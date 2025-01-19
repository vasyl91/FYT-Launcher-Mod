package com.android.launcher66;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DeferredHandler {
    private LinkedList<Pair<Runnable, Integer>> mQueue = new LinkedList<>();
    private MessageQueue mMessageQueue = Looper.myQueue();
    private Impl mHandler = new Impl(this, null);

    private class Impl extends Handler implements MessageQueue.IdleHandler {
        private Impl() {
        }

        /* synthetic */ Impl(DeferredHandler deferredHandler, Impl impl) {
            this();
        }

        @Override
        public void handleMessage(Message msg) {
            synchronized (DeferredHandler.this.mQueue) {
                if (DeferredHandler.this.mQueue.size() != 0) {
                    Pair<Runnable, Integer> p = (Pair) DeferredHandler.this.mQueue.removeFirst();
                    Runnable r = (Runnable) p.first;
                    r.run();
                    synchronized (DeferredHandler.this.mQueue) {
                        DeferredHandler.this.scheduleNextLocked();
                    }
                }
            }
        }

        @Override
        public boolean queueIdle() {
            handleMessage(null);
            return false;
        }
    }

    private class IdleRunnable implements Runnable {
        Runnable mRunnable;

        IdleRunnable(Runnable r) {
            this.mRunnable = r;
        }

        @Override
        public void run() {
            this.mRunnable.run();
        }
    }

    public void post(Runnable runnable) {
        post(runnable, 0);
    }

    public void post(Runnable runnable, int type) {
        synchronized (this.mQueue) {
            this.mQueue.add(new Pair<>(runnable, Integer.valueOf(type)));
            if (this.mQueue.size() == 1) {
                scheduleNextLocked();
            }
        }
    }

    public void postIdle(Runnable runnable) {
        postIdle(runnable, 0);
    }

    public void postIdle(Runnable runnable, int type) {
        post(new IdleRunnable(runnable), type);
    }

    public void cancelRunnable(Runnable runnable) {
        synchronized (this.mQueue) {
            do {
            } while (this.mQueue.remove(runnable));
        }
    }

    public void cancelAllRunnablesOfType(int type) {
        synchronized (this.mQueue) {
            ListIterator<Pair<Runnable, Integer>> iter = this.mQueue.listIterator();
            while (iter.hasNext()) {
                Pair<Runnable, Integer> p = iter.next();
                if (((Integer) p.second).intValue() == type) {
                    iter.remove();
                }
            }
        }
    }

    public void cancel() {
        synchronized (this.mQueue) {
            this.mQueue.clear();
        }
    }

    public void flush() {
        LinkedList<Pair<Runnable, Integer>> queue = new LinkedList<>();
        synchronized (this.mQueue) {
            queue.addAll(this.mQueue);
            this.mQueue.clear();
        }
        Iterator<Pair<Runnable, Integer>> it = queue.iterator();
        while (it.hasNext()) {
            Pair<Runnable, Integer> p = it.next();
            ((Runnable) p.first).run();
        }
    }

    void scheduleNextLocked() {
        if (this.mQueue.size() > 0) {
            Pair<Runnable, Integer> p = this.mQueue.getFirst();
            Runnable peek = (Runnable) p.first;
            if (peek instanceof IdleRunnable) {
                this.mMessageQueue.addIdleHandler(this.mHandler);
            } else {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }
}
