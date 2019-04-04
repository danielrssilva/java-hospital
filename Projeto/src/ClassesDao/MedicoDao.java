package ClassesDao;

import JavaBeans.Medico;
import conexao.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MedicoDao {
    private Connection connection;

    public MedicoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Medico medico){
        ResultSet rs = null;
        int idMax = 0;
        String sql = "insert into medico"+
                "(matricula, crm, senha, nome, cpf, data_nascimento, cargo, hora_inicio, hora_fim)"+
                "values( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //String consultaIdMax = "select max(idEndereco) as id from endereco";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //PreparedStatement stmtMax = connection.prepareStatement(consultaIdMax);
            //rs = stmtMax.executeQuery(consultaIdMax);
            //idMax = rs.getInt("id");

            stmt.setString(1, medico.getMatricula());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getSenha());
            stmt.setString(4, medico.getNome());
            stmt.setString(5, medico.getCpf());
            stmt.setDate(6, new Date (
                    medico.getDataNascimento().getTimeInMillis()));
            stmt.setString(7, medico.getCargo());
            stmt.setString(8, medico.getHoraInicioTrab());
            stmt.setString(9, medico.getHoraFinalTrab());
            //stmt.setInt(10, idMax);

            stmt.execute();
            stmt.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public JTable montarTabela(JTable table){
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        String select = "SELECT nome, descricao AS sintomas FROM paciente, diagnostico WHERE paciente.idDiagnostico = diagnostico.idDiagnostico";
        Object dados[] = new Object[2];
        ResultSet rs = null;
        try{
            PreparedStatement stmt = connection.prepareStatement(select);
            rs = stmt.executeQuery();
            while (rs.next()) {
                dados[0] = rs.getString("nome");
                dados[1] = rs.getString("sintomas");
                modelo.addRow(dados);
                return table;
            }
        }catch(SQLException e){
            System.out.println("Erro! Cheque suas credenciais");
            throw new RuntimeException(e);
        }
        return table;
    }
}
