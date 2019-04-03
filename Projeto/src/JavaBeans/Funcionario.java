package JavaBeans;

import java.util.Calendar;

public class Funcionario {
    private String matricula;
    private String nome;
    private String senha;
    private String cpf;
    private Calendar dataNascimento;
    private String cargo;
    private String horaInicioTrab;
    private String horaFinalTrab;

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo= cargo;
    }
    public String getHoraInicioTrab() {
        return horaInicioTrab;
    }
    public void setHoraInicioTrab(String horaInicioTrab) {
        this.horaInicioTrab = horaInicioTrab;
    }
    public String getHoraFinalTrab() {
        return this.horaFinalTrab;
    }
    public void setHoraFinalTrab(String horaFinalTrab) {
        this.horaFinalTrab = horaFinalTrab;
    }
}
