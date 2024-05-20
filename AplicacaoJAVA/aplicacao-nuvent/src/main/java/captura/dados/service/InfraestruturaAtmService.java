package captura.dados.service;

import captura.dados.model.AtmModel;
import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class InfraestruturaAtmService {
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public Sistema pegarSistemaLooca() {
        return looca.getSistema();
    }

    public String pegarSistemaOperacionalLooca() {
        return pegarSistemaLooca().getSistemaOperacional();
    }

    public Integer pegarArquiteturaLooca() {
        return pegarSistemaLooca().getArquitetura();
    }

    public void inserirDadosInfraAtm() {
        templateMySQL.getTemplateMySQl().update("""
                insert into infraestruturaAtm (sistemaOperacional, arquitetura, fkAtm) values (?, ?, ?)
                """, pegarSistemaOperacionalLooca(), pegarArquiteturaLooca(), 1);
    }
}
