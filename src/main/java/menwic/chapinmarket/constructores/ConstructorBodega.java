/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.constructores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.model.Bodega;
import menwic.chapinmarket.model.Sucursal;

public class ConstructorBodega implements Constructor {

    @Override
    public ArrayList<Bodega> construirLista(ResultSet resultado) throws SQLException {
        ArrayList<Bodega> bodega = new ArrayList<>();
        while (resultado.next()) {

            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            int cantidad = resultado.getInt("cantidad");
            double precio = resultado.getDouble("precio");

            Bodega bodega1 = new Bodega(new Sucursal(sucursal), cantidad,
                    nombre, precio);
            bodega.add(bodega1);
        }
        return bodega;
    }

    @Override
    public Bodega construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            int cantidad = resultado.getInt("cantidad");
            double precio = resultado.getDouble("precio");

            Bodega bodega1 = new Bodega(new Sucursal(sucursal), cantidad,
                    nombre, precio);
            return bodega1;
        }
        return null;
    }

}
