package org.example;

public class Thread2 {
    private CallBack callBack;

    public Thread2(CallBack callBack) {
        this.callBack = callBack;
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        callBack.call();
    }
}
