package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Ingresso;

public class IngressoDAO {

	/*
	 * private int id;
	 * private String tituloExibicao;
	 * private Date dataInicio;
	 * private Date dataFim;
	 * private boolean exibicaoEspecial;
	 * private float precoSemana;
	 * private float precoFimDeSemana;
	 * private Autor autor;
	 * private int limiteIngresso;
	 */

	private Connection c;

	public IngressoDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public IngressoDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Ingresso i) throws SQLException {
		PreparedStatement ps;
		if (i.getId() == 0) {
			String sql = "INSERT INTO ingresso (tituloExibicao, dataInicio, dataFim, exibicaoEspecial, precoSemana, precoFimDeSemana, autor_id, limiteIngresso) VALUES (?,?,?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getTituloExibicao());
			ps.setDate(2, new java.sql.Date(i.getDataInicio().getTime()));
			ps.setDate(3, new java.sql.Date(i.getDataFim().getTime()));
			ps.setBoolean(4, i.isExibicaoEspecial());
			ps.setFloat(5, i.getPrecoSemana());
			ps.setFloat(6, i.getPrecoFimDeSemana());
			ps.setInt(7, i.getAutor().getId());
			ps.setInt(8, i.getLimiteIngresso());
		} else {
			String sql = "UPDATE ingresso SET tituloExibicao = ?, dataInicio = ?, dataFim = ?, exibicaoEspecial = ?, precoSemana = ?, precoFimDeSemana = ?, autor_id = ?, limiteIngresso = ? WHERE id = ?";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getTituloExibicao());
			ps.setDate(2, new java.sql.Date(i.getDataInicio().getTime()));
			ps.setDate(3, new java.sql.Date(i.getDataFim().getTime()));
			ps.setBoolean(4, i.isExibicaoEspecial());
			ps.setFloat(5, i.getPrecoSemana());
			ps.setFloat(6, i.getPrecoFimDeSemana());
			ps.setInt(7, i.getAutor().getId());
			ps.setInt(8, i.getLimiteIngresso());
			ps.setInt(9, i.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação do Ingresso, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				i.setId(idsGerados.getInt(1));
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação do Ingresso, ID não capturado.");
			}
		}
	}

	public boolean apagar(Ingresso i) throws SQLException {
		if (i.getId() != 0) {
			String sql = "DELETE ingresso WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, i.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização do Ingresso, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualização do Ingresso, ID não recebido no parâmetro.");
	}

	public Ingresso pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT tituloExibicao, dataInicio, dataFim, exibicaoEspecial, precoSemana, precoFimDeSemana, autor_id FROM, limiteIngresso obra WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Ingresso i = new Ingresso();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			i.setId(id);
			i.setTituloExibicao(rs.getString("titulo"));
			i.setDataInicio(new java.util.Date(rs.getDate("dataInicio").getTime()));
			i.setDataFim(new java.util.Date(rs.getDate("dataFim").getTime()));
			i.setExibicaoEspecial(rs.getBoolean("exibicaoEspecial"));
			i.setPrecoSemana(rs.getFloat("precoSemana"));
			i.setPrecoFimDeSemana(rs.getFloat("precoFimDeSemana"));
			i.setAutor(new AutorDAO().pesquisarPorID(rs.getInt("autor_id")));
			i.setLimiteIngresso(rs.getInt("limiteIngresso"));
		} else {
			i = null;
		}
		ps.close();
		return i;
	}

	public List<Ingresso> pesquisarPorData(Date d) throws SQLException {
		String sql = "SELECT id, tituloExibicao, dataInicio, dataFim, exibicaoEspecial, precoSemana, precoFimDeSemana, autor_id, limiteIngresso FROM ingresso WHERE ? BETWEEN dataInicio AND dataFim";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setDate(1, new java.sql.Date(d.getTime()));

		List<Ingresso> iList = new ArrayList<Ingresso>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			iList.add(new Ingresso(rs.getInt("id"), rs.getString("tituloExibicao"),
					new java.util.Date(rs.getDate("dataInicio").getTime()),
					new java.util.Date(rs.getDate("dataFim").getTime()), rs.getBoolean("exibicaoEspecial"),
					rs.getFloat("precoSemana"), rs.getFloat("precoFimDeSemana"),
					new AutorDAO().pesquisarPorID(rs.getInt("autor_id")), rs.getInt("limiteIngresso")));
		}

		ps.close();
		return iList;
	}

	public List<Ingresso> pesquisarExibicoesAtivas() throws SQLException {
		String sql = "SELECT id, tituloExibicao, dataInicio, dataFim, exibicaoEspecial, precoSemana, precoFimDeSemana, autor_id, limiteIngresso FROM ingresso WHERE SYSDATE() BETWEEN dataInicio AND dataFim";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Ingresso> iList = new ArrayList<Ingresso>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			iList.add(new Ingresso(rs.getInt("id"), rs.getString("tituloExibicao"),
					new java.util.Date(rs.getDate("dataInicio").getTime()),
					new java.util.Date(rs.getDate("dataFim").getTime()), rs.getBoolean("exibicaoEspecial"),
					rs.getFloat("precoSemana"), rs.getFloat("precoFimDeSemana"),
					new AutorDAO().pesquisarPorID(rs.getInt("autor_id")), rs.getInt("limiteIngresso")));
		}

		ps.close();
		return iList;
	}

	public List<Ingresso> carregarTodos() throws SQLException {
		String sql = "SELECT id, tituloExibicao, dataInicio, dataFim, exibicaoEspecial, precoSemana, precoFimDeSemana, autor_id, limiteIngresso FROM ingresso";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Ingresso> iList = new ArrayList<Ingresso>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			iList.add(new Ingresso(rs.getInt("id"), rs.getString("tituloExibicao"),
					new java.util.Date(rs.getDate("dataInicio").getTime()),
					new java.util.Date(rs.getDate("dataFim").getTime()), rs.getBoolean("exibicaoEspecial"),
					rs.getFloat("precoSemana"), rs.getFloat("precoFimDeSemana"),
					new AutorDAO().pesquisarPorID(rs.getInt("autor_id")), rs.getInt("limiteIngresso")));
		}

		ps.close();
		return iList;
	}

}