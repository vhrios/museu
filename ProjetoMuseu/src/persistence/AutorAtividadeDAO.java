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

public class AutorAtividadeDAO implements IAutorAtividade {

	/*
	 * private Atividade atividade; private Autor autor;
	 */

	private Connection c;

	public AutorAtividadeDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public AutorAtividadeDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(List<Atividade> atividades, Autor autor) throws SQLException {

		String sql = "DELETE autor_atividade WHERE autor_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, autor.getId());
		ps.executeUpdate();

		if (atividades.size() != 0) {
			sql = "INSERT INTO autor_atividade (atividade_id, autor_id) VALUES (?,?)";
			ps = c.prepareStatement(sql, Statement.SUCCESS_NO_INFO);

			int i = 0;
			for (Atividade atividade : atividades) {
				ps.setInt(1, atividade.getId());
				ps.setInt(2, autor.getId());
				ps.addBatch();

				i++;

				if (i % 1000 == 0 || i == atividades.size()) {
					ps.executeBatch();
				}
			}
			return true;
		}
		return false;
	}

	public boolean apagar(List<Atividade> atividades, Autor autor) throws SQLException {
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

	public List<Atividade> pesquisarPorAutor(int i) throws SQLException {
		String sql = "SELECT atividade_id FROM autor_atividade WHERE autor_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);

		List<Atividade> aList = new ArrayList<Atividade>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(new AtividadeDAO(this.c).pesquisarPorID(rs.getInt("id")));
		}
		ps.close();
		return aList;
	}

}
