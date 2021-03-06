package ClassesDao;

import JavaBeans.Diagnostico;
import JavaBeans.Paciente;
import conexao.ConnectionFactory;

import java.sql.*;
import java.util.Calendar;

public class PacienteDao {
    private Connection connection;

    public PacienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void setPaciente(Paciente paciente){
        String sql = "insert into paciente"+
                "(nome, cpf, telefone, dataNascimento, idEndereco, idDiagnostico)"+
                "values(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.setDate(4, new Date(paciente.getDataNascimento().getTimeInMillis()));
            stmt.setString(5, paciente.getEndereço());
            stmt.setString(6, paciente.getDiagnostico());

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void getPaciente(){

    }
}
