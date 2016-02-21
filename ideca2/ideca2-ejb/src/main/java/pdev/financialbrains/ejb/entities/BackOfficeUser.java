package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Back_Office_User
 *
 */
@Entity
@DiscriminatorValue(value="backoffuser")

public class BackOfficeUser extends User implements Serializable {


	
	private Date dateOfBirth;
	private String firstName;
	private String lastName;
	private String position;
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BackOfficeUser() {
		super();
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
   
}
