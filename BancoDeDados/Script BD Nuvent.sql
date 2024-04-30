drop database if exists nuvent;
create database nuvent;

use nuvent;

-- Criação do usuario --

create user if not exists 'nuventUser'@'localhost' identified by 'nuvent';
grant all privileges on nuvent.* to 'nuventUser'@'localhost';
flush privileges;

-- TABELAS --

create table banco (
	idBanco int primary key auto_increment,
    nomeFantasia varchar(45),
    razaoSocial varchar(45),
    cnpj char(14) unique
);

create table endereco(
	idEndereco int primary key auto_increment,
    logradouro varchar(255),
    numero int,
    complemento varchar(255),
    cep char(8),
    uf varchar(2),
    fkBanco int
);

create table usuario(
	idUsuario int primary key auto_increment,
    nomeCompleto varchar(255),
    dtNascimento date,
    email varchar(255) unique,
    senha varchar(50),
    telefone varchar(16),
    cargo varchar(50),
    fkBanco int
);

create table permissionamento(
	idPermissionamento int primary key auto_increment,
    descrição varchar(255),
    nomePermissionamento varchar(60),
    fkusuario int
);

create table atm (
	idAtm int primary key auto_increment,
    sistemaOperacional varchar(100),
    arquitetura int,
    fkBanco int
);

create table janela(
	idJanela int primary key auto_increment,
    fkAtm int,
    tituloJanela varchar(200)
);

select*from janela;

create table processador(
	idProcessador int primary key auto_increment,
    nomeProcessador varchar(100),
    modeloProcessador varchar(100),
    frequenciaProcessador varchar(20),
	qtdProcessadorFisico int,
    qtdProcessadorLogico int,
    fkAtm int
);

create table memoria(
	idMemoria int primary key auto_increment,
    tamanhoTotal varchar(10),
    fkAtm int
);

create table disco(
	idDisco int primary key auto_increment,
    modeloDisco varchar(60),
    volumeDisco varchar(45),
    fkAtm int
);

create table dispositivoUsb(
	idDispositivoUsb int primary key auto_increment,
    nomeDispositivo varchar(100),
    fkAtm int
);

create table registro(
	idRegistro int primary key auto_increment,
    qtdTotalProcessos int,
    porcentagemUsoProcessador varchar(10),
    qtdUsoMemoria varchar(10),
    qtdDisponivelMemoria varchar(10),
    porcentagemUsoMemoria varchar(10),
    qtdUsoDisco varchar(10),
    qtdDisponivelDisco varchar(10),
    porcentagemUsoDisco varchar(10),
    momentoRegistro datetime default current_timestamp,
    fkProcessador int,
    fkMemoria int,
    fkDisco int
);

create table registroDispositivoUsbConectado(
	idRegistroDispositivoUsbConectado int primary key auto_increment,
    fkRegistro int,
    fkDispositivoUsb int,
    conectado tinyint
);

create table alerta(
	idAlerta int primary key auto_increment,
    descricaoAlerta varchar(255),
    dtAlerta datetime default current_timestamp,
    fkRegistroDispositivoUsbConectado int
);

create table baseConhecimento(
	idBaseConhecimento int primary key auto_increment,
    codigoProblema varchar(100),
    nomenclaturaProblema varchar(45),
    descricaoProblema varchar(255),
    propostaSolucao text,
    habilidadeNecessaria varchar(255)
);

create table relatorio(
	idRelatorio int primary key auto_increment,
    dtRelatorio datetime default current_timestamp,
    fkAlerta int,
    fkBaseConhecimento int
);

-- foreign keys --

-- banco <- endereço
alter table endereco 
	add constraint enderecoBanco
		foreign key(fkBanco)
		references banco(idBanco);
    
-- usuario <- banco
alter table usuario
	add constraint usuarioBanco
		foreign key(fkBanco)
		references banco(idBanco);
        
-- usuario <- permissionamento
alter table permissionamento
	add constraint permissionamentoUsuario
		foreign key(fkUsuario)
        references permissionamento(idPermissionamento);
        
-- atm <- banco
alter table atm
	add constraint atmBanco
		foreign key(fkBanco)
		references banco(idBanco);
        
-- cpu <- atm
alter table processador
	add constraint processadorAtm
		foreign key(fkAtm)
		references atm(idAtm);
        
-- ram <- atm
alter table memoria
	add constraint memoriaAtm
		foreign key(fkAtm)
        references atm(idAtm);
        
-- armazen <- atm
alter table disco
	add constraint discoAtm
		foreign key(fkAtm)
        references atm(idAtm);

-- Registro <- cpu/ram/disco
alter table registro
	add constraint registroProcessador
		foreign key (fkProcessador)
        references processador(idProcessador);

alter table registro
	add constraint registroMemoria
		foreign key (fkMemoria)
        references memoria(idMemoria);

alter table registro
	add constraint registroDisco
		foreign key (fkDisco)
        references disco(idDisco);

        
-- registroDispUsb <- dispositivoUsb/Registros
alter table registroDispositivoUsbConectado
	add constraint dispositivoUsbDispositivoConectado
		foreign key (fkDispositivoUsb)
		references dispositivoUsb(idDispositivoUsb);
        
alter table registroDispositivoUsbConectado
	add constraint dispositivoConectadoRegistro
		foreign key(fkRegistro)
        references registro(idRegistro);
        
        
-- alerta <- registroDispUsb
alter table alerta
	add constraint alertaRegistroUsbConectado
		foreign key (fkRegistroDispositivoUsbConectado)
        references registroDispositivoUsbConectado(idRegistroDispositivoUsbConectado);

-- inserindo dado na tabela Banco para testar aplicação Java        
insert into banco values
(null, 'Bradesco', 'Banco Bradesco S.A', '59456277000176');
insert into janela values
(null, 1, 'Curso: 2ADSA - Linguagem de Programação 2024/1');     
-- relatorio <- alerta/baseConhecimento
alter table relatorio
	add constraint relatorioAlerta
		foreign key (fkAlerta)
        references alerta(idAlerta);
        
alter table relatorio
	add constraint relatorioBaseConhecimento
		foreign key (fkBaseConhecimento)
        references baseConhecimento(idBaseConhecimento);



-- Atm
select * from atm;

-- processador
select * from processador;

-- memoria ram 
select * from memoria;

-- disco
select * from disco;

-- dispositivo usb
select * from dispositivoUsb;

-- registro
select * from registro;

-- registro usb
select * from registroDispositivoUsbConectado;
