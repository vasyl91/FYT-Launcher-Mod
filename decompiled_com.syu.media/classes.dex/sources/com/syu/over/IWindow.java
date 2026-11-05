package com.syu.over;

import android.graphics.Rect;
import android.view.WindowManager;
import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0003H&J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0005H&¨\u0006\u001a"}, d2 = {"Lcom/syu/over/IWindow;", FinalChip.BSP_PLATFORM_Null, "isAttached", FinalChip.BSP_PLATFORM_Null, "layoutParam", "Landroid/view/WindowManager$LayoutParams;", "maxRect", "Landroid/graphics/Rect;", "moveTo", FinalChip.BSP_PLATFORM_Null, "x", FinalChip.BSP_PLATFORM_Null, "y", "onAttachedToWindow", "onDetachedFromWindow", "onLayoutChanged", "layoutRect", "show", "gravity", "onLayoutMax", "onMaxLayoutRectChanged", "max", "updateLayoutFlags", "flag", "updateLayoutParam", "layoutParams", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IWindow {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void moveTo$default(IWindow iWindow, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveTo");
            }
            if ((i3 & 1) != 0) {
                i = Integer.MAX_VALUE;
            }
            if ((i3 & 2) != 0) {
                i2 = Integer.MAX_VALUE;
            }
            iWindow.moveTo(i, i2);
        }

        public static /* synthetic */ void onLayoutChanged$default(IWindow iWindow, int i, Rect rect, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLayoutChanged");
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            iWindow.onLayoutChanged(i, rect, z);
        }

        public static /* synthetic */ void onLayoutChanged$default(IWindow iWindow, Rect rect, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLayoutChanged");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iWindow.onLayoutChanged(rect, z);
        }
    }

    boolean isAttached();

    WindowManager.LayoutParams layoutParam();

    Rect maxRect();

    void moveTo(int x, int y);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onLayoutChanged(int gravity, Rect layoutRect, boolean show);

    void onLayoutChanged(Rect layoutRect, boolean show);

    void onLayoutMax();

    void onMaxLayoutRectChanged(Rect max);

    void updateLayoutFlags(int flag);

    void updateLayoutParam(WindowManager.LayoutParams layoutParams);
}
