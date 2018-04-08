package co.cyberz.util.string;

import java.util.regex.Pattern;

public final class a {
    public static boolean a(String str) {
        return Pattern.compile("^[a-zA-Z0-9]+$").matcher(str).find();
    }
}
