package com.syu.over;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import chip.FinalChip;
import com.google.android.material.badge.BadgeDrawable;
import com.syu.media.provider.Media;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006JS\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/syu/over/WindowManagerService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", FinalChip.BSP_PLATFORM_Null, "name", "Lcom/syu/over/FloatWindow;", "window", FinalChip.BSP_PLATFORM_Null, "addWindow", "Lcom/syu/over/IWindow;", "findWindowByName", FinalChip.BSP_PLATFORM_Null, "gravity", "flags", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "x", "y", "Landroid/view/WindowManager$LayoutParams;", "makeLayoutParam", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "a", "Lkotlin/Lazy;", "getMWindowManager", "()Landroid/view/WindowManager;", "mWindowManager", FinalChip.BSP_PLATFORM_Null, "b", "getMWindows", "()Ljava/util/Map;", "mWindows", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class WindowManagerService extends Service {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy mWindowManager = LazyKt.lazy(new Function0<WindowManager>() { // from class: com.syu.over.WindowManagerService$mWindowManager$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WindowManager m338invoke() {
            Object systemService = this.a.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy mWindows = LazyKt.lazy(new Function0<Map<String, IWindow>>() { // from class: com.syu.over.WindowManagerService$mWindows$2
        public final Map<String, IWindow> invoke() {
            return new LinkedHashMap();
        }
    });

    public static /* synthetic */ WindowManager.LayoutParams makeLayoutParam$default(WindowManagerService windowManagerService, int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makeLayoutParam");
        }
        if ((i2 & 1) != 0) {
            i = BadgeDrawable.TOP_START;
        }
        return windowManagerService.makeLayoutParam(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : num4, (i2 & 32) == 0 ? num5 : null);
    }

    public final void addWindow(String name, FloatWindow window) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(window, "window");
        getMWindows().put(name, window);
    }

    public final IWindow findWindowByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getMWindows().get(name);
    }

    public final WindowManager getMWindowManager() {
        return (WindowManager) this.mWindowManager.getValue();
    }

    public final Map<String, IWindow> getMWindows() {
        return (Map) this.mWindows.getValue();
    }

    public final WindowManager.LayoutParams makeLayoutParam(int gravity, Integer flags, Integer width, Integer height, Integer x, Integer y) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2038;
        layoutParams.flags = flags != null ? flags.intValue() : 16777768;
        layoutParams.format = -3;
        layoutParams.gravity = gravity;
        if (width != null) {
            layoutParams.width = width.intValue();
        }
        if (height != null) {
            layoutParams.height = height.intValue();
        }
        if (x != null) {
            layoutParams.x = x.intValue();
        }
        if (y != null) {
            layoutParams.y = y.intValue();
        }
        return layoutParams;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new WindowManagerBinder(this);
    }
}
