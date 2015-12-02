package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Exposicao;
import entity.Ingresso;
import persistence.IIngresso;
import persistence.IngressoImpl;

public class IngressoController {
	
	IIngresso iDao = new IngressoImpl();
	
	public void salvaExposicao(Exposicao expo) {
		try {
			iDao.insereExposicao(expo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvaIngresso(Ingresso i){
		try {
			int e = iDao.buscaIdExposicao();
			iDao.insereIngresso(i, e);
			JOptionPane.showMessageDialog(null,
					"Cadastrado com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Exposicao> nomeExpo(String data) {
		List<Exposicao> lista = new ArrayList<Exposicao>();
		try {
			lista = iDao.consultaNomeExposicao(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
