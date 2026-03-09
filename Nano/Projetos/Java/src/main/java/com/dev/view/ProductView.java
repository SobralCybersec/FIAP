package com.dev.view;

import com.dev.model.Categoria;
import com.dev.model.Product;
import com.dev.repository.ProductCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductView {

    public static Product select() {

        Product ret = (Product) JOptionPane.showInputDialog(
                null,
                "Selecione um produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProductCollectionRepository.findAll().toArray(),
                null
        );

        return ret;
    }

    public static Product form() {

        Categoria categoria = null;

        do {
            categoria = CategoryView.select(null);
        } while (categoria == null);

        String nome;

        do {
            nome = JOptionPane.showInputDialog("Nome do Produto");

            if (nome.length() < 3) {
                JOptionPane.showMessageDialog(null, "Nome mínimo 3 caracteres");
            }

        } while (nome.length() < 3);

        String descricao;

        do {

            descricao = JOptionPane.showInputDialog("Descrição");

            if (descricao.length() < 5) {
                JOptionPane.showMessageDialog(null, "Descrição mínima 5 caracteres");
            }

        } while (descricao.length() < 5);

        double p;

        do {

            try {

                p = Double.parseDouble(
                        JOptionPane.showInputDialog("Preço")
                );

            } catch (Exception e) {

                p = 0;

            }

            if (p <= 0) {
                JOptionPane.showMessageDialog(null, "Preço inválido");
            }

        } while (p <= 0);

        Product produto = new Product();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setCategoria(categoria);
        produto.setPreco(BigDecimal.valueOf(p));
        produto.setDataDeCriacao(LocalDateTime.now());

        return produto;
    }

    public static void update(Product produto) {

        Categoria categoria = null;

        do {
            categoria = CategoryView.select(produto.getCategoria());
        } while (categoria == null);

        produto.setCategoria(categoria);

        String nome;

        do {

            nome = JOptionPane.showInputDialog(
                    "Nome do Produto",
                    produto.getNome()
            );

            if (nome.length() < 3) {
                JOptionPane.showMessageDialog(null, "Nome mínimo 3 caracteres");
            }

        } while (nome.length() < 3);

        produto.setNome(nome);

        String descricao;

        do {

            descricao = JOptionPane.showInputDialog(
                    "Descrição",
                    produto.getDescricao()
            );

            if (descricao.length() < 5) {
                JOptionPane.showMessageDialog(null, "Descrição mínima 5 caracteres");
            }

        } while (descricao.length() < 5);

        produto.setDescricao(descricao);

        double p;

        do {

            try {

                p = Double.parseDouble(
                        JOptionPane.showInputDialog(
                                "Preço",
                                produto.getPreco()
                        )
                );

            } catch (Exception e) {

                p = 0;

            }

            if (p <= 0) {
                JOptionPane.showMessageDialog(null, "Preço inválido");
            }

        } while (p <= 0);

        produto.setPreco(BigDecimal.valueOf(p));

        success(produto);
        show(produto);
    }

    public static void success() {

        JOptionPane.showMessageDialog(
                null,
                "Produto salvo com sucesso!"
        );
    }

    public static void success(Product produto) {

        System.out.println(produto);

        JOptionPane.showMessageDialog(
                null,
                "Produto " + produto.getNome().toUpperCase() + " salvo com sucesso!"
        );
    }

    public static void show(Product p) {

        System.out.println(p);

        String produtoString = String.format(
                "PRODUTO: %s%sDESCRIÇÃO: %s%sCATEGORIA: %s%sPREÇO: %,.2f",
                p.getNome(),
                System.lineSeparator(),
                p.getDescricao(),
                System.lineSeparator(),
                p.getCategoria(),
                System.lineSeparator(),
                p.getPreco()
        );

        JOptionPane.showMessageDialog(
                null,
                produtoString
        );
    }
}