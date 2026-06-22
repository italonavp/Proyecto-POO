package Markov;

import java.sql.*;
import java.util.*;
import UTIL.dbBean;

public class MarkovDAO {

    public MarkovDAO() {
    }
    
    

    public MarkovChain construirCadenaMarkov() throws SQLException {
        MarkovChain cadena = new MarkovChain();
        Map<String, List<String>> productosPorCliente = new LinkedHashMap<>();

        String sql = "SELECT o.CustomerID, o.OrderDate, p.ProductName " +
                     "FROM Orders o " +
                     "INNER JOIN [Order Details] od ON o.OrderID = od.OrderID " +
                     "INNER JOIN Products p ON od.ProductID = p.ProductID " +
                     "ORDER BY o.CustomerID, o.OrderDate, p.ProductName";

        dbBean db = new dbBean();
        ResultSet rs = db.execSQL(sql);

        while (rs.next()) {
            String cliente = rs.getString("CustomerID");
            String producto = rs.getString("ProductName");

            if (!productosPorCliente.containsKey(cliente)) {
                productosPorCliente.put(cliente, new ArrayList<>());
            }
            productosPorCliente.get(cliente).add(producto);
        }

        db.close();

        for (List<String> productos : productosPorCliente.values()) {
            for (int i = 0; i < productos.size() - 1; i++) {
                cadena.agregarTransicion(productos.get(i), productos.get(i + 1));
            }
        }

        cadena.calcularProbabilidades();
        return cadena;
    }

    public List<String> obtenerProductos() throws SQLException {
        List<String> productos = new ArrayList<>();

        String sql = "SELECT DISTINCT p.ProductName " +
                     "FROM Products p " +
                     "INNER JOIN [Order Details] od ON p.ProductID = od.ProductID " +
                     "ORDER BY p.ProductName";

        dbBean db = new dbBean();
        ResultSet rs = db.execSQL(sql);

        while (rs.next()) {
            productos.add(rs.getString("ProductName"));
        }

        db.close();
        return productos;
    }
}