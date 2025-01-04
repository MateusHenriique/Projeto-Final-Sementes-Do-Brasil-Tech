package br.com.safeJourney.model.cotacaoMoeda;

public enum Moeda {
    USD("Dólar Americano"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    JPY("Iene Japonês"),
    AUD("Dólar Australiano"),
    CAD("Dólar Canadense"),
    CHF("Franco Suíço"),
    CNY("Yuan Chinês"),
    SEK("Coroa Sueca"),
    NZD("Dólar Neozelandês"),
    MXN("Peso Mexicano"),
    SGD("Dólar de Singapura"),
    HKD("Dólar de Hong Kong"),
    NOK("Coroa Norueguesa"),
    TRY("Lira Turca"),
    RUB("Rublo Russo"),
    INR("Rupia Indiana"),
    ZAR("Rand Sul-africano"),
    DKK("Coroa Dinamarquesa"),
    PLN("Zloty Polonês"),
    TWD("Novo Dólar Taiwanês"),
    THB("Baht Tailandês"),
    HUF("Florim Húngaro"),
    ILS("Novo Shekel Israelense"),
    CLP("Peso Chileno"),
    PHP("Peso Filipino"),
    AED("Dirham dos Emirados Árabes Unidos"),
    COP("Peso Colombiano"),
    SAR("Rial Saudita"),
    MYR("Ringgit Malaio"),
    PEN("Sol Peruano");

    private final String nomeCompleto;

    Moeda(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSigla() {
        return this.name();
    }

    @Override
    public String toString() {
        return nomeCompleto;
    }

    public static Moeda fromString(String moedaSelecionada) {
        for (Moeda moeda : Moeda.values()) {
            if (moeda.getNomeCompleto().equalsIgnoreCase(moedaSelecionada)) {
                return moeda;
            }
        }
        return null;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}
