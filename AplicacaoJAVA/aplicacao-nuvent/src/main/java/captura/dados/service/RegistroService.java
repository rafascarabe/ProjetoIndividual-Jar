package captura.dados.service;

import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

import java.text.DecimalFormat;

public class RegistroService {
    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    DecimalFormat formatarDecimal = new DecimalFormat("#.0");
    ProcessadorService processadorService = new ProcessadorService();
    MemoriaService memoriaService = new MemoriaService();
    DiscoService discoService = new DiscoService();

    public Double pegarUsoProcessador() {
        return processadorService.pegarProcessadorLooca().getUso();
    }

    public Long pegarUsoMemoria() {
        return memoriaService.pegarMemoriaLooca().getEmUso();
    }

    public Long pegarDisponivelMemoria() {
        return memoriaService.pegarMemoriaLooca().getDisponivel();
    }

    public Long pegarTotalMemoria() {
        return memoriaService.pegarMemoriaLooca().getTotal();
    }

    public Integer pegarQtdTotalProcessosLooca() {
//        Aqui está certo chamar o looca dessa forma
        Integer qtdTotalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
        return qtdTotalProcessos;
    }

    public String pegarPorcentagemUsoProcessador() {
        Double usoProcessador = pegarUsoProcessador();
        String porcentagemUsoProcessador = formatarDecimal.format(usoProcessador);
        return porcentagemUsoProcessador;
    }

    public String pegarQtdUsoMemoria() {
        String qtdUsoMemoria = conversor.formatarBytes(pegarUsoMemoria());
        return qtdUsoMemoria;
    }

    public String pegarQtdDisponivelMemoria() {
        Long qtdDisponivelMemoriaBytes = pegarDisponivelMemoria();
        String qtdDisponivelMemoria = conversor.formatarBytes(qtdDisponivelMemoriaBytes);
        return qtdDisponivelMemoria;
    }

    public String pegarPorcentagemUsoMemoria() {
        Double porcentagemUsoMemoriaBytes = (pegarUsoMemoria() * 100.0) / pegarTotalMemoria();
        String porcentagemUsoMemoria = formatarDecimal.format(porcentagemUsoMemoriaBytes);
        return porcentagemUsoMemoria;
    }

//    Faz insert do registro e também coleta os dados de Disco necessários
    public void inserirDadosRegistro() {
            Long qtdTotalDiscoBytes = discoService.pegarListaVolumeLooca().get(0).getTotal();
            Long qtdDisponivelDiscoBytes = discoService.pegarListaVolumeLooca().get(0).getDisponivel();
            Long qtdUsoDiscoBytes = qtdTotalDiscoBytes - qtdDisponivelDiscoBytes;
            Double porcentagemUsoDiscoBytes = ((qtdUsoDiscoBytes * 100.0) / qtdTotalDiscoBytes) / 10.0;

            String qtdUsoDisco = conversor.formatarBytes(qtdUsoDiscoBytes);
            String qtdDisponivelDisco = conversor.formatarBytes(qtdDisponivelDiscoBytes);
            String porcentagemUsoDisco = formatarDecimal.format(porcentagemUsoDiscoBytes);

            templateMySQL.getTemplateMySQl().update("""
                    insert into registro
                    (qtdTotalProcessos, porcentagemUsoProcessador, qtdUsoMemoria, qtdDisponivelMemoria,
                    porcentagemUsoMemoria, qtdUsoDisco, qtdDisponivelDisco, porcentagemUsoDisco, fkProcessador,
                    fkMemoria, fkDisco)
                    values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """, pegarQtdTotalProcessosLooca(), pegarPorcentagemUsoProcessador(), pegarQtdUsoMemoria(),
                    pegarQtdDisponivelMemoria(), pegarPorcentagemUsoMemoria(), qtdUsoDisco, qtdDisponivelDisco,
                    porcentagemUsoDisco, templateMySQL.pegarIdProcessadorMaisRecente(), templateMySQL.pegarIdMemoriaMaisRecente(),
                    templateMySQL.pegarIdDiscoMaisRecente());
    }
}
