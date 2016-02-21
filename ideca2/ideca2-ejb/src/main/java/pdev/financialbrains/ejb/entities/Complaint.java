package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import pdev.financialbrains.ejb.entities.User;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Complaint
 *
 */
@Entity
@Table(name = "t_complaint")
public class Complaint implements Serializable {

	@Id
	private int id;
	private String object;
	private String text;
	private Date date;
	@ManyToOne
	private User user;

	public Complaint(String object, String text, Date date) {
		super();
		this.object = object;
		this.text = text;
		this.date = date;
	}

	private static final long serialVersionUID = 1L;

	public Complaint(String object, String text, User user, Date date) {
		super();
		this.object = object;
		this.text = text;
		this.user = user;
	}

	public Complaint() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", object=" + object + ", text=" + text + ", date=" + date + ", user=" + user
				+ "]";
	}

}