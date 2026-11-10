package android.support.v4.net;

import android.net.TrafficStats;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class TrafficStatsCompatIcs {
    TrafficStatsCompatIcs() {
    }

    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    public static void incrementOperationCount(int operationCount) {
        TrafficStats.incrementOperationCount(operationCount);
    }

    public static void incrementOperationCount(int tag, int operationCount) {
        TrafficStats.incrementOperationCount(tag, operationCount);
    }

    public static void setThreadStatsTag(int tag) {
        TrafficStats.setThreadStatsTag(tag);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }
}
