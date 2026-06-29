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

        btnEliminar = new javax.swing.JButton();
        txtUserID = new javax.swing.JTextField();
        cmbEmployeeID = new javax.swing.JComboBox();
        cmbStatus = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserIdentification = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRepSimp = new javax.swing.JButton();
        btnRepParam = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        cmbEmployeeID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane1.setViewportView(tblUsers);

        jLabel7.setText("Buscar: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("ID USER");

        jLabel5.setText("PASSWORD");

        jLabel3.setText("NOMBRE COMPLETO");

        txtUserIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdentificationActionPerformed(evt);
            }
        });

        jLabel6.setText("STATUS");

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel4.setText("USER IDENTIFICATION");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel1.setText("MANTENIMIENTO USERS");

        btnRepSimp.setText("Reporte Simple");
        btnRepSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepSimpActionPerformed(evt);
            }
        });

        btnRepParam.setText("Reporte con Parametros");
        btnRepParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepParamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnGrabar)
                        .addGap(83, 83, 83)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserIdentification)
                            .addComponent(txtUserID)
                            .addComponent(cmbStatus, 0, 157, Short.MAX_VALUE)
                            .addComponent(cmbEmployeeID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRepSimp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRepParam, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addGap(20, 20, 20))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUserIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnRepSimp)
                    .addComponent(btnRepParam))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        Users user = new Users();
        user.setUserID(this.userId);
        this.userDao.eliminaUser(user);
        this.llenaUsers("");
        JOptionPane.showMessageDialog(this, "Registro eliminado con éxito");
        limpia();
        this.btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        int idFil = tblUsers.getSelectedRow();
        if (idFil < 0) return;

        this.userId = Integer.parseInt(dtm.getValueAt(idFil, 0).toString());
        this.txtUserID.setText(dtm.getValueAt(idFil, 0).toString());
        this.txtUserIdentification.setText(dtm.getValueAt(idFil, 2).toString());

        // Desencriptar contraseña para mostrarla al editar
        String passEncriptada = dtm.getValueAt(idFil, 3).toString();
        String passDesc = SecurityUtil.decrypt(passEncriptada);
        this.txtPassword.setText(passDesc != null ? passDesc : passEncriptada);

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

    private void txtUserIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdentificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIdentificationActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        if (valida()) {
            Users user = new Users();

            ItemCombo itemSeleccionado = (ItemCombo) cmbEmployeeID.getSelectedItem();
            user.setEmployeeID(itemSeleccionado.getId());
            user.setUserIdentification(this.txtUserIdentification.getText().trim());
            user.setPassword(this.txtPassword.getText().trim());
            user.setStatus(this.cmbStatus.getSelectedItem().equals("Activo") ? 1 : 0);

            if (this.btnGrabar.getText().equals("Grabar")) {
                Util u = new Util();
                this.userId = u.idNext("Users", "UserId"); // ID automático
                user.setUserID(this.userId);
                boolean ok = this.userDao.insertaUser(user);
                if (!ok) {
                    JOptionPane.showMessageDialog(this, "Error al insertar. Revisa la consola.");
                    return;
                }
            } else {
                user.setUserID(this.userId);
                boolean ok = this.userDao.actualizaUser(user);
                if (!ok) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar. Revisa la consola.");
                    return;
                }
            }

            this.llenaUsers("");
            JOptionPane.showMessageDialog(this, "Operación exitosa");
            limpia();
        }

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRepSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepSimpActionPerformed
        try {
        // Usamos dbBean, no necesitamos Conexion
            dbBean con = new dbBean();
            String ruta = "src/REPORTS/repUsersSimp.jasper";

            // false indica que NO hay parámetros (el booleano 'sw' de tu dbBean)
            con.connectRep(ruta, null, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRepSimpActionPerformed

    private void btnRepParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepParamActionPerformed
       
        String inputStatus = cmbStatus.getSelectedItem().toString().toLowerCase();

        if (inputStatus.equals("activo") || inputStatus.equals("inactivo")) {
            try {
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("STATUS", inputStatus); 

                String ruta = "src/REPORTS/repUsersParam.jasper";

                // Usamos dbBean y enviamos 'true' porque SÍ tenemos parámetros
                dbBean con = new dbBean();
                con.connectRep(ruta, (HashMap) parametros, true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Estado no válido.");
        }
    }//GEN-LAST:event_btnRepParamActionPerformed

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
    private javax.swing.JButton btnRepParam;
    private javax.swing.JButton btnRepSimp;
    private javax.swing.JComboBox cmbEmployeeID;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserIdentification;
    // End of variables declaration//GEN-END:variables
}
