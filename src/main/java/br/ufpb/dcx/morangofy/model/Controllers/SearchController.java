package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;
import br.ufpb.dcx.morangofy.model.Musica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class SearchController extends Component implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public SearchController(Morangofy morangofy, JFrame janela) {
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Pesquisar Músicas
        String opcaoDePesquisaStr = JOptionPane.showInputDialog(janelaPrincipal,
                "Deseja pesquisar pelo nome da música ou por artista?\n" +
                        "[1] Nome da Música\n" +
                        "[2] Nome do(s) Artista(s)");

        int opcaoDePesquisa = 0;

        try {
            if (opcaoDePesquisaStr != null && !opcaoDePesquisaStr.isEmpty()) {
                opcaoDePesquisa = Integer.parseInt(opcaoDePesquisaStr);
            }
        } catch (NumberFormatException c) {
            JOptionPane.showMessageDialog(this, "Opção inválida. Por favor, insira 1 ou 2 para selecionar uma opção válida.");
            return;
        }

        Collection<Musica> musicaPesquisada = new ArrayList<>();
        String nomeDeMusicas = "nome";
        String nomeDeArtistas = "artista";

        if (opcaoDePesquisa == 1) {
            String nomePesquisa = JOptionPane.showInputDialog(janelaPrincipal,"Informe o nome da música a ser pesquisada:");
            musicaPesquisada = morangofy.pesquisaMusicas(nomePesquisa, nomeDeMusicas);
        } else if (opcaoDePesquisa == 2) {
            String artistaPesquisa = JOptionPane.showInputDialog(janelaPrincipal,"Informe o nome do(s) artista(s) a ser pesquisado(s):");
            musicaPesquisada = morangofy.pesquisaMusicas(artistaPesquisa, nomeDeArtistas);
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Opção inválida. Por favor, insira 1 ou 2 para selecionar uma opção válida.");
            return;
        }

        if (musicaPesquisada.isEmpty()) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Nenhuma música encontrada com o que foi informado.");
        } else {
            StringBuilder musicaPesquisadaString = new StringBuilder("Músicas Encontradas: \n");
            for (Musica m : musicaPesquisada) {
                musicaPesquisadaString.append("ID: ").append(m.getId()).append("\n");
                musicaPesquisadaString.append("Nome: ").append(m.getNomeMusica()).append("\n");
                musicaPesquisadaString.append("Artista(s): ").append(m.getNomeArtista()).append("\n");
                musicaPesquisadaString.append("Banda: ").append(m.getNomeBanda()).append("\n");
                musicaPesquisadaString.append("Álbum: ").append(m.getNomeAlbum()).append("\n");
                musicaPesquisadaString.append("----------------------\n");
            }
            JOptionPane.showMessageDialog(janelaPrincipal, musicaPesquisadaString.toString());
        }
    }
}
