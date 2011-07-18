package de.jeha.spring_hibernate_hazelcast_webapp.struts2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Benutzer.
 * 
 * @author jeha
 */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
@SequenceGenerator(name = "SEQ_BENUTZER", sequenceName = "SEQ_BENUTZER")
@Cache(region = "user", usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

	/**
	 * ID des Benutzers
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_BENUTZER")
	private Long id;

	/**
	 * Name des Benutzers
	 */
	@NotNull
	@Column(name = "username")
	private String username;

	/**
	 * EMail-Adresse des Benutzers
	 */
	@Column(name = "email")
	@Email(message = "benutzer.email.invalid")
	@Length(max = 255, message = "error.maxLengthExceeded")
	private String email;

	/**
	 * Getter-Methode für das Attribut id.
	 * 
	 * @return das Attribut id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter-Methode für das Attribut id.
	 * 
	 * @param id
	 *            - das zu setzende Attribut id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter-Methode für das Attribut username.
	 * 
	 * @return das Attribut username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter-Methode für das Attribut username.
	 * 
	 * @param username
	 *            - das zu setzende Attribut username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter-Methode für das Attribut email.
	 * 
	 * @return das Attribut email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter-Methode für das Attribut email.
	 * 
	 * @param email
	 *            - das zu setzende Attribut email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
