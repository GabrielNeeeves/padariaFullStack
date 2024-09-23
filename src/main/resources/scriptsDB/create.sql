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