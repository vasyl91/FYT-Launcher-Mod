package com.syu.media;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.VideoSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import syu.utils.FileUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.syu.media.MediaFiles$checkMounted$1", f = "MediaFiles.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaFiles$checkMounted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MediaFiles a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFiles$checkMounted$1(MediaFiles mediaFiles, Continuation continuation) {
        super(2, continuation);
        this.a = mediaFiles;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFiles$checkMounted$1(this.a, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        List<String> folders = this.a.getMediaDao().getFolders();
        MediaFiles mediaFiles = this.a;
        for (String str : folders) {
            Log.e(MediaFiles.TAG, "checkMounted ---- dir path: " + str);
            if (!mediaFiles.isMounted(str)) {
                mediaFiles.getMediaDao().deleteAudioSource(str);
                mediaFiles.getMediaDao().deleteVideoSource(str);
                MediaFiles.CoverHandler mCoverHandler = mediaFiles.getMCoverHandler();
                if (mCoverHandler != null) {
                    mCoverHandler.removeWith(str);
                }
            }
        }
        List<AudioSource> listHistoricalAudio = this.a.getMediaDao().historicalAudio();
        if (listHistoricalAudio != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listHistoricalAudio) {
                if (!FileUtils.INSTANCE.exists(((AudioSource) obj2).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                    arrayList.add(obj2);
                }
            }
            MediaDao mediaDao = this.a.getMediaDao();
            Object[] array = arrayList.toArray(new AudioSource[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            AudioSource[] audioSourceArr = (AudioSource[]) array;
            mediaDao.delete((AudioSource[]) Arrays.copyOf(audioSourceArr, audioSourceArr.length));
        }
        List<VideoSource> listHistoricalVideo = this.a.getMediaDao().historicalVideo();
        if (listHistoricalVideo != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : listHistoricalVideo) {
                if (!FileUtils.INSTANCE.exists(((VideoSource) obj3).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                    arrayList2.add(obj3);
                }
            }
            MediaDao mediaDao2 = this.a.getMediaDao();
            Object[] array2 = arrayList2.toArray(new VideoSource[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            VideoSource[] videoSourceArr = (VideoSource[]) array2;
            mediaDao2.delete((VideoSource[]) Arrays.copyOf(videoSourceArr, videoSourceArr.length));
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
