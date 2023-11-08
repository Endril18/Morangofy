package br.ufpb.dcx.morangofy.testes;

import br.ufpb.dcx.morangofy.model.Morangofy;
import br.ufpb.dcx.morangofy.model.Musica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class testesModel {
    private Morangofy morangofy;

    @BeforeEach
    public void setup() throws SQLException {
        // Inicializa o sistema Morangofy antes de cada teste
        morangofy = new Morangofy();

    }

    @Test
    public void testCadastroDeMusica() {
        // Realize o cadastro de uma música
        Long IdDisponivel =  Long.parseLong(String.valueOf(morangofy.musicasAdicionadas().size() + 1));

        Musica musica = new Musica(IdDisponivel , "Nome Música", "Banda", "Artista", "Album");
        morangofy.adicionarMusica(musica);

        // Verifique se a música foi cadastrada corretamente
        assertTrue(morangofy.contemMusica(musica.getId()));

        morangofy.apagarMusica(musica.getId());
    }

    @Test
    public void testRemocaoDeMusica() {

        Long IdDisponivel =  Long.parseLong(String.valueOf(morangofy.musicasAdicionadas().size() + 1));

        // Realize o cadastro de uma música
        Musica musica = new Musica(IdDisponivel, "Nome Música", "Banda", "Artista", "Album");
        morangofy.adicionarMusica(musica);
        assertTrue(morangofy.contemMusica(musica.getId()));


        // Remova a música
        morangofy.apagarMusica(musica.getId());

        // Verifique se a música foi removida corretamente
        assertFalse(morangofy.contemMusica(musica.getId()));
    }

    @Test
    public void testPesquisaMusicas() {

        Long IdDisponivel =  Long.parseLong(String.valueOf(morangofy.musicasAdicionadas().size() + 1));

        // Realize o cadastro de algumas músicas
        Musica musica = new Musica(IdDisponivel , "Música do Silvio", "Banda", "Artista", "Album");
        morangofy.adicionarMusica(musica);


        // Verifique se a música foi cadastrada corretamente
        assertTrue(morangofy.contemMusica(musica.getId()));

        // Realize uma pesquisa por nome de música
        Collection<Musica> resultadosNome = morangofy.pesquisaMusicas("Música do Silvio", "nome");


        // Verifique se a pesquisa por nome retornou a música correta
        assertEquals(1, resultadosNome.size());
        assertTrue(resultadosNome.contains(musica));

        // Realize uma pesquisa por nome do artista
        Collection<Musica> resultadosArtista = morangofy.pesquisaMusicas("Artista", "artista");

        // Verifique se a pesquisa por nome do artista retornou a música correta
        assertEquals(1, resultadosArtista.size());
        assertTrue(resultadosArtista.contains(musica));

        morangofy.apagarMusica(musica.getId());
    }
}

