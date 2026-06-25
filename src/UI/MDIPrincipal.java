package UI;
import DAO.*;
import BEAN.*;
import Markov.*;
import PRESENTACION.*;
import UTIL.dbBean;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRException;

public class MDIPrincipal extends javax.swing.JFrame {
    private int wd;
    private int hd;
    FrmProducts formProd;
    FrmCustomer formCust;
    FrmOrders formOrder;
    FrmSupplier formsupplier;
    FrmUsers formUsers;
    frmCategory formcategory;
    frmEmployee formemployee;
    frmRepProductsRango repRango;
    frmRepCustomersRegion repRegion;

    public MDIPrincipal() {
        initComponents();
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
        wd = dim.width;
        hd = dim.height;
        
        System.out.println("WD: "+wd);
        System.out.println("HD: "+hd);
        this.setSize(wd, hd);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMant = new javax.swing.JMenu();
        submenuProducts = new javax.swing.JMenuItem();
        submenuCustomer = new javax.swing.JMenuItem();
        menuSuppliers = new javax.swing.JMenuItem();
        menuUsers = new javax.swing.JMenuItem();
        menuCategories = new javax.swing.JMenuItem();
        menuEmployees = new javax.swing.JMenuItem();
        menuRegion = new javax.swing.JMenuItem();
        menuShippers = new javax.swing.JMenuItem();
        menuTrans = new javax.swing.JMenu();
        menuOrders = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        repProductsSimp = new javax.swing.JMenuItem();
        repProductsParam = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        repCustomersSimp = new javax.swing.JMenuItem();
        repCustomersParam = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        repEmployeesSimp = new javax.swing.JMenuItem();
        repEmployeesParam = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        repCategoriesSimp = new javax.swing.JMenuItem();
        repCategoriesParam = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        repUsersSimp = new javax.swing.JMenuItem();
        repUserParam = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        repSuppliersSimp = new javax.swing.JMenuItem();
        RepSuppParam = new javax.swing.JMenuItem();
        tablacruzada = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        menuMant.setText("Mantenimiento");

        submenuProducts.setText("Products");
        submenuProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuProductsActionPerformed(evt);
            }
        });
        menuMant.add(submenuProducts);

        submenuCustomer.setText("Customer");
        submenuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuCustomerActionPerformed(evt);
            }
        });
        menuMant.add(submenuCustomer);

        menuSuppliers.setText("Suppliers");
        menuSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSuppliersActionPerformed(evt);
            }
        });
        menuMant.add(menuSuppliers);

        menuUsers.setText("Users");
        menuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsersActionPerformed(evt);
            }
        });
        menuMant.add(menuUsers);

        menuCategories.setText("Categorias");
        menuCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriesActionPerformed(evt);
            }
        });
        menuMant.add(menuCategories);

        menuEmployees.setText("Empleados");
        menuEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeesActionPerformed(evt);
            }
        });
        menuMant.add(menuEmployees);

        menuRegion.setText("Region");
        menuRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegionActionPerformed(evt);
            }
        });
        menuMant.add(menuRegion);

        menuShippers.setText("Transportistas");
        menuShippers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuShippersActionPerformed(evt);
            }
        });
        menuMant.add(menuShippers);

        jMenuBar1.add(menuMant);

        menuTrans.setText("Transacciones");

        menuOrders.setText("Registro de Orden");
        menuOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrdersActionPerformed(evt);
            }
        });
        menuTrans.add(menuOrders);

        jMenuBar1.add(menuTrans);

        jMenu1.setText("Reportes");

        jMenu2.setText("Productos");

        repProductsSimp.setText("Producto Simple");
        repProductsSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repProductsSimpActionPerformed(evt);
            }
        });
        jMenu2.add(repProductsSimp);

        repProductsParam.setText("Producto por rango");
        repProductsParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repProductsParamActionPerformed(evt);
            }
        });
        jMenu2.add(repProductsParam);

        jMenu1.add(jMenu2);

        jMenu3.setText("Clientes");

        repCustomersSimp.setText("Cliente Simple");
        repCustomersSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCustomersSimpActionPerformed(evt);
            }
        });
        jMenu3.add(repCustomersSimp);

        repCustomersParam.setText("Cliente por Region");
        repCustomersParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCustomersParamActionPerformed(evt);
            }
        });
        jMenu3.add(repCustomersParam);

        jMenu1.add(jMenu3);

        jMenu4.setText("Empleados");

        repEmployeesSimp.setText("Empleados Simple");
        repEmployeesSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repEmployeesSimpActionPerformed(evt);
            }
        });
        jMenu4.add(repEmployeesSimp);

        repEmployeesParam.setText("Empleados por ID");
        repEmployeesParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repEmployeesParamActionPerformed(evt);
            }
        });
        jMenu4.add(repEmployeesParam);

        jMenu1.add(jMenu4);

        jMenu5.setText("Categorias");

        repCategoriesSimp.setText("Categorías Simple");
        repCategoriesSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCategoriesSimpActionPerformed(evt);
            }
        });
        jMenu5.add(repCategoriesSimp);

        repCategoriesParam.setText("Categorías por ID");
        repCategoriesParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCategoriesParamActionPerformed(evt);
            }
        });
        jMenu5.add(repCategoriesParam);

        jMenu1.add(jMenu5);

        jMenu6.setText("Users");

        repUsersSimp.setText("Usuarios Simple");
        repUsersSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repUsersSimpActionPerformed(evt);
            }
        });
        jMenu6.add(repUsersSimp);

        repUserParam.setText("Usuarios por estados");
        repUserParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repUserParamActionPerformed(evt);
            }
        });
        jMenu6.add(repUserParam);

        jMenu1.add(jMenu6);

        jMenu7.setText("Proovedor");

        repSuppliersSimp.setText("ProovedorSimple");
        repSuppliersSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repSuppliersSimpActionPerformed(evt);
            }
        });
        jMenu7.add(repSuppliersSimp);

        RepSuppParam.setText("Proovedor por Estado");
        RepSuppParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepSuppParamActionPerformed(evt);
            }
        });
        jMenu7.add(RepSuppParam);

        jMenu1.add(jMenu7);

        tablacruzada.setText("Ventas de empleado por categoria");
        tablacruzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablacruzadaActionPerformed(evt);
            }
        });
        jMenu1.add(tablacruzada);

        jMenu8.setText("Orden");

        jMenuItem1.setText("Orden por ID");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenu1.add(jMenu8);

        jMenuBar1.add(jMenu1);

        jMenu9.setText("Modelo Predictivo");

        jMenuItem2.setText("Markov");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem2);

        jMenuItem3.setText("Arboles de Decision");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem3);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuProductsActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formProd = new FrmProducts(h, w);
        escritorio.add(formProd);
        formProd.setVisible(true);
        formProd.setSize(1100, 600);
        
        
    }//GEN-LAST:event_submenuProductsActionPerformed

    private void repProductsSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repProductsSimpActionPerformed
        try{
            String r = "src/REPORTS/repProductsSimp.jasper";
            dbBean con = new dbBean();
            con.connectRep(r, null, false);
        }catch(java.sql.SQLException e){
        e.printStackTrace();
         }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_repProductsSimpActionPerformed

    private void repProductsParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repProductsParamActionPerformed
       repRango = new frmRepProductsRango(this.dimH(),this.dimW());
       this.escritorio.add(repRango);
       repRango.setVisible(true);
       repRango.setSize(675,195);
    }//GEN-LAST:event_repProductsParamActionPerformed

    private void submenuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuCustomerActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formCust = new FrmCustomer(w, h);
        escritorio.add(formCust);
        formCust.setVisible(true);
        formCust.setSize(1200, 675);
    }//GEN-LAST:event_submenuCustomerActionPerformed

    private void repCustomersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCustomersSimpActionPerformed
        try{
            String r = "src/REPORTS/repCustomers.jasper";
            dbBean con = new dbBean();
            con.connectRep(r, null, false);
        }catch(java.sql.SQLException e){
        e.printStackTrace();
         }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_repCustomersSimpActionPerformed

    private void repCustomersParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCustomersParamActionPerformed
       repRegion = new frmRepCustomersRegion(this.dimH(),this.dimW());
       this.escritorio.add(repRegion);
       repRegion.setVisible(true);
       repRegion.setSize(675,195);
    }//GEN-LAST:event_repCustomersParamActionPerformed

    private void repEmployeesParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repEmployeesParamActionPerformed
        UI.frmRepEmpParam ventanaParam = new UI.frmRepEmpParam();
        this.escritorio.add(ventanaParam); 
        ventanaParam.setVisible(true);
    }//GEN-LAST:event_repEmployeesParamActionPerformed

    private void repEmployeesSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repEmployeesSimpActionPerformed
        try{
            String r = "src/REPORTS/repEmployeesSimp.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_repEmployeesSimpActionPerformed

    private void repCategoriesSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCategoriesSimpActionPerformed
        try{
            String r = "src/REPORTS/repCategoriesSimp.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_repCategoriesSimpActionPerformed

    private void repCategoriesParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCategoriesParamActionPerformed
        UI.frmRepCatParam ventanaCat = new UI.frmRepCatParam();
        this.escritorio.add(ventanaCat);
        ventanaCat.setVisible(true);
    }//GEN-LAST:event_repCategoriesParamActionPerformed

    private void menuOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrdersActionPerformed
      int w,h;
        
        w = dimW();
        h = dimH();
        
        formOrder = new FrmOrders(w, h);
        escritorio.add(formOrder);
        formOrder.setVisible(true);
        formOrder.setSize(1000, 685);
    }//GEN-LAST:event_menuOrdersActionPerformed

    private void menuSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSuppliersActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formsupplier = new FrmSupplier(w, h);
        escritorio.add(formsupplier);
        formsupplier.setVisible(true);
        formsupplier.setSize(1200, 739);
    }//GEN-LAST:event_menuSuppliersActionPerformed

    private void menuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsersActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formUsers = new FrmUsers(w, h);
        escritorio.add(formUsers);
        formUsers.setVisible(true);
        formUsers.setSize(900, 450);
    }//GEN-LAST:event_menuUsersActionPerformed

    private void menuCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriesActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formcategory = new frmCategory(w, h);
        escritorio.add(formcategory);
        formcategory.setVisible(true);
    }//GEN-LAST:event_menuCategoriesActionPerformed

    private void menuEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeesActionPerformed
        int w,h;
        
        w = dimW();
        h = dimH();
        
        formemployee = new frmEmployee(w, h);
        escritorio.add(formemployee);
        formemployee.setVisible(true);
    }//GEN-LAST:event_menuEmployeesActionPerformed

    private void repUsersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repUsersSimpActionPerformed
        try{
            String r = "src/REPORTS/repUsersSimp.jasper";
            dbBean con = new dbBean();
            con.connectRep(r, null, false);
        }catch(java.sql.SQLException e){
        e.printStackTrace();
         }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_repUsersSimpActionPerformed

    private void repSuppliersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repSuppliersSimpActionPerformed
        try{
            String r = "src/REPORTS/repSuppliersSimp.jasper";
            dbBean con = new dbBean();
            con.connectRep(r, null, false);
        }catch(java.sql.SQLException e){
        e.printStackTrace();
         }catch(JRException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_repSuppliersSimpActionPerformed

    private void RepSuppParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepSuppParamActionPerformed
        frmRepSuppParam ventanaSupp = new frmRepSuppParam();
        this.escritorio.add(ventanaSupp);
        ventanaSupp.setVisible(true);
    }//GEN-LAST:event_RepSuppParamActionPerformed

    private void repUserParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repUserParamActionPerformed
        FrmRepUserParam ventanaUsers = new FrmRepUserParam(hd, wd);
        this.escritorio.add(ventanaUsers);
        ventanaUsers.setVisible(true);
    }//GEN-LAST:event_repUserParamActionPerformed

    private void menuRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegionActionPerformed
        abrirRegion();
    }//GEN-LAST:event_menuRegionActionPerformed

    private void menuShippersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuShippersActionPerformed
        abrirShippers();
    }//GEN-LAST:event_menuShippersActionPerformed

    private void tablacruzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablacruzadaActionPerformed
        try {
            // 1. La ruta exacta de tu nuevo reporte compilado
            String ruta = "src/REPORTS/repTablaCruzada.jasper";

            // 2. Instanciamos tu clase de conexión
            UTIL.dbBean db = new UTIL.dbBean();

            // 3. ¡La magia directa!
            // Mandamos null en el mapa y FALSE porque este reporte NO usa parámetros ($P{})
            db.connectRep(ruta, null, false);

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar la matriz analítica: " + ex.getMessage());
        }
    }//GEN-LAST:event_tablacruzadaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRepOrdersParam ventanaOrders = new FrmRepOrdersParam();
        this.escritorio.add(ventanaOrders);
        ventanaOrders.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FormMarkov ventamaMarkov = new FormMarkov();
        this.escritorio.add(ventamaMarkov);
        ventamaMarkov.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ReporteGrafico dashboard = PRESENTACION.Main.generarDashboard();
            this.escritorio.add(dashboard);
            try {
                    dashboard.setMaximum(true);
                } catch (java.beans.PropertyVetoException e) {
                  // si falla no se hace nada
                }
            dashboard.setVisible(true);
            
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void abrirRegion() {
        FrmRegion formRegion = new FrmRegion();
        abrirFormulario(formRegion);
    }
    
    private void abrirShippers() {
        FrmShippers formShippers = new FrmShippers();
        abrirFormulario(formShippers);
    }
    
    private void abrirFormulario(JInternalFrame formulario) {
        escritorio.add(formulario);
        formulario.setVisible(true);
        try {
            formulario.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    int dimW(){
        return wd;
    }
    int dimH(){
        return hd;
    }
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
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem RepSuppParam;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuCategories;
    private javax.swing.JMenuItem menuEmployees;
    private javax.swing.JMenu menuMant;
    private javax.swing.JMenuItem menuOrders;
    private javax.swing.JMenuItem menuRegion;
    private javax.swing.JMenuItem menuShippers;
    private javax.swing.JMenuItem menuSuppliers;
    private javax.swing.JMenu menuTrans;
    private javax.swing.JMenuItem menuUsers;
    private javax.swing.JMenuItem repCategoriesParam;
    private javax.swing.JMenuItem repCategoriesSimp;
    private javax.swing.JMenuItem repCustomersParam;
    private javax.swing.JMenuItem repCustomersSimp;
    private javax.swing.JMenuItem repEmployeesParam;
    private javax.swing.JMenuItem repEmployeesSimp;
    private javax.swing.JMenuItem repProductsParam;
    private javax.swing.JMenuItem repProductsSimp;
    private javax.swing.JMenuItem repSuppliersSimp;
    private javax.swing.JMenuItem repUserParam;
    private javax.swing.JMenuItem repUsersSimp;
    private javax.swing.JMenuItem submenuCustomer;
    private javax.swing.JMenuItem submenuProducts;
    private javax.swing.JMenuItem tablacruzada;
    // End of variables declaration//GEN-END:variables
}
