package br.com.safeJourney.dao;

// Importações necessárias para manipulação do banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.plano.TipoPlano;
import br.com.safeJourney.model.viagem.Viagem;

public class PlanoDAO {
	private Connection connection;

	// Construtor da classe PlanoDAO que inicializa a conexão com o banco de dados
	public PlanoDAO(Connection connection) {
		this.connection = connection;
	}

	// Método para inserir um nov	o plano no banco de dados
	public void insertPlano(Plano plano) {
		String sql = "INSERT INTO t_plano (id_plano, tipo_plano) VALUES (?,?)"; // <- comando SQL referente à
																					// inserção de dados
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);;
			stmt.setLong(1, plano.getIdPlano());
			stmt.setString(2, plano.getTipoPlano().toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para buscar todos os planos no banco de dados
	public List<Plano> selectAll() {
		String sql = "SELECT * FROM t_plano";
		List<Plano> planos = new ArrayList<>();
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Plano plano = new Plano();
				plano.setIdPlano(rs.getLong("id_plano"));
				plano.setTipoPlano(TipoPlano.fromString(rs.getString("tipo_plano")));
				planos.add(plano);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planos;
	}
	
	public Plano selectPlanoByTipo(TipoPlano tipoPlano) {
		String sql = "SELECT * FROM t_plano where tipo_plano=?";
		
		Plano plano = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tipoPlano.toString());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				plano = new Plano();
				plano.setIdPlano(rs.getLong("id_plano"));
				plano.setTipoPlano(TipoPlano.fromString(rs.getString("tipo_plano")));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plano;
	}

	public Plano selectPlanoByid(long idPlano) {
String sql = "SELECT * FROM t_plano where id_plano=?";
		
		Plano plano = null;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idPlano);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				plano = new Plano();
				plano.setIdPlano(rs.getLong("id_plano"));
				plano.setTipoPlano(TipoPlano.fromString(rs.getString("tipo_plano")));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plano;
	}

}
