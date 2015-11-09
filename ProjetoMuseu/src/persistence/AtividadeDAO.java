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

public class AtividadeDAO {

	/*
	 * private int id; private String nome;
	 */

	private Connection c;

	public AtividadeDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public AtividadeDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Atividade a) throws SQLException {
		PreparedStatement ps;
		if (a.getId() == 0) {
			String sql = "INSERT INTO atividade (nome) VALUES (?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNome());
		} else {
			String sql = "UPDATE atividade SET nome = ? WHERE id = ?";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação da Atividade, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				a.setId(idsGerados.getInt(1));
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação da Atividade, ID não capturado.");
			}
		}
	}

	public boolean apagar(Atividade a) throws SQLException {
		if (a.getId() != 0) {
			String sql = "DELETE atividade WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, a.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização da Atividade, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualização da Atividade, ID não recebido no parâmetro.");
	}

	public Atividade pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome FROM atividade WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Atividade a = new Atividade();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(id);
			a.setNome(rs.getString("nome"));
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	public Atividade pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT id FROM atividade WHERE nome = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);

		Atividade a = new Atividade();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(nome);
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	public List<Atividade> pesquisarPorAutor(Autor a) throws SQLException {
		String sql = "SELECT id, nome FROM atividade AS a INNER JOIN autor_atividade AS aa ON a.id = aa.atividade_id WHERE aa.autor_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getId());

		List<Atividade> aList = new ArrayList<Atividade>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(new Atividade(rs.getInt("id"), rs.getString("nome")));
		}

		ps.close();
		return aList;
	}

	public List<Atividade> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome FROM atividade";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Atividade> aList = new ArrayList<Atividade>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(new Atividade(rs.getInt("id"), rs.getString("nome")));
		}

		ps.close();
		return aList;
	}

}
