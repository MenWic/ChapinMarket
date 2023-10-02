/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.constructores.ConstructorBodega;
import menwic.chapinmarket.model.Bodega;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.services.DBConexion;

public class BodegaQueries extends ConstructorBodega {

    public boolean guardarBodega(Bodega bodega) {
        try {
            DBConexion.conexion.setAutoCommit(false);
            PreparedStatement statement = DBConexion.conexion.prepareStatement(
                    "INSERT INTO c_bodega.producto (nombre, precio) VALUES(?,?);");

            statement.setString(1, bodega.getNombre());
            statement.setDouble(2, bodega.getPrecio());

            if (statement.executeUpdate() > 0) {
                statement = DBConexion.conexion.prepareStatement(
                        "INSERT INTO c_bodega.bodega VALUES(?,?,?);");
                statement.setString(1, bodega.getSucursal().getNombre());
                statement.setString(2, bodega.getNombre());
                statement.setInt(3, bodega.getCantidad());

                if (statement.executeUpdate() > 0) {
                    DBConexion.conexion.setAutoCommit(true);
                    return true;
                }
                throw new Exception("Error al crear la bodega");
            }
            throw new Exception("Error al crear el producto");
        } catch (Exception e) {
            try {
                DBConexion.conexion.rollback();
            } catch (SQLException ex) {

            }
            return false;
        }
    }

    public ArrayList<Bodega> mostrarTodaLaBodega(Empleado empleado) throws Exception {
        String query = "SELECT * FROM c_bodega.producto a INNER JOIN c_bodega.bodega"
                + " b ON a.nombre = b.producto AND b.sucursal = ?;";
        PreparedStatement pr = DBConexion.conexion.prepareStatement(query);
        pr.setString(1, empleado.getSucursal().getNombre());
        ResultSet resultado = pr.executeQuery();
        return construirLista(resultado);
    }

   
    public ArrayList<Bodega> buscarBodega(Empleado empleado, String busqueda) throws Exception {
        String query = "SELECT * FROM c_bodega.producto a INNER JOIN c_bodega.bodega"
                + " b ON a.nombre = b.producto AND b.sucursal = ? AND "
                + "LOWER(a.nombre) LIKE LOWER(?);";
        PreparedStatement pr = DBConexion.conexion.prepareStatement(query);
        pr.setString(1, empleado.getSucursal().getNombre());
        pr.setString(2, "%" + busqueda + "%");
        ResultSet resultado = pr.executeQuery();
        return construirLista(resultado);
    }
}
