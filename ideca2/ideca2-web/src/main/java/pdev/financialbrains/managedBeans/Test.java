package pdev.financialbrains.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.entities.Trader;

@ManagedBean
@ViewScoped
public class Test {

	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	
	
}
