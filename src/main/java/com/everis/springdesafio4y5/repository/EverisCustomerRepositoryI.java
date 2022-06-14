package com.everis.springdesafio4y5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz Repositorio
 * 
 * @author jborregb
 *
 */
@Repository
public interface EverisCustomerRepositoryI extends JpaRepository<EverisCustomer, Long> {

	/**
	 * Metodo que busca por nombres y apellidos
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return
	 */
	public List<EverisCustomer> findByNameAndFirstSurnameAndSecondSurname(final String name, final String firstSurname, final String secondSurname);
}
