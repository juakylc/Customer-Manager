package com.everis.springdesafio4y5.services;

import java.util.List;

import com.everis.springdesafio4y5.repository.EverisCustomer;

/**
 * Servicio: gestion de clientes
 * 
 * @author jborregb
 *
 */
public interface EverisCustomerServiceI {

	/**
	 * Obtiene el listado de clientes
	 * 
	 * @return List<EverisCustomer>
	 */
	public List<EverisCustomer> getAllCustomers();

	/**
	 * 
	 * @param carRegistration
	 * @return
	 */
	public List<EverisCustomer> getCustomerByNameAndFirstSurnameAndSecondSurname(String name, String firstSurname, String secondSurname);

	/**
	 * Elimina un cliente por ID.
	 * 
	 * @param customerId
	 */
	public void removeCustomerById(final Long customerId);

	/**
	 * Añade un cliente.
	 * 
	 * @param customer
	 */
	public void addCustomer(final EverisCustomer customer);

	/**
	 * Actualiza un cliente.
	 * 
	 * @param customer
	 */
	public void updCustomer(final EverisCustomer customer);

}
