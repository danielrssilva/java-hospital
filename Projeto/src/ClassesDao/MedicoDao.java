package ClassesDao;

import JavaBeans.Medico;
import JavaBeans.Tabela_Paciente_Diagnostico;
import conexao.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class MedicoDao {
    private Connection connection;

    public MedicoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Medico medico){
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into medico"+
                "(matricula, crm, especialidade)"+
                "values( ?, ?, ?)";
        //String consultaIdMax = "select max(idEndereco) as id from endereco";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //PreparedStatement stmtMax = connection.prepareStatement(consultaIdMax);
            //rs = stmtMax.executeQuery(consultaIdMax);
            //idMax = rs.getInt("id");

            stmt.setString(1, medico.getMatricula());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getEspecialidade());
            //stmt.setInt(10, idMax);

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Tabela_Paciente_Diagnostico> montarTabela(){


        String select = "SELECT nome, descricao AS sintomas FROM paciente, diagnostico WHERE paciente.idDiagnostico = diagnostico.idDiagnostico";
        ResultSet rs = null;

        ArrayList <Tabela_Paciente_Diagnostico> tpdArray = new ArrayList();

        try{
            PreparedStatement stmt = connection.prepareStatement(select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tabela_Paciente_Diagnostico tpd = new Tabela_Paciente_Diagnostico();

                tpd.setNome(rs.getString("nome"));
                tpd.setSintoma(rs.getString("sintomas"));

                tpdArray.add(tpd);
            }
        }catch(SQLException e){
            System.out.println("Erro! Cheque suas credenciais");
            throw new RuntimeException(e);
        }
        return tpdArray;
    }
}
