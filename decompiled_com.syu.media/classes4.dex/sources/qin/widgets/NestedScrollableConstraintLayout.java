package qin.widgets;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lqin/widgets/NestedScrollableConstraintLayout;", "Lqin/widgets/NestedConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleInterceptTouchEvent", "", "e", "Landroid/view/MotionEvent;", "Components_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollableConstraintLayout extends NestedConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableConstraintLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
    
        if (canChildScroll(r0, r1) != false) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // qin.widgets.NestedConstraintLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.viewpager2.widget.ViewPager2 r0 = r9.getParentViewPager()
            if (r0 == 0) goto La0
            int r0 = r0.getOrientation()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            boolean r1 = r9.canChildScroll(r0, r1)
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 != 0) goto L20
            boolean r1 = r9.canChildScroll(r0, r2)
            if (r1 != 0) goto L20
            return
        L20:
            int r1 = r10.getAction()
            r3 = 1
            if (r1 != 0) goto L3e
            float r0 = r10.getX()
            r9.setInitialX(r0)
            float r10 = r10.getY()
            r9.setInitialY(r10)
        L35:
            android.view.ViewParent r10 = r9.getParent()
            r10.requestDisallowInterceptTouchEvent(r3)
            goto La0
        L3e:
            int r1 = r10.getAction()
            r4 = 2
            if (r1 != r4) goto La0
            float r1 = r10.getX()
            float r4 = r9.getInitialX()
            float r1 = r1 - r4
            float r10 = r10.getY()
            float r4 = r9.getInitialY()
            float r10 = r10 - r4
            r4 = 0
            if (r0 != 0) goto L5c
            r5 = r3
            goto L5d
        L5c:
            r5 = r4
        L5d:
            float r6 = java.lang.Math.abs(r1)
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L67
            r8 = r7
            goto L68
        L67:
            r8 = r2
        L68:
            float r6 = r6 * r8
            float r8 = java.lang.Math.abs(r10)
            if (r5 == 0) goto L70
            goto L71
        L70:
            r2 = r7
        L71:
            float r8 = r8 * r2
            int r2 = r9.getTouchSlop()
            float r2 = (float) r2
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 > 0) goto L84
            int r2 = r9.getTouchSlop()
            float r2 = (float) r2
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 <= 0) goto La0
        L84:
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 <= 0) goto L8a
            r2 = r3
            goto L8b
        L8a:
            r2 = r4
        L8b:
            if (r5 != r2) goto L8e
            goto L99
        L8e:
            if (r5 == 0) goto L91
            goto L92
        L91:
            r1 = r10
        L92:
            boolean r10 = r9.canChildScroll(r0, r1)
            if (r10 == 0) goto L99
            goto L35
        L99:
            android.view.ViewParent r10 = r9.getParent()
            r10.requestDisallowInterceptTouchEvent(r4)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qin.widgets.NestedScrollableConstraintLayout.handleInterceptTouchEvent(android.view.MotionEvent):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
