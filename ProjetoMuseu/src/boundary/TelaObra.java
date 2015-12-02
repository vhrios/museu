package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import entity.Categoria;
import entity.Instituicao;
import entity.Meses;
import entity.Movimento;
import entity.Obra;

@SuppressWarnings("rawtypes")
public class TelaObra {

	private JFrame frmObra;
	private JTextField txtIdentificador;
	private JTextField txtTitulo;
	private JTextField txtApelido;
	private JLabel lblCategoria;
	private JComboBox<String> cmbCategoria, cmbNomeAutor, cmbMovimento, cmbEpoca;
	private JComboBox<String> cmbDoador;
	private JLabel lblTcnica;
	private JLabel lblData;
	private JTextField txtDia;
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
	private int id;
	private JTextField txtAno;
	private JComboBox cmbMes;
	private JTextField txtTecnica;

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
		for (Categoria c : Categoria.values()) {
			cmbCategoria.addItem(c.toString().replace('_', ' '));
		}
		cmbCategoria.setBounds(129, 124, 136, 20);
		frmObra.getContentPane().add(cmbCategoria);

		lblTcnica = new JLabel("T\u00E9cnica :");
		lblTcnica.setBounds(292, 127, 57, 14);
		frmObra.getContentPane().add(lblTcnica);

		lblData = new JLabel("Dia:");
		lblData.setBounds(67, 200, 46, 14);
		frmObra.getContentPane().add(lblData);

		txtDia = new JTextField();
		txtDia.setBounds(106, 197, 30, 20);
		frmObra.getContentPane().add(txtDia);
		txtDia.setColumns(10);

		cmbEpoca = new JComboBox();
		cmbEpoca.setModel(new DefaultComboBoxModel(new String[] { "a.C.", "d.C." }));
		cmbEpoca.setBounds(460, 197, 65, 20);
		frmObra.getContentPane().add(cmbEpoca);

		JLabel lblMovimento = new JLabel("*Movimento :");
		lblMovimento.setBounds(63, 166, 73, 14);
		frmObra.getContentPane().add(lblMovimento);

		cmbMovimento = new JComboBox();
		for (Movimento m : Movimento.values()) {
			cmbMovimento.addItem(m.toString().replace('_', ' '));
		}
		cmbMovimento.setBounds(139, 163, 146, 20);
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

				try {
					int idAux = txtIdentificador.getText().isEmpty() ? id
							: Integer.parseInt(txtIdentificador.getText());
					o.setId(idAux);
				} catch (NumberFormatException n) {
					o.setId(0);
				}

				o.setTitulo(txtTitulo.getText());
				o.setApelido(txtApelido.getText());
				o.setCategoria(cmbCategoria.getSelectedItem().toString());
				o.setTecnica(txtTecnica.getText());
				o.setMovimento(cmbMovimento.getSelectedItem().toString());
				o.setAutor(aList.get(cmbNomeAutor.getSelectedIndex()));
				o.setDia(Integer.parseInt(txtDia.getText()));
				o.setMes(cmbMes.getSelectedIndex());
				o.setAno(Integer.parseInt(txtAno.getText()));
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
						limparForm();
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmObra.dispose();
			}
		});
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
						id = o.getId();
						txtIdentificador.setText(Integer.toString(o.getId()));
						txtTitulo.setText(o.getTitulo());
						txtApelido.setText(o.getApelido());
						cmbCategoria.setSelectedItem(o.getCategoria());
						txtTecnica.setText(o.getTecnica());
						cmbMovimento.setSelectedItem(o.getMovimento());
						cmbNomeAutor.setSelectedItem(o.getAutor().getNome());
						txtDia.setText(String.format("%02d", o.getDia()));
						cmbMes.setSelectedIndex(o.getMes());
						txtAno.setText(String.format("%04d", o.getAno()));
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

		cmbMes = new JComboBox();
		for (Meses m : Meses.values()) {
			cmbMes.addItem(m.toString().replace('_', ' '));
		}
		cmbMes.setBounds(196, 197, 146, 20);
		frmObra.getContentPane().add(cmbMes);

		JLabel lblMs = new JLabel("M\u00EAs:");
		lblMs.setBounds(151, 200, 46, 14);
		frmObra.getContentPane().add(lblMs);

		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(398, 197, 57, 20);
		frmObra.getContentPane().add(txtAno);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(358, 200, 46, 14);
		frmObra.getContentPane().add(lblAno);

		txtTecnica = new JTextField();
		txtTecnica.setColumns(10);
		txtTecnica.setBounds(369, 124, 140, 20);
		frmObra.getContentPane().add(txtTecnica);

	}

	private void limparForm() {
		id = 0;
		txtIdentificador.setText("");
		txtTitulo.setText("");
		txtApelido.setText("");
		cmbCategoria.setSelectedIndex(0);
		txtTecnica.setText("");
		cmbMovimento.setSelectedIndex(0);
		txtNomeAutor.setText("");
		cmbNomeAutor.setSelectedIndex(0);
		txtDia.setText("");
		cmbMes.setSelectedIndex(0);
		txtAno.setText("");
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
