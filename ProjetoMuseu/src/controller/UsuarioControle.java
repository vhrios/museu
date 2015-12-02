package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import boundary.TelaPrincipal;
import entity.Usuario;
import persistence.IUsuario;
import persistence.UsuarioDAO;

public class UsuarioControle {

	public void validaLogin(Usuario u) {
		IUsuario iu = new UsuarioDAO();
		Usuario usu;
		try {
			usu = iu.validaLogin(u);
			if (usu == null) {
				JOptionPane.showMessageDialog(null, "Usuario não encontrado, \n ou não existe!");
			} else {
				TelaPrincipal tp = new TelaPrincipal(usu);
				tp.main(null);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
