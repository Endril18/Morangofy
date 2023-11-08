package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;
import br.ufpb.dcx.morangofy.model.Musica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public AddController(Morangofy morangofy, JFrame janela){
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        // Determinando identificador de cada música
        Long idMusica = Long.valueOf(morangofy.musicasAdicionadas().size() + 1);

        String nome = JOptionPane.showInputDialog(this, "Qual é o nome da música?");
        String criacaoStr = (JOptionPane.showInputDialog(this, "[1] Banda\n[2] Artista"));
        int criacao = 0;
        if(criacaoStr != null && !criacaoStr.isEmpty()){
            criacao = Integer.parseInt(criacaoStr);
        }
        String banda = "";
        String nomeArtista = "";

        if (criacao == 1) {
            banda = JOptionPane.showInputDialog(this, "Qual é o nome da banda?");
        } else if (criacao == 2) {
            nomeArtista = JOptionPane.showInputDialog(this, "Qual é o nome do(s) artista(s)?");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Informe uma opção válida");
        }

        String album = JOptionPane.showInputDialog(this, "Qual é o nome do álbum?");


        if (!nome.isEmpty()) {

            if (banda == null || banda.isEmpty()) {
                banda = "S/D";
            }
            if (nomeArtista == null || nomeArtista.isEmpty()) {
                nomeArtista = "S/D";
            }
            if (album == null || album.isEmpty()) {
                album = "S/D";
            }

            Musica musica = new Musica(idMusica, nome, banda, nomeArtista, album);
            boolean cadastrou = morangofy.adicionarMusica(musica);

            if (cadastrou){
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Música adicionada");
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Música não foi adicionada. " +
                                "Verifique se já não existe");
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Preencha os campos corretamente");
        }
    }
}
