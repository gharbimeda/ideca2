package pdev.financialbrains.managedBeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.CashInstrument;
import pdev.financialbrains.ejb.entities.DerivativeInstrument;
import pdev.financialbrains.ejb.entities.Trader;

@ManagedBean( name="capbean")
@RequestScoped
public class CapBean {

	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;
	
	private CapFloor c = new CapFloor();

	private Integer nbDays;
	private Float risk;
	private Float yield;
	
	public Integer doNbDays(Integer tenor){
		if (tenor == 3) return 90;
		if (tenor == 6) return 180;
		if (tenor == 12) return 360;
		return 0;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public CapFloor getC() {
		return c;
	}

	public void setC(CapFloor c) {
		this.c = c;
	}

	public Integer getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public Float getRisk() {
		return risk;
	}

	public void setRisk(Float risk) {
		this.risk = risk;
	}

	public Float getYield() {
		return yield;
	}

	public void setYield(Float yield) {
		this.yield = yield;
	}
	
	
	
	
}
