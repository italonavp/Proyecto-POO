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
            con.updateSQL(sql);
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
            con.updateSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }    

    public int eliminaShippers(int idShippers){
        dbBean con;
        con = new dbBean();
        int validacion = 0;
        try{
            String sqlCheck = "select count(*) from Orders where ShipVia = " + idShippers;
            ResultSet rs = con.execSQL(sqlCheck);
            if(rs.next() && rs.getInt(1) > 0){
                return 1;
            }

            String sql = "delete from Shippers where ShipperID = " + idShippers;
            con.updateSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            validacion = -1;
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return validacion;
    }
   
    
}
