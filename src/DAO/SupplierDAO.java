package DAO;
import BEAN.Supplier;
import UTIL.dbBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class SupplierDAO {
    Vector<Supplier> Supplier;

    public SupplierDAO() {
        Supplier = new Vector();
    }
    
    
    public Vector<Supplier> listaSuppliers(String cad) {
        dbBean con = new dbBean();
        Vector<Supplier> listaSup = new Vector<Supplier>();
        String sql = "select supplierID, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, homePage from Suppliers";
        
        if (!cad.isEmpty()) {
            sql = sql + " where companyName like '" + cad + "%' or contactName like '" + cad + "%'";
        }
        
        try {
            ResultSet result = con.execSQL(sql);
            while (result.next()) {
                Supplier sup = new Supplier();
                sup.setSupplierID(result.getInt(1));
                sup.setCompanyName(result.getString(2));
                sup.setContactName(result.getString(3));
                sup.setContactTitle(result.getString(4));
                sup.setAddress(result.getString(5));
                sup.setCity(result.getString(6));
                sup.setRegion(result.getString(7));
                sup.setPostalCode(result.getString(8));
                sup.setCountry(result.getString(9));
                sup.setPhone(result.getString(10));
                sup.setFax(result.getString(11));
                sup.setHomePage(result.getString(12));
                listaSup.addElement(sup);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return listaSup;
    } 

    
    public int insertaSupplier(Supplier sup) {
        dbBean con = new dbBean();
        int validacion = 0;
        try {
            // Validar que no exista otra empresa con el mismo nombre
            String sqlCheck = "SELECT COUNT(*) FROM Suppliers WHERE companyName = '" + sup.getCompanyName().replace("'", "''") + "'";
            ResultSet rs = con.execSQL(sqlCheck);
            if (rs.next() && rs.getInt(1) > 0) {
                return 1; // Ya existe un proveedor con ese nombre
            }

            String sql = "insert into Suppliers (companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, homePage) " +
                  "values ('" + sup.getCompanyName().replace("'", "''") + "', '" + sup.getContactName() + "', '" + sup.getContactTitle() + "', '" + 
                  sup.getAddress() + "', '" + sup.getCity() + "', '" + sup.getRegion() + "', '" + sup.getPostalCode() + "', '" + 
                  sup.getCountry() + "', '" + sup.getPhone() + "', '" + sup.getFax() + "', '" + sup.getHomePage() + "')";
            
            con.updateSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1;
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return validacion;
    }

    public int actualizaSupplier(Supplier sup) {
        dbBean con = new dbBean();
        int validacion = 0;

        
        String sqlCheck = "SELECT COUNT(*) FROM Suppliers WHERE companyName = ? AND supplierID <> ?";
        String sqlUpdate = "UPDATE Suppliers SET companyName=?, contactName=?, contactTitle=?, address=?, city=?, region=?, postalCode=?, country=?, phone=?, fax=?, homePage=? WHERE supplierID=?";

        try {
            
            java.sql.Connection conn = con.getConnection(); 

            // ver si nomb ya existe en otra empresa
            try (PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {
                psCheck.setString(1, sup.getCompanyName());
                psCheck.setInt(2, sup.getSupplierID());

                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        return 1; // nombre ya existe
                    }
                }
            }

            
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setString(1, sup.getCompanyName());
                psUpdate.setString(2, sup.getContactName());
                psUpdate.setString(3, sup.getContactTitle());
                psUpdate.setString(4, sup.getAddress());
                psUpdate.setString(5, sup.getCity());
                psUpdate.setString(6, sup.getRegion());
                psUpdate.setString(7, sup.getPostalCode());
                psUpdate.setString(8, sup.getCountry());
                psUpdate.setString(9, sup.getPhone());
                psUpdate.setString(10, sup.getFax());
                psUpdate.setString(11, sup.getHomePage());
                psUpdate.setInt(12, sup.getSupplierID());

                psUpdate.executeUpdate();
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1; // Error en la base de datos
        } finally {
            // Cerramos la conexión llamando al método que ya tenías en tu dbBean
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return validacion;
    }
    
    

    
    public int eliminaSupplier(int idSupplier) {
        dbBean con = new dbBean();
        int validacion = 0;
        try {
            //ver si hay productos asociados en Products
            String sqlCheck = "SELECT COUNT(*) FROM Products WHERE SupplierID = " + idSupplier;
            ResultSet rs = con.execSQL(sqlCheck);
            if (rs.next() && rs.getInt(1) > 0) {
                return 1; //Tiene productos dependientes, bloqueo
            }
            
            String sqlDelete = "DELETE FROM Suppliers WHERE SupplierID = " + idSupplier;
            con.updateSQL(sqlDelete);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1;
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return validacion;
    }
    /*
    public int actualizaSupplier(Supplier sup) {
        dbBean con = new dbBean();
        int validacion = 0;
        try {
            //ver que el nuevo nombre no lo tenga otra empresa
            String sqlCheck = "SELECT COUNT(*) FROM Suppliers WHERE companyName = '" + sup.getCompanyName().replace("'", "''") + "' AND supplierID <> " + sup.getSupplierID();
            ResultSet rs = con.execSQL(sqlCheck);
            if (rs.next() && rs.getInt(1) > 0) {
                return 1; // Conflicto de nombre, existente
            }

            String sql = "update Suppliers set companyName = '" + sup.getCompanyName().replace("'", "''") + "', " +
                  "contactName = '" + sup.getContactName() + "', " +
                  "contactTitle = '" + sup.getContactTitle() + "', " +
                  "address = '" + sup.getAddress() + "', " +
                  "city = '" + sup.getCity() + "', " +
                  "region = '" + sup.getRegion() + "', " +
                  "postalCode = '" + sup.getPostalCode() + "', " +
                  "country = '" + sup.getCountry() + "', " +
                  "phone = '" + sup.getPhone() + "', " +
                  "fax = '" + sup.getFax() + "', " +
                  "homePage = '" + sup.getHomePage() + "' " +
                  "where supplierID = " + sup.getSupplierID();
            
            con.updateSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1;
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return validacion;
    }
        */
}