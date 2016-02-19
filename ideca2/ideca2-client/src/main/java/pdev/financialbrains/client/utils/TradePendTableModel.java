package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.TradeManagementDelegate;
import pdev.financialbrains.ejb.entities.Trade;

public class TradePendTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	public List<Trade> trades;
	String[] entete = { "ID Trade", "Name", "Value", "Date", "Status" };

	public TradePendTableModel(String param) {
		if(param.equals("PENDING"))
			trades = TradeManagementDelegate.getInstance().doReadPending();
		else if(param.equals("MANAGED"))
			trades = TradeManagementDelegate.getInstance().doReadCanApp();
		else if(param.equals("ALL"))
			trades = TradeManagementDelegate.getInstance().doReadAll();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return trades.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return trades.get(arg0).getId();
		case 1:
			return trades.get(arg0).getName();
		case 2:
			return trades.get(arg0).getValue();
		case 3:
			return trades.get(arg0).getDate();
		case 4:
			return trades.get(arg0).getStatusString();

		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return entete[column];
	}
}
