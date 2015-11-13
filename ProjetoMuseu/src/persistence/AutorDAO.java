package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Autor;

public class AutorDAO implements IAutor{

	/*
	 * private int id;
	 * private String nome; 
	 * private int diaN;
	 * private int mesN;
	 * private int anoN;
	 * private int diaM;
	 * private int mesM;
	 * private int anoM;
	 * private int diaIniAtv;
	 * private int mesIniAtv;
	 * private int anoIniAtv;
	 * private int diaFimAtv;
	 * private int mesFimAtv;
	 * private int anoFimAtv;
	 * private String descricao; 
	 * private String pais;
	 * private List<String> atividades;
	 */

	private Connection c;

	public AutorDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public boolean manter(Autor a) throws SQLException {
		PreparedStatement ps;
		if (a.getId() == 0) {
			String sql = "INSERT INTO autor (nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id) VALUES (?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getDiaN());
			ps.setInt(3, a.getMesN());
			ps.setInt(4, a.getAnoN());
			ps.setInt(5, a.getDiaM());
			ps.setInt(6, a.getMesM());
			ps.setInt(7, a.getAnoM());
			ps.setInt(8, a.getDiaIniAtv());
			ps.setInt(9, a.getMesIniAtv());
			ps.setInt(10, a.getAnoIniAtv());
			ps.setInt(11, a.getDiaFimAtv());
			ps.setInt(12, a.getMesFimAtv());
			ps.setInt(13, a.getAnoFimAtv());
			ps.setString(14, a.getDescricao());
			ps.setString(15, a.getPais());
		} else {
			String sql = "UPDATE autor SET nome = ?, dataNasc = ?, dataObito = ?, iniAtividade = ?, fimAtividade = ?, descricao = ?, pais_id = ? WHERE id = ?";
			ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getDiaN());
			ps.setInt(3, a.getMesN());
			ps.setInt(4, a.getAnoN());
			ps.setInt(5, a.getDiaM());
			ps.setInt(6, a.getMesM());
			ps.setInt(7, a.getAnoM());
			ps.setInt(8, a.getDiaIniAtv());
			ps.setInt(9, a.getMesIniAtv());
			ps.setInt(10, a.getAnoIniAtv());
			ps.setInt(11, a.getDiaFimAtv());
			ps.setInt(12, a.getMesFimAtv());
			ps.setInt(13, a.getAnoFimAtv());
			ps.setString(14, a.getDescricao());
			ps.setString(15, a.getPais());
			ps.setInt(16, a.getId());
		}
		
		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação do Autor, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				a.setId(idsGerados.getInt(1));
				new AutorAtividadeDAO().manter(a.getAtividades(), a);
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação do Autor, ID não capturado.");
			}
		}
	}

	@Override
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

	@Override
	public Autor pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Autor a = new Autor();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			
			a.setDiaN(rs.getInt("diaN"));
			a.setMesN(rs.getInt("mesN"));
			a.setAnoN(rs.getInt("anoN"));
			a.setDiaM(rs.getInt("diaM"));
			a.setMesM(rs.getInt("mesM"));
			a.setAnoM(rs.getInt("anoM"));
			a.setDiaIniAtv(rs.getInt("diaIniAtv"));
			a.setMesIniAtv(rs.getInt("mesIniAtv"));
			a.setAnoIniAtv(rs.getInt("anoIniAtv"));
			a.setDiaFimAtv(rs.getInt("diaFimAtv"));
			a.setMesFimAtv(rs.getInt("mesFimAtv"));
			a.setAnoFimAtv(rs.getInt("anoFimAtv"));
			
			a.setDescricao(rs.getString("descricao"));
			a.setPais(rs.getString("Pais"));
			
			a.setAtividades();
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	@Override
	public Autor pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT id, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor WHERE nome = '?'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);

		Autor a = new Autor();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			
			a.setDiaN(rs.getInt("diaN"));
			a.setMesN(rs.getInt("mesN"));
			a.setAnoN(rs.getInt("anoN"));
			a.setDiaM(rs.getInt("diaM"));
			a.setMesM(rs.getInt("mesM"));
			a.setAnoM(rs.getInt("anoM"));
			a.setDiaIniAtv(rs.getInt("diaIniAtv"));
			a.setMesIniAtv(rs.getInt("mesIniAtv"));
			a.setAnoIniAtv(rs.getInt("anoIniAtv"));
			a.setDiaFimAtv(rs.getInt("diaFimAtv"));
			a.setMesFimAtv(rs.getInt("mesFimAtv"));
			a.setAnoFimAtv(rs.getInt("anoFimAtv"));
			
			a.setDescricao(rs.getString("descricao"));
			a.setPais(rs.getString("Pais"));
			a.setAtividades();
		} else {
			a = null;
		}
		ps.close();
		return a;
	}

	@Override
	public List<Autor> carregarTodos() throws SQLException {
		String sql = "SELECT id, nome, dataNasc, dataObito, iniAtividade, fimAtividade, descricao, pais_id FROM autor";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Autor> aList = new ArrayList<Autor>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			
			a.setDiaN(rs.getInt("diaN"));
			a.setMesN(rs.getInt("mesN"));
			a.setAnoN(rs.getInt("anoN"));
			a.setDiaM(rs.getInt("diaM"));
			a.setMesM(rs.getInt("mesM"));
			a.setAnoM(rs.getInt("anoM"));
			a.setDiaIniAtv(rs.getInt("diaIniAtv"));
			a.setMesIniAtv(rs.getInt("mesIniAtv"));
			a.setAnoIniAtv(rs.getInt("anoIniAtv"));
			a.setDiaFimAtv(rs.getInt("diaFimAtv"));
			a.setMesFimAtv(rs.getInt("mesFimAtv"));
			a.setAnoFimAtv(rs.getInt("anoFimAtv"));
			
			a.setDescricao(rs.getString("descricao"));
			a.setPais(rs.getString("Pais"));
			a.setAtividades();
			aList.add(a);
		}
		ps.close();
		return aList;
	}

}
