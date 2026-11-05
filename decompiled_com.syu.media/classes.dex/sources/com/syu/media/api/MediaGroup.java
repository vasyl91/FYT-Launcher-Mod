package com.syu.media.api;

import chip.FinalChip;
import com.syu.media.entities.MediaSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/syu/media/api/MediaGroup;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", "a", "Ljava/util/List;", "getMediaSources", "()Ljava/util/List;", "setMediaSources", "(Ljava/util/List;)V", "mediaSources", FinalChip.BSP_PLATFORM_Null, "b", "Ljava/lang/String;", "getFilterOfPath", "()Ljava/lang/String;", "setFilterOfPath", "(Ljava/lang/String;)V", "filterOfPath", FinalChip.BSP_PLATFORM_Null, "c", "Z", "isFavorite", "()Z", "setFavorite", "(Z)V", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public class MediaGroup {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public List mediaSources = new ArrayList();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String filterOfPath;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean isFavorite;

    public final String getFilterOfPath() {
        return this.filterOfPath;
    }

    public final List<MediaSource> getMediaSources() {
        return this.mediaSources;
    }

    /* JADX INFO: renamed from: isFavorite, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    public final void setFilterOfPath(String str) {
        this.filterOfPath = str;
    }

    public final void setMediaSources(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mediaSources = list;
    }
}
