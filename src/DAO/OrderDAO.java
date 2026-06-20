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
            sql += " Where CustomerID LIKE '"+cad+"%'";
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
                ord.setShipCountry(resultOrder.getString(12));
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
            sql = "SET INDENTITY_INSERT Orders ON;";
            sql += "INSERT INTO Orders (OrderID, CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipCountry) VALUES (";
            sql += ord.getOrderID()+",'"+ord.getCustomerID()+"',"+ord.getEmployeeID()+",'"+ord.getOrderDate()+"','"+ord.getRequiredDate()+"','"+ord.getShippedDate()+"',"+ord.getShipVia()+","+ord.getFreight()+",'"+ord.getShipName()+"','"+ord.getShipAddress()+"','"+ord.getShipCity()+"','"+ord.getShipCountry()+"'); ";
            sql += "SET IDENTITY_INSERT Orders OFF;";
            System.out.println(sql);
        }
        if(proc.equals("update")){
            sql = "UPDATE Orders SET "
                + "CustomerID = '" + ord.getCustomerID() + "', "
                + "EmployeeID = " + ord.getEmployeeID() + ", "
                + "OrderDate = '" + ord.getOrderDate() + "', "
                + "RequiredDate = '" + ord.getRequiredDate() + "', "
                + "ShippedDate = '" + ord.getShippedDate() + "', "
                + "ShipVia = " + ord.getShipVia() + ", "
                + "Freight = " + ord.getFreight() + ", "
                + "ShipName = '" + ord.getShipName() + "', "
                + "ShipAddress = '" +ord.getShipAddress() + "', "
                + "ShipCity = '" + ord.getShipCity() + "', "
                + "ShipCountry = '" + ord.getShipCountry() + "' "
                + "WHERE OrderID = " + ord.getOrderID();
        }
        if(proc.equals("delete")){
            sql = "DELETE FROM [Order Details] WHERE OrderID = " + ord.getOrderID() + "; ";
            sql += "DELETE FROM Orders WHERE OrderID = " + ord.getOrderID() + ";";
        }
        
        try{
           // Usamos el método ejecutaSQL que devuelve el número entero
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

