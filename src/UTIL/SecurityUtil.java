package UTIL;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecurityUtil {
    
    private static final String SECRET_KEY = "1234567890123456"; 

    
    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeySpec secretKey =
                    new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return new String(
                    cipher.doFinal(
                            Base64.getDecoder().decode(strToDecrypt)));

        } catch (Exception e) {
            return null;
        }
    }
}