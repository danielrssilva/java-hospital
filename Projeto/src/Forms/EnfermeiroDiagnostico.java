package Forms;

import ClassesDao.DiagnosticoDao;
import ClassesDao.PacienteDao;
import JavaBeans.Diagnostico;
import JavaBeans.DiagnosticoPaciente;
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
        DiagnosticoPaciente diagnosticoPaciente = new DiagnosticoPaciente();
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        diagnosticoPaciente = diagnosticoDao.selectDiagnostico(1);
        nomePaciente.setText(diagnosticoPaciente.getNome());
        sintomas.setText(diagnosticoPaciente.getDescricao());
        especialidade.setText(diagnosticoPaciente.getEspecialidade());
        DiagnosticoPaciente finalDiagnosticoPaciente = diagnosticoPaciente;
        confirmarButton.addActionListener(e -> {
            finalDiagnosticoPaciente.setEspecialidade(especialidade.getText());
            finalDiagnosticoPaciente.setDescricao(sintomas.getText());
            finalDiagnosticoPaciente.setStatus(2);
            diagnosticoDao.updateDiagnostico(finalDiagnosticoPaciente);
            this.getMainFrame().dispose();
            EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
            enfermeiroMain.montarFrame();
        });
        cancelarButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
            enfermeiroMain.montarFrame();
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
