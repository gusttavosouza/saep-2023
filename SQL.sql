CREATE TABLE Professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Turma (
    numero SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professor(id)
);

CREATE TABLE Atividade (
    numero SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_turma INT,
    FOREIGN KEY (id_turma) REFERENCES Turma(numero)
);
