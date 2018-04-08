package com.tapjoy.mraid.util;

import com.tapjoy.TJAdUnitConstants.String;

public enum NavigationStringEnum {
    NONE("none"),
    CLOSE(String.CLOSE),
    BACK("back"),
    FORWARD("forward"),
    REFRESH("refresh");
    
    private String a;

    private NavigationStringEnum(String text) {
        this.a = text;
    }

    public final String getText() {
        return this.a;
    }

    public static NavigationStringEnum fromString(String text) {
        if (text != null) {
            for (NavigationStringEnum navigationStringEnum : values()) {
                if (text.equalsIgnoreCase(navigationStringEnum.a)) {
                    return navigationStringEnum;
                }
            }
        }
        return null;
    }
}
