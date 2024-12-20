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
);

CREATE TABLE tbListaTelefone (
    idListaTelefone INT PRIMARY KEY AUTO_INCREMENT
    , numPrincipal VARCHAR (15)
    , idTelefone INT , FOREIGN KEY (idTelefone) REFERENCES tbTelefone(idTelefone)
    , idCliente INT , FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
);


CREATE TABLE tbProduto (
    idProduto INT PRIMARY KEY AUTO_INCREMENT
    , nomeProduto VARCHAR (60)
    , precoProduto FLOAT
    , quantidadeProduto INT 
    , idCategoria INT , FOREIGN KEY (idCategoria) REFERENCES tbCategoria (idCategoria)
);

CREATE TABLE tbPedido (
    idPedido INT PRIMARY KEY AUTO_INCREMENT
    , valorPedido FLOAT
    , dataPedido DATETIME
    , statusPedido VARCHAR (40)
);

CREATE TABLE tbCarrinho (
    idCarrinho INT PRIMARY KEY AUTO_INCREMENT
    , quantidadeProduto INT
    , idPedido INT , FOREIGN KEY (idPedido) REFERENCES tbPedido(idPedido)
);

CREATE TABLE tbItensCarrinho (
    idItensCarrinho INT PRIMARY KEY AUTO_INCREMENT
    , idCarrinho INT , FOREIGN KEY (idCarrinho ) REFERENCES tbCarrinho(idCarrinho)
    , idProduto INT , FOREIGN KEY (idProduto) REFERENCES tbProduto (idProduto)
)


