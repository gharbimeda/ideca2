package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.ejb.entities.Generic;

public class NewProductTableModel extends AbstractTableModel {


	public List<Generic> generics; 
	String[] entete = { "Attribute","Value","Type" };
	private static final long serialVersionUID = 1L;
	
	public NewProductTableModel(String[] s) {
		
	}
	
	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return generics.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getColumnName(int column){
		return entete[column];
	}

}
