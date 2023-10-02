package menwic.chapinmarket.services;

/**
 *
 * @author lamr4
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {

    private String url;
    private String usuario;
    private String contraseña;
    public static Connection conexion;

    //Constructor
    public DBConexion() {
        this.url = "jdbc:postgresql://localhost/chapin_market";
        this.usuario = "postgres";
        this.contraseña = "pass467";
        this.conexion = null;
    }

    //Metodo de Conexion inicial
    public  void conectarDB() {
        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a PostgreSQL");
            //conexion.close(); // Cerrar la conexion
        } catch (SQLException e) {
            System.out.println("Error al conectar con la DB: " + e.getMessage());
        }
    }
    
    //Metodo para conectar usuario especifico a la DB
    public void conectarDB(String usuario, String password) {
        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a PostgreSQL");
            //conexion.close(); // Cerrar la conexion
        } catch (SQLException e) {
            System.out.println("Error al conectar con la DB: " + e.getMessage());
        }
    }

    //Funcion para verificar estado de conexion
    public boolean getEstado() throws SQLException {
        return conexion.isClosed(); //aTure = desconectado, false = conectado
    }
}
