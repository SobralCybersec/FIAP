package com.dev.repository;

import com.dev.model.Categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoriaRepository {

    private static List<Categoria> categorias;

    static {
        categorias = new ArrayList<>();

        String[] nomes = {
                "Eletrônicos",
                "Celulares",
                "Livros",
                "Games"
        };

        Arrays.asList(nomes).forEach(CategoriaRepository::save);
    }

    public static Categoria save(String s) {
        Categoria c = new Categoria(s);
        if (!categorias.contains(c)) {
            c.setIdCategoria((long) categorias.size() + 1);
            categorias.add(c);
            return c;
        }

        return null;

    }

    public static List<Categoria> findAll() {
        return categorias;
    }

    public static Categoria findByIdCategoria(Long id) {
        return categorias.stream().filter(c -> c.getIdCategoria().equals(id)).findFirst().orElse(null);
    }

    public static Categoria save(Categoria c) {
        if (!categorias.contains(c)) {
            c.setIdCategoria((long) categorias.size() + 1);
            categorias.add(c);
            return c;
        }

        return null;
    }
}