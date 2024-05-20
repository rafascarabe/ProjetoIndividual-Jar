var database = require("../database/config");

async function cadastrar(nome, nomeFantasia, cnpj, logradouro, numero, cep, estado, complemento) {
    try {
        var instrucaoSql_Banco = `INSERT INTO banco (nomeFantasia, razaoSocial, cnpj) VALUES ('${nomeFantasia}', '${nome}', '${cnpj}')`;
        await database.executar(instrucaoSql_Banco);
        
        var fkBanco = `SELECT MAX(idBanco) AS ultimo_id FROM banco`;
        var result = await database.executar(fkBanco);
        
        var fkBanco = result[0].ultimo_id;
        var instrucaoSql_Endereco = `INSERT INTO endereco(logradouro, numero, complemento, cep, uf, fkBanco) VALUES ('${logradouro}', '${numero}', '${complemento}', '${cep}', '${estado}', '${fkBanco}')`;
        await database.executar(instrucaoSql_Endereco);

        // Redirecionar para a página de destino se todas as operações forem bem-sucedidas
        window.location.href = "cadastroGerente.html";
    } catch (error) {
        console.log("ERRO NO SQL: ", error);
        // Verificar se o erro é devido a um registro duplicado
        if (error.code === 'ER_DUP_ENTRY') {
            console.log("Registro duplicado, não redirecionando...");
        }
    }
}

module.exports = { cadastrar };