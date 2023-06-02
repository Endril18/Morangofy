package br.ufpb.dcx.morangofy.end;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaMorangofy {
    public static void main(String [] args){

        SistemaMusicalInterface sistema = new Morangofy();
        GuardarMusicas guardaMusicas = new GuardarMusicas();

        try {
            List<MusicaMorangofy> musicas = guardaMusicas.recuperaMusicas();
            sistema.carregaNovasMusicas(musicas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado no sistema!");
        } catch (MusicaJaExisteException e) {
            JOptionPane.showMessageDialog(null, "Nem todas as músicas puderam ser recuperadas. Verifique se alguma já existia");
            e.printStackTrace();
        }


        int escolha;
        do{
            // Mostrando as opções
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Morangofy\n\n[1] Adicionar Música\n[2] Procurar Música\n[3] Todas as Músicas\n[4] Apagar Música\n[5] Fechar\n\n"));
            List<MusicaMorangofy> musicas = sistema.musicasAdicionadas();
            switch (escolha) {
                case 1:
                    // Determinando identificador de cada música e passando para String
                    int idMusica = sistema.musicasAdicionadas().size() + 1;
                    String idMusicaString = String.valueOf(idMusica);

                    String nome = JOptionPane.showInputDialog("Qual é o nome da música?");
                    String banda = JOptionPane.showInputDialog("Qual é o nome da banda?");
                    String album = JOptionPane.showInputDialog("Qual é o nome do álbum?");

                    try {
                        sistema.adicionarMusica(idMusicaString, nome, banda, album);
                        JOptionPane.showMessageDialog(null, "Música adicionada com sucesso");
                    } catch (MusicaJaExisteException m) {
                        JOptionPane.showMessageDialog(null, "Não foi possível adicionar essa música, veja se essa música já está na lista");
                        m.printStackTrace();
                    }
                    break;
                case 2:
                    if (sistema.verificaSeTemMusica()) {
                        JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                    } else {
                        String nomePesquisa = JOptionPane.showInputDialog("Qual o nome da música?");
                        List<MusicaMorangofy> musicaPesquisada = sistema.pesquisaMusicas(nomePesquisa);;

                        if (musicaPesquisada.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhuma música encontrada com o nome informado.");
                        } else {
                            StringBuilder musicaPesquisadaString = new StringBuilder();
                            musicaPesquisadaString.append("Músicas: \n");
                            for (MusicaMorangofy musica : musicaPesquisada) {
                                musicaPesquisadaString
                                        .append(musica.getIdMusicaString()).append("º\n")
                                        .append("Nome: ").append(musica.getNomeMusica()).append("\n")
                                        .append("Banda: ").append(musica.getNomeArtista()).append("\n")
                                        .append("Álbum: ").append(musica.getNomeAlbum()).append("\n")
                                        .append("----------------------\n");
                            }
                            JOptionPane.showMessageDialog(null, musicaPesquisadaString.toString());
                        }
                    }
                    break;
                case 3:
                    if (sistema.verificaSeTemMusica()) {
                        JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                    } else {
                        // Passando para String
                        String stringTodasMusicas = "";
                        for (MusicaMorangofy m : musicas) {
                            stringTodasMusicas += m.getIdMusicaString()+"º\nNome : " + m.getNomeMusica() + "\nBanda: " + m.getNomeArtista() + "\nÁlbum: " + m.getNomeAlbum() + "\n ---------------------- \n";
                        }
                        JOptionPane.showMessageDialog(null, "Músicas: \n" + stringTodasMusicas);
                    }
                    break;
                case 4:
                    if (sistema.verificaSeTemMusica()) {
                        JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                    } else {
                        String id = JOptionPane.showInputDialog("Qual é a numeração da música?");
                        sistema.apagarMusica(id);
                    }
            }
        } while(escolha != 5);



        if (escolha == 5) {
            try{
                guardaMusicas.guardaMusicas(sistema.musicasAdicionadas());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível gravar as músicas :(");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Essa opção não é válida.");
        }
    }
}
