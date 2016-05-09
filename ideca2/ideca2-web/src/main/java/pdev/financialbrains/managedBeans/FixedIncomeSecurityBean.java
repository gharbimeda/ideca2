package pdev.financialbrains.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.entities.Bond;
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

	public static List<Float> BondYieldToday;
	
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
	private Float timeMaturity;
	private Integer frequency;
private String curYield;
	private Float faceValue;
	private int months;
    private String maturity;
	private Float couponRate=0f;
	private Float yield;
	private Float currentYield;
	private Float bondPrice;
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

	

	public Float getTimeMaturity() {
		return timeMaturity;
	}

	public void setTimeMaturity(Float timeMaturity) {
		this.timeMaturity = timeMaturity;
	}

	public Float getYield() {
		return yield;
	}

	public void setYield(Float yield) {
		this.yield = yield;
	}

	public Float getBondPrice() {
		return bondPrice;
	}

	public void setBondPrice(Float bondPrice) {
		this.bondPrice = bondPrice;
	}

	@PostConstruct
	public void init() {
		fixedIncomeSecurities = fxlocal.readAll();
		fixes = remplir();
		BondYieldToday =list_bond_yield_today();

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

	public String dopriceZeroCouponBond(Float faceValue, Float timeMaturity,
			Float currentYield) {
		String nav;
		this.bondPrice = fxlocal.priceZeroCouponBond(faceValue, timeMaturity,
				currentYield);
		init();
		nav = "menuProduct?faces-redirect=true";

		return null;

	}

	public String dopriceTreasuryBond(Float faceValue, Float timeMaturity,
			Float currentYield, Integer frequency, Float couponRate) {

		this.bondPrice = fxlocal.priceTreasuryBond(faceValue, timeMaturity,
				currentYield, frequency, couponRate);
		init();

		return "Prcing done!!";
	}

	public String dopricecorpBond(Float faceValue, Float timeMaturity,
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
		navTo = "menuProduct?faces-redirect=true";
		return navTo;
	}

	public void doBookTradeZCB() {
		Trade t = new Trade();
		TradePK pk = new TradePK();
		pk.setIdUser(1);
		 pk.setId(i);
		i++;
		pk.setDate(new Date());
		 t.setPk(pk);
		 t.setPutcall(putCall);
		 t.setStatus(2);
		 t.setName("ZCB");
		 t.setValue(bondPrice);
		 tradeServices.update(t);
	}

	public void doBookTradeTreausy() {
		Trade t = new Trade();
		TradePK pk = new TradePK();
		pk.setIdUser(1);
		 pk.setId(i);
		i++;
		pk.setDate(new Date());
		 t.setPk(pk);
		 t.setPutcall(putCall);
		 t.setStatus(2);
		 t.setName("Treasury Bond");
		 t.setValue(bondPrice);
		 tradeServices.update(t);
	}
	public void doBookTradeCorporate() {
		Trade t = new Trade();
		TradePK pk = new TradePK();
		pk.setIdUser(1);
		 pk.setId(i);
		i++;
		pk.setDate(new Date());
		 t.setPk(pk);
		 t.setPutcall(putCall);
		 t.setStatus(2);
		 t.setName("Corporate ");
		 t.setValue(bondPrice);
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
	public void handleChange(){  
		System.out.println(maturity);
		System.out.println(Yield1Today());
		System.out.println(couponRate);
	    if(maturity.equals("3 Month"))
	    {
	    	timeMaturity=0.25f;
	    	couponRate=Yield1Today();
	    	yield=Yield1Today();
	    	System.out.println(couponRate);
	    }
	    else if(maturity.equals("6 Month"))
	    {
	    	timeMaturity=0.5f;
	    	couponRate=Yield2Today();
	    	yield=Yield2Today();
	    	System.out.println(couponRate);
	    }
	    else if(maturity.equals("2 Year"))
	    {
	    	timeMaturity=2f;
	    	couponRate=Yield3Today();
	    	yield=Yield3Today();
	    	System.out.println(couponRate);
	    }
	    else if(maturity.equals("3 Year"))
	    {
	    	timeMaturity=3f;
	    	couponRate=Yield4Today();
	    	yield=Yield4Today();
	    	System.out.println(couponRate);
	    }
	    else if(maturity.equals("5 Year"))
	    {
	    	timeMaturity=5f;
	    	couponRate=Yield5Today();
	    	yield=Yield5Today();
	    	System.out.println(couponRate);
	    	
	    }
	    else if(maturity.equals("10 Year"))
	    {
	    	timeMaturity=10f;
	    	couponRate=Yield6Today();
	    	yield=Yield6Today();
	    	System.out.println(couponRate);
	    }
	    else if(maturity.equals("30 Year"))
	    {
	    	timeMaturity=30f;
	    	couponRate=Yield7Today();
	    	yield=Yield7Today();
	    	System.out.println(couponRate);
	    }
	}
	public List<String> list_maturity()
	{
		List<String> list = new ArrayList<>();
		list.add("3 Month");
		list.add("6 Month");
		list.add("2 Year");
		list.add("3 Year");
		list.add("5 Year");
		list.add("10 Year");
		list.add("30 Year");
		return list;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	public List<Float> list_bond_yield_today(){
		List<String> yield = new ArrayList<>();
		List<String> bondYield = new ArrayList<>();
		List<Float> bondYieldFinal = new ArrayList<>();
	      String html = "http://finance.yahoo.com/bonds";
	        try {
	           Document doc = Jsoup.connect(html).get();
	           Elements tableElements = doc.select("table");
	           Elements tableHeaderEles = tableElements.select("thead tr th");
	          
	           for (int i = 0; i < tableHeaderEles.size(); i++) {
	              
	           }
	           
	           Elements tableRowElements = tableElements.select(":not(thead) tr");
	           for (int i = 1; i < tableRowElements.size()-2; i++) {
	              Element row = tableRowElements.get(i);
	              Elements rowItems = row.select("td");
	              for (int j = 0; j < rowItems.size(); j++) {
	            	  yield.add(rowItems.get(j).text());
	                 
	              }
	           }
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	        
	        
	        for (int i = 0 ; i<yield.size();i++)
	        {
	        }
	        int i = 1 ;
	        		while(i<=yield.size())
	        				{
	        				bondYield.add(yield.get(i));
	        					i=i+5;
	        				}
	        		int j = 2 ;
	        		while(j<=yield.size())
	        		{
	        			        bondYield.add(yield.get(j));
	        			        j=j+5;
	        		}
	        		int k = 3 ;
	        		while(k<=yield.size())
	        		{
	        			        bondYield.add(yield.get(k));
	        			        k=k+5;
	        		}
	        		int z = 4 ;
	        		while(z<=yield.size())
	        		{
	        			        bondYield.add(yield.get(z));
	        			        z=z+5;
	        		}
					for (String s : bondYield)
					{
						Float f = Float.parseFloat(s);
						bondYieldFinal.add(f);
					}
		return bondYieldFinal;
	}
	

	
	public static Float Yield1Today()
	{
		return BondYieldToday.get(0);
	}
	public static Float Yield2Today()
	{
		return BondYieldToday.get(1);
	}
	public static Float Yield3Today()
	{
		return BondYieldToday.get(2);
	}
	public  static Float Yield4Today()
	{
		return BondYieldToday.get(3);
	}
	public static Float Yield5Today()
	{
		return BondYieldToday.get(4);
	}
	public  static Float Yield6Today()
	{
		return BondYieldToday.get(5);
	}
	public static Float Yield7Today()
	{
		return BondYieldToday.get(6);
	}
	public static Float Yield1Yesterday()
	{
		return BondYieldToday.get(7);
	}
	public static  Float Yield2Yesterday()
	{
		return BondYieldToday.get(8);
	}
	public  static Float Yield3Yesterday()
	{
		return BondYieldToday.get(9);
	}
	public static  Float Yield4Yesterday()
	{
		return BondYieldToday.get(10);
	}
	public static Float Yield5Yesterday()
	{
		return BondYieldToday.get(11);
	}
	public  static Float Yield6Yesterday()
	{
		return BondYieldToday.get(12);
	}
	public static Float Yield7Yesterday()
	{
		return BondYieldToday.get(13);
	}
	public static Float Yield1LastWeek()
	{
		return BondYieldToday.get(14);
	}
	public static Float Yield2LastWeek()
	{
		return BondYieldToday.get(15);
	}
	public static Float Yield3LastWeek()
	{
		return BondYieldToday.get(16);
	}
	public static Float Yield4LastWeek()
	{
		return BondYieldToday.get(17);
	}
	public static Float Yield5LastWeek()
	{
		return BondYieldToday.get(18);
	}
	public  static Float Yield6LastWeek()
	{
		return BondYieldToday.get(19);
	}
	public static Float Yield7LastWeek()
	{
		return BondYieldToday.get(20);
	}
	public static Float Yield1LastMonth()
	{
		return BondYieldToday.get(21);
	}
	public static Float Yield2LastMonth()
	{
		return BondYieldToday.get(22);
	}
	public static Float Yield3LastMonth()
	{
		return BondYieldToday.get(23);
	}
	public static Float Yield4LastMonth()
	{
		return BondYieldToday.get(24);
	}
	public static Float Yield5LastMonth()
	{
		return BondYieldToday.get(25);
	}
	public static Float Yield6LastMonth()
	{
		return BondYieldToday.get(26);
	}
	public static Float Yield7LastMonth()
	{
		return BondYieldToday.get(27);
	}

	public TradeCrudServices getTradeService() {
		return tradeService;
	}

	public void setTradeService(TradeCrudServices tradeService) {
		this.tradeService = tradeService;
	}

	public static List<Float> getBondYieldToday() {
		return BondYieldToday;
	}

	public static void setBondYieldToday(List<Float> bondYieldToday) {
		BondYieldToday = bondYieldToday;
	}

	public derivativesCrudService getDerivativesCrudService() {
		return derivativesCrudService;
	}

	public void setDerivativesCrudService(
			derivativesCrudService derivativesCrudService) {
		this.derivativesCrudService = derivativesCrudService;
	}

	public UserCrudServices getUserCrudServices() {
		return userCrudServices;
	}

	public void setUserCrudServices(UserCrudServices userCrudServices) {
		this.userCrudServices = userCrudServices;
	}

	public String getCurYield() {
		return curYield;
	}

	public void setCurYield(String curYield) {
		this.curYield = curYield;
	}


}
