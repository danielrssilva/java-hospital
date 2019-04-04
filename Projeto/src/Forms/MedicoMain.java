package Forms;

import ClassesDao.MedicoDao;
import JavaBeans.Medico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicoMain {
    private JPanel MedicoMain;
    private JTable table1;
    private JButton button1;

    public MedicoMain() {
        button1.addActionListener(e -> {
            MedicoDao mDao = new MedicoDao();
            setTable1(mDao.montarTabela(table1));
        });
    }

    public void montarFrame(){
        JFrame frame = new JFrame("Pacientes:");
        frame.setContentPane(new MedicoMain().MedicoMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JTable getTable1() {
        return table1;
    }

    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.MedicoMain);
    }
}
