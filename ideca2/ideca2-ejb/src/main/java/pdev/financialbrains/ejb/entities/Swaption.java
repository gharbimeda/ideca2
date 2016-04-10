package pdev.financialbrains.ejb.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_swaption")
public class Swaption extends Option {

	private Boolean firstCoupon;
	private Integer dayCount;
	private Boolean rollDate;
	private static final long serialVersionUID = 1L;

	public Swaption() {
		// TODO Auto-generated constructor stub
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

	public Boolean getRollDate() {
		return rollDate;
	}

	public void setRollDate(Boolean rollDate) {
		this.rollDate = rollDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dayCount == null) ? 0 : dayCount.hashCode());
		result = prime * result + ((firstCoupon == null) ? 0 : firstCoupon.hashCode());
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
		Swaption other = (Swaption) obj;
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
		if (rollDate == null) {
			if (other.rollDate != null)
				return false;
		} else if (!rollDate.equals(other.rollDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Swaption [getId()=" + getId() + ", getVolatility()=" + getVolatility() + ", getCurrentPrice()="
				+ getCurrentPrice() + ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", getBuySell()=" + getBuySell() + ", getExpiration()=" + getExpiration() + ", getRiskFree()="
				+ getRiskFree() + ", getStrikePrice()=" + getStrikePrice() + ", firstCoupon=" + firstCoupon
				+ ", dayCount=" + dayCount + ", rollDate=" + rollDate + "]";
	}

}
