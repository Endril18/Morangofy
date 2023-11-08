package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUsController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public AboutUsController(Morangofy morangofy, JFrame janela) {
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(janelaPrincipal,
                "Somos Endril Thiago, Isabelly Talita e Silvio Romero, alunos de LCC do campus IV \n" +
                        "da UFPB. Cursamos a disciplina de Programação Orientada a Objetos. \nEsse é o nosso trabalho" +
                        "de conclusão da disciplina.",
                "Sobre Nós",  // Título
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
