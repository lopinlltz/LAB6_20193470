package Daos;

import Beans.Canciones;

import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {
    public ArrayList<Canciones> listarCanciones() {
        ArrayList<Canciones> listaCanciones = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Canciones canciones = new Canciones();
                canciones.setIdcancion(resultSet.getInt(1));
                canciones.setNombre_cancion(resultSet.getString(2));
                canciones.setBanda(resultSet.getString(3));
                listaCanciones.add(canciones);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCanciones;
    }
}
