/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UTIL.dbBean;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Italo
 */
public class frmRepCustomersRegion extends javax.swing.JInternalFrame {

    private JDesktopPane desktop;
    
    /**
     * Creates new form frmRepCustomersRegion
     */
    public frmRepCustomersRegion(int mdiH, int mdiW, JDesktopPane desktop) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;
        
        cargarClientes();
        this.desktop = desktop; 
        
        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
    }

    private void cargarClientes() {
        try {
            DAO.CustomerDAO dao = new DAO.CustomerDAO();
            java.util.Vector<BEAN.Customer> lista = dao.listaCustomers("");

            cboClientes.removeAllItems();

            for (BEAN.Customer cliente : lista) {
                cboClientes.addItem(cliente.getCustomerID() + " - " + cliente.getCompanyName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReportar = new javax.swing.JButton();
        cboClientes = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("REPORTE DE CLIENTE POR ID");

        jLabel2.setText("Cliente");

        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        cboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnReportar))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cboClientes))
                .addGap(18, 18, 18)
                .addComponent(btnReportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        try {
            if (cboClientes.getSelectedItem() == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un cliente.");
                return;
            }

            String seleccionado = cboClientes.getSelectedItem().toString();
            String idBusqueda = seleccionado.split(" - ")[0].trim();

            HashMap parametros = new HashMap();
            parametros.put("param_id_cliente", idBusqueda);

            String tipoRep = "Customers";
            String tipo = "Param";

            FrmReporte frmReporte = new FrmReporte(tipoRep, parametros, tipo);
            desktop.add(frmReporte);
            frmReporte.setVisible(true);
            this.dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar la ficha: " + ex.getMessage());
        }


    }//GEN-LAST:event_btnReportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cboClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
