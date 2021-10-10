package by.training.project.service.hashing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing { // TODO question logger and exception
    private final Logger logger = LogManager.getLogger(MD5Hashing.class);

    private MD5Hashing() {
    }

    public static String hashing(String password) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (!password.isEmpty()){
            byte[] passwordMD5 = md5.digest(password.trim().getBytes());
            StringBuilder passMD5 = new StringBuilder();
            for (byte b : passwordMD5) {
                passMD5.append(String.format("%02X", b));
            }
            return passMD5.toString();
        } else {
            return "";
        }

    }

    public static boolean isValid(String password){
        return password.matches("[A-F0-9]{32}");
    }
}
