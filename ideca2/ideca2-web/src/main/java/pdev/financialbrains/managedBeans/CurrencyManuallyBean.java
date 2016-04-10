package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.ICurrencyCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Currency;
import pdev.financialbrains.ejb.entities.Stock;



@ManagedBean(name = "mdcurBean")
@ViewScoped
public class CurrencyManuallyBean {
	@EJB
	
	private ICurrencyCrudServicesLocal curlocal;
	private List<Currency> curr = new ArrayList<>();
	private Currency currency = new Currency();
	private boolean  showform = false;
	public ICurrencyCrudServicesLocal getCurlocal() {
		return curlocal;
	}
	public void setCurlocal(ICurrencyCrudServicesLocal curlocal) {
		this.curlocal = curlocal;
	}
	public List<Currency> getCurr() {
		return curr;
	}
	public void setCurr(List<Currency> curr) {
		this.curr = curr;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public boolean isShowform() {
		return showform;
	}
	public void setShowform(boolean showform) {
		this.showform = showform;
	}
	
	@PostConstruct
	public void init() {
	
		curr=curlocal.readAll();
		currency = new Currency();
	}
	public String doAdd() {
		curlocal.add(currency);
		System.out.println("Im inside ADD************");
		return null;
	}
	public String doUpdate() {
		curlocal.update2(currency);
		init();
		return null;
	}

	public String doDelete(Currency b) {
		curlocal.delete2(b);
		init();
		return null;
	}
	 public String initialiser(){
		
		 currency = new Currency();
		 return null;
	 }
	

}
