package com.syu.media.music.items;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.MediaApp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.music.items.AudioItem$listener$1$1$1", f = "AudioItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioItem$listener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioItem$listener$1$1$1(AudioItem audioItem, Continuation<? super AudioItem$listener$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = audioItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioItem$listener$1$1$1(this.this$0, continuation);
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
        Log.e(AudioItem.TAG, "update item music:" + this.this$0.getData());
        MediaApp.INSTANCE.getMe().getMusicModel().getMusicFavorite().setValue(this.this$0.getData());
        return Unit.INSTANCE;
    }
}
