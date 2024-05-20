package captura.dados.model;

public class ProcessadorModel {
    private Integer id;
    private String nome;
    private String modelo;
    private String frequencia;
    private Integer qtdProcessadorFisico;
    private Integer qtdProcessadorLogico;
    private Integer fkInfraAtm;

    public ProcessadorModel() {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public Integer getQtdProcessadorFisico() {
        return qtdProcessadorFisico;
    }

    public void setQtdProcessadorFisico(Integer qtdProcessadorFisico) {
        this.qtdProcessadorFisico = qtdProcessadorFisico;
    }

    public Integer getQtdProcessadorLogico() {
        return qtdProcessadorLogico;
    }

    public void setQtdProcessadorLogico(Integer qtdProcessadorLogico) {
        this.qtdProcessadorLogico = qtdProcessadorLogico;
    }

    public Integer getFkInfraAtm() {
        return fkInfraAtm;
    }

    public void setFkInfraAtm(Integer fkInfraAtm) {
        this.fkInfraAtm = fkInfraAtm;
    }

    @Override
    public String toString() {
        return "ProcessadorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", frequencia='" + frequencia + '\'' +
                ", qtdProcessadorFisico=" + qtdProcessadorFisico +
                ", qtdProcessadorLogico=" + qtdProcessadorLogico +
                ", fkInfraAtm=" + fkInfraAtm +
                '}';
    }
}
