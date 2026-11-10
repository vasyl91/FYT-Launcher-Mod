package com.syu.media;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.MediaProxy$updateList$1$2", f = "MediaProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaProxy$updateList$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AudioSource> $songs;
    int label;
    final /* synthetic */ MediaProxy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaProxy$updateList$1$2(MediaProxy mediaProxy, List<AudioSource> list, Continuation<? super MediaProxy$updateList$1$2> continuation) {
        super(2, continuation);
        this.this$0 = mediaProxy;
        this.$songs = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaProxy$updateList$1$2(this.this$0, this.$songs, continuation);
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
        Log.d("music", "updateList updateAudioPlayList");
        MediaDao mediaDao = this.this$0.getMediaDao();
        if (mediaDao != null) {
            mediaDao.updateAudioPlayList(this.$songs);
        }
        return Unit.INSTANCE;
    }
}
