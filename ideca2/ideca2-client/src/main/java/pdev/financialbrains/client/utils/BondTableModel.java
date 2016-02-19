package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.ejb.entities.Bond;

public class BondTableModel extends AbstractTableModel {

	public List<Bond> bonds;
	String[] entete = { "ID Bond", "Volatility", "Current Price", "Symbol", "Start Date", "End Date", "Coupon",
			"Day Count", "Yield Method" };
	private static final long serialVersionUID = 1L;

	public BondTableModel() {
		bonds = BondManagementDelegate.getInstance().doReadAll();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return bonds.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return bonds.get(arg0).getId();
		case 1:
			return bonds.get(arg0).getVolatility();
		case 2:
			return bonds.get(arg0).getCurrentPrice();
		case 3:
			return bonds.get(arg0).getSymbol();
		case 4:
			return bonds.get(arg0).getStartDate();
		case 5:
			return bonds.get(arg0).getEndDate();
		case 6:
			return bonds.get(arg0).getCoupon();
		case 7:
			return bonds.get(arg0).getDayCount();
		case 8:
			return bonds.get(arg0).getYieldMethod();
		default:
			return null;
		}
	}

	
	@Override
	public String getColumnName(int column) {
		return entete[column];
	}

}
