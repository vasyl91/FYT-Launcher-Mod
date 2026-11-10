package com.syu.media.companion.ext;

import android.os.SystemClock;
import android.view.View;
import chip.FinalChip;
import com.syu.media.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a(\u0010\b\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\t"}, d2 = {"throttleClick", "Landroid/view/View$OnClickListener;", "wait", FinalChip.BSP_PLATFORM_Null, "block", "Lkotlin/Function1;", "Landroid/view/View;", FinalChip.BSP_PLATFORM_Null, "onClick", "app_appRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewExtKt {
    public static /* synthetic */ void onClick$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        onClick(view, j, function1);
    }

    public static final void onClick(View view, long j, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        view.setOnClickListener(throttleClick(j, function1));
    }

    public static /* synthetic */ View.OnClickListener throttleClick$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return throttleClick(j, function1);
    }

    public static final View.OnClickListener throttleClick(final long j, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return new View.OnClickListener() { // from class: com.syu.media.companion.ext.ViewExtKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewExtKt.m149throttleClick$lambda0(j, function1, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: throttleClick$lambda-0, reason: not valid java name */
    public static final void m149throttleClick$lambda0(long j, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        long jUptimeMillis = SystemClock.uptimeMillis();
        Object tag = view.getTag(R.id.click_time_stamp);
        Long l = tag instanceof Long ? (Long) tag : null;
        if (jUptimeMillis - (l != null ? l.longValue() : 0L) > j) {
            view.setTag(R.id.click_time_stamp, Long.valueOf(jUptimeMillis));
            Intrinsics.checkNotNullExpressionValue(view, "v");
            function1.invoke(view);
        }
    }
}
