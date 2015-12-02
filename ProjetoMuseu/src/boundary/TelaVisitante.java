package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControllerTabela;
import controller.IngressoController;
import controller.VisitanteController;
import entity.Exposicao;
import entity.Locomocao;
import entity.NivelAcademico;
import entity.Paises;
import entity.Visitante;

public class TelaVisitante implements ActionListener{

	private JFrame frameVisitante;
	private JTextField txtData;
	private JTable table;
	private JTextField txtIdade;
	private JButton btnSalvar, btnAdicionar, btnVoltar, btnLimpar;
	private JRadioButton rdbtnFem_, rdbtnMasc_;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbEscolaridade, cmbLocomocao, cmbPais, cmbExposicao;
	DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisitante window = new TelaVisitante();
					window.frameVisitante.setVisible(true);
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
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void initialize() {
		frameVisitante = new JFrame();
		frameVisitante.setTitle("Registro do Visitante");
		frameVisitante.setBounds(100, 100, 827, 605);
		frameVisitante.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frameVisitante.setResizable(false);
		frameVisitante.getContentPane().setLayout(null);
		
		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(54, 26, 46, 14);
		frameVisitante.getContentPane().add(lblData);
		
		JLabel lblExposio = new JLabel("Exposição:");
		lblExposio.setBounds(273, 26, 73, 14);
		frameVisitante.getContentPane().add(lblExposio);
		
		JLabel lblPas_1 = new JLabel("País ");
		lblPas_1.setBounds(54, 146, 46, 14);
		frameVisitante.getContentPane().add(lblPas_1);
		
		JLabel lblEscolaridade_1 = new JLabel("Escolaridade");
		lblEscolaridade_1.setBounds(273, 146, 101, 14);
		frameVisitante.getContentPane().add(lblEscolaridade_1);
		
		cmbEscolaridade = new JComboBox(NivelAcademico.values());
		cmbEscolaridade.setBounds(273, 171, 179, 20);
		frameVisitante.getContentPane().add(cmbEscolaridade);
		
		JLabel lblLocomoo_1 = new JLabel("Locomoção");
		lblLocomoo_1.setBounds(493, 146, 89, 14);
		frameVisitante.getContentPane().add(lblLocomoo_1);
		
		cmbLocomocao = new JComboBox(Locomocao.values());
		cmbLocomocao.setBounds(493, 171, 179, 20);
		frameVisitante.getContentPane().add(cmbLocomocao);
		
		rdbtnMasc_ = new JRadioButton("Masculino");
		rdbtnMasc_.setSelected(true);
		rdbtnMasc_.setBounds(54, 98, 95, 23);
		frameVisitante.getContentPane().add(rdbtnMasc_);
		
		rdbtnFem_ = new JRadioButton("Feminino");
		rdbtnFem_.setBounds(185, 98, 89, 23);
		frameVisitante.getContentPane().add(rdbtnFem_);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMasc_);
		bg.add(rdbtnFem_);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(54, 73, 46, 14);
		frameVisitante.getContentPane().add(lblSexo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(693, 206, 95, 29);
		frameVisitante.getContentPane().add(btnAdicionar);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));  
		txtData.setBounds(93, 23, 135, 20);
		frameVisitante.getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade :");
		lblIdade.setBounds(340, 87, 46, 14);
		frameVisitante.getContentPane().add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(396, 84, 73, 20);
		frameVisitante.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		/*--------------- TABELA VISITANTES ----------------------*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 267, 730, 242);
		frameVisitante.getContentPane().add(scrollPane);
		String[] cabecalho = {"Idade", "Sexo", "País", "Escolaridade", "Locomoção"};
		modelo = new ControllerTabela(new Object[][]{}, cabecalho);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		/*--------------- FIM TABELA VISITANTES ------------------*/
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(693, 541, 89, 29);
		frameVisitante.getContentPane().add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(32, 541, 89, 29);
		frameVisitante.getContentPane().add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(528, 541, 101, 29);
		frameVisitante.getContentPane().add(btnLimpar);
		
		cmbPais = new JComboBox(Paises.values());
		cmbPais.setBounds(54, 171, 174, 20);
		frameVisitante.getContentPane().add(cmbPais);
		
		cmbExposicao = new JComboBox();
		cmbExposicao.setBounds(340, 23, 388, 20);
		IngressoController ic = new IngressoController();
		List<Exposicao> listaExpo = new ArrayList<Exposicao>();
		listaExpo = ic.nomeExpo(txtData.getText());
		if (listaExpo != null) {
			for (Exposicao e : listaExpo) {
				cmbExposicao.addItem(e.getTituloExibicao() + "  -  " + e.getHora());
			}
		} else {
			cmbExposicao.addItem("Não há exposições para Hoje");
		}
		frameVisitante.getContentPane().add(cmbExposicao);
		
		btnAdicionar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnLimpar.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Voltar")) 
			frameVisitante.dispose();
		if (cmd.equals("Adicionar")) 
			adicionarTabela();
		if (cmd.equals("Salvar"))
			salvaVisitante();
		if (cmd.equals("Limpar")) 
			limpaTudo();
		
	}
	
	Visitante v = null;
	VisitanteController vc = new VisitanteController();

	public void limpaTudo() {
		rdbtnMasc_.setSelected(true);
		txtIdade.setText("");
		cmbPais.setSelectedItem(Paises.Selecione);
		cmbEscolaridade.setSelectedItem(NivelAcademico.Selecione);
		cmbLocomocao.setSelectedItem(Locomocao.Selecione);
	}

	public Visitante salvarVisitante() {
		
		Visitante v = new Visitante();
		boolean sexo;
		if (rdbtnFem_.isSelected()) {
			sexo = true;
		} else{
			sexo = true;
		}
		v.setSexo(sexo);
		v.setIdade(Integer.parseInt(txtIdade.getText()));
		v.setPais(cmbPais.getSelectedItem().toString());
		v.setEscolaridade(cmbEscolaridade.getSelectedItem().toString());
		v.setLocomocao(cmbLocomocao.getSelectedItem().toString());
		
		return v;
	}

	private void adicionarTabela() {
		
		String e = cmbEscolaridade.getSelectedItem().toString();
		String p = cmbPais.getSelectedItem().toString();
		String l = cmbLocomocao.getSelectedItem().toString();
		
		if (!"".equals(txtIdade.getText())) {
			if (!"Selecione".equals(p)) {
				if (!"Selecione".equals(e)) {
					if (!"Selecione".equals(l)) {
						String sexo = null;
						
						if (rdbtnFem_.isSelected()) {
							sexo = "Feminino";
						} else{
							sexo = "Masculino";
						}
						
							Object[] linha = new Object[5];
							linha[0] = txtIdade.getText();
							linha[1] = sexo;
							linha[2] = "Pais";
							linha[3] = cmbEscolaridade.getSelectedItem();
							linha[4] = cmbLocomocao.getSelectedItem();
							modelo.addRow(linha);	
							
							Visitante v = null;
							VisitanteController vc = new VisitanteController();
							
							v = salvarVisitante();
							vc.salvaVisitante(v);
							
							txtIdade.setText("");
							
					} else {
						JOptionPane.showMessageDialog(null,
								"Escolha a Locomoção", "Alerta",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(null,
							"Escolha a Escolaridade", "Alerta",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			} else {
				JOptionPane.showMessageDialog(null,
						"Escolha o País", "Alerta",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else{
			JOptionPane.showMessageDialog(null,
					"Preencha o campo Idade", "Alerta",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void salvaVisitante(){
		if (modelo.getRowCount() != 0) {
			JOptionPane.showMessageDialog(null,
					"Visitante(s) registrado(s) com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			limpaTudo();
			modelo.removeRow(0);
		} else {
			JOptionPane.showMessageDialog(null,
					"Não há Visitante(s) para ser(em) \n                registrado(s)", "Alerta",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
