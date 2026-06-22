/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BEAN.Customer;
import DAO.CustomerDAO;
import UTIL.dbBean;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Admin
 */
public class FrmCustomer extends javax.swing.JInternalFrame {

    private DefaultTableModel dft;
    private CustomerDAO custDAO = new CustomerDAO();

    public FrmCustomer(int mdiW, int mdiH) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;
        
        this.setSize(1200, 675);
        slx = (mdiW/2) - (this.getWidth()/2);
        sly = (mdiH/2) -(this.getHeight()/2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        dft = (DefaultTableModel) tblCustomers.getModel();
        fillTableCustomers("");
        btnElimina.setEnabled(false);
    }

    private void fillTableCustomers(String filtro) {
        dft.setRowCount(0);

        Vector<Customer> vecCustomers = custDAO.listaCustomers(filtro);

        for (Customer c : vecCustomers) {
            Vector<String> vec = new Vector<String>();
            vec.add(c.getCustomerID());
            vec.add(c.getCompanyName());
            vec.add(c.getContactName());
            vec.add(c.getContactTitle());
            vec.add(c.getAddress());
            vec.add(c.getCity());
            vec.add(c.getRegion());
            vec.add(c.getPostalCode());
            vec.add(c.getCountry());
            vec.add(c.getPhone());
            vec.add(c.getFax());

            dft.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtCompName = new javax.swing.JTextField();
        txtContcName = new javax.swing.JTextField();
        txtCntcTitle = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        txtFax = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Company Name", "Contact Name", "Contact Title", "Address", "City", "Region", "Postal Code", "Country", "Phone", "Fax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Customers");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtCntcTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCntcTitleActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        jLabel3.setText("Company Name");

        jLabel4.setText("Contact Name");

        jLabel5.setText("Contact Title");

        jLabel6.setText("Address");

        jLabel13.setText("City");

        jLabel10.setText("Country");

        jLabel11.setText("Phone");

        jLabel12.setText("Fax");

        jLabel9.setText("Postal Code");

        txtFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFaxActionPerformed(evt);
            }
        });

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel8.setText("Region");

        txtCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCountry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(txtContcName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addComponent(txtCntcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCompName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnGrabar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCompName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContcName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCntcTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtRegion, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGrabar)
                .addGap(8, 8, 8))
        );

        btnElimina.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(btnElimina)
                                .addGap(124, 124, 124)
                                .addComponent(btnLimpiar)
                                .addGap(105, 105, 105)
                                .addComponent(btnSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(btnReporte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(btnReporte)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnSalir)
                            .addComponent(btnElimina))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReporteActionPerformed
        try {
            String r = "src/REPORTS/repCustomers.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnReporteActionPerformed

    private void txtCntcTitleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCntcTitleActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtCntcTitleActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAddressActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtCityActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPhoneActionPerformed

    private void txtFaxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFaxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFaxActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGrabarActionPerformed
        Customer c = new Customer();
        c.setCustomerId(txtId.getText());
        c.setCompanyName(txtCompName.getText());
        c.setContactName(txtContcName.getText());
        c.setContactTitle(txtCntcTitle.getText());
        c.setAddress(txtAddress.getText());
        c.setCity(txtCity.getText());
        c.setRegion(txtRegion.getText());
        c.setPostalCode(txtPostalCode.getText());
        c.setCountry(txtCountry.getText());
        c.setPhone(txtPhone.getText());
        c.setFax(txtFax.getText());

        if (btnGrabar.getText().equals("Grabar")) {
            custDAO.insertaCustomer(c);
            JOptionPane.showMessageDialog(this, "Cliente creado");

        } else {
            custDAO.actualizaCustomer(c);
            JOptionPane.showMessageDialog(this, "Cliente actualizado");

        }
        fillTableCustomers("");
    }// GEN-LAST:event_btnGrabarActionPerformed

    private void txtCountryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCountryActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtCountryActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtIdActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {
        btnGrabar.setText("Actualizar");
        btnElimina.setEnabled(true);
        
        txtId.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 0).toString());
        txtCompName.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 1).toString());
        txtContcName.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 2).toString());
        txtCntcTitle.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 3).toString());
        txtAddress.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 4).toString());
        txtCity.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 5).toString());
        txtRegion.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 6) == null ? "" : tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 6).toString());
        txtPostalCode.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 7).toString());
        txtCountry.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 8).toString());
        txtPhone.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 9).toString());
        txtFax.setText(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 10) == null ? "" : tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 10).toString());
    }// GEN-LAST:event_tblCustomersMouseClicked

    public void limpia(){
        txtId.setText("");
        txtCompName.setText("");
        txtContcName.setText("");
        txtCntcTitle.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtRegion.setText("");
        txtPostalCode.setText("");
        txtCountry.setText("");
        txtPhone.setText("");
        txtFax.setText("");

        btnGrabar.setText("Grabar");
        btnElimina.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCntcTitle;
    private javax.swing.JTextField txtCompName;
    private javax.swing.JTextField txtContcName;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtRegion;
    // End of variables declaration//GEN-END:variables
}
