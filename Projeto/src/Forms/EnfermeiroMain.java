package Forms;

import JavaBeans.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnfermeiroMain {
    private JButton diagnosticarPacienteButton;
    private JButton sairButton;
    private JPanel EnfermeiroMainPanel;

    public EnfermeiroMain() {

        sairButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            Login login = new Login();
            login.montarFrame();
        });
        diagnosticarPacienteButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            EnfermeiroDiagnostico diagnostico = new EnfermeiroDiagnostico();
            diagnostico.montarFrame();
        });
    }
    public JFrame montarFrame(){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new EnfermeiroMain().EnfermeiroMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.EnfermeiroMainPanel);
    }
}
