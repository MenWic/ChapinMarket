package menwic.chapinmarket.model;

/**
 *
 * @author lamr4
 */
public class Empleado {

    private String usuario;
    private String password;
    private String nombre;
    private Sucursal sucursal;
    private String rol;
    private boolean estado;

    //Constructor para Login
    public Empleado(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    //Constructor
    public Empleado(String usuario, String password, String nombre, Sucursal sucursal, String rol, boolean estado) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.rol = rol;
        this.estado = estado;
    }

    //Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
