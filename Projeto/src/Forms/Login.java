package Forms;

import ClassesDao.UsuarioDao;

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
            UsuarioDao login = new UsuarioDao();
            String prefixo, id, senha;
            prefixo = prefix.getSelectedItem().toString();
            id = prefix.getSelectedItem().toString()+matricula.getText();
            senha = password.getText();
            if(prefixo == "EN"){
                if(login.efetuarLogin("enfermeiro", id, senha)){
                    EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
                    enfermeiroMain.montarFrame();
                    this.getMainFrame().dispose();
                }
            }else if(prefixo == "MD"){
                if(login.efetuarLogin("medico", id, senha)) {
                    MedicoMain medicoMain = new MedicoMain();
                    medicoMain.montarFrame();
                    this.getMainFrame().dispose();
                }
            }else if(prefixo == "AT"){
                if(login.efetuarLogin("funcionario", id, senha)) {
                    CadastroPaciente cadPaciente = new CadastroPaciente();
                    cadPaciente.montarFrame();
                    this.getMainFrame().dispose();
                }
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
