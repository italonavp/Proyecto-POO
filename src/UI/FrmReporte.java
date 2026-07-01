/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BEAN.Customer;
import BEAN.Employee;
import BEAN.Users;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.UsersDAO;
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
    private UsersDAO userDAO = new UsersDAO();
    private EmployeeDAO empDAO = new EmployeeDAO();
    private DefaultTableModel dft;
    private DefaultTableModel dft2;
    private String tipoRep;
    private HashMap parametros;
    private String tipo;

    private String cliente;

    public FrmReporte(int w, int h, String tipoRep, String tipo) {
        initComponents();
        dft = (DefaultTableModel) tblCustomers.getModel();
        dft2 = (DefaultTableModel) tblEmployees.getModel();
        fillCustomersTable("");
        fillEmployeesTable("");
        this.tipoRep = tipoRep;
        this.tipo = tipo;
        txtSelected.setEnabled(false);
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
        txtSelected.setEnabled(false);

        dft = (DefaultTableModel) tblCustomers.getModel();
        dft2 = (DefaultTableModel) tblEmployees.getModel();
        fillCustomersTable("");
        fillEmployeesTable("");

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

    private void fillCustomersTable(String filtro) {
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

    private void fillEmployeesTable(String filtro) {
        Vector<Users> vecEmploy = userDAO.listaUsers(filtro);
        Vector<Employee> vec2 = empDAO.listaEmployees(filtro);
        for (Users u : vecEmploy) {
            System.out.println(u.getUserIdentification());
            Vector vec = new Vector();
            vec.add(u.getUserID());
            for (Employee e : vec2) {
                if (e.getEmployeeID() == u.getEmployeeID()) {
                    vec.add(e.getFirstName() + " " + e.getLastName());
                }
            }
            vec.add(u.getEmail());
            dft2.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSelected = new javax.swing.JTextField();
        txtAbrir = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();

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

        jLabel2.setText("Cliente Seleccionado");

        txtSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEnviar)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(127, 127, 127))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnviar)
                .addContainerGap())
        );

        txtAbrir.setText("Abrir Reporte");
        txtAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbrirActionPerformed(evt);
            }
        });

        lblTitle.setText("Envio de reportes");

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

        jTabbedPane1.addTab("Clientes", jScrollPane1);

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Username", "Email"
            }
        ));
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmployees);

        jTabbedPane1.addTab("Empleados", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAbrir)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtAbrir))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        cliente = txtSelected.getText();

        String asunto = String.format("Reporte Generado - %s", this.tipoRep);

        String mensaje = String.format(
                "Buen día " + cliente + ", "
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

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        int id = tblCustomers.getSelectedRow();

        txtCorreo.setText(dft.getValueAt(id, 3).toString());
        txtSelected.setText(dft.getValueAt(id, 1).toString());
    }//GEN-LAST:event_tblCustomersMouseClicked

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        int id = tblEmployees.getSelectedRow();

        txtCorreo.setText(dft2.getValueAt(id, 2) == null ? "" : dft2.getValueAt(id, 2).toString());
        txtSelected.setText(dft2.getValueAt(id, 1).toString());
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void txtSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JButton txtAbrir;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtSelected;
    // End of variables declaration//GEN-END:variables
}
