package com.padaria.padaria.services;

import com.padaria.padaria.model.Produto;
import com.padaria.padaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService{

    @Autowired
    private ProdutoRepository prodRepo;

    //buscarProdutos
    public List<Produto> buscarProdutos() {
        return prodRepo.findAll();
    }

    //buscarPorId
    public Optional<Produto> findById(Long id) {
        return prodRepo.findById(id);
    }

    //criar produto pela procedure do 'ProdutoRepository'
    public void criarProduto(String nomePr, BigDecimal precoPr, Integer qtdPr) {
        prodRepo.criarProduto(nomePr, precoPr, qtdPr);
    }

    //deletar por id
    public void deletarPorId(Long id) {
        prodRepo.deleteById(id);
    }

    //update por id
    public Produto updatePorId(Long id, Produto nvProd) {
        nvProd.setId(id);
        return prodRepo.save(nvProd);
    }
}
