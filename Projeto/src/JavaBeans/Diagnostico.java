package JavaBeans;

public class Diagnostico {
    private String descricao;
    private String especialidade;
    private String id;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
