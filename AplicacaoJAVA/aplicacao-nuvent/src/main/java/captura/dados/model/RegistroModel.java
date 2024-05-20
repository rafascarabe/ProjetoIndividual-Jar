package captura.dados.model;

import java.time.LocalDate;

public class RegistroModel {
    private Integer id;
    private Integer qtdTotalProcessos;
    private String porcentagemUsoProcessador;
    private String qtdUsoMemoria;
    private String qtdDisponivelMemoria;
    private String porcentagemUsoMemoria;
    private String qtdUsoDisco;
    private String qtdDisponivelDisco;
    private String porcentagemUsoDisco;
    private LocalDate momentoRegistro;
    private Integer fkProcessador;
    private Integer fkMemoria;
    private Integer fkDisco;

    public RegistroModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdTotalProcessos() {
        return qtdTotalProcessos;
    }

    public void setQtdTotalProcessos(Integer qtdTotalProcessos) {
        this.qtdTotalProcessos = qtdTotalProcessos;
    }

    public String getPorcentagemUsoProcessador() {
        return porcentagemUsoProcessador;
    }

    public void setPorcentagemUsoProcessador(String porcentagemUsoProcessador) {
        this.porcentagemUsoProcessador = porcentagemUsoProcessador;
    }

    public String getQtdUsoMemoria() {
        return qtdUsoMemoria;
    }

    public void setQtdUsoMemoria(String qtdUsoMemoria) {
        this.qtdUsoMemoria = qtdUsoMemoria;
    }

    public String getQtdDisponivelMemoria() {
        return qtdDisponivelMemoria;
    }

    public void setQtdDisponivelMemoria(String qtdDisponivelMemoria) {
        this.qtdDisponivelMemoria = qtdDisponivelMemoria;
    }

    public String getPorcentagemUsoMemoria() {
        return porcentagemUsoMemoria;
    }

    public void setPorcentagemUsoMemoria(String porcentagemUsoMemoria) {
        this.porcentagemUsoMemoria = porcentagemUsoMemoria;
    }

    public String getQtdUsoDisco() {
        return qtdUsoDisco;
    }

    public void setQtdUsoDisco(String qtdUsoDisco) {
        this.qtdUsoDisco = qtdUsoDisco;
    }

    public String getQtdDisponivelDisco() {
        return qtdDisponivelDisco;
    }

    public void setQtdDisponivelDisco(String qtdDisponivelDisco) {
        this.qtdDisponivelDisco = qtdDisponivelDisco;
    }

    public String getPorcentagemUsoDisco() {
        return porcentagemUsoDisco;
    }

    public void setPorcentagemUsoDisco(String porcentagemUsoDisco) {
        this.porcentagemUsoDisco = porcentagemUsoDisco;
    }

    public LocalDate getMomentoRegistro() {
        return momentoRegistro;
    }

    public void setMomentoRegistro(LocalDate momentoRegistro) {
        this.momentoRegistro = momentoRegistro;
    }

    public Integer getFkProcessador() {
        return fkProcessador;
    }

    public void setFkProcessador(Integer fkProcessador) {
        this.fkProcessador = fkProcessador;
    }

    public Integer getFkMemoria() {
        return fkMemoria;
    }

    public void setFkMemoria(Integer fkMemoria) {
        this.fkMemoria = fkMemoria;
    }

    public Integer getFkDisco() {
        return fkDisco;
    }

    public void setFkDisco(Integer fkDisco) {
        this.fkDisco = fkDisco;
    }

    @Override
    public String toString() {
        return "RegistroModel{" +
                "id=" + id +
                ", qtdTotalProcessos=" + qtdTotalProcessos +
                ", porcentagemUsoProcessador='" + porcentagemUsoProcessador + '\'' +
                ", qtdUsoMemoria='" + qtdUsoMemoria + '\'' +
                ", qtdDisponivelMemoria='" + qtdDisponivelMemoria + '\'' +
                ", porcentagemUsoMemoria='" + porcentagemUsoMemoria + '\'' +
                ", qtdUsoDisco='" + qtdUsoDisco + '\'' +
                ", qtdDisponivelDisco='" + qtdDisponivelDisco + '\'' +
                ", porcentagemUsoDisco='" + porcentagemUsoDisco + '\'' +
                ", momentoRegistro=" + momentoRegistro +
                ", fkProcessador=" + fkProcessador +
                ", fkMemoria=" + fkMemoria +
                ", fkDisco=" + fkDisco +
                '}';
    }
}
