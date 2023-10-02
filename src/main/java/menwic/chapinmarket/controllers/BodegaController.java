package menwic.chapinmarket.controllers;

import java.util.ArrayList;
import java.util.Set;

import menwic.chapinmarket.model.Bodega;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.queries.BodegaQueries;

public class BodegaController {

    private BodegaQueries bodegaQueries;

    public BodegaController() {
        this.bodegaQueries = new BodegaQueries();
    }

    public String guardarProducto(Bodega bodega) throws Exception {
        if (this.bodegaQueries.guardarBodega(bodega)) {
            return "Se guardo el producto.";
        }
        return "No se guardo el producto.";
    }

    public ArrayList<Bodega> verTodaLaBodega(Empleado empleado) {
        try {
            return this.bodegaQueries.mostrarTodaLaBodega(empleado);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public ArrayList<Bodega> buscarEnBodega(Empleado empleado, String busqueda) {
        try {
            return this.bodegaQueries.buscarBodega(empleado, busqueda);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

}
