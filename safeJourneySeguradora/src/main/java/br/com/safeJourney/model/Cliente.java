package br.com.safeJourney.model;

import java.security.NoSuchAlgorithmException;

import br.com.safeJourney.util.Criptografia;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
    
    // Campos da classe Cliente
    private String nomeCliente, emailCliente, telefoneCliente, dataNascCliente, cpfCliente, generoCliente, senhaCliente;
    private Long idCliente; // Relacionamento com a classe Apolice 

    // Construtor da classe Cliente
    public Cliente(String cpfCliente, String nomeCliente, String dataNascCliente, String emailCliente, String telefoneCliente,
            String generoCliente, String senhaCliente) {
        // Inicializa os campos com os valores fornecidos como parâmetros
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataNascCliente = dataNascCliente;
        this.cpfCliente = cpfCliente;
        this.generoCliente = generoCliente;
        try {
            // Criptografa a senha do cliente
            this.senhaCliente = Criptografia.criptografar(senhaCliente);
        } catch (NoSuchAlgorithmException e) {
            // Tratamento da exceção caso o algoritmo de criptografia não seja encontrado
            e.printStackTrace();
        }
    }

    // Construtor padrão sem parâmetros
    public Cliente() {
    	
    }
}
