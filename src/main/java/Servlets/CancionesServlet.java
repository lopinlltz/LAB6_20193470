package Servlets;

import Beans.Canciones;
import Daos.CancionesDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesServlet",urlPatterns = {"/listaCanciones"})
public class CancionesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao cancionesDao = new CancionesDao();
        ArrayList<Canciones> listaCanciones = cancionesDao.listarCanciones();

        request.setAttribute("listaCanciones",listaCanciones);

        RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
        view.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "anadirFavoritos" : request.getParameter("a");
        CancionesDao cancionesDao = new CancionesDao();

        switch (action) {
            case "a": //anadir
                Canciones canciones = parseCanciones(request);
                cancionesDao.anadirFavoritos(canciones);

                response.sendRedirect(request.getContextPath() + "/CancionesServlet");
                break;
        }
    }

    public Canciones parseCanciones(HttpServletRequest request) {

        Canciones canciones = new Canciones();
        String idcancion_str = request.getParameter("idcancion") != null ? request.getParameter("idcancion") : "";
        String nombre_cancion = request.getParameter("nombre_cancion");
        String banda = request.getParameter("banda");
        String estadoFavorito_str = request.getParameter("estadoFavorito");

        try {
            int idcancion = Integer.parseInt(idcancion_str);
            boolean estadoFavorito = Boolean.parseBoolean(estadoFavorito_str);

            canciones.setIdcancion(idcancion);
            canciones.setNombre_cancion(nombre_cancion);
            canciones.setBanda(banda);
            canciones.setEstadoFavorito(estadoFavorito);

            return canciones;

        } catch (NumberFormatException e) {

        }
        return canciones;
    }
}
