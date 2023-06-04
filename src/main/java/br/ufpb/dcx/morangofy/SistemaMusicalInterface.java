package br.ufpb.dcx.morangofy;

import java.util.List;

public interface SistemaMusicalInterface {

    void adicionarMusica(String idMusicaString, String nomeMusica, String nomeArtista, String nomeBanda, String nomeAlbum) throws MusicaJaExisteException;

    void carregaNovasMusicas(List<MusicaMorangofy> novasMusicas) throws MusicaJaExisteException;

    List<MusicaMorangofy> pesquisaMusicas(String nome, String escolha);

    boolean verificaSeTemMusica();

    void apagarMusica(String idMusicaString);

    List<MusicaMorangofy> musicasAdicionadas();
}
