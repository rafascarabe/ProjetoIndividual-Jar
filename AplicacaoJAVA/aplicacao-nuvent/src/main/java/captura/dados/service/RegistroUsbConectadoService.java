package captura.dados.service;

import captura.dados.model.DispositivoUsbModel;
import captura.dados.model.RegistroModel;
import captura.dados.template.TemplateMySQL;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class RegistroUsbConectadoService {
    Looca looca = new Looca();
    TemplateMySQL templateMySQL = new TemplateMySQL();
    DispositivoUsbService dispositivoUsbService = new DispositivoUsbService();

    public List<DispositivoUsb> pegarListaDispositivoUsbConectadoLooca() {
        return looca.getDispositivosUsbGrupo().getDispositivosUsbConectados();
    }

//    Insere e coleta todos os dados necessários para a tabela
    public void inserirDadosRegistroUsb() {
        List<DispositivoUsbModel> listaDispositivoUsb = templateMySQL.pegarListaDispostivosUsbAtuais();
        Integer fkRegistro = 0;
        Integer fkDispositivoUsb = 0;

        for (int i = 0; i < pegarListaDispositivoUsbConectadoLooca().size(); i++) {
            DispositivoUsbModel dispositivoUsbAtual = listaDispositivoUsb.get(i);
            String nomeDispositivoUsbConectado = pegarListaDispositivoUsbConectadoLooca().get(i).getNome();
            Boolean conectado = false;

            if (dispositivoUsbAtual.getNome().equals(nomeDispositivoUsbConectado)) {
                conectado = true;
            }

            fkRegistro = templateMySQL.getTemplateMySQl().queryForObject("""
                select * from registro where id = ?;
                """, new BeanPropertyRowMapper<>(RegistroModel.class), templateMySQL.pegarIdRegistroMaisRecente()).getId();

            fkDispositivoUsb = dispositivoUsbAtual.getId();

            templateMySQL.getTemplateMySQl().update("""
                    insert into registroUsbConectado (fkRegistro, fkDispositivoUsb, conectado) values (?, ?, ?)
                    """,fkRegistro, fkDispositivoUsb, conectado);
        }
    }
}
