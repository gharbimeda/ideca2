package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_trade")
public class Trade implements Serializable {

	@EmbeddedId
	private TradePK pk;
	private String name;
	private Float value;	
	private Integer status;
	private Integer putcall;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="idUser", name="idUser", updatable=false, insertable=false)
	private Trader trader;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id", name="id", updatable=false, insertable=false)
	private DerivativeInstrument fi;
	private static final long serialVersionUID = 1L;

	public Trade() {
		// TODO Auto-generated constructor stub
	}


	public TradePK getPk() {
		return pk;
	}


	public void setPk(TradePK pk) {
		this.pk = pk;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
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


	public Trader getTrader() {
		return trader;
	}


	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public Integer getPutcall() {
		return putcall;
	}
	
	public String getPutcallString() {
		if (this.putcall == 0)
			return "PUT";
		else
			return "CALL";
	}


	public void setPutcall(Integer putcall) {
		this.putcall = putcall;
	}


	public DerivativeInstrument getFi() {
		return fi;
	}


	public void setFi(DerivativeInstrument fi) {
		this.fi = fi;
	}



}
