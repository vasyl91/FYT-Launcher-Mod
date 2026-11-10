package com.syu.media.network.interceptor;

import com.syu.media.companion.utils.HiLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: HeaderInterceptor.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/syu/media/network/interceptor/HeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        builderNewBuilder.addHeader("Content-type", "application/json; charset=utf-8");
        builderNewBuilder.addHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        HiLog.INSTANCE.d("HeaderInterceptor", "------->>> HeaderInterceptor{" + chain.request().headers() + '}');
        HiLog.INSTANCE.d("HeaderInterceptor", "------->>> HeaderInterceptor{" + chain + '}');
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        Intrinsics.checkNotNullExpressionValue(responseProceed, "chain.proceed(newBuilder.build())");
        return responseProceed;
    }
}
