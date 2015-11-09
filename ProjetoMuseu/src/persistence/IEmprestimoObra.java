package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Emprestimo;
import entity.Obra;

public interface IEmprestimoObra {

	/*
	 * private Emprestimo emprestimo;
	 * private Obra obra;
	 */

	public boolean manter(List<Obra> obras, Emprestimo emprestimo) throws SQLException;

	public boolean apagar(List<Obra> obras, Emprestimo emprestimo) throws SQLException;

	public List<Obra> pesquisarPorEmprestimo(int e) throws SQLException;
}
