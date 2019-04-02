package JavaBeans;

import java.util.Calendar;

public class Funcionario {
    private String matricula;
    private String nome;
    private String CPF;
    private Calendar dataNascimento;
    private String funcao;
    private String horaInicioTrab;
    private String HoraFinalTrab;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public String getHoraInicioTrab() {
        return horaInicioTrab;
    }
    public void setHoraInicioTrab(String horaInicioTrab) {
        this.horaInicioTrab = horaInicioTrab;
    }
    public String getHoraFinalTrab() {
        return HoraFinalTrab;
    }
    public void setHoraFinalTrab(String horaFinalTrab) {
        HoraFinalTrab = horaFinalTrab;
    }
}
