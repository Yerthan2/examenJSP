package org.example.examennavidadpractica.dao;

import org.example.examennavidadpractica.model.Cliente;
import org.example.examennavidadpractica.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.examennavidadpractica.dao.AbstractDAOImpl.closeDb;
import static org.example.examennavidadpractica.dao.AbstractDAOImpl.connectDB;

public class pedidoDaoImpl extends AbstractDAOPedidoImpl implements PedidoDao{


    @Override
    public void create(Pedido pedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try{

            conn = connectDB();
            //1 alternativas comentadas:
            //Ver también, AbstractDAOImpl.executeInsert ...
            //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
            ps = conn.prepareStatement("INSERT INTO pedido (total, fecha, id_cliente, id_comercial) VALUES (?, ? , ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setDouble(idx++, pedido.getTotal());
            ps.setDate(idx++, pedido.getFecha());
            ps.setInt(idx++, pedido.getIdCliente());
            ps.setInt(idx++, pedido.getIdComercial());


            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de pedido con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                pedido.setIdCliente(rsGenKeys.getInt(1));

        } catch (SQLException | ClassNotFoundException  e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pedido> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Pedido> pedidos = new ArrayList<>();

        try{
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM pedido");
            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setId(rs.getInt(1));
                pedido.setTotal(rs.getDouble(2));
                pedido.setFecha(rs.getDate(3));
                pedido.setIdCliente(rs.getInt(4));
                pedido.setIdComercial(rs.getInt(5));
                pedidos.add(pedido);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return pedidos;
    }

    @Override
    public Optional<Pedido> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void delete(int id) {

    }
}
