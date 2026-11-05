package com.syu.radio.ctrl;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JHorizontalListView extends AdapterView<ListAdapter> {
    public int item_wight;
    protected ListAdapter mAdapter;
    public boolean mAlwaysOverrideTouch;
    protected int mCurrentX;
    private boolean mDataChanged;
    private DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private GestureDetector mGesture;
    public int mLeftViewIndex;
    private int mMaxX;
    protected int mNextX;
    private GestureDetector.OnGestureListener mOnGesture;
    private AdapterView.OnItemClickListener mOnItemClicked;
    private AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private AdapterView.OnItemSelectedListener mOnItemSelected;
    private Queue<View> mRemovedViewQueue;
    private int mRightViewIndex;
    protected Scroller mScroller;
    float startX;
    float startY;

    public JHorizontalListView(Context context) {
        super(context);
        this.mAlwaysOverrideTouch = true;
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mDisplayOffset = 0;
        this.item_wight = 132;
        this.mRemovedViewQueue = new LinkedList();
        this.mDataChanged = false;
        this.mDataObserver = new DataSetObserver() { // from class: com.syu.radio.ctrl.JHorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (JHorizontalListView.this) {
                    JHorizontalListView.this.mDataChanged = true;
                }
                JHorizontalListView.this.invalidate();
                JHorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                JHorizontalListView.this.reset();
                JHorizontalListView.this.invalidate();
                JHorizontalListView.this.requestLayout();
            }
        };
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.syu.radio.ctrl.JHorizontalListView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                return JHorizontalListView.this.onDown(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return JHorizontalListView.this.onFling(e1, e2, velocityX, velocityY);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                synchronized (JHorizontalListView.this) {
                    JHorizontalListView.this.mNextX += (int) distanceX;
                }
                JHorizontalListView.this.requestLayout();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                for (int i = 0; i < JHorizontalListView.this.getChildCount(); i++) {
                    View child = JHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (JHorizontalListView.this.mOnItemClicked != null) {
                            JHorizontalListView.this.mOnItemClicked.onItemClick(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                        }
                        if (JHorizontalListView.this.mOnItemSelected != null) {
                            JHorizontalListView.this.mOnItemSelected.onItemSelected(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                int childCount = JHorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = JHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (JHorizontalListView.this.mOnItemLongClicked != null) {
                            JHorizontalListView.this.mOnItemLongClicked.onItemLongClick(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return;
                        }
                        return;
                    }
                }
            }

            private boolean isEventWithinView(MotionEvent e, View child) {
                Rect viewRect = new Rect();
                int[] childPosition = new int[2];
                child.getLocationOnScreen(childPosition);
                int left = childPosition[0];
                int right = left + child.getWidth();
                int top = childPosition[1];
                int bottom = top + child.getHeight();
                viewRect.set(left, top, right, bottom);
                return viewRect.contains((int) e.getRawX(), (int) e.getRawY());
            }
        };
        initView();
    }

    public JHorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAlwaysOverrideTouch = true;
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mDisplayOffset = 0;
        this.item_wight = 132;
        this.mRemovedViewQueue = new LinkedList();
        this.mDataChanged = false;
        this.mDataObserver = new DataSetObserver() { // from class: com.syu.radio.ctrl.JHorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (JHorizontalListView.this) {
                    JHorizontalListView.this.mDataChanged = true;
                }
                JHorizontalListView.this.invalidate();
                JHorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                JHorizontalListView.this.reset();
                JHorizontalListView.this.invalidate();
                JHorizontalListView.this.requestLayout();
            }
        };
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.syu.radio.ctrl.JHorizontalListView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                return JHorizontalListView.this.onDown(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return JHorizontalListView.this.onFling(e1, e2, velocityX, velocityY);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                synchronized (JHorizontalListView.this) {
                    JHorizontalListView.this.mNextX += (int) distanceX;
                }
                JHorizontalListView.this.requestLayout();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                for (int i = 0; i < JHorizontalListView.this.getChildCount(); i++) {
                    View child = JHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (JHorizontalListView.this.mOnItemClicked != null) {
                            JHorizontalListView.this.mOnItemClicked.onItemClick(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                        }
                        if (JHorizontalListView.this.mOnItemSelected != null) {
                            JHorizontalListView.this.mOnItemSelected.onItemSelected(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                int childCount = JHorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = JHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (JHorizontalListView.this.mOnItemLongClicked != null) {
                            JHorizontalListView.this.mOnItemLongClicked.onItemLongClick(JHorizontalListView.this, child, JHorizontalListView.this.mLeftViewIndex + 1 + i, JHorizontalListView.this.mAdapter.getItemId(JHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return;
                        }
                        return;
                    }
                }
            }

            private boolean isEventWithinView(MotionEvent e, View child) {
                Rect viewRect = new Rect();
                int[] childPosition = new int[2];
                child.getLocationOnScreen(childPosition);
                int left = childPosition[0];
                int right = left + child.getWidth();
                int top = childPosition[1];
                int bottom = top + child.getHeight();
                viewRect.set(left, top, right, bottom);
                return viewRect.contains((int) e.getRawX(), (int) e.getRawY());
            }
        };
        initView();
    }

    private synchronized void initView() {
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        this.mOnItemSelected = listener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mOnItemClicked = listener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClicked = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataObserver);
        }
        this.mAdapter = adapter;
        this.mAdapter.registerDataSetObserver(this.mDataObserver);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int position) {
    }

    private void addAndMeasureChild(View child, int viewPos) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(child, viewPos, params, true);
        child.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(getHeight(), ExploreByTouchHelper.INVALID_ID));
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int oldCurrentX = this.mCurrentX;
                initView();
                removeAllViewsInLayout();
                this.mNextX = oldCurrentX;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                int scrollx = this.mScroller.getCurrX();
                this.mNextX = scrollx;
            }
            if (this.mNextX <= 0) {
                this.mNextX = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.mNextX >= this.mMaxX) {
                this.mNextX = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int dx = this.mCurrentX - this.mNextX;
            removeNonVisibleItems(dx);
            fillList(dx);
            positionItems(dx);
            this.mCurrentX = this.mNextX;
            if (!this.mScroller.isFinished()) {
                post(new Runnable() { // from class: com.syu.radio.ctrl.JHorizontalListView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        JHorizontalListView.this.requestLayout();
                    }
                });
            }
        }
    }

    private void fillList(int dx) {
        int edge = 0;
        View child = getChildAt(getChildCount() - 1);
        if (child != null) {
            edge = child.getRight();
        }
        fillListRight(edge, dx);
        int edge2 = 0;
        View child2 = getChildAt(0);
        if (child2 != null) {
            edge2 = child2.getLeft();
        }
        fillListLeft(edge2, dx);
    }

    private void fillListRight(int rightEdge, int dx) {
        while (rightEdge + dx < getWidth() && this.mRightViewIndex < this.mAdapter.getCount()) {
            View child = this.mAdapter.getView(this.mRightViewIndex, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(child, -1);
            rightEdge += child.getMeasuredWidth();
            if (this.mRightViewIndex == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.mCurrentX + rightEdge) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.mRightViewIndex++;
        }
    }

    private void fillListLeft(int leftEdge, int dx) {
        while (leftEdge + dx > 0 && this.mLeftViewIndex >= 0) {
            View child = this.mAdapter.getView(this.mLeftViewIndex, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(child, 0);
            leftEdge -= child.getMeasuredWidth();
            this.mLeftViewIndex--;
            this.mDisplayOffset -= child.getMeasuredWidth();
        }
    }

    private void removeNonVisibleItems(int dx) {
        View child = getChildAt(0);
        while (child != null && child.getRight() + dx <= 0) {
            this.mDisplayOffset += child.getMeasuredWidth();
            this.mRemovedViewQueue.offer(child);
            removeViewInLayout(child);
            this.mLeftViewIndex++;
            child = getChildAt(0);
        }
        View child2 = getChildAt(getChildCount() - 1);
        while (child2 != null && child2.getLeft() + dx >= getWidth()) {
            this.mRemovedViewQueue.offer(child2);
            removeViewInLayout(child2);
            this.mRightViewIndex--;
            child2 = getChildAt(getChildCount() - 1);
        }
    }

    private void positionItems(int dx) {
        if (getChildCount() > 0) {
            this.mDisplayOffset += dx;
            int left = this.mDisplayOffset;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                int childWidth = child.getMeasuredWidth();
                child.layout(left, 0, left + childWidth, child.getMeasuredHeight());
                left += child.getPaddingRight() + childWidth;
            }
        }
    }

    public synchronized void scrollTo(int x) {
        this.mScroller.startScroll(this.mNextX, 0, x - this.mNextX, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handled = super.dispatchTouchEvent(ev);
        boolean handled2 = handled | this.mGesture.onTouchEvent(ev);
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (ev.getAction()) {
            case 0:
                this.startX = (int) ev.getX();
                this.startY = (int) ev.getY();
                break;
            case 2:
                int endX = (int) ev.getX();
                int endY = (int) ev.getY();
                int dx = (int) (endX - this.startX);
                int dy = (int) (endY - this.startY);
                if (Math.abs(dx) + 50 <= Math.abs(dy)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev) | handled2;
    }

    protected boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-velocityX), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected boolean onDown(MotionEvent e) {
        this.mScroller.forceFinished(true);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.startX = ev.getX();
                this.startY = ev.getY();
                break;
            case 2:
                float endX = ev.getX();
                float endY = ev.getY();
                float dx = endX - this.startX;
                float dy = endY - this.startY;
                if (Math.abs(dx) - 10.0f > Math.abs(dy) || Math.abs(dx) < Math.abs(dy) - 10.0f) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
