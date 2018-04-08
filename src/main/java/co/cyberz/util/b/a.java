package co.cyberz.util.b;

public final class a extends Exception {
    public a() {
        super("FOX-SDK service interrupted !");
    }

    public a(String str) {
        super("FOX-SDK service interrupted for reason: " + str + " !");
    }
}
