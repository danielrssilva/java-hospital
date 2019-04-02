import JavaBeans.*;
import ClassesDao.*;
import conexao.ConnectionFactory;

public class Main {

    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        EnderecoDao endDAo = new EnderecoDao();

        endereco.setEstado("sp");
        endereco.setCidade("Hortolandia");
        endereco.setBairro("Remanso Campineiro");
        endereco.setLogradouro("rua:42");
        endereco.setNumero("234");
        endereco.setBloco("00");

        endDAo.adiciona(endereco);

    }
}
