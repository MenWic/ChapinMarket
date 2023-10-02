package menwic.chapinmarket.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import menwic.chapinmarket.constructores.ConstructorEmpleado;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.services.DBConexion;

/**
 *
 * @author lamr4
 */
public class EmpleadoQueries extends ConstructorEmpleado {

    public Empleado traerEmpleadoPorUsuarioYPassword(Empleado empleado) throws Exception {
        String query = "SELECT * FROM c_personal.empleado WHERE usuario = ? AND password = ?;";
        PreparedStatement pr = DBConexion.conexion.prepareStatement(query);
        pr.setString(1, empleado.getUsuario());
        pr.setString(2, empleado.getPassword());
        ResultSet resultado = pr.executeQuery();
        return construirObjeto(resultado);
    }
}
