package br.ufpb.dcx.morangofy.end;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuardarMusicas {
    private String arquivoDeMusicas = "Músicas.dat";
    private GravarDados gravador;

    public GuardarMusicas() {
        this.gravador = new GravarDados();
    }

    public void guardaMusicas (List<MusicaMorangofy> musicas) throws IOException {
        List<String> musicaAGravar = new ArrayList<>();

        for(MusicaMorangofy m : musicas) {
            String linha = m.getNomeMusica()+" "+m.getNomeBanda()+" "+m.getNomeAlbum();
            musicaAGravar.add(linha);
        }
        this.gravador.gravaTextoEmArquivo(musicaAGravar, this.arquivoDeMusicas);
    }

    public List<MusicaMorangofy> recuperaMusicas() throws IOException {
        List<String> dadosDasMusicas = this.gravador.recuperaStringDeArquivo(this.arquivoDeMusicas);
        List<MusicaMorangofy> MusicaLista = new ArrayList<>();


        for(String s: dadosDasMusicas) {
            String [] dados = s.split(" ");
            MusicaMorangofy musicas = new MusicaMorangofy(dados[0], dados[1], dados[2]);
            MusicaLista.add(musicas);
        }

        return MusicaLista;
    }
}
