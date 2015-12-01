package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Autor;
import persistence.AutorDAO;
import persistence.IAutor;

public class AutorController {

	public Autor pesquisarAutor(String nome) {
		IAutor ia = new AutorDAO();
		try {
			Autor a = ia.pesquisarPorNome(nome);
			if (a != null) {
				return a;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Autor");
			return null;
		}
	}

	public List<Autor> carregarTodos() {
		IAutor ia = new AutorDAO();
		try {
			return ia.carregarTodos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Lista de Autores");
			return null;
		}
	}

	public boolean salvarAutor(Autor a) {
		IAutor ia = new AutorDAO();
		try {
			return ia.manter(a);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao manter Autor");
			return false;
		}
	}

	public boolean verificarAutor(Autor a) {
		if (a.getNome() == null)
			return false;
		else if (a.getAtividades() == null)
			return false;
		else if (a.getDescricao() == null)
			return false;
		else
			return true;
	}
}