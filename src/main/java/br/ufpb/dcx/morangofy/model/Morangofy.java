package br.ufpb.dcx.morangofy.model;

import br.ufpb.dcx.morangofy.dao.MusicaDAO;
import java.util.*;

public class Morangofy implements SistemaMusicalInterface{

    private Map<Long, Musica> musicasMap;
    MusicaDAO musicaDAO = new MusicaDAO();

    public Morangofy() {
        this.musicasMap = new HashMap<>();
        carregarMusicasDoBancoDeDados();
    }

    private void renumerarIds() {
        Map<Long, Musica> novoMapa = new HashMap<>();

        long novoId = 1L;

        for (Musica m : musicasMap.values()) {
            m.setId(novoId); // Atualize o ID da música no mapa

            novoMapa.put(novoId, m); // Adicionando no mapa
            novoId++;
        }

        // Atualize o mapa musicasMap com o novo mapa renumerado
        musicasMap = novoMapa;

        renumerarIdsNoBanco();

        for (Musica m : musicasMap.values()){
            System.out.println(m.getId() + m.getNomeMusica());
        }
    }

    private void carregarMusicasDoBancoDeDados() {

        // Consulta o banco de dados para obter todas as músicas
        List<Musica> musicasDoBanco = musicaDAO.todasAsMusicas();

        // Preenche o mapa de músicas com as músicas do banco de dados
        for (Musica musica : musicasDoBanco) {
            musicasMap.put(musica.getId(), musica);
        }


    }

    public boolean adicionarMusica(Musica musica) {
        if (musica != null && !musicasMap.containsKey(musica.getId())) {
            musicasMap.put(musica.getId(), musica);

            musicaDAO.save(musica);

            return true;
        }
        return false; // A música já existe ou é inválida
    }

    public Collection<Musica> pesquisaMusicas(String nomeDado, String escolha) {
        Collection<Musica> resultados = new ArrayList<>();

        if(escolha.equals("nome")){
            for (Musica musica : musicasMap.values()) {
                if(musica.getNomeMusica().equalsIgnoreCase(nomeDado)){
                    resultados.add(musica);
                }
            }
        } else {
            for (Musica m : musicasMap.values()){
                if(m.getNomeArtista().equalsIgnoreCase(nomeDado)){
                    resultados.add(m);
                }
            }
        }
        return resultados;
    }

    public boolean apagarMusica(Long id) {
        // Remover a música do banco de dados
        boolean exclusaoNoBancoDeDadosBemSucedida = musicaDAO.delete(id);

        // Se a exclusão no banco de dados foi bem-sucedida, remover a música do mapa local
        if (exclusaoNoBancoDeDadosBemSucedida) {
            this.musicasMap.remove(id);

            // Renumerar os IDs
            renumerarIds();

            return true;
        } else {
            return false; // A exclusão não foi bem-sucedida
        }
    }

    public Collection<Musica> musicasAdicionadas() {
        return musicasMap.values();
    }

    public void renumerarIdsNoBanco() {
        for (Map.Entry<Long, Musica> entry : musicasMap.entrySet()) {
            Long id = entry.getKey();
            Musica musica = entry.getValue();
            musicaDAO.atualizarIdNoBanco(id, musica); // Atualiza o ID no banco de dados
        }
    }

    public boolean contemMusica(Long id) {
        return musicasMap.containsKey(id);
    }

    public boolean atualizaMusica(Long id, Musica musicaAtualizada) {
        if (musicasMap.containsKey(id)) {
            // Verifica se a música a ser atualizada é a mesma que está no mapa
            Musica musicaExistente = musicasMap.get(id);
            if (musicaExistente.equals(musicaAtualizada)) {
                return true; // A música não foi alterada
            }

            // Atualiza os dados da música no mapa local
            musicaExistente.setNomeMusica(musicaAtualizada.getNomeMusica());
            musicaExistente.setNomeArtista(musicaAtualizada.getNomeArtista());
            musicaExistente.setNomeBanda(musicaAtualizada.getNomeBanda());
            musicaExistente.setNomeAlbum(musicaAtualizada.getNomeAlbum());

            // Atualiza a música no banco de dados
            musicaDAO.update(musicaExistente);

            return true;
        }

        return false; // A música com o ID especificado não foi encontrada
    }


    public Musica pesquisaMusicaPorId(Long id) {
        if (musicasMap.containsKey(id)) {
            return musicasMap.get(id);
        } else {
            // Se a música não for encontrada no mapa local, realizar uma pesquisa no banco de dados
            Musica musica = musicaDAO.pesquisaMusicaID(id).orElse(null);
            if (musica != null) {
                musicasMap.put(id, musica); // Adiciona a música encontrada no mapa local
            }
            return musica;
        }
    }

}
