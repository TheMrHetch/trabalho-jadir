CREATE DATABASE escola;
USE escola;
CREATE TABLE aluno(
	RGM int NOT NULL,
    nome VARCHAR(45),
    email VARCHAR(45),
    nascimento DATETIME,
    idade int(3),
    endereco VARCHAR(45),
    CONSTRAINT aluno_rgm PRIMARY KEY(RGM)
)
SELECT * FROM aluno