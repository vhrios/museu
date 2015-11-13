package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UsuarioControle;
import entity.Usuario;

public class TelaLogin implements ActionListener{

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 243);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setBounds(55, 40, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(55, 94, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(101, 37, 150, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(101, 91, 150, 20);
		frame.getContentPane().add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(292, 175, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(10, 175, 89, 23);
		frame.getContentPane().add(btnSair);
		
		btnEntrar.addActionListener(this);
		btnSair.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Entrar".equals(cmd)) {
			Usuario u;
			u = validaUsuario();
			UsuarioControle uc = new UsuarioControle();
			uc.validaLogin(u);
		}
		if ("Sair".equals(cmd)) {
			System.exit(0);
		}
	}

	@SuppressWarnings("deprecation")
	public Usuario validaUsuario() {
		Usuario u = new Usuario();
		if (!"".equals(txtLogin.getText()) && !"".equals(txtSenha.getText())) {
			u.setLogin(txtLogin.getText());
			u.setSenha(txtSenha.getText());
		}else{
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		}
		return u;
	}
}
