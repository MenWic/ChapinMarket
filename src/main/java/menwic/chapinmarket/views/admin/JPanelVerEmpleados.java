package menwic.chapinmarket.views.admin;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import menwic.chapinmarket.controllers.AdminController;
import menwic.chapinmarket.model.Empleado;

/**
 *
 * @author lamr4
 */
public class JPanelVerEmpleados extends javax.swing.JPanel {

    private AdminController adminController;
    private Empleado empleado;

    /**
     * Creates new form JPanelVerEmpleados
     */
    public JPanelVerEmpleados() {
        initComponents();
        this.adminController = new AdminController();
        this.empleado = empleado;
        this.mostrarEmpleados();
    }

    private void mostrarEmpleados() {
        ArrayList<Empleado> encontrado = this.adminController.verEmpleados(empleado);
        this.cargarDatosATabla(encontrado);
    }

    private DefaultTableModel darColumnasATabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        Object[] columnas = new Object[]{"Usuario", "Password", "Nombre", "Sucursal", "Rol", "Estado"};

        for (Object object : columnas) {
            modelo.addColumn(object);
        }
        return modelo;
    }

    private void cargarDatosATabla(ArrayList<Empleado> empleados) {
        clearTable();//limpiar tabla
        DefaultTableModel modelo = darColumnasATabla();//crear modelo
        for (Empleado item : empleados) {
            Object[] itemArray = new Object[]{
                item.getUsuario(),
                item.getPassword(), item.getNombre(),
                item.getSucursal().getNombre(),
                item.getRol(), item.isEstado()
            };
            modelo.addRow(itemArray);
        }
        this.tablaTienda.setModel(modelo);
    }

    private void clearTable() {
        this.tablaTienda.setModel(new DefaultTableModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTienda = new javax.swing.JTable();

        tablaTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaTienda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTienda;
    // End of variables declaration//GEN-END:variables
}
