package pdev.financialbrains.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesLocal;
import pdev.financialbrains.ejb.entities.ForwardSwap;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.entities.TradePK;

@ManagedBean(name = "fsbean")
@ViewScoped
public class ForwardSwapBean {

	@EJB
	private IForwardSwapCrudServicesLocal fsLocal;
	private ForwardSwap forwardSwap;
	private Float strikeRate;
	private Float rate;
	private Float notional;
	private Float period;
	private Float expiryTime;
	private Float volatility;
	private Double result;
	private Boolean rend = false;
	private TradePK tradePk;
	private Trade trade;
	private boolean showForm = false;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public IForwardSwapCrudServicesLocal getFsLocal() {
		return fsLocal;
	}

	public void setFsLocal(IForwardSwapCrudServicesLocal fsLocal) {
		this.fsLocal = fsLocal;
	}

	public ForwardSwap getForwardSwap() {
		return forwardSwap;
	}

	public void setForwardSwap(ForwardSwap forwardSwap) {
		this.forwardSwap = forwardSwap;
	}

	public Float getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(Float strikeRate) {
		this.strikeRate = strikeRate;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getNotional() {
		return notional;
	}

	public void setNotional(Float notional) {
		this.notional = notional;
	}

	public Float getPeriod() {
		return period;
	}

	public void setPeriod(Float period) {
		this.period = period;
	}

	public Float getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Float expiryTime) {
		this.expiryTime = expiryTime;
	}

	public Float getVolatility() {
		return volatility;
	}

	public void setVolatility(Float volatility) {
		this.volatility = volatility;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public Boolean getRend() {
		return rend;
	}

	public void setRend(Boolean rend) {
		this.rend = rend;
	}

	public TradePK getTradePk() {
		return tradePk;
	}

	public void setTradePk(TradePK tradePk) {
		this.tradePk = tradePk;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@PostConstruct
	public void init() {
		forwardSwap = new ForwardSwap();
		strikeRate = new Float(0);
		rate = new Float(0);
		notional = new Float(0);
		period = new Float(0);
		expiryTime = new Float(0);
		volatility = new Float(0);
		result = new Double(0);
		trade = new Trade();
		tradePk = new TradePK();
	}

	public String doPrice() {
		result = fsLocal.priceForwardSwap(strikeRate, rate, notional, period, expiryTime, volatility);
		System.out.println(result);
		rend = true;
		return null;
	}

	public String doShowForm() {
		showForm = showForm ? false : true;
		return null;
	}
}
