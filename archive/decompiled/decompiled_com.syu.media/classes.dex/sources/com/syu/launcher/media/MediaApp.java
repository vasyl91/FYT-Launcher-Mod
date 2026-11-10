package com.syu.launcher.media;

import android.graphics.drawable.Drawable;
import chip.FinalChip;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006#"}, d2 = {"Lcom/syu/launcher/media/MediaApp;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "isValid", "other", "equals", FinalChip.BSP_PLATFORM_Null, "toString", "component1", "Landroid/graphics/drawable/Drawable;", "component2", "component3", "packageName", "appIcon", "appTitle", "copy", FinalChip.BSP_PLATFORM_Null, "hashCode", "a", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "b", "Landroid/graphics/drawable/Drawable;", "getAppIcon", "()Landroid/graphics/drawable/Drawable;", "setAppIcon", "(Landroid/graphics/drawable/Drawable;)V", "c", "getAppTitle", "setAppTitle", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class MediaApp {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public String packageName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Drawable appIcon;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public String appTitle;

    public MediaApp() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MediaApp copy$default(MediaApp mediaApp, String str, Drawable drawable, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaApp.packageName;
        }
        if ((i & 2) != 0) {
            drawable = mediaApp.appIcon;
        }
        if ((i & 4) != 0) {
            str2 = mediaApp.appTitle;
        }
        return mediaApp.copy(str, drawable, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppTitle() {
        return this.appTitle;
    }

    public final MediaApp copy(String packageName, Drawable appIcon, String appTitle) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new MediaApp(packageName, appIcon, appTitle);
    }

    public boolean equals(Object other) {
        return other instanceof MediaApp ? Utils.equals(((MediaApp) other).packageName, this.packageName) : super.equals(other);
    }

    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    public final String getAppTitle() {
        return this.appTitle;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        Drawable drawable = this.appIcon;
        int iHashCode2 = (iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
        String str = this.appTitle;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isValid() {
        String str = this.packageName;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.appTitle;
        return !(str2 == null || str2.length() == 0);
    }

    public final void setAppIcon(Drawable drawable) {
        this.appIcon = drawable;
    }

    public final void setAppTitle(String str) {
        this.appTitle = str;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public String toString() {
        return "MediaApp: " + this.packageName + ",appTitle" + this.appTitle + ", ";
    }

    public MediaApp(String str, Drawable drawable, String str2) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        this.packageName = str;
        this.appIcon = drawable;
        this.appTitle = str2;
    }

    public /* synthetic */ MediaApp(String str, Drawable drawable, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FinalChip.BSP_PLATFORM_Null : str, (i & 2) != 0 ? null : drawable, (i & 4) != 0 ? FinalChip.BSP_PLATFORM_Null : str2);
    }
}
