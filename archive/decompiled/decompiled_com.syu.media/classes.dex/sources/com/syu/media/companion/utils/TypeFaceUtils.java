package com.syu.media.companion.utils;

import android.content.Context;
import android.graphics.Typeface;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeFaceUtils.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/syu/media/companion/utils/TypeFaceUtils;", FinalChip.BSP_PLATFORM_Null, "()V", "compasse", "Landroid/graphics/Typeface;", "myinghei", "semibold", "getTypeFaceCompasse", "context", "Landroid/content/Context;", "getTypeFaceMyinghei", "getTypeFaceSemibold", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TypeFaceUtils {
    public static final TypeFaceUtils INSTANCE = new TypeFaceUtils();
    private static Typeface compasse;
    private static Typeface myinghei;
    private static Typeface semibold;

    private TypeFaceUtils() {
    }

    public final Typeface getTypeFaceCompasse(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (compasse == null) {
            compasse = Typeface.createFromAsset(context.getAssets(), "fonts/compasse.ttf");
        }
        return compasse;
    }

    public final Typeface getTypeFaceMyinghei(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (myinghei == null) {
            myinghei = Typeface.createFromAsset(context.getAssets(), "fonts/myinghei.ttf");
        }
        return myinghei;
    }

    public final Typeface getTypeFaceSemibold(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (semibold == null) {
            semibold = Typeface.createFromAsset(context.getAssets(), "fonts/semibold.ttf");
        }
        return semibold;
    }
}
