package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_fixedIncomeSecuritie")
public class FixedIncomeSecuritie extends DerivativeInstrument {

	private Integer notional;
	private Integer couponFreq;
	private Boolean steppedBond;
	private Boolean rollDate;
	private Boolean firstCoupon;
	private Boolean weekend;
	private Integer yield;
	private static final long serialVersionUID = 1L;

	public FixedIncomeSecuritie() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNotional() {
		return notional;
	}

	public void setNotional(Integer notional) {
		this.notional = notional;
	}

	public Integer getCouponFreq() {
		return couponFreq;
	}

	public void setCouponFreq(Integer couponFreq) {
		this.couponFreq = couponFreq;
	}

	public Boolean getSteppedBond() {
		return steppedBond;
	}

	public void setSteppedBond(Boolean steppedBond) {
		this.steppedBond = steppedBond;
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

	public Boolean getWeekend() {
		return weekend;
	}

	public void setWeekend(Boolean weekend) {
		this.weekend = weekend;
	}

	public Integer getYield() {
		return yield;
	}

	public void setYield(Integer yield) {
		this.yield = yield;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((couponFreq == null) ? 0 : couponFreq.hashCode());
		result = prime * result + ((firstCoupon == null) ? 0 : firstCoupon.hashCode());
		result = prime * result + ((notional == null) ? 0 : notional.hashCode());
		result = prime * result + ((rollDate == null) ? 0 : rollDate.hashCode());
		result = prime * result + ((steppedBond == null) ? 0 : steppedBond.hashCode());
		result = prime * result + ((weekend == null) ? 0 : weekend.hashCode());
		result = prime * result + ((yield == null) ? 0 : yield.hashCode());
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
		FixedIncomeSecuritie other = (FixedIncomeSecuritie) obj;
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
		if (notional == null) {
			if (other.notional != null)
				return false;
		} else if (!notional.equals(other.notional))
			return false;
		if (rollDate == null) {
			if (other.rollDate != null)
				return false;
		} else if (!rollDate.equals(other.rollDate))
			return false;
		if (steppedBond == null) {
			if (other.steppedBond != null)
				return false;
		} else if (!steppedBond.equals(other.steppedBond))
			return false;
		if (weekend == null) {
			if (other.weekend != null)
				return false;
		} else if (!weekend.equals(other.weekend))
			return false;
		if (yield == null) {
			if (other.yield != null)
				return false;
		} else if (!yield.equals(other.yield))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FixedIncomeSecuritie [getId()=" + getId() + ", getVolatility()=" + getVolatility()
				+ ", getCurrentPrice()=" + getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()="
				+ getEndDate() + ", notional=" + notional + ", couponFreq=" + couponFreq + ", steppedBond="
				+ steppedBond + ", rollDate=" + rollDate + ", firstCoupon=" + firstCoupon + ", weekend=" + weekend
				+ ", yield=" + yield + "]";
	}

}
