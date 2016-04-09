package pdev.financialbrains.ejb.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_capFloor")
public class CapFloor extends Option {

	private Integer firstPeriod;
	private String referenceIndex;
	private Integer tenor;
	private Integer lastFixing;
	private Integer dayCount;
	private Double notionalAmount;
	private Integer capFloor;
	private static final long serialVersionUID = 1L;

	public CapFloor() {
		// TODO Auto-generated constructor stub
	}

	public Integer getFirstPeriod() {
		return firstPeriod;
	}

	public void setFirstPeriod(Integer firstPeriod) {
		this.firstPeriod = firstPeriod;
	}

	public String getReferenceIndex() {
		return referenceIndex;
	}

	public void setReferenceIndex(String referenceIndex) {
		this.referenceIndex = referenceIndex;
	}

	public Integer getTenor() {
		return tenor;
	}

	public void setTenor(Integer tenor) {
		this.tenor = tenor;
	}

	public Integer getLastFixing() {
		return lastFixing;
	}

	public void setLastFixing(Integer lastFixing) {
		this.lastFixing = lastFixing;
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public Double getNotionalAmount() {
		return notionalAmount;
	}

	public void setNotionalAmount(Double notionalAmount) {
		this.notionalAmount = notionalAmount;
	}


	public Integer getCapFloor() {
		return capFloor;
	}
	
	public String getCapFloorString(){
		if (capFloor == 0){
			return "CAP";
		}else return "FLOOR";
	}

	public void setCapFloor(Integer capFloor) {
		this.capFloor = capFloor;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dayCount == null) ? 0 : dayCount.hashCode());
		result = prime * result + ((firstPeriod == null) ? 0 : firstPeriod.hashCode());
		result = prime * result + ((lastFixing == null) ? 0 : lastFixing.hashCode());
		result = prime * result + ((notionalAmount == null) ? 0 : notionalAmount.hashCode());
		result = prime * result + ((referenceIndex == null) ? 0 : referenceIndex.hashCode());
		result = prime * result + ((tenor == null) ? 0 : tenor.hashCode());
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
		CapFloor other = (CapFloor) obj;
		if (dayCount == null) {
			if (other.dayCount != null)
				return false;
		} else if (!dayCount.equals(other.dayCount))
			return false;
		if (firstPeriod == null) {
			if (other.firstPeriod != null)
				return false;
		} else if (!firstPeriod.equals(other.firstPeriod))
			return false;
		if (lastFixing == null) {
			if (other.lastFixing != null)
				return false;
		} else if (!lastFixing.equals(other.lastFixing))
			return false;
		if (notionalAmount == null) {
			if (other.notionalAmount != null)
				return false;
		} else if (!notionalAmount.equals(other.notionalAmount))
			return false;
		if (referenceIndex == null) {
			if (other.referenceIndex != null)
				return false;
		} else if (!referenceIndex.equals(other.referenceIndex))
			return false;
		if (tenor == null) {
			if (other.tenor != null)
				return false;
		} else if (!tenor.equals(other.tenor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CapFloor [firstPeriod=" + firstPeriod + ", referenceIndex=" + referenceIndex + ", tenor=" + tenor
				+ ", lastFixing=" + lastFixing + ", dayCount=" + dayCount + ", notionalAmount=" + notionalAmount + "]";
	}

	

}
