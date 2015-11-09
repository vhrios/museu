package boundary;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import entity.Autor;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class TelaAutor {

	private JFrame frame;
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblNacionalidade;
	private JLabel lblDescricao;
	private JLabel lblAreaAtuacao;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtNacionalidade;
	private JTextArea  txtDescricao;
	private JComboBox<String> cmbArea;
	private JLabel lblMaximo;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAutor window = new TelaAutor();
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
	public TelaAutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblCodigo = new JLabel("codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 48, 46, 14);
		frame.getContentPane().add(lblNome);
		
		lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setBounds(10, 92, 87, 14);
		frame.getContentPane().add(lblNacionalidade);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 132, 67, 14);
		frame.getContentPane().add(lblDescricao);
		
		lblAreaAtuacao = new JLabel("Area Atua\u00E7\u00E3o:");
		lblAreaAtuacao.setBounds(10, 205, 87, 14);
		frame.getContentPane().add(lblAreaAtuacao);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(87, 8, 86, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(88, 45, 401, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(87, 89, 126, 20);
		frame.getContentPane().add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
	    txtDescricao = new JTextArea();
		txtDescricao.setRows(10);
		txtDescricao.setBounds(87, 127, 401, 63);
		frame.getContentPane().add(txtDescricao);
		
		cmbArea = new JComboBox<String>();
		cmbArea.setBounds(87, 202, 175, 20);
		frame.getContentPane().add(cmbArea);
		
		lblMaximo = new JLabel("OBS.: ( apenas a  principal atividade. )");
		lblMaximo.setBounds(285, 205, 231, 14);
		frame.getContentPane().add(lblMaximo);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(441, 293, 126, 58);
		frame.getContentPane().add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 311, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		/*
		 * carregando o combo box da Area de atuação
		 */
		
		ArrayList<String> carregar= new ArrayList<>();
		carregar.add("selecione Area");
		carregar.add("Arqueologia");
		carregar.add("Desenho");
		carregar.add("Escultura");
		carregar.add("Fotografia");
		carregar.add("Gravura");
		carregar.add("Pintura");
		carregar.add("Outros");
		
		for(String m: carregar)
			cmbArea.addItem(m);

	}
	
	
	public Autor autorFrame(){
		Autor autor=new Autor();
		
		
		String nome="";
		String nacionalidade="";
		String areaAtiv="";
		String descricao="";
		
		nome= txtNome.getText();
		nacionalidade=txtNacionalidade.getText();
		areaAtiv=(String) cmbArea.getSelectedItem();
		descricao=txtDescricao.getText();
		
		
		autor.setNomeAutor(nome);
		autor.setNacionalidade(nacionalidade);
		autor.setAreaAtividade(areaAtiv);
		autor.setDescricao(descricao);
		
		return autor;
		
	}
	
	
}
