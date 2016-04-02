package pdev.financialbrains.ejb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_derivativeInstrument")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DerivativeInstrument extends FinancialInstrument {

	private Date startDate;
	private Date endDate;
	//@OneToMany(mappedBy="fi")
	//private List<Trade> trades;
	private static final long serialVersionUID = 1L;

	public DerivativeInstrument() {
		// TODO Auto-generated constructor stub
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		DerivativeInstrument other = (DerivativeInstrument) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DerivativeInstrument [getId()=" + getId() + ", getCurrentPrice()=" + getCurrentPrice()
				+ ", getVolatility()=" + getVolatility() + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public DerivativeInstrument(Integer id, Float currentPrice, Float volatility, Date startDate, Date endDate) {
		super(id, currentPrice, volatility);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public DerivativeInstrument(Integer id, Float currentPrice, Float volatility) {
		super(id, currentPrice, volatility);
	}

	public DerivativeInstrument(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}



}