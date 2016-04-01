package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.DerivativeInstrument;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.services.CapFloorCrudService;
import pdev.financialbrains.ejb.services.TradeCrudServices;
import pdev.financialbrains.ejb.services.UserCrudServices;
import pdev.financialbrains.ejb.services.derivativesCrudService;

@ManagedBean(name = "capFloorBean")
@ApplicationScoped
public class CapFloorBean {

	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;
	
	@EJB
	CapFloorCrudService CapService;

	@EJB
	TradeCrudServices tradeService;

	@EJB
	derivativesCrudService derivativesCrudService;

	@EJB
	UserCrudServices userCrudServices;
	
	

	// Trader trader = (Trader) userCrudServices.readOneUser(1);
	private List<CapFloor> capFloors;

	private DerivativeInstrument capFloor = new CapFloor();

	private Boolean formDisplayed = false;

	private List<Trade> trades ;

	@PostConstruct
	public void init() {
	    trades = tradeService.readAll();
		capFloors = doReadAll();
	}

	public List<CapFloor> doReadAll() {

		capFloors = new ArrayList<CapFloor>();
		for (Trade d : trades) {
			
				    DerivativeInstrument capFloor = (CapFloor) d.getFi();
					capFloors.add((CapFloor) capFloor);
				
			
		}

		return capFloors;
	}

	public String doSave() {
		String navTo = null;
		derivativesCrudService.createDervivativesInstrument((DerivativeInstrument) capFloor);
		Trade trade1 = new Trade();
		TradePK pk = new TradePK();
		pk.setId(1);
		pk.setIdUser(1);
		pk.setDate(new Date());
		trade1.setPk(pk);
		tradeService.create(trade1);
		trades = tradeService.readAll();
		capFloors = doReadAll();
		navTo = "/pages/trader/CapFloorTrade.jsf?faces-redirect=true";
		return navTo;
	}

	public DerivativeInstrument getCapFloor() {
		return capFloor;
	}

	public void setCapFloor(DerivativeInstrument capFloor) {
		this.capFloor = capFloor;
	}

	public Boolean getFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(Boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public List<CapFloor> getCapFloors() {
		return capFloors;
	}

	public void setCapFloors(List<CapFloor> capFloors) {
		this.capFloors = capFloors;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}


}
