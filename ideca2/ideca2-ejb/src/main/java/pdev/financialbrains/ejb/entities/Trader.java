package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="trader")
public class Trader extends User implements Serializable {

	private Integer cin;
	private String adress;
	private String company;
	private Integer creditCard;
	private Date dateOfBirth;
	private String firstName;
	private String lastName;
	private String job;
	private String nationality;
	private String phoneNumber;

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Trader() {
		super();
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Integer creditCard) {
		this.creditCard = creditCard;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
