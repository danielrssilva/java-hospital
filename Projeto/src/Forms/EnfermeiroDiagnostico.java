package Forms;

import ClassesDao.DiagnosticoDao;
import ClassesDao.PacienteDao;
import JavaBeans.Diagnostico;
import JavaBeans.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnfermeiroDiagnostico {
    private JPanel EnfermeiroDiagnostico;
    private JTextField especialidade;
    private JTextArea sintomas;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JLabel nomePaciente;

    public EnfermeiroDiagnostico() {
        Paciente paciente = new Paciente();
        PacienteDao pacienteDao = new PacienteDao();
        paciente = pacienteDao.selectPaciente();
        nomePaciente.setText(paciente.getNome());
        sintomas.setText(paciente.getDiagnostico());
        especialidade.setText(paciente.getStatus());
        cancelarButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
            enfermeiroMain.montarFrame();
        });
        confirmarButton.addActionListener(e -> {


            /*
            this.getMainFrame().dispose();
            EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
            enfermeiroMain.montarFrame();*/
        });
    }

    public JFrame montarFrame(){
        JFrame frame = new JFrame("Diagnostico");
        frame.setContentPane(new EnfermeiroDiagnostico().EnfermeiroDiagnostico);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.EnfermeiroDiagnostico);
    }
}
