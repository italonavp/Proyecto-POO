package UI;
import BEAN.Region;
import DAO.RegionDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class FrmRegion extends javax.swing.JFrame {

    RegionDAO regDAO;
    DefaultTableModel dtm;
    Util u = new Util();
    int idReg = u.idNext("Region", "RegionID");
    public FrmRegion() {
        regDAO = new RegionDAO();
        initComponents();
        dtm = (DefaultTableModel)this.tblRegion.getModel();
        llenatbl("");
        limpia();
        
    }
    private void llenatbl(String cad){
            Vector<Region> lista;
            lista = regDAO.listaRegion(cad);
            dtm.setRowCount(0);
            for(int i=0;i<lista.size();i++){
                Vector vec = new Vector();
                vec.addElement(lista.get(i).getIDregion());
                vec.addElement(lista.get(i).getRegdesc());
                dtm.addRow(vec);
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegion = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarReg = new javax.swing.JTextField();
        txtIDRegion = new javax.swing.JTextField();
        txtDescReg = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Region Mantenimiento");

        jLabel2.setText("ID Region");

        jLabel3.setText("Descripción");

        tblRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción"
            }
        ));
        tblRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegion);

        jLabel4.setText("Buscar");

        txtBuscarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarRegActionPerformed(evt);
            }
        });
        txtBuscarReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarRegKeyReleased(evt);
            }
        });

        txtIDRegion.setEnabled(false);
        txtIDRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDRegionActionPerformed(evt);
            }
        });

        txtDescReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescRegActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8)
                                .addComponent(txtDescReg, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnAgregar)
                        .addGap(47, 47, 47)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarReg, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDescReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtIDRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnSalir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscarReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDRegionActionPerformed

    private void txtDescRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescRegActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarRegActionPerformed
       
    }//GEN-LAST:event_txtBuscarRegActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        
        Region r = new Region();
        r.setRegdesc(this.txtDescReg.getText());
        if(this.btnAgregar.getText().equals("Agregar")){
            
            r.setIDregion(Integer.parseInt(this.txtIDRegion.getText()));
            regDAO.insertaRegion(r);
        }else{
            r.setIDregion(idReg);
            regDAO.actualizarReg(r);
        }
        limpia();
        JOptionPane.showMessageDialog(this, "Región registrado correctamente");
        this.llenatbl("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegionMouseClicked
        int idx;
        idx = this.tblRegion.getSelectedRow();
        
        this.txtIDRegion.setText(dtm.getValueAt(idx, 0).toString());
        this.txtDescReg.setText(dtm.getValueAt(idx, 1).toString());
        this.btnAgregar.setText("Actualizar");
    }//GEN-LAST:event_tblRegionMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarRegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRegKeyReleased
        if(this.txtBuscarReg.getText().isEmpty()){
           this.llenatbl("");
       }else{
           this.llenatbl(this.txtBuscarReg.getText());
       }
    }//GEN-LAST:event_txtBuscarRegKeyReleased
    
    private void limpia(){
        int idReg = u.idNext("Region", "RegionID");
        this.txtIDRegion.setText(String.valueOf(idReg));
        this.txtDescReg.setText("");
        this.btnAgregar.setText("Agregar");
        this.llenatbl("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegion;
    private javax.swing.JTextField txtBuscarReg;
    private javax.swing.JTextField txtDescReg;
    private javax.swing.JTextField txtIDRegion;
    // End of variables declaration//GEN-END:variables
}
