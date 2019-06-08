package ClassesDao;

import JavaBeans.Diagnostico;
import JavaBeans.DiagnosticoPaciente;
import conexao.ConnectionFactory;

import java.sql.*;

public class DiagnosticoDao {
    private Connection connection;

    public DiagnosticoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertDiagnostico(Diagnostico diagnostico){
        String sql = "insert into diagnostico"+
                "(descricao, especialidade)"+
                "values(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, diagnostico.getDescricao());
            stmt.setString(2, diagnostico.getEspecialidade());

            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    diagnostico.setId(generatedKeys.getString(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public DiagnosticoPaciente selectDiagnostico(int status){
        DiagnosticoPaciente diagnosticoPaciente = new DiagnosticoPaciente();
        ResultSet rs = null;
        String sql = "SELECT nome, diagnostico.idDiagnostico AS id, diagnostico.descricao AS sintomas, especialidade " +
                     "FROM paciente, diagnostico, status " +
                     "WHERE paciente.idDiagnostico = diagnostico.idDiagnostico AND status.id = paciente.id_status  AND paciente.id_status = "+ status +" limit 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                diagnosticoPaciente.setNome(rs.getString(1));
                diagnosticoPaciente.setId(rs.getInt(2));
                diagnosticoPaciente.setDescricao(rs.getString(3));
                diagnosticoPaciente.setEspecialidade(rs.getString(4));
            }
            stmt.execute();
            stmt.close();
            return diagnosticoPaciente;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void updateDiagnostico(DiagnosticoPaciente diagnosticoPaciente){
        String sql = "update diagnostico set descricao = ?, especialidade = ? where idDiagnostico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, diagnosticoPaciente.getDescricao());
            stmt.setString(2, diagnosticoPaciente.getEspecialidade());
            stmt.setInt(   3, diagnosticoPaciente.getId());

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        sql =  "update paciente set id_status = ? WHERE paciente.idDiagnostico = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(   1, diagnosticoPaciente.getStatus());
            stmt.setInt(   2, diagnosticoPaciente.getId());

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
