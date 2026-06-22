package UI;

import BEAN.Customer;
import DAO.CustomerDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class selCliente extends javax.swing.JDialog {
    private DefaultTableModel dft;
    private CustomerDAO custDAO = new CustomerDAO();
    Customer cliente = new Customer();

    public selCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dft = (DefaultTableModel) tblCustomers.getModel();
        fillTableCustomers("");
    }
    
    public Customer getCliente() {
        return cliente;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("SELECCIONAR CLIENTE");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBuscar))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(232, 232, 232))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        int fila = this.tblCustomers.getSelectedRow();
        cliente.setCustomerId(dft.getValueAt(fila, 0).toString());
        cliente.setCompanyName(dft.getValueAt(fila, 1).toString());
        cliente.setContactName(dft.getValueAt(fila, 2) != null ? dft.getValueAt(fila, 2).toString() : "");
        cliente.setContactTitle(dft.getValueAt(fila, 3) != null ? dft.getValueAt(fila, 3).toString() : "");
        cliente.setAddress(dft.getValueAt(fila, 4) != null ? dft.getValueAt(fila, 4).toString() : "");
        cliente.setCity(dft.getValueAt(fila, 5) != null ? dft.getValueAt(fila, 5).toString() : "");
        cliente.setRegion(dft.getValueAt(fila, 6) != null ? dft.getValueAt(fila, 6).toString() : "");
        cliente.setPostalCode(dft.getValueAt(fila, 7) != null ? dft.getValueAt(fila, 7).toString() : "");
        cliente.setCountry(dft.getValueAt(fila, 8) != null ? dft.getValueAt(fila, 8).toString() : "");
        cliente.setPhone(dft.getValueAt(fila, 9) != null ? dft.getValueAt(fila, 9).toString() : "");
        cliente.setFax(dft.getValueAt(fila, 10) != null ? dft.getValueAt(fila, 10).toString() : "");
        this.dispose();
    }//GEN-LAST:event_tblCustomersMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.fillTableCustomers(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(selCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                selCliente dialog = new selCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
