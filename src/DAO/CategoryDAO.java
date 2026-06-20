package DAO;

import BEAN.Category;
import UTIL.dbBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class CategoryDAO {

    // 1. LISTA CATEGORÍAS (Trae todos los campos y limpia la foto OLE)
    public Vector<Category> listaCategories(String cad) {
        dbBean con = new dbBean();
        Vector<Category> listaCat = new Vector<Category>();
        
        String sql = "SELECT CategoryID, CategoryName, Description, Picture FROM Categories";
        
        if (!cad.isEmpty()) {
            sql = sql + " WHERE CategoryName LIKE '" + cad + "%'";
        }
        
        try {
            ResultSet result = con.execSQL(sql);
            while (result != null && result.next()) {
                Category cat = new Category();
                cat.setCategoryID(result.getInt(1));
                cat.setCategoryName(result.getString(2));
                cat.setDescription(result.getString(3));

                // Algoritmo de limpieza de imagen (Los famosos 78 bytes)
                byte[] imgBytes = result.getBytes(4);
                if (imgBytes != null && imgBytes.length > 78) {
                    if (imgBytes[78] == 66 && imgBytes[79] == 77) {
                        byte[] cleanImg = java.util.Arrays.copyOfRange(imgBytes, 78, imgBytes.length);
                        cat.setPicture(cleanImg);
                    } else {
                        cat.setPicture(imgBytes);
                    }
                } else {
                    cat.setPicture(imgBytes);
                }

                listaCat.addElement(cat);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return listaCat;
    }

    // 2. MÉTODO ANTIDUPLICADOS (Para usar en tu botón Grabar)
    public boolean existeCategory(String categoryName) {
        dbBean con = new dbBean();
        String sql = "SELECT COUNT(*) FROM Categories WHERE CategoryName = '" + categoryName + "'";
        try {
            ResultSet rs = con.execSQL(sql);
            if (rs != null && rs.next() && rs.getInt(1) > 0) {
                return true; // La categoría ya existe
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return false; 
    }

    // 3. INSERTA CATEGORÍA
    public void insertaCategory(Category cat) {
        dbBean con = new dbBean();
        String sql = "INSERT INTO Categories (CategoryName, Description, Picture) VALUES (?, ?, ?)";
        
        try {
            Connection conexion = con.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            
            pstmt.setString(1, cat.getCategoryName());
            pstmt.setString(2, cat.getDescription());
            pstmt.setBytes(3, cat.getPicture());
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
    }

    // 4. ACTUALIZA CATEGORÍA
    public void actualizaCategory(Category cat) {
        dbBean con = new dbBean();
        String sql = "UPDATE Categories SET CategoryName=?, Description=?, Picture=? WHERE CategoryID=?";
        
        try {
            Connection conexion = con.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            
            pstmt.setString(1, cat.getCategoryName());
            pstmt.setString(2, cat.getDescription());
            pstmt.setBytes(3, cat.getPicture());
            pstmt.setInt(4, cat.getCategoryID());
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
    }

    // 5. ELIMINA CATEGORÍA (Validación Defensiva)
    // Retorna: 0 (Éxito), 1 (Bloqueado por Products), -1 (Error SQL)
    public int eliminaCategory(int idCategoria) {
        dbBean con = new dbBean();
        int validacion = 0;
        
        try {
            // Escudo de Integridad: Verificamos si la categoría tiene productos asignados
            String sqlCheckProducts = "SELECT COUNT(*) FROM Products WHERE CategoryID = " + idCategoria;
            ResultSet rsProducts = con.execSQL(sqlCheckProducts);
            if (rsProducts != null && rsProducts.next() && rsProducts.getInt(1) > 0) return 1; 

            // Si pasa el escudo, borramos físicamente
            String sqlDelete = "DELETE FROM Categories WHERE CategoryID = " + idCategoria;
            con.updateSQL(sqlDelete);
            return 0; 
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            validacion = -1; 
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return validacion;
    }
}