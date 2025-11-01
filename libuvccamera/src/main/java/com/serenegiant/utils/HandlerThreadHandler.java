package com.serenegiant.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class HandlerThreadHandler extends Handler {
    private HandlerThread mHandlerThread;

    private HandlerThreadHandler(Looper looper) {
        super(looper);
    }

    public static HandlerThreadHandler createHandler(String name) {
        HandlerThread thread = new HandlerThread(name);
        thread.start();
        return new HandlerThreadHandler(thread.getLooper());
    }

    public void release() {
        if (mHandlerThread != null) {
            mHandlerThread.quit();
            mHandlerThread = null;
        }
    }
}