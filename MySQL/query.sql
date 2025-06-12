CREATE DATABASE fraudedecompras;
USE fraudedecompras;

CREATE TABLE transacoes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    distancia_de_casa FLOAT,
    distancia_da_ultima_transacao FLOAT,
    razao_preco_medio_compra FLOAT,
    repetiu_estabelecimento boolean,
    usou_chip boolean,
    usou_pin boolean,
    pedido_online boolean,
    fraude boolean
);

CREATE TABLE suspeitas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_transacao_original INT,
    distancia_de_casa FLOAT,
    distancia_da_ultima_transacao FLOAT,
    razao_preco_medio_compra FLOAT,
    repetiu_estabelecimento boolean,
    usou_chip boolean,
    usou_pin boolean,
    pedido_online boolean,
    suspeita_detectada boolean
);