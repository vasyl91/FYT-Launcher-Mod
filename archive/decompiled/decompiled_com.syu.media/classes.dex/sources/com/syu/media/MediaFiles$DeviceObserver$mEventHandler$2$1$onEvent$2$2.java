package com.syu.media;

import chip.FinalChip;
import com.syu.media.entities.VideoSource;
import java.io.File;
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
@DebugMetadata(c = "com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$2$2", f = "MediaFiles.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MediaFiles a;
    public final /* synthetic */ File b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$2$2(MediaFiles mediaFiles, File file, Continuation continuation) {
        super(2, continuation);
        this.a = mediaFiles;
        this.b = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$2$2(this.a, this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        VideoSource videoSourceAccess$file2VideoSource = MediaFiles.access$file2VideoSource(this.a, this.b);
        if (videoSourceAccess$file2VideoSource != null) {
            this.a.getMediaDao().insert(videoSourceAccess$file2VideoSource);
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
