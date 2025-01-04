package br.com.safeJourney.model;

import java.security.NoSuchAlgorithmException;

import br.com.safeJourney.util.Criptografia;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Corretor {
	
	private String cpfCorretor, senhaCorretor, nomeCorretor;
	
	public Corretor(String cpfCorretor, String nomeCorretor, String senhaCorretor) {
		this.cpfCorretor = cpfCorretor;
		this.nomeCorretor = nomeCorretor;
		try {
			this.senhaCorretor = Criptografia.criptografar(senhaCorretor);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public Corretor() {

	}
	
	
}
