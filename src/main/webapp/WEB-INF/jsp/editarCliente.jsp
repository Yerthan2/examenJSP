<%@ page import="org.example.examennavidadpractica.model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: 34691
  Date: 08/01/2025
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Cliente</title>
</head><body>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<div>

    <h3>FORMULARIO EDITAR CLIENTE</h3>

    <div>
        <div>
            <div>Actualiza los datos del cliente</div>
            <br>
        </div>
    </div>

    <form method="post" action="EditarClienteServlet">
        <input type="hidden" name="id" value="<%=cliente.getIdCliente()%>">
        <div>
            <div>Nombre</div>
            <div>
                <input type="text" name="nombre" value="<%=cliente.getNombre()%>"/>
            </div>
        </div>
        <div>
            <div>Apellido1</div>
            <div>
                <input type="text" name="apellido1" value="<%=cliente.getApellido()%>"/>
            </div>
        </div>
        <div>
            <div>Apellido2</div>
            <div>
                <input type="text" name="apellido2" value="<%=cliente.getApellido2()%>"/>
            </div>
        </div>
        <div>
            <div>Ciudad</div>
            <div>
                <input type="text" name="ciudad" value="<%=cliente.getCiudad()%>"/>
            </div>
        </div>
        <div>
            <div>Categoria</div>
            <div>
                <input type="text" name="categoria" value="<%=cliente.getCategoria()%>"/>
            </div>
        </div>

        <!-- Botón aceptar -->
        <div>
            <div>
                <form method="get" action="ListadoPedidos.jsp">
                    <input type="submit" value="Aceptar">
                </form>
            </div>
        </div>
    </form>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>

    <div>
        <div>
            <div>
                <strong>Error!</strong> <%=error%>
                <button type="button" data-bs-dismiss="alert"></button>
            </div>
        </div>
    </div>

    <%
        }
    %>

</div>
</body>
</html>
