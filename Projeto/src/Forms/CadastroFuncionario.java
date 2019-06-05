package Forms;

import ClassesDao.EnderecoDao;
import ClassesDao.EnfermeiroDao;
import ClassesDao.FuncionarioDao;
import ClassesDao.MedicoDao;
import JavaBeans.Endereco;
import JavaBeans.Enfermeiro;
import JavaBeans.Funcionario;
import JavaBeans.Medico;

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
    private JTextField cargo;
    private JTextField horainicio;
    private JTextField horafim;
    private JRadioButton medico;
    private JRadioButton atendente;
    private JRadioButton enfermeiro;
    private JTextField nome;
    private JLabel matriculaLabel;
    private JLabel senhaLabel;
    private JLabel nomeLabel;
    private JTextField crm;
    private JTextField especialidade;
    private JTextField coren;

    public CadastroFuncionario() {
        crm.setEditable(false);
        especialidade.setEditable(false);
        coren.setEditable(false);
        cadastrarButton.addActionListener(e -> {
            if(medico.isSelected() == true || enfermeiro.isSelected() == true || atendente.isSelected() == true) {
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
                funcionario.setNome(nome.getText());
                funcionario.setCpf(cpf.getText());
                funcionario.setSenha(senha.getText());
                funcionario.setCargo(cargo.getText());
                if(medico.isSelected() == true){
                    Medico medico = new Medico();
                    MedicoDao medicoDao = new MedicoDao();
                    medico.setCrm(crm.getText());
                        funcionario.setMatricula("MD" + matricula.getText());
                        funcionario.setEndereco(endereco.getId());
                        funcionarioDao.adiciona(funcionario);
                    medico.setMatricula("MD" + matricula.getText());
                    medico.setEspecialidade(especialidade.getText());
                    medicoDao.adiciona(medico);
                }else if(enfermeiro.isSelected() == true){
                    Enfermeiro enfermeiro = new Enfermeiro();
                    EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
                        funcionario.setMatricula("EN" + matricula.getText());
                        funcionario.setEndereco(endereco.getId());
                        funcionarioDao.adiciona(funcionario);
                    enfermeiro.setMatricula("EN" + matricula.getText());
                    enfermeiro.setCoren(coren.getText());
                    enfermeiroDao.adiciona(enfermeiro);
                }else{
                    funcionario.setMatricula("AT" + matricula.getText());
                    funcionario.setEndereco(endereco.getId());
                    funcionarioDao.adiciona(funcionario);

                }

                this.getMainFrame().dispose();
                CadastroFuncionario cadastrarFuncionario = new CadastroFuncionario();
                cadastrarFuncionario.montarFrame();
            }else{
                System.out.println("Erro de selecão de tipo");
            }
        });
        sairButton.addActionListener(e -> {
            this.getMainFrame().dispose();
            Login login = new Login();
            login.montarFrame();
        });
        medico.addActionListener(e -> {
            if(medico.isSelected() == true) {
                crm.setEditable(true);
                especialidade.setEditable(true);
                coren.setEditable(false);
                coren.setText("");
            }
        });
        enfermeiro.addActionListener(e -> {
            if(enfermeiro.isSelected() == true) {
                coren.setEditable(true);
                crm.setEditable(false);
                crm.setText("");
                especialidade.setEditable(false);
                especialidade.setText("");
            }
        });
        atendente.addActionListener(e -> {
            if(atendente.isSelected() == true) {
                coren.setEditable(false);
                coren.setText("");
                crm.setEditable(false);
                crm.setText("");
                especialidade.setEditable(false);
                especialidade.setText("");
            }
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

}
