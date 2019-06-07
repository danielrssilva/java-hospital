package Forms;

import ClassesDao.MedicoDao;
import JavaBeans.Tabela_Paciente_Diagnostico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MedicoMain extends javax.swing.JPanel {

    public MedicoMain () {

    }

    public void montarFrame(){
        MedicoDao mDao = new MedicoDao();
        JFrame frame = new JFrame("Pacientes:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // JTable table = createTable();
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }



    public static JTable createTable()
    {
        MedicoDao md = new MedicoDao();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Paciente");
        model.addColumn("Sintomas");

        for(Tabela_Paciente_Diagnostico tpd : md.montarTabela()){
            model.addRow(new Object[]{
                    tpd.getNome(),
                    tpd.getSintoma()
            });
        }

        table.setFillsViewportHeight(true);

        return table;
    }


}
