package org.example.examennavidadpractica.model;

import java.util.Date;

public class Pedido {
    
    
    private Integer id;
    private double total;
    private Date fecha;
    private Integer idCliente;
    private Integer idComercial;

    public Pedido() {
    }

    public Pedido(Integer id, double total, Date fecha, Integer idCliente, Integer idComercial) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idComercial = idComercial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public java.sql.Date getFecha() {
        return (java.sql.Date) fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Integer idComercial) {
        this.idComercial = idComercial;
    }



    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", total=" + total +
                ", fecha=" + fecha +
                ", idCliente=" + idCliente +
                ", idComercial=" + idComercial +
                '}';
    }
}
