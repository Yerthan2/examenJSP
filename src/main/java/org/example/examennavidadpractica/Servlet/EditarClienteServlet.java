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

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditarClienteServlet", value = "/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {

    private ClienteDao clienteDao = new ClienteDaoImpl() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editarCliente.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}
