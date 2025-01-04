package br.com.safeJourney.util;

import java.util.Random;

public class Protocolo {
	public static String gerarProtocolo() {
		Random rand = new Random();
		String protocolo = Long.toString(rand.nextLong(999999999));
		return protocolo;

	}
}
