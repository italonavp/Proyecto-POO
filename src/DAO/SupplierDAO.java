package DAO;
import BEAN.Supplier;
import UTIL.dbBean;
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
                  "values ('" + sup.getCompanyName() + "', '" + sup.getContactName() + "', '" + sup.getContactTitle() + "', '" + 
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

    //Retorna 0 exito, 1 si el nombre en conflicto, -1 error SQL
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

            String sql = "update Suppliers set companyName = '" + sup.getCompanyName() + "', " +
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
    

}