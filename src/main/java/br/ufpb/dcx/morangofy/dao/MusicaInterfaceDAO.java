package br.ufpb.dcx.morangofy.dao;

import br.ufpb.dcx.morangofy.model.Musica;

import java.util.List;
import java.util.Optional;


public interface MusicaInterfaceDAO {

    Musica save(Musica musica);

    Musica update(Musica musica);

    boolean delete(Long id);

    List<Musica> todasAsMusicas();

    Optional<Musica> pesquisaMusicaID(Long id);

    void atualizarIdNoBanco(Long id, Musica musica);
}
