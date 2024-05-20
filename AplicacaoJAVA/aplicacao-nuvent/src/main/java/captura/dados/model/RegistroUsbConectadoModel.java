package captura.dados.model;

public class RegistroUsbConectadoModel {
    private Integer id;
    private Integer fkRegistro;
    private Integer fkDispositivoUsb;
    private Boolean conectado;

    public RegistroUsbConectadoModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkRegistro() {
        return fkRegistro;
    }

    public void setFkRegistro(Integer fkRegistro) {
        this.fkRegistro = fkRegistro;
    }

    public Integer getFkDispositivoUsb() {
        return fkDispositivoUsb;
    }

    public void setFkDispositivoUsb(Integer fkDispositivoUsb) {
        this.fkDispositivoUsb = fkDispositivoUsb;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String toString() {
        return "RegistroUsbConectadoModel{" +
                "id=" + id +
                ", fkRegistro=" + fkRegistro +
                ", fkDispositivoUsb=" + fkDispositivoUsb +
                ", conectado=" + conectado +
                '}';
    }
}
