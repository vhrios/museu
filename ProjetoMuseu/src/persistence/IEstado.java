package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Estado;
import entity.Pais;

public interface IEstado {

	/*
	 * private int id;
	 * private String nome;
	 * private Pais pais;
	 */

	public boolean manter(Estado e) throws SQLException;

	public boolean apagar(Estado e) throws SQLException;

	public Estado pesquisarPorID(int id) throws SQLException;

	public List<Estado> pesquisarPorPais(Pais p) throws SQLException;

	public List<Estado> carregarTodos() throws SQLException;

}
