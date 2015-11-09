package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Emprestimo;
import entity.Instituicao;

public class EmprestimoDAO {

	/*
	 * private int id; 
	 * private String status; 
	 * private String tituloExibicao;
	 * private Date dataEmprestimo; 
	 * private Date dataDevolucao; 
	 * private String observacao; 
	 * private Instituicao instituicao;
	 * 
	 * private List<Obra> obras;
	 */

	private Connection c;

	public EmprestimoDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	public EmprestimoDAO(Connection c) throws SQLException {
		this.c = c;
	}

	public boolean manter(Emprestimo e) throws SQLException {
		PreparedStatement ps;
		if (e.getId() == 0) {
			String sql = "INSERT INTO emprestimo (status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao, instituicao_id) VALUES (?,?,?,?,?,?)";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, e.getStatus());
			ps.setString(2, e.getTituloExibicao());
			ps.setDate(3, new java.sql.Date(e.getDataEmprestimo().getTime()));
			ps.setDate(4, new java.sql.Date(e.getDataDevolucao().getTime()));
			ps.setString(5, e.getObservacao());
			ps.setInt(6, e.getInstituicao().getId());
		} else {
			String sql = "UPDATE emprestimo SET status = ?, tituloExibicao = ?, dataEmprestimo = ?, dataDevolucao = ?, observacao = ?, instituicao_id = ? WHERE id = ?";
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, e.getStatus());
			ps.setString(2, e.getTituloExibicao());
			ps.setDate(3, new java.sql.Date(e.getDataEmprestimo().getTime()));
			ps.setDate(4, new java.sql.Date(e.getDataDevolucao().getTime()));
			ps.setString(5, e.getObservacao());
			ps.setInt(6, e.getInstituicao().getId());
			ps.setInt(7, e.getId());
		}

		int linhasAfetadas = ps.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new SQLException("Falha na criação do Emprestimo, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next()) {
				e.setId(idsGerados.getInt(1));
				new EmprestimoObraDAO(this.c).manter(e.getObras(), e);
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na criação do Emprestimo, ID não capturado.");
			}
		}
	}

	public boolean apagar(Emprestimo e) throws SQLException {
		if (e.getId() != 0) {
			String sql = "DELETE emprestimo WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, e.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualização do Emprestimo, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualização do Emprestimo, ID não recebido no parâmetro.");
	}

	public Emprestimo pesquisarPorID(int id) throws SQLException {
		String sql = "SELECT status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao, instituicao_id FROM emprestimo WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id);

		Emprestimo e = new Emprestimo();

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			e.setId(id);
			e.setStatus(rs.getString("status"));
			e.setTituloExibicao(rs.getString("tituloExibicao"));
			e.setDataEmprestimo(rs.getDate("dataEmprestimo"));
			e.setDataDevolucao(rs.getDate("dataDevolucao"));
			e.setObservacao(rs.getString("observacao"));
			e.setInstituicao(new InstituicaoDAO().pesquisarPorID(rs.getInt("instituicao_id")));
			e.setObras(new EmprestimoObraDAO().pesquisarPorEmprestimo(id));
		} else {
			e = null;
		}
		ps.close();
		return e;
	}

	public List<Emprestimo> pesquisarPorInstituicao(Instituicao i) throws SQLException {
		String sql = "SELECT id, status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao FROM emprestimo WHERE instituicao_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i.getId());

		List<Emprestimo> eList = new ArrayList<Emprestimo>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			eList.add(new Emprestimo(rs.getInt("id"), rs.getString("status"), rs.getString("tituloExibicao"),
					rs.getDate("dataEmprestimo"), rs.getDate("dataDevolucao"), rs.getString("observacao"), i,
					new EmprestimoObraDAO().pesquisarPorEmprestimo(rs.getInt("id"))));
		}
		ps.close();
		return eList;
	}

	public List<Emprestimo> carregarTodos() throws SQLException {
		String sql = "SELECT id, status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao, instituicao_id FROM emprestimo";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Emprestimo> eList = new ArrayList<Emprestimo>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			eList.add(new Emprestimo(rs.getInt("id"), rs.getString("status"), rs.getString("tituloExibicao"),
					rs.getDate("dataEmprestimo"), rs.getDate("dataDevolucao"), rs.getString("observacao"),
					new InstituicaoDAO().pesquisarPorID(rs.getInt("id")),
					new EmprestimoObraDAO().pesquisarPorEmprestimo(rs.getInt("id"))));
		}
		ps.close();
		return eList;
	}

}
