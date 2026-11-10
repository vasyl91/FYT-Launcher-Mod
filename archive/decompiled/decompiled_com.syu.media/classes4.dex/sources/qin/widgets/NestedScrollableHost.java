package qin.widgets;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, d2 = {"Lqin/widgets/NestedScrollableHost;", "Lqin/widgets/NestedHost;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handleInterceptTouchEvent", "", "e", "Landroid/view/MotionEvent;", "Components_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollableHost extends NestedHost {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a8, code lost:
    
        if (canChildScroll(r0, r1) != false) goto L20;
     */
    @Override // qin.widgets.NestedHost
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
            if (r0 == 0) goto Lb2
            int r0 = r0.getOrientation()
            qin.widgets.NestedHost$OnTouchEventHandler r1 = r9.getMOnTouchEventHandler()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1f
            boolean r1 = r1.onHandleTouchEvent(r10)
            if (r1 != r3) goto L1f
            r1 = r3
            goto L20
        L1f:
            r1 = r2
        L20:
            if (r1 == 0) goto L23
            return
        L23:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            boolean r1 = r9.canChildScroll(r0, r1)
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r1 != 0) goto L34
            boolean r1 = r9.canChildScroll(r0, r4)
            if (r1 != 0) goto L34
            return
        L34:
            int r1 = r10.getAction()
            if (r1 != 0) goto L51
            float r0 = r10.getX()
            r9.setInitialX(r0)
            float r10 = r10.getY()
            r9.setInitialY(r10)
        L48:
            android.view.ViewParent r10 = r9.getParent()
            r10.requestDisallowInterceptTouchEvent(r3)
            goto Lb2
        L51:
            int r1 = r10.getAction()
            r5 = 2
            if (r1 != r5) goto Lb2
            float r1 = r10.getX()
            float r5 = r9.getInitialX()
            float r1 = r1 - r5
            float r10 = r10.getY()
            float r5 = r9.getInitialY()
            float r10 = r10 - r5
            if (r0 != 0) goto L6e
            r5 = r3
            goto L6f
        L6e:
            r5 = r2
        L6f:
            float r6 = java.lang.Math.abs(r1)
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L79
            r8 = r7
            goto L7a
        L79:
            r8 = r4
        L7a:
            float r6 = r6 * r8
            float r8 = java.lang.Math.abs(r10)
            if (r5 == 0) goto L82
            goto L83
        L82:
            r4 = r7
        L83:
            float r8 = r8 * r4
            int r4 = r9.getTouchSlop()
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 > 0) goto L96
            int r4 = r9.getTouchSlop()
            float r4 = (float) r4
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 <= 0) goto Lb2
        L96:
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 <= 0) goto L9c
            r4 = r3
            goto L9d
        L9c:
            r4 = r2
        L9d:
            if (r5 != r4) goto La0
            goto Lab
        La0:
            if (r5 == 0) goto La3
            goto La4
        La3:
            r1 = r10
        La4:
            boolean r10 = r9.canChildScroll(r0, r1)
            if (r10 == 0) goto Lab
            goto L48
        Lab:
            android.view.ViewParent r10 = r9.getParent()
            r10.requestDisallowInterceptTouchEvent(r2)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qin.widgets.NestedScrollableHost.handleInterceptTouchEvent(android.view.MotionEvent):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
