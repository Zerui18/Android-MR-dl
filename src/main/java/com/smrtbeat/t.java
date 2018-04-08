package com.smrtbeat;

class t implements Runnable {
    t() {
    }

    public void run() {
        if (i.c.tryLock()) {
            try {
                i.l();
            } finally {
                i.c.unlock();
            }
        }
    }
}
