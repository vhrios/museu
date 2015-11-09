package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Venda;

public interface IVenda {

	public boolean manter(Venda v) throws SQLException;

	public boolean apagar(Venda v) throws SQLException;

	public Venda pesquisarPorID(int id) throws SQLException;

	public List<Venda> carregarTodos() throws SQLException;

}