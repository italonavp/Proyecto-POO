package DAO;

import BEAN.*;
import UTIL.*;
import java.util.Vector;
import java.sql.ResultSet;

public class UsersDAO {

    public UsersDAO() {
    }

  
    public boolean validarLogin(String userIdentification, String passwordInput) {
        dbBean con = new dbBean();
        try {
            String sql = "SELECT password FROM Users WHERE userIdentification='"
                    + userIdentification + "'";
            ResultSet rs = con.execSQL(sql);
            if (rs.next()) {
                String passwordBD = rs.getString("password");
                String passwordDesencriptada = SecurityUtil.decrypt(passwordBD);
                if (passwordDesencriptada != null) {
                    return passwordDesencriptada.trim().equals(passwordInput.trim());
                }
                return passwordBD.trim().equals(passwordInput.trim());
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return false;
    }

    public Vector<Users> listaUsers(String cad) {
        Vector<Users> listUsers = new Vector<Users>();
        dbBean con = new dbBean();
        String sql = "SELECT * FROM Users";
        if (cad != null && !cad.isEmpty()) {
            sql += " WHERE userIdentification LIKE '" + cad + "%'";
        }
        try {
            ResultSet rs = con.execSQL(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setUserID(rs.getInt("UserId"));
                user.setEmployeeID(rs.getInt("EmployeeId"));
                user.setUserIdentification(rs.getString("userIdentification"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
                user.setEmail(rs.getString("Email"));
                listUsers.add(user);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return listUsers;
    }


    public boolean insertaUser(Users user) {
        dbBean con = new dbBean();
        boolean exito = false;
        try {
            String sql = "INSERT INTO Users (UserId, EmployeeID, userIdentification, password, status) VALUES ("
                    + user.getUserID() + ", "
                    + user.getEmployeeID() + ", '"
                    + user.getUserIdentification() + "', '"
                    + user.getPassword() + "', "
                    + user.getStatus() + ")";
            con.updateSQL(sql);
            exito = true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return exito;
    }

    public boolean actualizaUser(Users user) {
        dbBean con = new dbBean();
        boolean exito = false;
        try {
            String sql = "UPDATE Users SET "
                    + "EmployeeId = " + user.getEmployeeID() + ", "
                    + "userIdentification = '" + user.getUserIdentification() + "', "
                    + "password = '" + user.getPassword() + "', "
                    + "status = " + user.getStatus()
                    + " WHERE UserId = " + user.getUserID();
            con.updateSQL(sql);
            exito = true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return exito;
    }

    public boolean eliminaUser(Users user) {
        dbBean con = new dbBean();
        boolean exito = false;
        try {
            String sql = "DELETE FROM Users WHERE UserId = " + user.getUserID();
            con.updateSQL(sql);
            exito = true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return exito;
    }

    
    public String getRolUsuario(String userIdentification) {
        
         dbBean con = new dbBean();
        try {
            String sql = "SELECT e.Title FROM Users u "
                       + "INNER JOIN Employees e ON u.EmployeeID = e.EmployeeID "
                       + "WHERE u.userIdentification = '" + userIdentification + "'";
            ResultSet rs = con.execSQL(sql);
            if (rs.next()) {
                return rs.getString("Title");
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return "Inside Sales Coordinator"; // mínimo acceso por defecto
    }
}