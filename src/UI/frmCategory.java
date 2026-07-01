package UI;
public class frmCategory extends javax.swing.JInternalFrame {
    DAO.CategoryDAO catDao;
    javax.swing.table.DefaultTableModel dtm;
    int idCat = 0;
    byte[] fotoBinaria = null; 
    
    java.util.Vector<BEAN.Category> listaCatGlobal; 

    public frmCategory(int mdiW, int mdiH) { // Ajusta este nombre si tu clase se llama distinto
        int slx, sly, wd = mdiW, hd = mdiH;
        
        this.setSize(1200, 675);
        slx = (mdiW/2) - (this.getWidth()/2);
        sly = (mdiH/2) -(this.getHeight()/2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        initComponents();
        this.getContentPane().setBackground(java.awt.Color.WHITE); // Fondo limpio
        
        catDao = new DAO.CategoryDAO();
        dtm = (javax.swing.table.DefaultTableModel) this.tblCategorias.getModel();
        
        // Protecciones de interfaz
        this.txtCategoriaId.setEnabled(false); 
        this.btnEliminar.setEnabled(false); // Se enciende solo al elegir de la tabla
        
        llenaTblCategorias("");
    }
    private void llenaTblCategorias(String cad) {
        listaCatGlobal = catDao.listaCategories(cad); // Asegúrate de que el método en tu DAO se llame así
        dtm.setRowCount(0);
        for (int i = 0; i < listaCatGlobal.size(); i++) {
            java.util.Vector vec = new java.util.Vector();
            vec.addElement(listaCatGlobal.get(i).getCategoryID()); // Asume que tu BEAN tiene getCategoryID()
            vec.addElement(listaCatGlobal.get(i).getCategoryName());
            vec.addElement(listaCatGlobal.get(i).getDescription());
            dtm.addRow(vec);
        }
    }
    private boolean valida() {
        // Valida campos de texto
        if (this.txtNombre.getText().trim().isEmpty() || 
            this.txtDescripcion.getText().trim().isEmpty()) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete el Nombre y la Descripción de la categoría.");
            return false;
        }
        
        // Valida Foto
        if (this.fotoBinaria == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Es obligatorio subir una imagen para la categoría.");
            return false;
        }
        return true;
    }

    private void limpia() {
        this.txtCategoriaId.setText("");
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");
        
        this.fotoBinaria = null;
        if (this.lblImagen != null) this.lblImagen.setIcon(null);
        
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        this.idCat = 0;
    }
    private void pintarImagenEnLabel(byte[] imgBytes) {
        if (imgBytes != null && imgBytes.length > 0) {
            try {
                java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(imgBytes);
                java.awt.image.BufferedImage imgOriginal = javax.imageio.ImageIO.read(bais);

                if (imgOriginal != null) {
                    java.awt.Image imagenEscalada = imgOriginal.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lblImagen.setIcon(new javax.swing.ImageIcon(imagenEscalada));
                } else {
                    javax.swing.ImageIcon icono = new javax.swing.ImageIcon(imgBytes);
                    java.awt.Image imagenOriginal = icono.getImage();
                    java.awt.Image imagenEscalada = imagenOriginal.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lblImagen.setIcon(new javax.swing.ImageIcon(imagenEscalada));
                }
                lblImagen.repaint(); 
                
            } catch (Exception e) {
                lblImagen.setIcon(null);
                System.out.println("Error al renderizar foto: " + e.getMessage());
            }
        } else {
            lblImagen.setIcon(null);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCategoriaId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnBuscarImagen = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Categoria");

        jLabel2.setText("ID Categoría");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripción");

        jLabel5.setText("Imagen");

        txtCategoriaId.setEnabled(false);

        btnBuscarImagen.setText("Subir Imagen");
        btnBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarImagenActionPerformed(evt);
            }
        });

        lblImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel7.setText("Buscar");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 20, 32, 14);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(80, 20, 330, 20);

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Categoría", "Nombre", "Descripción"
            }
        ));
        tblCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategorias);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 390, 180);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarImagen)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(btnGrabar)
                .addGap(89, 89, 89)
                .addComponent(btnLimpiar)
                .addGap(63, 63, 63)
                .addComponent(btnEliminar)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnBuscarImagen))
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGrabar)
                    .addComponent(btnEliminar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (!valida()) return; 
        
        BEAN.Category cat = new BEAN.Category();
        cat.setCategoryName(this.txtNombre.getText().trim());
        cat.setDescription(this.txtDescripcion.getText().trim());
        cat.setPicture(fotoBinaria); 

        // Decisión de Inserción o Actualización
        if (this.btnGrabar.getText().equals("Grabar")) {
            
            // Escudo Antiduplicados (Asumiendo que hiciste el método en tu DAO)
            if (catDao.existeCategory(cat.getCategoryName())) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Acción denegada: Ya existe una categoría con el nombre '" + cat.getCategoryName() + "'.", 
                    "Registro Duplicado", javax.swing.JOptionPane.WARNING_MESSAGE);
                return; 
            }
            
            catDao.insertaCategory(cat);
            javax.swing.JOptionPane.showMessageDialog(this, "Categoría registrada con éxito.");
        } else {
            cat.setCategoryID(idCat);
            catDao.actualizaCategory(cat);
            javax.swing.JOptionPane.showMessageDialog(this, "Categoría actualizada con éxito.");
        }
        
        limpia();
        llenaTblCategorias("");
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idCat == 0) return;

        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta categoría?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
        if(opcion == javax.swing.JOptionPane.YES_OPTION){
            int resultado = catDao.eliminaCategory(idCat);
            
            switch(resultado) {
                case 0:
                    javax.swing.JOptionPane.showMessageDialog(this, "Categoría eliminada correctamente.");
                    limpia();
                    llenaTblCategorias("");
                    break;
                case 1: 
                    javax.swing.JOptionPane.showMessageDialog(this, "Acción denegada: La categoría tiene PRODUCTOS asociados."); 
                    break;
                case -1: 
                    javax.swing.JOptionPane.showMessageDialog(this, "Error crítico de base de datos."); 
                    break;
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImagenActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        
        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = fileChooser.getSelectedFile();
            try {
                java.io.FileInputStream fis = new java.io.FileInputStream(archivo);
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                
                fotoBinaria = bos.toByteArray();
                pintarImagenEnLabel(fotoBinaria);
                
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al procesar la imagen.");
            }
        }
    }//GEN-LAST:event_btnBuscarImagenActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenaTblCategorias(this.txtBuscar.getText().trim());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriasMouseClicked
        int idx = this.tblCategorias.getSelectedRow();
        if (idx == -1) return;
        
        BEAN.Category cat = listaCatGlobal.get(idx);
        
        idCat = cat.getCategoryID();
        this.txtCategoriaId.setText(String.valueOf(idCat));
        this.txtNombre.setText(cat.getCategoryName());
        this.txtDescripcion.setText(cat.getDescription());

        // Renderizado de Imagen
        fotoBinaria = cat.getPicture(); // Asume que tu BEAN usa getPicture()
        pintarImagenEnLabel(fotoBinaria);

        this.btnGrabar.setText("Actualizar");
        this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCategoriaId;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
