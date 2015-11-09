package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Atividade;

public interface IAtividade {

	/*
	 * private int id;
	 * private String nome;
	 */

	public boolean manter(Atividade a) throws SQLException;

	public boolean apagar(Atividade a) throws SQLException;

	public Atividade pesquisarPorID(int id) throws SQLException;

	public Atividade pesquisarPorNome(String nome) throws SQLException;

	public List<Atividade> carregarTodos() throws SQLException;

}
