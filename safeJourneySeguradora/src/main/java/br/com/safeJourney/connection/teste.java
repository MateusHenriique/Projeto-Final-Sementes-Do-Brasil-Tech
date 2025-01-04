package br.com.safeJourney.connection;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.Cliente;

public class teste {

	public static void main(String[] args) {
		AppController app = AppController.getInstance();
		Cliente cliente = app.buscarClientePorCPF("580.757.038-39");
		System.out.println(cliente.getNomeCliente());
		System.out.println(cliente.getEmailCliente());
	}

}
