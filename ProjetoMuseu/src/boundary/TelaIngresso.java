
package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import entity.Ingresso;

public class TelaIngresso {

	private JFrame frmIngresso;
	private JTextField txtEvento;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	private JTextField txtQtdIngresso;
	private JButton btnSalvar, btnVoltar;
	private JTextField txtHorario;
	private JRadioButton rdbtnNao, rdbtnSim;
	private JFormattedTextField txtSemana, txtFds;

	DecimalFormat dFormat;
	NumberFormatter formatter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIngresso window = new TelaIngresso();
					window.frmIngresso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaIngresso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmIngresso = new JFrame();
		frmIngresso.setTitle("Ingresso");
		frmIngresso.setBounds(100, 100, 661, 295);
		frmIngresso.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmIngresso.getContentPane().setLayout(null);
		frmIngresso.setResizable(false);

		JLabel lblNomeDoEvento = new JLabel("Nome do Evento :");
		lblNomeDoEvento.setBounds(42, 33, 108, 14);
		frmIngresso.getContentPane().add(lblNomeDoEvento);

		txtEvento = new JTextField();
		txtEvento.setBounds(152, 30, 419, 20);
		frmIngresso.getContentPane().add(txtEvento);
		txtEvento.setColumns(10);

		JLabel lblIncio = new JLabel("In\u00EDcio :");
		lblIncio.setBounds(42, 74, 46, 14);
		frmIngresso.getContentPane().add(lblIncio);

		txtDataInicio = new JTextField();
		javax.swing.text.MaskFormatter data;
		try {
			data = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataInicio = new javax.swing.JFormattedTextField(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataInicio.setBounds(98, 71, 86, 20);
		frmIngresso.getContentPane().add(txtDataInicio);
		txtDataInicio.setColumns(10);

		JLabel lblFim = new JLabel("Fim : ");
		lblFim.setBounds(42, 105, 46, 14);
		frmIngresso.getContentPane().add(lblFim);

		txtDataFim = new JTextField();
		javax.swing.text.MaskFormatter dataFim;
		try {
			dataFim = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataFim = new javax.swing.JFormattedTextField(dataFim);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataFim.setBounds(98, 102, 86, 20);
		frmIngresso.getContentPane().add(txtDataFim);
		txtDataFim.setColumns(10);

		JLabel lblHorrio = new JLabel("Hor\u00E1rio :");
		lblHorrio.setBounds(282, 74, 58, 14);
		frmIngresso.getContentPane().add(lblHorrio);

		txtHorario = new JTextField();
		javax.swing.text.MaskFormatter hora;
		try {
			hora = new javax.swing.text.MaskFormatter("##:##");
			txtHorario = new javax.swing.JFormattedTextField(hora);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtHorario.setBounds(282, 94, 67, 20);
		frmIngresso.getContentPane().add(txtHorario);
		txtHorario.setColumns(10);

		JLabel lblExibioEspecial = new JLabel("Exibi\u00E7\u00E3o Especial ");
		lblExibioEspecial.setBounds(476, 74, 136, 14);
		frmIngresso.getContentPane().add(lblExibioEspecial);

		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(476, 96, 58, 23);
		frmIngresso.getContentPane().add(rdbtnSim);

		rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setSelected(true);
		rdbtnNao.setBounds(556, 96, 56, 23);
		frmIngresso.getContentPane().add(rdbtnNao);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNao);
		bg.add(rdbtnSim);

		JLabel lblQuantidadeDeIngresso = new JLabel("Qtd Ingresso :");
		lblQuantidadeDeIngresso.setBounds(42, 163, 99, 14);
		frmIngresso.getContentPane().add(lblQuantidadeDeIngresso);

		txtQtdIngresso = new JTextField();
		txtQtdIngresso.setBounds(139, 160, 67, 20);
		frmIngresso.getContentPane().add(txtQtdIngresso);
		txtQtdIngresso.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o :");
		lblPreo.setBounds(279, 141, 46, 14);
		frmIngresso.getContentPane().add(lblPreo);

		JLabel lblSemana = new JLabel("Semana : R$");
		lblSemana.setBounds(266, 163, 83, 14);
		frmIngresso.getContentPane().add(lblSemana);

		JLabel lblFimDeSem = new JLabel("Fim de Sem. : R$");
		lblFimDeSem.setBounds(440, 163, 99, 14);
		frmIngresso.getContentPane().add(lblFimDeSem);

		dFormat = new DecimalFormat("#,###,###0.00");
		formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);

		txtSemana = new JFormattedTextField();
		txtSemana.setFormatterFactory(new DefaultFormatterFactory(formatter));
		txtSemana.setBounds(341, 160, 76, 20);
		frmIngresso.getContentPane().add(txtSemana);

		txtFds = new JFormattedTextField();
		DecimalFormat df = new DecimalFormat("#,###,###0.00");
		NumberFormatter nf = new NumberFormatter(df);
		nf.setFormat(df);
		nf.setAllowsInvalid(false);
		txtFds.setFormatterFactory(new DefaultFormatterFactory(nf));
		txtFds.setBounds(536, 160, 76, 20);
		frmIngresso.getContentPane().add(txtFds);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarCampos();
				
			}
		});
		btnSalvar.setBounds(546, 223, 89, 23);
		frmIngresso.getContentPane().add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 223, 89, 23);
		frmIngresso.getContentPane().add(btnVoltar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNovo.setBounds(421, 223, 89, 23);
		frmIngresso.getContentPane().add(btnNovo);
	}

	private void validarCampos() {
		if (!"".equals(txtEvento.getText()) && !"".equals(txtDataInicio.getText()) && !"".equals(txtDataFim.getText())
				&& !"".equals(txtHorario.getText()) && !"".equals(txtQtdIngresso.getText())
				&& !"".equals(txtSemana.getText()) && !"".equals(txtDataFim.getText())) {

			Ingresso ingresso = null;
			Exposicao e = null;
			IngressoController ic = new IngressoController();
			e = salvaExposicao();
			ic.salvaExposicao(e);
			ingresso = salvaIngresso();
			ic.salvaIngresso(ingresso);

		} else {
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos", "Alerta", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public Ingresso salvaIngresso() {

		Ingresso i = new Ingresso();
		i.setLimiteIngresso(Integer.parseInt(txtQtdIngresso.getText()));
		i.setPrecoSemana(Float.parseFloat(txtSemana.getText().replaceAll(",", ".")));
		i.setPrecoFimDeSemana(Float.parseFloat(txtFds.getText().replaceAll(",", ".")));

		return i;
	}

	private void limparCampos() {

		txtEvento.setText("");
		txtDataInicio.setText("");
		txtDataFim.setText("");
		txtHorario.setText("");
		rdbtnNao.setSelected(true);
		txtQtdIngresso.setText("");
		txtSemana.setValue(null);
		txtFds.setValue(null);

	}
}
