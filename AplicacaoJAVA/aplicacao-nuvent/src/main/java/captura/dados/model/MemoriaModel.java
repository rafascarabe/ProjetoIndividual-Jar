package captura.dados.model;

import java.net.Inet4Address;

public class MemoriaModel {

    private Integer id;
    private String tamanhoTotal;
    private Integer fkInfraAtm;

    public MemoriaModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTamanhoTotal() {
        return tamanhoTotal;
    }

    public void setTamanhoTotal(String tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
    }

    public Integer getFkInfraAtm() {
        return fkInfraAtm;
    }

    public void setFkInfraAtm(Integer fkInfraAtm) {
        this.fkInfraAtm = fkInfraAtm;
    }

    @Override
    public String toString() {
        return "MemoriaModel{" +
                "id=" + id +
                ", tamanhoTotal='" + tamanhoTotal + '\'' +
                ", fkInfraAtm=" + fkInfraAtm +
                '}';
    }
}

