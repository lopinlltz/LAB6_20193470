package Servlets;

import Beans.Recomendados;
import Daos.RecomendadosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecomendadosServlet",urlPatterns = {"/listaRecomendados"})
public class RecomendadosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendadosDao recomendadosDao = new RecomendadosDao();
        ArrayList<Recomendados> listaRecomendados = recomendadosDao.listarRecomendados();

        request.setAttribute("listaRecomendados",listaRecomendados);

        RequestDispatcher view =request.getRequestDispatcher("listaRecomendados.jsp");
        view.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
