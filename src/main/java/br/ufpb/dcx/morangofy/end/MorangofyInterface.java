package br.ufpb.dcx.morangofy.end;

import java.util.List;
import java.util.ArrayList;

/**
 * Interface com as operações principais do sistema para gerenciar músicas.
 */

public interface MorangofyInterface {

    /**
     * Adiciona novas músicas no sistema.
     * @param nomeMusica O nome da música que vai ser cadastrada.
     * @param nomeBanda O nome da banda que vai ser cadastrada.
     * @param nomeAlbum O nome do Álbum da música que vai ser cadastrada.
     * @throws MusicaJaExisteException se já houver essa música, com mesmo nome
     * mesma banda, mesmo álbum.
     */
    void adicionarMusica(String nomeMusica, String nomeBanda, String nomeAlbum) throws MusicaJaExisteException;

    boolean apagarMusica(String nomeMusica, String nomeBanda, String nomeAlbum);

    /**
     * Retorna a lista com todas as músicas adicionadas.
     * @return a lista do tipo MuscaMorangofy
     */
    List<MusicaMorangofy> musicasAdicionadas();

    List<MusicaMorangofy> pesquisaMusicas(String nomeMusica, String nomeBanda, String nomeAlbum);

    List<MusicaMorangofy> pesquisaPorAutor (String nomeAutor);
}
