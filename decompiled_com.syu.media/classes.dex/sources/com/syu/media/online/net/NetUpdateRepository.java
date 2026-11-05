package com.syu.media.online.net;

import chip.FinalChip;
import com.syu.media.network.manager.ApiManager;
import com.syu.media.network.repository.BaseRepository;
import com.syu.media.network.response.BaseResponse;
import com.syu.media.online.model.OnlineJson;
import com.syu.radio.Radio;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NetUpdateRepository.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/syu/media/online/net/NetUpdateRepository;", "Lcom/syu/media/network/repository/BaseRepository;", "()V", "downloadOnlineData", "Lcom/syu/media/online/model/OnlineJson;", Radio.URL, FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRadioList", "versionStr", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetUpdateRepository extends BaseRepository {

    /* JADX INFO: renamed from: com.syu.media.online.net.NetUpdateRepository$updateRadioList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetUpdateRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/syu/media/network/response/BaseResponse;", "Lcom/syu/media/online/model/OnlineJson;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.net.NetUpdateRepository$updateRadioList$2", f = "NetUpdateRepository.kt", i = {}, l = {12}, m = "invokeSuspend", n = {}, s = {})
    static final class C00712 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<? extends OnlineJson>>, Object> {
        final /* synthetic */ String $versionStr;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00712(String str, Continuation<? super C00712> continuation) {
            super(1, continuation);
            this.$versionStr = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00712(this.$versionStr, continuation);
        }

        public final Object invoke(Continuation<? super BaseResponse<OnlineJson>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ApiManager.INSTANCE.getApi().updateRadioList(this.$versionStr, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Object updateRadioList(String str, Continuation<? super OnlineJson> continuation) {
        return requestResponse(new C00712(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.syu.media.online.net.NetUpdateRepository$downloadOnlineData$2, reason: invalid class name */
    /* JADX INFO: compiled from: NetUpdateRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/syu/media/network/response/BaseResponse;", "Lcom/syu/media/online/model/OnlineJson;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.net.NetUpdateRepository$downloadOnlineData$2", f = "NetUpdateRepository.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super BaseResponse<? extends OnlineJson>>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$url, continuation);
        }

        public final Object invoke(Continuation<? super BaseResponse<OnlineJson>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ApiManager.INSTANCE.getApi().downloadOnlineData(this.$url, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Object downloadOnlineData(String str, Continuation<? super OnlineJson> continuation) {
        return requestResponse(new AnonymousClass2(str, null), continuation);
    }
}
