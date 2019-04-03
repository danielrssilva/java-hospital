package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnfermeiroMain {
    private JButton diagnosticarPacienteButton;
    private JButton sairButton;
    private JPanel EnfermeiroMainPanel;

    public EnfermeiroMain() {
        sairButton.addActionListener(e -> {
            System.exit(0);
        });
        diagnosticarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
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
}
