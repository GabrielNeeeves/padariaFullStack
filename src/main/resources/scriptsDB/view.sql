CREATE VIEW v_produtos AS
	SELECT 	p.id Cod_Produto, p.nome Produto, p.preco Preco, p.qtd Estoque,
	CASE
		WHEN p.status = 1 THEN 'Disponivel'
		WHEN p.status = 2 THEN 'Indisponivel'
	END AS Situacao
	FROM Produtos p
	
SELECT *
FROM v_produtos


--VIEW 'PEDIDOS'
CREATE VIEW v_pedidos AS
	SELECT 	pe.idPedido Cod_Pedido, pe.idProduto Cod_Produto, pe.qtdProduto Quantidade,
			pe.valor Valor_Unitario, pe.DATA DATA, (pe.qtdProduto*pe.valor) valor_total
	FROM pedidos pe;
	
SELECT *
FROM v_pedidos