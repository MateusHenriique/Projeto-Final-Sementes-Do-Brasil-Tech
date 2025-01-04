package br.com.safeJourney.model.plano;

public enum TipoPlano {
	BASICO, 
	INTERMEDIARIO, 
	TOP;
	
	public static TipoPlano fromString(String tipo) {
        for (TipoPlano tipoPlano : TipoPlano.values()) {
            if (tipoPlano.name().equalsIgnoreCase(tipo)) {
                return tipoPlano;
            }
        }
        return null;
    }
}
