package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultItemDecoration extends RecyclerView.ItemDecoration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Drawer mDrawer;
    private final int mHeight;
    private final int mWidth;

    public DefaultItemDecoration(int i) {
        this(i, 4, 4);
    }

    public DefaultItemDecoration(int i, int i2, int i3) {
        int iRound = Math.round(i2 / 2.0f);
        this.mWidth = iRound;
        int iRound2 = Math.round(i3 / 2.0f);
        this.mHeight = iRound2;
        this.mDrawer = new ColorDrawer(i, iRound, iRound2);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int orientation = getOrientation(layoutManager);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            int spanCount = getSpanCount(layoutManager);
            int itemCount = layoutManager.getItemCount();
            if (orientation == 1) {
                offsetVertical(rect, childLayoutPosition, spanCount, itemCount);
                return;
            } else {
                offsetHorizontal(rect, childLayoutPosition, spanCount, itemCount);
                return;
            }
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int i = this.mWidth;
            int i2 = this.mHeight;
            rect.set(i, i2, i, i2);
        }
    }

    private void offsetHorizontal(Rect rect, int i, int i2, int i3) {
        boolean zIsFirstRaw = isFirstRaw(0, i, i2, i3);
        boolean zIsLastRaw = isLastRaw(0, i, i2, i3);
        boolean zIsFirstColumn = isFirstColumn(0, i, i2, i3);
        boolean zIsLastColumn = isLastColumn(0, i, i2, i3);
        if (i2 == 1) {
            if (zIsFirstColumn && zIsLastColumn) {
                rect.set(0, 0, 0, 0);
                return;
            }
            if (zIsFirstColumn) {
                rect.set(0, 0, this.mWidth, 0);
                return;
            } else if (zIsLastColumn) {
                rect.set(this.mWidth, 0, 0, 0);
                return;
            } else {
                int i4 = this.mWidth;
                rect.set(i4, 0, i4, 0);
                return;
            }
        }
        if (zIsFirstColumn && zIsFirstRaw) {
            rect.set(0, 0, this.mWidth, this.mHeight);
            return;
        }
        if (zIsFirstColumn && zIsLastRaw) {
            rect.set(0, this.mHeight, this.mWidth, 0);
            return;
        }
        if (zIsLastColumn && zIsFirstRaw) {
            rect.set(this.mWidth, 0, 0, this.mHeight);
            return;
        }
        if (zIsLastColumn && zIsLastRaw) {
            rect.set(this.mWidth, this.mHeight, 0, 0);
            return;
        }
        if (zIsFirstColumn) {
            int i5 = this.mHeight;
            rect.set(0, i5, this.mWidth, i5);
            return;
        }
        if (zIsLastColumn) {
            int i6 = this.mWidth;
            int i7 = this.mHeight;
            rect.set(i6, i7, 0, i7);
        } else if (zIsFirstRaw) {
            int i8 = this.mWidth;
            rect.set(i8, 0, i8, this.mHeight);
        } else if (zIsLastRaw) {
            int i9 = this.mWidth;
            rect.set(i9, this.mHeight, i9, 0);
        } else {
            int i10 = this.mWidth;
            int i11 = this.mHeight;
            rect.set(i10, i11, i10, i11);
        }
    }

    private void offsetVertical(Rect rect, int i, int i2, int i3) {
        boolean zIsFirstRaw = isFirstRaw(1, i, i2, i3);
        boolean zIsLastRaw = isLastRaw(1, i, i2, i3);
        boolean zIsFirstColumn = isFirstColumn(1, i, i2, i3);
        boolean zIsLastColumn = isLastColumn(1, i, i2, i3);
        if (i2 == 1) {
            if (zIsFirstRaw && zIsLastRaw) {
                rect.set(0, 0, 0, 0);
                return;
            }
            if (zIsFirstRaw) {
                rect.set(0, 0, 0, this.mHeight);
                return;
            } else if (zIsLastRaw) {
                rect.set(0, this.mHeight, 0, 0);
                return;
            } else {
                int i4 = this.mHeight;
                rect.set(0, i4, 0, i4);
                return;
            }
        }
        if (zIsFirstRaw && zIsFirstColumn) {
            rect.set(0, 0, this.mWidth, this.mHeight);
            return;
        }
        if (zIsFirstRaw && zIsLastColumn) {
            rect.set(this.mWidth, 0, 0, this.mHeight);
            return;
        }
        if (zIsLastRaw && zIsFirstColumn) {
            rect.set(0, this.mHeight, this.mWidth, 0);
            return;
        }
        if (zIsLastRaw && zIsLastColumn) {
            rect.set(this.mWidth, this.mHeight, 0, 0);
            return;
        }
        if (zIsFirstRaw) {
            int i5 = this.mWidth;
            rect.set(i5, 0, i5, this.mHeight);
            return;
        }
        if (zIsLastRaw) {
            int i6 = this.mWidth;
            rect.set(i6, this.mHeight, i6, 0);
            return;
        }
        if (zIsFirstColumn) {
            int i7 = this.mHeight;
            rect.set(0, i7, this.mWidth, i7);
        } else if (zIsLastColumn) {
            int i8 = this.mWidth;
            int i9 = this.mHeight;
            rect.set(i8, i9, 0, i9);
        } else {
            int i10 = this.mWidth;
            int i11 = this.mHeight;
            rect.set(i10, i11, i10, i11);
        }
    }

    private int getOrientation(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    private int getSpanCount(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    private boolean isFirstRaw(int i, int i2, int i3, int i4) {
        if (i == 1) {
            return i2 < i3;
        }
        return i3 == 1 || i2 % i3 == 0;
    }

    private boolean isLastRaw(int i, int i2, int i3, int i4) {
        if (i != 1) {
            return i3 == 1 || (i2 + 1) % i3 == 0;
        }
        if (i3 == 1) {
            return i2 + 1 == i4;
        }
        int i5 = i4 % i3;
        int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
        int i7 = i2 + 1;
        int i8 = i7 % i3;
        if (i8 == 0) {
            return i6 == i7 / i3;
        }
        return i6 == ((i7 - i8) / i3) + 1;
    }

    private boolean isFirstColumn(int i, int i2, int i3, int i4) {
        if (i == 1) {
            return i3 == 1 || i2 % i3 == 0;
        }
        return i2 < i3;
    }

    private boolean isLastColumn(int i, int i2, int i3, int i4) {
        if (i == 1) {
            return i3 == 1 || (i2 + 1) % i3 == 0;
        }
        if (i3 == 1) {
            return i2 + 1 == i4;
        }
        int i5 = i4 % i3;
        int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
        int i7 = i2 + 1;
        int i8 = i7 % i3;
        if (i8 == 0) {
            return i6 == i7 / i3;
        }
        return i6 == ((i7 - i8) / i3) + 1;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int orientation = getOrientation(layoutManager);
        int spanCount = getSpanCount(layoutManager);
        int childCount = layoutManager.getChildCount();
        if (layoutManager instanceof LinearLayoutManager) {
            canvas.save();
            for (int i = 0; i < childCount; i++) {
                View childAt = layoutManager.getChildAt(i);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(childAt);
                if (orientation == 1) {
                    drawVertical(canvas, childAt, childLayoutPosition, spanCount, childCount);
                } else {
                    drawHorizontal(canvas, childAt, childLayoutPosition, spanCount, childCount);
                }
            }
            canvas.restore();
            return;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            canvas.save();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = layoutManager.getChildAt(i2);
                this.mDrawer.drawLeft(childAt2, canvas);
                this.mDrawer.drawTop(childAt2, canvas);
                this.mDrawer.drawRight(childAt2, canvas);
                this.mDrawer.drawBottom(childAt2, canvas);
            }
            canvas.restore();
        }
    }

    private void drawHorizontal(Canvas canvas, View view, int i, int i2, int i3) {
        boolean zIsFirstRaw = isFirstRaw(0, i, i2, i3);
        boolean zIsLastRaw = isLastRaw(0, i, i2, i3);
        boolean zIsFirstColumn = isFirstColumn(0, i, i2, i3);
        boolean zIsLastColumn = isLastColumn(0, i, i2, i3);
        if (i2 == 1) {
            if (zIsFirstRaw && zIsLastColumn) {
                return;
            }
            if (zIsFirstColumn) {
                this.mDrawer.drawRight(view, canvas);
                return;
            } else if (zIsLastColumn) {
                this.mDrawer.drawLeft(view, canvas);
                return;
            } else {
                this.mDrawer.drawLeft(view, canvas);
                this.mDrawer.drawRight(view, canvas);
                return;
            }
        }
        if (zIsFirstColumn && zIsFirstRaw) {
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsFirstColumn && zIsLastRaw) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            return;
        }
        if (zIsLastColumn && zIsFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsLastColumn && zIsLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            return;
        }
        if (zIsFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (zIsFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (zIsLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        }
    }

    private void drawVertical(Canvas canvas, View view, int i, int i2, int i3) {
        boolean zIsFirstRaw = isFirstRaw(1, i, i2, i3);
        boolean zIsLastRaw = isLastRaw(1, i, i2, i3);
        boolean zIsFirstColumn = isFirstColumn(1, i, i2, i3);
        boolean zIsLastColumn = isLastColumn(1, i, i2, i3);
        if (i2 == 1) {
            if (zIsFirstRaw && zIsLastRaw) {
                return;
            }
            if (zIsFirstRaw) {
                this.mDrawer.drawBottom(view, canvas);
                return;
            } else if (zIsLastRaw) {
                this.mDrawer.drawTop(view, canvas);
                return;
            } else {
                this.mDrawer.drawTop(view, canvas);
                this.mDrawer.drawBottom(view, canvas);
                return;
            }
        }
        if (zIsFirstRaw && zIsFirstColumn) {
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsFirstRaw && zIsLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsLastRaw && zIsFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            return;
        }
        if (zIsLastRaw && zIsLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            return;
        }
        if (zIsFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
            return;
        }
        if (zIsLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else if (zIsFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (zIsLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        }
    }
}
