package ClassesDao;

import JavaBeans.Enfermeiro;
import JavaBeans.Medico;
import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnfermeiroDao {
    private Connection connection;

    public EnfermeiroDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Enfermeiro enfermeiro){
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into enfermeiro"+
                "(matricula, coren)"+
                "values( ?, ?)";
        //String consultaIdMax = "select max(idEndereco) as id from endereco";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, enfermeiro.getMatricula());
            stmt.setString(2, enfermeiro.getCoren());

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
