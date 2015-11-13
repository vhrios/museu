package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Visitante;

public interface IVisitante {
	
	public boolean manter(Visitante v) throws SQLException;

	public List<Visitante> carregarTodos() throws SQLException;
	
}
