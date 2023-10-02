package menwic.chapinmarket.model;


public class Bodega extends Producto {

    private Sucursal sucursal;
    private Integer cantidad;

    public Bodega(Sucursal sucursal, Integer cantidad, String nombre, double precio) {
        super(nombre, precio);
        this.sucursal = sucursal;
        this.cantidad = cantidad;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
