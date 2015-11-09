package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cidade;
import entity.Estado;

public class CidadeDAO {

	/*
	 * private int id;
	 * private String nome;
	 * private Estado estado;
	 */

	private Connection c;

	public CidadeDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public CidadeDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Cidade a) throws SQLException {
		if (a.getId() == 0) {
			String sql = "INSERT INTO cidade (nome, estado_id)" + " VALUES (?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getEstado().getId());
			ps.execute();
			ps.close();
			return true;
		} else {
			String sql = "UPDATE cidade SET nome = ?, estado_id = ?" + "WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getEstado().getId());
			ps.setInt(3, a.getId());
			ps.execute();
			ps.close();
			return true;
		}
	}

	public boolean apagar(Cidade a) throws SQLException {
		if (a.getId() != 0) {
			String sql = "DELETE cidade WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.execute();
			ps.close();
			return true;
		} else
			return false;
	}

	public Cidade pesquisarPorID(int idCidade) throws SQLException {
		String sql = "SELECT nome, estado_id FROM cidade WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, idCidade);

		Cidade a = new Cidade();

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			a.setId(idCidade);
			a.setNome(rs.getString("nome"));
			a.setEstado(new EstadoDAO().pesquisarPorID(rs.getInt("estado_id")));
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	public List<Cidade> pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT id, estado_id FROM cidade WHERE nome = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);

		List<Cidade> aList = new ArrayList<Cidade>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			aList.add(new Cidade(rs.getInt("id"), nome, new EstadoDAO().pesquisarPorID(rs.getInt("estado_id"))));
		}
		ps.close();
		return aList;
	}

	public List<Cidade> pesquisarPorEstado(Estado estado) throws SQLException {
		String sql = "SELECT id, nome, estado_id FROM cidade WHERE estado_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, estado.getId());

		List<Cidade> aList = new ArrayList<Cidade>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			aList.add(new Cidade(rs.getInt("id"), rs.getString("nome"), estado));
		}
		ps.close();
		return aList;
	}

	public List<Cidade> pesquisarPorEstado(int estado_id) throws SQLException {
		return pesquisarPorEstado(new EstadoDAO().pesquisarPorID(estado_id));
	}

}
