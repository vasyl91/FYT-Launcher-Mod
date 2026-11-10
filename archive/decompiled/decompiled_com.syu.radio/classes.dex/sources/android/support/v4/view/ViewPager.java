package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo lhs, ItemInfo rhs) {
            return lhs.position - rhs.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    interface Decor {
    }

    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = DEBUG;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(DEBUG);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        float density = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        this.mMinimumVelocity = (int) (400.0f * density);
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        this.mFlingDistance = (int) (25.0f * density);
        this.mCloseEnough = (int) (2.0f * density);
        this.mDefaultGutterSize = (int) (16.0f * density);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int newState) {
        if (this.mScrollState != newState) {
            this.mScrollState = newState;
            if (this.mPageTransformer != null) {
                enableLayers(newState != 0 ? true : DEBUG);
            }
            if (this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageScrollStateChanged(newState);
            }
        }
    }

    public void setAdapter(PagerAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo ii = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, ii.position, ii.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter oldAdapter = this.mAdapter;
        this.mAdapter = adapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = DEBUG;
            boolean wasFirstLayout = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, DEBUG, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!wasFirstLayout) {
                populate();
            } else {
                requestLayout();
            }
        }
        if (this.mAdapterChangeListener != null && oldAdapter != adapter) {
            this.mAdapterChangeListener.onAdapterChanged(oldAdapter, adapter);
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!lp.isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        this.mAdapterChangeListener = listener;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int item) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(item, !this.mFirstLayout, DEBUG);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(item, smoothScroll, DEBUG);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        if (!always && this.mCurItem == item && this.mItems.size() != 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        if (item < 0) {
            item = 0;
        } else if (item >= this.mAdapter.getCount()) {
            item = this.mAdapter.getCount() - 1;
        }
        int pageLimit = this.mOffscreenPageLimit;
        if (item > this.mCurItem + pageLimit || item < this.mCurItem - pageLimit) {
            for (int i = 0; i < this.mItems.size(); i++) {
                this.mItems.get(i).scrolling = true;
            }
        }
        boolean dispatchSelected = this.mCurItem != item;
        if (this.mFirstLayout) {
            this.mCurItem = item;
            if (dispatchSelected && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(item);
            }
            if (dispatchSelected && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(item);
            }
            requestLayout();
            return;
        }
        populate(item);
        scrollToItem(item, smoothScroll, velocity, dispatchSelected);
    }

    private void scrollToItem(int item, boolean smoothScroll, int velocity, boolean dispatchSelected) {
        ItemInfo curInfo = infoForPosition(item);
        int destX = 0;
        if (curInfo != null) {
            int width = getClientWidth();
            destX = (int) (width * Math.max(this.mFirstOffset, Math.min(curInfo.offset, this.mLastOffset)));
        }
        if (smoothScroll) {
            smoothScrollTo(destX, 0, velocity);
            if (dispatchSelected && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(item);
            }
            if (dispatchSelected && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(item);
                return;
            }
            return;
        }
        if (dispatchSelected && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(item);
        }
        if (dispatchSelected && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(item);
        }
        completeScroll(DEBUG);
        scrollTo(destX, 0);
        pageScrolled(destX);
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }

    public void setPageTransformer(boolean reverseDrawingOrder, PageTransformer transformer) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean hasTransformer = transformer != null;
            boolean needsPopulate = hasTransformer != (this.mPageTransformer != null);
            this.mPageTransformer = transformer;
            setChildrenDrawingOrderEnabledCompat(hasTransformer);
            if (hasTransformer) {
                this.mDrawingOrder = reverseDrawingOrder ? 2 : 1;
            } else {
                this.mDrawingOrder = 0;
            }
            if (needsPopulate) {
                populate();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean enable) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(enable));
            } catch (Exception e2) {
                Log.e(TAG, "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int i) {
        int index = this.mDrawingOrder == 2 ? (childCount - 1) - i : i;
        int result = ((LayoutParams) this.mDrawingOrderedChildren.get(index).getLayoutParams()).childIndex;
        return result;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener oldListener = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = listener;
        return oldListener;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int limit) {
        if (limit < 1) {
            Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to 1");
            limit = 1;
        }
        if (limit != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = limit;
            populate();
        }
    }

    public void setPageMargin(int marginPixels) {
        int oldMargin = this.mPageMargin;
        this.mPageMargin = marginPixels;
        int width = getWidth();
        recomputeScrollPosition(width, width, marginPixels, oldMargin);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable d) {
        this.mMarginDrawable = d;
        if (d != null) {
            refreshDrawableState();
        }
        setWillNotDraw(d == null ? true : DEBUG);
        invalidate();
    }

    public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        if (super.verifyDrawable(who) || who == this.mMarginDrawable) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = this.mMarginDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
    }

    void smoothScrollTo(int x, int y, int velocity) {
        int duration;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if (dx == 0 && dy == 0) {
            completeScroll(DEBUG);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int width = getClientWidth();
        int halfWidth = width / 2;
        float distanceRatio = Math.min(1.0f, (1.0f * Math.abs(dx)) / width);
        float distance = halfWidth + (halfWidth * distanceInfluenceForSnapDuration(distanceRatio));
        int velocity2 = Math.abs(velocity);
        if (velocity2 > 0) {
            duration = Math.round(1000.0f * Math.abs(distance / velocity2)) * 4;
        } else {
            float pageWidth = width * this.mAdapter.getPageWidth(this.mCurItem);
            float pageDelta = Math.abs(dx) / (this.mPageMargin + pageWidth);
            duration = (int) ((1.0f + pageDelta) * 100.0f);
        }
        this.mScroller.startScroll(sx, sy, dx, dy, Math.min(duration, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    ItemInfo addNewItem(int position, int index) {
        ItemInfo ii = new ItemInfo();
        ii.position = position;
        ii.object = this.mAdapter.instantiateItem((ViewGroup) this, position);
        ii.widthFactor = this.mAdapter.getPageWidth(position);
        if (index < 0 || index >= this.mItems.size()) {
            this.mItems.add(ii);
        } else {
            this.mItems.add(index, ii);
        }
        return ii;
    }

    void dataSetChanged() {
        int adapterCount = this.mAdapter.getCount();
        this.mExpectedAdapterCount = adapterCount;
        boolean needPopulate = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < adapterCount;
        int newCurrItem = this.mCurItem;
        boolean isUpdating = DEBUG;
        int i = 0;
        while (i < this.mItems.size()) {
            ItemInfo ii = this.mItems.get(i);
            int newPos = this.mAdapter.getItemPosition(ii.object);
            if (newPos != -1) {
                if (newPos == -2) {
                    this.mItems.remove(i);
                    i--;
                    if (!isUpdating) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        isUpdating = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, ii.position, ii.object);
                    needPopulate = true;
                    if (this.mCurItem == ii.position) {
                        newCurrItem = Math.max(0, Math.min(this.mCurItem, adapterCount - 1));
                        needPopulate = true;
                    }
                } else if (ii.position != newPos) {
                    if (ii.position == this.mCurItem) {
                        newCurrItem = newPos;
                    }
                    ii.position = newPos;
                    needPopulate = true;
                }
            }
            i++;
        }
        if (isUpdating) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (needPopulate) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View child = getChildAt(i2);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (!lp.isDecor) {
                    lp.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(newCurrItem, DEBUG, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int newCurrentItem) {
        String resName;
        ItemInfo ii;
        ItemInfo oldCurInfo = null;
        int focusDirection = 2;
        if (this.mCurItem != newCurrentItem) {
            focusDirection = this.mCurItem < newCurrentItem ? 66 : 17;
            oldCurInfo = infoForPosition(this.mCurItem);
            this.mCurItem = newCurrentItem;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrder();
            return;
        }
        if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int pageLimit = this.mOffscreenPageLimit;
            int startPos = Math.max(0, this.mCurItem - pageLimit);
            int N = this.mAdapter.getCount();
            int endPos = Math.min(N - 1, this.mCurItem + pageLimit);
            if (N != this.mExpectedAdapterCount) {
                try {
                    resName = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e) {
                    resName = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + N + " Pager id: " + resName + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
            ItemInfo curItem = null;
            int curIndex = 0;
            while (curIndex < this.mItems.size()) {
                ItemInfo ii2 = this.mItems.get(curIndex);
                if (ii2.position < this.mCurItem) {
                    curIndex++;
                } else {
                    if (ii2.position != this.mCurItem) {
                        break;
                    }
                    curItem = ii2;
                    break;
                }
            }
            if (curItem == null && N > 0) {
                curItem = addNewItem(this.mCurItem, curIndex);
            }
            if (curItem != null) {
                float extraWidthLeft = 0.0f;
                int itemIndex = curIndex - 1;
                ItemInfo ii3 = itemIndex >= 0 ? this.mItems.get(itemIndex) : null;
                int clientWidth = getClientWidth();
                float leftWidthNeeded = clientWidth <= 0 ? 0.0f : (2.0f - curItem.widthFactor) + (getPaddingLeft() / clientWidth);
                for (int pos = this.mCurItem - 1; pos >= 0; pos--) {
                    if (extraWidthLeft >= leftWidthNeeded && pos < startPos) {
                        if (ii3 == null) {
                            break;
                        }
                        if (pos == ii3.position && !ii3.scrolling) {
                            this.mItems.remove(itemIndex);
                            this.mAdapter.destroyItem((ViewGroup) this, pos, ii3.object);
                            itemIndex--;
                            curIndex--;
                            ii3 = itemIndex >= 0 ? this.mItems.get(itemIndex) : null;
                        }
                    } else if (ii3 != null && pos == ii3.position) {
                        extraWidthLeft += ii3.widthFactor;
                        itemIndex--;
                        ii3 = itemIndex >= 0 ? this.mItems.get(itemIndex) : null;
                    } else {
                        extraWidthLeft += addNewItem(pos, itemIndex + 1).widthFactor;
                        curIndex++;
                        ii3 = itemIndex >= 0 ? this.mItems.get(itemIndex) : null;
                    }
                }
                float extraWidthRight = curItem.widthFactor;
                int itemIndex2 = curIndex + 1;
                if (extraWidthRight < 2.0f) {
                    ItemInfo ii4 = itemIndex2 < this.mItems.size() ? this.mItems.get(itemIndex2) : null;
                    float rightWidthNeeded = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    for (int pos2 = this.mCurItem + 1; pos2 < N; pos2++) {
                        if (extraWidthRight >= rightWidthNeeded && pos2 > endPos) {
                            if (ii4 == null) {
                                break;
                            }
                            if (pos2 == ii4.position && !ii4.scrolling) {
                                this.mItems.remove(itemIndex2);
                                this.mAdapter.destroyItem((ViewGroup) this, pos2, ii4.object);
                                ii4 = itemIndex2 < this.mItems.size() ? this.mItems.get(itemIndex2) : null;
                            }
                        } else if (ii4 != null && pos2 == ii4.position) {
                            extraWidthRight += ii4.widthFactor;
                            itemIndex2++;
                            ii4 = itemIndex2 < this.mItems.size() ? this.mItems.get(itemIndex2) : null;
                        } else {
                            ItemInfo ii5 = addNewItem(pos2, itemIndex2);
                            itemIndex2++;
                            extraWidthRight += ii5.widthFactor;
                            ii4 = itemIndex2 < this.mItems.size() ? this.mItems.get(itemIndex2) : null;
                        }
                    }
                }
                calculatePageOffsets(curItem, curIndex, oldCurInfo);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, curItem != null ? curItem.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                lp.childIndex = i;
                if (!lp.isDecor && lp.widthFactor == 0.0f && (ii = infoForChild(child)) != null) {
                    lp.widthFactor = ii.widthFactor;
                    lp.position = ii.position;
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View currentFocused = findFocus();
                ItemInfo ii6 = currentFocused != null ? infoForAnyChild(currentFocused) : null;
                if (ii6 == null || ii6.position != this.mCurItem) {
                    for (int i2 = 0; i2 < getChildCount(); i2++) {
                        View child2 = getChildAt(i2);
                        ItemInfo ii7 = infoForChild(child2);
                        if (ii7 != null && ii7.position == this.mCurItem && child2.requestFocus(focusDirection)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                this.mDrawingOrderedChildren.add(child);
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(ItemInfo curItem, int curIndex, ItemInfo oldCurInfo) {
        ItemInfo ii;
        ItemInfo ii2;
        int N = this.mAdapter.getCount();
        int width = getClientWidth();
        float marginOffset = width > 0 ? this.mPageMargin / width : 0.0f;
        if (oldCurInfo != null) {
            int oldCurPosition = oldCurInfo.position;
            if (oldCurPosition < curItem.position) {
                int itemIndex = 0;
                float offset = oldCurInfo.offset + oldCurInfo.widthFactor + marginOffset;
                int pos = oldCurPosition + 1;
                while (pos <= curItem.position && itemIndex < this.mItems.size()) {
                    ItemInfo ii3 = this.mItems.get(itemIndex);
                    while (true) {
                        ii2 = ii3;
                        if (pos <= ii2.position || itemIndex >= this.mItems.size() - 1) {
                            break;
                        }
                        itemIndex++;
                        ii3 = this.mItems.get(itemIndex);
                    }
                    while (pos < ii2.position) {
                        offset += this.mAdapter.getPageWidth(pos) + marginOffset;
                        pos++;
                    }
                    ii2.offset = offset;
                    offset += ii2.widthFactor + marginOffset;
                    pos++;
                }
            } else if (oldCurPosition > curItem.position) {
                int itemIndex2 = this.mItems.size() - 1;
                float offset2 = oldCurInfo.offset;
                int pos2 = oldCurPosition - 1;
                while (pos2 >= curItem.position && itemIndex2 >= 0) {
                    ItemInfo ii4 = this.mItems.get(itemIndex2);
                    while (true) {
                        ii = ii4;
                        if (pos2 >= ii.position || itemIndex2 <= 0) {
                            break;
                        }
                        itemIndex2--;
                        ii4 = this.mItems.get(itemIndex2);
                    }
                    while (pos2 > ii.position) {
                        offset2 -= this.mAdapter.getPageWidth(pos2) + marginOffset;
                        pos2--;
                    }
                    offset2 -= ii.widthFactor + marginOffset;
                    ii.offset = offset2;
                    pos2--;
                }
            }
        }
        int itemCount = this.mItems.size();
        float offset3 = curItem.offset;
        int pos3 = curItem.position - 1;
        this.mFirstOffset = curItem.position == 0 ? curItem.offset : -3.4028235E38f;
        this.mLastOffset = curItem.position == N + (-1) ? (curItem.offset + curItem.widthFactor) - 1.0f : Float.MAX_VALUE;
        int i = curIndex - 1;
        while (i >= 0) {
            ItemInfo ii5 = this.mItems.get(i);
            while (pos3 > ii5.position) {
                offset3 -= this.mAdapter.getPageWidth(pos3) + marginOffset;
                pos3--;
            }
            offset3 -= ii5.widthFactor + marginOffset;
            ii5.offset = offset3;
            if (ii5.position == 0) {
                this.mFirstOffset = offset3;
            }
            i--;
            pos3--;
        }
        float offset4 = curItem.offset + curItem.widthFactor + marginOffset;
        int pos4 = curItem.position + 1;
        int i2 = curIndex + 1;
        while (i2 < itemCount) {
            ItemInfo ii6 = this.mItems.get(i2);
            while (pos4 < ii6.position) {
                offset4 += this.mAdapter.getPageWidth(pos4) + marginOffset;
                pos4++;
            }
            if (ii6.position == N - 1) {
                this.mLastOffset = (ii6.widthFactor + offset4) - 1.0f;
            }
            ii6.offset = offset4;
            offset4 += ii6.widthFactor + marginOffset;
            i2++;
            pos4++;
        }
        this.mNeedCalculatePageOffsets = DEBUG;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.position);
            out.writeParcelable(this.adapterState, flags);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel in, ClassLoader loader) {
            super(in);
            loader = loader == null ? getClass().getClassLoader() : loader;
            this.position = in.readInt();
            this.adapterState = in.readParcelable(loader);
            this.loader = loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.position = this.mCurItem;
        if (this.mAdapter != null) {
            ss.adapterState = this.mAdapter.saveState();
        }
        return ss;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(ss.adapterState, ss.loader);
            setCurrentItemInternal(ss.position, DEBUG, true);
        } else {
            this.mRestoredCurItem = ss.position;
            this.mRestoredAdapterState = ss.adapterState;
            this.mRestoredClassLoader = ss.loader;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (!checkLayoutParams(params)) {
            params = generateLayoutParams(params);
        }
        LayoutParams lp = (LayoutParams) params;
        lp.isDecor |= child instanceof Decor;
        if (this.mInLayout) {
            if (lp != null && lp.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            lp.needsMeasure = true;
            addViewInLayout(child, index, params);
            return;
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ItemInfo infoForChild(View child) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo ii = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(child, ii.object)) {
                return ii;
            }
        }
        return null;
    }

    ItemInfo infoForAnyChild(View child) {
        while (true) {
            Object parent = child.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                child = (View) parent;
            } else {
                return infoForChild(child);
            }
        }
    }

    ItemInfo infoForPosition(int position) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo ii = this.mItems.get(i);
            if (ii.position == position) {
                return ii;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        LayoutParams lp;
        LayoutParams lp2;
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int measuredWidth = getMeasuredWidth();
        int maxGutterSize = measuredWidth / 10;
        this.mGutterSize = Math.min(maxGutterSize, this.mDefaultGutterSize);
        int childWidthSize = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int childHeightSize = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int size = getChildCount();
        for (int i = 0; i < size; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8 && (lp2 = (LayoutParams) child.getLayoutParams()) != null && lp2.isDecor) {
                int hgrav = lp2.gravity & 7;
                int vgrav = lp2.gravity & 112;
                int widthMode = ExploreByTouchHelper.INVALID_ID;
                int heightMode = ExploreByTouchHelper.INVALID_ID;
                boolean consumeVertical = (vgrav == 48 || vgrav == 80) ? true : DEBUG;
                boolean consumeHorizontal = (hgrav == 3 || hgrav == 5) ? true : DEBUG;
                if (consumeVertical) {
                    widthMode = 1073741824;
                } else if (consumeHorizontal) {
                    heightMode = 1073741824;
                }
                int widthSize = childWidthSize;
                int heightSize = childHeightSize;
                if (lp2.width != -2) {
                    widthMode = 1073741824;
                    if (lp2.width != -1) {
                        widthSize = lp2.width;
                    }
                }
                if (lp2.height != -2) {
                    heightMode = 1073741824;
                    if (lp2.height != -1) {
                        heightSize = lp2.height;
                    }
                }
                int widthSpec = View.MeasureSpec.makeMeasureSpec(widthSize, widthMode);
                int heightSpec = View.MeasureSpec.makeMeasureSpec(heightSize, heightMode);
                child.measure(widthSpec, heightSpec);
                if (consumeVertical) {
                    childHeightSize -= child.getMeasuredHeight();
                } else if (consumeHorizontal) {
                    childWidthSize -= child.getMeasuredWidth();
                }
            }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(childWidthSize, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(childHeightSize, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = DEBUG;
        int size2 = getChildCount();
        for (int i2 = 0; i2 < size2; i2++) {
            View child2 = getChildAt(i2);
            if (child2.getVisibility() != 8 && ((lp = (LayoutParams) child2.getLayoutParams()) == null || !lp.isDecor)) {
                int widthSpec2 = View.MeasureSpec.makeMeasureSpec((int) (childWidthSize * lp.widthFactor), 1073741824);
                child2.measure(widthSpec2, this.mChildHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            recomputeScrollPosition(w, oldw, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        if (oldWidth > 0 && !this.mItems.isEmpty()) {
            int widthWithMargin = ((width - getPaddingLeft()) - getPaddingRight()) + margin;
            int oldWidthWithMargin = ((oldWidth - getPaddingLeft()) - getPaddingRight()) + oldMargin;
            int xpos = getScrollX();
            float pageOffset = xpos / oldWidthWithMargin;
            int newOffsetPixels = (int) (widthWithMargin * pageOffset);
            scrollTo(newOffsetPixels, getScrollY());
            if (!this.mScroller.isFinished()) {
                int newDuration = this.mScroller.getDuration() - this.mScroller.timePassed();
                ItemInfo targetInfo = infoForPosition(this.mCurItem);
                this.mScroller.startScroll(newOffsetPixels, 0, (int) (targetInfo.offset * width), 0, newDuration);
                return;
            }
            return;
        }
        ItemInfo ii = infoForPosition(this.mCurItem);
        float scrollOffset = ii != null ? Math.min(ii.offset, this.mLastOffset) : 0.0f;
        int scrollPos = (int) (((width - getPaddingLeft()) - getPaddingRight()) * scrollOffset);
        if (scrollPos != getScrollX()) {
            completeScroll(DEBUG);
            scrollTo(scrollPos, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ItemInfo ii;
        int childLeft;
        int childTop;
        int count = getChildCount();
        int width = r - l;
        int height = b - t;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int decorCount = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.isDecor) {
                    int hgrav = lp.gravity & 7;
                    int vgrav = lp.gravity & 112;
                    switch (hgrav) {
                        case 1:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            childLeft = paddingLeft;
                            break;
                        case 3:
                            childLeft = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                            break;
                        case 5:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    switch (vgrav) {
                        case 16:
                            childTop = Math.max((height - child.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            childTop = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                            break;
                        case 80:
                            childTop = (height - paddingBottom) - child.getMeasuredHeight();
                            paddingBottom += child.getMeasuredHeight();
                            break;
                        default:
                            childTop = paddingTop;
                            break;
                    }
                    int childLeft2 = childLeft + scrollX;
                    child.layout(childLeft2, childTop, child.getMeasuredWidth() + childLeft2, child.getMeasuredHeight() + childTop);
                    decorCount++;
                }
            }
        }
        int childWidth = (width - paddingLeft) - paddingRight;
        for (int i2 = 0; i2 < count; i2++) {
            View child2 = getChildAt(i2);
            if (child2.getVisibility() != 8) {
                LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                if (!lp2.isDecor && (ii = infoForChild(child2)) != null) {
                    int loff = (int) (childWidth * ii.offset);
                    int childLeft3 = paddingLeft + loff;
                    int childTop2 = paddingTop;
                    if (lp2.needsMeasure) {
                        lp2.needsMeasure = DEBUG;
                        int widthSpec = View.MeasureSpec.makeMeasureSpec((int) (childWidth * lp2.widthFactor), 1073741824);
                        int heightSpec = View.MeasureSpec.makeMeasureSpec((height - paddingTop) - paddingBottom, 1073741824);
                        child2.measure(widthSpec, heightSpec);
                    }
                    child2.layout(childLeft3, childTop2, child2.getMeasuredWidth() + childLeft3, child2.getMeasuredHeight() + childTop2);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = height - paddingBottom;
        this.mDecorChildCount = decorCount;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, DEBUG, 0, DEBUG);
        }
        this.mFirstLayout = DEBUG;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (oldX != x || oldY != y) {
                scrollTo(x, y);
                if (!pageScrolled(x)) {
                    this.mScroller.abortAnimation();
                    scrollTo(0, y);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        completeScroll(true);
    }

    private boolean pageScrolled(int xpos) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = DEBUG;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return DEBUG;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo ii = infoForCurrentScrollPosition();
        int width = getClientWidth();
        int widthWithMargin = width + this.mPageMargin;
        float marginOffset = this.mPageMargin / width;
        int currentPage = ii.position;
        float pageOffset = ((xpos / width) - ii.offset) / (ii.widthFactor + marginOffset);
        int offsetPixels = (int) (widthWithMargin * pageOffset);
        this.mCalledSuper = DEBUG;
        onPageScrolled(currentPage, pageOffset, offsetPixels);
        if (!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        int childLeft;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.isDecor) {
                    int hgrav = lp.gravity & 7;
                    switch (hgrav) {
                        case 1:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            childLeft = paddingLeft;
                            break;
                        case 3:
                            childLeft = paddingLeft;
                            paddingLeft += child.getWidth();
                            break;
                        case 5:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    int childOffset = (childLeft + scrollX) - child.getLeft();
                    if (childOffset != 0) {
                        child.offsetLeftAndRight(childOffset);
                    }
                }
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View child2 = getChildAt(i2);
                if (!((LayoutParams) child2.getLayoutParams()).isDecor) {
                    float transformPos = (child2.getLeft() - scrollX2) / getClientWidth();
                    this.mPageTransformer.transformPage(child2, transformPos);
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void completeScroll(boolean postEvents) {
        boolean needPopulate = this.mScrollState == 2;
        if (needPopulate) {
            setScrollingCacheEnabled(DEBUG);
            this.mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (oldX != x || oldY != y) {
                scrollTo(x, y);
            }
        }
        this.mPopulatePending = DEBUG;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo ii = this.mItems.get(i);
            if (ii.scrolling) {
                needPopulate = true;
                ii.scrolling = DEBUG;
            }
        }
        if (needPopulate) {
            if (postEvents) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private boolean isGutterDrag(float x, float dx) {
        if ((x >= this.mGutterSize || dx <= 0.0f) && (x <= getWidth() - this.mGutterSize || dx >= 0.0f)) {
            return DEBUG;
        }
        return true;
    }

    private void enableLayers(boolean enable) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int layerType = enable ? 2 : 0;
            ViewCompat.setLayerType(getChildAt(i), layerType, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = DEBUG;
            this.mIsUnableToDrag = DEBUG;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return DEBUG;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return DEBUG;
            }
        }
        switch (action) {
            case 0:
                float x = ev.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = ev.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                this.mIsUnableToDrag = DEBUG;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = DEBUG;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                } else {
                    completeScroll(DEBUG);
                    this.mIsBeingDragged = DEBUG;
                }
                break;
            case 2:
                int activePointerId = this.mActivePointerId;
                if (activePointerId != -1) {
                    int pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId);
                    float x2 = MotionEventCompat.getX(ev, pointerIndex);
                    float dx = x2 - this.mLastMotionX;
                    float xDiff = Math.abs(dx);
                    float y2 = MotionEventCompat.getY(ev, pointerIndex);
                    float yDiff = Math.abs(y2 - this.mInitialMotionY);
                    if (dx != 0.0f && !isGutterDrag(this.mLastMotionX, dx) && canScroll(this, DEBUG, (int) dx, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return DEBUG;
                    }
                    if (xDiff > this.mTouchSlop && 0.5f * xDiff > yDiff) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        this.mLastMotionX = dx > 0.0f ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                        this.mLastMotionY = y2;
                        setScrollingCacheEnabled(true);
                    } else if (yDiff > this.mTouchSlop) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mFakeDragging) {
            return true;
        }
        if ((ev.getAction() == 0 && ev.getEdgeFlags() != 0) || this.mAdapter == null || this.mAdapter.getCount() == 0) {
            return DEBUG;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        int action = ev.getAction();
        boolean needsInvalidate = DEBUG;
        switch (action & 255) {
            case 0:
                this.mScroller.abortAnimation();
                this.mPopulatePending = DEBUG;
                populate();
                float x = ev.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = ev.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int width = getClientWidth();
                    int scrollX = getScrollX();
                    ItemInfo ii = infoForCurrentScrollPosition();
                    int currentPage = ii.position;
                    float pageOffset = ((scrollX / width) - ii.offset) / ii.widthFactor;
                    int activePointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x2 = MotionEventCompat.getX(ev, activePointerIndex);
                    int totalDelta = (int) (x2 - this.mInitialMotionX);
                    int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity, totalDelta);
                    setCurrentItemInternal(nextPage, true, true, initialVelocity);
                    this.mActivePointerId = -1;
                    endDrag();
                    needsInvalidate = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    int pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x3 = MotionEventCompat.getX(ev, pointerIndex);
                    float xDiff = Math.abs(x3 - this.mLastMotionX);
                    float y2 = MotionEventCompat.getY(ev, pointerIndex);
                    float yDiff = Math.abs(y2 - this.mLastMotionY);
                    if (xDiff > this.mTouchSlop && xDiff > yDiff) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        this.mLastMotionX = x3 - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                        this.mLastMotionY = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    int activePointerIndex2 = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x4 = MotionEventCompat.getX(ev, activePointerIndex2);
                    needsInvalidate = false | performDrag(x4);
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, 0, DEBUG);
                    this.mActivePointerId = -1;
                    endDrag();
                    needsInvalidate = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                }
                break;
            case 5:
                int index = MotionEventCompat.getActionIndex(ev);
                float x5 = MotionEventCompat.getX(ev, index);
                this.mLastMotionX = x5;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                this.mLastMotionX = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                break;
        }
        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean disallowIntercept) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    private boolean performDrag(float x) {
        boolean needsInvalidate = DEBUG;
        float deltaX = this.mLastMotionX - x;
        this.mLastMotionX = x;
        float oldScrollX = getScrollX();
        float scrollX = oldScrollX + deltaX;
        int width = getClientWidth();
        float leftBound = width * this.mFirstOffset;
        float rightBound = width * this.mLastOffset;
        boolean leftAbsolute = true;
        boolean rightAbsolute = true;
        ItemInfo firstItem = this.mItems.get(0);
        ItemInfo lastItem = this.mItems.get(this.mItems.size() - 1);
        if (firstItem.position != 0) {
            leftAbsolute = DEBUG;
            leftBound = firstItem.offset * width;
        }
        if (lastItem.position != this.mAdapter.getCount() - 1) {
            rightAbsolute = DEBUG;
            rightBound = lastItem.offset * width;
        }
        if (scrollX < leftBound) {
            if (leftAbsolute) {
                float over = leftBound - scrollX;
                needsInvalidate = this.mLeftEdge.onPull(Math.abs(over) / width);
            }
            scrollX = leftBound;
        } else if (scrollX > rightBound) {
            if (rightAbsolute) {
                float over2 = scrollX - rightBound;
                needsInvalidate = this.mRightEdge.onPull(Math.abs(over2) / width);
            }
            scrollX = rightBound;
        }
        this.mLastMotionX += scrollX - ((int) scrollX);
        scrollTo((int) scrollX, getScrollY());
        pageScrolled((int) scrollX);
        return needsInvalidate;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int width = getClientWidth();
        float scrollOffset = width > 0 ? getScrollX() / width : 0.0f;
        float marginOffset = width > 0 ? this.mPageMargin / width : 0.0f;
        int lastPos = -1;
        float lastOffset = 0.0f;
        float lastWidth = 0.0f;
        boolean first = true;
        ItemInfo lastItem = null;
        int i = 0;
        while (i < this.mItems.size()) {
            ItemInfo ii = this.mItems.get(i);
            if (!first && ii.position != lastPos + 1) {
                ii = this.mTempItem;
                ii.offset = lastOffset + lastWidth + marginOffset;
                ii.position = lastPos + 1;
                ii.widthFactor = this.mAdapter.getPageWidth(ii.position);
                i--;
            }
            float offset = ii.offset;
            float rightBound = ii.widthFactor + offset + marginOffset;
            if (!first && scrollOffset < offset) {
                return lastItem;
            }
            if (scrollOffset >= rightBound && i != this.mItems.size() - 1) {
                first = DEBUG;
                lastPos = ii.position;
                lastOffset = offset;
                lastWidth = ii.widthFactor;
                lastItem = ii;
                i++;
            } else {
                ItemInfo lastItem2 = ii;
                return lastItem2;
            }
        }
        return lastItem;
    }

    private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        int targetPage;
        if (Math.abs(deltaX) > this.mFlingDistance && Math.abs(velocity) > this.mMinimumVelocity) {
            targetPage = velocity > 0 ? currentPage : currentPage + 1;
        } else {
            float truncator = currentPage >= this.mCurItem ? 0.4f : 0.6f;
            targetPage = (int) (currentPage + pageOffset + truncator);
        }
        if (this.mItems.size() > 0) {
            ItemInfo firstItem = this.mItems.get(0);
            ItemInfo lastItem = this.mItems.get(this.mItems.size() - 1);
            return Math.max(firstItem.position, Math.min(targetPage, lastItem.position));
        }
        return targetPage;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean needsInvalidate = DEBUG;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int restoreCount = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                needsInvalidate = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(restoreCount);
            }
            if (!this.mRightEdge.isFinished()) {
                int restoreCount2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                needsInvalidate |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(restoreCount2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float drawAt;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float marginOffset = this.mPageMargin / width;
            int itemIndex = 0;
            ItemInfo ii = this.mItems.get(0);
            float offset = ii.offset;
            int itemCount = this.mItems.size();
            int firstPos = ii.position;
            int lastPos = this.mItems.get(itemCount - 1).position;
            for (int pos = firstPos; pos < lastPos; pos++) {
                while (pos > ii.position && itemIndex < itemCount) {
                    itemIndex++;
                    ii = this.mItems.get(itemIndex);
                }
                if (pos == ii.position) {
                    drawAt = (ii.offset + ii.widthFactor) * width;
                    offset = ii.offset + ii.widthFactor + marginOffset;
                } else {
                    float widthFactor = this.mAdapter.getPageWidth(pos);
                    drawAt = (offset + widthFactor) * width;
                    offset += widthFactor + marginOffset;
                }
                if (this.mPageMargin + drawAt > scrollX) {
                    this.mMarginDrawable.setBounds((int) drawAt, this.mTopPageBounds, (int) (this.mPageMargin + drawAt + 0.5f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (drawAt > scrollX + width) {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return DEBUG;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long time = SystemClock.uptimeMillis();
        MotionEvent ev = MotionEvent.obtain(time, time, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(ev);
        ev.recycle();
        this.mFakeDragBeginTime = time;
        return true;
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        int width = getClientWidth();
        int scrollX = getScrollX();
        ItemInfo ii = infoForCurrentScrollPosition();
        int currentPage = ii.position;
        float pageOffset = ((scrollX / width) - ii.offset) / ii.widthFactor;
        int totalDelta = (int) (this.mLastMotionX - this.mInitialMotionX);
        int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity, totalDelta);
        setCurrentItemInternal(nextPage, true, true, initialVelocity);
        endDrag();
        this.mFakeDragging = DEBUG;
    }

    public void fakeDragBy(float xOffset) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.mLastMotionX += xOffset;
        float oldScrollX = getScrollX();
        float scrollX = oldScrollX - xOffset;
        int width = getClientWidth();
        float leftBound = width * this.mFirstOffset;
        float rightBound = width * this.mLastOffset;
        ItemInfo firstItem = this.mItems.get(0);
        ItemInfo lastItem = this.mItems.get(this.mItems.size() - 1);
        if (firstItem.position != 0) {
            leftBound = firstItem.offset * width;
        }
        if (lastItem.position != this.mAdapter.getCount() - 1) {
            rightBound = lastItem.offset * width;
        }
        if (scrollX < leftBound) {
            scrollX = leftBound;
        } else if (scrollX > rightBound) {
            scrollX = rightBound;
        }
        this.mLastMotionX += scrollX - ((int) scrollX);
        scrollTo((int) scrollX, getScrollY());
        pageScrolled((int) scrollX);
        long time = SystemClock.uptimeMillis();
        MotionEvent ev = MotionEvent.obtain(this.mFakeDragBeginTime, time, 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(ev);
        ev.recycle();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = MotionEventCompat.getActionIndex(ev);
        int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = DEBUG;
        this.mIsUnableToDrag = DEBUG;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean enabled) {
        if (this.mScrollingCacheEnabled != enabled) {
            this.mScrollingCacheEnabled = enabled;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        if (this.mAdapter == null) {
            return DEBUG;
        }
        int width = getClientWidth();
        int scrollX = getScrollX();
        if (direction < 0) {
            return scrollX > ((int) (((float) width) * this.mFirstOffset));
        }
        if (direction > 0) {
            return scrollX < ((int) (((float) width) * this.mLastOffset));
        }
        return DEBUG;
    }

    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            int count = group.getChildCount();
            for (int i = count - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom() && canScroll(child, true, dx, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                    return true;
                }
            }
        }
        if (checkV && ViewCompat.canScrollHorizontally(v, -dx)) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (super.dispatchKeyEvent(event) || executeKeyEvent(event)) {
            return true;
        }
        return DEBUG;
    }

    public boolean executeKeyEvent(KeyEvent event) {
        if (event.getAction() != 0) {
            return DEBUG;
        }
        switch (event.getKeyCode()) {
            case 21:
                boolean handled = arrowScroll(17);
                return handled;
            case 22:
                boolean handled2 = arrowScroll(66);
                return handled2;
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return DEBUG;
                }
                if (KeyEventCompat.hasNoModifiers(event)) {
                    boolean handled3 = arrowScroll(2);
                    return handled3;
                }
                if (!KeyEventCompat.hasModifiers(event, 1)) {
                    return DEBUG;
                }
                boolean handled4 = arrowScroll(1);
                return handled4;
            default:
                return DEBUG;
        }
    }

    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        } else if (currentFocused != null) {
            boolean isChild = DEBUG;
            for (ViewParent parent = currentFocused.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    isChild = true;
                    break;
                }
            }
            if (!isChild) {
                StringBuilder sb = new StringBuilder();
                sb.append(currentFocused.getClass().getSimpleName());
                for (ViewParent parent2 = currentFocused.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                currentFocused = null;
            }
        }
        boolean handled = DEBUG;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        if (nextFocused != null && nextFocused != currentFocused) {
            if (direction == 17) {
                int nextLeft = getChildRectInPagerCoordinates(this.mTempRect, nextFocused).left;
                int currLeft = getChildRectInPagerCoordinates(this.mTempRect, currentFocused).left;
                handled = (currentFocused == null || nextLeft < currLeft) ? nextFocused.requestFocus() : pageLeft();
            } else if (direction == 66) {
                int nextLeft2 = getChildRectInPagerCoordinates(this.mTempRect, nextFocused).left;
                int currLeft2 = getChildRectInPagerCoordinates(this.mTempRect, currentFocused).left;
                handled = (currentFocused == null || nextLeft2 > currLeft2) ? nextFocused.requestFocus() : pageRight();
            }
        } else if (direction == 17 || direction == 1) {
            handled = pageLeft();
        } else if (direction == 66 || direction == 2) {
            handled = pageRight();
        }
        if (handled) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        }
        return handled;
    }

    private Rect getChildRectInPagerCoordinates(Rect outRect, View child) {
        if (outRect == null) {
            outRect = new Rect();
        }
        if (child == null) {
            outRect.set(0, 0, 0, 0);
        } else {
            outRect.left = child.getLeft();
            outRect.right = child.getRight();
            outRect.top = child.getTop();
            outRect.bottom = child.getBottom();
            ViewParent parent = child.getParent();
            while ((parent instanceof ViewGroup) && parent != this) {
                ViewGroup group = (ViewGroup) parent;
                outRect.left += group.getLeft();
                outRect.right += group.getRight();
                outRect.top += group.getTop();
                outRect.bottom += group.getBottom();
                parent = group.getParent();
            }
        }
        return outRect;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        ItemInfo ii;
        int focusableCount = views.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem) {
                    child.addFocusables(views, direction, focusableMode);
                }
            }
        }
        if ((descendantFocusability != 262144 || focusableCount == views.size()) && isFocusable()) {
            if (((focusableMode & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && views != null) {
                views.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> views) {
        ItemInfo ii;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem) {
                child.addTouchables(views);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int index;
        int increment;
        int end;
        ItemInfo ii;
        int count = getChildCount();
        if ((direction & 2) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        for (int i = index; i != end; i += increment) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem && child.requestFocus(direction, previouslyFocusedRect)) {
                return true;
            }
        }
        return DEBUG;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        ItemInfo ii;
        if (event.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(event);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem && child.dispatchPopulateAccessibilityEvent(event)) {
                return true;
            }
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        if ((p instanceof LayoutParams) && super.checkLayoutParams(p)) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat recordCompat = AccessibilityRecordCompat.obtain();
            recordCompat.setScrollable(canScroll());
            if (event.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
                recordCompat.setItemCount(ViewPager.this.mAdapter.getCount());
                recordCompat.setFromIndex(ViewPager.this.mCurItem);
                recordCompat.setToIndex(ViewPager.this.mCurItem);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName(ViewPager.class.getName());
            info.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(1)) {
                info.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                info.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            if (super.performAccessibilityAction(host, action, args)) {
                return true;
            }
            switch (action) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return ViewPager.DEBUG;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
                    return true;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return ViewPager.DEBUG;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
                    return true;
                default:
                    return ViewPager.DEBUG;
            }
        }

        private boolean canScroll() {
            if (ViewPager.this.mAdapter == null || ViewPager.this.mAdapter.getCount() <= 1) {
                return ViewPager.DEBUG;
            }
            return true;
        }
    }

    private class PagerObserver extends DataSetObserver {
        private PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.widthFactor = 0.0f;
            TypedArray a = context.obtainStyledAttributes(attrs, ViewPager.LAYOUT_ATTRS);
            this.gravity = a.getInteger(0, 48);
            a.recycle();
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View lhs, View rhs) {
            LayoutParams llp = (LayoutParams) lhs.getLayoutParams();
            LayoutParams rlp = (LayoutParams) rhs.getLayoutParams();
            if (llp.isDecor != rlp.isDecor) {
                return llp.isDecor ? 1 : -1;
            }
            return llp.position - rlp.position;
        }
    }
}
