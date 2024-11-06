package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection c = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta.");
        c.close();
    }
}

//Em caso de erro: baixar o driver Connector/J em https://www.mysql.com/products/connector/