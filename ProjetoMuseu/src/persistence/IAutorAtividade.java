package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Atividade;
import entity.Autor;

public interface IAutorAtividade {
	
	/*
	 * private Atividade atividade;
	 * private Autor autor;
	 */

	public boolean manter(List<Atividade> atividades, Autor autor) throws SQLException;

	public boolean apagar(List<Atividade> atividades, Autor autor) throws SQLException;

	public List<Atividade> pesquisarPorAutor(int i) throws SQLException;

}
