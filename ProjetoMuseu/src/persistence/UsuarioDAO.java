package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Usuario;

public class UsuarioDAO implements IUsuario{
	
	private Connection c;

	public UsuarioDAO() {
		IConexaoMySQL iC = new ConexaoMySQL();
		c = iC.connect();
	}
	
	@Override
	public Usuario validaLogin(Usuario u) throws SQLException {
		String sql = "select nome, gerente from usuario where login = ? and senha = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, u.getLogin());
		ps.setString(2, u.getSenha());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			u.setNome(rs.getString("nome"));
			u.setGerente(rs.getBoolean("gerente"));
		} else {
			u = null;
		}
		return u;
	}

}
