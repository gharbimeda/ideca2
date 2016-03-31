package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.services.TradeCrudServices;

@ManagedBean(name = "tradeBean")
@ViewScoped
public class TradeBean {

	@EJB
	TradeCrudServices services;
	
	List<Trade> trades;
	
	private Boolean formDisplayed = false;
	
	public List<Trade> doReadAll (){
		return trades = services.readAll();
	}
}
