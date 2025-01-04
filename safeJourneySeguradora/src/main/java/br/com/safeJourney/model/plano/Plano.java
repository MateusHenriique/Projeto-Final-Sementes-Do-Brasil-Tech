package br.com.safeJourney.model.plano;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Plano {

	private long idPlano;
	private TipoPlano tipoPlano;

	public Plano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Plano() {

	}
}
