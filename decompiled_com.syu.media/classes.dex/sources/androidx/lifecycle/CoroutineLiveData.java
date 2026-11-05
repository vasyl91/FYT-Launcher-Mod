package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", FinalChip.BSP_PLATFORM_Null, "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (CoroutineContext) EmptyCoroutineContext.INSTANCE : coroutineContext, (i & 2) != 0 ? CoroutineLiveDataKt.DEFAULT_TIMEOUT : j, function2);
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(function2, "block");
        this.blockRunner = new BlockRunner<>(this, function2, j, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(coroutineContext).plus(SupervisorKt.SupervisorJob(coroutineContext.get(Job.Key)))), new Function0<Unit>() { // from class: androidx.lifecycle.CoroutineLiveData.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m35invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m35invoke() {
                CoroutineLiveData.this.blockRunner = null;
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            if ((coroutineLiveData$emitSource$1.label & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label -= Integer.MIN_VALUE;
            } else {
                coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
            }
        } else {
            coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
        }
        Object objAddDisposableSource = coroutineLiveData$emitSource$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = coroutineLiveData$emitSource$1.label;
        if (i != 0) {
            if (i == 1) {
                LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                CoroutineLiveData<T> coroutineLiveData2 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                ResultKt.throwOnFailure(objAddDisposableSource);
                liveData2 = liveData3;
                coroutineLiveData = coroutineLiveData2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                ResultKt.throwOnFailure(objAddDisposableSource);
            }
            EmittedSource emittedSource = (EmittedSource) objAddDisposableSource;
            coroutineLiveData.emittedSource = emittedSource;
            return emittedSource;
        }
        ResultKt.throwOnFailure(objAddDisposableSource);
        coroutineLiveData$emitSource$1.L$0 = this;
        coroutineLiveData$emitSource$1.L$1 = liveData;
        coroutineLiveData$emitSource$1.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        liveData2 = liveData;
        coroutineLiveData = this;
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = null;
        coroutineLiveData$emitSource$1.label = 2;
        objAddDisposableSource = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        if (objAddDisposableSource == coroutine_suspended) {
            return coroutine_suspended;
        }
        EmittedSource emittedSource2 = (EmittedSource) objAddDisposableSource;
        coroutineLiveData.emittedSource = emittedSource2;
        return emittedSource2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            if ((coroutineLiveData$clearSource$1.label & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label -= Integer.MIN_VALUE;
            } else {
                coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
            }
        } else {
            coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
        }
        Object obj = coroutineLiveData$clearSource$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = coroutineLiveData$clearSource$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            EmittedSource emittedSource = this.emittedSource;
            if (emittedSource != null) {
                coroutineLiveData$clearSource$1.L$0 = this;
                coroutineLiveData$clearSource$1.label = 1;
                if (emittedSource.disposeNow(coroutineLiveData$clearSource$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        coroutineLiveData.emittedSource = null;
        return Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }
}
