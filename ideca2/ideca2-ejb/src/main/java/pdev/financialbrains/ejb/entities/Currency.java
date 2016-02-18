package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_currency")
public class Currency extends CashInstrument {

	private Float openingPrice;
	private Float closingPrice;
	private Double volume;
	private static final long serialVersionUID = 1L;

	public Currency() {
	}

	public Float getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(Float openingPrice) {
		this.openingPrice = openingPrice;
	}

	public Float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(Float closingPrice) {
		this.closingPrice = closingPrice;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((closingPrice == null) ? 0 : closingPrice.hashCode());
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
		Currency other = (Currency) obj;
		if (closingPrice == null) {
			if (other.closingPrice != null)
				return false;
		} else if (!closingPrice.equals(other.closingPrice))
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

	@Override
	public String toString() {
		return "Currency [getId()=" + getId() + ", getVolatility()=" + getVolatility() + ", getCurrentPrice()="
				+ getCurrentPrice() + ", getSymbol()=" + getSymbol() + ", openingPrice=" + openingPrice
				+ ", closingPrice=" + closingPrice + ", volume=" + volume + "]";
	}

}
