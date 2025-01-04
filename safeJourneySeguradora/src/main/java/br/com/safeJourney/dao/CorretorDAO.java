package br.com.safeJourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.safeJourney.model.Corretor;

public class CorretorDAO {

	private Connection connection;

	public CorretorDAO(Connection connection) {
		this.connection = connection;
	}

	public void insertCorretor(Corretor corretor) {
		String sql = "insert into t_corretor (cpf_corretor, nm_corretor, senha_corretor) values (?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, corretor.getCpfCorretor());
			stmt.setString(2, corretor.getNomeCorretor());
			stmt.setString(3, corretor.getSenhaCorretor());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Corretor> selectAll() {

		List<Corretor> corretores = new ArrayList<Corretor>();
		String sql = "select * from t_corretor order by nm_corretor";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Corretor corretor = new Corretor();
				corretor = new Corretor();
				corretor.setCpfCorretor(rs.getString("cpf_corretor"));
				corretor.setSenhaCorretor(rs.getString("senha_corretor"));
				corretor.setNomeCorretor(rs.getString("nm_corretor"));

				corretores.add(corretor);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return corretores;
	}

	public Corretor selectByCPF(String cpfCorretor) {

		Corretor corretor = null;
		String sql = "select * from t_corretor where cpf_corretor = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpfCorretor);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				corretor = new Corretor();
				corretor.setCpfCorretor(rs.getString("cpf_corretor"));
				corretor.setSenhaCorretor(rs.getString("senha_corretor"));
				corretor.setNomeCorretor(rs.getString("nm_corretor"));
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return corretor;
	}

	public void deleteCorretor(String cpfCorretor) {

		String sql = "delete from t_corretor where (cpf_corretor = ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpfCorretor);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
