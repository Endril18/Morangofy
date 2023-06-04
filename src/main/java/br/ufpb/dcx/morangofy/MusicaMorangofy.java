package br.ufpb.dcx.morangofy;

import java.util.Objects;

public class MusicaMorangofy {
    private String idMusicaString;
    private String nomeMusica;
    private String nomeArtista;
    private String nomeBanda;
    private String nomeAlbum;

    public MusicaMorangofy(){
        this("", "s/t", "s/t", "s/t", "s/t");
    }

    public MusicaMorangofy(String idMusicaString, String nomeMusica, String nomeBanda, String nomeArtista, String nomeAlbum){
        this.idMusicaString = idMusicaString;
        this.nomeMusica = nomeMusica;
        this.nomeArtista = nomeArtista;
        this.nomeBanda = nomeBanda;
        this.nomeAlbum = nomeAlbum;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MusicaMorangofy that = (MusicaMorangofy) o;
        return nomeMusica.equalsIgnoreCase(that.nomeMusica) && nomeArtista.equalsIgnoreCase(that.nomeArtista) && nomeAlbum.equalsIgnoreCase(that.nomeAlbum) && nomeBanda.equalsIgnoreCase(that.nomeBanda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMusica, nomeArtista, nomeBanda, nomeAlbum);
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

    public String getNomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nome){
        this.nomeBanda = nome;
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
