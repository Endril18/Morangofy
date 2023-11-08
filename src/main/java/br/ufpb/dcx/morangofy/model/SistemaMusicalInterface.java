package br.ufpb.dcx.morangofy.model;

import java.util.Collection;
import java.util.List;

public interface SistemaMusicalInterface {

    boolean adicionarMusica(Musica musica);

    Collection<Musica> pesquisaMusicas(String nome, String escolha);

    boolean apagarMusica(Long id);

    Collection<Musica> musicasAdicionadas();

    void renumerarIdsNoBanco();

    boolean contemMusica(Long id);

    boolean atualizaMusica(Long id, Musica musicaAtualizada);

    Musica pesquisaMusicaPorId(Long id);
}

