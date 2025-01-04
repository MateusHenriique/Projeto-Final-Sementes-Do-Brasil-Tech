package br.com.safeJourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.safeJourney.model.viagem.PaisDestino;
import br.com.safeJourney.model.viagem.Viagem;

public class ViagemDAO {

	private Connection connection;

	public ViagemDAO(Connection connection) {
		this.connection = connection;
	}

	public void insertViagem(Viagem viagem) {

		String sql = "INSERT INTO t_viagem (id_viagem, data_ida, data_volta, qtd_passageiro, pais_destino, finalidade, cpf_cliente) VALUES (?,?,?,?,?,?,?)";

		try {
			// Preparação da declaração SQL com a conexão
			PreparedStatement stmt = connection.prepareStatement(sql);

			// Atribuição dos valores dos atributos do cliente nos parâmetros da consulta
			stmt.setLong(1, viagem.getIdViagem());
			stmt.setDate(2, viagem.getDataIda());
			stmt.setDate(3, viagem.getDataVolta());
			stmt.setInt(4, viagem.getQtdPassageiro());
			stmt.setString(5, viagem.getPaisDestino());
			stmt.setString(6, viagem.getFinalidadeViagem());
			stmt.setString(7, viagem.getCpfCliente());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Viagem selectById(long idViagem) {
		String sql = "SELECT * FROM t_viagem WHERE id_viagem = ?";
		Viagem viagem = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idViagem);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				viagem = new Viagem();
				viagem.setIdViagem(rs.getLong("id_viagem"));
				viagem.setDataIda(rs.getDate("data_ida"));
				viagem.setDataVolta(rs.getDate("data_volta"));
				viagem.setQtdPassageiro(rs.getInt("qtd_passageiro"));
				viagem.setPaisDestino(rs.getString("pais_destino"));
				viagem.setFinalidadeViagem(rs.getString("finalidade"));
				viagem.setCpfCliente(rs.getString("cpf_cliente"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viagem;
	}
	
	public Viagem selectByCPF(String cpfCliente) {
		String sql = "SELECT * FROM t_viagem WHERE cpf_cliente = ?";
		Viagem viagem = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpfCliente);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				viagem = new Viagem();
				viagem.setIdViagem(rs.getLong("id_viagem"));
				viagem.setDataIda(rs.getDate("data_ida"));
				viagem.setDataVolta(rs.getDate("data_volta"));
				viagem.setQtdPassageiro(rs.getInt("qtd_passageiro"));
				viagem.setPaisDestino(rs.getString("pais_destino"));
				viagem.setFinalidadeViagem(rs.getString("finalidade"));
				viagem.setCpfCliente(rs.getString("cpf_cliente"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viagem;
	}
}
	