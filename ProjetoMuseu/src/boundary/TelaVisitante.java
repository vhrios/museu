package boundary;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.VisitanteControl;
import entity.NivelAcademico;
import entity.Visitante;

public class TelaVisitante implements ActionListener{

	private JFrame frmRegistraVisitante;
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
	private JButton btnAlterar;
	private JButton btnNovaConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisitante window = new TelaVisitante();
					window.frmRegistraVisitante.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVisitante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	private void initialize() {
		frmRegistraVisitante = new JFrame();
		frmRegistraVisitante.setTitle("Registra Visitante");
		frmRegistraVisitante.setBounds(100, 100, 664, 410);
		frmRegistraVisitante.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmRegistraVisitante.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(30, 16, 46, 14);
		frmRegistraVisitante.getContentPane().add(lblNome);
		
		JLabel lblDataDeNasc = new JLabel("Data de Nasc.:");
		lblDataDeNasc.setBounds(30, 73, 102, 14);
		frmRegistraVisitante.getContentPane().add(lblDataDeNasc);
		
		JLabel lblGnero = new JLabel("G�nero: ");
		lblGnero.setBounds(340, 46, 58, 14);
		frmRegistraVisitante.getContentPane().add(lblGnero);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade: ");
		lblNacionalidade.setBounds(30, 117, 102, 14);
		frmRegistraVisitante.getContentPane().add(lblNacionalidade);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade :");
		lblNaturalidade.setBounds(339, 117, 95, 14);
		frmRegistraVisitante.getContentPane().add(lblNaturalidade);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento :");
		lblTipoDeDocumento.setBounds(30, 201, 120, 14);
		frmRegistraVisitante.getContentPane().add(lblTipoDeDocumento);
		
		JLabel lblNvelAcadmico = new JLabel("N\u00EDvel Acad\u00EAmico :");
		lblNvelAcadmico.setBounds(30, 161, 102, 14);
		frmRegistraVisitante.getContentPane().add(lblNvelAcadmico);
		
		txtNome = new JTextField();
		txtNome.setBounds(86, 13, 256, 20);
		frmRegistraVisitante.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtDataNasc = new JTextField();
		javax.swing.text.MaskFormatter data;
		try {
			data = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNasc = new javax.swing.JFormattedTextField(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataNasc.setBounds(125, 70, 113, 20);
		frmRegistraVisitante.getContentPane().add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(124, 114, 151, 20);
		frmRegistraVisitante.getContentPane().add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
		txtNaturalidade = new JTextField();
		txtNaturalidade.setBounds(427, 114, 151, 20);
		frmRegistraVisitante.getContentPane().add(txtNaturalidade);
		txtNaturalidade.setColumns(10);
		
		txtRg = new JTextField();
		javax.swing.text.MaskFormatter rg;
		try {
			rg = new javax.swing.text.MaskFormatter("##.###.###-#");
			txtRg = new javax.swing.JFormattedTextField(rg);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtRg.setBounds(86, 233, 173, 20);
		frmRegistraVisitante.getContentPane().add(txtRg);
		txtRg.setColumns(10);
		
		txtCpf = new JTextField();
		javax.swing.text.MaskFormatter cpf;
		try {
			cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(cpf);
			txtCpf.setEditable(false);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtCpf.setBounds(325, 234, 173, 20);
		frmRegistraVisitante.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtPassaporte = new JTextField();
		javax.swing.text.MaskFormatter passaporte;
		try {
			passaporte = new javax.swing.text.MaskFormatter("??######");
			txtPassaporte = new javax.swing.JFormattedTextField(passaporte);
			txtPassaporte.setEditable(false);
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtPassaporte.setEditable(false);
		txtPassaporte.setBounds(125, 269, 166, 20);
		frmRegistraVisitante.getContentPane().add(txtPassaporte);
		txtPassaporte.setColumns(10);
		
		cmbNivelAcademico = new JComboBox(NivelAcademico.values());
		cmbNivelAcademico.setBounds(140, 158, 173, 20);
		frmRegistraVisitante.getContentPane().add(cmbNivelAcademico);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setBounds(340, 67, 103, 23);
		frmRegistraVisitante.getContentPane().add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(445, 67, 88, 23);
		frmRegistraVisitante.getContentPane().add(rdbtnFeminino);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMasculino);
		bg.add(rdbtnFeminino);
		
		rdbtnRg = new JRadioButton("RG");
		rdbtnRg.setSelected(true);
		rdbtnRg.setBounds(30, 232, 46, 23);
		frmRegistraVisitante.getContentPane().add(rdbtnRg);
		
		rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.setBounds(269, 233, 55, 23);
		frmRegistraVisitante.getContentPane().add(rdbtnCpf);
		
		rdbtnPassaporte = new JRadioButton("Passaporte");
		rdbtnPassaporte.setBounds(30, 268, 95, 23);
		frmRegistraVisitante.getContentPane().add(rdbtnPassaporte);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rdbtnRg);
		bg1.add(rdbtnCpf);
		bg1.add(rdbtnPassaporte);
		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.setIcon(new ImageIcon(TelaVisitante.class.getResource("/icon/img-pesquisa.png")));
		btnPesquisa.setBounds(352, 12, 46, 23);
		frmRegistraVisitante.getContentPane().add(btnPesquisa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaVisitante.class.getResource("/icon/img-voltar.png")));
		btnVoltar.setBounds(10, 325, 108, 38);
		frmRegistraVisitante.getContentPane().add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaVisitante.class.getResource("/icon/img-salvar.png")));
		btnSalvar.setBounds(536, 325, 102, 38);
		frmRegistraVisitante.getContentPane().add(btnSalvar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(413, 325, 113, 38);
		frmRegistraVisitante.getContentPane().add(btnAlterar);
		
		btnNovaConsulta = new JButton("Nova Consulta");
		btnNovaConsulta.setBounds(278, 325, 120, 38);
		frmRegistraVisitante.getContentPane().add(btnNovaConsulta);
		
		btnPesquisa.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnNovaConsulta.addActionListener(this);
		
		rdbtnCpf.addActionListener(this);
		rdbtnRg.addActionListener(this);
		rdbtnPassaporte.addActionListener(this);
		
		cmbNivelAcademico.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Visitante v = new Visitante();
		String cmd = e.getActionCommand();
		if (rdbtnRg.isSelected()) {
			txtRg.setEditable(true);
			txtCpf.setEditable(false);
			txtPassaporte.setEditable(false);
		}else {
			if (rdbtnCpf.isSelected()) {
				txtCpf.setEditable(true);
				txtRg.setEditable(false);
				txtPassaporte.setEditable(false);
			}else {
				if (rdbtnPassaporte.isSelected()) {
					txtPassaporte.setEditable(true);
					txtCpf.setEditable(false);
					txtRg.setEditable(false);
				}
			}
		}
		
		if ("Salvar".equals(cmd)) {
			if (!"".equals(txtNome.getText()) && !"".equals(txtDataNasc.getText()) && !"".equals(txtNacionalidade.getText())
					&& !"".equals(txtNaturalidade.getText())) {
				if (!"".equals(txtRg.getText()) || !"".equals(txtCpf.getText()) || !"".equals(txtPassaporte.getText()) ) {
					v = preencheObjeto();
					VisitanteControl vc = new VisitanteControl();
					vc.insereVisitante(v);
					limpa();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			}
		}
		
		if ("".equals(cmd)) {
			VisitanteControl vc = new VisitanteControl(txtNome, txtDataNasc, txtNacionalidade, txtNaturalidade, txtRg, 
					txtCpf, txtPassaporte, rdbtnMasculino, rdbtnFeminino, rdbtnRg, rdbtnCpf, rdbtnPassaporte, cmbNivelAcademico);
			vc.consultaVisitantePeloNome(txtNome.getText());
		}
		
		if ("Voltar".equals(cmd)) {
			frmRegistraVisitante.dispose();
		}
		
		if ("Nova Consulta".equals(cmd)) {
			limpa();
		}
		
	}
	
	public Visitante preencheObjeto(){
		Visitante v = new Visitante();
		v.setNome(txtNome.getText());
		v.setDtNasc(txtDataNasc.getText().replaceAll("/", ""));
		System.out.println(v.getDtNasc());
		v.setNaturalidade(txtNaturalidade.getText());
		v.setNacionalidade(txtNacionalidade.getText());
		if (rdbtnMasculino.isSelected()) {
			v.setSexo("m");
		}else{
			if (rdbtnFeminino.isSelected()) {
				v.setSexo("f");
			}
		}
		if (cmbNivelAcademico.getSelectedItem() != null) {
			v.setNivelAcademico(cmbNivelAcademico.getSelectedItem().toString());
		}
		if (rdbtnRg.isSelected()) {
			v.setRg(txtRg.getText().replaceAll("[.-]", ""));
		}else {
			if (rdbtnCpf.isSelected()) {
				v.setCpf(txtCpf.getText().replaceAll("[.-]", ""));
			}else {
				if (rdbtnPassaporte.isSelected()) {
					v.setPassaporte(txtPassaporte.getText());
				}
			}
		}
		
		return v;
	}
	
	public void limpa() {
		txtNome.setText("");
		txtDataNasc.setText("");
		txtNacionalidade.setText("");
		txtNaturalidade.setText("");
		txtRg.setText("");
		txtCpf.setText("");
		txtPassaporte.setText("");
		rdbtnMasculino.setSelected(true);
		rdbtnRg.setSelected(true);
		txtCpf.setEditable(false);
		txtPassaporte.setEditable(false);
		cmbNivelAcademico.setSelectedItem(NivelAcademico.Fundamental);
	}
	
}
