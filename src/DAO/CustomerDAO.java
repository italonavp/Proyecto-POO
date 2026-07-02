package DAO;

import BEAN.Customer;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CustomerDAO {

    public Vector<Customer> listaCustomers(String cad) {
        Vector<Customer> vecCustomers = new Vector<Customer>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Customers";
        if (!cad.isEmpty()) {
            sql += " WHERE ContactName LIKE '%" + cad + "%' OR CompanyName LIKE '%"+cad + "%'";
        }

        try {
            ResultSet res = db.execSQL(sql);
            while (res.next()) {
                Customer c = new Customer();
                c.setCustomerId(res.getString(1));
                c.setCompanyName(res.getString(2));
                c.setContactName(res.getString(3));
                c.setContactTitle(res.getString(4));
                c.setAddress(res.getString(5));
                c.setCity(res.getString(6));
                c.setRegion(res.getString(7) == null ? "" : res.getString(7));
                c.setPostalCode(res.getString(8));
                c.setCountry(res.getString(9));
                c.setPhone(res.getString(10));
                c.setFax(res.getString(11) == null ? "" : res.getString(11));
                c.setEmail(res.getString(12) == null ? "" : res.getString(12));

                vecCustomers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vecCustomers;
    }

    public void insertaCustomer(Customer cust) {
        String sql = "INSERT INTO Customers VALUES (";

        sql += "'" + cust.getCustomerID() + "', ";
        sql += "'" + cust.getCompanyName() + "', ";
        sql += "'" + cust.getContactName() + "', ";
        sql += "'" + cust.getContactTitle() + "', ";
        sql += "'" + cust.getAddress() + "', ";
        sql += "'" + cust.getCity() + "', ";
        sql += "'" + cust.getRegion() + "', ";
        sql += "'" + cust.getPostalCode() + "', ";
        sql += "'" + cust.getCountry() + "', ";
        sql += "'" + cust.getPhone() + "', ";
        sql += "'" + cust.getFax() + "', ";
        sql += "'" + cust.getEmail() + "')";

        dbBean db = new dbBean();

        try {
            db.updateSQL(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizaCustomer(Customer cust) {
        String sql = "UPDATE Customers SET ";

        sql += "CustomerID='" + cust.getCustomerID() + "', ";
        sql += "CompanyName='" + cust.getCompanyName() + "', ";
        sql += "ContactName='" + cust.getContactName() + "', ";
        sql += "ContactTitle='" + cust.getContactTitle() + "', ";
        sql += "Address='" + cust.getAddress() + "', ";
        sql += "City='" + cust.getCity() + "', ";
        sql += "Region='" + cust.getRegion() + "', ";
        sql += "PostalCode='" + cust.getPostalCode() + "', ";
        sql += "Country='" + cust.getCountry() + "', ";
        sql += "Phone='" + cust.getPhone() + "', ";
        sql += "Fax='" + cust.getFax() + "' ";
        sql += "Email='" + cust.getEmail() + "' ";
        sql += "WHERE CustomerID='" + cust.getCustomerID() + "'";

        dbBean db = new dbBean();

        try {
            db.updateSQL(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarCustomer(Customer c) {
        String sql = "DELETE FROM Customers WHERE CustomerID = '" + c.getCustomerID() + "'";

        dbBean db = new dbBean();
        boolean state = false;

        try {
            db.updateSQL(sql);
            state = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            state = false;
        }

        try {
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return state;
    }

    public String generateID(String compName) {
        String id = "";

        try {

            String[] txt = compName.split(" ");

            // Si solo hay una palabra y tiene al menos 5 caracteres
            if (txt.length == 1 && txt[0].length() >= 5) {
                return txt[0].substring(0, 5).toUpperCase();
            }

            for (int i = 0; i < txt.length; i++) {
                String c = txt[i];
                if (c.length() >= i + 2) {
                    id += c.substring(0, i + 2);
                } else {
                    id += c;
                }
            }

        } catch (Exception e) {

        }

        return id.length() >= 5
                ? id.toUpperCase().substring(0, 5)
                : id.toUpperCase();

    }
}
