package Daos;

import Beans.Recomendados;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadosDao {
    public ArrayList<Recomendados> listarRecomendados() {
        ArrayList<Recomendados> listaRecomendados = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select c.idcancion as 'ID', c.nombre_cancion as 'NOMBRE', c.banda as 'BANDA' from reproduccion r left join cancion c on(c.idcancion = r.cancion_idcancion) group by cancion_idcancion having count(*) >2 order by count(*) desc";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Recomendados recomendados = new Recomendados();
                recomendados.setIdcancion(resultSet.getInt(1));
                recomendados.setNombre_cancion(resultSet.getString(2));
                recomendados.setBanda(resultSet.getString(3));
                listaRecomendados.add(recomendados);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaRecomendados;
    }
}
