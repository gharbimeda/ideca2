package pdev.financialbrains.ejb.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_bond")
public class Bond extends CashInstrument {

	private Date startDate;
	private Date endDate;
	private String coupon;
	private Integer couponFreq;
	private Integer steppedBound;
	private Boolean rollDate;
	private Boolean firstCoupon;
	private Integer dayCount;
	private Integer yieldMethod;
	private Integer yield;
	private static final long serialVersionUID = 1L;


	public Bond(Integer id, Float currentPrice, Float volatility,
			String symbol, Date startDate, Date endDate, Integer couponFreq,
			Integer steppedBound, Boolean rollDate, Integer yield) {
		super(id, currentPrice, volatility, symbol);
		this.startDate = startDate;
		this.endDate = endDate;
		this.couponFreq = couponFreq;
		this.steppedBound = steppedBound;
		this.rollDate = rollDate;
		this.yield = yield;
	}

	public Bond() {
		// TODO Auto-generated constructor stub
	}
    @Temporal(TemporalType.TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	 @Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Integer getCouponFreq() {
		return couponFreq;
	}

	public void setCouponFreq(Integer couponFreq) {
		this.couponFreq = couponFreq;
	}

	public Integer getSteppedBound() {
		return steppedBound;
	}

	public void setSteppedBound(Integer steppedBound) {
		this.steppedBound = steppedBound;
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

	public Integer getYieldMethod() {
		return yieldMethod;
	}

	public void setYieldMethod(Integer yieldMethod) {
		this.yieldMethod = yieldMethod;
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
		result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
		result = prime * result + ((couponFreq == null) ? 0 : couponFreq.hashCode());
		result = prime * result + ((dayCount == null) ? 0 : dayCount.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((firstCoupon == null) ? 0 : firstCoupon.hashCode());
		result = prime * result + ((rollDate == null) ? 0 : rollDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((steppedBound == null) ? 0 : steppedBound.hashCode());
		result = prime * result + ((yield == null) ? 0 : yield.hashCode());
		result = prime * result + ((yieldMethod == null) ? 0 : yieldMethod.hashCode());
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
		Bond other = (Bond) obj;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		if (couponFreq == null) {
			if (other.couponFreq != null)
				return false;
		} else if (!couponFreq.equals(other.couponFreq))
			return false;
		if (dayCount == null) {
			if (other.dayCount != null)
				return false;
		} else if (!dayCount.equals(other.dayCount))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (steppedBound == null) {
			if (other.steppedBound != null)
				return false;
		} else if (!steppedBound.equals(other.steppedBound))
			return false;
		if (yield == null) {
			if (other.yield != null)
				return false;
		} else if (!yield.equals(other.yield))
			return false;
		if (yieldMethod == null) {
			if (other.yieldMethod != null)
				return false;
		} else if (!yieldMethod.equals(other.yieldMethod))
			return false;
		return true;
	}

	public Bond(Integer id, Float currentPrice, Float volatility, String symbol, Date startDate, Date endDate,
			String coupon, Integer couponFreq, Integer steppedBound, Boolean rollDate, Boolean firstCoupon,
			Integer dayCount, Integer yieldMethod, Integer yield) {
		super(id, currentPrice, volatility, symbol);
		this.startDate = startDate;
		this.endDate = endDate;
		this.coupon = coupon;
		this.couponFreq = couponFreq;
		this.steppedBound = steppedBound;
		this.rollDate = rollDate;
		this.firstCoupon = firstCoupon;
		this.dayCount = dayCount;
		this.yieldMethod = yieldMethod;
		this.yield = yield;
	}

	@Override
	public String toString() {
		return "Bond [startDate=" + startDate + ", endDate=" + endDate + ", coupon=" + coupon + ", couponFreq="
				+ couponFreq + ", steppedBound=" + steppedBound + ", rollDate=" + rollDate + ", firstCoupon="
				+ firstCoupon + ", dayCount=" + dayCount + ", yieldMethod=" + yieldMethod + ", yield=" + yield
				+ ", toString()=" + super.toString() + "]";
	}

	public Bond(Integer id, Float currentPrice, Float volatility, String symbol, String coupon) {
		super(id, currentPrice, volatility, symbol);
		this.coupon = coupon;
	}

	public Bond(Integer couponFreq) {
		super();
		this.couponFreq = couponFreq;
	}

}
