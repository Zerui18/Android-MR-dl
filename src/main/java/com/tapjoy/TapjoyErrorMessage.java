package com.tapjoy;

public class TapjoyErrorMessage {
    private ErrorType a;
    private String b;

    public enum ErrorType {
        INTERNAL_ERROR,
        SDK_ERROR,
        SERVER_ERROR,
        INTEGRATION_ERROR,
        NETWORK_ERROR
    }

    public TapjoyErrorMessage(ErrorType type, String message) {
        this.a = type;
        this.b = message;
    }

    public ErrorType getType() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type=" + this.a.toString());
        stringBuilder.append(";Message=" + this.b);
        return stringBuilder.toString();
    }
}
