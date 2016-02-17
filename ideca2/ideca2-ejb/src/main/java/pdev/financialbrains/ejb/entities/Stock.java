package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_stock")
public class Stock extends CashInstrument {

	private String companyName;
	private Float openingPrice;
	private Double volume;
	private Float closingPrice;
	private static final long serialVersionUID = 1L;

	public Stock() {
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Float getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(Float openingPrice) {
		this.openingPrice = openingPrice;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(Float closingPrice) {
		this.closingPrice = closingPrice;
	}

	@Override
	public String toString() {
		return "Stock [getId()=" + getId() + ", getCurrentPrice()=" + getCurrentPrice() + ", getVolatility()="
				+ getVolatility() + ", getSymbol()=" + getSymbol() + ", companyName=" + companyName + ", openingPrice="
				+ openingPrice + ", volume=" + volume + ", closingPrice=" + closingPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((closingPrice == null) ? 0 : closingPrice.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((openingPrice == null) ? 0 : openingPrice.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		Stock other = (Stock) obj;
		if (closingPrice == null) {
			if (other.closingPrice != null)
				return false;
		} else if (!closingPrice.equals(other.closingPrice))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (openingPrice == null) {
			if (other.openingPrice != null)
				return false;
		} else if (!openingPrice.equals(other.openingPrice))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}
}
