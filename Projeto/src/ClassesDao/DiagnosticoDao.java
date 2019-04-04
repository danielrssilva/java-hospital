package ClassesDao;

import JavaBeans.Diagnostico;
import JavaBeans.Medico;
import conexao.ConnectionFactory;

import java.sql.*;

public class DiagnosticoDao {
    private Connection connection;

    public DiagnosticoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertDiagnostico(Diagnostico diagnostico){
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into diagnostico"+
                "(descricao, especialidade)"+
                "values(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String id;

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
    public void getDiagnostico(){

    }
}
