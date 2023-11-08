package br.ufpb.dcx.morangofy.dao;

import br.ufpb.dcx.morangofy.infra.FabricaDeConexoes;
import br.ufpb.dcx.morangofy.model.Musica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusicaDAO implements MusicaInterfaceDAO{
    @Override
    public Musica save(Musica musica) {
        try (Connection connection = FabricaDeConexoes.getConnection()) {
            String sql = "INSERT INTO Musicas (id, nome, artista, banda, album) VALUES (?, ?, ?, ?, ?) RETURNING id";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, musica.getId());
            preparedStatement.setString(2, musica.getNomeMusica());
            preparedStatement.setString(3, musica.getNomeArtista());
            preparedStatement.setString(4, musica.getNomeBanda());
            preparedStatement.setString(5, musica.getNomeAlbum());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Long idMusica = resultSet.getLong("id");
                musica.setId(idMusica);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return musica;
    }



    @Override
    public Musica update(Musica musica) {
        try (Connection connection = FabricaDeConexoes.getConnection()) {
            String sql = "UPDATE Musicas SET nome = ?, artista = ?, banda = ?, album = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, musica.getNomeMusica());
            preparedStatement.setString(2, musica.getNomeArtista());
            preparedStatement.setString(3, musica.getNomeBanda());
            preparedStatement.setString(4, musica.getNomeAlbum());
            preparedStatement.setLong(5, musica.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected != 1) {
                throw new SQLException("Erro ao atualizar a música no banco de dados.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao executar a query SQL: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return musica;
    }


    @Override
    public boolean delete(Long id) {
        try (Connection connection = FabricaDeConexoes.getConnection()) {
            String sql = "DELETE FROM Musicas WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected != 1) {
                throw new SQLException("Erro ao excluir a música do banco de dados.");
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Musica> todasAsMusicas() {
        List<Musica> musicas = new ArrayList<>();

        try (Connection connection = FabricaDeConexoes.getConnection()) {
            String sql = "SELECT id, nome, artista, banda, album FROM Musicas";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nomeMusica = resultSet.getString("nome");
                String nomeArtista = resultSet.getString("artista");
                String nomeBanda = resultSet.getString("banda");
                String nomeAlbum = resultSet.getString("album");

                Musica musica = new Musica(id, nomeMusica, nomeArtista, nomeBanda, nomeAlbum);
                musicas.add(musica);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return musicas;
    }

    @Override
    public Optional<Musica> pesquisaMusicaID(Long id) {
        return Optional.empty();
    }

    @Override
    public void atualizarIdNoBanco(Long idAntigo, Musica musica) {
        // Primeiro, remova a música com o ID antigo
        delete(idAntigo);

        // Em seguida, insira a mesma música com o novo ID
        save(musica);
    }
}
