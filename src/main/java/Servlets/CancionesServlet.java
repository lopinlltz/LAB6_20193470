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

        String action = request.getParameter("a") == null ? "anadirFavoritos" : request.getParameter("a");

        switch (action) {
            case "a": //anadir
                //int idcancion = request.getParameter("1");
                //cancionesDao.anadirFavoritos(idcancion);
                response.sendRedirect(request.getContextPath() + "/CancionesServlet");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
