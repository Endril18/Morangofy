package br.ufpb.dcx.morangofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuardarMusicas {
    private String arquivoDeMusicas = "Músicas.txt";
    private GravarDados gravador;

    public GuardarMusicas() {
        this.gravador = new GravarDados();
    }

    public void guardaMusicas (List<MusicaMorangofy> musicas) throws IOException {
        List<String> musicaAGravar = new ArrayList<>();

        for(MusicaMorangofy m : musicas) {
            String linha = m.getIdMusicaString() +"###"+ m.getNomeMusica()+"###"+m.getNomeBanda()+"###"+m.getNomeArtista()+"###"+m.getNomeAlbum()+"\n";
            musicaAGravar.add(linha);
        }
        this.gravador.gravaTextoEmArquivo(musicaAGravar, this.arquivoDeMusicas);
    }

    public List<MusicaMorangofy> recuperaMusicas() throws IOException {
        List<String> dadosDasMusicas = this.gravador.recuperaStringDeArquivo(this.arquivoDeMusicas);
        List<MusicaMorangofy> MusicaLista = new ArrayList<>();


        for(String s: dadosDasMusicas) {
            String [] dados = s.split("###");
            System.out.println("+++>"+s);
            System.out.println("+++>"+dados.length);
            MusicaMorangofy musicas = new MusicaMorangofy(dados[0], dados[1], dados[2], dados[3], dados[4]);
            MusicaLista.add(musicas);
        }

        return MusicaLista;
    }
}
