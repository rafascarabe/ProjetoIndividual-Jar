drop database if exists nuvent;
create database nuvent;

use nuvent;

-- Criação do usuario --

create user if not exists 'nuventUser'@'localhost' identified by 'nuvent';
grant all privileges on nuvent.* to 'nuventUser'@'localhost';
flush privileges;

-- TABELAS --

create table banco (
	id int primary key auto_increment,
    nomeFantasia varchar(45) not null,
    razaoSocial varchar(45) not null,
    cnpj char(14) unique not null
);

create table endereco(
	id int primary key auto_increment,
    logradouro varchar(255) not null,
    numero int not null,
    complemento varchar(255),
    cep char(8) not null,
    uf varchar(2),
    fkBanco int not null,
    constraint fkEnderecoBanco foreign key (fkBanco) references banco(id)
);

create table cargo(
	id int primary key auto_increment,
    nome varchar(50) not null
);

create table usuario(
	id int primary key auto_increment,
    nome varchar(255) not null,
    dtNasc date not null,
    cpf char(11) unique not null,
    email varchar(255) unique not null,
    senha varchar(50) not null,
    telefone varchar(16),
    fkCargo int not null,
    constraint fkUserCargo foreign key (fkCargo) references cargo(id),
    fkBanco int not null,
    constraint fkUserBanco foreign key (fkBanco) references banco(id)
);

create table atm (
	id int primary key auto_increment,
    nome varchar(50) not null,
    fkBanco int not null,
    constraint fkAtmBanco foreign key (fkBanco) references banco(id)
);

create table infraestruturaAtm (
	id int primary key auto_increment,
    sistemaOperacional varchar(30),
    arquitetura int,
    fkAtm int not null
);

create table processador(
	id int primary key auto_increment,
    nome varchar(100),
    modelo varchar(100),
    frequencia varchar(20),
	qtdProcessadorFisico int,
    qtdProcessadorLogico int,
    fkInfraAtm int not null,
    constraint fkProcessadorAtm foreign key (fkInfraAtm) references infraestruturaAtm(id)
);

create table memoria(
	id int primary key auto_increment,
    tamanhoTotal varchar(10),
    fkInfraAtm int not null,
    constraint fkMemoriaAtm foreign key (fkInfraAtm) references infraestruturaAtm(id)
);

create table disco(
	id int primary key auto_increment,
    modelo varchar(60),
    volume varchar(45),
    fkInfraAtm int not null,
    constraint fkDiscoAtm foreign key (fkInfraAtm) references infraestruturaAtm(id)
);

create table dispositivoUsb(
	id int primary key auto_increment,
    nome varchar(100),
    fkInfraAtm int not null,
    constraint fkUsbAtm foreign key (fkInfraAtm) references infraestruturaAtm(id)
);

create table registro(
	id int primary key auto_increment,
    qtdTotalProcessos int,
    porcentagemUsoProcessador varchar(10),
    qtdUsoMemoria varchar(10),
    qtdDisponivelMemoria varchar(10),
    porcentagemUsoMemoria varchar(10),
    qtdUsoDisco varchar(10),
    qtdDisponivelDisco varchar(10),
    porcentagemUsoDisco varchar(10),
    momentoRegistro datetime default current_timestamp,
    fkProcessador int not null,
    constraint fkRegistroProcessador foreign key (fkProcessador) references processador(id),
    fkMemoria int not null,
    constraint fkRegistroMemoria foreign key (fkMemoria) references memoria(id),
    fkDisco int not null,
    constraint fkRegistroDisco foreign key (fkDisco) references disco(id)
);

create table registroUsbConectado(
	id int primary key auto_increment,
    fkRegistro int,
    constraint fkUsbConectadoRegistro foreign key (fkRegistro) references registro(id),
    fkDispositivoUsb int,
    constraint fkUsbConectadoUsb foreign key (fkDispositivoUsb) references dispositivoUsb(id),
    conectado tinyint
);

create table alerta(
	id int primary key auto_increment,
    descricao varchar(255),
    dtAlerta datetime default current_timestamp,
    fkRegistroUsbConectado int,
    constraint fkAlertaUsbConectado foreign key (fkRegistroUsbConectado) references registroUsbConectado(id)
);

create table baseConhecimento(
	id int primary key auto_increment,
    codigoProblema varchar(100) not null,
    nomenclaturaProblema varchar(45) not null,
    descricaoProblema varchar(255) not null,
    propostaSolucao text not null,
    habilidadeNecessaria varchar(255),
    fkAlerta int, -- tornar not null novamente (tirei pra testar o  web-data-viz e aviso quando puder colocar novamente) - obs rafa :)
    constraint fkBaseAlerta foreign key (fkAlerta) references alerta(id)
);
-- teste de inserts
-- INSERT INTO baseConhecimento(codigoProblema, nomenclaturaProblema, descricaoProblema, propostaSolucao, habilidadeNecessaria) VALUES
-- select * from baseConhecimento where nomenclaturaProblema = ;

create table relatorio(
	id int primary key auto_increment,
    dtRelatorio datetime default current_timestamp,
    fkBase int not null,
    constraint fkRelatorioBase foreign key (fkBase) references baseConhecimento(id)
);
-- ------------------------- minhas alterações
CREATE TABLE janelas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    fkAtm INT,
    CONSTRAINT fkAtmJanela FOREIGN KEY (fkAtm) REFERENCES atm(id)
);
-- -----------------------------------
-- inserts prévios
insert into banco values
(null, 'Bradesco', 'Banco Bradesco S.A', '59456277000176');

insert into cargo values
	(null, 'Gerente'),
	(null, 'Suporte de TI'),
	(null, 'Equipe de Manutenção');
    
insert into atm values 
(null, 'Atm001', 1),
(null, 'Atm002', 1),
(null, 'Atm003', 1),
(null, 'Atm004', 1),
(null, 'Atm005', 1),
(null, 'Atm006', 1);
  
-- selects do Java
select * from infraestruturaAtm;
select * from processador;
select * from memoria;
select * from disco;
select * from dispositivoUsb;
select * from registro;
select * from registroUsbConectado;
select * from atm;
select * from janelas;