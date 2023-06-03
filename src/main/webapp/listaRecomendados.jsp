<%@ page import="Beans.Recomendados" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/06/2023
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Recomendados>" scope="request" id="listaRecomendados"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de recomendados"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="recomendados"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>Ver</th>
                    </thead>
                    <%
                        for (Recomendados recomendados : listaRecomendados) {
                    %>
                    <tr>
                        <td><%=recomendados.getIdcancion()%>
                        </td>
                        <td><%=recomendados.getNombre_cancion()%>
                        </td>
                        <td><%=recomendados.getBanda()%>
                        </td>
                        <td>
                            <a class="btn btn-primary" href="#" role="button">Más de la banda</a>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>