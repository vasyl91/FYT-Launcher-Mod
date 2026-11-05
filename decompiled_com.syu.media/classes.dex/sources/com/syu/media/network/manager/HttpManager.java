package com.syu.media.network.manager;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.network.constant.HttpConstantKt;
import com.syu.media.network.interceptor.HeaderInterceptor;
import com.syu.media.network.interceptor.NetWorkInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: HttpManager.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/syu/media/network/manager/HttpManager;", FinalChip.BSP_PLATFORM_Null, "()V", "retrofit", "Lretrofit2/Retrofit;", "create", ExifInterface.GPS_DIRECTION_TRUE, "apiService", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "initOkHttpClient", "Lokhttp3/OkHttpClient;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HttpManager {
    public static final HttpManager INSTANCE;
    private static final Retrofit retrofit;

    private HttpManager() {
    }

    static {
        HttpManager httpManager = new HttpManager();
        INSTANCE = httpManager;
        Retrofit retrofitBuild = new Retrofit.Builder().client(httpManager.initOkHttpClient()).baseUrl(HttpConstantKt.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder().client(initOkH…Factory.create()).build()");
        retrofit = retrofitBuild;
    }

    public final <T> T create(Class<T> apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        HiLog hiLog = HiLog.INSTANCE;
        StringBuilder sb = new StringBuilder("retrofit:");
        Retrofit retrofit2 = retrofit;
        hiLog.d("HttpManager", sb.append(retrofit2).toString());
        return (T) retrofit2.create(apiService);
    }

    private final OkHttpClient initOkHttpClient() {
        Interceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.syu.media.network.manager.HttpManager$$ExternalSyntheticLambda0
            public final void log(String str) {
                HttpManager.m196initOkHttpClient$lambda0(str);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(12L, TimeUnit.SECONDS).writeTimeout(12L, TimeUnit.SECONDS).readTimeout(12L, TimeUnit.SECONDS).addInterceptor(new HeaderInterceptor()).addInterceptor(new NetWorkInterceptor()).addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "Builder().connectTimeout…r(logInterceptor).build()");
        return okHttpClientBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initOkHttpClient$lambda-0, reason: not valid java name */
    public static final void m196initOkHttpClient$lambda0(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        HiLog.INSTANCE.d("okhttp", "data:" + str);
    }
}
