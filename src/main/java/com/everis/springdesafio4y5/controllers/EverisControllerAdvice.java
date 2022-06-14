package com.everis.springdesafio4y5.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@ControllerAdvice
public class EverisControllerAdvice {

	/**
	 * Capta cualquier excepción en los métodos de cualquier controlador.
	 * 
	 * @return @ResponseBody String
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorMsg", e.getMessage());

		return "error";
	}

}
