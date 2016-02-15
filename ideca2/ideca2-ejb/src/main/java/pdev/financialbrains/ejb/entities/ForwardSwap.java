package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_forwardSwap")
public class ForwardSwap extends DerivativeInstrument {

	private Boolean steppedNotional;
	private Float fixedRate;
	private Integer paymentFreq;
	private Boolean interestSteps;
	private Boolean rollDate;
	private Boolean firstCoupon;
	private Integer dayCount;
	private static final long serialVersionUID = 1L;

	public ForwardSwap() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getSteppedNotional() {
		return steppedNotional;
	}

	public void setSteppedNotional(Boolean steppedNotional) {
		this.steppedNotional = steppedNotional;
	}

	public Float getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(Float fixedRate) {
		this.fixedRate = fixedRate;
	}

	public Integer getPaymentFreq() {
		return paymentFreq;
	}

	public void setPaymentFreq(Integer paymentFreq) {
		this.paymentFreq = paymentFreq;
	}

	public Boolean getInterestSteps() {
		return interestSteps;
	}

	public void setInterestSteps(Boolean interestSteps) {
		this.interestSteps = interestSteps;
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

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dayCount == null) ? 0 : dayCount.hashCode());
		result = prime * result + ((firstCoupon == null) ? 0 : firstCoupon.hashCode());
		result = prime * result + ((fixedRate == null) ? 0 : fixedRate.hashCode());
		result = prime * result + ((interestSteps == null) ? 0 : interestSteps.hashCode());
		result = prime * result + ((paymentFreq == null) ? 0 : paymentFreq.hashCode());
		result = prime * result + ((rollDate == null) ? 0 : rollDate.hashCode());
		result = prime * result + ((steppedNotional == null) ? 0 : steppedNotional.hashCode());
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
		ForwardSwap other = (ForwardSwap) obj;
		if (dayCount == null) {
			if (other.dayCount != null)
				return false;
		} else if (!dayCount.equals(other.dayCount))
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
		if (interestSteps == null) {
			if (other.interestSteps != null)
				return false;
		} else if (!interestSteps.equals(other.interestSteps))
			return false;
		if (paymentFreq == null) {
			if (other.paymentFreq != null)
				return false;
		} else if (!paymentFreq.equals(other.paymentFreq))
			return false;
		if (rollDate == null) {
			if (other.rollDate != null)
				return false;
		} else if (!rollDate.equals(other.rollDate))
			return false;
		if (steppedNotional == null) {
			if (other.steppedNotional != null)
				return false;
		} else if (!steppedNotional.equals(other.steppedNotional))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ForwardSwap [getId()=" + getId() + ", getVolatility()=" + getVolatility() + ", getCurrentPrice()="
				+ getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", steppedNotional=" + steppedNotional + ", fixedRate=" + fixedRate + ", paymentFreq=" + paymentFreq
				+ ", interestSteps=" + interestSteps + ", rollDate=" + rollDate + ", firstCoupon=" + firstCoupon
				+ ", dayCount=" + dayCount + "]";
	}

}
