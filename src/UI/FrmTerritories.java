package UI;

import BEAN.Territories;
import DAO.TerritoriesDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmTerritories extends javax.swing.JInternalFrame {

    TerritoriesDAO terrDAO;
    DefaultTableModel dtm;
    Util u = new Util();

    public FrmTerritories(int mdiW, int mdiH) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;
        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
        terrDAO = new TerritoriesDAO();
        dtm = (DefaultTableModel) this.tblTerritories.getModel();
        llenatbl("");
        limpia();
    }

    private void llenatbl(String cad) {
        Vector<Territories> lista;
        lista = terrDAO.listaTerritories(cad);
        dtm.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Vector vec = new Vector();
            vec.addElement(lista.get(i).getTerritoryID());
            vec.addElement(lista.get(i).getTerritoryDescription());
            vec.addElement(lista.get(i).getRegionID());
            dtm.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtRegionID = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTerritories = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mantenimiento Territories");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mantenimiento Territories");

        jLabel2.setText("ID Territory");

        jLabel3.setText("Descripcion");

        jLabel4.setText("ID Region");

        txtID.setEnabled(false);

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

        btnSalir.setText("Eliminar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblTerritories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "ID Region"
            }
        ));
        tblTerritories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTerritoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTerritories);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegionID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(38, 38, 38)
                        .addComponent(btnLimpiar)
                        .addGap(38, 38, 38)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtRegionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnSalir))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (this.txtDescripcion.getText().isEmpty() || this.txtRegionID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        Territories t = new Territories();
        t.setTerritoryID(this.txtID.getText());
        t.setTerritoryDescription(this.txtDescripcion.getText());
        t.setRegionID(Integer.parseInt(this.txtRegionID.getText()));

        if (this.btnAgregar.getText().equals("Agregar")) {
            terrDAO.insertaTerritories(t);
            JOptionPane.showMessageDialog(this, "Territory registrado correctamente");
        } else {
            terrDAO.actualiza(t);
            JOptionPane.showMessageDialog(this, "Territory actualizado correctamente");
        }
        limpia();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (this.btnSalir.getText().equals("Eliminar")) {
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea eliminar el territory seleccionado?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                int resultado = terrDAO.eliminaTerritories(this.txtID.getText());
                if (resultado == 0) {
                    limpia();
                    JOptionPane.showMessageDialog(this, "Territory eliminado correctamente");
                } else if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar el territory porque tiene empleados asociados");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el territory");
                }
            }
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (this.txtBuscar.getText().isEmpty()) {
            this.llenatbl("");
        } else {
            this.llenatbl(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblTerritoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTerritoriesMouseClicked
        int idx;
        idx = this.tblTerritories.getSelectedRow();

        this.txtID.setText(dtm.getValueAt(idx, 0).toString());
        this.txtDescripcion.setText(dtm.getValueAt(idx, 1).toString());
        this.txtRegionID.setText(dtm.getValueAt(idx, 2).toString());
        this.btnAgregar.setText("Actualizar");
        this.btnSalir.setText("Eliminar");
    }//GEN-LAST:event_tblTerritoriesMouseClicked

    private void limpia() {
        int idTerritory = u.idNext("Territories", "TerritoryID");
        this.txtID.setText(String.valueOf(idTerritory));
        this.txtDescripcion.setText("");
        this.txtRegionID.setText("");
        this.btnAgregar.setText("Agregar");
        this.btnSalir.setText("Eliminar");
        this.llenatbl("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTerritories;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtRegionID;
    // End of variables declaration//GEN-END:variables
}
