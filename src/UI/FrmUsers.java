package UI;

import BEAN.*;
import UTIL.*;
import DAO.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmUsers extends javax.swing.JInternalFrame {
    
    UsersDAO userDao;
    DefaultTableModel dtm;
    int userId;
    
    Vector<Employee> listaEmployee;

    public FrmUsers(int mdiW, int mdiH) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;

        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        txtUserID.setEditable(false);
        txtUserID.setFocusable(false);
        txtUserID.setBackground(new java.awt.Color(220, 220, 220));

        userDao = new UsersDAO();
        dtm = (DefaultTableModel) this.tblUsers.getModel();

        cargaEmployee();
        cargaStatus();
        llenaUsers("");

        // Búsqueda en tiempo real
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                llenaUsers(txtBuscar.getText());
            }
        });
    }

   
    public void llenaUsers(String cad) {
        Vector<Users> listUsers = userDao.listaUsers(cad);
        dtm.setRowCount(0);
        for (int i = 0; i < listUsers.size(); i++) {
            Vector vec = new Vector();
            Users u = listUsers.get(i);
            vec.addElement(u.getUserID());
            vec.addElement(u.getEmployeeID());
            vec.addElement(u.getUserIdentification());

            // Encriptar la contraseña solo para mostrar en la tabla
            String passParaMostrar = SecurityUtil.encrypt(u.getPassword());
            vec.addElement(passParaMostrar != null ? passParaMostrar : u.getPassword());

            String estadoTexto = (u.getStatus() == 1) ? "Activo" : "Inactivo";
            vec.addElement(estadoTexto);
            dtm.addRow(vec);
        }
    }

    
    public void cargaEmployee() {
        cmbEmployeeID.removeAllItems();
        dbBean con = new dbBean();
        String sql = "SELECT EmployeeID, FirstName, LastName FROM Employees";
        try {
            java.sql.ResultSet rs = con.execSQL(sql);
            while (rs != null && rs.next()) {
                int id = rs.getInt("EmployeeID");
                String nombre = rs.getString("FirstName") + " " + rs.getString("LastName");
                cmbEmployeeID.addItem(new ItemCombo(id, nombre));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (Exception e) {}
        }
    }

    public void cargaStatus() {
        cmbStatus.removeAllItems();
        cmbStatus.addItem("Activo");
        cmbStatus.addItem("Inactivo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUserIdentification = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        txtUserID = new javax.swing.JTextField();
        cmbEmployeeID = new javax.swing.JComboBox();
        cmbStatus = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("ID Usuario");

        jLabel9.setText("Contraseña");

        jLabel10.setText("Nombre Completo");

        txtUserIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdentificationActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado");

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre de usuario");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        cmbEmployeeID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnGrabar)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEmployeeID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUserID, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(txtUserIdentification)
                            .addComponent(txtPassword)
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(115, 115, 115))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnLimpiar)
                        .addGap(98, 98, 98)
                        .addComponent(btnEliminar)
                        .addContainerGap(164, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGrabar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserId", "EmployeeId", "userIdentification", "password", "status"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsers);

        jLabel13.setText("Buscar: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reporte", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        int idFil = this.tblUsers.getSelectedRow();

        this.userId = Integer.parseInt(dtm.getValueAt(idFil, 0).toString());
        this.txtUserID.setText(dtm.getValueAt(idFil, 0).toString());
        this.txtUserIdentification.setText(dtm.getValueAt(idFil, 2).toString());
        this.txtPassword.setText(dtm.getValueAt(idFil, 3).toString());
        this.cmbStatus.setSelectedItem(dtm.getValueAt(idFil, 4).toString());

        int idEmpBD = Integer.parseInt(dtm.getValueAt(idFil, 1).toString());

        for (int i = 0; i < cmbEmployeeID.getItemCount(); i++) {
            ItemCombo item = (ItemCombo) cmbEmployeeID.getItemAt(i);
            if (item.getId() == idEmpBD) {
                cmbEmployeeID.setSelectedIndex(i);
                break;
            }
        }

        this.btnEliminar.setEnabled(true);
        this.btnGrabar.setText("Actualizar");
    }//GEN-LAST:event_tblUsersMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String msj;

        Users user = new Users();

        user.setUserID(userId);

        this.userDao.eliminaUser(user);

        msj = "Registro eliminado con éxito";

        this.llenaUsers("");

        JOptionPane.showMessageDialog(this, msj);

        limpia();

        this.btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()){
            Users user = new Users();
            Util u = new Util();

            ItemCombo itemSeleccionado = (ItemCombo) cmbEmployeeID.getSelectedItem();
            user.setEmployeeID(itemSeleccionado.getId());

            user.setUserIdentification(this.txtUserIdentification.getText());
            user.setPassword(this.txtPassword.getText());
            user.setStatus(this.cmbStatus.getSelectedItem().equals("Activo") ? 1 : 0);

            if(this.btnGrabar.getText().equals("Grabar")){
                this.userId = u.idNext("Users", "UserId");
                user.setUserID(userId);
                this.userDao.insertaUser(user);
            } else {
                user.setUserID(userId);
                this.userDao.actualizaUser(user);
            }

            this.llenaUsers("");
            JOptionPane.showMessageDialog(this, "Operación exitosa");
            limpia();
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtUserIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdentificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIdentificationActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void limpia(){

        this.txtUserID.setText("");
        this.txtUserIdentification.setText("");
        this.txtPassword.setText("");
        this.cmbEmployeeID.setSelectedIndex(0);
        this.cmbStatus.setSelectedIndex(0);
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        this.userId = 0;
    }


    public boolean valida(){

        String cad = "";
        boolean bl = false;

        if(this.txtUserIdentification.getText().isEmpty()){
            cad += "\n Ingrese el usuario";
        }

        if(this.txtPassword.getText().isEmpty()){
            cad += "\n Ingrese la contraseña";
        }

        if(this.cmbEmployeeID.getSelectedIndex() == -1){
            cad += "\n Seleccione un empleado";
        }

        if(this.cmbStatus.getSelectedIndex() == -1){
            cad += "\n Seleccione un estado";
        }

        if(cad.isEmpty()){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(this, cad);
        }

        return bl;
    
    }
    class ItemCombo {
        private int id;
        private String nombre;

        public ItemCombo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() { return id; }
        @Override
        public String toString() { return nombre; }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbEmployeeID;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserIdentification;
    // End of variables declaration//GEN-END:variables
}
