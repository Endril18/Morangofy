package br.ufpb.dcx.morangofy.end;

import java.util.Objects;

public class MusicaMorangofy {
    private String idMusicaString;
    private String nomeMusica;
    private String nomeArtista;
    private String nomeAlbum;

    public MusicaMorangofy(){
        this("", "", "", "");
    }

    public MusicaMorangofy(String idMusicaString, String nomeMusica, String nomeArtista, String nomeAlbum){
        this.idMusicaString = idMusicaString;
        this.nomeMusica = nomeMusica;
        this.nomeArtista = nomeArtista;
        this.nomeAlbum = nomeAlbum;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MusicaMorangofy that = (MusicaMorangofy) o;
        return nomeMusica.equals(that.nomeMusica) && nomeArtista.equals(that.nomeArtista) && nomeAlbum.equals(that.nomeAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMusica, nomeArtista, nomeAlbum);
    }

    public String getNomeMusica(){
        return this.nomeMusica;
    }

    public void setNomeMusica(String nome){
        this.nomeMusica = nome;
    }

    public String getNomeArtista(){
        return this.nomeArtista;
    }

    public void setNomeArtista(String nome){
        this.nomeArtista = nome;
    }

    public String getNomeAlbum(){ return this.nomeAlbum; }

    public void setNomeAlbum(String nome) { this.nomeAlbum = nome; }

    public String getIdMusicaString() {
        return this.idMusicaString;
    }

    public void setIdMusicaString(String id) {
        this.idMusicaString = id;
    }
}
