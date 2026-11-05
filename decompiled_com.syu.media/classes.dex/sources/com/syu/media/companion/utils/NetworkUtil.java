package com.syu.media.companion.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUtil.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/syu/media/companion/utils/NetworkUtil;", FinalChip.BSP_PLATFORM_Null, "()V", "getNetworkType", "Lcom/syu/media/companion/utils/NetworkType;", "context", "Landroid/content/Context;", "getOperatorName", FinalChip.BSP_PLATFORM_Null, "isConnected", FinalChip.BSP_PLATFORM_Null, "isWeakNetwork", "ctx", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkUtil {
    public static final NetworkUtil INSTANCE = new NetworkUtil();

    private NetworkUtil() {
    }

    public final boolean isConnected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    public final NetworkType getNetworkType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        boolean z = false;
        if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
            z = true;
        }
        if (z) {
            return NetworkType.NETWORK_WIFI;
        }
        Object systemService2 = context.getSystemService("phone");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        switch (((TelephonyManager) systemService2).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
                return NetworkType.NETWORK_4G;
            case 18:
                return NetworkType.NETWORK_WIFI;
            case 19:
            default:
                return NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    public final String getOperatorName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        String simOperatorName = ((TelephonyManager) systemService).getSimOperatorName();
        Intrinsics.checkNotNullExpressionValue(simOperatorName, "tm.simOperatorName");
        return simOperatorName;
    }

    public final boolean isWeakNetwork(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!isConnected(ctx)) {
            return true;
        }
        NetworkType networkType = getNetworkType(ctx);
        return (networkType == NetworkType.NETWORK_WIFI || networkType == NetworkType.NETWORK_4G || networkType == NetworkType.NETWORK_5G) ? false : true;
    }
}
