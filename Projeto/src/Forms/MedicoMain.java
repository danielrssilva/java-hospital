package Forms;

import ClassesDao.DiagnosticoDao;
import JavaBeans.DiagnosticoPaciente;

import javax.swing.*;

public class MedicoMain {
    private JPanel MedicoMain;
    private JLabel nomePaciente;
    private JTextField especialidade;
    private JTextArea sintomas;
    private JButton confirmarButton;
    private JButton sairButton;

    public MedicoMain() {
        DiagnosticoPaciente diagnosticoPaciente = new DiagnosticoPaciente();
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        diagnosticoPaciente = diagnosticoDao.selectDiagnostico(2);
        nomePaciente.setText(diagnosticoPaciente.getNome());
        sintomas.setText(diagnosticoPaciente.getDescricao());
        especialidade.setText(diagnosticoPaciente.getEspecialidade());
        DiagnosticoPaciente finalDiagnosticoPaciente = diagnosticoPaciente;
        confirmarButton.addActionListener(e -> {
            finalDiagnosticoPaciente.setStatus(3);
            diagnosticoDao.updateDiagnostico(finalDiagnosticoPaciente);
            this.getMainFrame().dispose();
            MedicoMain medicoMain = new MedicoMain();
            medicoMain.montarFrame();
        });
        sairButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            Login login = new Login();
            login.montarFrame();
        });
    }

    public void montarFrame(){
        JFrame frame = new JFrame("Pacientes:");
        frame.setContentPane(new MedicoMain().MedicoMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.MedicoMain);
    }
}
