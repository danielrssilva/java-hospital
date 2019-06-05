package ClassesDao;

import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public int efetuarLogin(String matricula, String senha){
        int check = 0;
        try{
            ResultSet rs = null;

            String select = "SELECT LEFT(matricula , 2) AS prefixo FROM funcionario WHERE matricula = ? and senha = ?";
            PreparedStatement stmt = connection.prepareStatement(select);

            stmt.setString(1, matricula);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while(rs.next()){
                if(rs.getString("prefixo").equals("MD")){
                    check = 1;
                }else if(rs.getString("prefixo").equals("EN")){
                    check = 2;
                }
                else if(rs.getString("prefixo").equals("AT")){
                    check = 3;
                }else if(rs.getString("prefixo").equals("AD")){
                    check = 4;
                }
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return check;

    }
}
