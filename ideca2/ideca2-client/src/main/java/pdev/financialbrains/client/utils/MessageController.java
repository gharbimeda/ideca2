package pdev.financialbrains.client.utils;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.ejb.entities.Message;

public class MessageController  extends AbstractTableModel{
List<Message> subjectlist = new ArrayList<Message>();
	
	String[] header = { "id","Date","Content", "Destination" };

	@Override
	public int getRowCount() {
		return subjectlist.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
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
			return subjectlist.get(rowIndex).getUserDest();
		

		default:
			return null;
		}
	}
	public String getColumnName(int column) {
        return header[column];
    }

}

