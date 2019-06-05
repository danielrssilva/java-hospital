package ClassesDao;

import JavaBeans.Funcionario;
import JavaBeans.Medico;
import conexao.ConnectionFactory;

import java.sql.*;

public class FuncionarioDao {
    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario funcionario) {
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into funcionario" +
                "(matricula, senha, nome, cpf, datanascimento, cargo, horaInicio, horaFim)" +
                "values( ?, ?, ?, ?, ?, ?, ?, ?)";
        //String consultaIdMax = "select max(idEndereco) as id from endereco";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //PreparedStatement stmtMax = connection.prepareStatement(consultaIdMax);
            //rs = stmtMax.executeQuery(consultaIdMax);
            //idMax = rs.getInt("id");

            stmt.setString(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getSenha());
            stmt.setString(3, funcionario.getNome());
            stmt.setString(4, funcionario.getCpf());
            stmt.setDate(5, null);
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getHoraInicioTrab());
            stmt.setString(8, funcionario.getHoraFinalTrab());
            //stmt.setInt(10, idMax);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
