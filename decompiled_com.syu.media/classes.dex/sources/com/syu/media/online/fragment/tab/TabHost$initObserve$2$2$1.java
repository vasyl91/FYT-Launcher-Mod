package com.syu.media.online.fragment.tab;

import chip.FinalChip;
import com.syu.media.entities.RadioSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: TabHost.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.online.fragment.tab.TabHost$initObserve$2$2$1", f = "TabHost.kt", i = {}, l = {73, 74}, m = "invokeSuspend", n = {}, s = {})
final class TabHost$initObserve$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RadioSource $it;
    int label;
    final /* synthetic */ TabHost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabHost$initObserve$2$2$1(TabHost tabHost, RadioSource radioSource, Continuation<? super TabHost$initObserve$2$2$1> continuation) {
        super(2, continuation);
        this.this$0 = tabHost;
        this.$it = radioSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TabHost$initObserve$2$2$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TabHost tabHost = this.this$0;
            NodeAdapter mAdapter = tabHost.getMAdapter();
            RadioSource radioSource = this.$it;
            Intrinsics.checkNotNullExpressionValue(radioSource, "it");
            this.label = 1;
            if (tabHost.notifyItemChanged(mAdapter, radioSource, (Continuation) this) == coroutine_suspended) {
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
            TabHost tabHost2 = this.this$0;
            RadioSource radioSource2 = this.$it;
            Intrinsics.checkNotNullExpressionValue(radioSource2, "it");
            tabHost2.lastSong = radioSource2;
            return Unit.INSTANCE;
        }
        TabHost tabHost3 = this.this$0;
        this.label = 2;
        if (tabHost3.notifyItemChanged(tabHost3.getMAdapter(), this.this$0.lastSong, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        TabHost tabHost4 = this.this$0;
        RadioSource radioSource3 = this.$it;
        Intrinsics.checkNotNullExpressionValue(radioSource3, "it");
        tabHost4.lastSong = radioSource3;
        return Unit.INSTANCE;
    }
}
