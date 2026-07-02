package UI;

import BEAN.*;
import UTIL.*;
import DAO.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import net.sf.jasperreports.engine.JRException;

public class FrmOrders extends javax.swing.JInternalFrame {

    Vector<Employee> listaEmployee;
    Vector<Shippers> listaShippers;
    DefaultTableModel dtm;
    DefaultTableModel dtmDetalles;
    DefaultTableModel dtmHistorial;
    int orderId;

    public FrmOrders(int mdiW, int mdiH, String empleado) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;

        this.jdOrderDate.setDate(new java.util.Date());
        this.setSize(1200, 675);
        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        cargaEmpleado();
        cargaShippers();
        dtm = (DefaultTableModel) this.tblOrderDetails.getModel();
        dtmDetalles = (DefaultTableModel) this.tblOrderDetailss.getModel();
        dtmHistorial = (DefaultTableModel) this.tblOrderDetailss.getModel();

        ((AbstractDocument) txtShipAdress.getDocument())
                .setDocumentFilter(new LimiteCaracteres(60));

        ((AbstractDocument) txtShipCity.getDocument())
                .setDocumentFilter(new LimiteCaracteres(15));

        ((AbstractDocument) txtShipRegion.getDocument())
                .setDocumentFilter(new LimiteCaracteres(15));

        ((AbstractDocument) txtShipAdress1.getDocument())
                .setDocumentFilter(new LimiteCaracteres(10));

        ((AbstractDocument) txtShipCountry.getDocument())
                .setDocumentFilter(new LimiteCaracteres(15));

