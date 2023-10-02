/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menwic.chapinmarket.constructores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import menwic.chapinmarket.model.Tienda;

public class ConstructorTienda implements Constructor {

    @Override
    public ArrayList<Tienda> construirLista(ResultSet resultado) throws SQLException {
        ArrayList<Tienda> tienda = new ArrayList<>();
        while (resultado.next()) {
            String producto = resultado.getString("producto");
            Integer cantidad = resultado.getInt("cantidad");
            String sucursal = resultado.getString("sucursal");
            Integer estante = resultado.getInt("estante");
            Tienda tiendaN = new Tienda(sucursal, producto, cantidad, estante);
            tienda.add(tiendaN);
        }
        return tienda;
    }

    @Override
    public Tienda construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            String producto = resultado.getString("producto");
            Integer cantidad = resultado.getInt("cantidad");
            Integer estante = resultado.getInt("estante");
            String sucursal = resultado.getString("sucursal");

            Tienda tiendaN = new Tienda(sucursal, producto, cantidad, estante);
            return tiendaN;
        }
        return null;
    }
}
