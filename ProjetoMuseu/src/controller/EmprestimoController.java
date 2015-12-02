package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.Emprestimo;
import persistence.EmprestimoDAO;
import persistence.IEmprestimo;

public class EmprestimoController {

	public Emprestimo pesquisarPorId(int id) {
		IEmprestimo ie = new EmprestimoDAO();
		try {
			Emprestimo e = ie.pesquisarPorID(id);
			if (e != null) {
				return e;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Empréstimo");
			return null;
		}
	}

	public boolean salvarEmprestimo(Emprestimo e) {
		IEmprestimo ie = new EmprestimoDAO();
		try {
			return ie.manter(e);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao manter Empréstimo");
			return false;
		}
	}

	public boolean verificarEmprestimo(Emprestimo e) {
		if (e.getStatus().isEmpty() 
				|| e.getTituloExibicao().isEmpty()
				|| e.getDataEmprestimo().after(e.getDataDevolucao())
				|| e.getInstituicao().getId() == 0
				|| e.getObras().isEmpty()) {
			return false;
		} else
			return true;
	}
}
