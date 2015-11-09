package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Pais;

public interface IPais {

	public boolean manter(Pais p) throws SQLException;

	public boolean apagar(Pais p) throws SQLException;

	public Pais pesquisarPorID(int id) throws SQLException;

	public List<Pais> carregarTodos() throws SQLException;

}