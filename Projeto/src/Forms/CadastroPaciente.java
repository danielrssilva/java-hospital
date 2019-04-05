package Forms;

import ClassesDao.DiagnosticoDao;
import ClassesDao.EnderecoDao;
import ClassesDao.PacienteDao;
import JavaBeans.Diagnostico;
import JavaBeans.Endereco;
import JavaBeans.Paciente;
import java.util.Calendar;

import javax.swing.*;

public class CadastroPaciente {
    private JPanel CadastroPaciente;
    private JTextField nome;
    private JFormattedTextField dia;
    private JFormattedTextField telefone;
    private JTextField estado;
    private JTextArea sintomas;
    private JButton cadastrarButton;
    private JButton sairButton;
    private JTextField especialidade;
    private JTextField cidade;
    private JTextField bairro;
    private JTextField logradouro;
    private JTextField numero;
    private JTextField bloco;
    private JTextField cpf;
    private JTextField mes;
    private JTextField ano;

    Calendar cale =  Calendar.getInstance();
    public CadastroPaciente() {
        sairButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            Login login = new Login();
            login.montarFrame();
        });
        cadastrarButton.addActionListener(e -> {

            cale.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia.getText()));
            int mes1 = Integer.parseInt(mes.getText())-1;
            cale.set(Calendar.MONTH, mes1);
            cale.set(Calendar.YEAR, Integer.parseInt(ano.getText()));

            Diagnostico diagnostico = new Diagnostico();
            DiagnosticoDao diagDao = new DiagnosticoDao();
            diagnostico.setDescricao(sintomas.getText());
            diagnostico.setEspecialidade(especialidade.getText());
            diagDao.insertDiagnostico(diagnostico);

            Endereco endereco = new Endereco();
            EnderecoDao enderecoDao = new EnderecoDao();
            endereco.setEstado(estado.getText());
            endereco.setCidade(cidade.getText());
            endereco.setBairro(bairro.getText());
            endereco.setLogradouro(logradouro.getText());
            endereco.setNumero(numero.getText());
            endereco.setBloco(bloco.getText());
            enderecoDao.insertEndereco(endereco);

            Paciente paciente = new Paciente();
            PacienteDao pacienteDao = new PacienteDao();
            paciente.setNome(nome.getText());
            paciente.setTelefone(telefone.getText());
            paciente.setCpf(cpf.getText());
            paciente.setDataNascimento(cale);
            paciente.setEndereço(endereco.getId());
            paciente.setDiagnostico(diagnostico.getId());
            pacienteDao.setPaciente(paciente);

            this.getMainFrame().dispose();
            CadastroPaciente cadastrarPaciente = new CadastroPaciente();
            cadastrarPaciente.montarFrame();
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
