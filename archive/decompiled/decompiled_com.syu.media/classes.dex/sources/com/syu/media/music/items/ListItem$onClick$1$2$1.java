package com.syu.media.music.items;

import chip.FinalChip;
import com.syu.media.MediaProxy;
import com.syu.media.dao.MediaDao;
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

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.music.items.ListItem$onClick$1$2$1", f = "ListItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ListItem$onClick$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Object> $list;
    final /* synthetic */ MediaProxy $this_run;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListItem$onClick$1$2$1(MediaProxy mediaProxy, List<? extends Object> list, Continuation<? super ListItem$onClick$1$2$1> continuation) {
        super(2, continuation);
        this.$this_run = mediaProxy;
        this.$list = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListItem$onClick$1$2$1(this.$this_run, this.$list, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MediaDao mediaDao = this.$this_run.getMediaDao();
        if (mediaDao != 0) {
            List<Object> list = this.$list;
            if (list == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.syu.media.entities.AudioSource>");
            }
            mediaDao.updateAudioPlayList(list);
        }
        return Unit.INSTANCE;
    }
}
