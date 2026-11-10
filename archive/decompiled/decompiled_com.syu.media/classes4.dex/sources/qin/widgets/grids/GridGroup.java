package qin.widgets.grids;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105B\u001b\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b4\u00108B#\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u0004¢\u0006\u0004\b4\u0010:J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0014J\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b0-8\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u00100¨\u0006;"}, d2 = {"Lqin/widgets/grids/GridGroup;", "Landroid/view/ViewGroup;", "", "changed", "", "l", "t", "r", "b", "", "onLayout", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "snapToDestination", "whichScreen", "snapToScreen", "setToScreen", "getCurScreen", "computeScroll", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "ev", "onInterceptTouchEvent", "", "screenId", "Lqin/widgets/grids/CellLayout;", "getScreenWithId", "layout", "getIdForScreen", "a", "I", "getRows", "()I", "setRows", "(I)V", "rows", "getColumns", "setColumns", "columns", "c", "getPageCount", "setPageCount", "pageCount", "Lqin/widgets/grids/LongArrayMap;", "Lqin/widgets/grids/LongArrayMap;", "getMGridScreens", "()Lqin/widgets/grids/LongArrayMap;", "mGridScreens", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class GridGroup extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int rows;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int columns;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int pageCount;
    public final Scroller d;
    public VelocityTracker e;
    public int f;
    public final int g;
    public final int h;
    public int i;
    public final int j;
    public float k;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final LongArrayMap mGridScreens;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridGroup(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.d;
        Intrinsics.checkNotNull(scroller);
        if (scroller.computeScrollOffset()) {
            Scroller scroller2 = this.d;
            Intrinsics.checkNotNull(scroller2);
            int currX = scroller2.getCurrX();
            Scroller scroller3 = this.d;
            Intrinsics.checkNotNull(scroller3);
            scrollTo(currX, scroller3.getCurrY());
            postInvalidate();
        }
    }

    public final int getColumns() {
        return this.columns;
    }

    /* JADX INFO: renamed from: getCurScreen, reason: from getter */
    public final int getF() {
        return this.f;
    }

    public final long getIdForScreen(CellLayout layout) {
        int iIndexOfValue = this.mGridScreens.indexOfValue(layout);
        if (iIndexOfValue != -1) {
            return this.mGridScreens.keyAt(iIndexOfValue);
        }
        return -1L;
    }

    public final LongArrayMap<CellLayout> getMGridScreens() {
        return this.mGridScreens;
    }

    public final int getPageCount() {
        return this.pageCount;
    }

    public final int getRows() {
        return this.rows;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CellLayout getScreenWithId(long screenId) {
        return (CellLayout) this.mGridScreens.get(screenId);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (((int) java.lang.Math.abs(r4.k - r3)) > r4.j) goto L16;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.getAction()
            r1 = 1
            r2 = 2
            if (r0 != r2) goto L12
            int r3 = r4.i
            if (r3 == 0) goto L12
            return r1
        L12:
            float r3 = r5.getX()
            r5.getY()
            r5 = 0
            if (r0 == 0) goto L38
            if (r0 == r1) goto L35
            if (r0 == r2) goto L24
            r2 = 3
            if (r0 == r2) goto L35
            goto L47
        L24:
            float r0 = r4.k
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            int r0 = (int) r0
            int r2 = r4.j
            if (r0 <= r2) goto L47
        L30:
            int r0 = r4.g
        L32:
            r4.i = r0
            goto L47
        L35:
            r4.i = r5
            goto L47
        L38:
            r4.k = r3
            android.widget.Scroller r0 = r4.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L30
            r0 = r5
            goto L32
        L47:
            int r0 = r4.i
            if (r0 == 0) goto L4c
            goto L4d
        L4c:
            r1 = r5
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: qin.widgets.grids.GridGroup.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i;
                childAt.layout(i, 0, measuredWidth, childAt.getMeasuredHeight());
                i = measuredWidth;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (!(View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824)) {
            throw new IllegalStateException("AllApps only canmCurScreen run at EXACTLY mode!".toString());
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
        }
        scrollTo(this.f * size, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.e;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(event);
        int action = event.getAction();
        float x = event.getX();
        event.getY();
        if (action != 0) {
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.e;
                Intrinsics.checkNotNull(velocityTracker2);
                velocityTracker2.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker2.getXVelocity();
                int i2 = this.h;
                if (xVelocity > i2 && (i = this.f) > 0) {
                    snapToScreen(i - 1);
                } else if (xVelocity >= (-i2) || this.f >= getChildCount() - 1) {
                    snapToDestination();
                } else {
                    snapToScreen(this.f + 1);
                }
                VelocityTracker velocityTracker3 = this.e;
                if (velocityTracker3 != null) {
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                    }
                    this.e = null;
                }
            } else if (action == 2) {
                int i3 = (int) (this.k - x);
                this.k = x;
                scrollBy(i3, 0);
            } else if (action == 3) {
            }
            this.i = 0;
        } else {
            Scroller scroller = this.d;
            Intrinsics.checkNotNull(scroller);
            if (!scroller.isFinished()) {
                Scroller scroller2 = this.d;
                Intrinsics.checkNotNull(scroller2);
                scroller2.abortAnimation();
            }
            this.k = x;
        }
        return true;
    }

    public final void setColumns(int i) {
        this.columns = i;
    }

    public final void setPageCount(int i) {
        this.pageCount = i;
    }

    public final void setRows(int i) {
        this.rows = i;
    }

    public final void setToScreen(int whichScreen) {
        int iMax = Math.max(0, Math.min(whichScreen, getChildCount() - 1));
        this.f = iMax;
        scrollTo(getWidth() * iMax, 0);
    }

    public final void snapToDestination() {
        int width = getWidth();
        snapToScreen(((width / 2) + getScrollX()) / width);
    }

    public final void snapToScreen(int whichScreen) {
        int iMax = Math.max(0, Math.min(whichScreen, getChildCount() - 1));
        if (getScrollX() != getWidth() * iMax) {
            int width = (getWidth() * iMax) - getScrollX();
            Scroller scroller = this.d;
            Intrinsics.checkNotNull(scroller);
            scroller.startScroll(getScrollX(), 0, width, 0, Math.abs(width) * 2);
            this.f = iMax;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rows = 1;
        this.columns = 1;
        this.pageCount = 1;
        this.g = 1;
        this.h = 600;
        this.i = 0;
        this.mGridScreens = new LongArrayMap();
        this.d = new Scroller(null);
        this.f = 0;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        new DisplayMetrics();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        float f = displayMetrics.density;
    }
}
