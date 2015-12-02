package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Exposicao;
import entity.Ingresso;

public interface IIngresso {
	
	public void insereIngresso(Ingresso i, int e) throws SQLException;
	public void insereExposicao(Exposicao e) throws SQLException;
	public int buscaIdExposicao() throws SQLException;
	public List<Exposicao> consultaNomeExposicao(String data) throws SQLException;
	
}
