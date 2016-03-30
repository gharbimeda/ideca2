package pdev.financialbrains.ejb.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_trade")
public class Trade implements Serializable {

	@EmbeddedId
    private TradePK tradePK;
	private String name;
	private Double value;
	private Integer status;
	@ManyToOne
	@JoinColumn(referencedColumnName="idUser", name="idUser", updatable=false, insertable=false)
	private Trader trader;
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="id", updatable=false, insertable=false)
	private FinancialInstrument financialInstrument;
	private static final long serialVersionUID = 1L;

	public Trade() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}


	public Integer getStatus() {
		return status;
	}

	public String getStatusString() {
		if (this.status == 0)
			return "DISAPROVED";
		else if (this.status == 1)
			return "APPROVED";
		else
			return "PENDING";
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



}
