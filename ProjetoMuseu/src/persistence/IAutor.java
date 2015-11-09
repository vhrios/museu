package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Autor;

public interface IAutor {

	/*
	 * private int id;
	 * private String nome;
	 * private String dataNasc;
	 * private String dataObito;
	 * private String iniAtividade;
	 * private String fimAtividade;
	 * private String descricao;
	 * private Pais pais;
	 */

	public boolean manter(Autor a) throws SQLException;

	public boolean apagar(Autor a) throws SQLException;

	public Autor pesquisarPorID(int id) throws SQLException;

	public Autor pesquisarPorNome(String nome) throws SQLException;

	public List<Autor> carregarTodos() throws SQLException;

}
