package DAO;
import BEAN.*;
import UTIL.*;
import java.util.Vector;
import java.sql.ResultSet;

public class ProductDAO {

    public ProductDAO() {
    }
    
    public Vector<Product> listaProducts(String cad){
        dbBean con;
        con = new dbBean();
        Vector<Product> listaProd;
        listaProd = new Vector<Product>();
        String sql = "select * from products ";
        try{
            if(!cad.isEmpty()){
                sql += " Where ProductName like '"+cad+"%'";
            }
            ResultSet result = con.execSQL(sql);
            
            while(result.next()){
                Product prod = new Product();
                prod.setProductID(result.getInt(1));
                prod.setProductName(result.getString(2));
                prod.setSupplierID(result.getInt(3));
                prod.setCategoryID(result.getInt(4));
                prod.setQuantityPerUnit(result.getString(5));
                prod.setUnitPrice(result.getDouble(6));
                prod.setUnitsInStock(result.getInt(7));
                prod.setUnitsOnOrder(result.getInt(8));
                prod.setReorderLevel(result.getInt(9));
                prod.setDiscontinued(result.getBoolean(10));
                listaProd.addElement(prod);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaProd;
    }
    
    public void insertaProduct(Product prod){
        dbBean con = new dbBean();
        String sql;
        
        try{
            //nota mental: para ingresar el ID manual, tenemos que "pedir permiso"
            sql = "SET IDENTITY_INSERT Products ON; ";
            sql += "Insert into Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) Values (";
            sql += prod.getProductID()+",'"+prod.getProductName()+"',"+prod.getSupplierID()+","+prod.getCategoryID()+",'"+prod.getQuantityPerUnit()+"',"+prod.getUnitPrice()+","+ prod.getUnitsInStock()+","+prod.getUnitsOnOrder()+","+prod.getReorderLevel()+","+ (prod.getDiscontinued() ? 1 : 0) +"); ";
            sql += "SET IDENTITY_INSERT Products OFF;";
            System.out.println(sql);
            con.updateSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    public void actualizaProduct(Product prod){
      dbBean con = new dbBean();
        String sql;
        
        try{
            sql = "Update Products set ProductName = '"+prod.getProductName()+"',";
            sql += "SupplierID = "+prod.getSupplierID()+",";
            sql += "CategoryID = "+prod.getCategoryID()+",";
            sql += "QuantityPerUnit = '"+prod.getQuantityPerUnit()+"',";
            sql += "UnitPrice = "+prod.getUnitPrice()+",";
            sql += "UnitsInStock = "+prod.getUnitsInStock()+",";
            sql += "UnitsOnOrder = "+prod.getUnitsOnOrder()+",";
            sql += "ReorderLevel = "+prod.getReorderLevel()+",";
            sql += "Discontinued = "+(prod.getDiscontinued() ? 1 : 0)+"";
            sql += " Where ProductID = "+prod.getProductID();
            System.out.println(sql);
            con.updateSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }  
    }
    
    public void eliminaProduct(Product prod){
        dbBean con = new dbBean();
        String sql;
        
        try{
            sql = "Delete from Products where ProductID = "+prod.getProductID();
            System.out.println(sql);
            con.updateSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "No se puede eliminar el producto porque tiene dependencias registradas.", "Error de Integridad", javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
}
