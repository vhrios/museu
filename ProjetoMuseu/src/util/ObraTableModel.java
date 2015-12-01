package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Obra;

@SuppressWarnings("serial")
public class ObraTableModel extends AbstractTableModel {

	private static final int TITULO = 0;
	private static final int TIPO = 1;
	private static final int AUTOR = 2;

	private String[] colunas = new String[] { "Título", "Tipo", "Autor" };
	private List<Obra> linhas;

	public ObraTableModel() {
		linhas = new ArrayList<Obra>();
	}

	public ObraTableModel(List<Obra> listaDeObras) {
		linhas = new ArrayList<Obra>(listaDeObras);
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	};

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case TITULO:
			return String.class;
		case TIPO:
			return String.class;
		case AUTOR:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		Obra o = linhas.get(rowIndex);

		switch (colIndex) {
		case TITULO:
			return o.getTitulo();
		case TIPO:
			return o.getTipo();
		case AUTOR:
			return o.getAutor().getNome();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public Obra getObra(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public List<Obra> getListaDeObras() {
		List<Obra> oList = new ArrayList<Obra>();
		for (Object o : linhas.toArray()) {
			oList.add((Obra) o);
		}
		return oList;
	}

	public void addObra(Obra o) {
		linhas.add(o);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeObra(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeObras(List<Obra> obras) {
		int indice = getRowCount();
		linhas.addAll(obras);
		fireTableRowsInserted(indice, indice + obras.size());
	}

	public void limpar() {
		linhas.clear();
		fireTableDataChanged();
	}
}
