package br.com.safeJourney.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    /**
     * Método para abrir uma conexão com o banco de dados.
     */
    public static Connection abrirConexao() {
        if (connection == null || isClosed()) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "tm21",
                    "01102005"
                    
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Método para fechar a conexão com o banco de dados. 
     */
    public static Connection fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Método para verificar se a conexão está fechada.
     * 
     * @return true se a conexão estiver fechada, caso contrário, false.
     */
    public static boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * Método para obter a conexão com o banco de dados.
     * 
     * @return a conexão ativa.
     */
    public static Connection getConnection() {
        return connection;
    }
}
