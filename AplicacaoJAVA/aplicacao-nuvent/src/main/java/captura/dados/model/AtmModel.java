package captura.dados.model;

public class AtmModel {
    private Integer id;
    private String nome;
    private Integer fkBanco;

    public AtmModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkBanco() {
        return fkBanco;
    }

    public void setFkBanco(Integer fkBanco) {
        this.fkBanco = fkBanco;
    }

    @Override
    public String toString() {
        return "AtmModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fkBanco=" + fkBanco +
                '}';
    }
}
