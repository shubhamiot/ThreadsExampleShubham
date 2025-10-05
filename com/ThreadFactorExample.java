package com;

import java.util.concurrent.ThreadFactory;

public class ThreadFactorExample implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread();
        thread.setDaemon(false);
        thread.setPriority(Thread.NORM_PRIORITY);
        return thread;
    }
}
