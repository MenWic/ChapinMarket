package menwic.chapinmarket.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.constructores.ConstructorEmpleado;
import menwic.chapinmarket.model.Bodega;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.services.DBConexion;

/**
 *
 * @author lamr4
 */
public class AdminQueries extends ConstructorEmpleado {

    //Funciones para Admin
    public boolean crearEmpleado(Empleado empleado) {
        try {
            DBConexion.conexion.setAutoCommit(false);
            PreparedStatement statement = DBConexion.conexion.prepareStatement(
                    "INSERT INTO c_personal.empleado (usuario, password, nombre, sucursal, rol, estado) "
                    + "VALUES(?,?,?,?,?,?);");
            statement.setString(1, empleado.getUsuario());
            statement.setString(2, empleado.getPassword());
            statement.setString(3, empleado.getNombre());
            statement.setString(4, empleado.getSucursal().getNombre());
            statement.setString(5, empleado.getRol());
            statement.setBoolean(6, empleado.isEstado());

            if (statement.executeUpdate() > 0) {
                DBConexion.conexion.commit();
                DBConexion.conexion.setAutoCommit(true);
                return true;
            }
            throw new Exception("Error al crear al empleado");
        } catch (Exception e) {
            try {
                DBConexion.conexion.rollback();
            } catch (SQLException ex) {

            }
            return false;
        }
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        try {
            DBConexion.conexion.setAutoCommit(false);
            PreparedStatement statement = DBConexion.conexion.prepareStatement(
                    "UPDATE INTO c_personal.empleado (usuario, password, nombre, sucursal, rol, estado) "
                    + "VALUES(?,?,?,?,?,?);");
            statement.setString(1, empleado.getUsuario());
            statement.setString(2, empleado.getPassword());
            statement.setString(3, empleado.getNombre());
            statement.setString(4, empleado.getSucursal().getNombre());
            statement.setString(5, empleado.getRol());
            statement.setBoolean(6, empleado.isEstado());

            if (statement.executeUpdate() > 0) {
                DBConexion.conexion.commit();
                DBConexion.conexion.setAutoCommit(true);
                return true;
            }
            throw new Exception("Error al crear al empleado");
        } catch (Exception e) {
            try {
                DBConexion.conexion.rollback();
            } catch (SQLException ex) {

            }
            return false;
        }
    }

    public Empleado cargaEmpleado(String usuarioEmpleado) {
        try {
            DBConexion.conexion.setAutoCommit(false);
            PreparedStatement statement = DBConexion.conexion.prepareStatement(
                    "SELECT * FROM c_personal.empleado WHERE usuario = ?;");
            statement.setString(1, usuarioEmpleado);
            ResultSet resultado = statement.executeQuery();
            return construirObjeto(resultado);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Empleado> buscarEmpleados(Empleado empleado) throws Exception {
        String query = "SELECT * FROM c_personal.empleado;";
        PreparedStatement pr = DBConexion.conexion.prepareStatement(query);
        ResultSet resultado = pr.executeQuery();
        return construirLista(resultado);
    }
}
