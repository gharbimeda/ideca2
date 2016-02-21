package pdev.financialbrains.ejb.entities;

public class CapFloorTable {

	private String startDate;
	private String endDate;
	private Double maturity;
	private Double cap;
	private Integer period;

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

	public Double getMaturity() {
		return maturity;
	}

	public void setMaturity(Double maturity) {
		this.maturity = maturity;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

}
