package com.dev.repository;

import com.dev.model.Categoria;
import com.dev.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductCollectionRepository {

    private static ArrayList<Product> products = new ArrayList<>();

    private static Long sequence = 1L;

    static {

        Product kindleReader = new Product();
        kindleReader.setId(sequence++);
        kindleReader.setCategoria(CategoriaRepository.findByIdCategoria(1L));
        kindleReader.setNome("Kindle");
        kindleReader.setDescricao("Leitor de Livros Digitais");
        kindleReader.setDataDeCriacao(LocalDateTime.now());
        kindleReader.setPreco(BigDecimal.valueOf(225.2));

        Product iPhone = new Product();
        iPhone.setId(sequence++);
        iPhone.setCategoria(CategoriaRepository.findByIdCategoria(2L));
        iPhone.setNome("iPhone");
        iPhone.setDescricao("Smartphone Apple");
        iPhone.setDataDeCriacao(LocalDateTime.now());
        iPhone.setPreco(BigDecimal.valueOf(1200));

        Product iPhone2 = new Product();
        iPhone2.setId(sequence++);
        iPhone2.setCategoria(CategoriaRepository.findByIdCategoria(3L));
        iPhone2.setNome("iPhone2");
        iPhone2.setDescricao("Versão alternativa");
        iPhone2.setDataDeCriacao(LocalDateTime.now());
        iPhone2.setPreco(BigDecimal.valueOf(225.2));

        products.add(kindleReader);
        products.add(iPhone);
        products.add(iPhone2);
    }

    public static void save(Product produto) {

        produto.setId(sequence++);

        products.add(produto);
    }

    public static List<Product> findAll() {
        return products;
    }

    public static Product findById(Long id) {

        return products.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }

    public static List<Product> findByCategoria(Categoria categoria) {

        return products.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .toList();
    }

    public static boolean delete(Long id) {

        return products.removeIf(p -> id.equals(p.getId()));
    }
}