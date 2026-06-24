
package DAO;
import BEAN.*;
import UTIL.*;
import java.util.Vector;
import java.sql.ResultSet;

public class OrderDetailDAO {

    public OrderDetailDAO() {
    }
    
    public Vector<OrderDetail> listaOrderDetails(String cad){
        Vector<OrderDetail> listDetail = new Vector<OrderDetail>();
        dbBean con = new dbBean();
        String sql = "SELECT od.OrderID, od.ProductID, p.ProductName, od.UnitPrice, od.Quantity, od.Discount "
                   + "FROM [Order Details] od "
                   + "INNER JOIN Products p ON od.ProductID = p.ProductID";
        
        if(!cad.isEmpty()){
            sql += " WHERE od.OrderID LIKE '" + cad + "%' or od.ProductID LIKE '"+cad+"%'";
        }
        System.out.println(sql);
        
        try{
            ResultSet resultDetail = con.execSQL(sql);
            
            while(resultDetail.next()){
                OrderDetail det = new OrderDetail();
                det.setOrderID(resultDetail.getInt("OrderID"));
                det.setProductID(resultDetail.getInt("ProductID"));
                det.setProductName(resultDetail.getString("ProductName"));
                det.setUnitPrice(resultDetail.getDouble("UnitPrice"));
                det.setQuantity(resultDetail.getInt("Quantity"));
                det.setDiscount(resultDetail.getDouble("Discount"));
                listDetail.addElement(det);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listDetail;
    }
    
    public int procesaOrderDetail(OrderDetail det, String proc){
        int resultado = 0;
        String sql = "";
        dbBean con = new dbBean();
        
        if(proc.equals("insert")){
            sql = "INSERT INTO [Order Details] (OrderID, ProductID, UnitPrice, Quantity, Discount) VALUES (";
            sql += det.getOrderID() + "," + det.getProductID() + "," + det.getUnitPrice() + "," + det.getQuantity() + "," + det.getDiscount() + ")";
            System.out.println(sql);
        }
        
        if(proc.equals("update")){
            sql = "UPDATE [Order Details] SET "
                + "UnitPrice = " + det.getUnitPrice() + ", "
                + "Quantity = " + det.getQuantity() + ", "
                + "Discount = " + det.getDiscount() + " "
                + "WHERE OrderID = " + det.getOrderID() + " AND ProductID = " + det.getProductID();
        }
        
        if(proc.equals("delete")){
            // Borramos un producto puntual del carrito
            sql = "DELETE FROM [Order Details] WHERE OrderID = " + det.getOrderID() + " AND ProductID = " + det.getProductID();
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