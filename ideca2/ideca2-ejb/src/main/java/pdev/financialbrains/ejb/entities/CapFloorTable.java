package pdev.financialbrains.ejb.entities;

public class CapFloorTable {

	private String startDate;
	private String endDate;
	private Double maturity;
	private Double cap;
	private Double floor;
	private Double d1;
	private Double d2;

	public CapFloorTable() {
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getCap() {
		return cap;
	}

	public void setCap(Double cap) {
		this.cap = cap;
	}

	public Double getFloor() {
		return floor;
	}

	public void setFloor(Double floor) {
		this.floor = floor;
	}

	public Double getD1() {
		return d1;
	}

	public void setD1(Double d1) {
		this.d1 = d1;
	}

	public Double getD2() {
		return d2;
	}

	public void setD2(Double d2) {
		this.d2 = d2;
	}

	public Double getMaturity() {
		return maturity;
	}

	public void setMaturity(Double maturity) {
		this.maturity = maturity;
	}

}
