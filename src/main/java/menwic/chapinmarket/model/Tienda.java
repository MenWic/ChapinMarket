/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.model;

public class Tienda {
    // Atributos

    private String sucursal;
    private String producto;
    private int cantidad;
    private int estante;

    // Constructor
    public Tienda(String sucursal, String producto, int cantidad, int estante) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estante = estante;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

}
