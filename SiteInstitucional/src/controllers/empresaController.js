var empresaModel = require("../models/empresaModel");

function cadastrar(req, res) {
    var nome = req.body.nome;
    var nomeFantasia = req.body.nomeFantasia;
    var cnpj = req.body.cnpj;
    var logradouro = req.body.logradouro;
    var numero = req.body.numero;
    var cep = req.body.cep;
    var estado = req.body.estado;
    var complemento = req.body.complemento;

    empresaModel.cadastrar(nome, nomeFantasia, cnpj, logradouro, numero, cep, estado, complemento)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o cadastro! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
}

module.exports = {
    cadastrar
};
