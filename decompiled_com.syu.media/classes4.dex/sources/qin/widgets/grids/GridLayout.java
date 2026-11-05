package qin.widgets.grids;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001.B\u0013\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(B\u001d\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+B%\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b'\u0010-J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0012J0\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\u001c\u0010#\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016¨\u0006/"}, d2 = {"Lqin/widgets/grids/GridLayout;", "Landroid/view/ViewGroup;", "", "cellWidth", "cellHeight", "countX", "countY", "", "setCellDimensions", "x", "y", "Landroid/view/View;", "getChildAt", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "child", "setupLp", "", "invert", "setInvertIfRtl", "getCellContentHeight", "measureChild", "invertLayoutHorizontally", "changed", "l", "t", "r", "b", "onLayout", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "shouldDelayChildPressedState", "focused", "requestChildFocus", "cancelLongPress", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class GridLayout extends ViewGroup {
    public final int[] a;
    public int b;
    public int c;
    public int d;
    public final WallpaperManager e;
    public boolean f;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010J\u0012\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NB\u0013\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bM\u0010QB\u0011\b\u0016\u0012\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bM\u0010RB)\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\bM\u0010SJ<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00102\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\"\u00107\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%\"\u0004\b6\u0010'R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0010\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\"\u0010C\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R$\u0010D\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R$\u0010G\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014¨\u0006T"}, d2 = {"Lqin/widgets/grids/GridLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "", "cellWidth", "cellHeight", "", "invertHorizontally", "colCount", "", "cellScaleX", "cellScaleY", "", "setup", "", "toString", "a", "I", "getCellX", "()I", "setCellX", "(I)V", "cellX", "b", "getCellY", "setCellY", "cellY", "c", "getTmpCellX", "setTmpCellX", "tmpCellX", "d", "getTmpCellY", "setTmpCellY", "tmpCellY", "e", "Z", "getUseTmpCoords", "()Z", "setUseTmpCoords", "(Z)V", "useTmpCoords", "f", "getCellHSpan", "setCellHSpan", "cellHSpan", "g", "getCellVSpan", "setCellVSpan", "cellVSpan", "h", "isLockedToGrid", "setLockedToGrid", "i", "getCanReorder", "setCanReorder", "canReorder", "j", "getX", "setX", "x", "k", "getY", "setY", "y", "l", "getDropped", "setDropped", "dropped", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "(Lqin/widgets/grids/GridLayout$LayoutParams;)V", "(IIII)V", "Components_release"}, k = 1, mv = {1, 7, 1})
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public int cellX;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public int cellY;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public int tmpCellX;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public int tmpCellY;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public boolean useTmpCoords;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public int cellHSpan;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public int cellVSpan;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public boolean isLockedToGrid;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public boolean canReorder;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public int x;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        public int y;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        public boolean dropped;

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(-1, -1);
            this.isLockedToGrid = true;
            this.canReorder = true;
            this.cellX = i;
            this.cellY = i2;
            this.cellHSpan = i3;
            this.cellVSpan = i4;
        }

        public static /* synthetic */ void setup$default(LayoutParams layoutParams, int i, int i2, boolean z, int i3, float f, float f2, int i4, Object obj) {
            layoutParams.setup(i, i2, z, i3, (i4 & 16) != 0 ? 1.0f : f, (i4 & 32) != 0 ? 1.0f : f2);
        }

        public final boolean getCanReorder() {
            return this.canReorder;
        }

        public final int getCellHSpan() {
            return this.cellHSpan;
        }

        public final int getCellVSpan() {
            return this.cellVSpan;
        }

        public final int getCellX() {
            return this.cellX;
        }

        public final int getCellY() {
            return this.cellY;
        }

        public final boolean getDropped() {
            return this.dropped;
        }

        public final int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        public final int getTmpCellX() {
            return this.tmpCellX;
        }

        public final int getTmpCellY() {
            return this.tmpCellY;
        }

        public final boolean getUseTmpCoords() {
            return this.useTmpCoords;
        }

        public final int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: isLockedToGrid, reason: from getter */
        public final boolean getIsLockedToGrid() {
            return this.isLockedToGrid;
        }

        public final void setCanReorder(boolean z) {
            this.canReorder = z;
        }

        public final void setCellHSpan(int i) {
            this.cellHSpan = i;
        }

        public final void setCellVSpan(int i) {
            this.cellVSpan = i;
        }

        public final void setCellX(int i) {
            this.cellX = i;
        }

        public final void setCellY(int i) {
            this.cellY = i;
        }

        public final void setDropped(boolean z) {
            this.dropped = z;
        }

        public final void setHeight(int i) {
            ((ViewGroup.MarginLayoutParams) this).height = i;
        }

        public final void setLockedToGrid(boolean z) {
            this.isLockedToGrid = z;
        }

        public final void setTmpCellX(int i) {
            this.tmpCellX = i;
        }

        public final void setTmpCellY(int i) {
            this.tmpCellY = i;
        }

        public final void setUseTmpCoords(boolean z) {
            this.useTmpCoords = z;
        }

        public final void setWidth(int i) {
            ((ViewGroup.MarginLayoutParams) this).width = i;
        }

        public final void setX(int i) {
            this.x = i;
        }

        public final void setY(int i) {
            this.y = i;
        }

        public final void setup(int i, int i2, boolean z, int i3) {
            setup$default(this, i, i2, z, i3, 0.0f, 0.0f, 48, null);
        }

        public String toString() {
            return "(" + this.cellX + ", " + this.cellY + ')';
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.isLockedToGrid = true;
            this.canReorder = true;
            this.cellHSpan = 1;
            this.cellVSpan = 1;
        }

        public final void setup(int i, int i2, boolean z, int i3, float f) {
            setup$default(this, i, i2, z, i3, f, 0.0f, 32, null);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.isLockedToGrid = true;
            this.canReorder = true;
            this.cellHSpan = 1;
            this.cellVSpan = 1;
        }

        public final void setup(int cellWidth, int cellHeight, boolean invertHorizontally, int colCount, float cellScaleX, float cellScaleY) {
            if (this.isLockedToGrid) {
                int i = this.cellHSpan;
                int i2 = this.cellVSpan;
                boolean z = this.useTmpCoords;
                int i3 = z ? this.tmpCellX : this.cellX;
                int i4 = z ? this.tmpCellY : this.cellY;
                if (invertHorizontally) {
                    i3 = (colCount - i3) - i;
                }
                int i5 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
                ((ViewGroup.MarginLayoutParams) this).width = (int) ((((i * cellWidth) / cellScaleX) - i5) - ((ViewGroup.MarginLayoutParams) this).rightMargin);
                int i6 = ((ViewGroup.MarginLayoutParams) this).topMargin;
                ((ViewGroup.MarginLayoutParams) this).height = (int) ((((i2 * cellHeight) / cellScaleY) - i6) - ((ViewGroup.MarginLayoutParams) this).bottomMargin);
                this.x = (i3 * cellWidth) + i5;
                this.y = (i4 * cellHeight) + i6;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            this.isLockedToGrid = true;
            this.canReorder = true;
            this.cellX = layoutParams.cellX;
            this.cellY = layoutParams.cellY;
            this.cellHSpan = layoutParams.cellHSpan;
            this.cellVSpan = layoutParams.cellVSpan;
        }
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    public final int getCellContentHeight() {
        return getMeasuredHeight();
    }

    public final View getChildAt(int x, int y) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type qin.widgets.grids.GridLayout.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (layoutParams2.getCellX() <= x) {
                if (x < layoutParams2.getCellHSpan() + layoutParams2.getCellX() && layoutParams2.getCellY() <= y) {
                    if (y < layoutParams2.getCellVSpan() + layoutParams2.getCellY()) {
                        return childAt;
                    }
                }
            }
        }
        return null;
    }

    public final boolean invertLayoutHorizontally() {
        return this.f && getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public final void measureChild(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type qin.widgets.grids.GridLayout.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.setX(0);
        layoutParams2.setY(0);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = getMeasuredWidth();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = getMeasuredHeight();
        child.measure(View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).width, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).height, 1073741824));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            if (getAlpha() == 0.0f) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type qin.widgets.grids.GridLayout.LayoutParams");
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                int x = layoutParams2.getX();
                int y = layoutParams2.getY();
                childAt.layout(x, y, ((ViewGroup.MarginLayoutParams) layoutParams2).width + x, ((ViewGroup.MarginLayoutParams) layoutParams2).height + y);
                if (layoutParams2.getDropped()) {
                    layoutParams2.setDropped(false);
                    int[] iArr = this.a;
                    getLocationOnScreen(iArr);
                    WallpaperManager wallpaperManager = this.e;
                    Intrinsics.checkNotNull(wallpaperManager);
                    wallpaperManager.sendWallpaperCommand(getWindowToken(), "android.home.drop", (((ViewGroup.MarginLayoutParams) layoutParams2).width / 2) + iArr[0] + x, (((ViewGroup.MarginLayoutParams) layoutParams2).height / 2) + iArr[1] + y, 0, null);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(childAt, "child");
                measureChild(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (child != null) {
            Rect rect = new Rect();
            child.getDrawingRect(rect);
            requestRectangleOnScreen(rect);
        }
    }

    public final void setCellDimensions(int cellWidth, int cellHeight, int countX, int countY) {
        this.b = cellWidth;
        this.c = cellHeight;
        this.d = countX;
    }

    public final void setInvertIfRtl(boolean invert) {
        this.f = invert;
    }

    public final void setupLp(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type qin.widgets.grids.GridLayout.LayoutParams");
        LayoutParams.setup$default((LayoutParams) layoutParams, this.b, this.c, invertLayoutHorizontally(), this.d, 0.0f, 0.0f, 48, null);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new int[2];
        this.e = WallpaperManager.getInstance(context);
    }
}
