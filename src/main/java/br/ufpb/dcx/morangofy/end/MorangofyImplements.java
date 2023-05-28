package br.ufpb.dcx.morangofy.end;

import java.util.ArrayList;
import java.util.List;

public class MorangofyImplements implements MorangofyInterface{

    private List<MusicaMorangofy> musicas;

    public MorangofyImplements() {
        this.musicas = new ArrayList<>();
    }

    public boolean existeMusica(String nomeMusica, String nomeBanda, String nomeAlbum) {
        for (MusicaMorangofy m : this.musicas){
            if(m.getNomeMusica().equals(nomeMusica) && m.getNomeBanda().equals(nomeBanda) && m.getNomeAlbum().equals(nomeAlbum)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionarMusica(String nomeMusica, String nomeBanda, String nomeAlbum) throws MusicaJaExisteException{
        if(this.existeMusica(nomeMusica, nomeBanda, nomeAlbum)) {
            throw new MusicaJaExisteException("Essa música já foi adicionada\n\n"+nomeMusica+"\n"+nomeBanda);
        } else {
            MusicaMorangofy novaMusica = new MusicaMorangofy(nomeMusica, nomeBanda, nomeAlbum);
            this.musicas.add(novaMusica);
        }
    }


    @Override
    public boolean apagarMusica(String nomeMusica, String nomeAutor, String nomeAlbum){
        return false;
    }


    @Override
    public List<MusicaMorangofy> musicasAdicionadas() {
        return this.musicas;
    }

    @Override
    public List<MusicaMorangofy> pesquisaMusicas(String nomeMusica, String nomeBanda, String nomeAlbum) {
        return null;
    }

    @Override
    public List<MusicaMorangofy> pesquisaPorAutor(String nomeAutor) {
        return null;
    }
}
