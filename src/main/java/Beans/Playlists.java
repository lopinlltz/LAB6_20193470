package Beans;

public class Playlists {
    private int idPlaylist;
    private String nombre_playlist;
    private int idcancion;
    private String nombre_cancion;
    private String banda;

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombre_playlist() {
        return nombre_playlist;
    }

    public void setNombre_playlist(String nombre_playlist) {
        this.nombre_playlist = nombre_playlist;
    }

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}
