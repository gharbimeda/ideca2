package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_message")

public class Message implements Serializable {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String texte;
	private Date date;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "userDest")
	private User userDest;
	@ManyToOne
	@JoinColumn(name = "userSource")
	private User userSource;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUserDest() {
		return userDest;
	}
	public void setUserDest(User userDest) {
		this.userDest = userDest;
	}
	public User getUserSource() {
		return userSource;
	}
	public void setUserSource(User userSource) {
		this.userSource = userSource;
	}
	public Message(Integer id, String texte, Date date, User userDest, User userSource) {
		super();
		this.id = id;
		this.texte = texte;
		this.date = date;
		this.userDest = userDest;
		this.userSource = userSource;
	}
	public Message() {
		super();
	}
	public Message(String texte, Date date, User userDest, User userSource) {
		super();
		this.texte = texte;
		this.date = date;
		this.userDest = userDest;
		this.userSource = userSource;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", texte=" + texte + ", date=" + date + ", userDest=" + userDest + ", userSource="
				+ userSource + "]";
	}
	public Message(String texte, Date date) {
		super();
		this.texte = texte;
		this.date = date;
	}
	public Message(String texte) {
		super();
		this.texte = texte;
	}
	public Message(String texte, User userDest, User userSource) {
		super();
		this.texte = texte;
		this.userDest = userDest;
		this.userSource = userSource;
	}
	public Message(Integer id, String texte) {
		super();
		this.id = id;
		this.texte = texte;
	}

	
}
