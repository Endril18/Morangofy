package br.ufpb.dcx.morangofy;

import java.util.Objects;

public class MusicaMorangofy {
    private String idMusicaString;
    private String nomeMusica;
    private String nomeArtista;
    private String nomeBanda;
    private String nomeAlbum;

    public MusicaMorangofy(){
        this("", "", "", "", "");
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
    public int hashCode(){
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

    /**

     Obtém o nome da banda.
     @return o nome da banda
     */
    public String getNomeBanda(){
        return nomeBanda;
    }

    public void setNomeBanda(String nome){
        this.nomeBanda = nome;
    }

    /**

     Obtém o nome do álbum.
     @return o nome do álbum
     */
    public String getNomeAlbum(){
        return this.nomeAlbum;
    }

    /**

     Define o nome do álbum.
     @param nome o nome do álbum
     */
    public void setNomeAlbum(String nome) {
        this.nomeAlbum = nome;
    }

    /**

     Obtém o identificador da música.
     @return o identificador da música
     */
    public String getIdMusicaString(){
        return this.idMusicaString;
    }

    /**

     Define o identificador da música.
     @param id o identificador da música
     */
    public void setIdMusicaString(String id){
        this.idMusicaString = id;
    }
}
