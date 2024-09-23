package com.padaria.padaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    private String nomePr;
    private BigDecimal precoPr;
    private Integer qtdPr;

    public String getNomePr() {
        return nomePr;
    }

    public void setNomePr(String nomePr) {
        this.nomePr = nomePr;
    }

    public BigDecimal getPrecoPr() {
        return precoPr;
    }

    public void setPrecoPr(BigDecimal precoPr) {
        this.precoPr = precoPr;
    }

    public Integer getQtdPr() {
        return qtdPr;
    }

    public void setQtdPr(Integer qtdPr) {
        this.qtdPr = qtdPr;
    }
}
