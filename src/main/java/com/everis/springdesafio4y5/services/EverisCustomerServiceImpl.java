package com.everis.springdesafio4y5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springdesafio4y5.repository.EverisCustomerRepositoryI;
import com.everis.springdesafio4y5.repository.EverisCustomer;

/**
 * Servicio: Gestion de clientes
 * 
 * @author jborregb
 *
 */
@Service
public class EverisCustomerServiceImpl implements EverisCustomerServiceI {

	/** Repositorio: customers */
	@Autowired
	private EverisCustomerRepositoryI customerRepository;

	@Override
	public List<EverisCustomer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<EverisCustomer> getCustomerByNameAndFirstSurnameAndSecondSurname(final String name, final String firstSurname, final String secondSurname) {
		return customerRepository.findByNameAndFirstSurnameAndSecondSurname(name, firstSurname, secondSurname);
	}

	@Override
	public void removeCustomerById(final Long customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public void addCustomer(final EverisCustomer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void updCustomer(final EverisCustomer customer) {
		customerRepository.save(customer);
	}
}
