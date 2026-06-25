package DAO;

import BEAN.Territories;
import UTIL.dbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class TerritoriesDAO {

    public Vector<Territories> listaTerritories(String cad) {
        dbBean con;
        con = new dbBean();
        Vector<Territories> listaTerr;
        listaTerr = new Vector<Territories>();
        String sql;
        sql = "select TerritoryID, TerritoryDescription, RegionID from Territories";
        if (!cad.isEmpty()) {
            sql = sql + " where TerritoryID like '" + cad + "%' or TerritoryDescription like '" + cad + "%'";
        }

        try {
            ResultSet result;
            result = con.execSQL(sql);
            while (result.next()) {
                Territories t = new Territories();
                t.setTerritoryID(result.getString(1));
                t.setTerritoryDescription(result.getString(2).trim());
                t.setRegionID(result.getInt(3));

                listaTerr.addElement(t);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return listaTerr;
    }

    public void insertaTerritories(Territories t) {
        dbBean con;
        con = new dbBean();
        String sql;
        try {
            sql = "insert into Territories (TerritoryID, TerritoryDescription, RegionID) values('"
                    + t.getTerritoryID() + "', '" + t.getTerritoryDescription() + "', " + t.getRegionID() + ")";
            con.updateSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualiza(Territories t) {
        dbBean con;
        con = new dbBean();
        String sql;
        try {
            sql = "update Territories set TerritoryDescription = '" + t.getTerritoryDescription() + "', ";
            sql = sql + "RegionID = " + t.getRegionID() + " where ";
            sql = sql + "TerritoryID = '" + t.getTerritoryID() + "'";
            con.updateSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public int eliminaTerritories(String idTerritory) {
        dbBean con;
        con = new dbBean();
        int validacion = 0;
        try {
            String sqlCheck = "select count(*) from EmployeeTerritories where TerritoryID = '" + idTerritory + "'";
            ResultSet rs = con.execSQL(sqlCheck);
            if (rs.next() && rs.getInt(1) > 0) {
                return 1;
            }

            String sql = "delete from Territories where TerritoryID = '" + idTerritory + "'";
            con.updateSQL(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1;
        }
        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return validacion;
    }
}
