package br.com.safeJourney.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.safeJourney.model.cotacaoMoeda.ConverteDados;
import br.com.safeJourney.model.cotacaoMoeda.CotacaoMoeda;

public class ConnectionCotacaoMoedaAPI {
	private static String endereco = "https://economia.awesomeapi.com.br/json/last/";
	
	public static String consumoAPI(String moedaCotacao) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco + moedaCotacao + "-BRL"))
				.build();
		
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String json = response.body();
		return json;

	}

	public static CotacaoMoeda consumo(String moedaCotacao) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco + moedaCotacao + "-BRL"))
				.build();

		final ObjectMapper mapper = new ObjectMapper();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if(response.statusCode() > 399 && response.statusCode() < 499) {
				JOptionPane.showMessageDialog(null, "Dados enviados invalido. Moeda: " + moedaCotacao);
				throw new RuntimeException("Dados enviados invalido");
			} else if(response.statusCode() > 499 && response.statusCode() < 599) {
				JOptionPane.showMessageDialog(null, "Erro ao consultar moeda, tentar novamente" + moedaCotacao);				
				throw new RuntimeException("Erro ao consultar moeda");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String json = response.body();

		JsonNode rootNode;
		try {
			rootNode = mapper.readTree(json);
			JsonNode usdNode = rootNode.path(moedaCotacao.toUpperCase() + "BRL");
			CotacaoMoeda moeda = ConverteDados.obterDados(usdNode.toString(), CotacaoMoeda.class);
			return moeda;
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Sistema indisponivel para calcular cotação, por favor chamar o administrador");
			e.printStackTrace();
		}
		return new CotacaoMoeda();
	}

}
