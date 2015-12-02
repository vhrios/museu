package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.VendaController;
import entity.Venda;

public class TelaVenda implements ActionListener {

	private JFrame frame;
	private JTextField txtData;
	private JTextField txtPreco;
	private JTextField txtInteira;
	private JTextField txtMeia;
	private JTextField txtValorTotal;
	private JTextField txtValorRecebido;
	private JTextField txtTroco;
	private JButton btnSalvar, btnVoltar, btnNovo, btnVisitante;
	private JCheckBox chckbxDinheiro, chckbxCartoDbito, chckbxCartoCrdito, chckbxMeia, chckbxInteira;
	private JRadioButton rdbtnNao, rdbtnSim;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda window = new TelaVenda();
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
	public TelaVenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 536);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(41, 32, 46, 14);
		frame.getContentPane().add(lblData);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		txtData.setBounds(83, 29, 86, 20);
		frame.getContentPane().add(txtData);
		txtData.setColumns(10);

		JLabel lblExposio = new JLabel("Exposi\u00E7\u00E3o :");
		lblExposio.setBounds(215, 32, 75, 14);
		frame.getContentPane().add(lblExposio);

		JComboBox cmbExposicao = new JComboBox();
		cmbExposicao.setBounds(292, 29, 310, 20);
		frame.getContentPane().add(cmbExposicao);

		JLabel lblExposioEspecial = new JLabel("Exposi\u00E7\u00E3o Especial :");
		lblExposioEspecial.setBounds(41, 75, 128, 14);
		frame.getContentPane().add(lblExposioEspecial);

		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setEnabled(false);
		rdbtnSim.setBounds(41, 108, 75, 23);
		frame.getContentPane().add(rdbtnSim);

		rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setEnabled(false);
		rdbtnNao.setBounds(131, 108, 75, 23);
		frame.getContentPane().add(rdbtnNao);

		JLabel lblPreo = new JLabel("Pre\u00E7o :");
		lblPreo.setBounds(292, 86, 56, 14);
		frame.getContentPane().add(lblPreo);

		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setBounds(358, 83, 86, 20);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ingresso", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		panel.setBounds(138, 157, 335, 136);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		chckbxInteira = new JCheckBox("Inteira");
		chckbxInteira.setBounds(31, 32, 97, 23);
		panel.add(chckbxInteira);

		chckbxMeia = new JCheckBox("Meia");
		chckbxMeia.setBounds(186, 32, 97, 23);
		panel.add(chckbxMeia);

		txtInteira = new JTextField();
		txtInteira.setBounds(57, 69, 86, 20);
		panel.add(txtInteira);
		txtInteira.setColumns(10);

		txtMeia = new JTextField();
		txtMeia.setBounds(239, 69, 86, 20);
		panel.add(txtMeia);
		txtMeia.setColumns(10);

		JLabel lblQtd = new JLabel("Qtd :");
		lblQtd.setBounds(15, 72, 46, 14);
		panel.add(lblQtd);

		JLabel lblQtd_1 = new JLabel("Qtd :");
		lblQtd_1.setBounds(196, 72, 46, 14);
		panel.add(lblQtd_1);

		JLabel lblValorTotal = new JLabel("Valor Total : ");
		lblValorTotal.setBounds(41, 326, 80, 14);
		frame.getContentPane().add(lblValorTotal);

		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(111, 323, 86, 20);
		frame.getContentPane().add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento :");
		lblTipoPagamento.setBounds(41, 361, 109, 14);
		frame.getContentPane().add(lblTipoPagamento);

		chckbxDinheiro = new JCheckBox("Dinheiro");
		chckbxDinheiro.setBounds(148, 361, 97, 23);
		frame.getContentPane().add(chckbxDinheiro);

		chckbxCartoDbito = new JCheckBox("D\u00E9bito");
		chckbxCartoDbito.setBounds(148, 387, 97, 23);
		frame.getContentPane().add(chckbxCartoDbito);

		chckbxCartoCrdito = new JCheckBox("Cart\u00E3o Cr\u00E9dito");
		chckbxCartoCrdito.setBounds(148, 413, 97, 23);
		frame.getContentPane().add(chckbxCartoCrdito);

		JLabel lblValorRecebido = new JLabel("Valor Recebido:");
		lblValorRecebido.setBounds(292, 361, 97, 14);
		frame.getContentPane().add(lblValorRecebido);

		txtValorRecebido = new JTextField();
		txtValorRecebido.setBounds(399, 358, 86, 20);
		frame.getContentPane().add(txtValorRecebido);
		txtValorRecebido.setColumns(10);

		JLabel lblTroco = new JLabel("Troco :");
		lblTroco.setBounds(314, 391, 46, 14);
		frame.getContentPane().add(lblTroco);

		txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setBounds(370, 388, 86, 20);
		frame.getContentPane().add(txtTroco);
		txtTroco.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(523, 474, 89, 23);
		frame.getContentPane().add(btnSalvar);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(325, 474, 89, 23);
		frame.getContentPane().add(btnNovo);

		btnVisitante = new JButton("Visitante");
		btnVisitante.setBounds(424, 474, 89, 23);
		frame.getContentPane().add(btnVisitante);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(20, 474, 89, 23);
		frame.getContentPane().add(btnVoltar);

		btnNovo.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnVisitante.addActionListener(this);
		btnVoltar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Voltar".equals(cmd)) {
			frame.dispose();
		}
		if ("Visitante".equals(cmd)) {
			TelaVisitante tv = new TelaVisitante();
			tv.main(null);
			btnSalvar.setEnabled(true);
		}
		if ("Novo".equals(cmd)) {
			limpar();
		}
		if ("Salvar".equals(cmd)) {
			verificaCampos();
			Venda v = conteudoTela();
			VendaController vc = new VendaController();
			vc.salvaVenda(v);
		}
	}

	private void verificaCampos() {
		if (chckbxInteira.isSelected()) {

		}
	}

	private void limpar() {
		txtPreco.setText("");
		txtInteira.setText("");
		txtMeia.setText("");
		txtTroco.setText("");
		txtValorRecebido.setText("");
		txtValorTotal.setText("");
		rdbtnNao.setSelected(false);
		rdbtnSim.setSelected(false);
		chckbxCartoCrdito.setSelected(false);
		chckbxCartoDbito.setSelected(false);
		chckbxDinheiro.setSelected(false);
		chckbxInteira.setSelected(false);
		chckbxMeia.setSelected(false);
	}

	private Venda conteudoTela() {
		Venda v = new Venda();
		String dataHoje = txtData.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			v.setData(sdf.parse(dataHoje));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		v.setQtdInteiro(Integer.parseInt(txtInteira.getText()));
		v.setQtdMeia(Integer.parseInt(txtMeia.getText()));
		v.setValorTotal(Double.parseDouble(txtValorTotal.getText()));
		// verifica qual check foi escolhi para opção de pagamento e seta na
		// forma de pagamento as opções selecionadas
		if (chckbxCartoCrdito.isSelected() && chckbxCartoDbito.isSelected() && chckbxDinheiro.isSelected()) {
			v.setFormaPagamento(chckbxCartoCrdito.getText() + " / " + chckbxCartoDbito.getText() + " / "
					+ chckbxDinheiro.getText());
		} else if (chckbxCartoCrdito.isSelected() && chckbxCartoDbito.isSelected()) {
			v.setFormaPagamento(chckbxCartoCrdito.getText() + " / " + chckbxCartoDbito.getText());
		} else if (chckbxCartoDbito.isSelected() && chckbxDinheiro.isSelected()) {
			v.setFormaPagamento(chckbxCartoDbito.getText() + " / " + chckbxDinheiro.getText());
		} else if (chckbxCartoCrdito.isSelected() && chckbxDinheiro.isSelected()) {
			v.setFormaPagamento(chckbxCartoCrdito.getText() + " / " + chckbxDinheiro.getText());
		} else if (chckbxCartoDbito.isSelected() && chckbxDinheiro.isSelected()) {
			v.setFormaPagamento(chckbxCartoDbito.getText() + " / " + chckbxDinheiro.getText());
		} else if (chckbxCartoCrdito.isSelected()) {
			v.setFormaPagamento(chckbxCartoCrdito.getText());
		} else if (chckbxCartoDbito.isSelected()) {
			v.setFormaPagamento(chckbxCartoDbito.getText());
		} else if (chckbxDinheiro.isSelected()) {
			v.setFormaPagamento(chckbxDinheiro.getText());
		}
		return v;
	}
}
