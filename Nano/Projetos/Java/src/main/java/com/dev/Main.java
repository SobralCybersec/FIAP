package com.dev;

import com.dev.model.Categoria;
import com.dev.model.Product;
import com.dev.repository.CategoriaRepository;
import com.dev.repository.ProductCollectionRepository;
import com.dev.view.CategoryView;
import com.dev.view.Options;
import com.dev.view.OptionsView;
import com.dev.view.ProductView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Options options = null;

        do {

            options = OptionsView.select();

            switch (options) {

                case CADASTRAR_CATEGORIA:
                    cadastrarCategoria();
                    break;

                case CADASTRAR_PRODUTO:
                    cadastrarProduto();
                    break;

                case ALTERAR_PRODUTO:
                    alterarProduto();
                    break;

                case CONSULTAR_PRODUTO_POR_ID:
                    consultarProdutoPorId();
                    break;

                case CONSULTAR_PRODUTO_POR_CATEGORIA:
                    consultarProdutoPorCategoria();
                    break;

                case ENCERRAR_SISTEMA:
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    break;
                case DELETAR_PRODUTO:
                    deletarProduto();
                    break;
            }

        } while (options != Options.ENCERRAR_SISTEMA);
    }

    private static void cadastrarCategoria(){
        CategoryView catView = new CategoryView();
        Categoria categoria = catView.form();
        CategoriaRepository.save(categoria);
        catView.sucesso(categoria);
    }

    private static void cadastrarProduto(){
        Product catView = new ProductView().form();
        ProductCollectionRepository.save(catView);
    }

    private static void alterarProduto(){
        Product catView = ProductView.select();
        ProductView.update(catView);
    }

    private static void consultarProdutoPorId() {

        Long id = 0L;

        do {

            try {

                id = Long.parseLong(
                        JOptionPane.showInputDialog(
                                "Informe o id do produto"
                        )
                );

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Id inválido!"
                );

            }

        } while (id <= 0);

        Product p = ProductCollectionRepository.findById(id);

        if (p != null) {

            ProductView.show(p);

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Produto não encontrado!"
            );

        }
    }

    private static void consultarProdutoPorCategoria() {

        Categoria categoria = CategoryView.select(null);

        List<Product> produtos =
                ProductCollectionRepository.findByCategoria(categoria);

        if (produtos.size() == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Não encontramos produtos cadastrados para a categoria "
                            + categoria.getNome()
            );

            return;
        }

        produtos.forEach(System.out::println);

        produtos.forEach(ProductView::show);
    }

    private static void deletarProduto() {

        Product produto = ProductView.select();

        if (produto == null) {
            return;
        }

        boolean removido =
                ProductCollectionRepository.delete(produto.getId());

        if (removido) {

            JOptionPane.showMessageDialog(
                    null,
                    "Produto removido com sucesso!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Produto não encontrado!"
            );
        }
    }
}