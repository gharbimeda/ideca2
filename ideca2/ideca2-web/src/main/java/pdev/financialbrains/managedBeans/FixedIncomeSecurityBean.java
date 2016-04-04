package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sun.mail.auth.MD4;

import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.DerivativeInstrument;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;
import pdev.financialbrains.ejb.entities.Trader;
import pdev.financialbrains.ejb.services.TradeCrudServices;
import pdev.financialbrains.ejb.services.UserCrudServices;
import pdev.financialbrains.ejb.services.derivativesCrudService;

@ManagedBean(name = "mdfxincomeBean")
@ViewScoped
public class FixedIncomeSecurityBean {

	@ManagedProperty("#{identity.userIdentify}")
	private Trader trader;
	@EJB
	TradeCrudServices tradeService;

	@EJB
	derivativesCrudService derivativesCrudService;

	@EJB
	UserCrudServices userCrudServices;
	private List<Trade> trades;

	@EJB
	private TradeCrudServices tradeServices;

	@EJB
	private IFixedIncomeSecurityLocal fxlocal;
	private List<FixedIncomeSecuritie> fixedIncomeSecurities = new ArrayList<>();

	private DerivativeInstrument fixedincome = new FixedIncomeSecuritie();

	private FixedIncomeSecuritie fx = new FixedIncomeSecuritie();
	private Integer timeMaturity;
	private Integer frequency;

	private Float faceValue;
	private int months;

	private Float couponRate;
	private Float yield;
	private Float currentYield;
	private Double bondPrice;
	private Integer putCall;

	private int i = 10;
	private List<Trade> fixes;

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Float getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Float faceValue) {
		this.faceValue = faceValue;
	}

	public Float getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(Float couponRate) {
		this.couponRate = couponRate;
	}

	public Float getCurrentYield() {
		return currentYield;
	}

	public void setCurrentYield(Float currentYield) {
		this.currentYield = currentYield;
	}

	public Integer getTimeMaturity() {
		return timeMaturity;
	}

	public void setTimeMaturity(Integer timeMaturity) {
		this.timeMaturity = timeMaturity;
	}

	public Float getYield() {
		return yield;
	}

	public void setYield(Float yield) {
		this.yield = yield;
	}

	public Double getBondPrice() {
		return bondPrice;
	}

	public void setBondPrice(Double bondPrice) {
		this.bondPrice = bondPrice;
	}

	@PostConstruct
	public void init() {
		fixedIncomeSecurities = fxlocal.readAll();
		fixes = remplir();

	}

	public IFixedIncomeSecurityLocal getFxlocal() {
		return fxlocal;
	}

	public void setFxlocal(IFixedIncomeSecurityLocal fxlocal) {
		this.fxlocal = fxlocal;
	}

	public List<FixedIncomeSecuritie> getFixedIncomeSecurities() {
		return fixedIncomeSecurities;
	}

	public void setFixedIncomeSecurities(
			List<FixedIncomeSecuritie> fixedIncomeSecurities) {
		this.fixedIncomeSecurities = fixedIncomeSecurities;
	}

	public FixedIncomeSecuritie getFx() {
		return fx;
	}

	public void setFx(FixedIncomeSecuritie fx) {
		this.fx = fx;
	}

	public String doAdd() {
		// bondlocal.add(bond);
		fxlocal.add(fx);
		System.out.println("Im inside ADD************");
		return null;
	}

	public String doUpdate() {
		// bondlocal.update2(bond);
		fxlocal.update2(fx);
		init();
		return null;
	}

	public String doDelete(Bond b) {
		fxlocal.delete2(fx);
		init();
		return null;
	}

	public String initialiser() {

		fx = new FixedIncomeSecuritie();
		return null;
	}

	public String dopriceZeroCouponBond(Float faceValue, Integer timeMaturity,
			Float currentYield) {
		String nav;
		this.bondPrice = fxlocal.priceZeroCouponBond(faceValue, timeMaturity,
				currentYield);
		init();
		// nav ="/pages/trader/menuProduct.xhtml?faces-redirect=true";
		return null;

	}

	public String dopriceTreasuryBond(Float faceValue, Integer timeMaturity,
			Float currentYield, Integer frequency, Float couponRate) {

		this.bondPrice = fxlocal.priceTreasuryBond(faceValue, timeMaturity,
				currentYield, frequency, couponRate);
		init();

		return "Prcing done!!";
	}

	public String dopricecorpBond(Float faceValue, Integer timeMaturity,
			Float currentYield, Integer frequency, Float couponRate,
			Integer months) {
		this.bondPrice = fxlocal.priceCorpBond(faceValue, timeMaturity,
				currentYield, frequency, couponRate, months);
		init();

		return null;

	}

	public List<FixedIncomeSecuritie> doReadAll() {

		fixedIncomeSecurities = new ArrayList<FixedIncomeSecuritie>();
		for (Trade d : trades) {

			DerivativeInstrument fixed = (FixedIncomeSecuritie) d.getFi();
			fixedIncomeSecurities.add((FixedIncomeSecuritie) fixed);

		}

		return fixedIncomeSecurities;
	}

	public String doSave() {
		String navTo ;
		derivativesCrudService
				.createDervivativesInstrument((DerivativeInstrument) fixedincome);
		Trade trade1 = new Trade();
		TradePK pk = new TradePK();
		pk.setId(11);
		pk.setIdUser(1);
		pk.setDate(new Date());
		trade1.setPk(pk);
		tradeService.create(trade1);
		trades = tradeService.readAll();
		fixedIncomeSecurities = doReadAll();
		navTo = "/pages/trader/menuProduct.xhtml?faces-redirect=true";
		return navTo;
	}

	public void doBookTrade() {
		Trade t = new Trade();
		TradePK pk = new TradePK();
		pk.setIdUser(1);
		 pk.setId(i);
		i++;
		pk.setDate(new Date());
		 t.setPk(pk);
		 t.setPutcall(putCall);
		 t.setStatus(2);
		 t.setName(fx.getbdString());
		 t.setValue(45.2f);
		 tradeServices.update(t);
	}

	public List<Trade> remplir() {
		trades = tradeServices.readPutAccepted();
		List<Trade> fixes = new ArrayList<Trade>();
		for (Trade t : trades) {
			if (t.getName().equalsIgnoreCase("ZCB")
					|| t.getName().equalsIgnoreCase("treasury")
					|| t.getName().equalsIgnoreCase("corporate")) {
				fixes.add(t);
			}
		}
		return fixes;

	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public DerivativeInstrument getFixedincome() {
		return fixedincome;
	}

	public void setFixedincome(DerivativeInstrument fixedincome) {
		this.fixedincome = fixedincome;
	}

	public TradeCrudServices getTradeServices() {
		return tradeServices;
	}

	public void setTradeServices(TradeCrudServices tradeServices) {
		this.tradeServices = tradeServices;
	}

	public Integer getPutCall() {
		return putCall;
	}

	public void setPutCall(Integer putCall) {
		this.putCall = putCall;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public List<Trade> getFixes() {
		return fixes;
	}

	public void setFixes(List<Trade> fixes) {
		this.fixes = fixes;
	}
}
