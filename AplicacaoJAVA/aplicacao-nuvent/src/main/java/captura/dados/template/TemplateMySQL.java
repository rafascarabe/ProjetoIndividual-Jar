package captura.dados.template;

import captura.dados.conexao.ConexaoMySQL;
import captura.dados.model.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TemplateMySQL {
    public ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
    public JdbcTemplate templateMySQl = conexaoMySQL.getConexaoBanco();

    public TemplateMySQL() {
    }

    public Integer pegarIdInfraAtmMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from infraestruturaAtm where fkAtm = 1 order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(InfraestruturaAtmModel.class)).getId();
    }

    public Integer pegarIdInfraAtm() {
        return templateMySQl.queryForObject("""
                    select * from infraestruturaAtm where fkAtm = 1 order by id asc limit 1;
                    """, new BeanPropertyRowMapper<>(InfraestruturaAtmModel.class)).getId();//1 limit 1
    }

    public Integer pegarIdProcessadorMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from processador where fkInfraAtm = ? order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(ProcessadorModel.class), pegarIdInfraAtmMaisRecente()).getId();
    }

    public Integer pegarIdMemoriaMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from memoria where fkInfraAtm = ? order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(MemoriaModel.class), pegarIdInfraAtmMaisRecente()).getId();
    }

    public Integer pegarIdDiscoMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from disco where fkInfraAtm = ? order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(DiscoModel.class), pegarIdInfraAtmMaisRecente()).getId();
    }

    public Integer pegarIdRegistroMaisRecente() {
        return templateMySQl.queryForObject("""
                    select * from registro where fkProcessador = ? order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(RegistroModel.class), pegarIdProcessadorMaisRecente()).getId();
    }

    public List<DispositivoUsbModel> pegarListaDispostivosUsbAtuais() {
        return templateMySQl.query("""
                select * from dispositivoUsb where fkInfraAtm = ? order by id
                """, new BeanPropertyRowMapper<>(DispositivoUsbModel.class), pegarIdInfraAtmMaisRecente());
    }

    public Integer pegarJanelaMaisRecentePorId() {
        return templateMySQl.queryForObject("""
                    select * from janelas order by id desc limit 1
                    """, new BeanPropertyRowMapper<>(JanelaModel.class)).getIdJanela();
    }

    public JdbcTemplate getTemplateMySQl() {
        return templateMySQl;
    }
}
