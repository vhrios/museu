package persistence;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entity.Ingresso;

public interface IIngresso {

	/*
	 * private int id;
	 * private String tituloExibicao;
	 * private Date dataInicio;
	 * private Date dataFim;
	 * private boolean exibicaoEspecial;
	 * private float precoSemana;
	 * private float precoFimDeSemana;
	 * private Autor autor;
	 */

	public boolean manter(Ingresso i) throws SQLException;

	public boolean apagar(Ingresso i) throws SQLException;

	public Ingresso pesquisarPorID(int id) throws SQLException;

	public List<Ingresso> pesquisarPorData(Date d) throws SQLException;

	public List<Ingresso> pesquisarExibicoesAtivas() throws SQLException;

	public List<Ingresso> carregarTodos() throws SQLException;

}