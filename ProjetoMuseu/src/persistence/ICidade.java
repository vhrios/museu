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

	public List<Cidade> pesquisarPorNome(String nome) throws SQLException;

	public List<Cidade> pesquisarPorEstado(Estado e) throws SQLException;

	public List<Cidade> pesquisarPorEstado(int idEstado) throws SQLException;

}
