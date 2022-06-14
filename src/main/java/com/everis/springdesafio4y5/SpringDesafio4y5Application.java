package com.everis.springdesafio4y5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.springdesafio4y5.repository.EverisCustomer;
import com.everis.springdesafio4y5.services.EverisCustomerServiceI;

@SpringBootApplication
public class SpringDesafio4y5Application implements CommandLineRunner {

	/**
	 * Servicio de gestión del cliente
	 */
	@Autowired
	private EverisCustomerServiceI customerService;

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringDesafio4y5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creacion de clientes
		EverisCustomer customer1 = new EverisCustomer();
		customer1.setName("Juan Alejandro");
		customer1.setFirstSurname("Tellez");
		customer1.setSecondSurname("Rubio");
		customer1.setDni("12345678M");

		EverisCustomer customer2 = new EverisCustomer();
		customer2.setName("Joaquin");
		customer2.setFirstSurname("Borrego");
		customer2.setSecondSurname("Fernandez");
		customer2.setDni("12345679M");

		EverisCustomer customer3 = new EverisCustomer();
		customer3.setName("Jose Antonio");
		customer3.setFirstSurname("Gonzalez");
		customer3.setSecondSurname("Arboledas");
		customer3.setDni("12345688M");

		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
		customerService.addCustomer(customer3);

		System.out.println("------------");

	}

}
