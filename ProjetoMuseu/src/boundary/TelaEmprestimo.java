package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;

import controller.EmprestimoController;
import controller.InstituicaoController;
import controller.ObraController;
import entity.Emprestimo;
import entity.Instituicao;
import entity.Obra;
import util.ObraTableModel;
import javax.swing.DefaultComboBoxModel;

public class TelaEmprestimo {

	private JFrame frame;
	private JTable tblObras;
	private JTextField txtNSolicitacao;
	private JTextField txtInstituicao;
	private JTextField txtTituloExibicao;
	private JTextField txtDtEmprestimo;
	private JTextField txtDtDevolucao;
	private JTextField txtObra;
	private JTextField txtTitulo;
	private ObraTableModel tableModel;
	private JTextField txtObservacao;
	private JButton btnSalvar, btnPesquisar, btnLimpar, btnAdiciona, btnVoltar;
	private JComboBox<String> cmbStatus, cmbInstituicao, cmbObra;
	private List<Instituicao> iList;
	private List<Obra> oList;
	private List<Obra> tableObraList = new ArrayList<Obra>();

	private JList<String> list = new JList<String>();
	private JScrollPane pane = new JScrollPane();
	private ResultWindow r = new ResultWindow();

	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestimo window = new TelaEmprestimo();
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
	public TelaEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 612);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JLabel lblNSolicitao = new JLabel("N\u00BA Solicita\u00E7\u00E3o :");
		lblNSolicitao.setBounds(25, 25, 92, 14);
		frame.getContentPane().add(lblNSolicitao);

		txtNSolicitacao = new JTextField();
		txtNSolicitacao.setBounds(125, 22, 86, 20);
		frame.getContentPane().add(txtNSolicitacao);
		txtNSolicitacao.setColumns(10);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(355, 28, 46, 14);
		frame.getContentPane().add(lblStatus);

		cmbStatus = new JComboBox();
		cmbStatus.setModel(
				new DefaultComboBoxModel(new String[] { "Em an\u00E1lise", "Deferido", "Indeferido", "Cancelado" }));
		cmbStatus.setBounds(411, 25, 121, 20);
		frame.getContentPane().add(cmbStatus);

		JLabel lblEmprstimoPara = new JLabel("Empr\u00E9stimo para :");
		lblEmprstimoPara.setBounds(25, 62, 115, 14);
		frame.getContentPane().add(lblEmprstimoPara);

		txtInstituicao = new JTextField();
		txtInstituicao.setBounds(133, 59, 78, 20);
		frame.getContentPane().add(txtInstituicao);
		txtInstituicao.setColumns(10);

		InstituicaoController ic = new InstituicaoController();
		iList = ic.carregarTodos();
		cmbInstituicao = new JComboBox();
		for (Instituicao i : iList) {
			cmbInstituicao.addItem(i.getNome());
		}
		cmbInstituicao.setBounds(221, 59, 336, 20);
		frame.getContentPane().add(cmbInstituicao);

		JLabel lblTtuloDaExibio = new JLabel("T\u00EDtulo da Exibi\u00E7\u00E3o :");
		lblTtuloDaExibio.setBounds(25, 99, 115, 14);
		frame.getContentPane().add(lblTtuloDaExibio);

		txtTituloExibicao = new JTextField();
		txtTituloExibicao.setBounds(143, 96, 414, 20);
		frame.getContentPane().add(txtTituloExibicao);
		txtTituloExibicao.setColumns(10);

		JLabel lblDataEmprstimo = new JLabel("Data Empr\u00E9stimo :");
		lblDataEmprstimo.setBounds(25, 136, 115, 14);
		frame.getContentPane().add(lblDataEmprstimo);

		txtDtEmprestimo = new JTextField();
		txtDtEmprestimo.setBounds(153, 133, 86, 20);
		frame.getContentPane().add(txtDtEmprestimo);
		txtDtEmprestimo.setColumns(10);

		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o :");
		lblDataDevoluo.setBounds(296, 136, 106, 14);
		frame.getContentPane().add(lblDataDevoluo);

		txtDtDevolucao = new JTextField();
		txtDtDevolucao.setBounds(412, 133, 86, 20);
		frame.getContentPane().add(txtDtDevolucao);
		txtDtDevolucao.setColumns(10);

		JLabel lblObra = new JLabel("Obra :");
		lblObra.setBounds(25, 177, 46, 14);
		frame.getContentPane().add(lblObra);

		txtObra = new JTextField();
		txtObra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (r.isVisible()) {
					r.setVisible(false);
				}
				if (arg0.getKeyChar() == '\n') {
					initiateSearch(txtObra.getText());
				}
			}
		});
		txtObra.setBounds(75, 174, 106, 20);
		frame.getContentPane().add(txtObra);

		JLabel lblTtulo = new JLabel("T\u00EDtulo :");
		lblTtulo.setBounds(25, 215, 46, 14);
		frame.getContentPane().add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(75, 212, 359, 20);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);

		ObraController oc = new ObraController();
		oList = oc.carregarTodos();
		cmbObra = new JComboBox();
		for (Obra o : oList) {
			cmbObra.addItem(o.getTitulo());
		}
		cmbObra.setBounds(191, 174, 307, 20);
		frame.getContentPane().add(cmbObra);

		/*--------------- TABELA OBRAS ----------------------*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 261, 485, 135);
		frame.getContentPane().add(scrollPane);
		// String[] cabecalho = { "Título da Obra" };
		// modelo = new TabelaController(new Object[][] {}, cabecalho);
		tblObras = new JTable();
		tblObras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int row = tblObras.rowAtPoint(arg0.getPoint());
					if (row >= 0) {
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Deseja removar a obra: " + tableModel.getValueAt(row, 0) + " da lista?", "Warning",
								JOptionPane.YES_NO_OPTION);
						if (dialogResult == JOptionPane.YES_OPTION) {
							oList.add(tableObraList.get(row));
							tableObraList.remove(row);
							tableModel.removeObra(row);
							cmbObra.removeAllItems();
							for (Obra o : oList) {
								cmbObra.addItem(o.getTitulo());
							}
						}
					}
				}
			}
		});
		tableModel = new ObraTableModel();
		tblObras.setModel(tableModel);
		scrollPane.setViewportView(tblObras);

		/*--------------- FIM TABELA OBRAS ------------------*/

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o :");
		lblObservao.setBounds(47, 424, 86, 14);
		frame.getContentPane().add(lblObservao);

		txtObservacao = new JTextField();
		txtObservacao.setBounds(47, 449, 485, 60);
		frame.getContentPane().add(txtObservacao);
		txtObservacao.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emprestimo emp = new Emprestimo();
				try {
					int idAux = txtNSolicitacao.getText().isEmpty() ? id : Integer.parseInt(txtNSolicitacao.getText());
					emp.setId(idAux);
				} catch (NumberFormatException n) {
					emp.setId(0);
				}
				emp.setStatus(cmbStatus.getSelectedItem().toString());
				txtInstituicao.setText("");
				emp.setInstituicao(iList.get(cmbInstituicao.getSelectedIndex()));
				emp.setTituloExibicao(txtTituloExibicao.getText());
				emp.setDataEmprestimo(new Date(txtDtEmprestimo.getText()));
				emp.setDataDevolucao(new Date(txtDtDevolucao.getText()));
				txtObra.setText("");
				txtTitulo.setText("");
				emp.setObras(tableModel.getListaDeObras());
				emp.setObservacao(txtObservacao.getText());

				EmprestimoController ec = new EmprestimoController();
				if (ec.verificarEmprestimo(emp)) {
					if (ec.salvarEmprestimo(emp)) {
						JOptionPane.showMessageDialog(null, "Emprestimo salvo com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao salvar o Emprestimo");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
				}

			}
		});
		btnSalvar.setBounds(479, 550, 89, 23);
		frame.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 550, 89, 23);
		frame.getContentPane().add(btnVoltar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparForm();
			}
		});
		btnLimpar.setBounds(370, 550, 89, 23);
		frame.getContentPane().add(btnLimpar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNSolicitacao.getText().isEmpty()) {
					EmprestimoController ec = new EmprestimoController();
					Emprestimo emp = ec.pesquisarPorId(Integer.parseInt(txtNSolicitacao.getText()));
					if (emp != null) {
						id = emp.getId();
						txtNSolicitacao.setText(Integer.toString(emp.getId()));
						cmbStatus.setSelectedItem(emp.getStatus());
						// txtInstituicao;
						cmbInstituicao.setSelectedItem(emp.getInstituicao().getNome());
						txtTituloExibicao.setText(emp.getTituloExibicao());
						txtDtEmprestimo.setText(emp.getDataEmprestimo().toString());
						txtDtDevolucao.setText(emp.getDataDevolucao().toString());
						// cmbObra;
						txtObra.setText("");
						txtTitulo.setText("");

						tableModel.addListaDeObras(emp.getObras());

						txtObservacao.setText(emp.getObservacao());
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum Empréstimo foi encontrado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite um Nº de Solicitação antes de pesquisar");
				}
			}
		});
		btnPesquisar.setBounds(228, 21, 106, 23);
		frame.getContentPane().add(btnPesquisar);

		btnAdiciona = new JButton("+");
		btnAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbObra.getItemCount() > 0) {
					tableModel.addObra(oList.get(cmbObra.getSelectedIndex()));
					tableObraList.add(oList.get(cmbObra.getSelectedIndex()));
					oList.remove(cmbObra.getSelectedIndex());
					cmbObra.removeAllItems();
					for (Obra o : oList) {
						cmbObra.addItem(o.getTitulo());
					}
				}
			}
		});
		btnAdiciona.setBounds(444, 211, 46, 23);
		frame.getContentPane().add(btnAdiciona);

	}

	private void limparForm() {
		id = 0;
		txtNSolicitacao.setText("");
		cmbStatus.setSelectedItem(0);
		txtInstituicao.setText("");
		cmbInstituicao.setSelectedIndex(0);
		txtTituloExibicao.setText("");
		txtDtEmprestimo.setText("");
		txtDtDevolucao.setText("");
		oList.addAll(tableObraList);
		tableObraList.removeAll(tableObraList);
		cmbObra.removeAllItems();
		for (Obra o : oList) {
			cmbObra.addItem(o.getTitulo());
		}
		txtObra.setText("");
		txtTitulo.setText("");
		tableModel.limpar();
		tblObras.setModel(tableModel);
		txtObservacao.setText("");
	}

	public void initiateSearch(String lookFor) {
		Vector<String> matches = new Vector<>();
		lookFor = lookFor.toLowerCase();
		for (Obra each : oList) {
			if (each.getTitulo().toLowerCase().contains(lookFor)) {
				matches.add(each.getTitulo());
				System.out.println("Match: " + each);
			}
		}
		r.repaint();

		if (matches.size() != 0) {
			list.setListData(matches);
			r.searchResult = list;
			r.pane = pane;
			r.initiateDisplay();
		} else {
			matches.add("No Match Found");
			list.setListData(matches);
			r.searchResult = list;
			r.pane = pane;
			r.initiateDisplay();
		}

	}

	// ------------------------------------------------------------------------------
	@SuppressWarnings("serial")
	public class ResultWindow extends JWindow {
		public JScrollPane pane;
		public JList<String> searchResult;

		// ------------------------------------------------------------------------------
		public ResultWindow() {

		}

		// ------------------------------------------------------------------------------
		public void initiateDisplay() {
			pane.setViewportView(searchResult);
			add(pane);
			pack();
			this.setLocation(txtObra.getX() + 2, txtObra.getY() + txtObra.getHeight());
			// this.setPreferredSize(city.getPreferredSize());
			this.setVisible(true);
		}
	}

}
