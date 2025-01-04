package br.com.safeJourney.model;

import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.viagem.Viagem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Apolice {
    // Campos da classe Apolice
    private Viagem viagem; 
    private Cliente cliente; 
    private Plano plano; 
    private String statusApolice;
    private long idViagem;
    private long idPlano;
    private long idCliente;

    // Construtor da classe Apolice
    public Apolice (String statusApolice, Cliente cliente, Viagem viagem, Plano plano) {
        // Inicializa os campos com os valores fornecidos como parâmetros
    	this.statusApolice = statusApolice;
        this.viagem = viagem;
        this.cliente = cliente;
        this.plano = plano;
    }
    
    public Apolice() {
    	
    }
}
