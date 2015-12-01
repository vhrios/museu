package persistence;

import java.sql.SQLException;
import java.util.List;

import util.Tupla;

public interface IGrafico {

	public List<Tupla<String, Integer>> pesquisarPorSexo() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorNivelAcademico() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorLocomocao() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorIdade() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorPais() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorExposicao() throws SQLException;

	public List<Tupla<String, Integer>> pesquisarPorAutor() throws SQLException;

}
