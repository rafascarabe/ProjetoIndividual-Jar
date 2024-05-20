package captura.dados.service;

import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;

import java.util.List;

public class DiscoService {

    Conversor conversor = new Conversor();
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();

    public DiscoGrupo pegarDiscoGrupoLooca() {
        return looca.getGrupoDeDiscos();
    }

    public List<Disco> pegarListaDiscoLooca() {
        return pegarDiscoGrupoLooca().getDiscos();
    }

    public List<Volume> pegarListaVolumeLooca() {
        return pegarDiscoGrupoLooca().getVolumes();
    }

    public void inserirPegarModeloVolumeDiscoLooca() {
            String modeloDisco = pegarListaDiscoLooca().get(0).getModelo();
            String volumeDisco = conversor.formatarBytes(pegarListaVolumeLooca().get(0).getTotal());

            templateMySQL.getTemplateMySQl().update("""
                insert into disco (modelo, volume, fkInfraAtm) values
                    (?, ?, ?);
                """, modeloDisco, volumeDisco, templateMySQL.pegarIdInfraAtmMaisRecente());
    }
}
