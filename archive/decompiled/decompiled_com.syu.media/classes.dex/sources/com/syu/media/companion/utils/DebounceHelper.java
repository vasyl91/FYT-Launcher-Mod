package com.syu.media.companion.utils;

import chip.FinalChip;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: DebounceHelper.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJK\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/syu/media/companion/utils/DebounceHelper;", FinalChip.BSP_PLATFORM_Null, "()V", "debounceJob", "Lkotlinx/coroutines/Job;", "debounce", FinalChip.BSP_PLATFORM_Null, "delayMs", FinalChip.BSP_PLATFORM_Null, "parentScope", "Lkotlinx/coroutines/CoroutineScope;", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "debounce2", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebounceHelper {
    public static final DebounceHelper INSTANCE = new DebounceHelper();
    private static Job debounceJob;

    private DebounceHelper() {
    }

    public static /* synthetic */ void debounce$default(DebounceHelper debounceHelper, long j, CoroutineScope coroutineScope, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 50;
        }
        if ((i & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        debounceHelper.debounce(j, coroutineScope, function2);
    }

    /* JADX INFO: renamed from: com.syu.media.companion.utils.DebounceHelper$debounce$1, reason: invalid class name */
    /* JADX INFO: compiled from: DebounceHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.companion.utils.DebounceHelper$debounce$1", f = "DebounceHelper.kt", i = {0}, l = {19, 20}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ long $delayMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delayMs = j;
            this.$action = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$delayMs, this.$action, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(this.$delayMs, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$action;
            this.L$0 = null;
            this.label = 2;
            if (function2.invoke(coroutineScope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void debounce(long delayMs, CoroutineScope parentScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(action, "action");
        Job job = debounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        debounceJob = BuildersKt.launch$default(parentScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(delayMs, action, null), 3, (Object) null);
    }

    public static /* synthetic */ void debounce2$default(DebounceHelper debounceHelper, long j, CoroutineScope coroutineScope, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        if ((i & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        debounceHelper.debounce2(j, coroutineScope, function2);
    }

    /* JADX INFO: renamed from: com.syu.media.companion.utils.DebounceHelper$debounce2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DebounceHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.companion.utils.DebounceHelper$debounce2$1", f = "DebounceHelper.kt", i = {}, l = {31, 32}, m = "invokeSuspend", n = {}, s = {})
    static final class C00481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ long $delayMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00481(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, long j, Continuation<? super C00481> continuation) {
            super(2, continuation);
            this.$action = function2;
            this.$delayMs = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00481 = new C00481(this.$action, this.$delayMs, continuation);
            c00481.L$0 = obj;
            return c00481;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$action;
                this.label = 1;
                if (function2.invoke(coroutineScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            this.label = 2;
            if (DelayKt.delay(this.$delayMs, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void debounce2(long delayMs, CoroutineScope parentScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(action, "action");
        Job job = debounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        debounceJob = BuildersKt.launch$default(parentScope, (CoroutineContext) null, (CoroutineStart) null, new C00481(action, delayMs, null), 3, (Object) null);
    }
}