        cmbEmployee.setSelectedItem(empleado);
        cmbEmployee.setEnabled(false);
    }

    public void llenaTablaOrdenes(String filtro) {
        DefaultTableModel dtmOrdenes = (DefaultTableModel) this.tblOrderss.getModel();
        dtmOrdenes.setRowCount(0);

        OrderDAO ordDao = new OrderDAO();
        Vector<Order> listaHistorial = ordDao.listaOrders(filtro);

        for (int i = 0; i < listaHistorial.size(); i++) {
            Vector vec = new Vector();
            vec.addElement(listaHistorial.get(i).getOrderID());
            vec.addElement(listaHistorial.get(i).getCustomerID());
            vec.addElement(listaHistorial.get(i).getEmployeeID());
            vec.addElement(listaHistorial.get(i).getOrderDate());
            vec.addElement(listaHistorial.get(i).getRequiredDate());
            vec.addElement(listaHistorial.get(i).getShippedDate());
            vec.addElement(listaHistorial.get(i).getShipVia());
            vec.addElement(listaHistorial.get(i).getFreight());
            vec.addElement(listaHistorial.get(i).getShipName());
            vec.addElement(listaHistorial.get(i).getShipCity());
            vec.addElement(listaHistorial.get(i).getShipRegion());
            vec.addElement(listaHistorial.get(i).getShipPostalCode());
            vec.addElement(listaHistorial.get(i).getShipCountry());

            dtmOrdenes.addRow(vec);
        }
    }

    public void cargaEmpleado() {

        EmployeeDAO employeeDao = new EmployeeDAO();
        listaEmployee = employeeDao.listaEmployees("");
        this.cmbEmployee.removeAllItems();
        this.cmbEmployee.addItem("");
        for (int i = 0; i < listaEmployee.size(); i++) {
            this.cmbEmployee.addItem(listaEmployee.get(i).getFirstName() + " " + listaEmployee.get(i).getLastName());
        }
    }

    public void cargaShippers() {

        ShippersDAO shippersDao = new ShippersDAO();
        listaShippers = shippersDao.listaShippers("");
        this.cmbShipVia.removeAllItems();
        this.cmbShipVia.addItem("");
        for (int i = 0; i < listaShippers.size(); i++) {
            this.cmbShipVia.addItem(listaShippers.get(i).getCompanyName());
        }
    }

    public void llenaTablaDetalles(String idOrden) {

        dtmDetalles.setRowCount(0); // Usamos la variable global

        OrderDetailDAO detDao = new OrderDetailDAO();
        Vector<OrderDetail> listaDetalles = detDao.listaOrderDetails(idOrden);

        for (int i = 0; i < listaDetalles.size(); i++) {
            Vector vec = new Vector();
            vec.addElement(listaDetalles.get(i).getProductID());
            vec.addElement(listaDetalles.get(i).getProductName());
            vec.addElement(listaDetalles.get(i).getUnitPrice());
            vec.addElement(listaDetalles.get(i).getQuantity());
            vec.addElement(listaDetalles.get(i).getDiscount());

            dtmDetalles.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        cmbEmployee = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbShipVia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jdOrderDate = new com.toedter.calendar.JDateChooser();
        jdRequiredDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtFreight = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtShipAdress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtShipCity = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtShipCountry = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtShipAdress1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jdShippedDate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        txtShipRegion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        txtUnitPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDetails = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtBusquedaCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderss = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrderDetailss = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(930, 610));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de la Orden"));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 140));

        jLabel2.setText("ID CLIENTE");

        jLabel3.setText("EMPLEADO");

        txtCustomerID.setEnabled(false);
        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("DESTINATARIO");

        txtCompanyName.setEnabled(false);

        cmbEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("ENVIADO POR");

        cmbShipVia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("FECHA DE ORDEN");

        jLabel7.setText("FECHA REQUERIDA");

        jLabel8.setText("FLETE");

        jLabel13.setText("DIRECCION");

        txtShipAdress.setEnabled(false);

        jLabel14.setText("CIUDAD");

        txtShipCity.setEnabled(false);

        jLabel15.setText("PAIS");

        txtShipCountry.setEnabled(false);
        txtShipCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShipCountryActionPerformed(evt);
            }
        });

        jLabel16.setText("CODIGO POSTAL");

        txtShipAdress1.setEnabled(false);

        jLabel17.setText("FECHA ENVIO");

        jLabel18.setText("REGION ");

        txtShipRegion.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShipCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtShipCity, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente))
                    .addComponent(txtShipRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbShipVia, 0, 111, Short.MAX_VALUE)
                    .addComponent(txtShipAdress)
                    .addComponent(txtShipAdress1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtFreight, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdShippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtShipCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtShipCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtShipRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jdOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbShipVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtShipAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdShippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtShipAdress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(txtFreight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE ORDEN");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del Producto"));
        jPanel4.setPreferredSize(new java.awt.Dimension(900, 120));

        jLabel9.setText("ID PRODUCTO");

        txtProductID.setEnabled(false);

        btnBuscarProducto.setText("Buscar producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        txtUnitPrice.setEnabled(false);

        jLabel10.setText("PRECIO");

        jLabel11.setText("CANTIDAD");

        txtProductName.setEnabled(false);

        jLabel12.setText("DESCRIPCION");

        btnAgregar.setText("Agregar al carrito");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel19.setText("DESCUENTO");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel21.setText("ejemplo: 15% = 0.15");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarProducto)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de la Orden"));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 220));
        jPanel5.setLayout(null);

        tblOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Descripcion", "Precio", "Cantidad", "Descuento"
            }
        ));
        jScrollPane1.setViewportView(tblOrderDetails);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 880, 190);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar)
                .addGap(233, 233, 233)
                .addComponent(btnLimpiar)
                .addGap(271, 271, 271))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar))
                .addGap(6, 6, 6))
        );

        jPanel5.getAccessibleContext().setAccessibleName("Datos de la Orden");

        jTabbedPane1.addTab("Registro de venta", jPanel1);

        jLabel20.setText("Nombre de Cliente");

        txtBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaClienteActionPerformed(evt);
            }
        });
        txtBusquedaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaClienteKeyReleased(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial de Ordenes"));
        jPanel6.setLayout(null);

        tblOrderss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ClienteID", "EmpleadoID", "FechOrden", "FechRequerid", "FechEnvio", "via Envio", "Flete", "Destinatario", "CiudadDest", "RegionDest", "CodigoPostal", "PaisDestino"
            }
        ));
        tblOrderss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderssMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrderss);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(10, 20, 910, 220);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de la Orden"));
        jPanel7.setPreferredSize(new java.awt.Dimension(900, 220));
        jPanel7.setLayout(null);

        tblOrderDetailss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Descripcion", "Precio", "Cantidad", "Descuento"
            }
        ));
        tblOrderDetailss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderDetailssMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOrderDetailss);

        jPanel7.add(jScrollPane3);
        jScrollPane3.setBounds(10, 20, 880, 190);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalida.setText("Salir");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(btnEliminar)
                .addGap(116, 116, 116)
                .addComponent(btnSalida)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Búsqueda de órdenes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtShipCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShipCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShipCountryActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (valida() == true) {
            try {
                Util u = new Util();
                Order order = new Order();

                int orderId = u.idNext("Orders", "OrderID");
                order.setOrderID(orderId);

                order.setCustomerID(this.txtCustomerID.getText());

                int posemp = this.cmbEmployee.getSelectedIndex() - 1;
                order.setEmployeeID(listaEmployee.get(posemp).getEmployeeID());

                int posship = this.cmbShipVia.getSelectedIndex() - 1;
                order.setShipVia(listaShippers.get(posship).getIdShippers());

                if (this.jdOrderDate.getDate() != null) {
                    order.setOrderDate(new java.sql.Date(this.jdOrderDate.getDate().getTime()));
                }

                if (this.jdRequiredDate.getDate() != null) {
                    order.setRequiredDate(new java.sql.Date(this.jdRequiredDate.getDate().getTime()));
                }
                if (this.jdShippedDate.getDate() != null) {
                    order.setShippedDate(new java.sql.Date(this.jdShippedDate.getDate().getTime()));
                }

                order.setFreight(Double.parseDouble(this.txtFreight.getText()));
                order.setShipName(this.txtCompanyName.getText());
                order.setShipAdress(this.txtShipAdress.getText());
                order.setShipCity(this.txtShipCity.getText());
                order.setShipRegion(this.txtShipRegion.getText());
                order.setShipPostalCode(this.txtShipAdress1.getText());
                order.setShipCountry(this.txtShipCountry.getText());

                OrderDAO orderDao = new OrderDAO();
                orderDao.procesaOrder(order, "insert");

                OrderDetailDAO detailDao = new OrderDetailDAO();

                // Recorremos la tabla visual fila por fila
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    OrderDetail det = new OrderDetail();

                    det.setOrderID(orderId);
                    det.setProductID(Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    det.setUnitPrice(Double.parseDouble(dtm.getValueAt(i, 2).toString()));
                    det.setQuantity(Integer.parseInt(dtm.getValueAt(i, 3).toString()));
                    det.setDiscount(Double.parseDouble(dtm.getValueAt(i, 4).toString()));

                    detailDao.procesaOrderDetail(det, "insert");
                }
                JOptionPane.showMessageDialog(this, "¡Éxito! La Orden #" + orderId + " ha sido registrada.");
                limpiarTodo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error crítico al grabar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        selCliente dialogcliente = new selCliente(new javax.swing.JFrame(), true);
        dialogcliente.setVisible(true);
        Customer cust = dialogcliente.getCliente();

        if (cust.getCustomerID() != null) {
            this.txtCustomerID.setText(cust.getCustomerID());
            this.txtCompanyName.setText(cust.getCompanyName());
            this.txtShipAdress.setText(cust.getAddress());
            this.txtShipCity.setText(cust.getCity());
            this.txtShipCountry.setText(cust.getCountry());
            this.txtShipRegion.setText(cust.getRegion());
            this.txtShipAdress1.setText(cust.getPostalCode());
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        SelProducts dialogProducts = new SelProducts(new javax.swing.JFrame(), true);
        dialogProducts.setVisible(true);
        Product prod = dialogProducts.getProduct();

        if (prod != null) {
            this.txtProductID.setText(String.valueOf(prod.getProductID()));
            this.txtProductName.setText(prod.getProductName());
            this.txtUnitPrice.setText(String.valueOf(prod.getUnitPrice()));
            this.txtQuantity.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (this.txtProductID.getText().isEmpty() || this.txtQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar producto o cantidad");
        } else {
            Vector vec = new Vector();
            vec.addElement(this.txtProductID.getText());
            vec.addElement(this.txtProductName.getText());
            vec.addElement(this.txtUnitPrice.getText());
            vec.addElement(this.txtQuantity.getText());
            if (this.txtDiscount.getText().isEmpty()) {
                this.txtDiscount.setText("0");
            }
            vec.addElement(this.txtDiscount.getText());
            dtm.addRow(vec);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTodo();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        selCliente dialogcliente = new selCliente(new javax.swing.JFrame(), true);
        dialogcliente.setVisible(true);
        Customer cust = dialogcliente.getCliente();

        if (cust.getCustomerID() != null) {
            this.txtBusquedaCliente.setText(cust.getCompanyName());
        }
        this.llenaTablaOrdenes(cust.getCustomerID());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBusquedaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaClienteActionPerformed

    private void tblOrderssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderssMouseClicked
        int fila = this.tblOrderss.getSelectedRow();
        if (fila != -1) {
            String orderId = this.tblOrderss.getValueAt(fila, 0).toString();
            llenaTablaDetalles(orderId);
        } else {

            dtmDetalles.setRowCount(0);
        }
    }//GEN-LAST:event_tblOrderssMouseClicked

    private void tblOrderDetailssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderDetailssMouseClicked

    }//GEN-LAST:event_tblOrderDetailssMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String msj;
        Order order = new Order();
        int fila = this.tblOrderss.getSelectedRow();
        int idOrden = Integer.parseInt(this.tblOrderss.getValueAt(fila, 0).toString());
        order.setOrderID(idOrden);
        OrderDAO orderDao = new OrderDAO();
        orderDao.procesaOrder(order, "delete");
        JOptionPane.showMessageDialog(this, "¡La Orden #" + idOrden + " ha sido eliminada con éxito");
        llenaTablaOrdenes(this.txtBusquedaCliente.getText());
        dtmDetalles.setRowCount(0);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBusquedaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaClienteKeyReleased
        this.llenaTablaOrdenes(this.txtBusquedaCliente.getText());
    }//GEN-LAST:event_txtBusquedaClienteKeyReleased

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    public void limpiarProducto() {
        this.txtProductID.setText("");
        this.txtProductName.setText("");
        this.txtUnitPrice.setText("");
        this.txtQuantity.setText("");
        this.txtDiscount.setText("");
    }

    public boolean valida() {
        String cad = "";
        if (this.txtCustomerID.getText().isEmpty()) {
            cad += "Seleccione un Cliente";
        }
        if (this.txtProductID.getText().isEmpty()) {
            cad += "\nSeleccione un producto";
        }
        if (this.txtQuantity.getText().isEmpty()) {
            cad += "\nIngrese la cantidad";
        }
        if (this.cmbEmployee.getSelectedItem().equals("")) {
            cad += "\nSeleccione el empleado encargado de esta orden";
        }
        if (this.cmbShipVia.getSelectedItem().equals("")) {
            cad += "\nSeleccione la compañia de envio encargada de esta orden";
        }
        if (this.jdOrderDate.getDate() == null) {
            cad += "\nSeleccione la fecha de la orden";
        }
        if (this.jdRequiredDate.getDate() == null) {
            cad += "\nSeleccione la fecha requerida ";
        }
        if (this.txtFreight.getText().isEmpty()) {
            cad += "\nIngrese el flete";
        }
        if (this.tblOrderDetails.getRowCount() == 0) {
            cad += "\nDebe agregar al menos un producto al carrito.";
        }
        if (cad.equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }

    }

    public void limpiarTodo() {
        this.txtCustomerID.setText("");
        this.txtCompanyName.setText("");
        this.cmbEmployee.setSelectedIndex(0);
        this.cmbShipVia.setSelectedIndex(0);
        this.jdOrderDate.setDate(null);
        this.jdRequiredDate.setDate(null);
        this.jdShippedDate.setDate(null);
        this.txtFreight.setText("");
        this.txtShipAdress.setText("");
        this.txtShipCity.setText("");
        this.txtShipRegion.setText("");
        this.txtShipAdress1.setText("");
        this.txtShipCountry.setText("");

        limpiarProducto();
        dtm.setRowCount(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalida;
    private javax.swing.JComboBox<String> cmbEmployee;
    private javax.swing.JComboBox<String> cmbShipVia;
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
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdOrderDate;
    private com.toedter.calendar.JDateChooser jdRequiredDate;
    private com.toedter.calendar.JDateChooser jdShippedDate;
    private javax.swing.JTable tblOrderDetails;
    private javax.swing.JTable tblOrderDetailss;
    private javax.swing.JTable tblOrderss;
    private javax.swing.JTextField txtBusquedaCliente;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtFreight;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtShipAdress;
    private javax.swing.JTextField txtShipAdress1;
    private javax.swing.JTextField txtShipCity;
    private javax.swing.JTextField txtShipCountry;
    private javax.swing.JTextField txtShipRegion;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
