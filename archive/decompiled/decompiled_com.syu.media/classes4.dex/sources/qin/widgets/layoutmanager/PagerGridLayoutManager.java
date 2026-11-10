package qin.widgets.layoutmanager;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 0;
    public int a;
    public final int d;
    public final int e;
    public final int f;
    public int l;
    public int m;
    public RecyclerView p;
    public int b = 0;
    public int c = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int n = 0;
    public boolean o = true;
    public boolean q = true;
    public int r = -1;
    public int s = -1;
    public PageListener t = null;
    public final SparseArray g = new SparseArray();

    public @interface OrientationType {
    }

    public interface PageListener {
        void onPageSelect(int i);

        void onPageSizeChanged(int i);
    }

    public PagerGridLayoutManager(int i, int i2, int i3) {
        this.a = i3;
        this.d = i;
        this.e = i2;
        this.f = i * i2;
    }

    public final void a(RecyclerView.Recycler recycler, Rect rect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Rect rectA = a(i);
        if (!Rect.intersects(rect, rectA)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.j, this.k);
        RecyclerView.LayoutParams layoutParams = viewForPosition.getLayoutParams();
        layoutDecorated(viewForPosition, getPaddingLeft() + (rectA.left - this.b) + layoutParams.leftMargin, getPaddingTop() + (rectA.top - this.c) + layoutParams.topMargin, getPaddingLeft() + ((rectA.right - this.b) - layoutParams.rightMargin), getPaddingTop() + ((rectA.bottom - this.c) - layoutParams.bottomMargin));
    }

    public final int b() {
        int i = this.s - 1;
        PagerConfig.Loge("computeScrollVectorForPosition pre = " + i);
        if (i < 0) {
            i = 0;
        }
        PagerConfig.Loge("computeScrollVectorForPosition pre = " + i);
        return i * this.f;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b A[PHI: r2
  0x002b: PHI (r2v2 int) = (r2v0 int), (r2v5 int) binds: [B:16:0x0029, B:9:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x002e  */
    public final int c() {
        int i;
        if (canScrollVertically()) {
            int iE = e();
            int i2 = this.c;
            if (i2 <= 0 || iE <= 0) {
                i = 0;
            } else {
                i = i2 / iE;
                if (i2 % iE > iE / 2) {
                    i++;
                }
            }
        } else {
            int iF = f();
            int i3 = this.b;
            if (i3 <= 0 || iF <= 0) {
                i = 0;
            } else {
                i = i3 / iF;
                if (i3 % iF > iF / 2) {
                    i++;
                }
            }
        }
        PagerConfig.Logi("getPageIndexByOffset pageIndex = " + i);
        return i;
    }

    public boolean canScrollHorizontally() {
        return this.a == 1;
    }

    public boolean canScrollVertically() {
        return this.a == 0;
    }

    public PointF computeScrollVectorForPosition(int i) {
        PointF pointF = new PointF();
        int[] iArrB = b(i);
        pointF.x = iArrB[0];
        pointF.y = iArrB[1];
        return pointF;
    }

    public final int d() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.f;
        return getItemCount() % this.f != 0 ? itemCount + 1 : itemCount;
    }

    public final int e() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final int f() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int iC = c() * this.f;
        for (int i = 0; i < getChildCount(); i++) {
            if (getPosition(getChildAt(i)) == iC) {
                return getChildAt(i);
            }
        }
        return getChildAt(0);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOffsetX() {
        return this.b;
    }

    public int getOffsetY() {
        return this.c;
    }

    public boolean isAllowContinuousScroll() {
        return this.o;
    }

    public void nextPage() {
        scrollToPage(c() + 1);
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.p = recyclerView;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        PagerConfig.Logi("Item onLayoutChildren");
        PagerConfig.Logi("Item onLayoutChildren isPreLayout = " + state.isPreLayout());
        PagerConfig.Logi("Item onLayoutChildren isMeasuring = " + state.isMeasuring());
        PagerConfig.Loge("Item onLayoutChildren state = " + state);
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            PageListener pageListener = this.t;
            if (pageListener != null && this.r != 0) {
                pageListener.onPageSizeChanged(0);
            }
            this.r = 0;
            a(0, false);
            return;
        }
        int iD = d();
        if (iD >= 0) {
            PageListener pageListener2 = this.t;
            if (pageListener2 != null && iD != this.r) {
                pageListener2.onPageSizeChanged(iD);
            }
            this.r = iD;
        }
        a(c(), false);
        int itemCount = getItemCount() / this.f;
        if (getItemCount() % this.f != 0) {
            itemCount++;
        }
        if (canScrollHorizontally()) {
            int iF = f() * (itemCount - 1);
            this.l = iF;
            this.m = 0;
            if (this.b > iF) {
                this.b = iF;
            }
        } else {
            this.l = 0;
            int iE = e() * (itemCount - 1);
            this.m = iE;
            if (this.c > iE) {
                this.c = iE;
            }
        }
        PagerConfig.Logi("count = " + getItemCount());
        if (this.h <= 0) {
            this.h = f() / this.e;
        }
        if (this.i <= 0) {
            this.i = e() / this.d;
        }
        this.j = f() - this.h;
        this.k = e() - this.i;
        for (int i = 0; i < this.f * 2; i++) {
            a(i);
        }
        if (this.b == 0 && this.c == 0) {
            for (int i2 = 0; i2 < this.f && i2 < getItemCount(); i2++) {
                View viewForPosition = recycler.getViewForPosition(i2);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, this.j, this.k);
            }
        }
        a(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        int iD = d();
        if (iD >= 0) {
            PageListener pageListener = this.t;
            if (pageListener != null && iD != this.r) {
                pageListener.onPageSizeChanged(iD);
            }
            this.r = iD;
        }
        a(c(), false);
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        super.onMeasure(recycler, state, i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && size > 0) {
            mode = 1073741824;
        }
        if (mode2 != 1073741824 && size2 > 0) {
            mode2 = 1073741824;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void onScrollStateChanged(int i) {
        PagerConfig.Logi("onScrollStateChanged = " + i);
        this.n = i;
        super.onScrollStateChanged(i);
        if (i == 0) {
            a(c(), false);
        }
    }

    public void prePage() {
        scrollToPage(c() - 1);
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.b;
        int i3 = i2 + i;
        int i4 = this.l;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.b = i2 + i;
        a(c(), true);
        offsetChildrenHorizontal(-i);
        if (i > 0) {
            a(recycler, state, true);
        } else {
            a(recycler, state, false);
        }
        return i;
    }

    public void scrollToPage(int i) {
        int iF;
        int iE;
        if (i < 0 || i >= this.r) {
            Log.e("PagerGridLayoutManager", "pageIndex = " + i + " is out of bounds, mast in [0, " + this.r + ")");
            return;
        }
        if (this.p == null) {
            Log.e("PagerGridLayoutManager", "RecyclerView Not Found!");
            return;
        }
        if (canScrollVertically()) {
            iE = (e() * i) - this.c;
            iF = 0;
        } else {
            iF = (f() * i) - this.b;
            iE = 0;
        }
        PagerConfig.Loge("mTargetOffsetXBy = " + iF);
        PagerConfig.Loge("mTargetOffsetYBy = " + iE);
        this.p.scrollBy(iF, iE);
        a(i, false);
    }

    public void scrollToPosition(int i) {
        scrollToPage(i / this.f);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.c;
        int i3 = i2 + i;
        int i4 = this.m;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.c = i2 + i;
        a(c(), true);
        offsetChildrenVertical(-i);
        if (i > 0) {
            a(recycler, state, true);
        } else {
            a(recycler, state, false);
        }
        return i;
    }

    public void setAllowContinuousScroll(boolean z) {
        this.o = z;
    }

    public void setChangeSelectInScrolling(boolean z) {
        this.q = z;
    }

    public int setOrientationType(int i) {
        int i2 = this.a;
        if (i2 == i || this.n != 0) {
            return i2;
        }
        this.a = i;
        this.g.clear();
        int i3 = this.b;
        this.b = f() * (this.c / e());
        this.c = e() * (i3 / f());
        int i4 = this.l;
        this.l = f() * (this.m / e());
        this.m = e() * (i4 / f());
        return this.a;
    }

    public void setPageListener(PageListener pageListener) {
        this.t = pageListener;
    }

    public void smoothNextPage() {
        smoothScrollToPage(c() + 1);
    }

    public void smoothPrePage() {
        smoothScrollToPage(c() - 1);
    }

    public void smoothScrollToPage(int i) {
        int i2;
        if (i < 0 || i >= this.r) {
            Log.e("PagerGridLayoutManager", "pageIndex is outOfIndex, must in [0, " + this.r + ").");
            return;
        }
        if (this.p == null) {
            Log.e("PagerGridLayoutManager", "RecyclerView Not Found!");
            return;
        }
        int iC = c();
        if (Math.abs(i - iC) > 3) {
            if (i > iC) {
                i2 = i - 3;
            } else if (i < iC) {
                i2 = i + 3;
            }
            scrollToPage(i2);
        }
        PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(this.p);
        pagerGridSmoothScroller.setTargetPosition(i * this.f);
        startSmoothScroll(pagerGridSmoothScroller);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        smoothScrollToPage(i / this.f);
    }

    public final int a() {
        int iD = this.s + 1;
        if (iD >= d()) {
            iD = d() - 1;
        }
        PagerConfig.Loge("computeScrollVectorForPosition next = " + iD);
        return iD * this.f;
    }

    public final Rect a(int i) {
        int iE;
        Rect rect = (Rect) this.g.get(i);
        if (rect == null) {
            rect = new Rect();
            int i2 = i / this.f;
            int iF = 0;
            if (canScrollHorizontally()) {
                iF = (f() * i2) + 0;
                iE = 0;
            } else {
                iE = (e() * i2) + 0;
            }
            int i3 = i % this.f;
            int i4 = this.e;
            int i5 = i3 / i4;
            int i6 = i3 - (i4 * i5);
            int i7 = (this.h * i6) + iF;
            int i8 = (this.i * i5) + iE;
            PagerConfig.Logi("pagePos = " + i3);
            PagerConfig.Logi("行 = " + i5);
            PagerConfig.Logi("列 = " + i6);
            PagerConfig.Logi("offsetX = " + i7);
            PagerConfig.Logi("offsetY = " + i8);
            rect.left = i7;
            rect.top = i8;
            rect.right = i7 + this.h;
            rect.bottom = i8 + this.i;
            this.g.put(i, rect);
        }
        return rect;
    }

    public final int[] b(int i) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int i2 = i / this.f;
        if (canScrollHorizontally()) {
            iArr2[0] = f() * i2;
            iArr2[1] = 0;
        } else {
            iArr2[0] = 0;
            iArr2[1] = e() * i2;
        }
        iArr[0] = iArr2[0] - this.b;
        iArr[1] = iArr2[1] - this.c;
        return iArr;
    }

    public final void a(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        if (state.isPreLayout()) {
            return;
        }
        PagerConfig.Logi("mOffsetX = " + this.b);
        PagerConfig.Logi("mOffsetY = " + this.c);
        Rect rect = new Rect(this.b - this.h, this.c - this.i, f() + this.b + this.h, e() + this.c + this.i);
        rect.intersect(0, 0, f() + this.l, e() + this.m);
        PagerConfig.Loge("displayRect = " + rect.toString());
        int iC = c() * this.f;
        PagerConfig.Logi("startPos = " + iC);
        int i = this.f;
        int i2 = iC - (i * 2);
        int i3 = i2 >= 0 ? i2 : 0;
        int itemCount = (i * 4) + i3;
        if (itemCount > getItemCount()) {
            itemCount = getItemCount();
        }
        PagerConfig.Loge("startPos = " + i3);
        PagerConfig.Loge("stopPos = " + itemCount);
        detachAndScrapAttachedViews(recycler);
        if (z) {
            while (i3 < itemCount) {
                a(recycler, rect, i3);
                i3++;
            }
        } else {
            for (int i4 = itemCount - 1; i4 >= i3; i4--) {
                a(recycler, rect, i4);
            }
        }
        PagerConfig.Loge("child count = " + getChildCount());
    }

    public final void a(int i, boolean z) {
        PageListener pageListener;
        PagerConfig.Loge("setPageIndex = " + i + ":" + z);
        if (i == this.s) {
            return;
        }
        if (isAllowContinuousScroll() || !z) {
            this.s = i;
        }
        if ((!z || this.q) && i >= 0 && (pageListener = this.t) != null) {
            pageListener.onPageSelect(i);
        }
    }
}
