package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;
import br.ufpb.dcx.morangofy.model.Musica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class AllMusicController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public AllMusicController(Morangofy morangofy, JFrame janela){
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Collection<Musica> musicas = morangofy.musicasAdicionadas();

        String stringTodasMusicas = "";
        for (Musica m : musicas) {
            stringTodasMusicas += "ID: " + m.getId()
                    + "\nNome: " + m.getNomeMusica()
                    + "\nBanda: " + m.getNomeBanda()
                    + "\nArtista(s): " + m.getNomeArtista()
                    + "\nÁlbum: " + m.getNomeAlbum()
                    + "\n----------------------\n";
        }
        JOptionPane.showMessageDialog(janelaPrincipal, "Músicas:\n" + stringTodasMusicas);
    }

}
