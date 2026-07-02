package UTIL;

import BEAN.Users;
import DAO.UsersDAO;
import java.util.Vector;

public class MigracionPasswords {

    public static void main(String[] args) {
        UsersDAO dao = new UsersDAO();
        Vector<Users> lista = dao.listaUsers("");
        int contador = 0;

        for (Users user : lista) {
            String actual = user.getPassword();

            // Si NO se puede desencriptar, significa que está en texto plano
            String prueba = SecurityUtil.decrypt(actual);

            if (prueba == null) {
                String encriptada = SecurityUtil.encrypt(actual);
                user.setPassword(encriptada);
                dao.actualizaUser(user);
                contador++;
                System.out.println("Usuario " + user.getUserID() + " -> encriptado");
            } else {
                System.out.println("Usuario " + user.getUserID() + " ya estaba encriptado, se omite");
            }
        }

        System.out.println("Migración completa. Total actualizados: " + contador);
    }
}