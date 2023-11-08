package br.ufpb.dcx.morangofy.model.Controllers;

import br.ufpb.dcx.morangofy.model.Morangofy;
import br.ufpb.dcx.morangofy.model.Musica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class UpdateController implements ActionListener {
    private Morangofy morangofy;
    private JFrame janelaPrincipal;

    public UpdateController(Morangofy morangofy, JFrame janela) {
        this.morangofy = morangofy;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idMusicaStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe o ID da música:");
        if (idMusicaStr == null || idMusicaStr.isEmpty()) {
            JOptionPane.showMessageDialog(janelaPrincipal, "ID da música não informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Long idMusica = Long.parseLong(idMusicaStr);

            Musica musica = morangofy.pesquisaMusicaPorId(idMusica);

            if (musica != null) {
                String[] opcoes = { "Nome da Música", "Nome do Artista", "Banda", "Álbum" };

                int escolha = JOptionPane.showOptionDialog(janelaPrincipal, "Escolha o que você deseja editar:", "Editar Música",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha >= 0) {
                    String novoValor = JOptionPane.showInputDialog("Digite o novo valor:");
                    if (novoValor != null) { // O usuário pode cancelar o diálogo
                        switch (escolha) {
                            case 0:
                                musica.setNomeMusica(novoValor);
                                break;
                            case 1:
                                musica.setNomeArtista(novoValor);
                                break;
                            case 2:
                                musica.setNomeBanda(novoValor);
                                break;
                            case 3:
                                musica.setNomeAlbum(novoValor);
                                break;
                        }
                        morangofy.atualizaMusica(musica.getId(), musica);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Música atualizada com sucesso.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Música não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "ID da música inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
