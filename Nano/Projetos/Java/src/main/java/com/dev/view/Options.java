package com.dev.view;

import java.util.Arrays;
import java.util.List;

public enum Options {
    CADASTRAR_CATEGORIA(1, "Cadastrar Categoria"),
    CADASTRAR_PRODUTO(2, "Cadastrar Produto"),
    ALTERAR_PRODUTO(3, "Alterar dados do Produto"),
    DELETAR_PRODUTO(4, "Deletar dados do Produto"),
    CONSULTAR_PRODUTO_POR_ID(5, "Consultar Produto por ID"),
    CONSULTAR_PRODUTO_POR_CATEGORIA(6, "Consultar Produto por Categoria"),
    ENCERRAR_SISTEMA(7, "Encerrar Sistema");

    private String nome;
    private int id;

    Options(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Options> getOptions()
    {
        return Arrays.asList(Options.values());
    }

    @Override
    public String toString()
    {
        return nome;
    }


}
