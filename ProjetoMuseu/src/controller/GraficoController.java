package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.GraficoDAO;
import persistence.IGrafico;
import util.Tupla;

public class GraficoController {

	public List<Tupla<String, Integer>> gerarIdade() {
		IGrafico ig = new GraficoDAO();
		try {
			List<Tupla<String, Integer>> l = ig.pesquisarPorIdade();
			if (l != null) {
				return l;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar dados idade");
			return null;
		}
	}

	public List<Tupla<String, Integer>> gerarSexo() {
		IGrafico ig = new GraficoDAO();
		try {
			List<Tupla<String, Integer>> l = ig.pesquisarPorSexo();
			if (l != null) {
				return l;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar dados sexo");
			return null;
		}
		/* lista.add(new Tupla<String, Integer>("Masculino",35));
		 * lista.add(new Tupla<String, Integer>("Feminino",54));
		 */
	}

	public List<Tupla<String, Integer>> gerarNacionalidade() {
		IGrafico ig = new GraficoDAO();
		try {
			List<Tupla<String, Integer>> l = ig.pesquisarPorPais();
			if (l != null) {
				return l;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar dados nacionalidade");
			return null;
		}
	}

	public List<Tupla<String, Integer>> gerarNivelAcademico() {
		IGrafico ig = new GraficoDAO();
		try {
			List<Tupla<String, Integer>> l = ig.pesquisarPorNivelAcademico();
			if (l != null) {
				return l;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar dados nivel academico");
			return null;
		}
		/* lista.add(new Tupla<String, Integer>("Fundamental",25));
		 * lista.add(new Tupla<String, Integer>("Medio",35));
		 * lista.add(new Tupla<String, Integer>("Superior",30));
		 * lista.add(new Tupla<String, Integer>("Outros",10)); 
		 */
	}

	public List<Tupla<String, Integer>> gerarLocomocao() {
		IGrafico ig = new GraficoDAO();
		try {
			List<Tupla<String, Integer>> l = ig.pesquisarPorLocomocao();
			if (l != null) {
				return l;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no SQL ao buscar dados locomocao");
			return null;
		}
		/* lista.add(new Tupla<String, Integer>("A pé",11));
		 * lista.add(new Tupla<String, Integer>("Ônibus",23));
		 * lista.add(new Tupla<String, Integer>("Trem/Metrô",32));
		 * lista.add(new Tupla<String, Integer>("Veículo Própio",19));
		 * lista.add(new Tupla<String, Integer>("Outros",15));
		 */
	}
}
