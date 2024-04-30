package captura.dados.model;

import com.github.britooo.looca.api.group.janelas.Janela;

import java.util.ArrayList;
import java.util.List;

public class AtmModel {
    private Integer idAtm;
    private String sistemaOperacional;
    private Integer arquitetura;
    private Integer fkBanco;
    private List<Janela> listaJanelas;

    public void AtmModel(){

    }

    public Integer getIdAtm() {
        return idAtm;
    }

    public void setIdAtm(Integer idAtm) {
        this.idAtm = idAtm;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(Integer arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Integer getFkBanco() {
        return fkBanco;
    }

    public void setFkBanco(Integer fkBanco) {
        this.fkBanco = fkBanco;
    }

    public List<Janela> getListaJanelas() {
        return listaJanelas;
    }

    public void setListaJanelas(List<Janela> listaJanelas) {
        this.listaJanelas = listaJanelas;
    }

//    @Override
//    public String toString() {
//        return
//                """
//                ----------- AtmModel:
//                idAtm= %d
//                sistemaOperacional= %s
//                arquitetura= %d
//                fkBanco= %d
//                        """.formatted(idAtm, sistemaOperacional, arquitetura, fkBanco);
//
//    }


    @Override
    public String toString() {
        return "AtmModel{" +
                "idAtm=" + idAtm +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                ", arquitetura=" + arquitetura +
                ", fkBanco=" + fkBanco +
                ", \nlistaJanelas=" + listaJanelas +
                '}';
    }
}
