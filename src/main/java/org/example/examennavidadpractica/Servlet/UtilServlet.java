package org.example.examennavidadpractica.Servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.example.examennavidadpractica.model.Pedido;


import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class UtilServlet {

    public static Optional<Pedido> validaPedido(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        //int socioID = -1;
        String total = null;
        Date fecha = null;
        int id_cliente = -1;
        int id_comercial = -1;
        try {

            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            Objects.requireNonNull(request.getParameter("cantidad"));
            //CONTRACT nonBlank..
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("cantidad").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            total = request.getParameter("cantidad");

            Integer total2 = Integer.parseInt(total);

            fecha = java.sql.Date.valueOf(request.getParameter("fecha"));

            id_cliente = Integer.parseInt(request.getParameter("id_cliente"));

            id_comercial = Integer.parseInt(request.getParameter("id_comercial"));

            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            //Objects.requireNonNull(request.getParameter("localidad"));
            Objects.requireNonNull(request.getParameter("cantidad"));
            //CONTRACT nonBlank
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|

           // localidad = request.getParameter("localidad");

            return Optional.of(new Pedido(-1, total2, fecha, id_cliente, id_comercial));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }
}

