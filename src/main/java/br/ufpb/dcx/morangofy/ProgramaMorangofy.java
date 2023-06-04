package br.ufpb.dcx.morangofy;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaMorangofy {
    public static void main(String [] args) {

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

        int escolha = 0;


        do {
            // Mostrando as opções
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Morangofy\n\n[1] Adicionar Música\n[2] Procurar Música\n[3] Todas as Músicas\n[4] Apagar Música\n[5] Salvar Dados\n[6] Fechar\n\n"));
            List<MusicaMorangofy> musicas = sistema.musicasAdicionadas();

            switch (escolha) {
                case 1:
                    // Determinando identificador de cada música e passando para String
                    int idMusica = sistema.musicasAdicionadas().size() + 1;
                    String idMusicaString = String.valueOf(idMusica);

                    String nome = JOptionPane.showInputDialog("Qual é o nome da música?");
                    int criacao = Integer.parseInt(JOptionPane.showInputDialog("[1] Banda\n[2] Artista"));
                    String banda = "";
                    String nomeArtista = "";

                    if (criacao == 1) {
                        banda = JOptionPane.showInputDialog("Qual é o nome da banda?");
                    } else if (criacao == 2) {
                        nomeArtista = JOptionPane.showInputDialog("Qual é o nome do(s) artista(s)?");
                    } else {
                        JOptionPane.showMessageDialog(null, "Informe uma opção válida");
                    }
                     String album = JOptionPane.showInputDialog("Qual é o nome do álbum?");

                    try {
                        if (nome.isEmpty() || banda.isEmpty() && nomeArtista.isEmpty() && album.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
                        } else {
                            sistema.adicionarMusica(idMusicaString, nome, banda, nomeArtista, album);
                            JOptionPane.showMessageDialog(null, "Música adicionada com sucesso");
                        }
                    } catch (MusicaJaExisteException m) {
                        JOptionPane.showMessageDialog(null, "Não foi possível adicionar essa música, veja se essa música já está na lista");
                        m.printStackTrace();
                    }
                    break;
                    case 2:
                        if (sistema.verificaSeTemMusica()) {
                            JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                        } else {
                            int opcaoDePesquisa = Integer.parseInt(JOptionPane.showInputDialog("Deseja pesquisar pelo nome da música ou por artista?\n[1] Nome da Música\n[2] Nome do(s) Artista(s)"));
                            List<MusicaMorangofy> musicaPesquisada = new ArrayList<>();
                            String nomeDeMusicas = "nome";
                            String nomeDeArtistas = "artista";


                            if (opcaoDePesquisa == 1) {
                                String nomePesquisa = JOptionPane.showInputDialog("Qual o nome da música?");
                                musicaPesquisada = sistema.pesquisaMusicas(nomePesquisa, nomeDeMusicas);
                            } else if (opcaoDePesquisa == 2) {
                                String artistaPesquisa = JOptionPane.showInputDialog("Qual o nome do(s) artista(s)?");
                                musicaPesquisada = sistema.pesquisaMusicas(artistaPesquisa, nomeDeArtistas);
                            } else {
                                JOptionPane.showMessageDialog(null, "Informe um valor válido");
                            }

                            if (musicaPesquisada.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhuma música encontrada com o nome informado.");
                            } else {
                                String musicaPesquisadaString = "Músicas: \n";
                                for (MusicaMorangofy m : musicaPesquisada) {
                                    musicaPesquisadaString += m.getIdMusicaString() + "º\n" + "Nome: " + m.getNomeMusica() + "\n" + "Banda: " + m.getNomeBanda() + "\n" + "Artista(s): " + m.getNomeArtista() + "\n" + "Álbum: " + m.getNomeAlbum() + "\n" + "----------------------\n";
                                }
                                JOptionPane.showMessageDialog(null, musicaPesquisadaString);
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

                                stringTodasMusicas += m.getIdMusicaString() + "º\nNome : " + m.getNomeMusica() + "\nBanda: " + m.getNomeBanda() + "\nArtista(s): " + m.getNomeArtista() + "\nÁlbum: " + m.getNomeAlbum() + "\n ---------------------- \n";
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

                    case 5:
                        if (sistema.verificaSeTemMusica()) {
                            JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                        } else {
                            try {
                                guardaMusicas.guardaMusicas(sistema.musicasAdicionadas());
                                JOptionPane.showMessageDialog(null, "Suas Músicas Foram Salvas!");
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "Não foi possível salvar as músicas :(");
                                e.printStackTrace();
                            }
                        }

            }
        } while (escolha != 6);
    }
}