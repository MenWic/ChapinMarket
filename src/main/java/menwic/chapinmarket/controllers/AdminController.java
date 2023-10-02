package menwic.chapinmarket.controllers;

import java.util.ArrayList;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.queries.AdminQueries;
import menwic.chapinmarket.queries.EmpleadoQueries;

/**
 *
 * @author lamr4
 */
public class AdminController {

    private AdminQueries adminQueries;

    //Consructor
    public AdminController() {
        this.adminQueries = new AdminQueries();
    }

    //Funciones
    //Guardar Empleado
    public String guardarEmpleado(Empleado empleado) {
        if (this.adminQueries.crearEmpleado(empleado)) {
            return "Se guardo el empleado.";
        }
        return "No se guardo el empleado.";
    }

    //Actulizar Empleado
    public String actualizarEmpleado(Empleado empleado) {
        if (this.adminQueries.actualizarEmpleado(empleado)) {
            return "Se actualizo el empleado.";
        }
        return "No se actualizo el empleado.";
    }
    
    public Empleado buscarEmpleado(String usuarioEmpleado) {
        return this.adminQueries.cargaEmpleado(usuarioEmpleado);
    }

    public ArrayList<Empleado> verEmpleados(Empleado empleado) {
        try {
            return this.adminQueries.buscarEmpleados(empleado);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }
}
