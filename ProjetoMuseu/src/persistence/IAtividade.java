package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Atividade;

public interface IAtividade {

	/*
	 * private int id;
	 * private String nome;
	 */

	public int pesquisarPorNome(String nome) throws SQLException;

	//public List<Atividade> carregarTodos() throws SQLException;

}
