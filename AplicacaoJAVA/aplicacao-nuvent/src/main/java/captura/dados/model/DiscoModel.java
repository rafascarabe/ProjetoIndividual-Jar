package captura.dados.model;

public class DiscoModel {

    private Integer id;
    private String modelo;
    private String volume;
    private Integer fkInfraAtm;

    public DiscoModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getFkInfraAtm() {
        return fkInfraAtm;
    }

    public void setFkInfraAtm(Integer fkInfraAtm) {
        this.fkInfraAtm = fkInfraAtm;
    }

    @Override
    public String toString() {
        return "DiscoModel{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", volume='" + volume + '\'' +
                ", fkInfraAtm=" + fkInfraAtm +
                '}';
    }
}
