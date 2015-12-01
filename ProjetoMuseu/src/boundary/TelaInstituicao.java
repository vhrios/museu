package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.InstituicaoController;
import entity.Instituicao;
import entity.Paises;

public class TelaInstituicao {

	private JFrame frmInstituio;
	private JTextField txtId;
	private JTextField txtInstituicao;
	private JTextField txtLogradouro;
	private JTextField txtNum;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtCargo;
	private JTextField txtContato;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPais;
	private JButton btnSalvar, btnVoltar, btnNovo, btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInstituicao window = new TelaInstituicao();
					window.frmInstituio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInstituicao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void initialize() {
		frmInstituio = new JFrame();
		frmInstituio.setTitle("Institui\u00E7\u00E3o");
		frmInstituio.setBounds(100, 100, 662, 429);
		frmInstituio.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmInstituio.getContentPane().setLayout(null);
		frmInstituio.setResizable(false);

		JLabel lblIdentificador = new JLabel("Identificador :");
		lblIdentificador.setBounds(31, 27, 80, 14);
		frmInstituio.getContentPane().add(lblIdentificador);

		txtId = new JTextField();
		txtId.setBounds(121, 24, 86, 20);
		frmInstituio.getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o :");
		lblInstituio.setBounds(31, 65, 80, 14);
		frmInstituio.getContentPane().add(lblInstituio);

		txtInstituicao = new JTextField();
		txtInstituicao.setBounds(104, 62, 389, 20);
		frmInstituio.getContentPane().add(txtInstituicao);
		txtInstituicao.setColumns(10);

		JLabel lblLogradouro = new JLabel("Logradouro :");
		lblLogradouro.setBounds(31, 93, 80, 14);
		frmInstituio.getContentPane().add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(121, 90, 290, 20);
		frmInstituio.getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);

		JLabel lblN = new JLabel("N\u00BA :");
		lblN.setBounds(75, 120, 46, 14);
		frmInstituio.getContentPane().add(lblN);

		txtNum = new JTextField();
		txtNum.setBounds(104, 117, 63, 20);
		frmInstituio.getContentPane().add(txtNum);
		txtNum.setColumns(10);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(212, 120, 46, 14);
		frmInstituio.getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(246, 117, 124, 20);
		frmInstituio.getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblPas = new JLabel("Pa\u00EDs :");
		lblPas.setBounds(75, 156, 46, 14);
		frmInstituio.getContentPane().add(lblPas);

		cmbPais = new JComboBox();
		for (Paises p : Paises.values()) {
			cmbPais.addItem(p.toString().replace('_', ' '));
		}
		cmbPais.setBounds(114, 153, 156, 20);
		frmInstituio.getContentPane().add(cmbPais);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(302, 156, 46, 14);
		frmInstituio.getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(358, 153, 70, 20);
		frmInstituio.getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(468, 156, 46, 14);
		frmInstituio.getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(518, 153, 104, 20);
		frmInstituio.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contato", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(31, 222, 596, 124);
		frmInstituio.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTelefone = new JLabel("Contato :");
		lblTelefone.setBounds(23, 30, 64, 14);
		panel.add(lblTelefone);

		txtContato = new JTextField();
		txtContato.setBounds(95, 27, 96, 20);
		panel.add(txtContato);
		txtContato.setColumns(10);

		JLabel lblTelefone_1 = new JLabel("Telefone :");
		lblTelefone_1.setBounds(23, 69, 81, 14);
		panel.add(lblTelefone_1);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(95, 66, 96, 20);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("E - mail :");
		lblEmail.setBounds(280, 69, 57, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(280, 86, 299, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(270, 30, 46, 14);
		panel.add(lblCargo);

		txtCargo = new JTextField();
		txtCargo.setBounds(336, 27, 245, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instituicao i = new Instituicao();

				i.setId(Integer.parseInt(txtId.getText()));
				i.setNome(txtInstituicao.getText());
				i.setEndereco(txtLogradouro.getText());
				i.setNumero(txtNum.getText());
				i.setCep(txtCep.getText());
				i.setEstado(txtEstado.getText());
				i.setCidade(txtCidade.getText());
				i.setPais(cmbPais.getSelectedItem().toString());

				i.setContato(txtContato.getText());
				i.setTelefone(txtTelefone.getText());
				i.setEmail(txtEmail.getText());
				i.setCargo(txtCargo.getText());

				InstituicaoController ic = new InstituicaoController();
				if (ic.verificarInstituicao(i)) {
					if (ic.salvarInstituicao(i)) {
						JOptionPane.showMessageDialog(null, "Instituição salva com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao salvar a Instituição");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos campos");
				}
			}
		});
		btnSalvar.setBounds(557, 367, 89, 23);
		frmInstituio.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 367, 89, 23);
		frmInstituio.getContentPane().add(btnVoltar);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparForm();
			}
		});
		btnNovo.setBounds(458, 367, 89, 23);
		frmInstituio.getContentPane().add(btnNovo);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtId.getText().isEmpty()) {
					InstituicaoController ic = new InstituicaoController();
					Instituicao i = ic.pesquisarPorId(Integer.parseInt(txtId.getText()));
					if (i != null) {
						txtId.setText(Integer.toString(i.getId()));
						txtInstituicao.setText(i.getNome());
						txtLogradouro.setText(i.getEndereco());
						txtNum.setText(i.getNumero());
						txtCep.setText(i.getCep());
						txtEstado.setText(i.getEstado());
						txtCidade.setText(i.getCidade());
						cmbPais.setSelectedItem(Paises.valueOf(i.getPais().replace(' ', '_')));

						txtContato.setText(i.getContato());
						txtTelefone.setText(i.getTelefone());
						txtEmail.setText(i.getEmail());
						txtCargo.setText(i.getCargo());
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma Instituição encontrada");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Digite o código antes de pesquisar");
				}
			}
		});
		btnPesquisar.setBounds(231, 23, 89, 23);
		frmInstituio.getContentPane().add(btnPesquisar);

	}

	private void limparForm() {
		txtId.setText("");
		txtInstituicao.setText("");
		txtLogradouro.setText("");
		txtNum.setText("");
		txtCep.setText("");
		txtEstado.setText("");
		txtCidade.setText("");
		cmbPais.setSelectedIndex(0);

		txtContato.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtCargo.setText("");
	}
}
