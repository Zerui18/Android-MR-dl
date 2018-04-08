package com.smrtbeat;

class bc {
    bc() {
    }

    static ar a(at atVar, long j) {
        Thread thread = new Thread(atVar);
        thread.start();
        if (j > 0) {
            try {
                thread.join(j);
            } catch (InterruptedException e) {
            }
        } else {
            thread.join();
        }
        ar a = atVar.a();
        return a == null ? new ar() : a;
    }
}
