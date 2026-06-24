package DAO;
import BEAN.*;
import UTIL.*;
import java.util.Vector;
import java.sql.ResultSet;

public class OrderDAO {

    public OrderDAO() {
    }
    
    public Vector<Order> listaOrders(String cad){
        Vector<Order> listOrder = new Vector<Order>();
        dbBean con = new dbBean();
        String sql = "Select * from Orders";
        
        if(!cad.isEmpty()){
            sql += " Where CustomerID LIKE '"+cad+"%' or ShipName LIKE '"+cad+"%'";
        }
        System.out.println(sql);
        try{
            ResultSet resultOrder = con.execSQL(sql);
            
            while(resultOrder.next()){
                Order ord = new Order();
                ord.setOrderID(resultOrder.getInt(1));
                ord.setCustomerID(resultOrder.getString(2));
                ord.setEmployeeID(resultOrder.getInt(3));
                ord.setOrderDate(resultOrder.getDate(4));
                ord.setRequiredDate(resultOrder.getDate(5));
                ord.setShippedDate(resultOrder.getDate(6));
                ord.setShipVia(resultOrder.getInt(7));
                ord.setFreight(resultOrder.getDouble(8));
                ord.setShipName(resultOrder.getString(9));
                ord.setShipAdress(resultOrder.getString(10));
                ord.setShipCity(resultOrder.getString(11));
                ord.setShipRegion(resultOrder.getString(12));
                ord.setShipPostalCode(resultOrder.getString(13));
                ord.setShipCountry(resultOrder.getString(14));
                
                listOrder.addElement(ord);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listOrder;
    }
    
    public int procesaOrder(Order ord, String proc){
        int resultado = 0;
        String sql = "";
        dbBean con = new dbBean();
        if(proc.equals("insert")){
            String orderDateVal = (ord.getOrderDate() != null) ? "'" + ord.getOrderDate() + "'" : "NULL";
            String reqDateVal = (ord.getRequiredDate() != null) ? "'" + ord.getRequiredDate() + "'" : "NULL";
            String shipDateVal = (ord.getShippedDate() != null) ? "'" + ord.getShippedDate() + "'" : "NULL";
            String regionVal = (ord.getShipRegion() == null || ord.getShipRegion().isEmpty()) ? "NULL" : "'" + ord.getShipRegion() + "'";
            String postalVal = (ord.getShipPostalCode() == null || ord.getShipPostalCode().isEmpty()) ? "NULL" : "'" + ord.getShipPostalCode() + "'";

            sql = "SET IDENTITY_INSERT Orders ON; ";
            sql += "INSERT INTO Orders (OrderID, CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry) VALUES (";
            
            sql += ord.getOrderID() + ", '" 
                + ord.getCustomerID() + "', " 
                + ord.getEmployeeID() + ", " 
                + orderDateVal + ", " 
                + reqDateVal + ", " 
                + shipDateVal + ", " 
                + ord.getShipVia() + ", " 
                + ord.getFreight() + ", '" 
                + ord.getShipName() + "', '" 
                + ord.getShipAddress() + "', '" 
                + ord.getShipCity() + "', "
                + regionVal + ", "            
                + postalVal + ", '"           
                + ord.getShipCountry() + "'); ";
                
            sql += "SET IDENTITY_INSERT Orders OFF;";
            System.out.println(sql);
        }
        
        if(proc.equals("update")){
            String orderDateVal = (ord.getOrderDate() != null) ? "'" + ord.getOrderDate() + "'" : "NULL";
            String reqDateVal = (ord.getRequiredDate() != null) ? "'" + ord.getRequiredDate() + "'" : "NULL";
            String shipDateVal = (ord.getShippedDate() != null) ? "'" + ord.getShippedDate() + "'" : "NULL";
            String regionVal = (ord.getShipRegion() == null || ord.getShipRegion().trim().isEmpty()) ? "NULL" : "'" + ord.getShipRegion() + "'";
            String postalVal = (ord.getShipPostalCode() == null || ord.getShipPostalCode().trim().isEmpty()) ? "NULL" : "'" + ord.getShipPostalCode() + "'";

            sql = "UPDATE Orders SET "
                + "CustomerID = '" + ord.getCustomerID() + "', "
                + "EmployeeID = " + ord.getEmployeeID() + ", "
                + "OrderDate = " + orderDateVal + ", "
                + "RequiredDate = " + reqDateVal + ", "
                + "ShippedDate = " + shipDateVal + ", "
                + "ShipVia = " + ord.getShipVia() + ", "
                + "Freight = " + ord.getFreight() + ", "
                + "ShipName = '" + ord.getShipName() + "', "
                + "ShipAddress = '" + ord.getShipAddress() + "', "
                + "ShipCity = '" + ord.getShipCity() + "', "
                + "ShipRegion = " + regionVal + ", "         
                + "ShipPostalCode = " + postalVal + ", "     
                + "ShipCountry = '" + ord.getShipCountry() + "' "
                + "WHERE OrderID = " + ord.getOrderID();
        }
        if(proc.equals("delete")){
            sql = "DELETE FROM [Order Details] WHERE OrderID = " + ord.getOrderID() + "; ";
            sql += "DELETE FROM Orders WHERE OrderID = " + ord.getOrderID() + ";";
        }
        
        try{
           resultado = con.updateSQL(sql);
       }
       catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       try{
           con.close();
       }
       catch(java.sql.SQLException e){
           e.printStackTrace();
       }
       
       return resultado;
    }
}

