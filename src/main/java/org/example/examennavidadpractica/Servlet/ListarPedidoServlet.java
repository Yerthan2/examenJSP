package org.example.examennavidadpractica.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.examennavidadpractica.dao.ClienteDaoImpl;
import org.example.examennavidadpractica.dao.PedidoDao;

import org.example.examennavidadpractica.dao.pedidoDaoImpl;
import org.example.examennavidadpractica.model.Cliente;
import org.example.examennavidadpractica.model.Pedido;

import java.io.IOException;
import java.util.List;

@WebServlet(name= "ListarPedidoServlet", value= "/ListarPedidoServlet")
public class ListarPedidoServlet  extends HttpServlet {

    private PedidoDao clienteDao = new pedidoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoClienteB.jsp");

        List<Pedido> listado = this.clienteDao.getAll();

        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);


    }
}
