package org.example.examennavidadpractica.Servlet;

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
import java.util.Optional;

@WebServlet(name= "ListarClientesServlet", value= "/ListarClientesServlet")
public class ListarClientesServlet extends HttpServlet {

    private ClienteDao clienteDao = new ClienteDaoImpl() ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoClienteB.jsp");

        List<Cliente> listado = this.clienteDao.getAll();

        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);


    }



}
