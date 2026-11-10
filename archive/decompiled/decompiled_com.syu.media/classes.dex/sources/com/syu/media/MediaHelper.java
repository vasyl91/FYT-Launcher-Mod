package com.syu.media;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MediaHelper.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/syu/media/MediaHelper;", FinalChip.BSP_PLATFORM_Null, "()V", "audioProxy", "Lcom/syu/media/MediaProxy;", "getAudioProxy", "()Lcom/syu/media/MediaProxy;", "setAudioProxy", "(Lcom/syu/media/MediaProxy;)V", "videoProxy", "getVideoProxy", "setVideoProxy", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediaHelper helper = new MediaHelper();
    private MediaProxy audioProxy;
    private MediaProxy videoProxy;

    /* JADX INFO: compiled from: MediaHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/MediaHelper$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "helper", "Lcom/syu/media/MediaHelper;", "getHelper", "()Lcom/syu/media/MediaHelper;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaHelper getHelper() {
            return MediaHelper.helper;
        }
    }

    public final MediaProxy getAudioProxy() {
        return this.audioProxy;
    }

    public final void setAudioProxy(MediaProxy mediaProxy) {
        this.audioProxy = mediaProxy;
    }

    public final MediaProxy getVideoProxy() {
        return this.videoProxy;
    }

    public final void setVideoProxy(MediaProxy mediaProxy) {
        this.videoProxy = mediaProxy;
    }
}
