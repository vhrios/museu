package persistence;

import java.sql.SQLException;

import entity.Visitante;

public interface IVisitante {
	
	public void insereVisitante(Visitante v) throws SQLException;
	public Visitante consultaVisitante(String nome) throws SQLException;
	
}
