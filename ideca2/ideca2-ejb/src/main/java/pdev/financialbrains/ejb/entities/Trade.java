package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_trade")
public class Trade implements Serializable {

	@Id
	private Integer id;
	
	private Date date;
	private String name;
	private Double value;
	private Integer status;
	
	
	private static final long serialVersionUID = 1L;

	public Trade(){
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}



}
