<%@ page import="Beans.Canciones" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/06/2023
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Canciones>" scope="request" id="listaCanciones"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th></th>
                    </thead>
                    <%
                        for (Canciones canciones : listaCanciones) {
                    %>
                    <tr>
                        <td><%=canciones.getIdcancion()%>
                        </td>
                        <td><%=canciones.getNombre_cancion()%>
                        </td>
                        <td><%=canciones.getBanda()%>
                        </td>
                        <td>
                            <a> href="<%=request.getContextPath()%>/listaFavoritos">
                                <i class ="bi <%=(canciones.getEstadoFavorito() == 1)?"bi-heart heart-icon" : "bi-heart-fill heart-icon-liked"%>"data-toggle="tooltop" data-placement="top" title="Añadir a favoritos"></i>
                            </a>
                            <!--<a class="btn btn-warning" href="<%=request.getContextPath()%>/listaFavoritos">Añadir a favoritos</a>->
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
