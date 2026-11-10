package com.syu.over;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import chip.FinalChip;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010H\u001a\u00020\u0002\u0012\u0006\u0010I\u001a\u00020\u0002\u0012\u0012\b\u0002\u0010L\u001a\f\u0012\u0006\b\u0001\u0012\u00020K\u0018\u00010J¢\u0006\u0004\bM\u0010NJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006O"}, d2 = {"Lcom/syu/over/FloatWindow;", "Lcom/syu/over/IWindow;", FinalChip.BSP_PLATFORM_Null, "gravity", "Landroid/graphics/Rect;", "layoutRect", FinalChip.BSP_PLATFORM_Null, "show", FinalChip.BSP_PLATFORM_Null, "onLayoutChanged", "flag", "updateLayoutFlags", "onLayoutMax", "onAttachedToWindow", "onDetachedFromWindow", "max", "onMaxLayoutRectChanged", "maxRect", "Landroid/view/WindowManager$LayoutParams;", "layoutParams", "updateLayoutParam", "layoutParam", "x", "y", "moveTo", "isAttached", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/WindowManager;", "b", "Landroid/view/WindowManager;", "getMWindowManager", "()Landroid/view/WindowManager;", "setMWindowManager", "(Landroid/view/WindowManager;)V", "mWindowManager", "c", "Landroid/view/WindowManager$LayoutParams;", "getLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "setLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)V", "d", "Landroid/graphics/Rect;", "getFullSize", "()Landroid/graphics/Rect;", "setFullSize", "(Landroid/graphics/Rect;)V", "fullSize", "e", "I", "getOffsetX", "()I", "setOffsetX", "(I)V", "offsetX", "f", "getOffsetY", "setOffsetY", "offsetY", "Landroid/animation/AnimatorSet;", "g", "Landroid/animation/AnimatorSet;", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "setAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "animatorSet", "layoutId", "rootContainer", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "<init>", "(Landroid/content/Context;Landroid/view/WindowManager;Landroid/view/WindowManager$LayoutParams;IILjava/lang/Class;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FloatWindow implements IWindow {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public WindowManager mWindowManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public WindowManager.LayoutParams layoutParams;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Rect fullSize;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int offsetX;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int offsetY;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public AnimatorSet animatorSet;
    public final Lazy h;
    public final FragmentController i;

    public FloatWindow(final Context context, WindowManager windowManager, WindowManager.LayoutParams layoutParams, final int i, final int i2, final Class<? extends Fragment> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowManager, "mWindowManager");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.context = context;
        this.mWindowManager = windowManager;
        this.layoutParams = layoutParams;
        this.fullSize = new Rect();
        this.offsetX = Integer.MIN_VALUE;
        this.offsetY = Integer.MIN_VALUE;
        this.h = LazyKt.lazy(new Function0<FragmentContainerHelper>() { // from class: com.syu.over.FloatWindow$mLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FragmentContainerHelper m337invoke() {
                View viewInflate = LayoutInflater.from(this.a.getContext()).inflate(i, (ViewGroup) null, false);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.syu.over.FragmentContainerHelper");
                final FragmentContainerHelper fragmentContainerHelper = (FragmentContainerHelper) viewInflate;
                final FloatWindow floatWindow = this.a;
                final int i3 = i2;
                final Class cls2 = cls;
                fragmentContainerHelper.setMCallback(new FragmentContainerHelper.UiShowCallback() { // from class: com.syu.over.FloatWindow$mLayout$2$1$1
                    @Override // com.syu.over.FragmentContainerHelper.UiShowCallback
                    public void onAttachedToWindow() {
                        floatWindow.i.attachHost(null);
                        floatWindow.i.dispatchResume();
                        View viewFindViewById = fragmentContainerHelper.findViewById(i3);
                        if (viewFindViewById != null) {
                            FloatWindow floatWindow2 = floatWindow;
                            FragmentContainerHelper fragmentContainerHelper2 = fragmentContainerHelper;
                            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                            layoutParams3.width = floatWindow2.getFullSize().width();
                            layoutParams3.height = floatWindow2.getFullSize().height();
                            fragmentContainerHelper2.updateViewLayout(viewFindViewById, layoutParams3);
                        }
                        Log.e("float", "FloatWindow  ==========>>  " + floatWindow.getOffsetX() + "  " + floatWindow.getOffsetY());
                        Class cls3 = cls2;
                        if (cls3 != null) {
                            floatWindow.i.getSupportFragmentManager().beginTransaction().replace(i3, (Fragment) cls3.newInstance()).commit();
                        }
                    }

                    @Override // com.syu.over.FragmentContainerHelper.UiShowCallback
                    public void onDetachedFromWindow() {
                        floatWindow.i.dispatchDestroy();
                    }
                });
                return fragmentContainerHelper;
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        FragmentController fragmentControllerCreateController = FragmentController.createController(new FragmentHostCallback<Context>(context, handler) { // from class: com.syu.over.FloatWindow$mFragments$1
            @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
            public View onFindViewById(int id) {
                return this.a.a().findViewById(id);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.fragment.app.FragmentHostCallback
            public Context onGetHost() {
                return this.a.getContext();
            }

            @Override // androidx.fragment.app.FragmentHostCallback
            public LayoutInflater onGetLayoutInflater() {
                LayoutInflater layoutInflaterCloneInContext = super.onGetLayoutInflater().cloneInContext(this.a.getContext());
                Intrinsics.checkNotNullExpressionValue(layoutInflaterCloneInContext, "super.onGetLayoutInflate…).cloneInContext(context)");
                return layoutInflaterCloneInContext;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fragmentControllerCreateController, "createController(object …\n            }\n        })");
        this.i = fragmentControllerCreateController;
    }

    public static final void b(FloatWindow floatWindow, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatWindow, "this$0");
        WindowManager.LayoutParams layoutParams = floatWindow.layoutParams;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.y = ((Integer) animatedValue).intValue();
        floatWindow.mWindowManager.updateViewLayout(floatWindow.a(), floatWindow.layoutParams);
    }

    public final FragmentContainerHelper a() {
        return (FragmentContainerHelper) this.h.getValue();
    }

    public final AnimatorSet getAnimatorSet() {
        return this.animatorSet;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Rect getFullSize() {
        return this.fullSize;
    }

    public final WindowManager.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public final WindowManager getMWindowManager() {
        return this.mWindowManager;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    @Override // com.syu.over.IWindow
    public boolean isAttached() {
        return a().getParent() != null;
    }

    @Override // com.syu.over.IWindow
    public WindowManager.LayoutParams layoutParam() {
        return this.layoutParams;
    }

    @Override // com.syu.over.IWindow
    public Rect maxRect() {
        return new Rect(this.fullSize);
    }

    @Override // com.syu.over.IWindow
    public void moveTo(int x, int y) {
        if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
            return;
        }
        this.offsetX = x != Integer.MAX_VALUE ? x : this.fullSize.left;
        this.offsetY = y != Integer.MAX_VALUE ? y : this.fullSize.top;
        Log.e("float", "moveTo ==========>>  " + x + ", " + y + ", " + this.offsetX + ", " + this.offsetY + ", " + this.fullSize);
        if (isAttached()) {
            ArrayList arrayList = new ArrayList();
            if (x != Integer.MAX_VALUE) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.layoutParams.x, x);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.syu.over.FloatWindow$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FloatWindow.a(this.f$0, valueAnimator);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "ofInt(layoutParams.x, x)…          }\n            }");
                arrayList.add(valueAnimatorOfInt);
            }
            if (y != Integer.MAX_VALUE) {
                ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.layoutParams.y, y);
                valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.syu.over.FloatWindow$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FloatWindow.b(this.f$0, valueAnimator);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt2, "ofInt(layoutParams.y, y)…          }\n            }");
                arrayList.add(valueAnimatorOfInt2);
            }
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.playTogether(arrayList);
            AnimatorSet animatorSet3 = this.animatorSet;
            if (animatorSet3 != null) {
                animatorSet3.setInterpolator(new DecelerateInterpolator(5.0f));
            }
            AnimatorSet animatorSet4 = this.animatorSet;
            if (animatorSet4 != null) {
                animatorSet4.setDuration(500L);
            }
            AnimatorSet animatorSet5 = this.animatorSet;
            if (animatorSet5 != null) {
                animatorSet5.start();
            }
        }
    }

    @Override // com.syu.over.IWindow
    public void onAttachedToWindow() {
        if (a().getParent() == null) {
            this.mWindowManager.addView(a(), this.layoutParams);
        }
    }

    @Override // com.syu.over.IWindow
    public void onDetachedFromWindow() {
        if (a().getParent() != null) {
            this.mWindowManager.removeView(a());
        }
    }

    @Override // com.syu.over.IWindow
    public void onLayoutChanged(int gravity, Rect layoutRect, boolean show) {
        Intrinsics.checkNotNullParameter(layoutRect, "layoutRect");
        Log.e("float", "service onLayoutChanged ==========>>  " + layoutRect);
        this.layoutParams.gravity = gravity;
        onLayoutChanged(layoutRect, show);
    }

    @Override // com.syu.over.IWindow
    public void onLayoutMax() {
        if (this.layoutParams.width == this.fullSize.width() && this.layoutParams.height == this.fullSize.height()) {
            return;
        }
        onLayoutChanged(this.fullSize, true);
    }

    @Override // com.syu.over.IWindow
    public void onMaxLayoutRectChanged(Rect max) {
        Intrinsics.checkNotNullParameter(max, "max");
        this.fullSize.set(max);
    }

    public final void setAnimatorSet(AnimatorSet animatorSet) {
        this.animatorSet = animatorSet;
    }

    public final void setFullSize(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.fullSize = rect;
    }

    public final void setLayoutParams(WindowManager.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "<set-?>");
        this.layoutParams = layoutParams;
    }

    public final void setMWindowManager(WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(windowManager, "<set-?>");
        this.mWindowManager = windowManager;
    }

    public final void setOffsetX(int i) {
        this.offsetX = i;
    }

    public final void setOffsetY(int i) {
        this.offsetY = i;
    }

    @Override // com.syu.over.IWindow
    public void updateLayoutFlags(int flag) {
        WindowManager.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.flags != flag) {
            layoutParams.flags = flag;
            if (a().getParent() != null) {
                this.mWindowManager.updateViewLayout(a(), this.layoutParams);
            }
        }
    }

    @Override // com.syu.over.IWindow
    public void updateLayoutParam(WindowManager.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.layoutParams = layoutParams;
        if (isAttached()) {
            this.mWindowManager.updateViewLayout(a(), this.layoutParams);
        }
    }

    public /* synthetic */ FloatWindow(Context context, WindowManager windowManager, WindowManager.LayoutParams layoutParams, int i, int i2, Class cls, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, windowManager, layoutParams, i, i2, (i3 & 32) != 0 ? null : cls);
    }

    public static final void a(FloatWindow floatWindow, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatWindow, "this$0");
        WindowManager.LayoutParams layoutParams = floatWindow.layoutParams;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.x = ((Integer) animatedValue).intValue();
        floatWindow.mWindowManager.updateViewLayout(floatWindow.a(), floatWindow.layoutParams);
    }

    @Override // com.syu.over.IWindow
    public void onLayoutChanged(Rect layoutRect, boolean show) {
        Intrinsics.checkNotNullParameter(layoutRect, "layoutRect");
        WindowManager.LayoutParams layoutParams = this.layoutParams;
        layoutParams.x = layoutRect.left;
        layoutParams.y = layoutRect.top;
        layoutParams.width = layoutRect.width();
        this.layoutParams.height = layoutRect.height();
        if (show) {
            if (a().getParent() != null) {
                this.mWindowManager.updateViewLayout(a(), this.layoutParams);
            } else {
                this.mWindowManager.addView(a(), this.layoutParams);
            }
        }
    }
}
