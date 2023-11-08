package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public LeaveController(Morangofy morangofy, JFrame janela) {
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}


