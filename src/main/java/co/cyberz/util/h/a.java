package co.cyberz.util.h;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static final String[] a = new String[]{"AES"};

    public enum a {
        XUNIQ(0, "a582a79754ac4f5fb75bc18271e4712c"),
        SERVER_URL(1, "910c256430ae453496018633be5e1629");
        
        int c;
        byte[] d;

        private a(int i, String str) {
            this.c = i;
            this.d = a.f(str);
        }

        public static a a(int i) {
            for (a aVar : values()) {
                if (aVar.c == i) {
                    return aVar;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown key index: " + i);
            return null;
        }
    }

    public static String a(String str) {
        String str2 = null;
        try {
            str2 = e(str);
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e2) {
        } catch (InvalidKeyException e3) {
        } catch (IllegalBlockSizeException e4) {
        } catch (BadPaddingException e5) {
        }
        return str2;
    }

    public static String a(String str, a aVar) {
        String str2 = a[0];
        Cipher instance = Cipher.getInstance(str2);
        instance.init(1, new SecretKeySpec(aVar.d, str2));
        return Integer.toString(0) + Integer.toString(aVar.c) + a(instance.doFinal(str.getBytes()));
    }

    private static String a(String str, String str2) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        instance.update(str.getBytes());
        return a(instance.digest());
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        return a(str, "MD5");
    }

    public static String c(String str) {
        return a(str, "SHA-1");
    }

    private static String e(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(0, 1));
            try {
                int parseInt2 = Integer.parseInt(str.substring(1, 2));
                if (parseInt < 0 || parseInt >= a.length) {
                    throw new NoSuchAlgorithmException("Invalid algorithm index.");
                }
                try {
                    if (a.a(parseInt2) == null) {
                        throw new InvalidKeyException("Invalid key index.");
                    }
                    String str2 = a[parseInt];
                    a a = a.a(parseInt2);
                    String substring = str.substring(2);
                    Cipher instance = Cipher.getInstance(str2);
                    instance.init(2, new SecretKeySpec(a.d, str2));
                    return new String(instance.doFinal(f(substring)));
                } catch (Exception e) {
                    throw new InvalidKeyException("Invalid key index.");
                }
            } catch (Exception e2) {
                throw new InvalidKeyException(e2.getMessage());
            }
        } catch (Exception e22) {
            throw new NoSuchAlgorithmException(e22.getMessage());
        }
    }

    private static byte[] f(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
