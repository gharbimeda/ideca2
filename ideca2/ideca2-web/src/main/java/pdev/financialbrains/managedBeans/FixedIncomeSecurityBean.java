package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IFixedIncomeSecurityLocal;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;

@ManagedBean(name = "mdfxincomeBean")
@ViewScoped
public class FixedIncomeSecurityBean {
	@EJB
	private IFixedIncomeSecurityLocal fxlocal;
	private List<FixedIncomeSecuritie> fixedIncomeSecurities = new ArrayList<>();

	private FixedIncomeSecuritie fx = new FixedIncomeSecuritie();
	private Integer timeMaturity;
	private Integer couponFreq;

	private Float faceValue;

	private Float couponRate;
	private Float yield;
	private Float currentYield;
	private Double bondPrice;

	public Integer getCouponFreq() {
		return couponFreq;
	}

	public void setCouponFreq(Integer couponFreq) {
		this.couponFreq = couponFreq;
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
		// bondlocal.delete2(b);
		fxlocal.delete2(fx);
		init();
		return null;
	}

	public String initialiser() {

		// bond=new Bond();
		fx = new FixedIncomeSecuritie();
		return null;
	}

	public String dopriceZeroCouponBond(Float faceValue, Integer timeMaturity,
			Float currentYield) {
		this.bondPrice = fxlocal.priceZeroCouponBond(faceValue, timeMaturity,
				currentYield);
		init();

		return null;

	}
}
