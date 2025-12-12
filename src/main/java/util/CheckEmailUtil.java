package util;

import exception.WrongEmailException;

public abstract class CheckEmailUtil {

    public static String isValidEmail(String email) throws WrongEmailException {
        if (checkEmail(email)) {
            return email;
        }
        throw new WrongEmailException("Wrong email, please input try again !!!");
    }

    private static boolean checkEmail(String email) {
        return email.contains("@");
    }
}
