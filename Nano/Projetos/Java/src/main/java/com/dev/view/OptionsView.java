package com.dev.view;

import javax.swing.*;

public class OptionsView {
    public static Options select(){
        Options ret = (Options) JOptionPane.showInputDialog(
                null,
                "Selecione Uma Opção",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options.values(),
                Options.CADASTRAR_PRODUTO);

            return ret != null ? ret: Options.ENCERRAR_SISTEMA;
    }
}
