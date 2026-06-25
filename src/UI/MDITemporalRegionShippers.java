package UI;

import UTIL.dbBean;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRException;

public class MDITemporalRegionShippers extends javax.swing.JFrame {

    public MDITemporalRegionShippers() {
        initComponents();
        maximizarVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuMantenimiento = new javax.swing.JMenu();
        menuRegion = new javax.swing.JMenuItem();
        menuShippers = new javax.swing.JMenuItem();
        menuTerritories = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MDI Temporal - Region y Shippers");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        menuMantenimiento.setText("Mantenimiento");

        menuRegion.setText("Region");
        menuRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegionActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuRegion);

        menuShippers.setText("Shippers");
        menuShippers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuShippersActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuShippers);

        menuTerritories.setText("Territories");
        menuTerritories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTerritoriesActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuTerritories);

        menuBar.add(menuMantenimiento);

        jMenu1.setText("Reportes");

        jMenuItem1.setText("Region Simple");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Shippers Simple");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Territories x Region");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Orders x Shipper");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Territories Simple");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

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

    private void menuRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegionActionPerformed
        abrirRegion();
    }//GEN-LAST:event_menuRegionActionPerformed

    private void menuShippersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuShippersActionPerformed
        abrirShippers();
    }//GEN-LAST:event_menuShippersActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try{
           String r = "src/REPORTS/repRegionSimp.jasper";
           dbBean db = new dbBean();
           db.connectRep(r, null, false);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{
           String r = "src/REPORTS/repShippersSimp.jasper";
           dbBean db = new dbBean();
           db.connectRep(r, null, false);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuTerritoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTerritoriesActionPerformed
        abrirTerritories();
    }//GEN-LAST:event_menuTerritoriesActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmRepTerReg f = new frmRepTerReg();
        abrirFormulario(f);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        frmRepOrdersShipper f = new frmRepOrdersShipper();
        abrirFormulario(f);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try{
           String r = "src/REPORTS/repTerritoriesSimp.jasper";
           dbBean db = new dbBean();
           db.connectRep(r, null, false);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void maximizarVentana() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setSize(dimension.width, dimension.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void abrirRegion() {
        FrmRegion formRegion = new FrmRegion();
        abrirFormulario(formRegion);
    }

    private void abrirShippers() {
        FrmShippers formShippers = new FrmShippers();
        abrirFormulario(formShippers);
    }

    private void abrirTerritories() {
        FrmTerritories formTerritories = new FrmTerritories();
        abrirFormulario(formTerritories);
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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDITemporalRegionShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDITemporalRegionShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDITemporalRegionShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDITemporalRegionShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDITemporalRegionShippers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuMantenimiento;
    private javax.swing.JMenuItem menuRegion;
    private javax.swing.JMenuItem menuShippers;
    private javax.swing.JMenuItem menuTerritories;
    // End of variables declaration//GEN-END:variables
}
