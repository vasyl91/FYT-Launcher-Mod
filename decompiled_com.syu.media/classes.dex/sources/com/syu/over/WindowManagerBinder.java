package com.syu.over;

import android.os.Binder;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.google.android.material.badge.BadgeDrawable;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019JS\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u001a"}, d2 = {"Lcom/syu/over/WindowManagerBinder;", "Landroid/os/Binder;", FinalChip.BSP_PLATFORM_Null, "gravity", "flags", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "x", "y", "Landroid/view/WindowManager$LayoutParams;", "makeLayoutParam", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/view/WindowManager$LayoutParams;", FinalChip.BSP_PLATFORM_Null, "name", "Lcom/syu/over/FloatWindow;", "window", FinalChip.BSP_PLATFORM_Null, "addWindow", "Lcom/syu/over/IWindow;", "findWindowByName", "Landroid/view/WindowManager;", "getWindowManager", "Lcom/syu/over/WindowManagerService;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Lcom/syu/over/WindowManagerService;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class WindowManagerBinder extends Binder {
    public final WindowManagerService a;

    public WindowManagerBinder(WindowManagerService windowManagerService) {
        Intrinsics.checkNotNullParameter(windowManagerService, NotificationCompat.CATEGORY_SERVICE);
        this.a = windowManagerService;
    }

    public static /* synthetic */ WindowManager.LayoutParams makeLayoutParam$default(WindowManagerBinder windowManagerBinder, int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = BadgeDrawable.TOP_START;
        }
        return windowManagerBinder.makeLayoutParam(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : num4, (i2 & 32) == 0 ? num5 : null);
    }

    public final void addWindow(String name, FloatWindow window) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(window, "window");
        this.a.addWindow(name, window);
    }

    public final IWindow findWindowByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.a.findWindowByName(name);
    }

    public final WindowManager getWindowManager() {
        return this.a.getMWindowManager();
    }

    public final WindowManager.LayoutParams makeLayoutParam(int gravity, Integer flags, Integer width, Integer height, Integer x, Integer y) {
        return this.a.makeLayoutParam(gravity, flags, width, height, x, y);
    }
}
