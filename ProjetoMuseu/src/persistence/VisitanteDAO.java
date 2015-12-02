package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Visitante;

public class VisitanteDAO implements IVisitante{

	private Connection c;

	public VisitanteDAO() {
		IConexaoMySQL gc = new ConexaoMySQL();
		c = gc.connect();
	}

	
	@Override
	public void insereVisitante(Visitante v) throws SQLException {
			String sql = "INSERT INTO visitante (sexo, idade, pais, escolaridade, locomocao) VALUES (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setBoolean(1, v.isSexo());
			ps.setInt(2, v.getIdade());
			ps.setString(3, v.getPais());
			ps.setString(4, v.getEscolaridade());
			ps.setString(5, v.getLocomocao());
			ps.executeUpdate();
			ps.close();
	}

	@Override
	public Visitante consultaVisitante(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}