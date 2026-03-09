package com.dev.model;


import java.util.Objects;

public class Categoria {
    Long IdCategoria;
    String nome;

    public Categoria(String nome) {
        this.setNome(nome);
    }

    // Getters
    public Long getIdCategoria() { return IdCategoria; }
    public String getNome() { return nome; }

    // Setters
    public void setIdCategoria(Long IdCategoria) { this.IdCategoria = IdCategoria; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getNome(), ((Categoria) o).getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, IdCategoria);
    }
}
