<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 34691
  Date: 06/01/2025
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Listado de Clientes</h1>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ventas ","root", "secret");

    Statement s = conexion.createStatement();
    ResultSet listado = s.executeQuery("Select * from cliente");

    while (listado.next()) {
        out.println(listado.getString("id") + " " + listado.getString ("nombre") + listado.getString("apellido") + listado.getString("apellido2") + "<br>");
    }
    listado.close();
    s.close();
    conexion.close();
%>
</body>
</html>
