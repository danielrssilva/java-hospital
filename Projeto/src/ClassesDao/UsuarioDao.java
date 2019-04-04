package ClassesDao;

import JavaBeans.Endereco;
import conexao.ConnectionFactory;
import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean efetuarLogin(String tabela, String matricula, String senha){
        String select = "select * from "+tabela+" where matricula = '"+matricula+"' and senha = '"+senha+"'";
        try{
            ResultSet rs = null;
            PreparedStatement stmt = connection.prepareStatement(select);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Sucesso! Efetuando login...");
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
