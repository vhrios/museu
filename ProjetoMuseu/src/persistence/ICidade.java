package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Cidade;
import entity.Estado;

public interface ICidade {

	/*
	 * private int id;
	 * private String nome;
	 * private Estado estado;
	 */

	public boolean manter(Cidade c) throws SQLException;

	public boolean apagar(Cidade c) throws SQLException;

	public Cidade pesquisarPorID(int id) throws SQLException;

	public Cidade pesquisarPorNome(String nome) throws SQLException;

	public Cidade pesquisarPorEstado(Estado e) throws SQLException;

	public List<Cidade> carregarTodos() throws SQLException;

}
