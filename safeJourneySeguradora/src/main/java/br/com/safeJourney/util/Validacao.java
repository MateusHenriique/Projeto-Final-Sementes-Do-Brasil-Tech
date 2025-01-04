package br.com.safeJourney.util;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.model.Corretor;

public class Validacao {

	public static boolean validaCPFCliente(AppController app, String cpf) {
		boolean validaCliente = false;

		Cliente cliente = app.buscarClientePorCPF(cpf);
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
		} else {
			validaCliente = true;
		}

		return validaCliente;
	}

	public static boolean validaSenhaCliente(AppController app, String cpf, String senha) {
		boolean validaSenhaCliente = false;
		try {
			senha = Criptografia.criptografar(senha);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Cliente cliente = app.buscarClientePorCPF(cpf);
		if (cliente != null) {
			if (cliente.getSenhaCliente().equals(senha)) {
				validaSenhaCliente = true;
			}
		}	
		return validaSenhaCliente;
	}

	public static boolean validaCPFCorretor(AppController app, String cpf) {
		boolean validaCorretor = false;

		Corretor corretor = app.buscarCorretorPorCPF(cpf);
		if (corretor == null) {
			JOptionPane.showMessageDialog(null, "Corretor nao encontrado");
		} else {
			validaCorretor = true;
		}

		return validaCorretor;
	}

	public static boolean validaSenhaCorretor(AppController app, String cpf, String senha) {
		boolean validaSenhaCorretor = false;
		try {
			senha = Criptografia.criptografar(senha);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Corretor corretor = app.buscarCorretorPorCPF(cpf);
		if (corretor != null) {
			if (corretor.getSenhaCorretor().equals(senha))
				validaSenhaCorretor = true;
		}
		return validaSenhaCorretor;
	}
}
