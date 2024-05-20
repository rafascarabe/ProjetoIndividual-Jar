package captura.dados.service;


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
        Integer fkAtm = templateMySQL.pegarIdInfraAtmMaisRecente(); // Obtém o ID mais recente apenas uma vez

        List<Janela> listaJanelas = janelaGrupo.getJanelas();

        // Adiciona log para depuração
        System.out.println("Quantidade de janelas capturadas: " + listaJanelas.size());

        for (Janela janela : listaJanelas) {
            System.out.println("Capturando janela: " + janela.getTitulo() + " com fkAtm: " + fkAtm); // Log para depuração
            inserirJanela(janela, fkAtm); // Passa o fkAtm obtido para o método de inserção
        }
    }

    public void inserirJanela(Janela janela, Integer fkAtm) {
        templateMySQL.getTemplateMySQl().update("""
                    INSERT INTO janelas (titulo, fkAtm) VALUES (?, ?)
                    """, janela.getTitulo(), fkAtm); // Usa o fkAtm passado
    }

}


