package com.syu.media;

import chip.FinalChip;
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
@DebugMetadata(c = "com.syu.media.MediaFiles$onReceive$1$1$1$1$1", f = "MediaFiles.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaFiles$onReceive$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MediaFiles a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFiles$onReceive$1$1$1$1$1(MediaFiles mediaFiles, String str, Continuation continuation) {
        super(2, continuation);
        this.a = mediaFiles;
        this.b = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFiles$onReceive$1$1$1$1$1(this.a, this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.a.getMediaDao().deleteAudioSource(this.b);
        this.a.getMediaDao().deleteVideoSource(this.b);
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
