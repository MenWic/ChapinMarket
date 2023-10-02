package menwic.chapinmarket.controllers;

import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.queries.EmpleadoQueries;

/**
 *
 * @author lamr4
 */
public class EmpleadoController {

    private EmpleadoQueries empleadoQueries;

    //Constructor
    public EmpleadoController() {
        this.empleadoQueries = new EmpleadoQueries();
    }

    //Funciones
    
    //Iniciar Sesion de Empleado
    public Empleado login(Empleado empleado) throws Exception {
        if (empleado.getUsuario().isBlank() || empleado.getPassword().isBlank()) {
            throw new Exception("Credenciales invalidas o vacías.");
        }
        Empleado empleadoBuscar = empleadoQueries.traerEmpleadoPorUsuarioYPassword(empleado);
        if (empleadoBuscar == null) {
            throw new Exception("Credenciales incorrectas.");
        }
        return empleadoBuscar;
    }
}
