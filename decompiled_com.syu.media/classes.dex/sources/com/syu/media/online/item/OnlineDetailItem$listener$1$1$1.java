package com.syu.media.online.item;

import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.entities.RadioSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OnlineDetailItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.online.item.OnlineDetailItem$listener$1$1$1", f = "OnlineDetailItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OnlineDetailItem$listener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ RadioSource $it;
    int label;
    final /* synthetic */ OnlineDetailItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnlineDetailItem$listener$1$1$1(RadioSource radioSource, boolean z, OnlineDetailItem onlineDetailItem, Continuation<? super OnlineDetailItem$listener$1$1$1> continuation) {
        super(2, continuation);
        this.$it = radioSource;
        this.$isChecked = z;
        this.this$0 = onlineDetailItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnlineDetailItem$listener$1$1$1(this.$it, this.$isChecked, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$it.setFavorite(this.$isChecked);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.online.item.OnlineDetailItem$listener$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineDetailItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.item.OnlineDetailItem$listener$1$1$1$1", f = "OnlineDetailItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OnlineDetailItem this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OnlineDetailItem onlineDetailItem, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = onlineDetailItem;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MediaApp.INSTANCE.getMe().getMusicModel().getOnlineFavorite().setValue(this.this$0.getData());
            return Unit.INSTANCE;
        }
    }
}
