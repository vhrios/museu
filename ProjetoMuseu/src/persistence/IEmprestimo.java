package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Emprestimo;
import entity.Instituicao;

public interface IEmprestimo {

	/*
	 * 	private int id;
	 * private String status;
	 * private String tituloExibicao;
	 * private Date dataEmprestimo;
	 * private Date dataDevolucao;
	 * private String observacao;
	 * private Instituicao instituicao;
	 * 
	 * private List<Obra> obras;
	 */

	public boolean manter(Emprestimo e) throws SQLException;

	public boolean apagar(Emprestimo e) throws SQLException;

	public Emprestimo pesquisarPorID(int id) throws SQLException;

	public List<Emprestimo> pesquisarPorInstituicao(Instituicao i) throws SQLException;
	
	public List<Emprestimo> carregarTodos() throws SQLException;

}
