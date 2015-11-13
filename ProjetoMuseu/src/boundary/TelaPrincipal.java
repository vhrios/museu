package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaPrincipal implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrarVisitante = new JButton("Cadastrar Visitante");
		btnCadastrarVisitante.setBounds(32, 26, 173, 39);
		frame.getContentPane().add(btnCadastrarVisitante);
		
		JButton btnEstatistica = new JButton("Estatística");
		btnEstatistica.setBounds(262, 26, 138, 39);
		frame.getContentPane().add(btnEstatistica);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(161, 228, 89, 23);
		frame.getContentPane().add(btnSair);
		
		btnCadastrarVisitante.addActionListener(this);
		btnEstatistica.addActionListener(this);
		btnSair.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Cadastrar Visitante".equals(cmd)) {
			TelaVisitante tv = new TelaVisitante();
			tv.main(null);
		}
		if ("Estatística".equals(cmd)) {
			TelaGrafico tg = new TelaGrafico();
			tg.main(null);
		}
		if ("Sair".equals(cmd)) {
			System.exit(0);
		}
	}

}
