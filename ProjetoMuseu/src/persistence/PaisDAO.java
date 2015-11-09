package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pais;

public class PaisDAO {

	/*
	 * private int id;
	 * private String nome;
	 */

	private Connection c;

	public PaisDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public PaisDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Pais p) throws SQLException {
		return false;
	}

	public boolean apagar(Pais p) throws SQLException {
		return false;
	}

	public Pais pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome FROM pais WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Pais p = new Pais();

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			p.setId(id);
			p.setNome(rs.getString("nome"));
		} else {
			p = null;
		}
		ps.close();
		return p;
	}

	public List<Pais> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome FROM pais";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Pais> pList = new ArrayList<Pais>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pList.add(new Pais(rs.getInt("id"), rs.getString("nome")));
		}
		ps.close();
		return pList;
	}

}