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
import entity.Obra;

public class EmprestimoDAO implements IEmprestimo{

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

	@Override
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
			throw new SQLException("Falha na cria��o do Emprestimo, sem linhas afetadas.");
		}

		try (ResultSet idsGerados = ps.getGeneratedKeys()) {
			if (idsGerados.next() || e.getId()!=0) {
				int id = e.getId()==0 ? idsGerados.getInt(1) : e.getId();
				e.setId(id);
				new EmprestimoObraDAO().manter(e.getObras(), e);
				ps.close();
				return true;
			} else {
				throw new SQLException("Falha na cria��o do Emprestimo, ID n�o capturado.");
			}
		}
	}

	@Override
	public boolean apagar(Emprestimo e) throws SQLException {
		if (e.getId() != 0) {
			String sql = "DELETE emprestimo WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, e.getId());
			int linhasAfetadas = ps.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha na atualiza��o do Emprestimo, sem linhas afetadas.");
			} else {
				ps.close();
				return true;
			}
		}
		throw new SQLException("Falha na atualiza��o do Emprestimo, ID n�o recebido no par�metro.");
	}

	@Override
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

	@Override
	public List<Emprestimo> pesquisarPorInstituicao(Instituicao i) throws SQLException {
		String sql = "SELECT id, status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao FROM emprestimo WHERE instituicao_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i.getId());

		List<Emprestimo> eList = new ArrayList<Emprestimo>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Emprestimo e = new Emprestimo();
			e.setId(rs.getInt("id"));
			e.setStatus(rs.getString("status"));
			e.setTituloExibicao(rs.getString("tituloExibicao"));
			e.setDataEmprestimo(rs.getDate("dataEmprestimo"));
			e.setDataDevolucao(rs.getDate("dataDevolucao"));
			e.setObservacao(rs.getString("observacao"));
			
			List<Obra> obras = new EmprestimoObraDAO().pesquisarPorEmprestimo(rs.getInt("id"));
			e.setObras(obras);
			
			e.setInstituicao(i);
			eList.add(e);
		}
		ps.close();
		return eList;
	}

	@Override
	public List<Emprestimo> carregarTodos() throws SQLException {
		String sql = "SELECT id, status, tituloExibicao, dataEmprestimo, dataDevolucao, observacao, instituicao_id FROM emprestimo";
		PreparedStatement ps = c.prepareStatement(sql);

		List<Emprestimo> eList = new ArrayList<Emprestimo>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Emprestimo e = new Emprestimo();
			e.setId(rs.getInt("id"));
			e.setStatus(rs.getString("status"));
			e.setTituloExibicao(rs.getString("tituloExibicao"));
			e.setDataEmprestimo(rs.getDate("dataEmprestimo"));
			e.setDataDevolucao(rs.getDate("dataDevolucao"));
			e.setObservacao(rs.getString("observacao"));
			
			List<Obra> obras = new EmprestimoObraDAO().pesquisarPorEmprestimo(rs.getInt("id"));
			e.setObras(obras);
			
			Instituicao i = new InstituicaoDAO().pesquisarPorID(rs.getInt("id"));
			e.setInstituicao(i);
			eList.add(e);
			
			eList.add(e);
		}
		ps.close();
		return eList;
	}

}
