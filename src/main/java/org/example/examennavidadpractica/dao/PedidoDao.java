package org.example.examennavidadpractica.dao;

import org.example.examennavidadpractica.model.Cliente;
import org.example.examennavidadpractica.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDao {

    public void create(Pedido pedido);

    public List<Pedido> getAll();
    public Optional<Pedido> find(int id);

    public void update(Pedido pedido);

    public void delete(int id);

}
