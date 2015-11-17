package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class TelaVenda {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(41, 32, 46, 14);
		frame.getContentPane().add(lblData);
		
		textField = new JTextField();
		textField.setBounds(83, 29, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblExposio = new JLabel("Exposi\u00E7\u00E3o :");
		lblExposio.setBounds(249, 29, 75, 14);
		frame.getContentPane().add(lblExposio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(314, 26, 310, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblExposioEspecial = new JLabel("Exposi\u00E7\u00E3o Especial :");
		lblExposioEspecial.setBounds(41, 75, 128, 14);
		frame.getContentPane().add(lblExposioEspecial);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(41, 108, 75, 23);
		frame.getContentPane().add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setBounds(131, 108, 75, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o :");
		lblPreo.setBounds(292, 86, 56, 14);
		frame.getContentPane().add(lblPreo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(358, 83, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ingresso", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(138, 157, 335, 136);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxInteira = new JCheckBox("Inteira");
		chckbxInteira.setBounds(31, 32, 97, 23);
		panel.add(chckbxInteira);
		
		JCheckBox chckbxMeia = new JCheckBox("Meia");
		chckbxMeia.setBounds(186, 32, 97, 23);
		panel.add(chckbxMeia);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 69, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 69, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total : ");
		lblValorTotal.setBounds(41, 326, 80, 14);
		frame.getContentPane().add(lblValorTotal);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 323, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento :");
		lblTipoPagamento.setBounds(41, 361, 96, 14);
		frame.getContentPane().add(lblTipoPagamento);
		
		JCheckBox chckbxDinheiro = new JCheckBox("Dinheiro");
		chckbxDinheiro.setBounds(131, 361, 97, 23);
		frame.getContentPane().add(chckbxDinheiro);
		
		JCheckBox chckbxCartoDbito = new JCheckBox("D\u00E9bito");
		chckbxCartoDbito.setBounds(131, 387, 97, 23);
		frame.getContentPane().add(chckbxCartoDbito);
		
		JCheckBox chckbxCartoCrdito = new JCheckBox("Cart\u00E3o Cr\u00E9dito");
		chckbxCartoCrdito.setBounds(131, 413, 97, 23);
		frame.getContentPane().add(chckbxCartoCrdito);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido:");
		lblValorRecebido.setBounds(314, 361, 86, 14);
		frame.getContentPane().add(lblValorRecebido);
		
		textField_5 = new JTextField();
		textField_5.setBounds(399, 358, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco :");
		lblTroco.setBounds(314, 391, 46, 14);
		frame.getContentPane().add(lblTroco);
		
		textField_6 = new JTextField();
		textField_6.setBounds(370, 388, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(523, 474, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(325, 474, 89, 23);
		frame.getContentPane().add(btnNovo);
		
		JButton btnVisitante = new JButton("Visitante");
		btnVisitante.setBounds(424, 474, 89, 23);
		frame.getContentPane().add(btnVisitante);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(20, 474, 89, 23);
		frame.getContentPane().add(btnVoltar);
		frame.setResizable(false);
	}
}
