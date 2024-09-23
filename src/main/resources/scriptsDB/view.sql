CREATE VIEW v_produtos AS
	SELECT 	p.id Cod_Produto, p.nome Produto, p.preco Preco, p.qtd Estoque,
	CASE
		WHEN p.status = 1 THEN 'Disponivel'
		WHEN p.status = 2 THEN 'Indisponivel'
	END AS Situacao
	FROM Produtos p
	
SELECT *
FROM v_produtos
