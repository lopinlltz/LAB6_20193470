package Daos;

import Beans.Canciones;

import java.sql.*;
import java.util.ArrayList;

public class CancionesPorBandaDao {
    public ArrayList<Canciones> listarCancionesPorBanda() {
        ArrayList<Canciones> listaCancionesPorBanda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion order by banda";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Canciones cancionesPorBanda = new Canciones();
                cancionesPorBanda.setIdcancion(resultSet.getInt(1));
                cancionesPorBanda.setNombre_cancion(resultSet.getString(2));
                cancionesPorBanda.setBanda(resultSet.getString(3));
                listaCancionesPorBanda.add(cancionesPorBanda);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCancionesPorBanda;
    }
}
