package pdev.financialbrains.client.utils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pdev.financialbrains.client.delegate.FxManagementDelegate;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

public class FxTableModel extends AbstractTableModel{
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<ForeignExchangeOption> fx ;
	String[] entete={"id","currentPrice","volatility","endDate","startDate","buySell","expiration","riskFree","strikePrice","domesticRiskFree","spotFx"} ;

	public FxTableModel() {
		fx =FxManagementDelegate.getInstance().doReadAll();
	}
	
	@Override
	public int getColumnCount() {
		return entete.length;
		
	}

	@Override
	public int getRowCount() {
		
		return fx.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return fx.get(rowIndex).getId();
		case 1:
			return fx.get(rowIndex).getCurrentPrice();
		case 2:
			return fx.get(rowIndex).getVolatility();
		case 3:
			return fx.get(rowIndex).getEndDate();
		case 4:
			return fx.get(rowIndex).getStartDate();
		case 5:
			return fx.get(rowIndex).getBuySell();
		case 6:
			return fx.get(rowIndex).getExpiration();
		case 7:
			return fx.get(rowIndex).getRiskFree();
		case 8:
			return fx.get(rowIndex).getStrikePrice();
		case 9:
			return fx.get(rowIndex).getDomesticRiskFree();
		case 10:
			return fx.get(rowIndex).getSpotFx();
				
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
