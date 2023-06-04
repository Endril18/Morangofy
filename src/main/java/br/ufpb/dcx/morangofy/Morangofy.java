package br.ufpb.dcx.morangofy;

import java.util.ArrayList;
import java.util.List;

public class Morangofy implements SistemaMusicalInterface {

    private List<MusicaMorangofy> musicas;

    public Morangofy() {
        this.musicas = new ArrayList<>();
    }

    public boolean existeMusica(String nomeMusica, String nomeBanda, String nomeArtista, String nomeAlbum) {
        for (MusicaMorangofy m : this.musicas) {
            if (m.getNomeMusica().equalsIgnoreCase(nomeMusica) && m.getNomeArtista().equalsIgnoreCase(nomeArtista) && m.getNomeAlbum().equalsIgnoreCase(nomeAlbum) && m.getNomeBanda().equalsIgnoreCase(nomeBanda)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionarMusica(String idMusicaString, String nomeMusica, String nomeBanda, String nomeArtista, String nomeAlbum) throws MusicaJaExisteException {
        if (this.existeMusica(nomeMusica, nomeBanda, nomeArtista, nomeAlbum)) {
            throw new MusicaJaExisteException("Essa música já foi adicionada\n\n" + nomeMusica + "\n" + nomeBanda);
        } else {
            MusicaMorangofy novaMusica = new MusicaMorangofy(idMusicaString, nomeMusica, nomeBanda, nomeArtista, nomeAlbum);
            this.musicas.add(novaMusica);
        }
    }

    public void carregaNovasMusicas(List<MusicaMorangofy> novasMusicas) throws MusicaJaExisteException {
        for (MusicaMorangofy m : novasMusicas) {
            if (this.existeMusica(m.getNomeMusica(), m.getNomeBanda(), m.getNomeArtista(), m.getNomeAlbum())) {
                throw new MusicaJaExisteException("A música " + musicas.toString() + " já foi adicionada");
            } else {
                this.musicas.add(m);
            }
        }
    }

    @Override
    public List<MusicaMorangofy> pesquisaMusicas(String nomeDado, String escolha) {
        List<MusicaMorangofy> dadoMusicaEncontrada = new ArrayList<>();

        if (escolha.equalsIgnoreCase("nome")) {
            for (MusicaMorangofy m : musicas) {
                if (m.getNomeMusica().equalsIgnoreCase(nomeDado)) {
                    dadoMusicaEncontrada.add(m);
                }
            }
        } else {
            for (MusicaMorangofy m : musicas) {
                if (m.getNomeArtista().equalsIgnoreCase(nomeDado)) {
                    dadoMusicaEncontrada.add(m);
                }
            }
        }
        return dadoMusicaEncontrada;
    }

    @Override
    public void apagarMusica(String id) {
        int idNum = Integer.parseInt(id);
        musicas.remove(idNum - 1);
    }

    @Override
    public boolean verificaSeTemMusica() {
        if (musicas.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<MusicaMorangofy> musicasAdicionadas() {
        return this.musicas;
    }
}
