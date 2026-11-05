package com.syu.over;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.google.android.material.badge.BadgeDrawable;
import com.syu.media.provider.Media;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\u0006\u0010&\u001a\u00020!¢\u0006\u0004\bD\u0010EJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rJU\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/syu/over/FloatManager;", "Landroid/content/ServiceConnection;", "Landroid/os/IBinder$DeathRecipient;", FinalChip.BSP_PLATFORM_Null, "startBind", "unbind", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, "onServiceConnected", "onServiceDisconnected", "binderDied", "Landroid/view/WindowManager;", "getWindowManager", FinalChip.BSP_PLATFORM_Null, "gravity", "flags", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "x", "y", "Landroid/view/WindowManager$LayoutParams;", "makeLayoutParam", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/view/WindowManager$LayoutParams;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/over/FloatWindow;", "window", "addWindow", "Lcom/syu/over/IWindow;", "findWindowByName", FinalChip.BSP_PLATFORM_Null, "isConnected", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/syu/over/WindowManagerBinder;", "b", "Lcom/syu/over/WindowManagerBinder;", "getMFloatManager", "()Lcom/syu/over/WindowManagerBinder;", "setMFloatManager", "(Lcom/syu/over/WindowManagerBinder;)V", "mFloatManager", "c", "Z", "getNeedInit", "()Z", "setNeedInit", "(Z)V", "needInit", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler", "Lcom/syu/over/FloatManager$OnInitializeListener;", "e", "Lcom/syu/over/FloatManager$OnInitializeListener;", "getMListener", "()Lcom/syu/over/FloatManager$OnInitializeListener;", "setMListener", "(Lcom/syu/over/FloatManager$OnInitializeListener;)V", "mListener", "<init>", "(Landroid/content/Context;)V", "OnInitializeListener", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FloatManager implements ServiceConnection, IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public WindowManagerBinder mFloatManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean needInit;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy uiHandler;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public OnInitializeListener mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/syu/over/FloatManager$OnInitializeListener;", FinalChip.BSP_PLATFORM_Null, "onInitialize", FinalChip.BSP_PLATFORM_Null, "init", FinalChip.BSP_PLATFORM_Null, "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnInitializeListener {
        void onInitialize(boolean init);
    }

    public FloatManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uiHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.over.FloatManager$uiHandler$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m336invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
    }

    public static final void access$bind(FloatManager floatManager) {
        floatManager.getClass();
        Intent intent = new Intent(WindowManagerService.class.getName());
        intent.setPackage(floatManager.context.getPackageName());
        Log.e("float", " bind  " + intent + XmlConsts.CHAR_SPACE);
        floatManager.context.bindService(intent, floatManager, 1);
    }

    public static /* synthetic */ WindowManager.LayoutParams makeLayoutParam$default(FloatManager floatManager, int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = BadgeDrawable.TOP_START;
        }
        return floatManager.makeLayoutParam(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : num4, (i2 & 32) == 0 ? num5 : null);
    }

    public final void addWindow(String name, FloatWindow window) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(window, "window");
        WindowManagerBinder windowManagerBinder = this.mFloatManager;
        if (windowManagerBinder != null) {
            windowManagerBinder.addWindow(name, window);
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        WindowManagerBinder windowManagerBinder = this.mFloatManager;
        if (windowManagerBinder != null) {
            windowManagerBinder.unlinkToDeath(this, 0);
        }
        OnInitializeListener onInitializeListener = this.mListener;
        if (onInitializeListener != null) {
            onInitializeListener.onInitialize(false);
        }
        if (this.needInit) {
            startBind();
        }
    }

    public final IWindow findWindowByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        WindowManagerBinder windowManagerBinder = this.mFloatManager;
        if (windowManagerBinder != null) {
            return windowManagerBinder.findWindowByName(name);
        }
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final WindowManagerBinder getMFloatManager() {
        return this.mFloatManager;
    }

    public final OnInitializeListener getMListener() {
        return this.mListener;
    }

    public final boolean getNeedInit() {
        return this.needInit;
    }

    public final Handler getUiHandler() {
        return (Handler) this.uiHandler.getValue();
    }

    public final WindowManager getWindowManager() {
        WindowManagerBinder windowManagerBinder = this.mFloatManager;
        if (windowManagerBinder != null) {
            return windowManagerBinder.getWindowManager();
        }
        return null;
    }

    public final boolean isConnected() {
        return this.mFloatManager != null;
    }

    public final WindowManager.LayoutParams makeLayoutParam(int gravity, Integer flags, Integer width, Integer height, Integer x, Integer y) {
        WindowManagerBinder windowManagerBinder = this.mFloatManager;
        if (windowManagerBinder != null) {
            return windowManagerBinder.makeLayoutParam(gravity, flags, width, height, x, y);
        }
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
        Log.e("float", " 11 onServiceConnected " + name + "  " + service + XmlConsts.CHAR_SPACE);
        if (service != null) {
            service.linkToDeath(this, 0);
            this.mFloatManager = (WindowManagerBinder) service;
            OnInitializeListener onInitializeListener = this.mListener;
            if (onInitializeListener != null) {
                onInitializeListener.onInitialize(true);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        OnInitializeListener onInitializeListener;
        this.mFloatManager = null;
        if (!this.needInit && (onInitializeListener = this.mListener) != null) {
            onInitializeListener.onInitialize(false);
        }
        startBind();
    }

    public final void setMFloatManager(WindowManagerBinder windowManagerBinder) {
        this.mFloatManager = windowManagerBinder;
    }

    public final void setMListener(OnInitializeListener onInitializeListener) {
        this.mListener = onInitializeListener;
    }

    public final void setNeedInit(boolean z) {
        this.needInit = z;
    }

    public final void startBind() {
        this.needInit = true;
        getUiHandler().postDelayed(new Runnable() { // from class: com.syu.over.FloatManager.startBind.1
            @Override // java.lang.Runnable
            public void run() {
                FloatManager.this.getUiHandler().removeCallbacks(this);
                if (FloatManager.this.getMFloatManager() == null && FloatManager.this.getNeedInit()) {
                    FloatManager.access$bind(FloatManager.this);
                    FloatManager.this.getUiHandler().postDelayed(this, 800L);
                }
            }
        }, 500L);
    }

    public final void unbind() {
        this.needInit = false;
        this.context.unbindService(this);
    }
}
