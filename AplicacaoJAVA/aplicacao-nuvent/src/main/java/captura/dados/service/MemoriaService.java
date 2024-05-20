package captura.dados.service;

import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;

public class MemoriaService {

    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public Memoria pegarMemoriaLooca() {
        return looca.getMemoria();
    }

    public String pegarTamanhoTotalLooca() {
        Long tamanhoTotal = pegarMemoriaLooca().getTotal();
        String tamanhoTotalConvertida = conversor.formatarBytes(tamanhoTotal);
        return tamanhoTotalConvertida;
    }

    public void inserirDadosMemoria(){
        templateMySQL.getTemplateMySQl().update("""
                    insert into memoria (tamanhoTotal, fkInfraAtm) values
                    (?, ?);
                """, pegarTamanhoTotalLooca(), templateMySQL.pegarIdInfraAtmMaisRecente());
    }
}

