package UI;

import BEAN.*;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class frmEmployee extends javax.swing.JInternalFrame {

    DAO.EmployeeDAO empDao;
    javax.swing.table.DefaultTableModel dtm;
    int idEmp = 0;
    byte[] fotoBinaria = null;

    java.util.Vector<Employee> listaEmpGlobal;
    java.util.Vector<Employee> listaJefesGlobal;

    public frmEmployee(int mdiW, int mdiH) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;

        this.setSize(1200, 675);
        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        //this.getContentPane().setBackground(java.awt.Color.WHITE); // Fondo limpio y estético

        empDao = new DAO.EmployeeDAO();
        dtm = (javax.swing.table.DefaultTableModel) this.tblEmpleados.getModel();

        // Protecciones de interfaz
        this.txtEmpleadoId.setEnabled(false);
        this.btnEliminar.setEnabled(false); // Se enciende solo al elegir de la tabla

        llenaComboJefes();
        llenaComboTitulos(); // <-- LLAMADA AL NUEVO MÉTODO
        llenaTblEmpleados("");

        cmbTituloEmp.setEditable(true);
    }

    // NUEVO MÉTODO: Carga las opciones de cargos de la empresa
    private void llenaComboTitulos() {
        this.cmbTituloEmp.removeAllItems();

        String sql = "SELECT DISTINCT Title FROM Employees";
        dbBean db = new dbBean();
        try {
            ResultSet res = db.execSQL(sql);
            while (res.next()) {
                cmbTituloEmp.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void llenaTblEmpleados(String cad) {
        listaEmpGlobal = empDao.listaEmployees(cad);
        dtm.setRowCount(0);
        for (int i = 0; i < listaEmpGlobal.size(); i++) {
            java.util.Vector vec = new java.util.Vector();
            BEAN.Employee emp = listaEmpGlobal.get(i);
            vec.addElement(emp.getEmployeeID());
            vec.addElement(emp.getLastName());
            vec.addElement(emp.getFirstName());
            vec.addElement(emp.getTitle());
            vec.addElement(emp.getTitleOfCourtesy());
            vec.addElement(emp.getBirthDate());
            vec.addElement(emp.getHireDate());
            vec.addElement(emp.getAddress());
            vec.addElement(emp.getCity());
            vec.addElement(emp.getRegion());
            vec.addElement(emp.getPostalCode());
            vec.addElement(emp.getCountry());
            vec.addElement(emp.getHomePhone());
            vec.addElement(emp.getExtension());
            vec.addElement(emp.getNotes());
            vec.addElement(emp.getReportsTo());
            vec.addElement(emp.getPhotoPath());
            dtm.addRow(vec);
        }
    }

    private void llenaComboJefes() {
        listaJefesGlobal = empDao.listaCmbEmployee();
        this.cmbEncargado.removeAllItems();
        this.cmbEncargado.addItem("Ninguno"); // Índice 0
        for (int i = 0; i < listaJefesGlobal.size(); i++) {
            this.cmbEncargado.addItem(listaJefesGlobal.get(i).getFirstName());
        }
    }

    private boolean valida() {
        // Valida campos de texto y combos esenciales
        if (this.txtApellidos.getText().trim().isEmpty()
                || this.txtNombres.getText().trim().isEmpty()
                || this.txtDireccion.getText().trim().isEmpty()
                || this.txtCiudad.getText().trim().isEmpty()
                || this.txtPais.getText().trim().isEmpty()) {

            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto principales y seleccione un Título.");
            return false;
        }
        // Valida Fechas
        if (this.jDateChooserNacimiento.getDate() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione la fecha de nacimiento.");
            return false;
        }
        if (this.jDateChooserContratacion.getDate() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione la fecha de contratación.");
            return false;
        }
        // Valida Foto
        if (this.fotoBinaria == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Es obligatorio subir la fotografía del empleado.");
            return false;
        }
        return true;
    }

    private void limpia() {
        this.txtEmpleadoId.setText("");
        this.txtApellidos.setText("");
        this.txtNombres.setText("");
        this.cmbTituloEmp.setSelectedIndex(0); // <-- LIMPIA EL COMBO
        this.cmbCortesia.setSelectedIndex(0);
        this.jDateChooserNacimiento.setDate(null);
        this.jDateChooserContratacion.setDate(null);
        this.txtDireccion.setText("");
        this.txtCiudad.setText("");
        this.txtRegion.setText("");
        this.txtCodigo.setText("");
        this.txtPais.setText("");
        this.txtTelefono.setText("");
        this.txtExtension.setText("");
        this.txtNotas.setText("");
        this.cmbEncargado.setSelectedIndex(0);
        this.txtRutaFoto.setText("");

        this.fotoBinaria = null;
        if (this.lblFoto != null) {
            this.lblFoto.setIcon(null);
        }

        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        this.idEmp = 0;
    }

    private void pintarImagenEnLabel(byte[] imgBytes) {
        if (imgBytes != null && imgBytes.length > 0) {
            try {
                // Intento 1: Librería ImageIO (Robusta)
                java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(imgBytes);
                java.awt.image.BufferedImage imgOriginal = javax.imageio.ImageIO.read(bais);

                if (imgOriginal != null) {
                    java.awt.Image imagenEscalada = imgOriginal.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lblFoto.setIcon(new javax.swing.ImageIcon(imagenEscalada));
                } else {
                    // Intento 2: Método clásico Swing (Si ImageIO falla con algún formato)
                    javax.swing.ImageIcon icono = new javax.swing.ImageIcon(imgBytes);
                    java.awt.Image imagenOriginal = icono.getImage();
                    java.awt.Image imagenEscalada = imagenOriginal.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lblFoto.setIcon(new javax.swing.ImageIcon(imagenEscalada));
                }
                lblFoto.repaint(); // Fuerza al panel a redibujarse

            } catch (Exception e) {
                lblFoto.setIcon(null);
                System.out.println("Error al renderizar foto: " + e.getMessage());
            }
        } else {
            lblFoto.setIcon(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtEmpleadoId = new javax.swing.JTextField();
        btnSubirFoto = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        cmbTituloEmp = new javax.swing.JComboBox<>();
        txtCiudad = new javax.swing.JTextField();
        cmbCortesia = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRegion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtExtension = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbEncargado = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRutaFoto = new javax.swing.JTextField();
        jDateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        jDateChooserContratacion = new com.toedter.calendar.JDateChooser();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1070, 546));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 503, -1, -1));

        txtEmpleadoId.setEnabled(false);
        jPanel2.add(txtEmpleadoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 57, -1));

        btnSubirFoto.setText("Subir Foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });
        jPanel2.add(btnSubirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, -1, -1));
        jPanel2.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 151, -1));

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 150, 150));
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 151, -1));

        jPanel2.add(cmbTituloEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 152, -1));
        jPanel2.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 85, -1));

        cmbCortesia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Mr.", "Mrs.", "Ms.", "Dr." }));
        jPanel2.add(cmbCortesia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 72, -1));

        jLabel19.setText("Empleado Encargado");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 100, -1));

        jLabel20.setText("Ruta de Foto");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 77, -1));

        jLabel9.setText("Dirección");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 170, -1));

        jLabel10.setText("Ciudad");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));
        jPanel2.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 89, -1));

        jLabel11.setText("Región");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));
        jPanel2.add(txtRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 89, -1));

        jLabel12.setText("Código Postal");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 111, -1));

        jLabel13.setText("País");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        jPanel2.add(txtExtension, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 56, -1));

        jLabel14.setText("Teléfono");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        txtNotas.setColumns(20);
        txtNotas.setRows(5);
        jScrollPane2.setViewportView(txtNotas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 189, 84));

        jLabel15.setText("Extensión");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel16.setText("Foto");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, -1, -1));

        cmbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEncargadoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 120, -1));

        jLabel17.setText("Notas");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, -1, -1));

        jLabel2.setText("ID Empleado");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("Apellidos");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setText("Nombres");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setText("Título en Empresa");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel6.setText("Titulo de Cortesía");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel7.setText("Fecha de Nacimiento");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel8.setText("Fecha de Contratación");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));
        jPanel2.add(txtRutaFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 231, -1));
        jPanel2.add(jDateChooserNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 132, -1));
        jPanel2.add(jDateChooserContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 132, -1));

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jTabbedPane1.addTab("Mantenimiento", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado Id", "Apellidos", "Nombres", "Título", "Título de Cortesía", "F. de Cumpleaños", "F. de Contrato", "Dirección", "Ciudad", "Región", "Código Postal", "País", "Teléfono", "Extensión", "Notas", "E. a Cargo", "Url Foto"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 40, 1050, 420);

        jLabel18.setText("Buscar");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 10, 32, 14);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(90, 10, 980, 20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1137, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Reporte", jPanel4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(459, 459, 459))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEncargadoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int idx = this.tblEmpleados.getSelectedRow();
        if (idx == -1) {
            return;
        }

        BEAN.Employee emp = listaEmpGlobal.get(idx);

        idEmp = emp.getEmployeeID();
        this.txtEmpleadoId.setText(String.valueOf(idEmp));
        this.txtApellidos.setText(emp.getLastName());
        this.txtNombres.setText(emp.getFirstName());
        this.txtDireccion.setText(emp.getAddress());
        this.txtCiudad.setText(emp.getCity());
        this.txtRegion.setText(emp.getRegion());
        this.txtCodigo.setText(emp.getPostalCode());
        this.txtPais.setText(emp.getCountry());
        this.txtTelefono.setText(emp.getHomePhone());
        this.txtExtension.setText(emp.getExtension());
        this.txtNotas.setText(emp.getNotes());
        this.txtRutaFoto.setText(emp.getPhotoPath());
        // <-- LÓGICA PARA EL COMBO TÍTULO
        if (emp.getTitle() != null) {
            this.cmbTituloEmp.setSelectedItem(emp.getTitle());
        } else {
            this.cmbTituloEmp.setSelectedIndex(0);
        }

        if (emp.getTitleOfCourtesy() != null) {
            this.cmbCortesia.setSelectedItem(emp.getTitleOfCourtesy());
        }

        this.jDateChooserNacimiento.setDate(emp.getBirthDate());
        this.jDateChooserContratacion.setDate(emp.getHireDate());

        // Lógica Inversa para Combo Jefes
        int idJefeBD = emp.getReportsTo();
        if (idJefeBD == 0) {
            this.cmbEncargado.setSelectedIndex(0);
        } else {
            for (int i = 0; i < listaJefesGlobal.size(); i++) {
                if (listaJefesGlobal.get(i).getEmployeeID() == idJefeBD) {
                    this.cmbEncargado.setSelectedIndex(i + 1);
                    break;
                }
            }
        }

        // Renderizado de Imagen
        fotoBinaria = emp.getPhoto();
        pintarImagenEnLabel(fotoBinaria);

        this.btnGrabar.setText("Actualizar");
        this.btnEliminar.setEnabled(true);
        this.jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenaTblEmpleados(this.txtBuscar.getText().trim());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (!valida()) {
            return; // Si falta algo, detiene la grabación
        }
        
        Employee emp = new Employee();
        emp.setLastName(this.txtApellidos.getText().trim());
        emp.setFirstName(this.txtNombres.getText().trim());
        
        emp.setTitle(cmbTituloEmp.getEditor().getItem().toString());

        if (this.cmbCortesia.getSelectedItem() != null) {
            emp.setTitleOfCourtesy(this.cmbCortesia.getSelectedItem().toString());
        }

        // Conversión de Fechas
        emp.setBirthDate(new java.sql.Date(this.jDateChooserNacimiento.getDate().getTime()));
        emp.setHireDate(new java.sql.Date(this.jDateChooserContratacion.getDate().getTime()));

        emp.setAddress(this.txtDireccion.getText().trim());
        emp.setCity(this.txtCiudad.getText().trim());
        emp.setRegion(this.txtRegion.getText().trim());
        emp.setPostalCode(this.txtCodigo.getText().trim());
        emp.setCountry(this.txtPais.getText().trim());
        emp.setHomePhone(this.txtTelefono.getText().trim());
        emp.setExtension(this.txtExtension.getText().trim());
        emp.setNotes(this.txtNotas.getText().trim());
        emp.setPhotoPath(this.txtRutaFoto.getText().trim());

        emp.setPhoto(fotoBinaria); // Asignamos la memoria visual al BEAN

        // Lectura del Combo de Jefes
        int posCombo = this.cmbEncargado.getSelectedIndex();
        if (posCombo == 0) {
            emp.setReportsTo(0);
        } else {
            emp.setReportsTo(listaJefesGlobal.get(posCombo - 1).getEmployeeID());
        }

        // Decisión de Inserción o Actualización
        if (this.btnGrabar.getText().equals("Grabar")) {
            if (empDao.existeEmpleado(emp.getFirstName(), emp.getLastName())) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Acción denegada: Ya existe un empleado registrado con el nombre '"
                        + emp.getFirstName() + " " + emp.getLastName() + "'.",
                        "Registro Duplicado",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                return; // Interrumpe la ejecución completa del botón para que NO guarde
            }
            // ------------------------------

            empDao.insertaEmployee(emp);
            javax.swing.JOptionPane.showMessageDialog(this, "Empleado registrado con éxito.");
        } else {
            emp.setEmployeeID(idEmp);
            empDao.actualizaEmployee(emp);
            javax.swing.JOptionPane.showMessageDialog(this, "Empleado actualizado con éxito.");
        }

        System.out.println(emp.getTitle());
        limpia();
        llenaTblEmpleados("");
        llenaComboJefes(); // Actualiza por si el nuevo empleado ahora es jefe de alguien
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idEmp == 0) {
            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a este empleado?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int resultado = empDao.eliminaEmployee(idEmp);

            switch (resultado) {
                case 0:
                    javax.swing.JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
                    limpia();
                    llenaTblEmpleados("");
                    llenaComboJefes();
                    break;
                case 1:
                    javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene cuenta activa (USERS).");
                    break;
                case 2:
                    javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene historial de ventas (ORDERS).");
                    break;
                case 3:
                    javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene territorios asignados.");
                    break;
                case 4:
                    javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Es jefe de otros empleados.");
                    break;
                case -1:
                    javax.swing.JOptionPane.showMessageDialog(this, "Error crítico de base de datos.");
                    break;
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = fileChooser.getSelectedFile();
            //Automatización de la ruta con la foto subida
            this.txtRutaFoto.setText(archivo.getAbsolutePath());

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
    }//GEN-LAST:event_btnSubirFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cmbCortesia;
    private javax.swing.JComboBox<String> cmbEncargado;
    private javax.swing.JComboBox<String> cmbTituloEmp;
    private com.toedter.calendar.JDateChooser jDateChooserContratacion;
    private com.toedter.calendar.JDateChooser jDateChooserNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpleadoId;
    private javax.swing.JTextField txtExtension;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtRegion;
    private javax.swing.JTextField txtRutaFoto;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
