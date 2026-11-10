package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    RouteDatabase() {
    }

    public synchronized void failed(Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.failedRoutes.contains(route);
    }
}
