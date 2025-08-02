package com.negocio.models;

// ERROR 1: Atributos públicos (Mala práctica de encapsulamiento)
public class Producto {
    private  int id;
    private  String nombre;
    private double precio;
    public int stock;
    private int cantidad;

    // Getters y setters
    public int getid ()
    {
        return id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public double getPrecio()
    {
        return precio;
    }
    public int getcantidad()
    {
        return cantidad;
    }

    // ERROR 2: Constructor sin validaciones
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock; // No valida si el stock es negativo
    }

    // ERROR 3: Método que permite stock negativo
    public void reducirStock(int cantidad) {
        this.stock = this.stock - cantidad; // No verifica si hay suficiente stock
    }

    // ERROR 4: Método con lógica incorrecta
    public boolean hayStock(int cantidad) {
        return stock >= cantidad; // Debería ser >= para permitir exactamente la cantidad
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
