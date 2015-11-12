package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.Visitante;
import persistence.IVisitante;
import persistence.VisitanteDAO;

public class VisitanteCotroller {
	
	public void salvaVisitante(Visitante v){
		IVisitante iv = new VisitanteDAO();
		try {
			iv.insereVisitante(v);
			JOptionPane.showMessageDialog(null,
					"Cadastrado com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
