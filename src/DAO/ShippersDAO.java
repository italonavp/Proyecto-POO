package DAO;

import BEAN.Shippers;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ShippersDAO {
    
    
    public Vector<Shippers> listaShippers(String cad){
        dbBean con;
        con = new dbBean();
        Vector<Shippers> listaShip;
        listaShip = new Vector<Shippers>();
        String sql = "select * from Shippers ";
        if(!cad.isEmpty()){
            sql = sql + " where CompanyName like '"+ cad +"%'";
        }
        
        try{
            ResultSet result = con.execSQL(sql);
            while(result.next()){
                Shippers s = new Shippers();
                s.setIdShippers(result.getInt(1));
                s.setCompanyName(result.getString(2));
                s.setPhone(result.getString(3));
              
                listaShip.addElement(s);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaShip;
    }
    
    public void insertaShippers(Shippers s){
        dbBean con;
        con = new dbBean();
        
        String sql;
        try{
            sql = "insert into Shippers (CompanyName, Phone) values('"+ s.getCompanyName() +"', '"+ s.getPhone() +"')";
           
            System.out.println("JJJJ "+sql);
            con.execSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    public void actualiza(Shippers s){
        dbBean con;
        con = new dbBean();
        String sql;
        try{
            sql = "update Shippers set CompanyName = '"+s.getCompanyName()+"', ";
            sql = sql + "Phone = '"+s.getPhone()+"' where ";
            sql = sql + "ShipperID ="+ s.getIdShippers() +"";
            
            System.out.println("TICO TIco: "+sql);
            
            con.execSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }    
   
    
}
