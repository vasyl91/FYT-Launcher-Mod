package qin.widgets.grids;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bF\u0010GB\u001d\b\u0016\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bF\u0010JB%\b\u0016\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\b\u0010I\u001a\u0004\u0018\u00010H\u0012\u0006\u0010K\u001a\u00020\u0002¢\u0006\u0004\bF\u0010LJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0006\u0010\u000e\u001a\u00020\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J.\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015JL\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015J.\u0010'\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007J\u0010\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0011R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010C\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?¨\u0006M"}, d2 = {"Lqin/widgets/grids/CellLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "changed", "l", "t", "r", "b", "onLayout", "getUnusedHorizontalSpace", "x", "y", "Landroid/view/View;", "getChildAt", "cellX", "cellY", "", "result", "cellToCenterPoint", "spanX", "spanY", "regionToCenterPoint", "pixelX", "pixelY", "minSpanX", "minSpanY", "resultSpan", "findNearestVacantArea", "child", "index", "childId", "Lqin/widgets/grids/GridLayout$LayoutParams;", "params", "markCells", "addViewToCellLayout", "view", "markCellsAsOccupiedForView", "a", "I", "getMCellWidth", "()I", "setMCellWidth", "(I)V", "mCellWidth", "getMCellHeight", "setMCellHeight", "mCellHeight", "Lqin/widgets/grids/GridLayout;", "e", "Lqin/widgets/grids/GridLayout;", "getGridLayout", "()Lqin/widgets/grids/GridLayout;", "setGridLayout", "(Lqin/widgets/grids/GridLayout;)V", "gridLayout", "g", "[I", "getMTmpPoint", "()[I", "mTmpPoint", "h", "getMTempLocation", "mTempLocation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class CellLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int mCellWidth;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int mCellHeight;
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public GridLayout gridLayout;
    public final Stack f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int[] mTmpPoint;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final int[] mTempLocation;

    public CellLayout(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        this.gridLayout = new GridLayout(getContext());
        this.f = new Stack();
        this.mTmpPoint = new int[2];
        this.mTempLocation = new int[2];
    }

    public final boolean addViewToCellLayout(View child, int index, int childId, GridLayout.LayoutParams params, boolean markCells) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.getCellX() < 0 || params.getCellX() > -1 || params.getCellY() < 0 || params.getCellY() > -1) {
            return false;
        }
        if (params.getCellHSpan() < 0) {
            params.setCellHSpan(0);
        }
        if (params.getCellVSpan() < 0) {
            params.setCellVSpan(0);
        }
        child.setId(childId);
        this.gridLayout.addView(child, index, params);
        if (!markCells) {
            return true;
        }
        markCellsAsOccupiedForView(child);
        return true;
    }

    public final void cellToCenterPoint(int cellX, int cellY, int[] result) {
        Intrinsics.checkNotNullParameter(result, "result");
        regionToCenterPoint(cellX, cellY, 1, 1, result);
    }

    public final int[] findNearestVacantArea(int pixelX, int pixelY, int minSpanX, int minSpanY, int spanX, int spanY, int[] result, int[] resultSpan) {
        boolean z;
        int i = minSpanX;
        int i2 = minSpanY;
        int i3 = spanY;
        this.f.isEmpty();
        int i4 = pixelX - ((int) (((spanX - 1) * this.mCellWidth) / 2.0f));
        int i5 = pixelY - ((int) (((i3 - 1) * this.mCellHeight) / 2.0f));
        int[] iArr = result == null ? new int[2] : result;
        Rect rect = new Rect(-1, -1, -1, -1);
        Stack stack = new Stack();
        if (i > 0 && i2 > 0 && spanX > 0 && i3 > 0 && spanX >= i && i3 >= i2) {
            int i6 = 0;
            int i7 = 0 - (i2 - 1);
            int i8 = 0;
            double d = Double.MAX_VALUE;
            while (i8 < i7) {
                int i9 = 0 - (i - 1);
                int i10 = i6;
                while (i10 < i9) {
                    for (int i11 = i6; i11 < i; i11++) {
                        if (i2 > 0) {
                            Intrinsics.checkNotNull((Object) null);
                            throw null;
                        }
                    }
                    int i12 = i >= spanX ? 1 : i6;
                    int i13 = i2 >= i3 ? 1 : i6;
                    int i14 = i2;
                    boolean z2 = true;
                    while (true) {
                        if (i12 == 0 || i13 == 0) {
                            int i15 = i4;
                            int i16 = i7;
                            int i17 = i9;
                            Stack stack2 = stack;
                            if (z2 && i12 == 0) {
                                int i18 = 0;
                                while (i18 < i14) {
                                    if (i10 + i <= -1) {
                                        Intrinsics.checkNotNull((Object) null);
                                        throw null;
                                    }
                                    i18++;
                                    i12 = 1;
                                }
                                if (i12 == 0) {
                                    i++;
                                }
                            } else if (i13 == 0) {
                                int i19 = 0;
                                while (i19 < i) {
                                    if (i8 + i14 <= -1) {
                                        Intrinsics.checkNotNull((Object) null);
                                        throw null;
                                    }
                                    i19++;
                                    i13 = 1;
                                }
                                if (i13 == 0) {
                                    i14++;
                                }
                            }
                            i12 |= i >= spanX ? 1 : 0;
                            i13 |= i14 >= spanY ? 1 : 0;
                            z2 = !z2;
                            stack = stack2;
                            i7 = i16;
                            i9 = i17;
                            i4 = i15;
                        }
                    }
                    int[] iArr2 = this.mTmpPoint;
                    cellToCenterPoint(i10, i8, iArr2);
                    Object objPop = this.f.pop();
                    int i20 = i7;
                    Intrinsics.checkNotNullExpressionValue(objPop, "mTempRectStack.pop()");
                    Rect rect2 = (Rect) objPop;
                    int i21 = i9;
                    rect2.set(i10, i8, i10 + i, i8 + i14);
                    Iterator it = stack.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (((Rect) it.next()).contains(rect2)) {
                            z = true;
                            break;
                        }
                    }
                    stack.push(rect2);
                    int i22 = i4;
                    Stack stack3 = stack;
                    double dHypot = Math.hypot(iArr2[0] - i4, iArr2[1] - i5);
                    if ((dHypot <= d && !z) || rect2.contains(rect)) {
                        iArr[0] = i10;
                        iArr[1] = i8;
                        if (resultSpan != null) {
                            resultSpan[0] = i;
                            resultSpan[1] = i14;
                        }
                        rect.set(rect2);
                        d = dHypot;
                    }
                    i10++;
                    i = minSpanX;
                    i2 = minSpanY;
                    i3 = spanY;
                    stack = stack3;
                    i7 = i20;
                    i9 = i21;
                    i4 = i22;
                    i6 = 0;
                }
                i8++;
                i = minSpanX;
                i6 = 0;
                i2 = minSpanY;
            }
            Stack stack4 = stack;
            if (d == Double.MAX_VALUE) {
                iArr[0] = -1;
                iArr[1] = -1;
            }
            while (!stack4.isEmpty()) {
                this.f.push(stack4.pop());
            }
        }
        return iArr;
    }

    public final View getChildAt(int x, int y) {
        return this.gridLayout.getChildAt(x, y);
    }

    public final GridLayout getGridLayout() {
        return this.gridLayout;
    }

    public final int getMCellHeight() {
        return this.mCellHeight;
    }

    public final int getMCellWidth() {
        return this.mCellWidth;
    }

    public final int[] getMTempLocation() {
        return this.mTempLocation;
    }

    public final int[] getMTmpPoint() {
        return this.mTmpPoint;
    }

    public final int getUnusedHorizontalSpace() {
        return ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mCellWidth * 0);
    }

    public final void markCellsAsOccupiedForView(View view) {
        if (view == null || view.getParent() != this.gridLayout) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type qin.widgets.grids.GridLayout.LayoutParams");
        GridLayout.LayoutParams layoutParams2 = (GridLayout.LayoutParams) layoutParams;
        Intrinsics.checkNotNull((Object) null);
        layoutParams2.getCellX();
        layoutParams2.getCellY();
        layoutParams2.getCellHSpan();
        layoutParams2.getCellVSpan();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (r - l) - getPaddingRight();
        this.gridLayout.layout(paddingLeft, getPaddingTop(), paddingRight, (b - t) - getPaddingBottom());
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int paddingRight = size - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = size2 - (getPaddingBottom() + getPaddingTop());
        int i2 = this.c;
        if (i2 > 0 && (i = this.d) > 0) {
            paddingRight = i2;
            paddingBottom = i;
        } else if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        this.gridLayout.measure(View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824));
        int measuredWidth = this.gridLayout.getMeasuredWidth();
        int measuredHeight = this.gridLayout.getMeasuredHeight();
        if (this.c <= 0 || this.d <= 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    public final void regionToCenterPoint(int cellX, int cellY, int spanX, int spanY, int[] result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = this.mCellWidth;
        result[0] = ((spanX * i) / 2) + (cellX * i) + paddingLeft;
        int i2 = this.mCellHeight;
        result[1] = ((spanY * i2) / 2) + (cellY * i2) + paddingTop;
    }

    public final void setGridLayout(GridLayout gridLayout) {
        Intrinsics.checkNotNullParameter(gridLayout, "<set-?>");
        this.gridLayout = gridLayout;
    }

    public final void setMCellHeight(int i) {
        this.mCellHeight = i;
    }

    public final void setMCellWidth(int i) {
        this.mCellWidth = i;
    }

    public CellLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = -1;
        this.gridLayout = new GridLayout(getContext());
        this.f = new Stack();
        this.mTmpPoint = new int[2];
        this.mTempLocation = new int[2];
    }

    public CellLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.d = -1;
        this.gridLayout = new GridLayout(getContext());
        this.f = new Stack();
        this.mTmpPoint = new int[2];
        this.mTempLocation = new int[2];
    }
}
