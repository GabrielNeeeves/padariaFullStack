CREATE TABLE PRODUTOS (
	id serial PRIMARY KEY,
	nome varchar(200) NOT NULL,
	preco decimal(10,2) NOT null,
	qtd int NOT null,
	status int NOT NULL,
	check(status IN(1,2,3))
)

SELECT *
FROM produtos


CREATE TABLE PEDIDOS (
	idPedido serial PRIMARY KEY,
	idProduto int NOT NULL,
	qtdProduto int NOT NULL check(qtdProduto > 0),
	valor decimal(10,2) NOT NULL check(valor > 0),
	DATA date NOT NULL,
	--DEFININDO FKs
	FOREIGN KEY (idProduto) REFERENCES produtos(id)
)

SELECT *
FROM PEDIDOS
