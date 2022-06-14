package com.everis.springdesafio4y5.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springdesafio4y5.repository.EverisCustomer;
import com.everis.springdesafio4y5.services.EverisCustomerServiceI;

@RestController
@RequestMapping("/customers")
public class EverisCustomerRestController {

	/** Servicio: gestión de clientes */
	@Autowired
	private EverisCustomerServiceI customerService;

	@GetMapping
	public List<EverisCustomer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@DeleteMapping("/{identifCustomer}")
	public void deleteCustomer(@PathVariable Long identifCustomer) {
		customerService.removeCustomerById(identifCustomer);
	}

	@GetMapping("/customer")
	public List<EverisCustomer> searchBy(@RequestBody EverisCustomer searchedCustomer) throws Exception {

		// Posibilidad de múltiples resultados.
		List<EverisCustomer> customersList = new ArrayList<EverisCustomer>();

		final String name = searchedCustomer.getName();
		final String customerFirstSurname = searchedCustomer.getFirstSurname();
		final String customerSecondSurname = searchedCustomer.getSecondSurname();

		if (StringUtils.hasText(name)) {

			// Búsqueda por nombre
			final EverisCustomer customer = customerService.getCustomerByNameAndFirstSurnameAndSecondSurname(name, customerFirstSurname, customerSecondSurname).get(0);

			if (customer != null) {
				customersList.add(customer);
			}

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		return customersList;

	}
	
	@PutMapping("/customer")
	public void deleteCustomer(@RequestBody EverisCustomer newCustomer) {
		customerService.addCustomer(newCustomer);
	}

}
