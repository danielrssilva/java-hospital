import Forms.Login;
import JavaBeans.*;
import ClassesDao.*;


import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Login login = new Login();
        login.montarFrame();

        Calendar cali = Calendar.getInstance();
        cali.set(1993, 3, 3);

        Medico md = new Medico();
        MedicoDao mDao = new MedicoDao();
        md.setMatricula("md5732989");//mudar o id, se for executado mais de uma vez dá erro no banco.
        md.setCrm("43454354");
        md.setSenha("123");
        md.setNome("Jack Santana");
        md.setCpf("135.358.453-45");
        md.setDataNascimento(cali);
        md.setCargo("Cirugiao_assistente");
        md.setHoraInicioTrab("12:00");
        md.setHoraFinalTrab("0:00");

        mDao.adiciona(md);
    }
}
