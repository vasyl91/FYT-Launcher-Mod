package com.syu.media.network.repository;

import androidx.exifinterface.media.ExifInterface;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.network.response.BaseResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: BaseRepository.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/syu/media/network/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.network.repository.BaseRepository$requestResponse$response$1", f = "BaseRepository.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
final class BaseRepository$requestResponse$response$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseResponse<? extends T>>, Object> {
    final /* synthetic */ Function1<Continuation<? super BaseResponse<? extends T>>, Object> $requestCall;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseRepository$requestResponse$response$1(Function1<? super Continuation<? super BaseResponse<? extends T>>, ? extends Object> function1, Continuation<? super BaseRepository$requestResponse$response$1> continuation) {
        super(2, continuation);
        this.$requestCall = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseRepository$requestResponse$response$1<>(this.$requestCall, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BaseResponse<? extends T>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.syu.media.network.repository.BaseRepository$requestResponse$response$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/syu/media/network/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.network.repository.BaseRepository$requestResponse$response$1$1", f = "BaseRepository.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseResponse<? extends T>>, Object> {
        final /* synthetic */ Function1<Continuation<? super BaseResponse<? extends T>>, Object> $requestCall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1<? super Continuation<? super BaseResponse<? extends T>>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestCall = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestCall, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BaseResponse<? extends T>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HiLog.INSTANCE.d("BaseRepository", "aaaaaaaa");
                Function1<Continuation<? super BaseResponse<? extends T>>, Object> function1 = this.$requestCall;
                this.label = 1;
                obj = function1.invoke(this);
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TimeoutKt.withTimeout(50000L, new AnonymousClass1(this.$requestCall, null), (Continuation) this);
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
