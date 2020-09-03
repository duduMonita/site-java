CREATE TABLE tb_setores(
id_setor 	INTEGER,
nm_setor 	VARCHAR(30) NOT NULL,
CONSTRAINT pk_tb_setores_id_setor PRIMARY KEY(id_setor));

CREATE TABLE tb_local_fisico(
id_local_fisico INTEGER,
nm_local_fisico VARCHAR(30) NOT NULL,
CONSTRAINT pk_tb_local_fisico_id_local_fisico PRIMARY KEY (id_local_fisico));

CREATE TABLE tb_alergia(
id_alergia	INTEGER,
descr_alergia	VARCHAR(80),
CONSTRAINT pk_tb_alergia_id_alergia PRIMARY KEY (id_alergia));

CREATE TABLE tb_pessoa(
id_pessoa 	INTEGER,
nome 		VARCHAR(80) NOT NULL,
cpf 		VARCHAR(14) NOT NULL,
rg 		VARCHAR(13) NOT NULL,
nome_mae 	VARCHAR(80) NOT NULL,
endereco 	VARCHAR(60) NOT NULL,
numero 		INTEGER,
cep 		VARCHAR(11),
complemento 	VARCHAR(100),
cidade 		VARCHAR(20) NOT NULL,
bairro 		VARCHAR(20) ,
dt_nascimento 	DATE NOT NULL,
sexo 		VARCHAR(10) NOT NULL,
naturalidade 	VARCHAR(20) NOT NULL,
telefone 	VARCHAR(10),
CONSTRAINT pk_tb_pessoa_id_pessoa PRIMARY KEY(id_pessoa));

CREATE TABLE tb_paciente(
id_paciente	INTEGER,
tel_emergencia  VARCHAR(18),
CONSTRAINT pk_tb_paciente_id_paciente PRIMARY KEY (id_paciente));

CREATE TABLE tb_medico(
id_medico 	INTEGER,
id_pessoa	INTEGER,
crm 		VARCHAR(10) NOT NULL,
CONSTRAINT pk_tb_medico_id_medico PRIMARY KEY (id_medico),
CONSTRAINT fk_tb_pessoa_id_pessoa FOREIGN KEY (id_pessoa)
	REFERENCES tb_pessoa(id_pessoa));

CREATE TABLE tb_paciente_alergia(
id_paciente 	INTEGER,
id_alergia 	INTEGER,
nivel_alergia   INTEGER,
CONSTRAINT pk_tb_paciente_alergia_id_paciente PRIMARY KEY (id_paciente, id_alergia),
CONSTRAINT fk_tb_paciente_id_paciente FOREIGN KEY (id_paciente)
	REFERENCES tb_paciente(id_paciente),
CONSTRAINT fk_tb_alergia_id_alergia FOREIGN KEY (id_alergia)
	REFERENCES tb_alergia(id_alergia));

CREATE TABLE tb_prontuario(
id_prontuario 	INTEGER,
id_medico 	INTEGER NOT NULL,
id_paciente 	INTEGER NOT NULL,
observacao 	VARCHAR(250),
situacao 	BOOLEAN NOT NULL,
dt_consulta 	DATE NOT NULL,
id_local_fisico INTEGER NOT NULL,
receita 	VARCHAR(200),
CONSTRAINT pk_tb_prontuario_id_prontuario PRIMARY KEY (id_prontuario),
CONSTRAINT fk_tb_medico_id_medico FOREIGN KEY (id_medico) 
	REFERENCES tb_medico(id_medico),
CONSTRAINT fk_tb_paciente_id_paciente FOREIGN KEY (id_paciente) 
	REFERENCES tb_paciente(id_paciente),
CONSTRAINT fk_tb_local_fisico_id_local_fisico FOREIGN KEY (id_local_fisico) 
	REFERENCES tb_local_fisico(id_local_fisico));

CREATE TABLE tb_usuario(
id_usuario 	INTEGER,
id_setor 	INTEGER NOT NULL,
id_pessoa       INTEGER NOT NULL,
login 		VARCHAR(10) NOT NULL UNIQUE,
senha 		VARCHAR(15) NOT NULL,
CONSTRAINT pk_tb_usuario_id_usuario PRIMARY KEY (id_usuario),
CONSTRAINT fk_tb_setor_setor FOREIGN KEY (id_setor) 
	REFERENCES tb_setores(id_setor),
CONSTRAINT fk_tb_pessoa_id_pessoa FOREIGN KEY (id_pessoa)
	REFERENCES tb_pessoa(id_pessoa));

/* Select das Tabelas */
SELECT * FROM tb_usuario;
SELECT * FROM tb_medico;
SELECT * FROM tb_paciente;
SELECT * FROM tb_prontuario;
SELECT * FROM tb_pessoa;
SELECT * 
FROM tb_setores
ORDER BY 1;

INSERT INTO tb_usuario
VALUES
(1,5,1,'monita','1234');

INSERT INTO tb_pessoa
VALUES
(1,'eduardo','1234','1234','Rejane','Rua Magda Perona Frossard',750,'14401375','22','Ribeirão Preto','Nova Aliança','24/06/2000','M','Brasileiro','991536813');

