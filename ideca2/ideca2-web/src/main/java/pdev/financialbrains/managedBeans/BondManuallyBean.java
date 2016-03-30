package pdev.financialbrains.managedBeans;

/*
 * Mariem
 */

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IBondCrudServicesLocal;
import pdev.financialbrains.ejb.entities.Bond;

@ManagedBean(name = "mdbondBean")
@ViewScoped
public class BondManuallyBean {
	@EJB
	private IBondCrudServicesLocal bondlocal;
	private List<Bond> bonds = new ArrayList<>();
	private Bond bond = new Bond();
	private Bond test = new Bond(5);


	public IBondCrudServicesLocal getBondlocal() {
		return bondlocal;
	}

	public void setBondlocal(IBondCrudServicesLocal bondlocal) {
		this.bondlocal = bondlocal;
	}

	public List<Bond> getBonds() {
		return bonds;
	}

	public void setBonds(List<Bond> bonds) {
		this.bonds = bonds;
	}

	public Bond getBond() {
		return bond;
	}

	public void setBond(Bond bond) {
		this.bond = bond;
	}

	@PostConstruct
	public void init() {
		//bonds = bondlocal.readAll();
		bond = new Bond();

	}

	public String doAdd() {
		bondlocal.add(bond);
		System.out.println("Im inside ADD************");
		return null;
	}

	public String doUpdate() {
		bondlocal.update2(bond);
		init();
		return null;
	}

	public String doDelete(Bond b) {
		bondlocal.delete2(b);
		init();
		return null;
	}
	 public String initialiser(){
		 bond=new Bond();
		 return null;
	 }
}
