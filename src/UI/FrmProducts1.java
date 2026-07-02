package UI;

import BEAN.*;
import UTIL.*;
import DAO.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import net.sf.jasperreports.engine.JRException;

public class FrmProducts1 extends javax.swing.JInternalFrame {

    ProductDAO productDao;
    DefaultTableModel dtm;
    int idProduct;
    Vector<Supplier> listaSupplier;
    Vector<Category> listaCategory;

    public FrmProducts1(int mdiW, int mdiH) {
        initComponents();
        int slx, sly, wd = mdiW, hd = mdiH;

        this.setSize(1100, 600);
        slx = (mdiW / 2) - (this.getWidth() / 2);
        sly = (mdiH / 2) - (this.getHeight() / 2);
        this.setLocation(slx, sly);
        this.setResizable(false);
        productDao = new ProductDAO();
        dtm = (DefaultTableModel) this.tblProducts.getModel();
        cargaSupplier();
        cargaCategory();
        llenaProducts("");
        ((AbstractDocument) txtProductName.getDocument())
                .setDocumentFilter(new LimiteCaracteres(40));

        ((AbstractDocument) txtQuantityPerUnit.getDocument())
                .setDocumentFilter(new LimiteCaracteres(20));
    }

    public void llenaProducts(String cad) {
        Vector<Product> listProduct;
        listProduct = productDao.listaProducts(cad);
        dtm.setRowCount(0);
        for (int i = 0; i < listProduct.size(); i++) {
            Vector vec = new Vector();
            vec.addElement(listProduct.get(i).getProductID());
            vec.addElement(listProduct.get(i).getProductName());
            vec.addElement(listProduct.get(i).getSupplierID());
            vec.addElement(listProduct.get(i).getCategoryID());
            vec.addElement(listProduct.get(i).getQuantityPerUnit());
            vec.addElement(listProduct.get(i).getUnitPrice());
            vec.addElement(listProduct.get(i).getUnitsInStock());
            vec.addElement(listProduct.get(i).getUnitsOnOrder());
            vec.addElement(listProduct.get(i).getReorderLevel());
            vec.addElement(listProduct.get(i).getDiscontinued());
            dtm.addRow(vec);
        }
    }

    public void cargaSupplier() {

        SupplierDAO supplierDao = new SupplierDAO();
        listaSupplier = supplierDao.listaSuppliers("");
        this.cmbSupplierID.removeAllItems();
        this.cmbSupplierID.addItem("");
        for (int i = 0; i < listaSupplier.size(); i++) {
            this.cmbSupplierID.addItem(listaSupplier.get(i).getCompanyName());
        }

    }

