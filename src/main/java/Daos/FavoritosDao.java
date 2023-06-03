package Daos;

import Beans.Favoritos;

import java.sql.*;
import java.util.ArrayList;

public class FavoritosDao {
    public ArrayList<Favoritos> listarFavoritos() {
        ArrayList<Favoritos> listaFavoritos = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT idcancion as 'ID', nombre_cancion as 'NOMBRE', banda as 'BANDA' from cancion where estadoFavorito = 1";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Favoritos favoritos = new Favoritos();
                favoritos.setIdcancion(resultSet.getInt(1));
                favoritos.setNombre_cancion(resultSet.getString(2));
                favoritos.setBanda(resultSet.getString(3));
                //favoritos.setEstadoFavorito(resultSet.getBoolean(4));
                listaFavoritos.add(favoritos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaFavoritos;
    }
}
