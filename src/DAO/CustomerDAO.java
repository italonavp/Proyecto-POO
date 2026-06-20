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
            sql += " WHERE ContactName LIKE '%" + cad + "%'";
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
                c.setRegion(res.getString(7));
                c.setPostalCode(res.getString(8));
                c.setCountry(res.getString(9));
                c.setPhone(res.getString(10));
                c.setFax(res.getString(11));

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
        sql += "'" + cust.getFax() + "')";

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

    public void eliminaCustomer(Customer cust) {

    }
}
