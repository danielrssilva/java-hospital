package Codigo;
/*
 * Esta é a classe que possui todos os dados do funcionario
 * 
 * */
public class Funcionario {
	private int matricula;
	private String nome;
	private String CPF;
	private String dataNascimento;
	private String funcao;
	private String horaInicioTrab;
	private String HoraFinalTrab;
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
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
	
	
}
