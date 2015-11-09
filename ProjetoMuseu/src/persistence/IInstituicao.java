package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Instituicao;

public interface IInstituicao {

	/*
	 * 	private int id;
	 * private String nome;
	 * private String endereco;
	 * private String numero;
	 * private String cep;
	 * private String contato;
	 * private String cargo;
	 * private String telefone;
	 * private String email;
	 * private Pais pais;
	 * private Estado estado;
	 * private Cidade cidade;
	 */

	public boolean manter(Instituicao i) throws SQLException;

	public boolean apagar(Instituicao i) throws SQLException;

	public Instituicao pesquisarPorID(int id) throws SQLException;

	public Instituicao pesquisarPorNome(String nome) throws SQLException;

	public List<Instituicao> carregarTodos() throws SQLException;

}