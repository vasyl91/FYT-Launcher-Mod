package com.syu.media.online.item;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineTypeOrLocal.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/syu/media/online/item/OnlineTypeOrLocal;", FinalChip.BSP_PLATFORM_Null, "()V", "itemType", FinalChip.BSP_PLATFORM_Null, "getItemType", "()I", "setItemType", "(I)V", "title", FinalChip.BSP_PLATFORM_Null, "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "equals", FinalChip.BSP_PLATFORM_Null, "other", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineTypeOrLocal {
    public static final int ONLINE_LOCAL = 2;
    public static final int ONLINE_TYPE = 1;
    private int itemType = -1;
    private String title = FinalChip.BSP_PLATFORM_Null;

    public final int getItemType() {
        return this.itemType;
    }

    public final void setItemType(int i) {
        this.itemType = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public boolean equals(Object other) {
        if (!(other instanceof OnlineTypeOrLocal)) {
            return super.equals(other);
        }
        OnlineTypeOrLocal onlineTypeOrLocal = (OnlineTypeOrLocal) other;
        return onlineTypeOrLocal.itemType == this.itemType && Intrinsics.areEqual(onlineTypeOrLocal.title, this.title);
    }
}
