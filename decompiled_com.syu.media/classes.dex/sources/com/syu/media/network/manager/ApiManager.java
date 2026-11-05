package com.syu.media.network.manager;

import chip.FinalChip;
import com.syu.media.network.api.ApiInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ApiManager.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/syu/media/network/manager/ApiManager;", FinalChip.BSP_PLATFORM_Null, "()V", "api", "Lcom/syu/media/network/api/ApiInterface;", "getApi", "()Lcom/syu/media/network/api/ApiInterface;", "api$delegate", "Lkotlin/Lazy;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApiManager {
    public static final ApiManager INSTANCE = new ApiManager();

    /* JADX INFO: renamed from: api$delegate, reason: from kotlin metadata */
    private static final Lazy api = LazyKt.lazy(new Function0<ApiInterface>() { // from class: com.syu.media.network.manager.ApiManager$api$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ApiInterface m194invoke() {
            return (ApiInterface) HttpManager.INSTANCE.create(ApiInterface.class);
        }
    });

    private ApiManager() {
    }

    public final ApiInterface getApi() {
        return (ApiInterface) api.getValue();
    }
}
