package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public RemoveController(Morangofy morangofy, JFrame janela){
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Long id = Long.valueOf(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o ID da música que quer remover?"));

        boolean removeu = morangofy.apagarMusica(id);

        if(removeu){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Música apagada com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Música não encontrada. "+
                            "Operação não realizada.");
        }
    }
}

