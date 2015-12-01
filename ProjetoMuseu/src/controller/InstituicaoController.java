package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Instituicao;
import persistence.IInstituicao;
import persistence.InstituicaoDAO;

public class InstituicaoController {

	public boolean salvarInstituicao(Instituicao i) {
		IInstituicao ii = new InstituicaoDAO();
		try {
			return ii.manter(i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao manter Autor");
			return false;
		}
	}

	public Instituicao pesquisarPorId(int id) {
		IInstituicao ii = new InstituicaoDAO();
		try {
			Instituicao i = ii.pesquisarPorID(id);
			if (i != null) {
				return i;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Instituicao");
			return null;
		}
	}

	public Instituicao pesquisarPorNome(String nome) {
		IInstituicao ii = new InstituicaoDAO();
		try {
			Instituicao i = ii.pesquisarPorNome(nome);
			if (i != null) {
				return i;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Instituicao");
			return null;
		}
	}

	public List<Instituicao> carregarTodos() {
		IInstituicao ii = new InstituicaoDAO();
		try {
			return ii.carregarTodos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Lista de Instituicoes");
			return null;
		}
	}

	public boolean verificarInstituicao(Instituicao i) {
		if (i.getNome().isEmpty() || i.getEndereco().isEmpty() || i.getNumero().isEmpty() 
				|| i.getCep().isEmpty() || i.getEstado().isEmpty() || i.getCidade().isEmpty() 
				|| i.getPais().isEmpty() || i.getContato().isEmpty() || i.getTelefone().isEmpty()
				|| i.getEmail().isEmpty() || i.getCargo().isEmpty())
			return false;
		else
			return true;
	}
}
