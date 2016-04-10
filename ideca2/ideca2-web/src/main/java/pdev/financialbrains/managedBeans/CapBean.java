package pdev.financialbrains.managedBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.CapFloorTable;
import pdev.financialbrains.ejb.entities.CashInstrument;
import pdev.financialbrains.ejb.entities.DerivativeInstrument;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.services.CapFloorCrudService;
import pdev.financialbrains.ejb.services.TradeCrudServices;
import pdev.financialbrains.ejb.services.UserCrudServices;
import pdev.financialbrains.util.Util;

@ManagedBean(name = "capbean")
@ViewScoped
public class CapBean {

	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;

	@EJB
	private TradeCrudServices tradeServices;

	@EJB
	private CapFloorCrudService capService;

	@EJB
	private UserCrudServices userServices;

	private CapFloor c = new CapFloor();

	private Integer idUserConnect; 
	
	private Integer nbDays;
	private Double risk;
	private Float yield;
	private Integer putCall;

	private Integer nd;
	private Integer i=15;

	private List<CapFloorTable> resulats;
	private List<Trade> trades;
	private List<Trade> caps;

	@PostConstruct
	public void init() {

		caps = remplir();
	}

	public List<Trade> remplir() {
		trades = tradeServices.readPutAccepted();
		List<Trade> caps = new ArrayList<Trade>();
		for (Trade t : trades) {
			if (t.getName().equalsIgnoreCase("cap") || t.getName().equalsIgnoreCase("floor")) {
				caps.add(t);
			}
		}
		return caps;

	}

	private Integer nDays() {
		Date date1 = c.getStartDate();
		Date date2 = c.getEndDate();
		Integer nbJour = Math.abs((date2.getYear() - date1.getYear()) * 12 + (date2.getMonth() - date1.getMonth()));
		return nbJour;
	}

	private double nbPeriode() {

		return nDays() / c.getTenor();
	}

	public void doPricing() {
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		nd = this.nDays();
		Calendar date1 = null, date2 = null;
		date1.setTime(c.getStartDate());
		date2.setTime(c.getEndDate());

		Integer n = 0;
		Double somme = 0.0;
		String f = c.getRiskFree() + "";
		List<CapFloorTable> capFloorTables = new ArrayList<>();
		for (int i = 1; i <= nbPeriode(); i++) {
			CapFloorTable capFloorTable = new CapFloorTable();
			capFloorTable.setStartDate(formater.format(date1.getTime()));
			date1.add(date1.DATE, nd);
			capFloorTable.setEndDate(formater.format(date1.getTime()));
			capFloorTable.setPeriod(i);
			n = Math.abs((date2.getTime().getYear() - date1.getTime().getYear()) * 12
					+ (date2.getTime().getMonth() - date1.getTime().getMonth()));
			capFloorTable.setMaturity(n / 365.0);
			//capFloorTable.setCap(capService.pricingCapFloor(c.getNotionalAmount(), c.getCapFloorString(), nd, i, 360,
			//		risk, c.getStrikePrice(), c.getVolatility(), capFloorTable.getMaturity(), Double.parseDouble(f)));
			capFloorTables.add(capFloorTable);
			somme += capFloorTable.getCap();
		}
		resulats = capFloorTables;

	}

	public String doBookTrade() {
		
		Trade t = new Trade();
		c.setId(i);
		capService.update(c);
		
		TradePK pk = new TradePK();
		pk.setId(i);
		i++;
		pk.setIdUser(1);
		//t.setFi(c);
		//t.setTrader((Trader) userServices.readOneUser(1));
		t.setPk(pk);
		t.setPutcall(putCall);
		t.setStatus(2);
		t.setName(c.getCapFloorString());
		t.setValue(c.getNotionalAmount());
		tradeServices.update(t);
		return "CapFloorTrade?faces-redirect=true";
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

	public Double getRisk() {
		return risk;
	}

	public void setRisk(Double risk) {
		this.risk = risk;
	}

	public Float getYield() {
		return yield;
	}

	public void setYield(Float yield) {
		this.yield = yield;
	}

	public Integer getPutCall() {
		return putCall;
	}

	public void setPutCall(Integer putCall) {
		this.putCall = putCall;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public List<Trade> getCaps() {
		return caps;
	}

	public Integer getIdUserConnect() {
		return idUserConnect;
	}

	public void setIdUserConnect(Integer idUserConnect) {
		this.idUserConnect = idUserConnect;
	}

	public void setCaps(List<Trade> caps) {
		this.caps = caps;
	}

	public List<CapFloorTable> getResulats() {
		return resulats;
	}

	public void setResulats(List<CapFloorTable> resulats) {
		this.resulats = resulats;
	}

}
