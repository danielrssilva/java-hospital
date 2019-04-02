package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public Connection getConnection(){
        try{
            System.out.println("ta funfando");
            return DriverManager.getConnection("jdbc:mysql://localhost/hospital?user=root");//jdbc:mysql://localhost/hospital?user=root
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
