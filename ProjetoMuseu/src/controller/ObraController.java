package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Obra;
import persistence.IObra;
import persistence.ObraDAO;

public class ObraController {

	public Obra pesquisarObra(int id) {
		IObra io = new ObraDAO();
		try {
			Obra o = io.pesquisarPorID(id);
			if (o != null) {
				return o;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar Obra");
			return null;
		}
	}

	public boolean salvarObra(Obra obra) {
		IObra io = new ObraDAO();
		try {
			return io.manter(obra);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao salvar Obra");
			return false;
		}
	}

	public List<Obra> carregarTodos() {
		IObra io = new ObraDAO();
		try {
			return io.carregarTodos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao salvar Obra");
			return null;
		}
	}

	public boolean verificarObra(Obra o) {
		if (o.getTitulo() == null && o.getApelido() == null)
			return false;
		else if (o.getCategoria() == null)
			return false;
		else if (o.getMovimento() == null)
			return false;
		else if (o.getInstituicao() == null)
			return false;
		else if (o.getAltura() == 0 || o.getLargura() == 0 || o.getProfundidade() == 0)
			return false;
		else
			return true;
	}
}
