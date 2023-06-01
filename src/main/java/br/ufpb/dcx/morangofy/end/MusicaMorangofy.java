package br.ufpb.dcx.morangofy.end;

import java.util.Objects;

public class MusicaMorangofy {
    private String idMusicaString;
    private String nomeMusica;
    private String nomeBanda;
    private String nomeAlbum;

    public MusicaMorangofy(){
        this("", "", "", "");
    }

    public MusicaMorangofy(String idMusicaString, String nomeMusica, String nomeBanda, String nomeAlbum){
        this.idMusicaString = idMusicaString;
        this.nomeMusica = nomeMusica;
        this.nomeBanda = nomeBanda;
        this.nomeAlbum = nomeAlbum;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MusicaMorangofy that = (MusicaMorangofy) o;
        return nomeMusica.equals(that.nomeMusica) && nomeBanda.equals(that.nomeBanda) && nomeAlbum.equals(that.nomeAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMusica, nomeBanda, nomeAlbum);
    }

    public String getNomeMusica(){
        return this.nomeMusica;
    }

    public void setNomeMusica(String nome){
        this.nomeMusica = nome;
    }

    public String getNomeBanda(){
        return this.nomeBanda;
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
