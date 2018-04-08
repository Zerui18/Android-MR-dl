package com.smrtbeat;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;

class ak {
    ak() {
    }

    private static ActivityLifecycleCallbacks a() {
        return new al();
    }

    static void a(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(a());
        } else {
            bd.a(bg.ERROR, "Failed to register activity lifecycle callback");
        }
    }
}
