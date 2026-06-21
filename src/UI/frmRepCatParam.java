package UI;
public class frmRepCatParam extends javax.swing.JInternalFrame {
    public frmRepCatParam() {
        initComponents();
        cargarCategorias();
    }
    private void cargarCategorias() {
        try {
            DAO.CategoryDAO dao = new DAO.CategoryDAO();
            // Traemos la lista completa usando tu DAO de Categorías
            java.util.Vector<BEAN.Category> lista = dao.listaCategories(""); 
            
            cboCategorias.removeAllItems(); 
            
            for (BEAN.Category cat : lista) {
                // Formato: "1 - Beverages"
                cboCategorias.addItem(cat.getCategoryID() + " - " + cat.getCategoryName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboCategorias = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();

        jLabel1.setText("REPORTE DE CATEGORÍA POR ID");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(cboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnReportar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
try {
            if (cboCategorias.getSelectedItem() == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione una categoría.");
                return;
            }
            // 1. Extraemos el ID del texto (Ej: "1 - Beverages" -> 1)
            String seleccionado = cboCategorias.getSelectedItem().toString();
            int idBusqueda = Integer.parseInt(seleccionado.split(" - ")[0].trim());
            // 2. Buscamos la foto (Picture) de la categoría
            DAO.CategoryDAO dao = new DAO.CategoryDAO();
            java.util.Vector<BEAN.Category> lista = dao.listaCategories(""); 
            byte[] fotoLimpia = null;
            for (BEAN.Category cat : lista) {
                if (cat.getCategoryID() == idBusqueda) {
                    fotoLimpia = cat.getPicture(); // Ojo: Asegúrate de que tu BEAN se llame getPicture()
                    break;
                }
            }
            // 3. Convertimos a InputStream
            java.io.InputStream isImagen = null;
            if (fotoLimpia != null && fotoLimpia.length > 0) {
                isImagen = new java.io.ByteArrayInputStream(fotoLimpia);
            }
            // 4. Llenamos los parámetros con HashMap (¡Como vimos en tu dbBean!)
            java.util.HashMap parametros = new java.util.HashMap();
            parametros.put("param_id_categoria", idBusqueda);
            parametros.put("IMAGEN", isImagen);
            // 5. Lanzamos el reporte
            String ruta = "src/REPORTS/repCategoriesParam.jasper"; 
            UTIL.dbBean db = new UTIL.dbBean();
            db.connectRep(ruta, parametros, true); // TRUE para que acepte los parámetros
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + ex.getMessage());
        }       
    }//GEN-LAST:event_btnReportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cboCategorias;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
