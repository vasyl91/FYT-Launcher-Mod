package com.syu.manger.module.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import chip.FinalChip;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b@\u0010\"J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\u0012\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\u0012\u0010\b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\r\u001a\u00020\u0005H&R\u0017\u0010\u0012\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\"R$\u00105\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u0017\u0010?\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/syu/manger/module/video/VideoAdapter;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "values", FinalChip.BSP_PLATFORM_Null, "responseVideoId", "responseSignal", "responseFormat", "videoFormat", "Landroid/util/Size;", "size", "videoReady", "videoInvalid", "a", "I", "getId", "()I", "id", "Landroid/os/HandlerThread;", "b", "Landroid/os/HandlerThread;", "getMHandlerThread", "()Landroid/os/HandlerThread;", "mHandlerThread", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "d", "getVideoId", "setVideoId", "(I)V", "videoId", FinalChip.BSP_PLATFORM_Null, "e", "Z", "getHasSignal", "()Z", "setHasSignal", "(Z)V", "hasSignal", "f", "getVideoFormat", "setVideoFormat", "g", "Landroid/util/Size;", "getVideoSize", "()Landroid/util/Size;", "setVideoSize", "(Landroid/util/Size;)V", "videoSize", "h", "getAlready", "setAlready", "already", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "getMVideoChangedRunner", "()Ljava/lang/Runnable;", "mVideoChangedRunner", "<init>", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public abstract class VideoAdapter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final HandlerThread mHandlerThread;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Handler mHandler;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int videoId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean hasSignal;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int videoFormat;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public Size videoSize;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public boolean already;
    public final VideoAdapter$mVideoChangedRunner$1 i;

    /* JADX WARN: Type inference failed for: r4v5, types: [com.syu.manger.module.video.VideoAdapter$mVideoChangedRunner$1] */
    public VideoAdapter(int i) {
        this.id = i;
        HandlerThread handlerThread = new HandlerThread("VideoAdapter-" + i);
        handlerThread.start();
        this.mHandlerThread = handlerThread;
        this.mHandler = new Handler(handlerThread.getLooper());
        this.videoFormat = -1;
        this.i = new Runnable() { // from class: com.syu.manger.module.video.VideoAdapter$mVideoChangedRunner$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = this.a.getVideoId() == this.a.getId() && this.a.getHasSignal() && this.a.getVideoFormat() > -1;
                if (this.a.getAlready() != z) {
                    this.a.setAlready(z);
                    if (!this.a.getAlready()) {
                        this.a.videoInvalid();
                    } else {
                        VideoAdapter videoAdapter = this.a;
                        videoAdapter.videoReady(videoAdapter.getVideoFormat(), this.a.getVideoSize());
                    }
                }
            }
        };
    }

    public static /* synthetic */ void videoReady$default(VideoAdapter videoAdapter, int i, Size size, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: videoReady");
        }
        if ((i2 & 2) != 0) {
            size = null;
        }
        videoAdapter.videoReady(i, size);
    }

    public final boolean getAlready() {
        return this.already;
    }

    public final boolean getHasSignal() {
        return this.hasSignal;
    }

    public final int getId() {
        return this.id;
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final HandlerThread getMHandlerThread() {
        return this.mHandlerThread;
    }

    public final Runnable getMVideoChangedRunner() {
        return this.i;
    }

    public final int getVideoFormat() {
        return this.videoFormat;
    }

    public final int getVideoId() {
        return this.videoId;
    }

    public final Size getVideoSize() {
        return this.videoSize;
    }

    public final void responseFormat(int... values) {
        Intrinsics.checkNotNullParameter(values, "values");
        boolean z = true;
        boolean zContains = Utils.checkIndex(values, 2) ? ArraysKt.contains(ArraysKt.copyOfRange(values, 2, values.length), this.id) : true;
        if (!zContains || !Utils.checkIndex(values, 1)) {
            z = zContains;
        } else if (values[1] != this.id) {
            z = false;
        }
        if (z && Utils.checkIndex(values, 0)) {
            this.videoFormat = values[0];
            run();
        }
    }

    public final void responseSignal(int... values) {
        Intrinsics.checkNotNullParameter(values, "values");
        boolean zContains = Utils.checkIndex(values, 2) ? ArraysKt.contains(ArraysKt.copyOfRange(values, 2, values.length), this.id) : true;
        if (zContains && Utils.checkIndex(values, 1)) {
            zContains = values[1] == this.id;
        }
        if (zContains && Utils.checkIndex(values, 0)) {
            this.hasSignal = values[0] > 0;
            run();
        }
    }

    public final void responseVideoId(int... values) {
        Intrinsics.checkNotNullParameter(values, "values");
        if ((Utils.checkIndex(values, 2) ? ArraysKt.contains(ArraysKt.copyOfRange(values, 2, values.length), this.id) : true) && Utils.checkIndex(values, 1)) {
            int i = values[0];
            int i2 = this.id;
            this.videoId = i == i2 && values[1] == 1 ? i2 : 0;
            run();
        }
    }

    public final void setAlready(boolean z) {
        this.already = z;
    }

    public final void setHasSignal(boolean z) {
        this.hasSignal = z;
    }

    public final void setVideoFormat(int i) {
        this.videoFormat = i;
    }

    public final void setVideoId(int i) {
        this.videoId = i;
    }

    public final void setVideoSize(Size size) {
        this.videoSize = size;
    }

    public abstract void videoInvalid();

    public abstract void videoReady(int videoFormat, Size size);
}
