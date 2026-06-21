package DAO;

import BEAN.Region;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class RegionDAO {
    Vector Region;

    public RegionDAO() {
        Region  = new Vector();
    }
    
    public Vector<Region> listaRegion(String cad){
        dbBean con;
        con = new dbBean();
        Vector<Region> listaClient;
        listaClient = new Vector<Region>();
        String sql; // Se crea recien el sql que se enviara a ejecutar
        sql = "select * from Region";
        if(!cad.isEmpty()){
            sql = sql + " where RegionDescription like '"+cad + "%'";
        }
        try{
            ResultSet result;
            result = con.execSQL(sql);
            while (result.next()){
                Region r = new Region();
                r.setIDregion(result.getInt(1));
                r.setRegdesc(result.getString(2));
                
                listaClient.addElement(r);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaClient;
    } 
    public void insertaRegion(Region r){
        dbBean con;
        con = new dbBean();
        
        String sql;
        try{
            sql = "insert into Region values("+ r.getIDregion() +", '"+ r.getRegdesc() +"')";
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
    public void actualizarReg(Region r){
        dbBean con;
        con = new dbBean();
        String sql;
        try{
            sql = "update Region set RegionDescription = '"+r.getRegdesc()+"' where ";
            sql = sql + "RgionID ="+ r.getIDregion() +"";
            
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
