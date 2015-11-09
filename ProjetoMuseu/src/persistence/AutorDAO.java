package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Autor;

public class AutorDAO {

	/*
	 * private int id;
	 * private String nome; 
	 * private String dataNasc; 
	 * private String dataObito; 
	 * private String iniAtividade; 
	 * private String fimAtividade; 
	 * private String descricao; 
	 * private Pais pais;
	 * 
	 * private List<Atividades> atividades;
	 */

	private Connection c;

	public AutorDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public AutorDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Autor a) throws SQLException {
		PreparedStatement ps;
		if (a.getId() == 0) {
			String sql = "INSERT INTO autor (nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id) VALUES (?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getDataNasc());
			ps.setString(3, a.getDataObito());
			ps.setString(4, a.getIniAtividade());
			ps.setString(5, a.getFimAtividade());
			ps.setString(6, a.getDescricao());
			ps.setInt(7, a.getPais().getId());
		} else {
			String sql = "UPDATE autor SET nome = ?, dataNasc = ?, dataObito = ?, iniAtividade = ?, fimAtividade = ?, descricao = ?, pais_id = ? WHERE id = ?";
			ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getDataNasc());
			ps.setString(3, a.getDataObito());
			ps.setString(4, a.getIniAtividade());
			ps.setString(5, a.getFimAtividade());
			ps.setString(6, a.getDescricao());
			ps.setInt(7, a.getPais().getId());
			ps.setInt(8, a.getId());
		}
		
		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação do Autor, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				a.setId(idsGerados.getInt(1));
				new AutorAtividadeDAO(this.c).manter(a.getAtividades(), a);
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação do Autor, ID não capturado.");
			}
		}
	}

	public boolean apagar(Autor a) throws SQLException {
		if (a.getId() != 0) {
			String sql = "DELETE autor WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, a.getId());
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

	public Autor pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Autor a = new Autor();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(id);
			a.setNome(rs.getString("nome"));
			a.setDataNasc(rs.getString("dataNasc"));
			a.setDataObito(rs.getString("dataObito"));
			a.setIniAtividade(rs.getString("iniAtividade"));
			a.setFimAtividade(rs.getString("fimAtividade"));
			a.setDescricao(rs.getString("descricao"));
			a.setPais(new PaisDAO().pesquisarPorID(rs.getInt("pais_id")));
			a.setAtividades(new AtividadeDAO().pesquisarPorAutor(a));
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	public Autor pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT id, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor WHERE nome = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);

		Autor a = new Autor();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(nome);
			a.setDataNasc(rs.getString("dataNasc"));
			a.setDataObito(rs.getString("dataObito"));
			a.setIniAtividade(rs.getString("iniAtividade"));
			a.setFimAtividade(rs.getString("fimAtividade"));
			a.setDescricao(rs.getString("descricao"));
			a.setPais(new PaisDAO().pesquisarPorID(rs.getInt("pais_id")));
			a.setAtividades(new AutorAtividadeDAO().pesquisarPorAutor(rs.getInt("id")));
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	public List<Autor> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Autor> aList = new ArrayList<Autor>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			aList.add(new Autor(rs.getInt("id"), rs.getString("nome"), rs.getString("dataNasc"),
					rs.getString("dataObito"), rs.getString("iniAtividade"), rs.getString("fimAtividade"),
					rs.getString("descricao"), new PaisDAO().pesquisarPorID(rs.getInt("pais_id")), new AutorAtividadeDAO().pesquisarPorAutor(rs.getInt("id"))));
		}
		ps.close();
		return aList;
	}

}
