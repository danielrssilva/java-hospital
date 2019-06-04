package Forms;

import ClassesDao.DiagnosticoDao;
import ClassesDao.EnderecoDao;
import ClassesDao.FuncionarioDao;
import ClassesDao.PacienteDao;
import JavaBeans.Diagnostico;
import JavaBeans.Endereco;
import JavaBeans.Funcionario;
import JavaBeans.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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
    private JTextField name;


    public CadastroFuncionario() {
        cadastrarButton.addActionListener(e -> {

            Endereco endereco = new Endereco();
            EnderecoDao enderecoDao = new EnderecoDao();
            endereco.setEstado(estado.getText());
            endereco.setCidade(cidade.getText());
            endereco.setBairro(bairro.getText());
            endereco.setLogradouro(logradouro.getText());
            endereco.setNumero(numero.getText());
            endereco.setBloco(bloco.getText());
            enderecoDao.insertEndereco(endereco);

            Funcionario funcionario = new Funcionario();
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            //matricula, senha, nome, cpf, data_nascimento, cargo, hora_inicio, hora_fim
            funcionario.setMatricula(matricula.getText());
            funcionario.setNome(name.getText());
            funcionario.setCpf(cpf.getText());
            funcionario.setEndereco(endereco.getId());
            funcionarioDao.adiciona(funcionario);

            this.getMainFrame().dispose();
            CadastroPaciente cadastrarPaciente = new CadastroPaciente();
            cadastrarPaciente.montarFrame();
        });
    }

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
