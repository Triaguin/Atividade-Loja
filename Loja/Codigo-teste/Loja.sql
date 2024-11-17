CREATE DATABASE bdLojinha;

USE bdLojinha;

CREATE TABLE tbCategoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT
    , nomeCategoria VARCHAR (40)
);

CREATE TABLE tbCliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT
    , nomeCliente VARCHAR (60)
    , datanascCliente DATE
    , cpfCliente CHAR (11)
    , sexoCliente INT
    , logradouroCliente VARCHAR (40)
    , numLogradouroCliente INT
    , bairroCliente VARCHAR (60)
    , cidadeCliente VARCHAR (58)
);

CREATE TABLE tbTelefone (
    idTelefone INT PRIMARY KEY AUTO_INCREMENT
    , numTelefone VARCHAR (15)
    , idCliente INT , FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
);

CREATE TABLE tbEstoqueProduto ( 
    idEstoqueProduto INT PRIMARY KEY AUTO_INCREMENT
    , nomeEstoqueProduto VARCHAR (60)
    , quantidadeEstoqueProduto INT
    , idCategoria INT , FOREIGN KEY (idCategoria) REFERENCES tbCategoria(idCategoria)
);

CREATE TABLE tbProduto (
    idProduto INT PRIMARY KEY AUTO_INCREMENT
    , nomeProduto VARCHAR (60)
    , precoProduto FLOAT
    , quantidadeProduto INT;
    , idEstoqueProduto INT , FOREIGN KEY (idEstoqueProduto) REFERENCES tbEstoqueProduto(idEstoqueProduto)
);

CREATE TABLE tbPedido (
    idPedido INT PRIMARY KEY AUTO_INCREMENT
    , valorPedido FLOAT
    , dataPedido DATETIME
    , idCliente INT , FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
    , statusPedido VARCHAR (40)
);

CREATE TABLE tbCarrinho (
    idCarrinho INT PRIMARY KEY AUTO_INCREMENT
    , idProduto INT , FOREIGN KEY (idProduto) REFERENCES tbProduto(idProduto)
    , idPedido INT , FOREIGN KEY (idProduto) REFERENCES tbPedido(idPedido)
);


