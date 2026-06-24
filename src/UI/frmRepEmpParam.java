package UI;
public class frmRepEmpParam extends javax.swing.JInternalFrame {
    public frmRepEmpParam() {
        initComponents();
        cargarEmpleados();
        
    }
    private void cargarEmpleados() {
        try {
            DAO.EmployeeDAO dao = new DAO.EmployeeDAO();
            // Traemos la lista completa de tu base de datos
            java.util.Vector<BEAN.Employee> lista = dao.listaEmployees(""); 
            
            cboEmpleados.removeAllItems(); // Limpiamos por si acaso
            
            for (BEAN.Employee emp : lista) {
                // Metemos el ID, un guion y el nombre completo al combo
                cboEmpleados.addItem(emp.getEmployeeID() + " - " + emp.getFirstName() + " " + emp.getLastName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboEmpleados = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("REPORTE DE EMPLEADO POR ID");

        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnReportar)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        try {
            // 1. Validamos que haya seleccionado algo
            if (cboEmpleados.getSelectedItem() == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un empleado.");
                return;
            }

            // 2. Extraemos el texto (Ej: "1 - Nancy Davolio") y lo cortamos para sacar solo el "1"
            String seleccionado = cboEmpleados.getSelectedItem().toString();
            int idBusqueda = Integer.parseInt(seleccionado.split(" - ")[0].trim());
            
            // 3. Usamos tu DAO para sacar la foto limpia de ese empleado específico
            DAO.EmployeeDAO dao = new DAO.EmployeeDAO();
            java.util.Vector<BEAN.Employee> lista = dao.listaEmployees(""); 
            byte[] fotoLimpia = null;
            
            for (BEAN.Employee emp : lista) {
                if (emp.getEmployeeID() == idBusqueda) {
                    fotoLimpia = emp.getPhoto();
                    break;
                }
            }

            // 4. Convertimos los bytes de la foto a InputStream para que iReport lo entienda
            java.io.InputStream isImagen = null;
            if (fotoLimpia != null && fotoLimpia.length > 0) {
                isImagen = new java.io.ByteArrayInputStream(fotoLimpia);
            }
            
            // 5. Llenamos los parámetros exactos (¡Los nombres deben ser idénticos a tu iReport!)
            java.util.HashMap parametros = new java.util.HashMap();
            parametros.put("param_id_empleado", idBusqueda);
            parametros.put("IMAGEN", isImagen);
            
            // 6. ¡Lanzamos el reporte! (Asegúrate de poner el nombre exacto de tu archivo .jasper)
            String ruta = "src/REPORTS/repEmployeesParam.jasper"; 
            UTIL.dbBean db = new UTIL.dbBean();
            db.connectRep(ruta, parametros, true);
            this.dispose();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar la ficha: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnReportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cboEmpleados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
