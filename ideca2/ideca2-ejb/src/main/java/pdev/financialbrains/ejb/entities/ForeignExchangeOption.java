package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_foreignExchangeOption")
public class ForeignExchangeOption extends Option {

	private Integer spotFx;
	private Integer callPut;
	private Float volatilite;
	private Integer domesticRiskFree;
	private Integer MaturityDate;
	
	private static final long serialVersionUID = 1L;

	public ForeignExchangeOption() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSpotFx() {
		return spotFx;
	}

	public void setSpotFx(Integer spotFx) {
		this.spotFx = spotFx;
	}

	public Integer getDomesticRiskFree() {
		return domesticRiskFree;
	}
	public void setDomesticRiskFree(Integer domesticRiskFree) {
		this.domesticRiskFree = domesticRiskFree;
	}

	public Float getVolatilite() {
		return volatilite;
	}

	public void setVolatilite(Float volatilite) {
		this.volatilite = volatilite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domesticRiskFree == null) ? 0 : domesticRiskFree.hashCode());
		result = prime * result + ((spotFx == null) ? 0 : spotFx.hashCode());
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
		ForeignExchangeOption other = (ForeignExchangeOption) obj;
		if (domesticRiskFree == null) {
			if (other.domesticRiskFree != null)
				return false;
		} else if (!domesticRiskFree.equals(other.domesticRiskFree))
			return false;
		if (spotFx == null) {
			if (other.spotFx != null)
				return false;
		} else if (!spotFx.equals(other.spotFx))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ForeignExchangeOption [getId()=" + getId() + ", getVolatility()=" + getVolatility()
				+ ", getCurrentPrice()=" + getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()="
				+ getEndDate() + ", getBuySell()=" + getBuySell() + ", getExpiration()=" + getExpiration()
				+ ", getRiskFree()=" + getRiskFree() + ", getStrikePrice()=" + getStrikePrice() + ", spotFx=" + spotFx
				+ ", domesticRiskFree=" + domesticRiskFree + "]";
	}

	public Integer getMaturityDate() {
		return MaturityDate;
	}

	public void setMaturityDate(Integer maturityDate) {
		MaturityDate = maturityDate;
	}

	public Integer getCallPut() {
		return callPut;
	}

	public void setCallPut(Integer callPut) {
		this.callPut = callPut;
	}

}
