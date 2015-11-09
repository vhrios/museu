package controller;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entity.NivelAcademico;
import entity.Visitante;
import persistence.IVisitante;
import persistence.VisitanteImpl;

public class VisitanteControl {
	
	Visitante v = new Visitante();
	
	@SuppressWarnings("unused")
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtNacionalidade;
	private JTextField txtNaturalidade;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtPassaporte;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnRg;
	private JRadioButton rdbtnCpf;
	private JRadioButton rdbtnPassaporte;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbNivelAcademico;
	
	public VisitanteControl(JTextField txtNome, JTextField txtDataNasc, JTextField txtNacionalidade, JTextField txtNaturalidade,
			JTextField txtRg, JTextField txtCpf, JTextField txtPassaporte, JRadioButton rdbtnMasculino, JRadioButton rdbtnFeminino,
			JRadioButton rdbtnRg, JRadioButton rdbtnCpf, JRadioButton rdbtnPassaporte, @SuppressWarnings("rawtypes") JComboBox cmbNivelAcademico) {

		this.txtNome = txtNome;
		this.txtDataNasc = txtDataNasc;
		this.txtNacionalidade = txtNacionalidade;
		this.txtNaturalidade = txtNaturalidade;
		this.txtRg = txtRg;
		this.txtCpf = txtCpf;
		this.txtPassaporte = txtPassaporte;
		this.rdbtnMasculino = rdbtnMasculino;
		this.rdbtnFeminino = rdbtnFeminino;
		this.rdbtnRg = rdbtnRg;
		this.rdbtnCpf = rdbtnCpf;
		this.rdbtnPassaporte = rdbtnPassaporte;
		this.cmbNivelAcademico = cmbNivelAcademico;
	
	}
	
	public VisitanteControl() {
	}

	public void insereVisitante(Visitante v) {
		System.out.println("Entrou no control insereVisitante");
		IVisitante iv = new VisitanteImpl();
		try {
			System.out.println(v.getDtNasc());
			iv.insereVisitante(v);
			JOptionPane.showMessageDialog(null, 
					"Cadastrado com Sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public Visitante consultaVisitantePeloNome(String nome) {
		IVisitante iv = new VisitanteImpl();
		Visitante v = new Visitante();
		try {
			v = iv.consultaVisitante(nome);
			if (v == null) {
				JOptionPane.showMessageDialog(null, "Nome não encontrado!");
			} else {	
				txtDataNasc.setText(v.getDtNasc());
				if (v.getSexo() == "m") {
					rdbtnMasculino.setSelected(true);
				}else{
					if (v.getSexo() == "f") {
						rdbtnFeminino.setSelected(true);
					}
				}
				txtNacionalidade.setText(v.getNacionalidade());
				txtNaturalidade.setText(v.getNaturalidade());
				if (v.getNivelAcademico().equals("Superior")) {
					cmbNivelAcademico.setSelectedItem(NivelAcademico.Superior);
				}
				if (v.getNivelAcademico().equals("Médio")) {
					cmbNivelAcademico.setSelectedItem(NivelAcademico.Médio);
				}
				if (v.getNivelAcademico().equals("Fundamental")) {
					cmbNivelAcademico.setSelectedItem(NivelAcademico.Fundamental);
				}
				if (v.getNivelAcademico().equals("Outro")) {
					cmbNivelAcademico.setSelectedItem(NivelAcademico.Outro);
				}
				if (v.getRg() != null) {
					rdbtnRg.setSelected(true);
					txtRg.setText(v.getRg());
				} else{
					if (v.getCpf() != null) {
						rdbtnCpf.setSelected(true);
						txtCpf.setText(v.getCpf());
						txtRg.setEditable(false);
						txtCpf.setEditable(true);
					}else{
						if (v.getPassaporte() != null) {
							rdbtnPassaporte.setSelected(true);
							txtPassaporte.setText(v.getPassaporte());
							txtPassaporte.setEditable(true);
							txtCpf.setEditable(false);
							txtRg.setEditable(false);
						}
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public void chamaValidaRG(String rg) {
		Visitante v = new Visitante();
		v.validaRG(rg);
	}
	
	public void chamaValidaCPF(String cpf){
		Visitante v = new Visitante();
		v.validaCPF(cpf);
	}
}
