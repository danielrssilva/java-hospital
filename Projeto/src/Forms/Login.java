package Forms;

import ClassesDao.UsuarioDao;

import javax.swing.*;

public class Login {
    private JPanel LoginPanel;
    private JButton sairButton;
    private JPasswordField password;
    private JTextField matricula;
    private JButton loginButton;

    public Login() {
        sairButton.addActionListener(e -> System.exit(0));
        loginButton.addActionListener(e -> {
            UsuarioDao login = new UsuarioDao();
            String id, senha;
            id = matricula.getText();
            senha = new String(password.getPassword());
            int valorUsuario = login.efetuarLogin(id, senha);
            switch(valorUsuario){
                case 0 :
                    System.out.println("Usuário invalido");
                    break;
                case  1 :
                    MedicoMain medicoMain = new MedicoMain();
                    medicoMain.montarFrame();
                    this.getMainFrame().dispose();
                    break;
                case 2 :
                    EnfermeiroMain enfermeiroMain = new EnfermeiroMain();
                    enfermeiroMain.montarFrame();
                    this.getMainFrame().dispose();
                    break;
                case 3:
                    CadastroPaciente cadPaciente = new CadastroPaciente();
                    cadPaciente.montarFrame();
                    this.getMainFrame().dispose();
                    break;
                default:
                    break;
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
