package Servlets;

import Beans.Favoritos;
import Daos.FavoritosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FavoritosServlet",urlPatterns = {"/listaFavoritos"})
public class FavoritosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FavoritosDao favoritosDao = new FavoritosDao();
        ArrayList<Favoritos> listaFavoritos = favoritosDao.listarFavoritos();

        request.setAttribute("listaFavoritos",listaFavoritos);

        RequestDispatcher view =request.getRequestDispatcher("listaFavoritos.jsp");
        view.forward(request,response);

    }
}
