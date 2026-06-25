package UTIL;

import UTIL.dbBean;
import java.sql.ResultSet;

public class EncriptaExistentes {

    public static void main(String[] args) {

        dbBean con = new dbBean();

        try {
            // 1. Traer todos los usuarios
            String sqlSelect = "SELECT UserId, password FROM Users";
            ResultSet rs = con.execSQL(sqlSelect);

            // Guardamos los datos en listas para no tener dos conexiones abiertas
            java.util.Vector<Integer> ids = new java.util.Vector<>();
            java.util.Vector<String> passwords = new java.util.Vector<>();

            while (rs.next()) {
                ids.add(rs.getInt("UserId"));
                passwords.add(rs.getString("password"));
            }
            con.close();

            // 2. Por cada usuario, intentar desencriptar
            for (int i = 0; i < ids.size(); i++) {
                int id = ids.get(i);
                String passActual = passwords.get(i).trim();

                // Si ya está encriptada, decrypt devuelve algo distinto de null
                String intento = SecurityUtil.decrypt(passActual);

                if (intento == null) {
                    // Está en texto plano → la encriptamos
                    String passEncriptada = SecurityUtil.encrypt(passActual);

                    dbBean conUpdate = new dbBean();
                    String sqlUpdate = "UPDATE Users SET password = '"
                            + passEncriptada + "' WHERE UserId = " + id;
                    conUpdate.updateSQL(sqlUpdate);
                    conUpdate.close();

                    System.out.println(" Usuario ID " + id + " encriptado correctamente.");
                } else {
                    // Ya estaba encriptada, no tocamos nada
                    System.out.println(" Usuario ID " + id + " ya estaba encriptado. Sin cambios.");
                }
            }

            System.out.println("\n✅ Proceso finalizado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}