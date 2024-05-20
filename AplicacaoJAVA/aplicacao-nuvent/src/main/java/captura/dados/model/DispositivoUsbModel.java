package captura.dados.model;

public class DispositivoUsbModel {

    private Integer id;
    private String nome;
    private Integer fkInfraAtm;

    public DispositivoUsbModel() {
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

    public Integer getFkInfraAtm() {
        return fkInfraAtm;
    }

    public void setFkInfraAtm(Integer fkInfraAtm) {
        this.fkInfraAtm = fkInfraAtm;
    }

    @Override
    public String toString() {
        return "DispositivoUsbModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fkInfraAtm=" + fkInfraAtm +
                '}';
    }
}
