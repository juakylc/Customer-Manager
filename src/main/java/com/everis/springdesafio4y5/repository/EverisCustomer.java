package com.everis.springdesafio4y5.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Entidad del cliente
 * 
 * @author jborregb
 *
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "customers")
public class EverisCustomer implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del cliente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	/**
	 * Nombre del cliente
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * Primer apellido del cliente
	 */
	@Column(name = "firstSurname", nullable = false)
	private String firstSurname;

	/**
	 * Segundo apellido del cliente
	 */
	@Column(name = "secondSurname", nullable = true)
	private String secondSurname;

	/**
	 * DNI del cliente
	 */
	@Column(name = "dni", length = 9, nullable = false, unique = true)
	private String dni;

	/**
	 * Fecha de nacimiento del cliente
	 */
	@Column(name = "birthDate")
	private Date birthDate;

	/**
	 * 
	 * @return customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            the id to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return firstSurname
	 */
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * 
	 * @param firstSurname
	 *            the firstSurname to set
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * 
	 * @return secondSurname
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * 
	 * @param secondSurname
	 *            the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * 
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * 
	 * @return birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * 
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Metodo que devuelve un String que representa al objeto
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "EverisCustomer [customerId=" + customerId + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname=" + secondSurname + ", dni="
		        + dni + ", birthDate=" + birthDate + "]";
	}

}