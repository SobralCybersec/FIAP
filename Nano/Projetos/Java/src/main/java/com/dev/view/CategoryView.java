package com.dev.view;

import com.dev.model.Categoria;
import com.dev.repository.CategoriaRepository;

import javax.swing.*;

public class CategoryView {

    static CategoriaRepository categoriaRepository;

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma Categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categoriaRepository.findAll().toArray(),
                categoria == null ? 1: categoria);

            return ret;
    }

    public static Categoria form(){
        String nome = JOptionPane.showInputDialog("Digite o nome da Categoria");
        return  new Categoria(nome);
    }

    public void sucesso(){
        JOptionPane.showMessageDialog(null, "Sucesso!");
    }

    public void sucesso(Categoria categoria){
        System.out.println(categoria);
        JOptionPane.showMessageDialog(null, "Categoria: " + categoria.getNome() + "Salva com sucesso!");
    }

}
