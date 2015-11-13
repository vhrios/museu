package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Atividade;
import entity.Autor;

public class AutorAtividadeDAO implements IAutorAtividade{

	private Connection c;

	public AutorAtividadeDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(List<String> atividades, Autor autor) throws SQLException {
		if (atividades.size() != 0) {
			String sql = "INSERT INTO autor_atividade (atividade_id, autor_id) VALUES (?,?)";
			PreparedStatement ps = c.prepareStatement(sql, Statement.SUCCESS_NO_INFO);
			ps.setInt(2, autor.getId());

			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean apagar(List<String> atividades, Autor autor) throws SQLException {
		if (autor.getId() != 0) {
			String sql = "DELETE autor_atividade WHERE autor_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, autor.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização do Autor, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualização do Autor, ID não recebido no parâmetro.");
	}

	@Override
	public List<Atividade> pesquisarPorAutor(int i) throws SQLException {
		String sql = "SELECT atividade_id FROM autor_atividade WHERE autor_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);

		List<Atividade> aList = new ArrayList<Atividade>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			
			aList.add(null);
		}
		ps.close();
		return aList;
	}

}
