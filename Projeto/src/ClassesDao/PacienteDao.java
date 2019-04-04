package ClassesDao;

import JavaBeans.Diagnostico;
import JavaBeans.Paciente;
import conexao.ConnectionFactory;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDao {
    private Connection connection;

    public PacienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void setPaciente(Paciente paciente){
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into paciente"+
                "(nome, telefone, idEndereco, idDiagnostico)"+
                "values(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getTelefone());
            stmt.setString(3, paciente.getEndereço());
            stmt.setString(4, paciente.getDiagnostico());

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void getPaciente(){

    }
}
