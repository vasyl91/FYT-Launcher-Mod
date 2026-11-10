package android.support.v4.net;

import android.os.Build;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket) throws SocketException;

        void untagSocket(Socket socket) throws SocketException;
    }

    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal<SocketTags>() { // from class: android.support.v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public SocketTags initialValue() {
                return new SocketTags();
            }
        };

        private static class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }
        }

        BaseTrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            this.mThreadSocketTags.get().statsTag = -1;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return this.mThreadSocketTags.get().statsTag;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int operationCount) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int tag, int operationCount) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int tag) {
            this.mThreadSocketTags.get().statsTag = tag;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) {
        }
    }

    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(operationCount);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int tag, int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(tag, operationCount);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int tag) {
            TrafficStatsCompatIcs.setThreadStatsTag(tag);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int operationCount) {
        IMPL.incrementOperationCount(operationCount);
    }

    public static void incrementOperationCount(int tag, int operationCount) {
        IMPL.incrementOperationCount(tag, operationCount);
    }

    public static void setThreadStatsTag(int tag) {
        IMPL.setThreadStatsTag(tag);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}
