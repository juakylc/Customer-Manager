package com.everis.springdesafio4y5.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.springdesafio4y5.repository.EverisCustomer;
import com.everis.springdesafio4y5.services.EverisCustomerServiceI;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Controller
public class EverisCustomerController {

	/**
	 * Servicio: gestión de clientes.
	 */
	@Autowired
	private EverisCustomerServiceI customersService;

	/**
	 * Muestra todos los clientes.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/showCustomersView")
	public String showCustomers(Model model) {

		// Obtención de clientes.
		final List<EverisCustomer> customersList = customersService.getAllCustomers();

		// Carga de datos al modelo.
		model.addAttribute("customersListView", customersList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.FALSE);

		return "showCustomers";
	}

	/**
	 * Elimina un cliente
	 * 
	 * @param customerId
	 * @param model
	 * @return
	 */
	@PostMapping("/actDropCustomer")
	public String deleteCustomer(@RequestParam String customerId, Model model) {

		// Eliminación de clientes.
		customersService.removeCustomerById(Long.valueOf(customerId));

		return "redirect:showCustomersView";
	}

	/**
	 * Método de consulta.
	 * 
	 * @param searchedCustomer
	 * @param model
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actSearchCustomer")
	public String submitSearchCustomerForm(@ModelAttribute EverisCustomer searchedCustomer, Model model) throws Exception {

		// Posibilidad de múltiples resultados.
		List<EverisCustomer> customersList = new ArrayList<EverisCustomer>();

		final String name = searchedCustomer.getName();
		final String customerFirstSurname = searchedCustomer.getFirstSurname();
		final String customerSecondSurname = searchedCustomer.getSecondSurname();

		if (StringUtils.hasText(name)) {

			// Búsqueda por nombre.
			final EverisCustomer customer = customersService.getCustomerByNameAndFirstSurnameAndSecondSurname(name, customerFirstSurname, customerSecondSurname).get(0);

			if (customer != null) {
				customersList.add(customer);
			}

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		// Carga de datos al modelo.
		model.addAttribute("customersListView", customersList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.TRUE);

		return "showCustomers";
	}

	/**
	 * Método de inserción de cliente.
	 * 
	 * @param newCustomer
	 * @param result
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actAddCustomer")
	private String submitAddCustomerForm(@Valid @ModelAttribute EverisCustomer newCustomer, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de insercion erróneos.");
		} else {

			// Se añade el nuevo cliente.
			customersService.addCustomer(newCustomer);
		}

		return "redirect:showCustomersView";
	}

}
