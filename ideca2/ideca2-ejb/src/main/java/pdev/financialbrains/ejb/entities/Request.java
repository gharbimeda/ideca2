package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.GroupSequence;

/**
 * Entity implementation class for Entity: Request
 *
 */
@Entity
@Table(name="t_request")

public class Request implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String mail;
	private String job;
	private String company;
	private String accountType;
	private static final long serialVersionUID = 1L;

	public Request() {
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}   
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
   
}
