package UI;

import UTIL.Util;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class frmRepOrdersShipper extends javax.swing.JInternalFrame {

    public frmRepOrdersShipper() {
        initComponents();
        llenaCmb();
    }

    private void llenaCmb() {
        dbBean con = new dbBean();
        String sql = "select CompanyName from Shippers order by CompanyName";
        try {
            ResultSet result = con.execSQL(sql);
            this.cmbShipper.removeAllItems();
            this.cmbShipper.addItem("");
            while (result.next()) {
                this.cmbShipper.addItem(result.getString(1).trim());
            }
            result.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbShipper = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Transportista");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Parametrizacion de Orders por Shipper");

        cmbShipper.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(cmbShipper, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnReportar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbShipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        if (this.cmbShipper.getSelectedItem() == null || this.cmbShipper.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un shipper");
            return;
        }

        String shipper = this.cmbShipper.getSelectedItem().toString();
        Util u = new Util();
        int a = u.idExp("Shippers", "ShipperID", "CompanyName", shipper);

        HashMap h = new HashMap();
        h.put("paraShipID", a);
        try {
            String r = "src/REPORTS/repOrdersShipperParam.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, h, true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cmbShipper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
