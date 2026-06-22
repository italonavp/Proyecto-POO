package UI;
import BEAN.*;
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
        slx = (mdiW/2) - (this.getWidth()/2);
        sly = (mdiH/2) -(this.getHeight()/2);
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
    }

    // NUEVO MÉTODO: Carga las opciones de cargos de la empresa
    private void llenaComboTitulos() {
        this.cmbTituloEmp.removeAllItems();
        this.cmbTituloEmp.addItem(""); // Índice 0 (vacío, para forzar selección)
        this.cmbTituloEmp.addItem("Sales Representative");
        this.cmbTituloEmp.addItem("Vice President, Sales");
        this.cmbTituloEmp.addItem("Sales Manager");
        this.cmbTituloEmp.addItem("Inside Sales Coordinator");
    }
    
    private void llenaTblEmpleados(String cad) {
        listaEmpGlobal = empDao.listaEmployees(cad);
        dtm.setRowCount(0);
        for (int i = 0; i < listaEmpGlobal.size(); i++) {
            java.util.Vector vec = new java.util.Vector();
            vec.addElement(listaEmpGlobal.get(i).getEmployeeID());
            vec.addElement(listaEmpGlobal.get(i).getLastName());
            vec.addElement(listaEmpGlobal.get(i).getFirstName());
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
        if (this.txtApellidos.getText().trim().isEmpty() || 
            this.txtNombres.getText().trim().isEmpty() ||
            this.cmbTituloEmp.getSelectedIndex() == 0 || // <-- VALIDA EL COMBO
            this.txtDireccion.getText().trim().isEmpty() ||
            this.txtCiudad.getText().trim().isEmpty() ||
            this.txtPais.getText().trim().isEmpty()) {
            
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
        if (this.lblFoto != null) this.lblFoto.setIcon(null);
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtEmpleadoId = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        cmbCortesia = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtRegion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtExtension = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        cmbEncargado = new javax.swing.JComboBox<>();
        txtRutaFoto = new javax.swing.JTextField();
        jDateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        jDateChooserContratacion = new com.toedter.calendar.JDateChooser();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSubirFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        cmbTituloEmp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO EMPLEADO");

        jLabel2.setText("Id Empleado");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Nombres");

        jLabel5.setText("Título en Empresa");

        jLabel6.setText("Titulo de Cortesía");

        jLabel7.setText("Fecha de Nacimiento");

        jLabel8.setText("Fecha de Contratación");

        jLabel9.setText("Dirección");

        jLabel10.setText("Ciudad");

        jLabel11.setText("Región");

        jLabel12.setText("Código Postal");

        jLabel13.setText("País");

        jLabel14.setText("Teléfono");

        jLabel15.setText("Extensión");

        jLabel16.setText("Foto");

        jLabel17.setText("Notas");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado Id", "Apellidos", "Nombres"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 40, 340, 190);

        jLabel18.setText("Buscar");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 10, 32, 14);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(90, 10, 260, 20);

        txtEmpleadoId.setEnabled(false);

        cmbCortesia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Mr.", "Mrs.", "Ms.", "Dr." }));

        jLabel19.setText("Empleado Encargado");

        jLabel20.setText("Ruta de Foto");

        txtNotas.setColumns(20);
        txtNotas.setRows(5);
        jScrollPane2.setViewportView(txtNotas);

        cmbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEncargadoActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

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

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSubirFoto.setText("Subir Foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCortesia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jDateChooserContratacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbTituloEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(85, 85, 85)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSubirFoto)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(66, 66, 66)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addGap(59, 59, 59)
                                .addComponent(btnLimpiar)
                                .addGap(57, 57, 57)
                                .addComponent(btnSalir)
                                .addGap(93, 93, 93))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(537, 537, 537))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(342, 342, 342)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSubirFoto)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cmbEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGrabar)
                                    .addComponent(btnLimpiar)
                                    .addComponent(btnSalir)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTituloEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbCortesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jDateChooserNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jDateChooserContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEncargadoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int idx = this.tblEmpleados.getSelectedRow();
        if (idx == -1) return;
        
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
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenaTblEmpleados(this.txtBuscar.getText().trim());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (!valida()) return; // Si falta algo, detiene la grabación
        
        Employee emp = new Employee();
        emp.setLastName(this.txtApellidos.getText().trim());
        emp.setFirstName(this.txtNombres.getText().trim());
        
        if(this.cmbTituloEmp.getSelectedIndex() > 0){
            emp.setTitle(this.cmbTituloEmp.getSelectedItem().toString());
        } else {
            emp.setTitle("");
        }
        
        if(this.cmbCortesia.getSelectedItem() != null){
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
        
        limpia();
        llenaTblEmpleados("");
        llenaComboJefes(); // Actualiza por si el nuevo empleado ahora es jefe de alguien
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idEmp == 0) return;

        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a este empleado?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
        if(opcion == javax.swing.JOptionPane.YES_OPTION){
            int resultado = empDao.eliminaEmployee(idEmp);
            
            switch(resultado) {
                case 0:
                    javax.swing.JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
                    limpia();
                    llenaTblEmpleados("");
                    llenaComboJefes();
                    break;
                case 1: javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene cuenta activa (USERS)."); break;
                case 2: javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene historial de ventas (ORDERS)."); break;
                case 3: javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Tiene territorios asignados."); break;
                case 4: javax.swing.JOptionPane.showMessageDialog(this, "Denegado: Es jefe de otros empleados."); break;
                case -1: javax.swing.JOptionPane.showMessageDialog(this, "Error crítico de base de datos."); break;
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
    private javax.swing.JButton btnSalir;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
