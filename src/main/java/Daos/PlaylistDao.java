package Daos;

import Beans.Playlists;
import java.sql.*;
public class PlaylistDao {
    public void crear(Playlists playlists) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "INSERT INTO playlists (idPlaylists,nombre_playlist, idcancion,nombre_cancion,banda) VALUES (?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, playlists.getIdPlaylist());
            pstmt.setString(2, playlists.getNombre_playlist());
            pstmt.setInt(3, playlists.getIdcancion());
            pstmt.setString(4, playlists.getNombre_cancion());
            pstmt.setString(5, playlists.getBanda());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
