package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.ejb.entities.Stock;

public class StockTableModel extends AbstractTableModel {

	public List<Stock> stocks;
	String[] entete = { "ID Stock", "Volatility", "Current Price", "Symbol", "Company Name", "Opening Price",
			"Volume" };
	private static final long serialVersionUID = 1L;

	public StockTableModel() {
		stocks = StockManagementDelegate.getInstance().doReadAll();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return stocks.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return stocks.get(arg0).getId();
		case 1:
			return stocks.get(arg0).getVolatility();
		case 2:
			return stocks.get(arg0).getCurrentPrice();
		case 3:
			return stocks.get(arg0).getSymbol();
		case 4:
			return stocks.get(arg0).getCompanyName();
		case 5:
			return stocks.get(arg0).getOpeningPrice();
		case 6:
			return stocks.get(arg0).getClosingPrice();
		case 7:
			return stocks.get(arg0).getVolume();
		default:
			return null;
		}
	}

	public String getColumnString(int column) {
		return entete[column];
	}

}
