package br.ufpb.dcx.morangofy.end;

import java.util.List;

public interface SistemaMusicalInterface {

    void adicionarMusica(String idMusicaString, String nomeMusica, String nomeArtista, String nomeAlbum) throws MusicaJaExisteException;

    void carregaNovasMusicas(List<MusicaMorangofy> novasMusicas) throws MusicaJaExisteException;

    List<MusicaMorangofy> pesquisaMusicas(String nome);

    boolean verificaSeTemMusica();

    void apagarMusica(String idMusicaString);

    List<MusicaMorangofy> musicasAdicionadas();

    List<MusicaMorangofy> pesquisaPorArtista (String nomeAutor);
}

