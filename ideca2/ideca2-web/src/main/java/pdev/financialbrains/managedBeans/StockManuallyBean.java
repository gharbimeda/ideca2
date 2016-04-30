package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IBondCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IStockCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Stock;
/*
 * Mariem
 */

@ManagedBean(name = "mdstockBean")
@ViewScoped

public class StockManuallyBean {
	
	@EJB
	
	private IStockCrudServicesLocal stocklocal;
	private List<Stock> stocks = new ArrayList<>();
	private Stock stock = new Stock();
	private boolean showForm = false;

	public IStockCrudServicesLocal getStocklocal() {
		return stocklocal;
	}
	public void setStocklocal(IStockCrudServicesLocal stocklocal) {
		this.stocklocal = stocklocal;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	@PostConstruct
	public void init() {
		stocks= stocklocal.readAll();
		stock = new Stock();
	}
	public String doAdd() {
		stocklocal.add(stock);
		System.out.println("Im inside ADD************");
		return null;
	}
	public String doUpdate() {
		stocklocal.update2(stock);
		init();
		return null;
	}

	public String doDelete(Stock b) {
		stocklocal.delete2(b);
		init();
		return null;
	}
	 public String initialiser(){
 		 stock = new Stock();
		 return null;
	 }
	

}
