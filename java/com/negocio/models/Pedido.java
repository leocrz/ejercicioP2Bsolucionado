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

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
    }

    public int getid ()
    {
        return id;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    // ERROR 5: Cálculo incorrecto del total (suma precios sin considerar cantidades)
    private void calcularTotal() {
        total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getcantidad(); // Suma solo el precio, no considera cantidad
        }
    }

    // ERROR 6: Método que puede causar IndexOutOfBoundsException
    public Producto obtenerPrimerProducto() {
        // Verifica si la lista es null o está vacía
        if (productos == null || productos.isEmpty()) {
            return null;
        }
        // Si hay elementos, devuelve el primero
        return productos.get(0);
    }

    // ERROR 7: Descuento mal aplicado
    public double aplicarDescuento(double porcentaje) {
        // Aplica el descuento sumándolo en lugar de restándolo
        return total - (total * porcentaje / 100);
    }

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
    public LocalDateTime getFecha() { return fecha; }
    public double getTotal() { return total; }

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
