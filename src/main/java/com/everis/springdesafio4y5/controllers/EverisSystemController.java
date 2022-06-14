package com.everis.springdesafio4y5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Controller
@RequestMapping("*")
public class EverisSystemController {

	/**
	 * Capta cualquier solicitud.
	 * 
	 * @return String
	 */
	@GetMapping
	public String showIndex() {
		return "index";
	}

	/**
	 * Redirecciona al controlador de gestión de clientes.
	 * 
	 * @return String
	 */
	@GetMapping("/customersView")
	public String redirectToCustomerController() {
		return "redirect:showCustomersView";
	}

	/**
	 * Redirecciona a la plantilla de búsqueda.
	 * 
	 * @return String
	 */
	@GetMapping("/searchCustomerByView")
	public String redirectToCustomerSearchByTemplate() {
		return "searchCustomerBy";
	}

	/**
	 * Redirecciona a la plantilla de insercción.
	 * 
	 * @return String
	 */
	@GetMapping("/newCustomerView")
	public String redirectToNewCustomerTemplate() {
		return "newCustomer";
	}

}
