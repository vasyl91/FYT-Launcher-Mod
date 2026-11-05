package com.syu.media.service;

import chip.FinalChip;
import com.syu.media.player.IPlayer;
import java.util.Iterator;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.syu.media.service.MediaPresenter$callback2$1$onVideoSizeChanged$1", f = "MediaPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaPresenter$callback2$1$onVideoSizeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MediaPresenter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPresenter$callback2$1$onVideoSizeChanged$1(MediaPresenter mediaPresenter, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.a = mediaPresenter;
        this.b = i;
        this.c = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaPresenter$callback2$1$onVideoSizeChanged$1(this.a, this.b, this.c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.a.setVideoWidth(this.b);
        this.a.setVideoHeight(this.c);
        List list = this.a.s;
        int i = this.b;
        int i2 = this.c;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((IPlayer.Callback2) it.next()).onVideoSizeChanged(i, i2);
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
