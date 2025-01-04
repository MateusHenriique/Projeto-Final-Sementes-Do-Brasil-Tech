package br.com.safeJourney.model.viagem;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Viagem {
    // Campos da classe Viagem
    private String paisDestino;
    private Date dataIda, dataVolta;
    private long duracaoDia;
    private int qtdPassageiro;
    private long idViagem;
    private String finalidadeViagem;
    private String cpfCliente;

    // Construtor da classe Viagem
    public Viagem(String dataIda, String dataVolta, int qtdPassageiro, String siglaPaisDestino, String finalidadeViagem) {
        // Inicializa a quantidade de passageiros
        this.qtdPassageiro = qtdPassageiro;

        // Inicializa o destino da viagem
        this.paisDestino = siglaPaisDestino;

        this.finalidadeViagem = finalidadeViagem;

        // Define o formato de data esperado "dd/MM/yyyy"
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // Define para análise estrita (não permite datas inválidas)

        try {
            // Tenta converter as strings de data para objetos Date
            java.util.Date utilDateIda = formato.parse(dataIda);
            java.util.Date utilDateVolta = formato.parse(dataVolta);

            // Converte java.util.Date para java.sql.Date
            this.dataIda = new java.sql.Date(utilDateIda.getTime());
            this.dataVolta = new java.sql.Date(utilDateVolta.getTime());

            // Calcula a duração da viagem em dias
            this.duracaoDia = calculaDiaViagem(this.dataIda, this.dataVolta);
        } catch (ParseException e) {
            // Caso ocorra uma exceção de parse
            e.printStackTrace();
        }
    }

    public Viagem() {
        // Construtor padrão
    }

    // Método privado para calcular a quantidade de dias entre a data de ida e a data de volta
    private long calculaDiaViagem(Date dataIda, Date dataVolta) {
        long diferencaMillis = dataVolta.getTime() - dataIda.getTime();
        // Converte a diferença em milissegundos para dias
        return TimeUnit.DAYS.convert(diferencaMillis, TimeUnit.MILLISECONDS);
    }
}
