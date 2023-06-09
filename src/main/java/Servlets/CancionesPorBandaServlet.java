package Servlets;

import Beans.Canciones;
import Daos.CancionesPorBandaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesPorBandaServlet",urlPatterns = {"/listaCancionesPorBanda"})
public class CancionesPorBandaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesPorBandaDao cancionesPorBandaDao = new CancionesPorBandaDao();
        ArrayList<Canciones> listaCancionesPorBanda = cancionesPorBandaDao.listarCancionesPorBanda();

        request.setAttribute("listaCancionesPorBanda",listaCancionesPorBanda);

        RequestDispatcher view =request.getRequestDispatcher("listaCancionesPorBanda.jsp");
        view.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

