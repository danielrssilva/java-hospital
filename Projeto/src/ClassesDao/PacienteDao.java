package ClassesDao;

import JavaBeans.Diagnostico;
import JavaBeans.Paciente;
import conexao.ConnectionFactory;

import java.sql.*;

public class PacienteDao {
    private Connection connection;

    public PacienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void setPaciente(Paciente paciente){
        String sql = "insert into paciente"+
                "(nome, cpf, telefone, dataNascimento, idEndereco, idDiagnostico, status)"+
                "values(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.setDate(4, new Date(paciente.getDataNascimento().getTimeInMillis()));
            stmt.setString(5, paciente.getEndereço());
            stmt.setString(6, paciente.getDiagnostico());
            stmt.setString(7, "2");//Coloca paciente em status de aguardando triagem

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Paciente selectPaciente(){
        Paciente paciente = new Paciente();
        Diagnostico diagnostico = new Diagnostico();
        ResultSet rs = null;
        String sql = "SELECT nome, diagnostico.idDiagnostico AS id, diagnostico.descricao AS sintomas, especialidade " +
                     "FROM paciente, diagnostico, status " +
                     "WHERE paciente.idDiagnostico = diagnostico.idDiagnostico AND status.id = paciente.status  AND paciente.status = 2  limit 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                paciente.setNome(rs.getString(1));
                diagnostico.setId(rs.getString(2));
                diagnostico.setDescricao(rs.getString(3));
                diagnostico.setEspecialidade(rs.getString(4));
            }
            stmt.execute();
            stmt.close();
            return paciente;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
