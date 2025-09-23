## CRIAR BANCO DE DADOS

CREATE DATABASE controle_pendencias;
USE controle_pendencias;

##TABELA CATEGORIA

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

##TABELA PENDENCIAS

CREATE TABLE pendencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    categoria_id INT,
    prioridade ENUM('Baixa','Média','Alta') DEFAULT 'Média',
    status ENUM('Pendente','Em andamento','Concluída','Cancelada') DEFAULT 'Pendente',
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_entrega DATE,
    responsavel VARCHAR(100),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Exemplos de inserção na tabela categoria
INSERT INTO categoria (nome) VALUES 
('Pessoal'),
('Trabalho'),
('Estudos'),
('Urgente');

-- Exemplo de inserção na tabela pendencia
INSERT INTO pendencia (titulo, descricao, categoria_id, prioridade, status, data_entrega, responsavel) VALUES
('Finalizar relatório', 'Relatório anual para apresentação', 2, 'Alta', 'Pendente', '2025-09-30', 'João Silva'),
('Comprar material de escritório', 'Comprar papel, canetas e grampeador', 1, 'Média', 'Em andamento', '2025-09-25', 'Maria Lima');
