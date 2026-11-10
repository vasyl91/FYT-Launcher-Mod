package com.syu.media.api;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/syu/media/api/FolderInfo;", "Lcom/syu/media/api/MediaGroup;", "()V", Media.PATH, FinalChip.BSP_PLATFORM_Null, "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "equals", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class FolderInfo extends MediaGroup {
    public String path;
    public String title;

    public boolean equals(Object other) {
        return other instanceof FolderInfo ? Intrinsics.areEqual(((FolderInfo) other).getPath(), getPath()) : super.equals(other);
    }

    public final String getPath() {
        String str = this.path;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Media.PATH);
        return null;
    }

    public final String getTitle() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
