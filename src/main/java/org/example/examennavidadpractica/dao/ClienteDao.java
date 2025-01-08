package org.example.examennavidadpractica.dao;

import org.example.examennavidadpractica.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDao {

    public void create(Cliente Cliente);

    public List<Cliente> getAll();
    public Optional<Cliente> find(int id);

    public void update(Cliente cliente);

    public void delete(int id);
}
