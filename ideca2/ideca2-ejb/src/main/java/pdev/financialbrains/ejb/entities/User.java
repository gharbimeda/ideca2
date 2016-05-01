package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue(value="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUser;
	private String login;
	private String password;
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	private List<Complaint> complaints;
	@OneToMany(mappedBy = "userDest",fetch=FetchType.LAZY)
	private List<Message> messages;
	@OneToMany(mappedBy = "userSource",fetch=FetchType.LAZY)
	private List<Message> messages2;
	private static final long serialVersionUID = 1L;

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, List<Message> messages) {
		super();
		this.login = login;
		this.password = password;
		this.messages = messages;
	}

	public User() {
		super();
	}

	public int getIdUser() {
		return this.IdUser;
	}

	public void setIdUser(int IdUser) {
		this.IdUser = IdUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(int idUser, String login, String password) {
		super();
		IdUser = idUser;
		this.login = login;
		this.password = password;
	}

	public User(int idUser) {
		super();
		IdUser = idUser;
	}

	public String toString1() {
		return "User [IdUser=" + IdUser + ", login=" + login + ", password=" + password + "]";
	}

	public String toString() {
		return login;
	}
}