/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BEAN.Customer;
import DAO.CustomerDAO;
import UTIL.MailUtil;
import UTIL.dbBean;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Admin
 */
public class FrmReporte extends JInternalFrame {

    private CustomerDAO custDAO = new CustomerDAO();
    private DefaultTableModel dft;
    private String tipoRep;
    private HashMap parametros;
    private String tipo;

    public FrmReporte(int w, int h, String tipoRep, String tipo) {
        initComponents();
        dft = (DefaultTableModel) tblCustomers.getModel();
        fillTable("");
        this.tipoRep = tipoRep;
        this.tipo = tipo;
        lblTitle.setText("Reporte de " + this.tipoRep);

        try {
            String r = "src/REPORTS/rep" + this.tipoRep + "Simp.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, null, false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public FrmReporte(String tipoRep, HashMap parametros, String tipo) {
        initComponents();

        dft = (DefaultTableModel) tblCustomers.getModel();
        fillTable("");

        this.tipoRep = tipoRep;
        this.parametros = parametros;
        this.tipo = tipo;

        lblTitle.setText("Reporte de " + this.tipoRep);

        try {
            String r = "src/REPORTS/rep" + this.tipoRep + "Param.jasper";
            dbBean db = new dbBean();
            db.connectRep(r, parametros, true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    private void fillTable(String filtro) {
        Vector<Customer> vecCust = custDAO.listaCustomers(filtro);
        for (Customer c : vecCust) {
            Vector vec = new Vector();
            vec.add(c.getCustomerID());
            vec.add(c.getCompanyName());
            vec.add(c.getContactName());
            vec.add(c.getEmail());
            dft.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        txtAbrir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Enviar a Correo"));

        jLabel1.setText("Correo: ");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnEnviar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAbrir.setText("Abrir Reporte");
        txtAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbrirActionPerformed(evt);
            }
        });

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Nombre Empresa", "Nombre Contacto", "Email"
            }
        ));
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        lblTitle.setText("Envio de reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtAbrir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAbrir)
                        .addGap(67, 67, 67)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        int id = tblCustomers.getSelectedRow();

        txtCorreo.setText(dft.getValueAt(id, 3).toString());
    }//GEN-LAST:event_tblCustomersMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String asunto = String.format("Reporte Generado - %s", this.tipoRep);

        String mensaje = String.format(
                "Buen día,%n%n"
                + "En atención a su solicitud, se adjunta el reporte \"%s\".%n%n"
                + "El documento contiene la información correspondiente al reporte solicitado y se encuentra disponible para su revisión.%n%n"
                + "Agradecemos su preferencia y esperamos que la información proporcionada sea de utilidad.%n%n"
                + "Saludos cordiales.",
                this.tipoRep
        );

        boolean sent = MailUtil.sendTo(txtCorreo.getText(), asunto, mensaje, "Reporte.pdf");
        if (sent) {
            JOptionPane.showMessageDialog(this, "Correo enviado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar enviar el correo, intenta de nuevo.");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbrirActionPerformed
        try {
            String r = "src/REPORTS/rep" + this.tipoRep + this.tipo + ".jasper";
            dbBean db = new dbBean();
            if (tipo.equals("Simp")) {
                db.connectRep(r, null, false);
            } else {
                db.connectRep(r, parametros, true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtAbrirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JButton txtAbrir;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
