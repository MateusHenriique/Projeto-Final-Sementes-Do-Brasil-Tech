package br.com.safeJourney.model.plano;

import br.com.safeJourney.model.viagem.Viagem;

public class PrecoDinamico {

	public static double calcularPrecoDinamico(Viagem viagem, TipoPlano plano) {
		double precoBase;

		switch (plano) {
		case BASICO:
			precoBase = 184.72;
			break;
		case INTERMEDIARIO:
			precoBase = 226.68;
			break;
		case TOP:
			precoBase = 262.00;
			break;
		default:
			throw new IllegalArgumentException("Tipo de plano inválido!");
		}

		double fatorViajantes = 1 + (viagem.getQtdPassageiro() - 1) * 0.2; // 20% por viajante extra
		double fatorDuracao = 1 + (viagem.getDuracaoDia() / 30.0) * 0.1; // 10% a mais a cada 30 dias
		// Cálculo do preço final
		return precoBase * fatorViajantes * fatorDuracao;
	}
}
