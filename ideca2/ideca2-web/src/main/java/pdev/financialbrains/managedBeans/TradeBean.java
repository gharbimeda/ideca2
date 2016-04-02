package pdev.financialbrains.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Trade;

@ManagedBean(name = "tradeBean")
@ViewScoped
public class TradeBean {

	@EJB
	ITradeCrudServiceLocal services;

	List<Trade> trades;

	private Boolean formDisplayed = false;

	public List<Trade> doReadAll() {
		return trades = services.readAll();
	}
}
