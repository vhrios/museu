package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Autor;

public interface IAutorAtividade {
	
	/*
	 * private Atividade atividade;
	 * private Autor autor;
	 */

	public boolean manter(List<String> atividades, Autor autor) throws SQLException;

	public boolean apagar(Autor autor) throws SQLException;

	public List<String> pesquisarPorAutor(int i) throws SQLException;

}
