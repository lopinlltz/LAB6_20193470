package Beans;

public class Canciones {
    private int idcancion;
    private String nombre_cancion;
    private String banda;
    private Boolean estadoFavorito;

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

    public Boolean getEstadoFavorito() {
        return estadoFavorito;
    }

    public void setEstadoFavorito(Boolean estadoFavorito) {
        this.estadoFavorito = estadoFavorito;
    }
}
