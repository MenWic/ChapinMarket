package menwic.chapinmarket.views.bodega;

import java.awt.BorderLayout;
import menwic.chapinmarket.model.Empleado;

/**
 *
 * @author lamr4
 */
public class JFrameBodega extends javax.swing.JFrame {

    private Empleado empleado;

    /**
     * Creates new form JFrameBodega
     */
    public JFrameBodega(Empleado empleado) {
        this.empleado = empleado;

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); //Pantalla Completa
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuProductosBodega = new javax.swing.JMenu();
        jMenuItemVerProductos = new javax.swing.JMenuItem();
        jMenuItemIngresar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bodega");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        jMenuProductosBodega.setText("Productos en Bodega");

        jMenuItemVerProductos.setText("Ver Productos");
        jMenuItemVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerProductosActionPerformed(evt);
            }
        });
        jMenuProductosBodega.add(jMenuItemVerProductos);

        jMenuItemIngresar.setText("Ingresar");
        jMenuItemIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngresarActionPerformed(evt);
            }
        });
        jMenuProductosBodega.add(jMenuItemIngresar);

        jMenuBar.add(jMenuProductosBodega);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngresarActionPerformed
        JPanelCrearProducto cProductos = new JPanelCrearProducto(this.empleado);
        cProductos.setSize(750, 479);
        cProductos.setLocation(0, 0);

        jPanelContenedor.removeAll();
        jPanelContenedor.add(cProductos, BorderLayout.CENTER);
        jPanelContenedor.revalidate();
        jPanelContenedor.repaint();
    }//GEN-LAST:event_jMenuItemIngresarActionPerformed

    private void jMenuItemVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerProductosActionPerformed
        JPanelVerProductos cProductos = new JPanelVerProductos(this.empleado);
        cProductos.setLocation(0, 0);
        cProductos.setSize(750, 479);
        jPanelContenedor.removeAll();
        jPanelContenedor.add(cProductos, BorderLayout.CENTER);
        jPanelContenedor.revalidate();
        jPanelContenedor.repaint();
    }//GEN-LAST:event_jMenuItemVerProductosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemIngresar;
    private javax.swing.JMenuItem jMenuItemVerProductos;
    private javax.swing.JMenu jMenuProductosBodega;
    private javax.swing.JPanel jPanelContenedor;
    // End of variables declaration//GEN-END:variables
}