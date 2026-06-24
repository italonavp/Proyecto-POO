package DATOS;

import MODELO.Registro;
import UTIL.dbBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de Acceso a Datos (DAO) que consolida la información relacional.
 * Transforma el modelo transaccional en un modelo agregativo apto para Machine Learning.
 */
public class ClienteCategoriaDAO {

    /**
     * Extrae y consolida el historial de comportamiento del consumidor en Northwind.
     * @return List de objetos Registro mapeados desde la BD.
     */
    public List<Registro> obtenerDatosParaArbol() {
        List<Registro> listaPlanificada = new ArrayList<>();
        
        // QUERY MAESTRO: Unificación relacional de 5 tablas con agregación y cálculo del Target
        String sql = "SELECT " +
                     "  c.CustomerID AS IdCliente, " +
                     "  c.Country AS Pais, " +
                     "  cat.CategoryName AS Categoria, " +
                     "  SUM((od.UnitPrice * od.Quantity) * (1 - od.Discount)) AS MontoTotal, " +
                     "  SUM(od.Quantity) AS CantidadTotal, " +
                     "  CASE WHEN COUNT(DISTINCT o.OrderID) > 1 THEN 1 ELSE 0 END AS VolvioAComprar " +
                     "FROM Customers c " +
                     "JOIN Orders o ON c.CustomerID = o.CustomerID " +
                     "JOIN [Order Details] od ON o.OrderID = od.OrderID " +
                     "JOIN Products p ON od.ProductID = p.ProductID " +
                     "JOIN Categories cat ON p.CategoryID = cat.CategoryID " +
                     "GROUP BY c.CustomerID, c.Country, cat.CategoryID, cat.CategoryName";

        // 1. Instanciamos dbBean para que ejecute su constructor e inicie la conexión internamente
        dbBean db = new dbBean();

        // 2. Extraemos la conexión mediante db.getConnection() dentro del try-with-resources
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String idCliente = rs.getString("IdCliente"); 
                String pais = rs.getString("Pais");
                String categoria = rs.getString("Categoria");
                double montoTotal = rs.getDouble("MontoTotal");
                int cantidadTotal = rs.getInt("CantidadTotal");
                int volvioAComprar = rs.getInt("VolvioAComprar");
                
                // Mapeo directo al objeto de la capa de Modelo
                Registro registro = new Registro(idCliente, pais, categoria, montoTotal, cantidadTotal, volvioAComprar);
                listaPlanificada.add(registro);
            }
            
            System.out.println("Datos cargados con éxito. Total de registros para el árbol: " + listaPlanificada.size());

        } catch (SQLException e) {
            System.err.println("Error en la extracción relacional: " + e.getMessage());
        }

        return listaPlanificada;
    }
}