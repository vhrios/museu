package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Tupla;

public class GraficoDAO implements IGrafico {

	private Connection c;

	public GraficoDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorSexo() throws SQLException {
		PreparedStatement ps;
	    String sql = "SELECT sexo, COUNT(*) AS 'count'"
	    		   +" FROM visitante"
	    		   +" GROUP BY sexo";
	    ps = c.prepareStatement(sql);
	    
	    List<Tupla<String, Integer>> t = new ArrayList<Tupla<String, Integer>>();
		
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
			Tupla<String, Integer> e = new Tupla<String, Integer>(rs.getString("sexo"), rs.getInt("count"));
			t.add(e);
		}
	    ps.close();
		return t;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorNivelAcademico() throws SQLException {
		PreparedStatement ps;
	    String sql = "SELECT escolaridade, COUNT(*) AS 'count'"
	    		   +" FROM visitante"
	    		   +" GROUP BY escolaridade";
	    ps = c.prepareStatement(sql);
	    
	    List<Tupla<String, Integer>> t = new ArrayList<Tupla<String, Integer>>();
		
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
			Tupla<String, Integer> e = new Tupla<String, Integer>(rs.getString("escolaridade"), rs.getInt("count"));
			t.add(e);
		}
	    ps.close();
		return t;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorLocomocao() throws SQLException {
		PreparedStatement ps;
	    String sql = "SELECT locomocao, COUNT(*) AS 'count'"
	    		   +" FROM visitante"
	    		   +" GROUP BY locomocao";
	    ps = c.prepareStatement(sql);
	    
	    List<Tupla<String, Integer>> t = new ArrayList<Tupla<String, Integer>>();
		
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
			Tupla<String, Integer> e = new Tupla<String, Integer>(rs.getString("locomocao"), rs.getInt("count"));
			t.add(e);
		}
	    ps.close();
		return t;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorIdade() throws SQLException {
		CallableStatement cs = null;
		cs = c.prepareCall("{call estatistica_idade}");
		
		List<Tupla<String, Integer>> t = new ArrayList<Tupla<String, Integer>>();
		
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			Tupla<String, Integer> e = new Tupla<String, Integer>(rs.getInt("de")+" - "+rs.getInt("ate"), rs.getInt("count"));
			t.add(e);
		}
	    cs.close();
		return t;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorPais(/*int qtd*/) throws SQLException {
		PreparedStatement ps;
	    String sql = "SELECT CASE WHEN v2.pais IS NOT NULL THEN v1.pais"
	    		   +" ELSE 'Outros' END AS pais, count(*) AS 'count'"
	    		   +" FROM visitante v1 LEFT JOIN"
	    		   +" (SELECT pais, COUNT(*) AS 'pcount' FROM visitante"
	    		   +" GROUP BY pais ORDER BY 'pcount' DESC LIMIT 5) v2 ON v1.pais = v2.pais"
	    		   //+" GROUP BY pais ORDER BY 'pcount' DESC LIMIT ?) v2 ON v1.pais = v2.pais"
	    		   +" GROUP BY pais ORDER BY 'count' DESC";
	    ps = c.prepareStatement(sql);
	    //ps.setString(1, qtd);
	    
	    List<Tupla<String, Integer>> t = new ArrayList<Tupla<String, Integer>>();
		
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
			Tupla<String, Integer> e = new Tupla<String, Integer>(rs.getString("pais"), rs.getInt("count"));
			t.add(e);
		}
	    ps.close();
		return t;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorExposicao() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tupla<String, Integer>> pesquisarPorAutor() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
