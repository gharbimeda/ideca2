package pdev.financialbrains.ejb.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="t_option")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Option extends DerivativeInstrument {

	private Boolean buySell;
	private Date expiration;
	private Integer riskFree;
	private Float strikePrice;
	private static final long serialVersionUID = 1L;

	public Option() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getBuySell() {
		return buySell;
	}

	public void setBuySell(Boolean buySell) {
		this.buySell = buySell;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Integer getRiskFree() {
		return riskFree;
	}

	public void setRiskFree(Integer riskFree) {
		this.riskFree = riskFree;
	}

	public Float getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Float strikePrice) {
		this.strikePrice = strikePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((buySell == null) ? 0 : buySell.hashCode());
		result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + ((riskFree == null) ? 0 : riskFree.hashCode());
		result = prime * result + ((strikePrice == null) ? 0 : strikePrice.hashCode());
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
		Option other = (Option) obj;
		if (buySell == null) {
			if (other.buySell != null)
				return false;
		} else if (!buySell.equals(other.buySell))
			return false;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (riskFree == null) {
			if (other.riskFree != null)
				return false;
		} else if (!riskFree.equals(other.riskFree))
			return false;
		if (strikePrice == null) {
			if (other.strikePrice != null)
				return false;
		} else if (!strikePrice.equals(other.strikePrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Option [buySell=" + buySell + ", expiration=" + expiration + ", riskFree=" + riskFree + ", strikePrice="
				+ strikePrice + "]";
	}
}