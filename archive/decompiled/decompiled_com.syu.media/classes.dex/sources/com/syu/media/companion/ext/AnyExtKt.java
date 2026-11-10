package com.syu.media.companion.ext;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyExt.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a\u001a\u0010\u0004\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"isEqualType", FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "saveAs", "(Ljava/lang/Object;)Ljava/lang/Object;", "saveAsUnChecked", "app_appRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnyExtKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T saveAsUnChecked(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T saveAs(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return obj;
    }

    public static final /* synthetic */ <T> boolean isEqualType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return obj instanceof Object;
    }
}
