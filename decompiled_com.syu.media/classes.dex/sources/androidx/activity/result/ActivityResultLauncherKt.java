package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityResultLauncher.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"launch", FinalChip.BSP_PLATFORM_Null, "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "launchUnit", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ActivityResultLauncherKt {
    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launch(ActivityResultLauncher<Void> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "$this$launch");
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launchUnit(ActivityResultLauncher<Unit> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "$this$launch");
        activityResultLauncher.launch(Unit.INSTANCE, activityOptionsCompat);
    }
}
