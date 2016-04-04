package pdev.financialbrains.ejb.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_equityOption")
public class EquityOption extends Option {

	private Integer numberShares;
	private Integer spotSharePrice;
	private Integer expectedDividend;
	private static final long serialVersionUID = 1L;

	public EquityOption() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNumberShares() {
		return numberShares;
	}

	public void setNumberShares(Integer numberShares) {
		this.numberShares = numberShares;
	}

	public Integer getSpotSharePrice() {
		return spotSharePrice;
	}

	public void setSpotSharePrice(Integer spotSharePrice) {
		this.spotSharePrice = spotSharePrice;
	}

	public Integer getExpectedDividend() {
		return expectedDividend;
	}

	public void setExpectedDividend(Integer expectedDividend) {
		this.expectedDividend = expectedDividend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((expectedDividend == null) ? 0 : expectedDividend.hashCode());
		result = prime * result + ((numberShares == null) ? 0 : numberShares.hashCode());
		result = prime * result + ((spotSharePrice == null) ? 0 : spotSharePrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquityOption other = (EquityOption) obj;
		if (expectedDividend == null) {
			if (other.expectedDividend != null)
				return false;
		} else if (!expectedDividend.equals(other.expectedDividend))
			return false;
		if (numberShares == null) {
			if (other.numberShares != null)
				return false;
		} else if (!numberShares.equals(other.numberShares))
			return false;
		if (spotSharePrice == null) {
			if (other.spotSharePrice != null)
				return false;
		} else if (!spotSharePrice.equals(other.spotSharePrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EquityOption [getId()=" + getId() + ", getVolatility()=" + getVolatility() + ", getCurrentPrice()="
				+ getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", getBuySell()=" + getBuySell() + ", getExpiration()=" + getExpiration() + ", getRiskFree()="
				+ getRiskFree() + ", getStrikePrice()=" + getStrikePrice() + ", numberShares=" + numberShares
				+ ", spotSharePrice=" + spotSharePrice + ", expectedDividend=" + expectedDividend + "]";
	}

}
