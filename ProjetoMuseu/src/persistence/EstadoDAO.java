package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Estado;
import entity.Pais;

public class EstadoDAO {

	/*
	 * private int id;
	 * private String nome;
	 * private Pais pais;
	 */

	private Connection c;

	public EstadoDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public EstadoDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Estado e) throws SQLException {
		if (e.getId() == 0) {
			String sql = "INSERT INTO estado (nome, pais_id) VALUES (?, ?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setInt(2, e.getPais().getId());
			ps.execute();
			ps.close();
			return true;
		} else {
			String sql = "UPDATE estado SET nome = ?, pais_id = ? WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setInt(2, e.getPais().getId());
			ps.setInt(3, e.getId());
			ps.execute();
			ps.close();
			return true;
		}
	}

	public boolean apagar(Estado e) throws SQLException {
		if (e.getId() != 0) {
			String sql = "DELETE estado WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, e.getId());
			ps.execute();
			ps.close();
			return true;
		} else
			return false;
	}

	public Estado pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome, pais_id FROM estado WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Estado e = new Estado();

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			e.setId(id);
			e.setNome(rs.getString("nome"));
			e.setPais(new PaisDAO().pesquisarPorID(rs.getInt("pais_id")));
		} else {
			e = null;
		}
		ps.close();
		return e;
	}

	public List<Estado> pesquisarPorPais(Pais p) throws SQLException {
		String sql = "SELECT id, nome FROM estado";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Estado> eList = new ArrayList<Estado>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			eList.add(new Estado(rs.getInt("id"), rs.getString("nome"), p));
		}
		ps.close();
		return eList;
	}

	public List<Estado> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome, pais_id FROM estado";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Estado> eList = new ArrayList<Estado>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			eList.add(new Estado(rs.getInt("id"), rs.getString("nome"),
					new PaisDAO().pesquisarPorID(rs.getInt("pais_id"))));
		}
		ps.close();
		return eList;
	}

}
