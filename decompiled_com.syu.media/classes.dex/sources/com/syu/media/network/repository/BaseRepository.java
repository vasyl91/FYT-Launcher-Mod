package com.syu.media.network.repository;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.network.response.BaseResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BaseRepository.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042$\u0010\u0005\u001a \b\u0001\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/syu/media/network/repository/BaseRepository;", FinalChip.BSP_PLATFORM_Null, "()V", "requestResponse", ExifInterface.GPS_DIRECTION_TRUE, "requestCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/syu/media/network/response/BaseResponse;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseRepository {

    /* JADX INFO: renamed from: com.syu.media.network.repository.BaseRepository$requestResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseRepository.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.network.repository.BaseRepository", f = "BaseRepository.kt", i = {}, l = {12}, m = "requestResponse", n = {}, s = {})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseRepository.this.requestResponse(null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object requestResponse(Function1<? super Continuation<? super BaseResponse<? extends T>>, ? extends Object> function1, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineContext io = Dispatchers.getIO();
            BaseRepository$requestResponse$response$1 baseRepository$requestResponse$response$1 = new BaseRepository$requestResponse$response$1(function1, null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io, baseRepository$requestResponse$response$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        BaseResponse baseResponse = (BaseResponse) objWithContext;
        if (baseResponse == null) {
            return null;
        }
        HiLog.INSTANCE.d("BaseRepository", "JsonResponse code:" + baseResponse.getResultcode() + " ,version:" + baseResponse.getVersion());
        return baseResponse.getResult();
    }
}
