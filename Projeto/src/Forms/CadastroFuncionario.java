package Forms;

import javax.swing.*;

public class CadastroFuncionario {
    private JPanel CadastroFuncionario;
    private JTextField matricula;
    private JTextField cpf;
    private JTextField cidade;
    private JTextField estado;
    private JTextField logradouro;
    private JTextField bloco;
    private JTextField bairro;
    private JTextField numero;
    private JTextField ano;
    private JButton cadastrarButton;
    private JButton sairButton;
    private JTextField senha;
    private JLabel nome;
    private JTextField cargo;
    private JTextField horainicio;
    private JTextField horafim;
    private JRadioButton medico;
    private JRadioButton atendente;
    private JRadioButton enfermeiro;

    public JFrame montarFrame(){
        JFrame frame = new JFrame("Cadastrar funcionario");
        frame.setContentPane(new CadastroFuncionario().CadastroFuncionario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JFrame getMainFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor( this.CadastroFuncionario);
    }
}
