<%@ page import="Beans.Favoritos" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/06/2023
  Time: 01:12
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean type="java.util.ArrayList<Beans.Favoritos>" scope="request" id="listaFavoritos"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Favoritos"/>
  </jsp:include>
  <body>
    <div class='container'>
      <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="favoritos"/>
      </jsp:include>
      <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
          <h1 class='text-light'>Canciones Favoritas</h1>
        </div>
      </div>
      <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
          <thead>
            <th>ID</th>
            <th>CANCION</th>
            <th>BANDA</th>
          </thead>
          <%
            for (Favoritos favoritos : listaFavoritos) {
          %>
          <tr>
            <td><%=favoritos.getIdcancion()%>
            </td>
            <td><%=favoritos.getNombre_cancion()%>
            </td>
            <td><%=favoritos.getBanda()%>
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
