package captura.dados.service;

import captura.dados.model.AtmModel;
import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.util.List;

public class AtmService {
    Looca looca = new Looca();
    AtmModel atmModel = new AtmModel();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();

    public Sistema pegarSistemaLooca() {
        return looca.getSistema();
    }

    public String pegarSistemaOperacionalLooca() {
        return pegarSistemaLooca().getSistemaOperacional();
    }

    public Integer pegarArquiteturaLooca() {
        return pegarSistemaLooca().getArquitetura();
    }

    public void inserirDadosAtm() {
        templateMySQL.getTemplateMySQl().update("""
                insert into atm (sistemaOperacional, arquitetura, fkBanco) values (?, ?, ?)
                """, pegarSistemaOperacionalLooca(), pegarArquiteturaLooca(), templateMySQL.pegarIdBancoMaisRecente());
    }

    public void inserirDadosJanelas() {
        Integer idAtm = templateMySQL.pegarIdAtmMaisRecente();
        List<Janela> listaJanelas = janelaGrupo.getJanelas();
        for (Janela janela : listaJanelas) {
            if (janela.getTitulo().contains("Google Chrome") ||
                    janela.getTitulo().contains("SPTECH") ||
                    janela.getTitulo().contains("Firefox") ||
                    janela.getTitulo().contains("Opera")) {
                inserirJanela(janela, idAtm);
            } else{
                System.out.println("nenhuma janela encontrada");
            }
        }
    }

    public void inserirJanela(Janela janela, Integer fkAtm) {
        AtmModel atmModel = new AtmModel();
        atmModel.setIdAtm(fkAtm);
        atmModel.getListaJanelas().add(janela);
        templateMySQL.getTemplateMySQl().update("""
                insert into janela (titulo, fkAtm) values (?, ?)
                """, janela.getTitulo(), fkAtm);
    }

}
