package util;

import java.util.Base64;

public class PasswordUtil {


    public static String encrypt(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String decrypt(String encrypted) {
        return new String(Base64.getDecoder().decode(encrypted));
    }

}
