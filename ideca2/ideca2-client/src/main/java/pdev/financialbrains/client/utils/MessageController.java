package pdev.financialbrains.client.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.MessageManagementDelegate;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.User;

public class MessageController extends AbstractTableModel {
	List<Message> subjectlist = new ArrayList<Message>();
	public static User userconnect;

	String[] header = { "id", "Date", "Content", "Destination" };

	@Override
	public int getRowCount() {
		return subjectlist.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	public MessageController() {
		subjectlist = MessageManagementDelegate.getInstance().doRead(Util.userConnect.getIdUser());
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return subjectlist.get(rowIndex).getId();
		case 1:
			return subjectlist.get(rowIndex).getDate();
		case 2:
			return subjectlist.get(rowIndex).getTexte();
		case 3:
			return subjectlist.get(rowIndex).getUserDest().getLogin();

		default:
			return null;
		}
	}

	public String getColumnName(int column) {
		return header[column];
	}

}
