package br.ufpb.dcx.morangofy.model;

import java.util.Objects;

public class Musica {
    private Long id;
    private String nomeMusica;
    private String nomeArtista;
    private String nomeBanda;
    private String nomeAlbum;

    public Musica() {
        this(1L, "", "", "", "");
    }

    public Musica(Long id, String nomeMusica, String nomeBanda, String nomeArtista, String nomeAlbum) {
        this.id = id;
        this.nomeMusica = nomeMusica;
        this.nomeArtista = nomeArtista;
        this.nomeBanda = nomeBanda;
        this.nomeAlbum = nomeAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica that = (Musica) o;
        return nomeMusica.equalsIgnoreCase(that.nomeMusica) && nomeArtista.equalsIgnoreCase(that.nomeArtista) && nomeAlbum.equalsIgnoreCase(that.nomeAlbum) && nomeBanda.equalsIgnoreCase(that.nomeBanda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMusica, nomeArtista, nomeBanda, nomeAlbum);
    }

    public String getNomeMusica() {
        return this.nomeMusica;
    }

    public void setNomeMusica(String nome) {
        this.nomeMusica = nome;
    }

    public String getNomeArtista() {
        return this.nomeArtista;
    }

    public void setNomeArtista(String nome) {
        this.nomeArtista = nome;
    }

    /**
     * Obtém o nome da banda.
     *
     * @return o nome da banda
     */
    public String getNomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nome) {
        this.nomeBanda = nome;
    }

    /**
     * Obtém o nome do álbum.
     *
     * @return o nome do álbum
     */
    public String getNomeAlbum() {
        return this.nomeAlbum;
    }

    /**
     * Define o nome do álbum.
     *
     * @param nome o nome do álbum
     */
    public void setNomeAlbum(String nome) {
        this.nomeAlbum = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
