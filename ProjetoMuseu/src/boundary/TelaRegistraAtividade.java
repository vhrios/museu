package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerTabela;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaRegistraAtividade {

	private JFrame frmAtividade;
	private JTable table;
	DefaultTableModel modelo;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JLabel lblAtividade;
	private JTextField txtAtividade;
	private JButton btnAdicionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistraAtividade window = new TelaRegistraAtividade();
					window.frmAtividade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRegistraAtividade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmAtividade = new JFrame();
		frmAtividade.setTitle("Atividade");
		frmAtividade.setBounds(100, 100, 450, 366);
		frmAtividade.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmAtividade.getContentPane().setLayout(null);
		frmAtividade.setResizable(false);
		
		/*--------------- TABELA ATIVIDADES ----------------------*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 74, 332, 181);
		frmAtividade.getContentPane().add(scrollPane);
		String[] cabecalho = {"Atividade"};
		modelo = new ControllerTabela(new Object[][]{}, cabecalho);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		/*--------------- FIM TABELA VISITANTES ------------------*/
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(334, 289, 89, 23);
		frmAtividade.getContentPane().add(btnSalvar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(24, 289, 89, 23);
		frmAtividade.getContentPane().add(btnVoltar);
		
		lblAtividade = new JLabel("Atividade :");
		lblAtividade.setBounds(41, 27, 72, 14);
		frmAtividade.getContentPane().add(lblAtividade);
		
		txtAtividade = new JTextField();
		txtAtividade.setBounds(103, 24, 201, 20);
		frmAtividade.getContentPane().add(txtAtividade);
		txtAtividade.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(334, 23, 89, 23);
		frmAtividade.getContentPane().add(btnAdicionar);
		
	}

}
