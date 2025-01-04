package br.com.safeJourney.model.cotacaoMoeda;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoMoeda {
	
	@JsonAlias("high") 
	private float valorMoeda;
	
	@JsonAlias("low") 
	private float valorMoedaBaixa;
	
	
	public float getValorMoeda() {
		return valorMoeda;
	}
	
	public void setValroMoeda(float valorMoeda) {
		this.valorMoeda = valorMoeda;
	}

}
