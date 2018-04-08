package com.smrtbeat;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class v {
    v() {
    }

    private static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed");
        switch (i) {
            case 1:
                stringBuilder.append(" to encrypt");
                break;
            case 2:
                stringBuilder.append(" to decrypt");
                break;
            default:
                stringBuilder.append(": NOT_DEFINED_OPEMODE");
                break;
        }
        return stringBuilder.toString();
    }

    private static void a(Exception exception, int i) {
        bd.a(bg.ERROR, a(i));
    }

    private static byte[] a() {
        return ("nay" + "am" + "ag" + "u " + "meg" + "an" + "e!n" + "ay" + "ama" + "gu " + "meg" + "ane" + "!").getBytes();
    }

    private static byte[] a(int i, byte[] bArr) {
        Key secretKeySpec = new SecretKeySpec(a(), "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(b());
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            a(e, i);
            return null;
        } catch (Exception e2) {
            a(e2, i);
            return null;
        } catch (Exception e22) {
            a(e22, i);
            return null;
        } catch (Exception e222) {
            a(e222, i);
            return null;
        } catch (Exception e2222) {
            a(e2222, i);
            return null;
        } catch (Exception e22222) {
            a(e22222, i);
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        return a(1, bArr);
    }

    private static byte[] b() {
        return ("g" + "ing" + "a n" + "o " + "ys" + "ak" + "at" + "a").getBytes();
    }

    static byte[] b(byte[] bArr) {
        return a(2, bArr);
    }
}
