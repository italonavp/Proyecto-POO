package UI;
import DAO.*;
import BEAN.*;
import UTIL.dbBean;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;

public class MDIPrincipal extends javax.swing.JFrame {
    private int wd;
    private int hd;
    FrmProducts formProd;
    FrmCustomer formCust;
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
        menuTrans = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        repProductsSimp = new javax.swing.JMenuItem();
        repProductsParam = new javax.swing.JMenuItem();
        repCustomersSimp = new javax.swing.JMenuItem();
        repCustomersParam = new javax.swing.JMenuItem();
        repEmployeesSimp = new javax.swing.JMenuItem();
        repEmployeesParam = new javax.swing.JMenuItem();
        repCategoriesSimp = new javax.swing.JMenuItem();
        repCategoriesParam = new javax.swing.JMenuItem();

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

        jMenuBar1.add(menuMant);

        menuTrans.setText("Transacciones");
        jMenuBar1.add(menuTrans);

        jMenu1.setText("Reportes");

        repProductsSimp.setText("Producto Simple");
        repProductsSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repProductsSimpActionPerformed(evt);
            }
        });
        jMenu1.add(repProductsSimp);

        repProductsParam.setText("Producto por rango");
        repProductsParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repProductsParamActionPerformed(evt);
            }
        });
        jMenu1.add(repProductsParam);

        repCustomersSimp.setText("Cliente Simple");
        repCustomersSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCustomersSimpActionPerformed(evt);
            }
        });
        jMenu1.add(repCustomersSimp);

        repCustomersParam.setText("Cliente por Region");
        repCustomersParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCustomersParamActionPerformed(evt);
            }
        });
        jMenu1.add(repCustomersParam);

        repEmployeesSimp.setText("Empleados Simple");
        repEmployeesSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repEmployeesSimpActionPerformed(evt);
            }
        });
        jMenu1.add(repEmployeesSimp);

        repEmployeesParam.setText("Empleados por ID");
        repEmployeesParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repEmployeesParamActionPerformed(evt);
            }
        });
        jMenu1.add(repEmployeesParam);

        repCategoriesSimp.setText("Categorías Simple");
        repCategoriesSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCategoriesSimpActionPerformed(evt);
            }
        });
        jMenu1.add(repCategoriesSimp);

        repCategoriesParam.setText("Categorías por ID");
        repCategoriesParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repCategoriesParamActionPerformed(evt);
            }
        });
        jMenu1.add(repCategoriesParam);

        jMenuBar1.add(jMenu1);

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
        // Instanciamos tu ventanita intermediaria
        UI.frmRepEmpParam ventanaParam = new UI.frmRepEmpParam();
        
        // La agregamos al panel principal
        this.escritorio.add(ventanaParam); 
        
        // La mostramos
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
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuMant;
    private javax.swing.JMenu menuTrans;
    private javax.swing.JMenuItem repCategoriesParam;
    private javax.swing.JMenuItem repCategoriesSimp;
    private javax.swing.JMenuItem repCustomersParam;
    private javax.swing.JMenuItem repCustomersSimp;
    private javax.swing.JMenuItem repEmployeesParam;
    private javax.swing.JMenuItem repEmployeesSimp;
    private javax.swing.JMenuItem repProductsParam;
    private javax.swing.JMenuItem repProductsSimp;
    private javax.swing.JMenuItem submenuCustomer;
    private javax.swing.JMenuItem submenuProducts;
    // End of variables declaration//GEN-END:variables
}
