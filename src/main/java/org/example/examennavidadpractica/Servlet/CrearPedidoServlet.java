package org.example.examennavidadpractica.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.examennavidadpractica.dao.PedidoDao;
import org.example.examennavidadpractica.dao.pedidoDaoImpl;
import org.example.examennavidadpractica.model.Pedido;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CrearPedidoServlet", value = "/CrearPedidoServlet")
public class CrearPedidoServlet extends HttpServlet {

    private PedidoDao pedidoDao = new pedidoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crearPedido.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = null;

        Optional<Pedido> optionalPedido = UtilServlet.validaPedido(request);

        if(optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();

            this.pedidoDao.create(pedido);

            List<Pedido> listado = this.pedidoDao.getAll();

            request.setAttribute("pedidos", listado);

            request.setAttribute("newPedidoID", pedido.getId());


            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoClienteB.jsp");
            requestDispatcher.forward(request, response);


        }else{
            System.out.println("<h2>No se encontro nada</h2>");
        }


    }


}
