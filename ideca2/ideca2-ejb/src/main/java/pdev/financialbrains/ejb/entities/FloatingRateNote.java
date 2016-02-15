package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_floatingRateNote")
public class FloatingRateNote extends DerivativeInstrument {

	private Boolean notional;
	private Integer fixedRate;
	private Boolean rollDate;
	private Boolean firstCoupon;
	private String referenceRate;
	private Integer couponFreq;
	private Integer lastFixing;
	private static final long serialVersionUID = 1L;

	public FloatingRateNote() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getNotional() {
		return notional;
	}

	public void setNotional(Boolean notional) {
		this.notional = notional;
	}

	public Integer getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(Integer fixedRate) {
		this.fixedRate = fixedRate;
	}

	public Boolean getRollDate() {
		return rollDate;
	}

	public void setRollDate(Boolean rollDate) {
		this.rollDate = rollDate;
	}

	public Boolean getFirstCoupon() {
		return firstCoupon;
	}

	public void setFirstCoupon(Boolean firstCoupon) {
		this.firstCoupon = firstCoupon;
	}

	public String getReferenceRate() {
		return referenceRate;
	}

	public void setReferenceRate(String referenceRate) {
		this.referenceRate = referenceRate;
	}

	public Integer getCouponFreq() {
		return couponFreq;
	}

	public void setCouponFreq(Integer couponFreq) {
		this.couponFreq = couponFreq;
	}

	public Integer getLastFixing() {
		return lastFixing;
	}

	public void setLastFixing(Integer lastFixing) {
		this.lastFixing = lastFixing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((couponFreq == null) ? 0 : couponFreq.hashCode());
		result = prime * result + ((firstCoupon == null) ? 0 : firstCoupon.hashCode());
		result = prime * result + ((fixedRate == null) ? 0 : fixedRate.hashCode());
		result = prime * result + ((lastFixing == null) ? 0 : lastFixing.hashCode());
		result = prime * result + ((notional == null) ? 0 : notional.hashCode());
		result = prime * result + ((referenceRate == null) ? 0 : referenceRate.hashCode());
		result = prime * result + ((rollDate == null) ? 0 : rollDate.hashCode());
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
		FloatingRateNote other = (FloatingRateNote) obj;
		if (couponFreq == null) {
			if (other.couponFreq != null)
				return false;
		} else if (!couponFreq.equals(other.couponFreq))
			return false;
		if (firstCoupon == null) {
			if (other.firstCoupon != null)
				return false;
		} else if (!firstCoupon.equals(other.firstCoupon))
			return false;
		if (fixedRate == null) {
			if (other.fixedRate != null)
				return false;
		} else if (!fixedRate.equals(other.fixedRate))
			return false;
		if (lastFixing == null) {
			if (other.lastFixing != null)
				return false;
		} else if (!lastFixing.equals(other.lastFixing))
			return false;
		if (notional == null) {
			if (other.notional != null)
				return false;
		} else if (!notional.equals(other.notional))
			return false;
		if (referenceRate == null) {
			if (other.referenceRate != null)
				return false;
		} else if (!referenceRate.equals(other.referenceRate))
			return false;
		if (rollDate == null) {
			if (other.rollDate != null)
				return false;
		} else if (!rollDate.equals(other.rollDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FloatingRateNote [getId()=" + getId() + ", getVolatility()=" + getVolatility() + ", getCurrentPrice()="
				+ getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", notional=" + notional + ", fixedRate=" + fixedRate + ", rollDate=" + rollDate + ", firstCoupon="
				+ firstCoupon + ", referenceRate=" + referenceRate + ", couponFreq=" + couponFreq + ", lastFixing="
				+ lastFixing + "]";
	}

}
