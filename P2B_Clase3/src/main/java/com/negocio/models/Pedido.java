package com.negocio.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDateTime fecha;
    private double total;

    // Constructor
    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
    }

    // Devuelve el id del pedido
    public int getid() {
        return id;
    }

    // Agrega un producto y recalcula el total sin descuento
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    // Recalcula el total sumando precio * cantidad de cada producto
    private void calcularTotal() {
        total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getcantidad();
        }
    }

    // Aplica descuento sobre el total ya calculado y devuelve el resultado
    // No modifica el valor almacenado en total
    public double aplicarDescuento(double porcentaje) {
        return total - (total * porcentaje / 100);
    }

    // Devuelve el primer producto de la lista o null si no hay ninguno
    public Producto obtenerPrimerProducto() {
        if (productos == null || productos.isEmpty()) {
            return null;
        }
        return productos.get(0);
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", productos=" + productos.size() +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}