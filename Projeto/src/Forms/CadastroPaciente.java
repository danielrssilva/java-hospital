package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPaciente {
    private JPanel CadastroPaciente;
    private JTextField textField1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton cadastrarButton;
    private JButton sairButton;

    public CadastroPaciente() {
        sairButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            Login login = new Login();
            login.montarFrame();
        });
        cadastrarButton.addActionListener(e -> {
            System.out.println("Cadastrou, uau");
        });
    }

    public JFrame montarFrame(){
        JFrame frame = new JFrame("Cadastrar paciente");
        frame.setContentPane(new CadastroPaciente().CadastroPaciente);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.CadastroPaciente);
    }
}
