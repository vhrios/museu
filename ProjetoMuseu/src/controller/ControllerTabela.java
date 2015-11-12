package controller;

import javax.swing.table.DefaultTableModel;

public class ControllerTabela extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;

	public ControllerTabela(Object[][]  dados , String [] cabecalho){
		super.setDataVector(dados, cabecalho);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
