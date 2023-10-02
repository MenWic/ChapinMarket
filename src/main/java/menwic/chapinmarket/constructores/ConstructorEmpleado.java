package menwic.chapinmarket.constructores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.model.Sucursal;

public class ConstructorEmpleado implements Constructor {

    @Override
    public ArrayList<Empleado> construirLista(ResultSet resultado) throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (resultado.next()) {
            String usuario = resultado.getString("usuario");
            String password = resultado.getString("password");
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            String rol = resultado.getString("rol");
            boolean estado = resultado.getBoolean("estado");
            Sucursal sucursal1 = new Sucursal(sucursal, "");
            Empleado empleado = new Empleado(usuario, password, nombre,
                    sucursal1, rol, estado);
            empleados.add(empleado);
        }
        return empleados;
    }

    @Override
    public Empleado construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            String usuario = resultado.getString("usuario");
            String password = resultado.getString("password");
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            String rol = resultado.getString("rol");
            boolean estado = resultado.getBoolean("estado");
            Sucursal sucursal1 = new Sucursal(sucursal, "");
            Empleado empleado = new Empleado(usuario, password, nombre,
                    sucursal1, rol, estado);
            return empleado;
        }
        return null;
    }

}
