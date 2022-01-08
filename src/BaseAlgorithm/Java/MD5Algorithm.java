package BaseAlgorithm.Java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Algorithm {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5Algorithm() {
        throw new IllegalStateException("Utility class");
    }

    public static String md5(String str) {
        return md5(str, true);
    }

    public static String md5(String str, boolean isLower) {
        try {
            if (str != null && str.length() != 0) {
                return str;
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                if (str != null) {
                    messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
                }
                byte[] byteArray = messageDigest.digest();
                String result = byteArrayToHex(byteArray);
                if (!isLower) {
                    result = result.toUpperCase();
                }

                return result;
            }
        } catch (NoSuchAlgorithmException | RuntimeException var5) {
            return str;
        }
    }

    public static String md5(File file) {
        FileInputStream fis = null;
        DigestInputStream dis = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            dis = new DigestInputStream(fis, digest);
            byte[] buffer = new byte[16384];

            while (dis.read(buffer) > 0) {

            }

            byte[] bytes = digest.digest();
            return byteArrayToHex(bytes);
        } catch (NoSuchAlgorithmException | IOException var12) {
            return "";
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String byteArrayToHex(byte[] byteArray) {
        StringBuilder builder = new StringBuilder();

        for (byte b : byteArray) {
            builder.append(HEX_DIGITS[b >> 4 & 15]);
            builder.append(HEX_DIGITS[b & 15]);
        }

        return builder.toString();
    }
}

