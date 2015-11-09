package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Obra;

public interface IObra {

	public boolean manter(Obra o) throws SQLException;

	public boolean apagar(Obra o ) throws SQLException;

	public Obra pesquisarPorID(int id) throws SQLException;

	public Obra pesquisarPorTitulo(String titulo) throws SQLException;

	public List<Obra> carregarTodos() throws SQLException;

}