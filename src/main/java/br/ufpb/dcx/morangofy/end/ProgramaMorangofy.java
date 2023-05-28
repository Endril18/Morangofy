package br.ufpb.dcx.morangofy.end;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramaMorangofy {
    public static void main(String [] args){

        MorangofyInterface sistema = new MorangofyImplements();
        GuardarMusicas guardaMusicas = new GuardarMusicas();

        int escolha;
        do{
            // Mostrando as opções
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Morangofy\n\n[1] Adicionar Música\n[2] Procurar Música\n[3] Todas as Músicas\n[4] Apagar Música\n[5] Fechar\n\n"));

            switch (escolha) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Qual é o nome da música?");
                    String banda = JOptionPane.showInputDialog("Qual é o nome da banda?");
                    String album = JOptionPane.showInputDialog("Qual é o nome do álbum?");

                    try {
                        sistema.adicionarMusica(nome, banda, album);
                        JOptionPane.showMessageDialog(null, "Música adicionada com sucesso");
                    } catch (MusicaJaExisteException m) {
                        JOptionPane.showMessageDialog(null, "Não foi possível adicionar essa música, veja se essa música já está na lista");
                        m.printStackTrace();
                    }
                    break;
                case 2:
                    //pesquisaMusicas();
                    break;
                case 3:
                    List<MusicaMorangofy> musicas = sistema.musicasAdicionadas();
                    if (musicas.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Não há músicas adicionadas no sistema");
                    } else {
                        // Passando para String
                        String stringTodasMusicas = "";
                        for (MusicaMorangofy m : musicas) {
                            stringTodasMusicas += "\nNome : " + m.getNomeMusica() + "\nBanda: " + m.getNomeBanda() + "\nÁlbum: " + m.getNomeAlbum() + "\n ---------------------- \n";
                        }
                        JOptionPane.showMessageDialog(null, "Músicas: \n" + stringTodasMusicas);
                    }
                    }

        } while(escolha != 5);
    }
}
