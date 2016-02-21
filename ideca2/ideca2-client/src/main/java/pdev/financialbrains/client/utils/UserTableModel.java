package pdev.financialbrains.client.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.AccountManagementDelegate;
import pdev.financialbrains.ejb.entities.User;

public class UserTableModel  extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<User> Users = new ArrayList<User>();
	String[] entete = {"IdUser","login","password" };
	
	public UserTableModel() {
		Users=AccountManagementDelegate.getProxy().readAll();
				
	}
	
	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return Users.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return Users.get(arg0).getIdUser();
		case 1:
			return Users.get(arg0).getLogin();
		case 2:
			return Users.get(arg0).getPassword();
		
		default:
			return null;
		}
	}
	@Override
	public String getColumnName(int arg0) {
		return entete[arg0];
	}
	@Override
	public void fireTableRowsUpdated(int arg0, int arg1) {
		super.fireTableRowsUpdated(arg0, arg1);
	}

	
	

}
