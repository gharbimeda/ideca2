package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesLocal;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

@ManagedBean
@ViewScoped
public class FxOptionBean {
	@EJB
	private IFxoptionCrudServicesLocal fxoptionCrudServicesLocal;
	private List<ForeignExchangeOption>  fxoptions = new ArrayList<ForeignExchangeOption>();
	private ForeignExchangeOption foreignExchangeOption=new ForeignExchangeOption();
	private Integer callPut ;
	private Integer currentSpotPrice;
	private Integer dRisk;
	private Integer fRisk;
	private Integer time;
	private Float strikePrice;
	private Float volatilite;
	private Double price;
	public Integer getCallPut() {
		return callPut;
	}
	public void setCallPut(Integer callPut) {
		this.callPut = callPut;
	}
	public Integer getCurrentSpotPrice() {
		return currentSpotPrice;
	}
	public void setCurrentSpotPrice(Integer currentSpotPrice) {
		this.currentSpotPrice = currentSpotPrice;
	}
	public Integer getdRisk() {
		return dRisk;
	}
	public void setdRisk(Integer dRisk) {
		this.dRisk = dRisk;
	}
	public Integer getfRisk() {
		return fRisk;
	}
	public void setfRisk(Integer fRisk) {
		this.fRisk = fRisk;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Float getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Float strikePrice) {
		this.strikePrice = strikePrice;
	}
	public Float getVolatilite() {
		return volatilite;
	}
	public void setVolatilite(Float volatilite) {
		this.volatilite = volatilite;
	}
	

	//public ForeignExchangeOption construct(Integer callPut, Integer currentSpotPrice, Integer dRisk, Integer fRisk, Integer time,
		//	Float strikePrice, Float volatilite) {
	
	
//	}
	@PostConstruct
	public void init(){
	//	foreignExchangeOption=new ForeignExchangeOption();
	}
	
	public String Pricing(Integer callPut , Integer currentSpotPrice, Integer dRisk,Integer fRisk,Integer time,Float strikePrice,Float volatilite)
	{
		this.price=fxoptionCrudServicesLocal.Pricing(callPut, currentSpotPrice, dRisk, fRisk, time, strikePrice, volatilite);
		Float curPrice=new Float(currentSpotPrice);
		foreignExchangeOption.setCallPut(callPut);
		 foreignExchangeOption.setMaturityDate(time);
		 foreignExchangeOption.setRiskFree(fRisk);
		 foreignExchangeOption.setDomesticRiskFree(dRisk);
		 foreignExchangeOption.setStrikePrice(strikePrice);
		 foreignExchangeOption.setVolatilite(volatilite);
		 foreignExchangeOption.setCurrentPrice(curPrice);
		 
		return null;
	}
	
	public String doAdd(){
		
		fxoptionCrudServicesLocal.create(foreignExchangeOption);
		System.out.println("added");
		return null;
		
	}
	public String doUpdate(){
		fxoptionCrudServicesLocal.update(foreignExchangeOption);
		init();
		return null;
	}
	public String doDelete(ForeignExchangeOption foreignExchangeOption){
		fxoptionCrudServicesLocal.delete(foreignExchangeOption);
		init();
		return null;
		
	}
	public IFxoptionCrudServicesLocal getFxoptionCrudServicesLocal() {
		return fxoptionCrudServicesLocal;
	}
	public void setFxoptionCrudServicesLocal(IFxoptionCrudServicesLocal fxoptionCrudServicesLocal) {
		this.fxoptionCrudServicesLocal = fxoptionCrudServicesLocal;
	}
	public ForeignExchangeOption getForeignExchangeOption() {
		return foreignExchangeOption;
	}
	public void setForeignExchangeOption(ForeignExchangeOption foreignExchangeOption) {
		this.foreignExchangeOption = foreignExchangeOption;
	}
	public List<ForeignExchangeOption> getFxoptions() {
		return fxoptions;
	}
	public void setFxoptions(List<ForeignExchangeOption> fxoptions) {
		this.fxoptions = fxoptions;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
