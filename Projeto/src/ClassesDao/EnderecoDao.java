package ClassesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.ConnectionFactory;
import JavaBeans.Endereco;

public class EnderecoDao {
    private Connection connection;

    public EnderecoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Endereco endereco){
        String sql = "insert into endereco"+
                "(idEndereco, estado, cidade, bairro, logradouro, numero, bloco)"+
                "values(null, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, endereco.getEstado());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getLogradouro());
            stmt.setString(5, endereco.getNumero());
            stmt.setString(6, endereco.getBloco());
            stmt.execute();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
