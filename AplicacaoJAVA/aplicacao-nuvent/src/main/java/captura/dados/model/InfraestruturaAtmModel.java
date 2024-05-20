package captura.dados.model;

public class InfraestruturaAtmModel {

    private Integer id;
    private String sistemaOperacional;
    private Integer fkAtm;

    public InfraestruturaAtmModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAtm) {
        this.fkAtm = fkAtm;
    }

    @Override
    public String toString() {
        return "InfraestruturaAtmModel{" +
                "id=" + id +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                ", fkAtm=" + fkAtm +
                '}';
    }
}
