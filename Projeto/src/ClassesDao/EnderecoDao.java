package ClassesDao;
import java.sql.*;

import conexao.ConnectionFactory;
import JavaBeans.Endereco;

public class EnderecoDao {
    private Connection connection;

    public EnderecoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertEndereco(Endereco endereco){
        String sql = "insert into endereco"+
                "(idEndereco, estado, cidade, bairro, logradouro, numero, bloco)"+
                "values(null, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getEstado());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getLogradouro());
            stmt.setString(5, endereco.getNumero());
            stmt.setString(6, endereco.getBloco());
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    endereco.setId(generatedKeys.getString(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
