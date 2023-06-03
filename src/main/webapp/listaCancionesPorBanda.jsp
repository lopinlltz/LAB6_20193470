<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/06/2023
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Canciones"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Canciones>" scope="request" id="listaCancionesPorBanda"/>

<html>
  <jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones por Banda"/>
  </jsp:include>
  <body>
    <div class='container'>
      <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="canciones"/>
      </jsp:include>
      <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
          <h1 class='text-light'>Lista de Canciones Por Banda</h1>
          <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
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
            for ( Canciones cancionesPorBanda : listaCancionesPorBanda) {
          %>
          <tr>
            <td><%=cancionesPorBanda.getIdcancion()%>
            </td>
            <td><%=cancionesPorBanda.getNombre_cancion()%>
            </td>
            <td><%=cancionesPorBanda.getBanda()%>
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
