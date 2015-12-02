package boundary;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaUsuario /* implements ActionListener */ {

	private JFrame frmRegistraUsuario;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario window = new TelaUsuario();
					window.frmRegistraUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation" })
	private void initialize() {
		frmRegistraUsuario = new JFrame();
		frmRegistraUsuario.setTitle("Registra Usu\u00E1rio");
		frmRegistraUsuario.setBounds(100, 100, 590, 410);
		frmRegistraUsuario.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmRegistraUsuario.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(30, 24, 55, 14);
		frmRegistraUsuario.getContentPane().add(lblNome);

		JLabel lblTipoDeDocumento = new JLabel("CPF: ");
		lblTipoDeDocumento.setBounds(31, 58, 62, 14);
		frmRegistraUsuario.getContentPane().add(lblTipoDeDocumento);

		txtNome = new JTextField();
		txtNome.setBounds(86, 21, 341, 20);
		frmRegistraUsuario.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(87, 55, 170, 20);
		javax.swing.text.MaskFormatter cpf;
		try {
			cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(cpf);
			txtCpf.setSize(170, 20);
			txtCpf.setLocation(87, 55);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		frmRegistraUsuario.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setIcon(new ImageIcon(TelaUsuario.class.getResource("/icon/img-pesquisa.png")));
		btnPesquisa.setBounds(275, 54, 108, 23);
		frmRegistraUsuario.getContentPane().add(btnPesquisa);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaUsuario.class.getResource("/icon/img-voltar.png")));
		btnVoltar.setBounds(15, 300, 108, 38);
		frmRegistraUsuario.getContentPane().add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaUsuario.class.getResource("/icon/img-salvar.png")));
		btnSalvar.setBounds(443, 300, 102, 38);
		frmRegistraUsuario.getContentPane().add(btnSalvar);

		JLabel lblUsurio = new JLabel("usu\u00E1rio: ");
		lblUsurio.setBounds(30, 115, 72, 14);
		frmRegistraUsuario.getContentPane().add(lblUsurio);

		JLabel lblSenha = new JLabel("senha: ");
		lblSenha.setBounds(31, 151, 62, 14);
		frmRegistraUsuario.getContentPane().add(lblSenha);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(96, 112, 129, 20);
		frmRegistraUsuario.getContentPane().add(txtUsuario);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(96, 148, 129, 20);
		frmRegistraUsuario.getContentPane().add(txtSenha);

		JLabel lblPerfil = new JLabel("Perfil: ");
		lblPerfil.setBounds(30, 186, 88, 14);
		frmRegistraUsuario.getContentPane().add(lblPerfil);

		JRadioButton rdbtnPadro = new JRadioButton("Padr\u00E3o");
		rdbtnPadro.setSelected(true);
		rdbtnPadro.setBounds(40, 212, 102, 23);
		frmRegistraUsuario.getContentPane().add(rdbtnPadro);

		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(149, 212, 103, 23);
		frmRegistraUsuario.getContentPane().add(rdbtnGerente);

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rdbtnPadro);
		bg1.add(rdbtnGerente);

	}
}