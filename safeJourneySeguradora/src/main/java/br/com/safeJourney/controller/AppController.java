package br.com.safeJourney.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.safeJourney.connection.ConnectionCotacaoMoedaAPI;
import br.com.safeJourney.connection.ConnectionFactory;
import br.com.safeJourney.dao.ApoliceDAO;
import br.com.safeJourney.dao.ClienteDAO;
import br.com.safeJourney.dao.CorretorDAO;
import br.com.safeJourney.dao.PlanoDAO;
import br.com.safeJourney.dao.ViagemDAO;
import br.com.safeJourney.model.Apolice;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.model.Corretor;
import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.plano.TipoPlano;
import br.com.safeJourney.model.viagem.Viagem;

public class AppController {
	private static AppController instance;
	private Connection connection;
	private PlanoDAO planoDAO;
	private ClienteDAO clienteDAO;
	private CorretorDAO corretorDAO;
	private ViagemDAO viagemDAO;
	private ApoliceDAO apoliceDAO;

	// Construtor privado para Singleton
	private AppController() throws SQLException {
		this.connection = ConnectionFactory.abrirConexao();;
		this.planoDAO = new PlanoDAO(connection);
		this.clienteDAO = new ClienteDAO(connection);
		this.corretorDAO = new CorretorDAO(connection);
		this.viagemDAO = new ViagemDAO(connection);
		this.apoliceDAO = new ApoliceDAO(connection);
	}

	// Método para obter a instância única do AppController
	public static AppController getInstance() {
		if (instance == null) {
			try {
				instance = new AppController();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	// Método para fechar a conexão quando o AppController não for mais necessário
	public void closeConnection() throws SQLException {
		this.connection = ConnectionFactory.fecharConexao();
	}

	public void cadastrarCliente(Cliente cliente) {
		clienteDAO.insertCliente(cliente);
	}

	public void atualizarCadastroCliente(Cliente cliente) {
		clienteDAO.updateCliente(cliente);
	}

	public void deletarCliente(String cpf) {
		clienteDAO.deleteCliente(cpf);
	}

	public Cliente buscarClientePorCPF(String cpf) {
		Cliente cliente = clienteDAO.selectByCPF(cpf);
		if (cliente != null) {
			return cliente;
		}
		return null;
	}

	public List<Cliente> buscarTodosClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
			listaCliente.addAll(clienteDAO.selectAll());
		return listaCliente;

	}

	public void cadastrarCorretor(Corretor corretor) {
		corretorDAO.insertCorretor(corretor);
	}

	public void deletarCorretor(String cpf) {
		corretorDAO.deleteCorretor(cpf);
	}

	public List<Corretor> buscarTodosCorretores() {
		List<Corretor> listaCorretor = new ArrayList<>(); 
		listaCorretor.addAll(corretorDAO.selectAll());
		return listaCorretor;
	}

	public Corretor buscarCorretorPorCPF(String cpf) {
		Corretor corretor = corretorDAO.selectByCPF(cpf);
		if (corretor != null) {
			return corretor;
		}
		return null;
	}

	public void cadastrarPlano(Plano plano) {
		planoDAO.insertPlano(plano);
	}

	public List<Plano> buscarTodosPlanos() {
		List<Plano> listaPlano = new ArrayList<>(); 
		listaPlano.addAll(planoDAO.selectAll());
		return listaPlano;
	}
	
	public Plano buscarplanoByTipo(TipoPlano tipoPlano) {
		Plano plano = planoDAO.selectPlanoByTipo(tipoPlano);
		return plano;
	}
	
	public Plano buscarplanoById(long idPlano) {
		Plano plano = planoDAO.selectPlanoByid(idPlano);
		return plano;
	}
	
	public void cadastrarViagem(Viagem viagem) {
		viagemDAO.insertViagem(viagem);
	}
	
	public Viagem buscarViagemById(long id) {
		Viagem viagem = viagemDAO.selectById(id);
		return viagem;
	}
	public Viagem buscarViagemByCPF(String cpf) {
		Viagem viagem = viagemDAO.selectByCPF(cpf);
		return viagem;
	}
	
	public void CadastroApolice(Apolice apolice) {
		apoliceDAO.insertApolice(apolice);
	}

	public float cotacaoMoeda(String moedaCotacao) {
		return ConnectionCotacaoMoedaAPI
				.consumo(moedaCotacao.toUpperCase())
				.getValorMoeda();
	}

	public Apolice buscarApoliceByIdCliente(long idCliente) {
		Apolice apolice = apoliceDAO.selectByIdCliente(idCliente);
		return apolice;
	}

	
}
