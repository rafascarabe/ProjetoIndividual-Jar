package captura.dados.service;


import captura.dados.model.AtmModel;
import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;

import java.util.List;

public class JanelaService {

    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();

    public void capturarJanelas() {
        Integer fkAtm = templateMySQL.pegarIdInfraAtm();

        List<Janela> listaJanelas = janelaGrupo.getJanelas();

        // Log para depuração
        System.out.println("Quantidade de janelas capturadas: " + listaJanelas.size());

        for (Janela janela : listaJanelas) {
            String titulo = janela.getTitulo();

            // IMPORTANTE: Alerta/console.log quando uma janela não autorizada for aberta
            // DESEJAVEL: criar um mecanismo pra fechar janelas não desejadas

            if (titulo != null && !titulo.isEmpty()) {
                System.out.println("-------- Capturando janela: " + titulo + " com fkAtm: " + fkAtm); // Log para depuração
                inserirJanela(janela, fkAtm); // Passa o fkAtm obtido para o método de inserção
            } else {
                System.out.println("Janela com título nulo ou vazio ignorada.");
            }
        }
    }

    public void inserirJanela(Janela janela, Integer fkAtm) {
        templateMySQL.getTemplateMySQl().update("""
                    INSERT INTO janelas (titulo, fkAtm) VALUES (?, ?)
                    """, janela.getTitulo(), fkAtm); // Usa o fkAtm passado
    }

}


