package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.AutorController;
import entity.Atividade;
import entity.Autor;
import entity.Meses;
import entity.Paises;
import util.CheckboxListItem;
import util.CheckboxListRenderer;

public class TelaAutor {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtIniAtiv;
	private JTextField txtFimAtiv;
	private JTextField txtDescricao;
	private JButton btnPesquisar, btnSalvar, btnAlterar, btnVoltar, btnNovo;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPais;
	private JTextField txtDiaF;
	private JTextField txtDiaN;
	private JTextField txtAnoN;
	private JTextField txtAnoF;
	private JComboBox<String> cmbMesN;
	private JComboBox<String> cmbMesF;
	private JList<CheckboxListItem> listaAtividades;
	private CheckboxListItem[] cList;
	private int id = 0;

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
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Autor");
		frame.setBounds(100, 100, 585, 530);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNomeCompleto = new JLabel("*Nome Completo:");
		lblNomeCompleto.setBounds(10, 20, 130, 14);
		frame.getContentPane().add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setBounds(141, 17, 285, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data Nascimento:");
		lblDataNasc.setBounds(10, 53, 138, 14);
		frame.getContentPane().add(lblDataNasc);

		JLabel lblPas = new JLabel("Pa\u00EDs :");
		lblPas.setBounds(10, 197, 46, 14);
		frame.getContentPane().add(lblPas);

		cmbPais = new JComboBox();
		for (Paises p : Paises.values()) {
			cmbPais.addItem(p.toString().replace('_', ' '));
		}
		cmbPais.setBounds(71, 194, 162, 20);
		frame.getContentPane().add(cmbPais);

		JLabel lblreasDeAtividade = new JLabel("*\u00C1reas de Atividade :");
		lblreasDeAtividade.setBounds(273, 197, 153, 14);
		frame.getContentPane().add(lblreasDeAtividade);

		JLabel lblIncioAtividade = new JLabel("In\u00EDcio Atividade :");
		lblIncioAtividade.setBounds(10, 257, 130, 14);
		frame.getContentPane().add(lblIncioAtividade);

		txtIniAtiv = new JTextField();
		javax.swing.text.MaskFormatter datai;
		try {
			datai = new javax.swing.text.MaskFormatter("##/##/####");
			txtIniAtiv = new javax.swing.JFormattedTextField(datai);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIniAtiv.setBounds(147, 254, 86, 20);
		frame.getContentPane().add(txtIniAtiv);
		txtIniAtiv.setColumns(10);

		JLabel lblFimAtividade = new JLabel("Fim Atividade :");
		lblFimAtividade.setBounds(10, 289, 112, 14);
		frame.getContentPane().add(lblFimAtividade);

		txtFimAtiv = new JTextField();
		javax.swing.text.MaskFormatter datafa;
		try {
			datafa = new javax.swing.text.MaskFormatter("##/##/####");
			txtFimAtiv = new javax.swing.JFormattedTextField(datafa);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtFimAtiv.setBounds(147, 286, 86, 20);
		frame.getContentPane().add(txtFimAtiv);
		txtFimAtiv.setColumns(10);

		JLabel lblDescrio = new JLabel("*Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(65, 329, 105, 14);
		frame.getContentPane().add(lblDescrio);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(59, 354, 459, 62);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtNome.getText().isEmpty()) {
					AutorController ac = new AutorController();
					Autor a = new Autor();
					a = ac.pesquisarAutor(txtNome.getText());
					if (a != null) {
						id = a.getId();
						txtNome.setText(a.getNome());

						String iniA = String.format("%02d", a.getDiaIniAtv()) + String.format("%02d", a.getMesIniAtv()) + String.format("%04d", a.getAnoIniAtv());
						txtIniAtiv.setText(iniA);
						String fimA = String.format("%02d", a.getDiaFimAtv()) + String.format("%02d", a.getMesFimAtv()) + String.format("%04d", a.getAnoFimAtv());
						txtFimAtiv.setText(fimA);

						txtDescricao.setText(a.getDescricao());
						cmbPais.setSelectedItem(a.getPais());
						txtDiaF.setText(Integer.toString(a.getDiaM()));
						txtDiaN.setText(Integer.toString(a.getDiaN()));
						txtAnoN.setText(Integer.toString(a.getAnoN()));
						txtAnoF.setText(Integer.toString(a.getAnoM()));
						cmbMesN.setSelectedIndex(a.getMesN());
						cmbMesF.setSelectedIndex(a.getMesM());

						for (int i = 0; i < cList.length; i++) {
							for (String s : a.getAtividades()) {
								if (cList[i].getLabel().equals(s))
									listaAtividades.getModel().getElementAt(i).setSelected(true);
							}
						}
						listaAtividades.repaint();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum autor encontrado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite um nome antes de pesquisar");
				}
			}
		});
		btnPesquisar.setBounds(453, 16, 101, 23);
		frame.getContentPane().add(btnPesquisar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Autor a = new Autor();
				a.setId(id);
				a.setNome(txtNome.getText());
				try {
					a.setDiaIniAtv(Integer.parseInt(txtIniAtiv.getText().substring(0, 2)));
				} catch (NumberFormatException n) {
					a.setDiaIniAtv(0);
				}
				try {
					a.setMesIniAtv(Integer.parseInt(txtIniAtiv.getText().substring(3, 5)));
				} catch (NumberFormatException n) {
					a.setMesIniAtv(0);
				}
				try {
					a.setAnoIniAtv(Integer.parseInt(txtIniAtiv.getText().substring(6, 10)));
				} catch (NumberFormatException n) {
					a.setAnoIniAtv(0);
				}
				try {
					a.setDiaFimAtv(Integer.parseInt(txtFimAtiv.getText().substring(0, 2)));
				} catch (NumberFormatException n) {
					a.setDiaFimAtv(0);
				}
				try {
					a.setMesFimAtv(Integer.parseInt(txtFimAtiv.getText().substring(3, 5)));
				} catch (NumberFormatException n) {
					a.setMesFimAtv(0);
				}
				try {
					a.setAnoFimAtv(Integer.parseInt(txtFimAtiv.getText().substring(6, 10)));
				} catch (NumberFormatException n) {
					a.setAnoFimAtv(0);
				}

				a.setDescricao(txtDescricao.getText());
				a.setPais(cmbPais.getSelectedItem().toString());

				try {
					a.setDiaN(Integer.parseInt(txtDiaN.getText()));
				} catch (NumberFormatException n) {
					a.setDiaN(0);
				}
				try {
					a.setDiaM(Integer.parseInt(txtDiaF.getText()));
				} catch (NumberFormatException n) {
					a.setDiaM(0);
				}
				try {
					a.setAnoN(Integer.parseInt(txtAnoN.getText()));
				} catch (NumberFormatException n) {
					a.setAnoN(0);
				}
				try {
					a.setAnoM(Integer.parseInt(txtAnoF.getText()));
				} catch (NumberFormatException n) {
					a.setAnoM(0);
				}

				a.setMesN(cmbMesN.getSelectedIndex());
				a.setMesM(cmbMesF.getSelectedIndex());

				List<String> atvList = new ArrayList<String>();
				for (int i = 0; i < cList.length; i++) {
					if (listaAtividades.getModel().getElementAt(i).isSelected()) {
						atvList.add(listaAtividades.getModel().getElementAt(i).getLabel());
					}
				}
				a.setAtividades(atvList);

				AutorController ac = new AutorController();

				if (ac.verificarAutor(a)) {
					if (ac.salvarAutor(a)) {
						JOptionPane.showMessageDialog(null, "Autor salvo com sucesso");
						limparForm();
						bloquearForm();
					} else {
						JOptionPane.showMessageDialog(null, "Falha ao salvar o Autor");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
				}
			}
		});
		btnSalvar.setBounds(470, 458, 89, 23);
		frame.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 458, 89, 23);
		frame.getContentPane().add(btnVoltar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!txtNome.getText().isEmpty()) {
					desbloquearForm();
				}
			}
		});
		btnAlterar.setBounds(359, 458, 89, 23);
		frame.getContentPane().add(btnAlterar);

		btnNovo = new JButton("Novo");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limparForm();
				desbloquearForm();
			}
		});
		btnNovo.setBounds(250, 458, 89, 23);
		frame.getContentPane().add(btnNovo);

		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(48, 86, 40, 14);
		frame.getContentPane().add(lblDia);

		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(153, 86, 40, 14);
		frame.getContentPane().add(lblMs);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(380, 86, 40, 14);
		frame.getContentPane().add(lblAno);

		cmbMesN = new JComboBox(Meses.values());
		cmbMesN.setBounds(197, 83, 154, 20);
		frame.getContentPane().add(cmbMesN);

		JLabel lblDataFalecimento = new JLabel("Data Falecimento:");
		lblDataFalecimento.setBounds(10, 118, 138, 14);
		frame.getContentPane().add(lblDataFalecimento);

		JLabel label_1 = new JLabel("Dia");
		label_1.setBounds(48, 151, 40, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("M\u00EAs");
		label_2.setBounds(153, 151, 40, 14);
		frame.getContentPane().add(label_2);

		cmbMesF = new JComboBox(Meses.values());
		cmbMesF.setBounds(197, 148, 154, 20);
		frame.getContentPane().add(cmbMesF);

		JLabel label_3 = new JLabel("Ano");
		label_3.setBounds(380, 151, 40, 14);
		frame.getContentPane().add(label_3);

		int t = Atividade.values().length;
		cList = new CheckboxListItem[t];
		for (int i = 0; i < t; i++) {
			cList[i] = new CheckboxListItem(Atividade.values()[i].name().replace('_', ' '));
		}

		listaAtividades = new JList<CheckboxListItem>(cList);
		listaAtividades.setCellRenderer(new CheckboxListRenderer());
		listaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaAtividades.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();

				int index = list.locationToIndex(event.getPoint());
				CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);
				item.setSelected(!item.isSelected());
				list.repaint(list.getCellBounds(index, index));
			}
		});

		listaAtividades.setBounds(273, 227, 281, 79);

		JScrollPane sclAtiv = new JScrollPane(listaAtividades);
		sclAtiv.setBounds(listaAtividades.getBounds());
		frame.getContentPane().add(sclAtiv);

		txtDiaF = new JTextField();
		txtDiaF.setBounds(82, 145, 40, 26);
		frame.getContentPane().add(txtDiaF);
		txtDiaF.setColumns(10);

		txtDiaN = new JTextField();
		txtDiaN.setColumns(10);
		txtDiaN.setBounds(82, 80, 40, 26);
		frame.getContentPane().add(txtDiaN);

		txtAnoN = new JTextField();
		txtAnoN.setColumns(10);
		txtAnoN.setBounds(414, 80, 68, 26);
		frame.getContentPane().add(txtAnoN);

		txtAnoF = new JTextField();
		txtAnoF.setColumns(10);
		txtAnoF.setBounds(414, 145, 68, 26);
		frame.getContentPane().add(txtAnoF);

		bloquearForm();
	}

	private void limparForm() {
		txtNome.setText("");
		txtIniAtiv.setText("");
		txtFimAtiv.setText("");
		txtDescricao.setText("");
		cmbPais.setSelectedIndex(0);
		txtDiaF.setText("");
		txtDiaN.setText("");
		txtAnoN.setText("");
		txtAnoF.setText("");
		cmbMesN.setSelectedIndex(0);
		cmbMesF.setSelectedIndex(0);
		for (int i = 0; i < listaAtividades.getModel().getSize(); i++) {
			listaAtividades.getModel().getElementAt(i).setSelected(false);
			listaAtividades.repaint(listaAtividades.getCellBounds(i, i));
		}
	}

	private void desbloquearForm() {
		txtNome.setEditable(true);
		txtIniAtiv.setEditable(true);
		txtFimAtiv.setEditable(true);
		txtDescricao.setEditable(true);
		cmbPais.setEnabled(true);
		txtDiaF.setEditable(true);
		txtDiaN.setEditable(true);
		txtAnoN.setEditable(true);
		txtAnoF.setEditable(true);
		cmbMesN.setEnabled(true);
		cmbMesF.setEnabled(true);
		for (int i = 0; i < listaAtividades.getModel().getSize(); i++) {
			listaAtividades.getModel().getElementAt(i).setEnabled(true);
			listaAtividades.repaint(listaAtividades.getCellBounds(i, i));
		}
	}

	private void bloquearForm() {
		txtIniAtiv.setEditable(false);
		txtFimAtiv.setEditable(false);
		txtDescricao.setEditable(false);
		cmbPais.setEnabled(false);
		txtDiaF.setEditable(false);
		txtDiaN.setEditable(false);
		txtAnoN.setEditable(false);
		txtAnoF.setEditable(false);
		cmbMesN.setEnabled(false);
		cmbMesF.setEnabled(false);
		listaAtividades.setEnabled(false);
		for (int i = 0; i < listaAtividades.getModel().getSize(); i++) {
			listaAtividades.getModel().getElementAt(i).setEnabled(false);
			listaAtividades.repaint(listaAtividades.getCellBounds(i, i));
		}
	}

}
