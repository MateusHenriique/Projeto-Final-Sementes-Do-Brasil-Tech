package br.com.safeJourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.safeJourney.model.Cliente;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um novo registro de cliente no banco de dados
    public void insertCliente(Cliente cliente) {
        String sql = "INSERT INTO t_cliente (cpf_cliente, nm_cliente, data_nasc_cliente, email_cliente, telefone_cliente, "
                + "genero_cliente, senha_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Atribuição dos valores dos atributos do cliente nos parâmetros da consulta
            stmt.setString(1, cliente.getCpfCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setString(3, cliente.getDataNascCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefoneCliente());
            stmt.setString(6, cliente.getGeneroCliente());
            stmt.setString(7, cliente.getSenhaCliente());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um registro de cliente com base no CPF
    public void deleteCliente(String cpfCliente) {
        String sql = "DELETE FROM t_cliente WHERE cpf_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar os dados de um cliente no banco de dados
    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE t_cliente SET nm_cliente = ?, data_nasc_cliente = ?, email_cliente = ?, telefone_cliente = ?, "
                + "genero_cliente = ?, senha_cliente = ? WHERE cpf_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente() != null ? cliente.getNomeCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "nm_cliente"));
            stmt.setString(2, cliente.getDataNascCliente() != null ? cliente.getDataNascCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "data_nasc_cliente"));
            stmt.setString(3, cliente.getEmailCliente() != null ? cliente.getEmailCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "email_cliente"));
            stmt.setString(4, cliente.getTelefoneCliente() != null ? cliente.getTelefoneCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "telefone_cliente"));
            stmt.setString(5, cliente.getGeneroCliente() != null ? cliente.getGeneroCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "genero_cliente"));
            stmt.setString(6, cliente.getSenhaCliente() != null ? cliente.getSenhaCliente()
                    : getCurrentValue(cliente.getCpfCliente(), "senha_cliente"));
            stmt.setString(7, cliente.getCpfCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para buscar o valor atual do campo no banco de dados
    private String getCurrentValue(String cpfCliente, String campo) {
        String currentValue = null;
        String sql = "SELECT " + campo + " FROM t_cliente WHERE cpf_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                currentValue = rs.getString(campo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentValue;
    }

    // Método para buscar todos os registros de clientes no banco de dados
    public List<Cliente> selectAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM t_cliente";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNomeCliente(rs.getString("nm_cliente"));
                cliente.setCpfCliente(rs.getString("cpf_cliente"));
                cliente.setDataNascCliente(rs.getString("data_nasc_cliente"));
                cliente.setEmailCliente(rs.getString("email_cliente"));
                cliente.setTelefoneCliente(rs.getString("telefone_cliente"));
                cliente.setGeneroCliente(rs.getString("genero_cliente"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para buscar um registro de Cliente com base no CPF
    public Cliente selectByCPF(String cpfCliente) {
        Cliente cliente = null;
        String sql = "SELECT * FROM t_cliente WHERE cpf_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getLong("id_cliente"));
                    cliente.setNomeCliente(rs.getString("nm_cliente"));
                    cliente.setCpfCliente(rs.getString("cpf_cliente"));
                    cliente.setDataNascCliente(rs.getString("data_nasc_cliente"));
                    cliente.setEmailCliente(rs.getString("email_cliente"));
                    cliente.setTelefoneCliente(rs.getString("telefone_cliente"));
                    cliente.setGeneroCliente(rs.getString("genero_cliente"));
                    cliente.setSenhaCliente(rs.getString("senha_cliente"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}
