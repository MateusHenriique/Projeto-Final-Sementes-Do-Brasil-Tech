package br.com.safeJourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.safeJourney.model.Apolice;
import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.plano.TipoPlano;

public class ApoliceDAO {

	private Connection connection;

	public ApoliceDAO(Connection connection) {
		this.connection = connection;
	}

	public void insertApolice(Apolice apolice) {

		String sql = "INSERT INTO t_apolice(status_apolice, id_plano, id_cliente, id_viagem) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, apolice.getStatusApolice());
			stmt.setLong(2, apolice.getPlano().getIdPlano());
			stmt.setLong(3, apolice.getCliente().getIdCliente());
			stmt.setLong(4, apolice.getViagem().getIdViagem());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Apolice selectByIdCliente(long idCliente) {
String sql = "SELECT * FROM t_apolice where id_cliente=?";
		
		Apolice apolice = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idCliente);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				apolice = new Apolice();
				apolice.setIdCliente(rs.getLong("id_cliente"));
				apolice.setIdViagem(rs.getLong("id_viagem"));
				apolice.setIdPlano(rs.getLong("id_plano"));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apolice;
	}
}
