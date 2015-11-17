package boundary;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaAutor {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtDtNasc;
	private JTextField txtFalecimento;
	private JTextField txtIniAtiv;
	private JTextField txtFimAtiv;
	private JTextField txtDescricao;
	private JButton btnPesquisar, btnSalvar, btnAlterar, btnVoltar, btnNovo;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPais, cmbAtividade;

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
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Autor");
		frame.setBounds(100, 100, 585, 530);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNomeCompleto = new JLabel("Nome Completo :");
		lblNomeCompleto.setBounds(37, 31, 105, 14);
		frame.getContentPane().add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setBounds(142, 28, 306, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setBounds(62, 76, 80, 14);
		frame.getContentPane().add(lblDataNasc);

		txtDtNasc = new JTextField();
		javax.swing.text.MaskFormatter datan;
		try {
			datan = new javax.swing.text.MaskFormatter("##/##/####");
			txtDtNasc = new javax.swing.JFormattedTextField(datan);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDtNasc.setBounds(133, 73, 86, 20);
		frame.getContentPane().add(txtDtNasc);
		txtDtNasc.setColumns(10);

		JLabel lblDataFalecimento = new JLabel("Data Falecimento :");
		lblDataFalecimento.setBounds(296, 76, 123, 14);
		frame.getContentPane().add(lblDataFalecimento);

		txtFalecimento = new JTextField();
		javax.swing.text.MaskFormatter dataf;
		try {
			dataf = new javax.swing.text.MaskFormatter("##/##/####");
			txtFalecimento = new javax.swing.JFormattedTextField(dataf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtFalecimento.setBounds(406, 73, 86, 20);
		frame.getContentPane().add(txtFalecimento);
		txtFalecimento.setColumns(10);

		JLabel lblPas = new JLabel("Pa\u00EDs :");
		lblPas.setBounds(62, 120, 46, 14);
		frame.getContentPane().add(lblPas);

		cmbPais = new JComboBox();
		cmbPais.setBounds(118, 117, 162, 20);
		frame.getContentPane().add(cmbPais);

		JLabel lblreasDeAtividade = new JLabel("\u00C1reas de Atividade :");
		lblreasDeAtividade.setBounds(62, 186, 123, 14);
		frame.getContentPane().add(lblreasDeAtividade);

		cmbAtividade = new JComboBox();
		cmbAtividade.setBounds(171, 183, 181, 20);
		frame.getContentPane().add(cmbAtividade);

		JLabel lblIncioAtividade = new JLabel("In\u00EDcio Atividade :");
		lblIncioAtividade.setBounds(62, 242, 105, 14);
		frame.getContentPane().add(lblIncioAtividade);

		txtIniAtiv = new JTextField();
		javax.swing.text.MaskFormatter datai;
		try {
			datai = new javax.swing.text.MaskFormatter("##/##/####");
			txtIniAtiv = new javax.swing.JFormattedTextField(datai);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIniAtiv.setBounds(158, 239, 86, 20);
		frame.getContentPane().add(txtIniAtiv);
		txtIniAtiv.setColumns(10);

		JLabel lblFimAtividade = new JLabel("Fim Atividade :");
		lblFimAtividade.setBounds(62, 284, 94, 14);
		frame.getContentPane().add(lblFimAtividade);

		txtFimAtiv = new JTextField();
		javax.swing.text.MaskFormatter datafa;
		try {
			datafa = new javax.swing.text.MaskFormatter("##/##/####");
			txtFimAtiv = new javax.swing.JFormattedTextField(datafa);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtFimAtiv.setBounds(158, 281, 86, 20);
		frame.getContentPane().add(txtFimAtiv);
		txtFimAtiv.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(65, 329, 105, 14);
		frame.getContentPane().add(lblDescrio);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(59, 354, 459, 62);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(458, 27, 89, 23);
		frame.getContentPane().add(btnPesquisar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(470, 458, 89, 23);
		frame.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 458, 89, 23);
		frame.getContentPane().add(btnVoltar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(359, 458, 89, 23);
		frame.getContentPane().add(btnAlterar);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(250, 458, 89, 23);
		frame.getContentPane().add(btnNovo);
	}
}
