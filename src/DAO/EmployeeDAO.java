package DAO;

import BEAN.Employee;
import UTIL.dbBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class EmployeeDAO {

    // 1. LISTA EMPLEADOS (Trae todos los campos para tu tabla y tu form)
    public Vector<Employee> listaEmployees(String cad) {
        dbBean con = new dbBean();
        Vector<Employee> listaEmp = new Vector<Employee>();
        
        String sql = "SELECT EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, "
                   + "BirthDate, HireDate, Address, City, Region, PostalCode, Country, "
                   + "HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath "
                   + "FROM Employees";
        
        if (!cad.isEmpty()) {
            sql = sql + " WHERE LastName LIKE '" + cad + "%'";
        }
        
        try {
            ResultSet result = con.execSQL(sql);
            while (result != null && result.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(result.getInt(1));
                emp.setLastName(result.getString(2));
                emp.setFirstName(result.getString(3));
                emp.setTitle(result.getString(4));
                emp.setTitleOfCourtesy(result.getString(5));
                emp.setBirthDate(result.getDate(6));
                emp.setHireDate(result.getDate(7));
                emp.setAddress(result.getString(8));
                emp.setCity(result.getString(9));
                emp.setRegion(result.getString(10));
                emp.setPostalCode(result.getString(11));
                emp.setCountry(result.getString(12));
                emp.setHomePhone(result.getString(13));
                emp.setExtension(result.getString(14));

                // Algoritmo para limpiar la imagen de los 78 bytes (Tu requerimiento 3)
                byte[] imgBytes = result.getBytes(15);
                if (imgBytes != null && imgBytes.length > 78) {
                    if (imgBytes[78] == 66 && imgBytes[79] == 77) {
                        byte[] cleanImg = java.util.Arrays.copyOfRange(imgBytes, 78, imgBytes.length);
                        emp.setPhoto(cleanImg);
                    } else {
                        emp.setPhoto(imgBytes);
                    }
                } else {
                    emp.setPhoto(imgBytes);
                }

                emp.setNotes(result.getString(16));
                emp.setReportsTo(result.getInt(17));
                emp.setPhotoPath(result.getString(18));

                listaEmp.addElement(emp);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return listaEmp;
    }

    // 2. LISTA JEFES (Este es tu equivalente a "listaCargos()" de tu cuaderno)
    public Vector<Employee> listaCmbEmployee() {
        dbBean con = new dbBean();
        Vector<Employee> listaJefes = new Vector<Employee>();
        String sql = "SELECT EmployeeID, FirstName, LastName FROM Employees";
        
        try {
            ResultSet result = con.execSQL(sql);
            while (result != null && result.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(result.getInt(1));
                emp.setFirstName(result.getString(2) + " " + result.getString(3)); 
                listaJefes.addElement(emp);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return listaJefes;
    }

    // 3. INSERTA EMPLEADO (Directo, confiando en tu validación del formulario)
    public void insertaEmployee(Employee emp) {
        dbBean con = new dbBean();
        String sql = "INSERT INTO Employees (LastName, FirstName, Title, TitleOfCourtesy, BirthDate, "
                   + "HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, "
                   + "Photo, Notes, ReportsTo, PhotoPath) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conexion = con.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            
            pstmt.setString(1, emp.getLastName());
            pstmt.setString(2, emp.getFirstName());
            pstmt.setString(3, emp.getTitle());
            pstmt.setString(4, emp.getTitleOfCourtesy());
            pstmt.setDate(5, emp.getBirthDate()); 
            pstmt.setDate(6, emp.getHireDate()); 
            pstmt.setString(7, emp.getAddress());
            pstmt.setString(8, emp.getCity()); 
            pstmt.setString(9, emp.getRegion());
            pstmt.setString(10, emp.getPostalCode());
            pstmt.setString(11, emp.getCountry());
            pstmt.setString(12, emp.getHomePhone());
            pstmt.setString(13, emp.getExtension());
            pstmt.setBytes(14, emp.getPhoto());
            pstmt.setString(15, emp.getNotes());
            pstmt.setInt(16, emp.getReportsTo()); 
            pstmt.setString(17, emp.getPhotoPath());
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
    }
    public boolean existeEmpleado(String firstName, String lastName) {
        dbBean con = new dbBean();
        String sql = "SELECT COUNT(*) FROM Employees WHERE FirstName = '" + firstName + "' AND LastName = '" + lastName + "'";
        try {
            ResultSet rs = con.execSQL(sql);
            if (rs != null && rs.next() && rs.getInt(1) > 0) {
                return true; // Significa que ya existe
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return false; // No existe, es seguro registrar
    }

    // 4. ACTUALIZA EMPLEADO (Directo, confiando en tu validación del formulario)
    public void actualizaEmployee(Employee emp) {
        dbBean con = new dbBean();
        String sql = "UPDATE Employees SET LastName=?, FirstName=?, Title=?, TitleOfCourtesy=?, "
                   + "BirthDate=?, HireDate=?, Address=?, City=?, Region=?, PostalCode=?, "
                   + "Country=?, HomePhone=?, Extension=?, Photo=?, Notes=?, ReportsTo=?, "
                   + "PhotoPath=? WHERE EmployeeID=?";
        
        try {
            Connection conexion = con.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            
            pstmt.setString(1, emp.getLastName());
            pstmt.setString(2, emp.getFirstName());
            pstmt.setString(3, emp.getTitle());
            pstmt.setString(4, emp.getTitleOfCourtesy());
            pstmt.setDate(5, emp.getBirthDate());
            pstmt.setDate(6, emp.getHireDate());
            pstmt.setString(7, emp.getAddress());
            pstmt.setString(8, emp.getCity()); 
            pstmt.setString(9, emp.getRegion());
            pstmt.setString(10, emp.getPostalCode());
            pstmt.setString(11, emp.getCountry());
            pstmt.setString(12, emp.getHomePhone());
            pstmt.setString(13, emp.getExtension());
            pstmt.setBytes(14, emp.getPhoto());
            pstmt.setString(15, emp.getNotes());
            pstmt.setInt(16, emp.getReportsTo());
            pstmt.setString(17, emp.getPhotoPath());
            pstmt.setInt(18, emp.getEmployeeID());
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
    }

    // 5. ELIMINA EMPLEADO (Tu arquitectura defensiva intocable)
    public int eliminaEmployee(int idEmpleado) {
        dbBean con = new dbBean();
        int validacion = 0;
        
        try {
            String sqlCheckUsers = "SELECT COUNT(*) FROM Users WHERE EmployeeId = " + idEmpleado;
            ResultSet rsUsers = con.execSQL(sqlCheckUsers);
            if (rsUsers != null && rsUsers.next() && rsUsers.getInt(1) > 0) return 1; 

            String sqlCheckOrders = "SELECT COUNT(*) FROM Orders WHERE EmployeeID = " + idEmpleado;
            ResultSet rsOrders = con.execSQL(sqlCheckOrders);
            if (rsOrders != null && rsOrders.next() && rsOrders.getInt(1) > 0) return 2; 

            String sqlCheckTerrs = "SELECT COUNT(*) FROM EmployeeTerritories WHERE EmployeeID = " + idEmpleado;
            ResultSet rsTerrs = con.execSQL(sqlCheckTerrs);
            if (rsTerrs != null && rsTerrs.next() && rsTerrs.getInt(1) > 0) return 3;

            String sqlCheckJefe = "SELECT COUNT(*) FROM Employees WHERE ReportsTo = " + idEmpleado;
            ResultSet rsJefe = con.execSQL(sqlCheckJefe);
            if (rsJefe != null && rsJefe.next() && rsJefe.getInt(1) > 0) return 4;

            String sqlDelete = "DELETE FROM Employees WHERE EmployeeID = " + idEmpleado;
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