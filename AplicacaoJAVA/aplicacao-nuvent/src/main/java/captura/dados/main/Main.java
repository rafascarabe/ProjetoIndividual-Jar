package captura.dados.main;

import captura.dados.model.*;
import captura.dados.service.*;
import captura.dados.template.TemplateMySQL;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        TemplateMySQL templateMySQL = new TemplateMySQL();

        Integer delay = 1000;
        Integer intervalo = 5000;
        Timer timer = new Timer();

        InfraestruturaAtmService infraestruturaAtmService = new InfraestruturaAtmService();
        ProcessadorService processadorService = new ProcessadorService();
        MemoriaService memoriaService = new MemoriaService();
        DiscoService discoService= new DiscoService();
        DispositivoUsbService dispositivoUsbService = new DispositivoUsbService();
        RegistroService registroService = new RegistroService();
        RegistroUsbConectadoService registroUsbConectadoService = new RegistroUsbConectadoService();
        JanelaService janelaService = new JanelaService();  // Adiciona JanelaService

        infraestruturaAtmService.inserirDadosInfraAtm();
        processadorService.inserirDadosProcessador();
        memoriaService.inserirDadosMemoria();
        discoService.inserirPegarModeloVolumeDiscoLooca();
        dispositivoUsbService.inserirPegarNomeDispositivo();
        janelaService.capturarJanelas();  // Insere dados das janelas abertas

        System.out.println("Inseriu os dados estáticos de hardware");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                registroService.inserirDadosRegistro();
                registroUsbConectadoService.inserirDadosRegistroUsb();

                System.out.println("Está inserindo os registros");
                System.out.println("------------");
                System.out.println(templateMySQL.getTemplateMySQl().query("""
                select * from janelas;
                """, new BeanPropertyRowMapper<>(JanelaModel.class)));
            }
        }, delay, intervalo);
    }
}
