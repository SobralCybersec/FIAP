package com.dev.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime dataDeCriacao;
    private Categoria categoria;



    public Product() {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setCategoria(categoria);
        this.setDataDeCriacao(dataDeCriacao);
    }

    // Getters
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public Categoria getCategoria() {return categoria;}
    public BigDecimal getPreco() {return preco;}
    public LocalDateTime getDataDeCriacao() {return dataDeCriacao;}


    // Setters
    public void setId(Long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setPreco(BigDecimal preco) {this.preco = preco;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    public void setDataDeCriacao(LocalDateTime  dataDeCriacao) {this.dataDeCriacao = dataDeCriacao;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
       return nome.equals(product.nome) && categoria.equals(product.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria);
    }



    @Override
    public String toString() {
        return getNome();
    }
}