    public void cargaCategory() {

        CategoryDAO categoryDao = new CategoryDAO();
        listaCategory = categoryDao.listaCategories("");
        this.cmbCategoryID.removeAllItems();
        this.cmbCategoryID.addItem("");
        for (int i = 0; i < listaCategory.size(); i++) {
            this.cmbCategoryID.addItem(listaCategory.get(i).getCategoryName());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbSupplierID = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoryID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtQuantityPerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUnitsInStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtUnitsOnOrder = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtReorderLevel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rbActivo = new javax.swing.JRadioButton();
        rbDescontinuado = new javax.swing.JRadioButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Productos");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ID Producto");

        txtProductID.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre Producto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("ID Proovedor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID Categoria");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cantidad por Unidad");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Precio Unitario");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Unidad en Stock");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Unidades en Orden");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Reorder Level");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Descontinuado");

        buttonGroup1.add(rbActivo);
        rbActivo.setText("Activo");

        buttonGroup1.add(rbDescontinuado);
        rbDescontinuado.setText("Descontinuado");
        rbDescontinuado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescontinuadoActionPerformed(evt);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btnGrabar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoryID, 0, 165, Short.MAX_VALUE)
                            .addComponent(cmbSupplierID, 0, 165, Short.MAX_VALUE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtQuantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(rbActivo)
                        .addGap(18, 18, 18)
                        .addComponent(rbDescontinuado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(95, 95, 95)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUnitsOnOrder))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(38, 38, 38)
                                    .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnitsInStock, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(199, 313, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnitsInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtUnitsOnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtQuantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbActivo)
                            .addComponent(rbDescontinuado))))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGrabar))
                .addGap(55, 55, 55))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Buscar");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(11, 14, 35, 15);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(50, 10, 930, 20);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Producto", "ID Proovedor", "ID Categoria", "Cant por unidad", "Precio unitario", "Stock", "Unidades pedidas", "Reorder Level", "Descontinuado"
            }
        ));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 980, 300);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.llenaProducts(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (valida() == true) {
            String msj;
            Product prod = new Product();
            prod.setProductID(idProduct);
            this.productDao.eliminaProduct(prod);
            msj = "Producto eliminado con exito";
            this.llenaProducts("");
            JOptionPane.showMessageDialog(this, msj);
            limpia();
            this.btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int idFil;
        idFil = this.tblProducts.getSelectedRow();
        this.idProduct = Integer.parseInt(dtm.getValueAt(idFil, 0).toString());
        this.txtProductID.setText(dtm.getValueAt(idFil, 0).toString());
        this.txtProductName.setText(dtm.getValueAt(idFil, 1).toString());
        int idSupplier = Integer.parseInt(dtm.getValueAt(idFil, 2).toString());
        int idCategory = Integer.parseInt(dtm.getValueAt(idFil, 3).toString());
        this.txtQuantityPerUnit.setText(dtm.getValueAt(idFil, 4).toString());
        this.txtUnitPrice.setText(dtm.getValueAt(idFil, 5).toString());
        this.txtUnitsInStock.setText(dtm.getValueAt(idFil, 6).toString());
        this.txtUnitsOnOrder.setText(dtm.getValueAt(idFil, 7).toString());
        this.txtReorderLevel.setText(dtm.getValueAt(idFil, 8).toString());
        this.txtReorderLevel.setText(dtm.getValueAt(idFil, 8).toString());
        String descontinuado = dtm.getValueAt(idFil, 9).toString();

        if (descontinuado.equalsIgnoreCase("true") || descontinuado.equals("1")) {
            this.rbDescontinuado.setSelected(true);
        } else {
            this.rbActivo.setSelected(true);
        }

        for (int i = 0; i < listaSupplier.size(); i++) {
            if (listaSupplier.get(i).getSupplierID() == idSupplier) {
                this.cmbSupplierID.setSelectedIndex(i + 1);
                break;
            }
        }

        for (int i = 0; i < listaCategory.size(); i++) {
            if (listaCategory.get(i).getCategoryID() == idCategory) {
                this.cmbCategoryID.setSelectedIndex(i + 1);
                break;
            }
        }

        this.btnEliminar.setEnabled(true);
        this.btnGrabar.setText("Actualizar");
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_tblProductsMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (valida() == true) {
            String msj;
            Product prod = new Product();
            Util u = new Util();
            int indiceSupplier = this.cmbSupplierID.getSelectedIndex();
            int indiceCategory = this.cmbCategoryID.getSelectedIndex();
            prod.setProductName(this.txtProductName.getText());
            prod.setSupplierID(listaSupplier.get(indiceSupplier).getSupplierID());
            prod.setCategoryID(listaCategory.get(indiceCategory).getCategoryID());
            prod.setQuantityPerUnit(this.txtQuantityPerUnit.getText());
            prod.setUnitPrice(Double.parseDouble(this.txtUnitPrice.getText()));
            prod.setUnitsInStock(Integer.parseInt(this.txtUnitsInStock.getText()));
            prod.setUnitsOnOrder(Integer.parseInt(this.txtUnitsOnOrder.getText()));
            prod.setReorderLevel(Integer.parseInt(this.txtReorderLevel.getText()));
            prod.setDiscontinued(this.rbDescontinuado.isSelected());

            if (this.btnGrabar.getText().equals("Grabar")) {
                this.idProduct = u.idNext("Products", "ProductID");
                prod.setProductID(idProduct);
                this.productDao.insertaProduct(prod);
                msj = "Producto añadido con exito";

            } else {
                prod.setProductID(idProduct);
                this.productDao.actualizaProduct(prod);
                msj = "Producto actualizado con exito";
            }
            this.llenaProducts("");
            JOptionPane.showMessageDialog(this, msj);
            limpia();

        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void rbDescontinuadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescontinuadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDescontinuadoActionPerformed

    public void limpia() {
        this.txtProductID.setText("");
        this.txtProductName.setText("");
        this.cmbSupplierID.setSelectedIndex(0);
        this.cmbCategoryID.setSelectedIndex(0);
        this.txtQuantityPerUnit.setText("");
        this.txtUnitPrice.setText("");
        this.txtUnitsInStock.setText("");
        this.txtUnitsOnOrder.setText("");
        this.txtReorderLevel.setText("");
        this.rbActivo.setSelected(true);
        this.btnEliminar.setEnabled(false);
        this.btnGrabar.setText("Grabar");
    }

    public boolean valida() {
        String cad = "";

        if (this.txtProductName.getText().isEmpty()) {
            cad += "\n ingrese el nombre del producto";
        }
        if (this.cmbSupplierID.getSelectedIndex() == -1) {
            cad += "\n ingrese Proovedor";
        }
        if (this.cmbCategoryID.getSelectedIndex() == -1) {
            cad += "\n ingrese categoria";
        }
        if (this.txtQuantityPerUnit.getText().isEmpty()) {
            cad += "\n ingrese la cantidad por unidad";
        }
        if (this.txtUnitPrice.getText().isEmpty()) {
            cad += "\n ingrese el precio unitario";
        }
        if (this.txtUnitsInStock.getText().isEmpty()) {
            cad += "\n ingrese el stock";
        }
        if (this.txtUnitsOnOrder.getText().isEmpty()) {
            cad += "\n ingrese las unidades pendientes de recibir";
        }
        if (this.txtReorderLevel.getText().isEmpty()) {
            cad += "\n ingrese el limite para reordenar";
        }

        if (cad.isEmpty()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, cad);
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategoryID;
    private javax.swing.JComboBox<String> cmbSupplierID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbDescontinuado;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantityPerUnit;
    private javax.swing.JTextField txtReorderLevel;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtUnitsInStock;
    private javax.swing.JTextField txtUnitsOnOrder;
    // End of variables declaration//GEN-END:variables
}
