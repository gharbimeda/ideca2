package pdev.financialbrains.ejb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUser;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "userDest")
	List<Message> messages;
	@OneToMany(mappedBy = "userSource")
	List<Message> messages2;

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
	}}