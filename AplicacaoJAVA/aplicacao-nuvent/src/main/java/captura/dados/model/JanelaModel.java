package captura.dados.model;

public class JanelaModel {

    private Integer idJanela;
    private String titulo;
    private Integer fkAmt;

    public JanelaModel(Integer idJanela, String titulo,Integer fkAtm) {
        this.idJanela = idJanela;
        this.titulo = titulo;
        this.fkAmt = fkAtm;
    }

    public Integer getIdJanela() {
        return idJanela;
    }

    public void setIdJanela(Integer idJanela) {
        this.idJanela = idJanela;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getFkAmt() {
        return fkAmt;
    }

    public void setFkAmt(Integer fkAmt) {
        this.fkAmt = fkAmt;
    }

    @Override
    public String toString() {
        return "JanelaModel{" +
                "idJanela=" + idJanela +
                ", titulo='" + titulo + '\'' +
                ", fkAmt=" + fkAmt +
                '}';
    }
}

