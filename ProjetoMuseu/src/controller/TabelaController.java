package controller;

import javax.swing.table.DefaultTableModel;

public class TabelaController extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;

	public TabelaController(Object[][]  dados , String [] cabecalho){
		super.setDataVector(dados, cabecalho);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
