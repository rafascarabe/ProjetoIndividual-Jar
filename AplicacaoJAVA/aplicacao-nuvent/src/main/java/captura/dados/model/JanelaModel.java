package captura.dados.model;

public class JanelaModel {

    private Integer idJanela;
    private String titulo;
    private Integer fkAtm;

    public JanelaModel(Integer idJanela, String titulo,Integer fkAtm) {
        this.idJanela = idJanela;
        this.titulo = titulo;
        this.fkAtm = fkAtm;
    }

    public JanelaModel() {
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

    public Integer getFkAtm() {
        return fkAtm;
    }

    public void setFkAtm(Integer fkAmt) {
        this.fkAtm = fkAmt;
    }

    @Override
    public String toString() {
        return "JanelaModel:" +
                "|idJanela: " + idJanela +
                ", |titulo:'" + titulo + '\'' +
                ", |fkAtm:" + fkAtm +
                '}';
    }
}

