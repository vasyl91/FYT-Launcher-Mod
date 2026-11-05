package com.syu.media.network.interceptor;

import android.content.Context;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.NetworkUtil;
import com.syu.media.network.error.ERROR;
import com.syu.media.network.error.NoNetWorkException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: NetWorkInterceptor.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/syu/media/network/interceptor/NetWorkInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetWorkInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws NoNetWorkException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (NetworkUtil.INSTANCE.isConnected((Context) MediaApp.INSTANCE.getMe())) {
            Response responseProceed = chain.proceed(chain.request());
            Intrinsics.checkNotNullExpressionValue(responseProceed, "chain.proceed(request)");
            return responseProceed;
        }
        throw new NoNetWorkException(ERROR.NETWORD_ERROR, null, 2, null);
    }
}
