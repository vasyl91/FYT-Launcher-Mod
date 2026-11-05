package com.syu.media.btmusic.fragment;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyDragShadowBuilder.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/syu/media/btmusic/fragment/MyDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "shadow", "Landroid/graphics/drawable/ColorDrawable;", "onDrawShadow", FinalChip.BSP_PLATFORM_Null, "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "size", "Landroid/graphics/Point;", "touch", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyDragShadowBuilder extends View.DragShadowBuilder {
    private final ColorDrawable shadow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyDragShadowBuilder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "v");
        this.shadow = new ColorDrawable(-3355444);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point size, Point touch) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(touch, "touch");
        int width = getView().getWidth() / 2;
        int height = getView().getHeight() / 2;
        this.shadow.setBounds(0, 0, width, height);
        size.set(width, height);
        touch.set(width / 2, height / 2);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.shadow.draw(canvas);
    }
}
