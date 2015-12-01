package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.AutorController;
import controller.InstituicaoController;
import controller.ObraController;
import entity.Autor;
import entity.Instituicao;
import entity.Obra;

@SuppressWarnings("rawtypes")
public class TelaObra {

	private JFrame frmObra;
	private JTextField txtIdentificador;
	private JTextField txtTitulo;
	private JTextField txtApelido;
	private JLabel lblCategoria;
	private JComboBox<String> cmbCategoria, cmbNomeAutor, cmbMovimento, cmbEpoca;
	private JLabel lblTipo;
	private JComboBox<String> cmbTipo, cmbDoador;
	private JLabel lblTcnica;
	private JComboBox cmbTecnica;
	private JLabel lblData;
	private JTextField txtData;
	private JTextField txtNomeAutor;
	private JTextField txtAltura;
	private JTextField txtLargura;
	private JTextField txtProfundidade;
	private JTextField txtValor;
	private JTextField txtDoador;
	private JTextField txtBiografia;
	private JButton btnPesquisar, btnSalvar, btnVoltar;
	private JButton btnNovo;
	private List<Instituicao> iList;
	private List<Autor> aList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaObra window = new TelaObra();
					window.frmObra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaObra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void initialize() {
		frmObra = new JFrame();
		frmObra.setTitle("Obra");
		frmObra.setBounds(100, 100, 584, 592);
		frmObra.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmObra.getContentPane().setLayout(null);
		frmObra.setResizable(false);

		JLabel lblIdentificador = new JLabel("Identificador :");
		lblIdentificador.setBounds(30, 25, 83, 14);
		frmObra.getContentPane().add(lblIdentificador);

		txtIdentificador = new JTextField();
		txtIdentificador.setBounds(123, 22, 103, 20);
		frmObra.getContentPane().add(txtIdentificador);
		txtIdentificador.setColumns(10);

		JLabel lblTtulo = new JLabel("*T\u00EDtulo :");
		lblTtulo.setBounds(63, 65, 57, 14);
		frmObra.getContentPane().add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(119, 62, 390, 20);
		frmObra.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblApelido = new JLabel("Apelido :");
		lblApelido.setBounds(63, 93, 57, 14);
		frmObra.getContentPane().add(lblApelido);

		txtApelido = new JTextField();
		txtApelido.setBounds(119, 90, 390, 20);
		frmObra.getContentPane().add(txtApelido);
		txtApelido.setColumns(10);

		lblCategoria = new JLabel("*Categoria :");
		lblCategoria.setBounds(63, 127, 73, 14);
		frmObra.getContentPane().add(lblCategoria);

		cmbCategoria = new JComboBox();
		cmbCategoria.setBounds(129, 124, 136, 20);
		frmObra.getContentPane().add(cmbCategoria);

		lblTipo = new JLabel("*Tipo :");
		lblTipo.setBounds(286, 127, 46, 14);
		frmObra.getContentPane().add(lblTipo);

		cmbTipo = new JComboBox();
		cmbTipo.setBounds(324, 124, 185, 20);
		frmObra.getContentPane().add(cmbTipo);

		lblTcnica = new JLabel("T\u00E9cnica :");
		lblTcnica.setBounds(63, 166, 57, 14);
		frmObra.getContentPane().add(lblTcnica);

		cmbTecnica = new JComboBox();
		cmbTecnica.setBounds(119, 163, 146, 20);
		frmObra.getContentPane().add(cmbTecnica);

		lblData = new JLabel("Data :");
		lblData.setBounds(286, 166, 46, 14);
		frmObra.getContentPane().add(lblData);

		txtData = new JTextField();
		txtData.setBounds(324, 163, 86, 20);
		frmObra.getContentPane().add(txtData);
		txtData.setColumns(10);

		cmbEpoca = new JComboBox();
		cmbEpoca.setBounds(431, 163, 65, 20);
		frmObra.getContentPane().add(cmbEpoca);

		JLabel lblMovimento = new JLabel("*Movimento :");
		lblMovimento.setBounds(63, 202, 73, 14);
		frmObra.getContentPane().add(lblMovimento);

		cmbMovimento = new JComboBox();
		cmbMovimento.setBounds(141, 199, 146, 20);
		frmObra.getContentPane().add(cmbMovimento);

		JLabel lblAutor = new JLabel("Autor :");
		lblAutor.setBounds(63, 233, 46, 14);
		frmObra.getContentPane().add(lblAutor);

		txtNomeAutor = new JTextField();
		txtNomeAutor.setBounds(106, 230, 86, 20);
		frmObra.getContentPane().add(txtNomeAutor);
		txtNomeAutor.setColumns(10);

		AutorController ac = new AutorController();
		aList = ac.carregarTodos();
		cmbNomeAutor = new JComboBox<String>();
		for (Autor a : aList) {
			cmbNomeAutor.addItem(a.getNome());
		}
		cmbNomeAutor.setBounds(231, 230, 278, 20);
		frmObra.getContentPane().add(cmbNomeAutor);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "*Dimens\u00F5es", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(30, 273, 528, 62);
		frmObra.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAltura = new JLabel("Altura :");
		lblAltura.setBounds(23, 22, 58, 14);
		panel.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setBounds(68, 19, 73, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblLargura = new JLabel("Largura :");
		lblLargura.setBounds(184, 22, 65, 14);
		panel.add(lblLargura);

		txtLargura = new JTextField();
		txtLargura.setBounds(240, 19, 73, 20);
		panel.add(txtLargura);
		txtLargura.setColumns(10);

		JLabel lblProfundidade = new JLabel("Profundidade :");
		lblProfundidade.setBounds(347, 22, 88, 14);
		panel.add(lblProfundidade);

		txtProfundidade = new JTextField();
		txtProfundidade.setBounds(426, 19, 76, 20);
		panel.add(txtProfundidade);
		txtProfundidade.setColumns(10);

		JLabel lblValor = new JLabel("Valor :");
		lblValor.setBounds(50, 377, 46, 14);
		frmObra.getContentPane().add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(93, 374, 86, 20);
		frmObra.getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JLabel lblDoador = new JLabel("*Doador :");
		lblDoador.setBounds(40, 349, 57, 14);
		frmObra.getContentPane().add(lblDoador);

		InstituicaoController ic = new InstituicaoController();
		iList = ic.carregarTodos();
		cmbDoador = new JComboBox<String>();
		for (Instituicao i : iList) {
			cmbDoador.addItem(i.getNome());
		}
		cmbDoador.setBounds(219, 346, 278, 20);
		frmObra.getContentPane().add(cmbDoador);

		txtDoador = new JTextField();
		txtDoador.setBounds(94, 346, 86, 20);
		frmObra.getContentPane().add(txtDoador);
		txtDoador.setColumns(10);

		JLabel lblDadosBiogrficos = new JLabel("*Dados Biogr\u00E1ficos :");
		lblDadosBiogrficos.setBounds(50, 411, 142, 14);
		frmObra.getContentPane().add(lblDadosBiogrficos);

		txtBiografia = new JTextField();
		txtBiografia.setBounds(45, 436, 513, 62);
		frmObra.getContentPane().add(txtBiografia);
		txtBiografia.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obra o = new Obra();
				o.setId(Integer.parseInt(txtIdentificador.getText()));
				o.setTitulo(txtTitulo.getText());
				o.setApelido(txtApelido.getText());
				o.setCategoria(cmbCategoria.getSelectedItem().toString());
				o.setTipo(cmbTipo.getSelectedItem().toString());
				cmbTecnica.getSelectedItem();
				o.setMovimento(cmbMovimento.getSelectedItem().toString());
				o.setAutor(aList.get(cmbNomeAutor.getSelectedIndex()));
				o.setDia(Integer.parseInt(txtData.getText().substring(0, 1)));
				o.setMes(Integer.parseInt(txtData.getText().substring(2, 3)));
				o.setAno(Integer.parseInt(txtData.getText().substring(4)));
				o.setPeriodo(cmbEpoca.getSelectedItem().toString());
				o.setAltura((Float.parseFloat(txtAltura.getText())));
				o.setLargura((Float.parseFloat(txtLargura.getText())));
				o.setProfundidade(Float.parseFloat(txtProfundidade.getText()));
				o.setValor(Double.parseDouble(txtValor.getText()));
				o.setBiografia(txtBiografia.getText());
				o.setInstituicao(iList.get(cmbDoador.getSelectedIndex()));

				ObraController oc = new ObraController();

				if (oc.verificarObra(o)) {
					if (oc.salvarObra(o)) {
						JOptionPane.showMessageDialog(null, "Obra salva com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao salvar a Obra");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
				}
			}
		});
		btnSalvar.setBounds(479, 530, 89, 23);
		frmObra.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 530, 89, 23);
		frmObra.getContentPane().add(btnVoltar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtIdentificador.getText().isEmpty()) {
					ObraController oc = new ObraController();
					Obra o = new Obra();
					o = oc.pesquisarObra(Integer.parseInt(txtIdentificador.getText()));
					if (o != null) {
						txtIdentificador.setText(Integer.toString(o.getId()));
						txtTitulo.setText(o.getTitulo());
						txtApelido.setText(o.getApelido());
						cmbCategoria.setSelectedItem(o.getCategoria());
						cmbTipo.setSelectedItem(o.getTipo());
						// cmbTecnica.setSelectedItem();
						cmbMovimento.setSelectedItem(o.getMovimento());
						cmbNomeAutor.setSelectedItem(o.getAutor().getNome());
						txtData.setText(o.getDia() + "/" + o.getMes() + "/" + o.getAno());
						cmbEpoca.setSelectedItem(o.getPeriodo());
						txtAltura.setText(Float.toString(o.getAltura()));
						txtLargura.setText(Float.toString(o.getLargura()));
						txtProfundidade.setText(Float.toString(o.getProfundidade()));
						txtValor.setText(Double.toString(o.getValor()));
						txtBiografia.setText(o.getBiografia());
						cmbDoador.setSelectedItem(o.getInstituicao().getNome());
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma obra encontrada");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite o codigo identificador antes de pesquisar");
				}
			}
		});
		btnPesquisar.setBounds(236, 21, 89, 23);
		frmObra.getContentPane().add(btnPesquisar);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparForm();
			}
		});
		btnNovo.setBounds(380, 530, 89, 23);
		frmObra.getContentPane().add(btnNovo);

	}

	private void limparForm() {
		txtIdentificador.setText("");
		txtTitulo.setText("");
		txtApelido.setText("");
		cmbCategoria.setSelectedIndex(0);
		cmbTipo.setSelectedItem(0);
		cmbTecnica.setSelectedItem(0);
		cmbMovimento.setSelectedItem(0);
		txtNomeAutor.setText("");
		cmbNomeAutor.setSelectedItem(0);
		txtData.setText("");
		cmbEpoca.setSelectedIndex(0);
		txtAltura.setText("");
		txtLargura.setText("");
		txtProfundidade.setText("");
		txtValor.setText("");
		txtBiografia.setText("");
		txtDoador.setText("");
		cmbDoador.setSelectedIndex(0);
	}
}
