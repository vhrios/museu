package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Autor;

public class AutorAtividadeDAO implements IAutorAtividade {

	private Connection c;

	public AutorAtividadeDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(List<String> atividades, Autor autor) throws SQLException {
		try{
			apagar(autor);
		}catch (SQLException e){
			
		}
		if (atividades.size() != 0) {
			String sql = "INSERT INTO museu.autor_atividade (atividade_id, autor_id) VALUES (?,?)";
			PreparedStatement ps = c.prepareStatement(sql, Statement.SUCCESS_NO_INFO);

			final int batchSize = 1000;
			int i = 0;
			
			for(String atividade : atividades){
				AtividadeDAO atv = new AtividadeDAO();
				int id = atv.pesquisarPorNome(atividade);
				ps.setInt(1, id);
				ps.setInt(2, autor.getId());
				ps.addBatch();
				
				if(++i % batchSize == 0) {
			        ps.executeBatch();
			    }
			}
			ps.executeBatch();
			ps.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean apagar(Autor autor) throws SQLException {
		if (autor.getId() != 0) {
			String sql = "DELETE FROM museu.autor_atividade WHERE autor_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, autor.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na remoção das atividades do Autor, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na remoção das atividades do Autor, ID não recebido no parâmetro.");
	}

	@Override
	public List<String> pesquisarPorAutor(int i) throws SQLException {
		String sql = "SELECT nome FROM museu.atividade AS atv LEFT JOIN museu.autor_atividade AS aa ON atv.id=aa.atividade_id WHERE aa.autor_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);

		List<String> aList = new ArrayList<String>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(rs.getString("nome"));
		}
		ps.close();
		return aList;
	}

}
