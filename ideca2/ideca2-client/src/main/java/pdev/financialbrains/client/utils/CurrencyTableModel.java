package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.ejb.entities.Currency;

public class CurrencyTableModel extends AbstractTableModel {

	public List<Currency> currencies;
	String[] entete = { "ID Currency", "Volatility", "Current Price", "Symbol", "Opening Price", "Closing Price",
			"Volume" };
	private static final long serialVersionUID = 1L;

	public CurrencyTableModel() {
		currencies = CurrencyManagementDelegate.getInstance().doReadAll();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return currencies.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return currencies.get(rowIndex).getId();
		case 1:
			return currencies.get(rowIndex).getVolatility();
		case 2:
			return currencies.get(rowIndex).getCurrentPrice();
		case 3:
			return currencies.get(rowIndex).getSymbol();
		case 4:
			return currencies.get(rowIndex).getOpeningPrice();
		case 5:
			return currencies.get(rowIndex).getClosingPrice();
		case 6:
			return currencies.get(rowIndex).getVolume();

		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return entete[column];
	}
}
