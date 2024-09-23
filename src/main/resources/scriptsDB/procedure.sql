CREATE PROCEDURE sp_createProduto (
	nomePr varchar(200),
	precoPr decimal(10,2),
	qtdPr int
)
LANGUAGE plpgsql
AS $$
BEGIN
	if precoPr <= 0 THEN
	RAISE EXCEPTION 'O preço deve ser maior que 0';
	end if;
	if qtdPr <= 0 THEN
	RAISE EXCEPTION 'A quantidade deve ser maior que 0';
	END if;
	
	INSERT INTO PRODUTOS (nome, preco, qtd, status) VALUES
	(nomePr, precoPr, qtdPr, 1);
END $$;

CALL sp_createProduto ('Bolo de cenoura', 15.00, 50)

SELECT *
FROM v_produtos
