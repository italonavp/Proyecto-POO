package UI;

import DAO.*;
import BEAN.*;
import Markov.*;
import PRESENTACION.*;
import UTIL.MailUtil;
import UTIL.dbBean;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.sf.jasperreports.engine.JRException;

public class MDIPrincipal extends javax.swing.JFrame {

    private int wd;
    private int hd;
    private String titulo;
    FrmProducts1 formProd;
    FrmCustmers2 formCust;
    FrmOrders formOrder;
    FrmSupplier formsupplier;
    FrmUsers formUsers;
    frmCategory formcategory;
    frmEmployee formemployee;
    frmRepProductsRango repRango;
    frmRepCustomersRegion repRegion;

    public MDIPrincipal(String titulo) {
        initComponents();
        this.titulo = titulo;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        wd = dim.width;
        hd = dim.height;
        this.setSize(wd, hd);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Sistema Northwind — " + titulo);
        aplicarPermisosPorTitulo();
    }

    public MDIPrincipal() {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        wd = dim.width;
        hd = dim.height;

        System.out.println("WD: " + wd);
        System.out.println("HD: " + hd);
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
        menuTerritories = new javax.swing.JMenuItem();
        menuTrans = new javax.swing.JMenu();
        menuOrders = new javax.swing.JMenuItem();
        tablacruzada = new javax.swing.JMenuItem();
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
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        repRegionSimp = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        repTerritoriesSimp = new javax.swing.JMenuItem();
        repTerritoriesParam = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        repShippersSimp = new javax.swing.JMenuItem();
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
            .addGap(0, 281, Short.MAX_VALUE)
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

        menuTerritories.setText("Territorios");
        menuTerritories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTerritoriesActionPerformed(evt);
            }
        });
        menuMant.add(menuTerritories);

        jMenuBar1.add(menuMant);

        menuTrans.setText("Transacciones");

        menuOrders.setText("Registro de Orden");
        menuOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrdersActionPerformed(evt);
            }
        });
        menuTrans.add(menuOrders);

        tablacruzada.setText("Ventas de empleado por categoria");
        tablacruzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablacruzadaActionPerformed(evt);
            }
        });
        menuTrans.add(tablacruzada);

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

        repProductsParam.setText("Producto por rango de precio unitario");
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

        jMenu8.setText("Orden");

        jMenuItem1.setText("Orden por ID");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenuItem4.setText("Orden por Transportistas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenu1.add(jMenu8);

        jMenu10.setText("Region");

        repRegionSimp.setText("Region Simple");
        repRegionSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repRegionSimpActionPerformed(evt);
            }
        });
        jMenu10.add(repRegionSimp);

        jMenu1.add(jMenu10);

        jMenu11.setText("Territorios");

        repTerritoriesSimp.setText("Territorios Simple");
        repTerritoriesSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repTerritoriesSimpActionPerformed(evt);
            }
        });
        jMenu11.add(repTerritoriesSimp);

        repTerritoriesParam.setText("Territorios por Region");
        repTerritoriesParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repTerritoriesParamActionPerformed(evt);
            }
        });
        jMenu11.add(repTerritoriesParam);

        jMenu1.add(jMenu11);

        jMenu12.setText("Transportistas");

        repShippersSimp.setText("Transportistas Simples");
        repShippersSimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repShippersSimpActionPerformed(evt);
            }
        });
        jMenu12.add(repShippersSimp);

        jMenu1.add(jMenu12);

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
        int w, h;

        w = dimW();
        h = dimH();

        formProd = new FrmProducts1(h, w);
        escritorio.add(formProd);
        formProd.setVisible(true);
        formProd.setSize(1100, 600);


    }//GEN-LAST:event_submenuProductsActionPerformed

    private void repProductsSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repProductsSimpActionPerformed
        int w, h;

        w = dimW();
        h = dimH();
        String tipReport = "Products";

        formProd = new FrmProducts1(h, w);
        escritorio.add(formProd);
        formProd.setVisible(true);
        formProd.setSize(1100, 600);

    }//GEN-LAST:event_repProductsSimpActionPerformed

    private void repProductsParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repProductsParamActionPerformed
        repRango = new frmRepProductsRango(this.dimH(), this.dimW());
        this.escritorio.add(repRango);
        repRango.setVisible(true);
        repRango.setSize(675, 195);
    }//GEN-LAST:event_repProductsParamActionPerformed

    private void submenuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuCustomerActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formCust = new FrmCustmers2(w, h);
        escritorio.add(formCust);
        formCust.setVisible(true);
        formCust.setSize(1200, 675);
    }//GEN-LAST:event_submenuCustomerActionPerformed

    private void repCustomersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCustomersSimpActionPerformed
        int w, h;
        String tipoRep = "Customers";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repCustomersSimpActionPerformed

    private void repCustomersParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCustomersParamActionPerformed
        repRegion = new frmRepCustomersRegion(this.dimH(), this.dimW());
        this.escritorio.add(repRegion);
        repRegion.setVisible(true);
        repRegion.setSize(675, 195);
    }//GEN-LAST:event_repCustomersParamActionPerformed

    private void repEmployeesParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repEmployeesParamActionPerformed
        UI.frmRepEmpParam ventanaParam = new UI.frmRepEmpParam();
        this.escritorio.add(ventanaParam);
        ventanaParam.setVisible(true);
    }//GEN-LAST:event_repEmployeesParamActionPerformed

    private void repEmployeesSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repEmployeesSimpActionPerformed
        int w, h;
        String tipoRep = "Employees";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repEmployeesSimpActionPerformed

    private void repCategoriesSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCategoriesSimpActionPerformed
        int w, h;
        String tipoRep = "Categories";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repCategoriesSimpActionPerformed

    private void repCategoriesParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repCategoriesParamActionPerformed
        UI.frmRepCatParam ventanaCat = new UI.frmRepCatParam();
        this.escritorio.add(ventanaCat);
        ventanaCat.setVisible(true);
    }//GEN-LAST:event_repCategoriesParamActionPerformed

    private void menuOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrdersActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formOrder = new FrmOrders(w, h);
        escritorio.add(formOrder);
        formOrder.setVisible(true);
        formOrder.setSize(1000, 685);
    }//GEN-LAST:event_menuOrdersActionPerformed

    private void menuSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSuppliersActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formsupplier = new FrmSupplier(w, h);
        escritorio.add(formsupplier);
        formsupplier.setVisible(true);
        formsupplier.setSize(1200, 739);
    }//GEN-LAST:event_menuSuppliersActionPerformed

    private void menuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsersActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formUsers = new FrmUsers(w, h);
        escritorio.add(formUsers);
        formUsers.setVisible(true);
        formUsers.setSize(900, 450);
    }//GEN-LAST:event_menuUsersActionPerformed

    private void menuCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriesActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formcategory = new frmCategory(w, h);
        escritorio.add(formcategory);
        formcategory.setVisible(true);
    }//GEN-LAST:event_menuCategoriesActionPerformed

    private void menuEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeesActionPerformed
        int w, h;

        w = dimW();
        h = dimH();

        formemployee = new frmEmployee(w, h);
        escritorio.add(formemployee);
        formemployee.setVisible(true);
    }//GEN-LAST:event_menuEmployeesActionPerformed

    private void repUsersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repUsersSimpActionPerformed
        int w, h;
        String tipoRep = "Users";
        String tipo = "Simp";
        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repUsersSimpActionPerformed

    private void repSuppliersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repSuppliersSimpActionPerformed
        int w, h;
        String tipoRep = "Suppliers";

        w = dimW();
        h = dimH();
        String tipo = "Simp";

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
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
        int w, h;
        String tipoRep = "TablaCruzada";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_tablacruzadaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRepOrdersParam ventanaOrders = new FrmRepOrdersParam(escritorio);
        this.escritorio.add(ventanaOrders);
        ventanaOrders.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmMarkov ventamaMarkov = new FrmMarkov();
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

    private void menuTerritoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTerritoriesActionPerformed
        FrmTerritories formTerritories = new FrmTerritories();
        escritorio.add(formTerritories);
        formTerritories.setVisible(true);
        try {
            formTerritories.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuTerritoriesActionPerformed

    private void repRegionSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repRegionSimpActionPerformed
        int w, h;
        String tipoRep = "Region";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repRegionSimpActionPerformed

    private void repTerritoriesSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repTerritoriesSimpActionPerformed
        int w, h;
        String tipoRep = "Territories";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repTerritoriesSimpActionPerformed

    private void repTerritoriesParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repTerritoriesParamActionPerformed
        frmRepTerReg f = new frmRepTerReg();
        escritorio.add(f);
        f.setVisible(true);
        try {
            f.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_repTerritoriesParamActionPerformed

    private void repShippersSimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repShippersSimpActionPerformed
        int w, h;
        String tipoRep = "Shippers";
        String tipo = "Simp";

        w = dimW();
        h = dimH();

        FrmReporte frmReporte = new FrmReporte(w, h, tipoRep, tipo);
        escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }//GEN-LAST:event_repShippersSimpActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        frmRepOrdersShipper f = new frmRepOrdersShipper();
        escritorio.add(f);
        f.setVisible(true);
        try {
            f.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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

    int dimW() {
        return wd;
    }

    int dimH() {
        return hd;
    }

    private void aplicarPermisosPorTitulo() {
        if (titulo == null) {
            titulo = "";
        }

        switch (titulo) {

            case "Vice President, Sales":
                submenuProducts.setEnabled(true);
                submenuCustomer.setEnabled(true);
                menuSuppliers.setEnabled(true);
                menuUsers.setEnabled(true);
                menuCategories.setEnabled(true);
                menuEmployees.setEnabled(true);
                menuRegion.setEnabled(true);
                menuShippers.setEnabled(true);
                menuOrders.setEnabled(true);
                // Reportes todos
                repProductsSimp.setEnabled(true);
                repProductsParam.setEnabled(true);
                repCustomersSimp.setEnabled(true);
                repCustomersParam.setEnabled(true);
                repEmployeesSimp.setEnabled(true);
                repEmployeesParam.setEnabled(true);
                repCategoriesSimp.setEnabled(true);
                repCategoriesParam.setEnabled(true);
                repUsersSimp.setEnabled(true);
                repUserParam.setEnabled(true);
                repSuppliersSimp.setEnabled(true);
                RepSuppParam.setEnabled(true);
                tablacruzada.setEnabled(true);
                jMenuItem1.setEnabled(true);
                break;

            case "Sales Manager":

                submenuProducts.setEnabled(true);
                submenuCustomer.setEnabled(true);
                menuSuppliers.setEnabled(true);
                menuUsers.setEnabled(false);
                menuCategories.setEnabled(true);
                menuEmployees.setEnabled(true);
                menuRegion.setEnabled(false);
                menuShippers.setEnabled(true);
                menuOrders.setEnabled(true);
                // Reportes
                repProductsSimp.setEnabled(true);
                repProductsParam.setEnabled(true);
                repCustomersSimp.setEnabled(true);
                repCustomersParam.setEnabled(true);
                repEmployeesSimp.setEnabled(true);
                repEmployeesParam.setEnabled(true);
                repCategoriesSimp.setEnabled(true);
                repCategoriesParam.setEnabled(false);
                repUsersSimp.setEnabled(false);
                repUserParam.setEnabled(false);
                repSuppliersSimp.setEnabled(true);
                RepSuppParam.setEnabled(true);
                tablacruzada.setEnabled(true);
                jMenuItem1.setEnabled(true);
                break;

            case "Sales Representative":

                submenuProducts.setEnabled(true);
                submenuCustomer.setEnabled(true);
                menuSuppliers.setEnabled(false);
                menuUsers.setEnabled(false);
                menuCategories.setEnabled(true);
                menuEmployees.setEnabled(false);
                menuRegion.setEnabled(false);
                menuShippers.setEnabled(false);
                menuOrders.setEnabled(true);
                // Reportes
                repProductsSimp.setEnabled(true);
                repProductsParam.setEnabled(true);
                repCustomersSimp.setEnabled(true);
                repCustomersParam.setEnabled(true);
                repEmployeesSimp.setEnabled(false);
                repEmployeesParam.setEnabled(false);
                repCategoriesSimp.setEnabled(true);
                repCategoriesParam.setEnabled(false);
                repUsersSimp.setEnabled(false);
                repUserParam.setEnabled(false);
                repSuppliersSimp.setEnabled(false);
                RepSuppParam.setEnabled(false);
                tablacruzada.setEnabled(false);
                jMenuItem1.setEnabled(true);
                break;

            case "Inside Sales Coordinator":

                submenuProducts.setEnabled(true);
                submenuCustomer.setEnabled(true);
                menuSuppliers.setEnabled(false);
                menuUsers.setEnabled(false);
                menuCategories.setEnabled(true);
                menuEmployees.setEnabled(false);
                menuRegion.setEnabled(false);
                menuShippers.setEnabled(false);
                menuOrders.setEnabled(false);
                // Reportes
                repProductsSimp.setEnabled(true);
                repProductsParam.setEnabled(false);
                repCustomersSimp.setEnabled(true);
                repCustomersParam.setEnabled(false);
                repEmployeesSimp.setEnabled(false);
                repEmployeesParam.setEnabled(false);
                repCategoriesSimp.setEnabled(true);
                repCategoriesParam.setEnabled(false);
                repUsersSimp.setEnabled(false);
                repUserParam.setEnabled(false);
                repSuppliersSimp.setEnabled(false);
                RepSuppParam.setEnabled(false);
                tablacruzada.setEnabled(false);
                jMenuItem1.setEnabled(false);
                break;

            default:

                submenuProducts.setEnabled(false);
                submenuCustomer.setEnabled(false);
                menuSuppliers.setEnabled(false);
                menuUsers.setEnabled(false);
                menuCategories.setEnabled(false);
                menuEmployees.setEnabled(false);
                menuRegion.setEnabled(false);
                menuShippers.setEnabled(false);
                menuOrders.setEnabled(false);
                repProductsSimp.setEnabled(false);
                repProductsParam.setEnabled(false);
                repCustomersSimp.setEnabled(false);
                repCustomersParam.setEnabled(false);
                repEmployeesSimp.setEnabled(false);
                repEmployeesParam.setEnabled(false);
                repCategoriesSimp.setEnabled(false);
                repCategoriesParam.setEnabled(false);
                repUsersSimp.setEnabled(false);
                repUserParam.setEnabled(false);
                repSuppliersSimp.setEnabled(false);
                RepSuppParam.setEnabled(false);
                tablacruzada.setEnabled(false);
                jMenuItem1.setEnabled(false);
                break;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // ← Abre el LOGIN primero, no el MDI
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem RepSuppParam;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
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
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menuCategories;
    private javax.swing.JMenuItem menuEmployees;
    private javax.swing.JMenu menuMant;
    private javax.swing.JMenuItem menuOrders;
    private javax.swing.JMenuItem menuRegion;
    private javax.swing.JMenuItem menuShippers;
    private javax.swing.JMenuItem menuSuppliers;
    private javax.swing.JMenuItem menuTerritories;
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
    private javax.swing.JMenuItem repRegionSimp;
    private javax.swing.JMenuItem repShippersSimp;
    private javax.swing.JMenuItem repSuppliersSimp;
    private javax.swing.JMenuItem repTerritoriesParam;
    private javax.swing.JMenuItem repTerritoriesSimp;
    private javax.swing.JMenuItem repUserParam;
    private javax.swing.JMenuItem repUsersSimp;
    private javax.swing.JMenuItem submenuCustomer;
    private javax.swing.JMenuItem submenuProducts;
    private javax.swing.JMenuItem tablacruzada;
    // End of variables declaration//GEN-END:variables
}
