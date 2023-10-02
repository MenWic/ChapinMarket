/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.controllers;

import java.util.ArrayList;

import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.model.Tienda;
import menwic.chapinmarket.queries.InventarioQueries;

public class InventarioController {

    private InventarioQueries inventarioQueries;

    public InventarioController() {
        this.inventarioQueries = new InventarioQueries();
    }

    public String solicitarProductos(Empleado empleado, String producto,
            Integer cantidad, Integer estante, Integer cantActual) throws Exception {
        if (inventarioQueries.solicitarProductos(empleado, producto, cantidad, estante,
                cantActual)) {
            return "Se solicito el producto con exito";
        } else {
            return "Error al solicitar el producto";
        }
    }

    public ArrayList<Tienda> verTienda(Empleado empleado) {
        try {
            return this.inventarioQueries.traerTienda(empleado);
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }
}
