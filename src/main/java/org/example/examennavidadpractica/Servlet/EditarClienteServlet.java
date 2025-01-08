package org.example.examennavidadpractica.Servlet;


import com.sun.net.httpserver.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.examennavidadpractica.dao.ClienteDao;
import org.example.examennavidadpractica.dao.ClienteDaoImpl;
import org.example.examennavidadpractica.model.Cliente;

import java.io.IOException;
import java.util.List;

@WebServlet(name= "EditarClienteServlet", value= "/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {

    private ClienteDao clienteDao = new ClienteDaoImpl() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("editarCliente.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;
        String idUsuario = request.getParameter("idUsuario");

        if(!idUsuario.equals("")){
            System.out.println("<h2>Vamos a editar al usuario " + idUsuario + "</h2>");
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String ciudad = request.getParameter("ciudad");
            Integer categoria = Integer.valueOf(request.getParameter("categoria"));

            Cliente cliente = new Cliente();

        }
    }

}
