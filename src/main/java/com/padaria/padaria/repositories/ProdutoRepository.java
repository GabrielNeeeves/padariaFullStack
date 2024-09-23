package com.padaria.padaria.repositories;

import com.padaria.padaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //criar produto
    @Procedure(procedureName = "sp_createProduto")
    void criarProduto(
            @Param("nomePr") String nomePr,
            @Param("precoPr") BigDecimal precoPr,
            @Param("qtdPr") Integer qtdPr
    );


}
