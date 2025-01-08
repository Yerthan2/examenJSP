package org.example.examennavidadpractica.dao;

import org.example.examennavidadpractica.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDaoImpl extends AbstractDAOImpl implements ClienteDao {

    @Override
    public void create(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;



        try{


        conn = connectDB();
        //1 alternativas comentadas:
        //Ver también, AbstractDAOImpl.executeInsert ...
        //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
        ps = conn.prepareStatement("INSERT INTO cliente (nombre, apellido1, apellido2, ciudad, categoria) VALUES (?, ? , ?, ?)", Statement.RETURN_GENERATED_KEYS);

        int idx = 1;
        ps.setString(idx++, cliente.getNombre());
        ps.setString(idx++, cliente.getApellido());
        ps.setString(idx++, cliente.getApellido2());
        ps.setString(idx++, cliente.getCiudad());
        ps.setInt(idx++, cliente.getCategoria());

        int rows = ps.executeUpdate();
        if (rows == 0)
            System.out.println("INSERT de socio con 0 filas insertadas.");

        rsGenKeys = ps.getGeneratedKeys();
        if (rsGenKeys.next())
            cliente.setIdCliente(rsGenKeys.getInt(1));

    } catch (SQLException | ClassNotFoundException  e) {
        e.printStackTrace();
    } finally {
        closeDb(conn, ps, rs);
    }
    }

    @Override
    public List<Cliente> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try{
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setApellido2(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setCategoria(rs.getInt(6));
                clientes.add(cliente);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return clientes;
    }

    @Override
    public Optional<Cliente> find(int id) {



        return Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {


        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try{
            conn = connectDB();
            s = conn.prepareStatement("UPDATE cliente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(int id) {

    }


}
