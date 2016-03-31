package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.entities.CapFloor;
import pdev.financialbrains.ejb.entities.Trade;
import pdev.financialbrains.ejb.services.CapFloorCrudService;
import pdev.financialbrains.ejb.services.TradeCrudServices;

@ManagedBean(name = "capFloorBean")
@ViewScoped
public class CapFloorBean {

	@EJB
	CapFloorCrudService CapService;
	
	@EJB
	TradeCrudServices tradeService;
	
	//public List<CapFloor> capFloors;
	
	private CapFloor capFloor = new CapFloor();
	
	private Boolean formDisplayed = false;
	
	//public List<Trade> trades = tradeService.readAcceptedAll();
	
	//public List<CapFloor> doReadAll (){
		/*capFloors = new ArrayList<CapFloor>();
		for(Trade d : trades){
			if (d.getFi() instanceof CapFloor){
				CapFloor capFloor = (CapFloor) d.getFi();
				if (capFloor.getBuySell()){
					capFloors.add(capFloor);
				}
			}
		}*/
		//return capFloors ;
	//}

	public CapFloor getCapFloor() {
		return capFloor;
	}

	public void setCapFloor(CapFloor capFloor) {
		this.capFloor = capFloor;
	}

	public Boolean getFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(Boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
}
