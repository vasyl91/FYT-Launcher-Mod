package qin.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b)\u0010-B#\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b)\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0014R\"\u0010\u0013\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"Lqin/widgets/NestedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "orientation", "", "delta", "", "canChildScroll", "Landroid/view/MotionEvent;", "e", "onInterceptTouchEvent", "", "handleInterceptTouchEvent", "a", "I", "getTouchSlop", "()I", "setTouchSlop", "(I)V", "touchSlop", "b", "F", "getInitialX", "()F", "setInitialX", "(F)V", "initialX", "c", "getInitialY", "setInitialY", "initialY", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "child", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public class NestedConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int touchSlop;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float initialX;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float initialY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedConstraintLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public final boolean canChildScroll(int orientation, float delta) {
        int i = -((int) Math.signum(delta));
        if (orientation == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i);
            }
        } else {
            if (orientation != 1) {
                throw new IllegalArgumentException();
            }
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i);
            }
        }
        return false;
    }

    public final float getInitialX() {
        return this.initialX;
    }

    public final float getInitialY() {
        return this.initialY;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019 A[LOOP:0: B:6:0x000b->B:11:0x0019, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0017 -> B:5:0x000a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:6:0x000b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto La
            goto L19
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L1c
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L1c
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto La
        L19:
            android.view.View r0 = (android.view.View) r0
            goto Lb
        L1c:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L23
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L23:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: qin.widgets.NestedConstraintLayout.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    public final int getTouchSlop() {
        return this.touchSlop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleInterceptTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    public final void setInitialX(float f) {
        this.initialX = f;
    }

    public final void setInitialY(float f) {
        this.initialY = f;
    }

    public final void setTouchSlop(int i) {
        this.touchSlop = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = 16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = 16;
    }
}
