<%--
  Created by IntelliJ IDEA.
  User: 34691
  Date: 08/01/2025
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Pedido</title>
</head>
<body>
<h1>Crear pedidos</h1>

<form method="post" action="CrearPedidoServlet">
    <label>Cantidad</label>
    <input name="cantidad" type="text">
    <label>Fecha que se realizo</label>
    <input type="date" name="fecha">
    <label>Cliente</label>
    <input type="number" name="id_cliente">
    <label>Comercial</label>
    <input type="number" name="id_comercial">
    <button type="submit">Enviar</button>

</form>


</body>
</html>
