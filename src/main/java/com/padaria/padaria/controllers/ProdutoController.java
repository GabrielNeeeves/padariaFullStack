package com.padaria.padaria.controllers;

import com.padaria.padaria.model.Produto;
import com.padaria.padaria.model.ProdutoDTO;
import com.padaria.padaria.repositories.ProdutoRepository;
import com.padaria.padaria.services.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService prodServ;

    //GET
    @GetMapping
    public ResponseEntity<List<Produto>> getProduto() {
        List<Produto> p = prodServ.buscarProdutos();
        return ResponseEntity.ok(p);
    }

    //GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        Optional<Produto> optProd = prodServ.findById(id);
        if(optProd.isPresent()) return ResponseEntity.ok(optProd.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //POST
    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO prodDto) {
        if(prodDto.getPrecoPr().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero");
        }
        if(prodDto.getQtdPr() <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        try {
            prodServ.criarProduto(prodDto.getNomePr(), prodDto.getPrecoPr(), prodDto.getQtdPr());
            return ResponseEntity.status(201).body("Produto cadastrado");
        } catch(Exception e) {
            throw new RuntimeException("Erro ao cadastrar produto: "+e.getMessage());
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            prodServ.deletarPorId(id);
            return ResponseEntity.ok().body("Produto deletado");
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Falha ao deletar produto");
        }

    }

    //UPDATE(PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateById(@PathVariable Long id, @RequestBody Produto nvProd) {
        try {
            Produto p = prodServ.updatePorId(id, nvProd);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
