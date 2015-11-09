package persistence;

import java.sql.SQLException;

import entity.Usuario;

public interface IUsuario {
	
	public Usuario validaLogin(Usuario u) throws SQLException;

}
