package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControllerTabela;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaEmprestimo {

	private JFrame frame;
	private JTable table;
	private JTextField txtNSolicitacao;
	private JTextField txtInstituicao;
	private JTextField txtTituloExibicao;
	private JTextField txtDtEmprestimo;
	private JTextField txtDtDevolucao;
	private JTextField txtObra;
	private JTextField txtTitulo;
	DefaultTableModel modelo;
	private JTextField txtObservacao;
	private JButton btnSalvar, btnPesquisar, btnAlterar, btnAdiciona, btnVoltar, btnCancelar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbStatus, cmbInstituicao, cmbObra;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestimo window = new TelaEmprestimo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 612);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNSolicitao = new JLabel("N\u00BA Solicita\u00E7\u00E3o :");
		lblNSolicitao.setBounds(25, 25, 92, 14);
		frame.getContentPane().add(lblNSolicitao);
		
		txtNSolicitacao = new JTextField();
		txtNSolicitacao.setBounds(125, 22, 86, 20);
		frame.getContentPane().add(txtNSolicitacao);
		txtNSolicitacao.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(355, 28, 46, 14);
		frame.getContentPane().add(lblStatus);
		
		cmbStatus = new JComboBox();
		cmbStatus.setBounds(411, 25, 121, 20);
		frame.getContentPane().add(cmbStatus);
		
		JLabel lblEmprstimoPara = new JLabel("Empr\u00E9stimo para :");
		lblEmprstimoPara.setBounds(25, 62, 115, 14);
		frame.getContentPane().add(lblEmprstimoPara);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setBounds(133, 59, 78, 20);
		frame.getContentPane().add(txtInstituicao);
		txtInstituicao.setColumns(10);
		
		cmbInstituicao = new JComboBox();
		cmbInstituicao.setBounds(221, 59, 336, 20);
		frame.getContentPane().add(cmbInstituicao);
		
		JLabel lblTtuloDaExibio = new JLabel("T\u00EDtulo da Exibi\u00E7\u00E3o :");
		lblTtuloDaExibio.setBounds(25, 99, 115, 14);
		frame.getContentPane().add(lblTtuloDaExibio);
		
		txtTituloExibicao = new JTextField();
		txtTituloExibicao.setBounds(143, 96, 414, 20);
		frame.getContentPane().add(txtTituloExibicao);
		txtTituloExibicao.setColumns(10);
		
		JLabel lblDataEmprstimo = new JLabel("Data Empr\u00E9stimo :");
		lblDataEmprstimo.setBounds(25, 136, 115, 14);
		frame.getContentPane().add(lblDataEmprstimo);
		
		txtDtEmprestimo = new JTextField();
		txtDtEmprestimo.setBounds(153, 133, 86, 20);
		frame.getContentPane().add(txtDtEmprestimo);
		txtDtEmprestimo.setColumns(10);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o :");
		lblDataDevoluo.setBounds(296, 136, 106, 14);
		frame.getContentPane().add(lblDataDevoluo);
		
		txtDtDevolucao = new JTextField();
		txtDtDevolucao.setBounds(412, 133, 86, 20);
		frame.getContentPane().add(txtDtDevolucao);
		txtDtDevolucao.setColumns(10);
		
		JLabel lblObra = new JLabel("Obra :");
		lblObra.setBounds(25, 177, 46, 14);
		frame.getContentPane().add(lblObra);
		
		txtObra = new JTextField();
		txtObra.setBounds(75, 174, 106, 20);
		frame.getContentPane().add(txtObra);
		txtObra.setColumns(10);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo :");
		lblTtulo.setBounds(25, 215, 46, 14);
		frame.getContentPane().add(lblTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(75, 212, 359, 20);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		cmbObra = new JComboBox();
		cmbObra.setBounds(191, 174, 307, 20);
		frame.getContentPane().add(cmbObra);
		
		/*--------------- TABELA ATIVIDADES ----------------------*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 261, 485, 135);
		frame.getContentPane().add(scrollPane);
		String[] cabecalho = {"Título da Obra"};
		modelo = new ControllerTabela(new Object[][]{}, cabecalho);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		/*--------------- FIM TABELA VISITANTES ------------------*/
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o :");
		lblObservao.setBounds(47, 424, 86, 14);
		frame.getContentPane().add(lblObservao);
		
		txtObservacao = new JTextField();
		txtObservacao.setBounds(47, 449, 485, 60);
		frame.getContentPane().add(txtObservacao);
		txtObservacao.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(479, 550, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(258, 550, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 550, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(370, 550, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(228, 21, 106, 23);
		frame.getContentPane().add(btnPesquisar);
		
		btnAdiciona = new JButton("+");
		btnAdiciona.setBounds(444, 211, 46, 23);
		frame.getContentPane().add(btnAdiciona);
		
	}
}
