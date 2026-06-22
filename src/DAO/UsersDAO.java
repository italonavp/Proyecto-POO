package DAO;
import BEAN.*;
import UTIL.*;
import java.util.Vector;
import java.sql.ResultSet;

public class UsersDAO {

    public UsersDAO() {
    }

    public Vector<Users> listaUsers(String cad) {
        ResultSet resultUsers;
        Vector<Users> listUsers = new Vector<Users>();
        dbBean con = new dbBean();
        String sql;

        try {
            sql = "SELECT * FROM Users";

            if (!cad.isEmpty()) {
                sql += " WHERE userIdentification LIKE '" + cad + "%'";
            }

            resultUsers = con.execSQL(sql);

            while (resultUsers.next()) {
                Users user = new Users();

                user.setUserID(resultUsers.getInt(1));
                user.setEmployeeID(resultUsers.getInt(2));
                user.setUserIdentification(resultUsers.getString(3));
                user.setPassword(resultUsers.getString(4));
                user.setStatus(resultUsers.getInt(5));

                listUsers.add(user);
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        return listUsers;
    }

    public void insertaUser(Users user) {
        dbBean con = new dbBean();
        String sql;

        try {
            sql = "INSERT INTO Users VALUES (";
            sql +=""+ user.getUserID() + ", ";
            sql +=""+ user.getEmployeeID() + ", '";
            sql +=""+ user.getUserIdentification() + "', '";
            sql +=""+ user.getPassword() + "', ";
            sql +=""+ user.getStatus() + ")";

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

    public void actualizaUser(Users user) {
        dbBean con = new dbBean();
        String sql;

        try {
            sql = "UPDATE Users SET ";
            sql += "EmployeeId = " + user.getEmployeeID() + ", ";
            sql += "userIdentification = '" + user.getUserIdentification() + "', ";
            sql += "password = '" + user.getPassword() + "', ";
            sql += "status = " + user.getStatus();
            sql += " WHERE UserId = " + user.getUserID();

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

    public void eliminaUser(Users user) {
        dbBean con = new dbBean();
        String sql;

        try {
            sql = "DELETE FROM Users WHERE UserId = " + user.getUserID();

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
}
