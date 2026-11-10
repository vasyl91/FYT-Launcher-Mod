package com.syu.media.online.fragment;

import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
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

/* JADX INFO: compiled from: OnlineFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.online.fragment.OnlineFragment$initObserve$2$1", f = "OnlineFragment.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
final class OnlineFragment$initObserve$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RadioSource $it;
    int label;
    final /* synthetic */ OnlineFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnlineFragment$initObserve$2$1(RadioSource radioSource, OnlineFragment onlineFragment, Continuation<? super OnlineFragment$initObserve$2$1> continuation) {
        super(2, continuation);
        this.$it = radioSource;
        this.this$0 = onlineFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnlineFragment$initObserve$2$1(this.$it, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HiLog.INSTANCE.e(OnlineFragment.TAG, "update item online:" + this.$it);
            OnlineFragment onlineFragment = this.this$0;
            NodeAdapter nodeAdapter = onlineFragment.mAdapter;
            RadioSource radioSource = this.$it;
            Intrinsics.checkNotNullExpressionValue(radioSource, "it");
            this.label = 1;
            if (onlineFragment.notifyItemChanged(nodeAdapter, radioSource, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
