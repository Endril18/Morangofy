package br.ufpb.dcx.morangofy.end;

import java.util.ArrayList;
import java.util.List;

public class Morangofy implements SistemaMusicalInterface{

    private List<MusicaMorangofy> musicas;

    public Morangofy() {
        this.musicas = new ArrayList<>();
    }

    public boolean existeMusica(String nomeMusica, String nomeBanda, String nomeAlbum) {
        for (MusicaMorangofy m : this.musicas){
            if(m.getNomeMusica().equals(nomeMusica) && m.getNomeArtista().equals(nomeBanda) && m.getNomeAlbum().equals(nomeAlbum)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionarMusica(String idMusicaString, String nomeMusica, String nomeBanda, String nomeAlbum) throws MusicaJaExisteException{
        if(this.existeMusica(nomeMusica, nomeBanda, nomeAlbum)) {
            throw new MusicaJaExisteException("Essa música já foi adicionada\n\n"+nomeMusica+"\n"+nomeBanda);
        } else {
            MusicaMorangofy novaMusica = new MusicaMorangofy(idMusicaString, nomeMusica, nomeBanda, nomeAlbum);
            this.musicas.add(novaMusica);
        }
    }

    public void carregaNovasMusicas(List<MusicaMorangofy> novasMusicas) throws MusicaJaExisteException {
        for(MusicaMorangofy m : novasMusicas) {
            if(this.existeMusica(m.getNomeMusica(), m.getNomeArtista(), m.getNomeAlbum())) {
                throw new MusicaJaExisteException("A música "+ musicas.toString() +" já foi adicionada");
            } else {
                this.musicas.add(m);
            }
        }
    }

    @Override
    public List<MusicaMorangofy> pesquisaMusicas (String nomeMusica){
        List<MusicaMorangofy> dadoMusicaEncontrada = new ArrayList<>();

        for (MusicaMorangofy m: musicas) {
            if(m.getNomeMusica().equalsIgnoreCase(nomeMusica)){
                dadoMusicaEncontrada.add(m);
            }
        }
        return dadoMusicaEncontrada;
    }

    @Override
    public void apagarMusica(String id){
        int idNum = Integer.parseInt(id);
        musicas.remove(idNum - 1);
    }

    @Override
    public boolean verificaSeTemMusica(){
        if(musicas.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<MusicaMorangofy> musicasAdicionadas() {
        return this.musicas;
    }

    @Override
    public List<MusicaMorangofy> pesquisaPorArtista(String nomeAutor) {
        List<MusicaMorangofy> dadoMusicaEncontrada = new ArrayList<>();

        for (MusicaMorangofy m: musicas) {
            if(m.getNomeMusica().equalsIgnoreCase(nomeAutor)){
                dadoMusicaEncontrada.add(m);
            }
        }
        return dadoMusicaEncontrada;
    }
}
