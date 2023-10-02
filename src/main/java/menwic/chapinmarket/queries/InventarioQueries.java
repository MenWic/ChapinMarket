/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.constructores.ConstructorTienda;
import menwic.chapinmarket.model.Empleado;
import menwic.chapinmarket.model.Tienda;
import menwic.chapinmarket.services.DBConexion;

public class InventarioQueries extends ConstructorTienda {

    public boolean solicitarProductos(Empleado empleado, String producto,
            Integer cantidad, Integer estante, Integer cantActual) throws Exception {

        try {
            DBConexion.conexion.setAutoCommit(false);
            PreparedStatement statement = DBConexion.conexion.prepareStatement(
                    "INSERT INTO c_inventario.tienda VALUES(?,?,?,?);");

            statement.setInt(1, estante);
            statement.setString(2, empleado.getSucursal().getNombre());
            statement.setString(3, producto);
            statement.setInt(4, cantidad);

            if (statement.executeUpdate() > 0) {
                Integer nuevaCantidad = cantActual - cantidad;

                statement = DBConexion.conexion.prepareStatement(
                        "UPDATE c_bodega.bodega SET cantidad = ? WHERE "
                        + " sucursal = ? AND producto = ?;");

                statement.setInt(1, nuevaCantidad);
                statement.setString(2, empleado.getSucursal().getNombre());
                statement.setString(3, producto);
                if (statement.executeUpdate() > 0) {
                    DBConexion.conexion.commit();
                    DBConexion.conexion.setAutoCommit(true);
                    return true;
                }

                throw new Exception("Error al solicitar producto");
            }
            throw new Exception("Error al solicitar producto");
        } catch (Exception e) {
            try {
                DBConexion.conexion.rollback();
            } catch (SQLException ex) {

            }
            return false;
        }

    }

    public ArrayList<Tienda> traerTienda(Empleado empleado) throws Exception {
        String query = "SELECT * FROM c_inventario.tienda WHERE sucursal = ?;";
        PreparedStatement pr = DBConexion.conexion.prepareStatement(query);
        pr.setString(1, empleado.getSucursal().getNombre());
        ResultSet resultado = pr.executeQuery();
        return construirLista(resultado);
    }
}
