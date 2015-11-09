package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Visitante;

public class VisitanteDAO {

	/*
	 * private int id;
	 * private boolean sexo;
	 * private String escolaridade;
	 * private String locomocao;
	 * private int idade;
	 * private Pais pais;
	 */

	private Connection c;

	public VisitanteDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public VisitanteDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Visitante v) throws SQLException {
		if (v.getId() == 0) {
			String sql = "INSERT INTO visitante (sexo, escolaridade, locomocao, idade, pais_id) VALUES (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, v.isSexo());
			ps.setString(2, v.getEscolaridade());
			ps.setString(3, v.getLocomocao());
			ps.setInt(4, v.getIdade());
			ps.setInt(5, v.getPais().getId());

			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na criação do Visitante, sem linhas afetadas.");
			}

			try (ResultSet idsGerados = ps.getGeneratedKeys()) {
				if (idsGerados.next()) {
					v.setId(idsGerados.getInt(1));
					ps.close();
					return true;
				} else {
					throw new SQLException("Falha na criação do Visitante, ID não capturado.");
				}
			}
		} else {
			String sql = "UPDATE visitante SET sexo = ?, escolaridade = ?, locomocao = ?, idade = ?, pais_id = ? WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, v.isSexo());
			ps.setString(2, v.getEscolaridade());
			ps.setString(3, v.getLocomocao());
			ps.setInt(4, v.getIdade());
			ps.setInt(5, v.getPais().getId());
			ps.setInt(6, v.getId());

			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização do Visitante, sem linhas afetadas.");
			}

			try (ResultSet idsGerados = ps.getGeneratedKeys()) {
				if (idsGerados.next()) {
					v.setId(idsGerados.getInt(1));
					ps.close();
					return true;
				} else {
					throw new SQLException("Falha na atualização do Visitante, ID não capturado.");
				}
			} catch (Exception e) {
				return false;
			}
		}
	}

	public boolean apagar(Visitante v) throws SQLException {
		return false;
	}

	public Visitante pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT id, sexo, escolaridade, locomocao, idade, pais_id FROM visitante WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Visitante v = new Visitante();

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			v.setId(id);
			v.setSexo(rs.getBoolean("nome"));
			v.setEscolaridade(rs.getString("escolaridade"));
			v.setLocomocao(rs.getString("locomocao"));
			v.setIdade(rs.getInt("idade"));
			v.setPais(new PaisDAO().pesquisarPorID(rs.getInt("pais_id")));
		} else {
			v = null;
		}
		ps.close();
		return v;
	}

	public List<Visitante> carregarTodos() throws SQLException {
		String sql = "SELECT id, sexo, escolaridade, locomocao, idade, pais_id FROM visitante";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Visitante> vList = new ArrayList<Visitante>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			vList.add(new Visitante(rs.getInt("id"), rs.getBoolean("sexo"), rs.getString("escolaridade"),
					rs.getString("locomocao"), rs.getInt("idade"), new PaisDAO().pesquisarPorID(rs.getInt("pais_id"))));
		}
		ps.close();
		return vList;
	}

}