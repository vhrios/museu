package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.GraficoController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import util.Tupla;

public class TelaGrafico implements ActionListener {

	private static final int frmX = 100;
	private static final int frmY = 100;
	private static final int frmW = 664;
	private static final int frmH = 481;

	private JFrame frmGrafico;
	private List<Tupla<String, Integer>> lista;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGrafico window = new TelaGrafico();
					window.frmGrafico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaGrafico() {
		initialize();
	}

	private static void initFxLater(JFXPanel panel, List<Tupla<String, Integer>> lista, String titulo) {
		Group root = new Group();
		Scene scene = new Scene(root, frmW + 100, frmH - 100);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < lista.size(); i++) {
			pieChartData.add(new PieChart.Data(lista.get(i).x, lista.get(i).y));
		}
		PieChart chart = new PieChart(pieChartData);
		chart.setTitle(titulo);
		chart.setLabelLineLength(10);
		// chart.setLegendVisible(false);
		chart.setLegendSide(Side.RIGHT);

		((Group) scene.getRoot()).getChildren().add(chart);

		panel.setScene(scene);
	}

	@SuppressWarnings({ "deprecation" })
	private void initialize() {
		frmGrafico = new JFrame();
		frmGrafico.setTitle("Grafico dos Visitantes");
		frmGrafico.setBounds(frmX, frmY, frmW, frmH);
		frmGrafico.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmGrafico.getContentPane().setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGrafico.dispose();
			}
		});
		btnVoltar.setBounds(10, 394, 108, 38);
		btnVoltar.addActionListener(this);
		frmGrafico.getContentPane().add(btnVoltar);

		JLabel lblFiltro = new JLabel("Filtrar por :");
		lblFiltro.setBounds(10, 14, 54, 14);
		// frmGrafico.getContentPane().add(lblFiltro);

		final JFXPanel jFXPanel = new JFXPanel();
		jFXPanel.setBounds(10, 40, 628, 343);
		frmGrafico.getContentPane().add(jFXPanel);

		JComboBox<String> cmbFiltro = new JComboBox<String>();
		cmbFiltro.setBounds(10, 11, 196, 20);
		cmbFiltro.setModel(new DefaultComboBoxModel<String>(new String[] { "Escolha o filtro por...", "Idade", "Sexo",
				"Nacionalidade", "Nível acadêmico", "Meio de locomoção" }));
		cmbFiltro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				GraficoController gc = new GraficoController();
				switch (cmbFiltro.getSelectedItem().toString()) {
				case "Idade":
					lista = gc.gerarIdade();
					break;

				case "Sexo":
					lista = gc.gerarSexo();
					break;

				case "Nacionalidade":
					lista = gc.gerarNacionalidade();
					break;

				case "Nível acadêmico":
					lista = gc.gerarNivelAcademico();
					break;

				case "Meio de locomoção":
					lista = gc.gerarLocomocao();
					break;
				}

				if (lista != null) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							initFxLater(jFXPanel, lista, cmbFiltro.getSelectedItem().toString());
						}
					});
				}
			}
		});
		frmGrafico.getContentPane().add(cmbFiltro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Voltar".equals(cmd)) {
			frmGrafico.dispose();
		}
	}
}