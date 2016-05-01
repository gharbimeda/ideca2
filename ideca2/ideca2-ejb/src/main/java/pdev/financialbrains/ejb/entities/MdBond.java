package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MdBond
 *
 */
@Entity
@Table(name = "t_mdbond")

public class MdBond implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private String maturity;
	private Double yield;
	private Double yesterday;
	private Double lastWeek;
	private Double lastMonth;
	private String type;
	private Date dataB;

	public MdBond() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public Double getYesterday() {
		return yesterday;
	}

	public void setYesterday(Double yesterday) {
		this.yesterday = yesterday;
	}

	public Double getLastWeek() {
		return lastWeek;
	}

	public void setLastWeek(Double lastWeek) {
		this.lastWeek = lastWeek;
	}

	public Double getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(Double lastMonth) {
		this.lastMonth = lastMonth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDataB() {
		return dataB;
	}

	public void setDataB(Date dataB) {
		this.dataB = dataB;
	}

	@Override
	public String toString() {
		return "MdBond [id=" + id + ", maturity=" + maturity + ", yield="
				+ yield + ", yesterday=" + yesterday + ", lastWeek=" + lastWeek
				+ ", lastMonth=" + lastMonth + ", type=" + type + ", dataB="
				+ dataB + "]";
	}
   
}
