package boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import entity.Usuario;

public class TelaPrincipal {

	private JFrame frmMm;
	private Usuario u;
	private JButton btnInserirVisitante;
	private JButton btnManterAutor;
	private JButton btnManterObra;
	private JButton btnManterUsuario;
	private JButton btnManterEmprstimo;
	private JButton btnManterInstituio;
	private JButton btnManterExposicao;
	private JButton btnRealizarVenda;
	private JButton btnEstatistica;
	@SuppressWarnings("unused")
	private Label lblBemVindo;
	private ImageIcon icon;
	private Image img;
	private Image newimg;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmMm.setVisible(true);
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
		this(new Usuario());
	}

	public TelaPrincipal(Usuario u) {
		this.u = u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMm = new JFrame();
		frmMm.setTitle("MMS");
		frmMm.setBounds(100, 100, 640, 480);
		frmMm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMm.getContentPane().setLayout(null);

		btnInserirVisitante = new JButton("Inserir Visitante");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121531_add_user.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnInserirVisitante.setIcon(icon);
		btnInserirVisitante.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInserirVisitante.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInserirVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVisitante tv = new TelaVisitante();
				tv.main(null);
			}
		});
		btnInserirVisitante.setBounds(430, 137, 173, 60);
		frmMm.getContentPane().add(btnInserirVisitante);

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121885_brush.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterAutor = new JButton("Manter Autor");
		btnManterAutor.setIcon(icon);
		btnManterAutor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterAutor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAutor ta = new TelaAutor();
				ta.main(null);
			}
		});
		btnManterAutor.setBounds(15, 61, 173, 60);
		frmMm.getContentPane().add(btnManterAutor);

		btnManterObra = new JButton("Manter Obra");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121657_stack_of_photos.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterObra.setIcon(icon);
		btnManterObra.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterObra.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaObra to = new TelaObra();
				to.main(null);
			}
		});
		btnManterObra.setBounds(15, 137, 173, 60);
		frmMm.getContentPane().add(btnManterObra);

		btnManterUsuario = new JButton("Manter Usu\u00E1rio");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121536_conference.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterUsuario.setIcon(icon);
		btnManterUsuario.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuario tu = new TelaUsuario();
				tu.main(null);
			}
		});
		btnManterUsuario.setBounds(223, 61, 173, 60);
		frmMm.getContentPane().add(btnManterUsuario);

		btnManterEmprstimo = new JButton("Manter Empr\u00E9stimo");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121547_logout.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterEmprstimo.setIcon(icon);
		btnManterEmprstimo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterEmprstimo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEmprestimo te = new TelaEmprestimo();
				te.main(null);
			}
		});
		btnManterEmprstimo.setBounds(15, 289, 173, 60);
		frmMm.getContentPane().add(btnManterEmprstimo);

		btnManterInstituio = new JButton("Manter Institui\u00E7\u00E3o");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449122931_business_contact.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterInstituio.setIcon(icon);
		btnManterInstituio.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterInstituio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterInstituio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInstituicao ti = new TelaInstituicao();
				ti.main(null);
			}
		});
		btnManterInstituio.setBounds(15, 213, 173, 60);
		frmMm.getContentPane().add(btnManterInstituio);

		btnManterExposicao = new JButton("Manter Exposi\u00E7\u00E3o");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121761_purchase_order.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnManterExposicao.setIcon(icon);
		btnManterExposicao.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManterExposicao.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManterExposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaIngresso ti = new TelaIngresso();
				ti.main(null);
			}
		});
		btnManterExposicao.setBounds(223, 137, 173, 60);
		frmMm.getContentPane().add(btnManterExposicao);

		btnRealizarVenda = new JButton("Realizar Venda");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121572_ticket.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnRealizarVenda.setIcon(icon);
		btnRealizarVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRealizarVenda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda tv = new TelaVenda();
				tv.main(null);
			}
		});
		btnRealizarVenda.setBounds(430, 61, 173, 60);
		frmMm.getContentPane().add(btnRealizarVenda);

		btnEstatistica = new JButton("Estat\u00EDstica");

		icon = new ImageIcon(TelaPrincipal.class.getResource("/ico/1449121563_combo.png"));
		img = icon.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		btnEstatistica.setIcon(icon);
		btnEstatistica.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEstatistica.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEstatistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGrafico tg = new TelaGrafico();
				tg.main(null);
			}
		});
		btnEstatistica.setBounds(223, 213, 173, 60);
		frmMm.getContentPane().add(btnEstatistica);

		Label lblBemVindo = new Label();
		String nome;
		try {
			nome = u.getNome();
		} catch (NullPointerException e) {
			nome = "Visitante";
		}
		lblBemVindo.setText("Bem vindo, " + nome);
		lblBemVindo.setBounds(15, 10, 588, 27);
		frmMm.getContentPane().add(lblBemVindo);

		aplicarPerfil();

	}

	private void aplicarPerfil() {
		if (!u.isGerente()) {
			btnInserirVisitante.setEnabled(true);
			btnManterAutor.setEnabled(true);
			btnManterObra.setEnabled(true);
			btnManterUsuario.setEnabled(false);
			btnManterEmprstimo.setEnabled(false);
			btnManterInstituio.setEnabled(true);
			btnManterExposicao.setEnabled(true);
			btnRealizarVenda.setEnabled(true);
			btnEstatistica.setEnabled(false);
		}
	}
}
