package Forms;

import javax.swing.*;

public class Login {
    private JPanel LoginPanel;
    private JButton sairButton;
    private JPasswordField password;
    private JComboBox prefix;
    private JTextField matricula;
    private JButton loginButton;

    public Login() {
        sairButton.addActionListener(e -> System.exit(0));
        loginButton.addActionListener(e -> {
            String prefixo, id, senha;
            prefixo = prefix.getSelectedItem().toString();
            if(prefixo == "EN"){
                EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
                enfermeiroMain.montarFrame();
                this.getMainFrame().dispose();
            }else if(prefixo == "MD"){
                /*EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
                enfermeiroMain.montarFrame();*/
                this.getMainFrame().dispose();
            }else if(prefixo == "AT"){
                CadastroPaciente cadPaciente = new CadastroPaciente();
                cadPaciente.montarFrame();
                this.getMainFrame().dispose();
            }else{
                System.out.println("Erro");
            }
        });
    }

    public JFrame montarFrame(){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.LoginPanel);
    }

}
