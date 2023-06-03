<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="playlists"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="playlists"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Playlists</h1>
                    <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaPlaylists">Mostrar playlists</a>
                    <a class="btn btn-warning" href="<%=request.getContextPath()%>/crearPlaylists">Crear playlist</a>
                </div>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>