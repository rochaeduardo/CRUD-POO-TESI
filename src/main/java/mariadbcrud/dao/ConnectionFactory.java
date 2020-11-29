package mariadbcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariadbcrud.model.ConnectionInfo;

public class ConnectionFactory {

    public static Connection getConexao() {
        String database = "fatec";
        String url = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
        String user = "root";
        String password = "";

        try {

            return DriverManager.getConnection(url, user, password);
            
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(ConnectionFactory.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
    
    public static Connection getConexao(ConnectionInfo info) {
        try {
            return DriverManager.getConnection(info.getDatabase(), info.getUser(), info.getPassword());
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(ConnectionFactory.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
