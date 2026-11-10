package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.yanzhenjie.recyclerview.touch.DefaultItemTouchHelper;
import com.yanzhenjie.recyclerview.touch.OnItemMoveListener;
import com.yanzhenjie.recyclerview.touch.OnItemMovementListener;
import com.yanzhenjie.recyclerview.touch.OnItemStateChangedListener;
import com.yanzhenjie.recyclerview.widget.DefaultLoadMoreView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeRecyclerView extends RecyclerView {
    private static final int INVALID_POSITION = -1;
    public static final int LEFT_DIRECTION = 1;
    public static final int RIGHT_DIRECTION = -1;
    private boolean allowSwipeDelete;
    private boolean isAutoLoadMore;
    private boolean isLoadError;
    private boolean isLoadMore;
    private RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private AdapterWrapper mAdapterWrapper;
    private boolean mDataEmpty;
    private List<Integer> mDisableSwipeItemMenuList;
    private int mDownX;
    private int mDownY;
    private List<View> mFooterViewList;
    private boolean mHasMore;
    private List<View> mHeaderViewList;
    private DefaultItemTouchHelper mItemTouchHelper;
    private LoadMoreListener mLoadMoreListener;
    private LoadMoreView mLoadMoreView;
    protected SwipeMenuLayout mOldSwipedLayout;
    protected int mOldTouchedPosition;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemMenuClickListener mOnItemMenuClickListener;
    protected int mScaleTouchSlop;
    private int mScrollState;
    private boolean mSwipeItemMenuEnable;
    private SwipeMenuCreator mSwipeMenuCreator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionMode {
    }

    public interface LoadMoreListener {
        void onLoadMore();
    }

    public interface LoadMoreView {
        void onLoadError(int i, String str);

        void onLoadFinish(boolean z, boolean z2);

        void onLoading();

        void onWaitToLoadMore(LoadMoreListener loadMoreListener);
    }

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOldTouchedPosition = -1;
        this.mSwipeItemMenuEnable = true;
        this.mDisableSwipeItemMenuList = new ArrayList();
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.yanzhenjie.recyclerview.SwipeRecyclerView.2
            public void onChanged() {
                SwipeRecyclerView.this.mAdapterWrapper.notifyDataSetChanged();
            }

            public void onItemRangeChanged(int i2, int i3) {
                SwipeRecyclerView.this.mAdapterWrapper.notifyItemRangeChanged(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            public void onItemRangeChanged(int i2, int i3, Object obj) {
                SwipeRecyclerView.this.mAdapterWrapper.notifyItemRangeChanged(i2 + SwipeRecyclerView.this.getHeaderCount(), i3, obj);
            }

            public void onItemRangeInserted(int i2, int i3) {
                SwipeRecyclerView.this.mAdapterWrapper.notifyItemRangeInserted(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            public void onItemRangeRemoved(int i2, int i3) {
                SwipeRecyclerView.this.mAdapterWrapper.notifyItemRangeRemoved(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            public void onItemRangeMoved(int i2, int i3, int i4) {
                SwipeRecyclerView.this.mAdapterWrapper.notifyItemMoved(i2 + SwipeRecyclerView.this.getHeaderCount(), i3 + SwipeRecyclerView.this.getHeaderCount());
            }
        };
        this.mHeaderViewList = new ArrayList();
        this.mFooterViewList = new ArrayList();
        this.mScrollState = -1;
        this.isLoadMore = false;
        this.isAutoLoadMore = true;
        this.isLoadError = false;
        this.mDataEmpty = true;
        this.mHasMore = false;
        this.mScaleTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void initializeItemTouchHelper() {
        if (this.mItemTouchHelper == null) {
            DefaultItemTouchHelper defaultItemTouchHelper = new DefaultItemTouchHelper();
            this.mItemTouchHelper = defaultItemTouchHelper;
            defaultItemTouchHelper.attachToRecyclerView(this);
        }
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.setOnItemMoveListener(onItemMoveListener);
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.setOnItemMovementListener(onItemMovementListener);
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.setOnItemStateChangedListener(onItemStateChangedListener);
    }

    public void setSwipeItemMenuEnabled(boolean z) {
        this.mSwipeItemMenuEnable = z;
    }

    public boolean isSwipeItemMenuEnabled() {
        return this.mSwipeItemMenuEnable;
    }

    public void setSwipeItemMenuEnabled(int i, boolean z) {
        if (z) {
            if (this.mDisableSwipeItemMenuList.contains(Integer.valueOf(i))) {
                this.mDisableSwipeItemMenuList.remove(Integer.valueOf(i));
            }
        } else {
            if (this.mDisableSwipeItemMenuList.contains(Integer.valueOf(i))) {
                return;
            }
            this.mDisableSwipeItemMenuList.add(Integer.valueOf(i));
        }
    }

    public boolean isSwipeItemMenuEnabled(int i) {
        return !this.mDisableSwipeItemMenuList.contains(Integer.valueOf(i));
    }

    public void setLongPressDragEnabled(boolean z) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.setLongPressDragEnabled(z);
    }

    public boolean isLongPressDragEnabled() {
        initializeItemTouchHelper();
        return this.mItemTouchHelper.isLongPressDragEnabled();
    }

    public void setItemViewSwipeEnabled(boolean z) {
        initializeItemTouchHelper();
        this.allowSwipeDelete = z;
        this.mItemTouchHelper.setItemViewSwipeEnabled(z);
    }

    public boolean isItemViewSwipeEnabled() {
        initializeItemTouchHelper();
        return this.mItemTouchHelper.isItemViewSwipeEnabled();
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.startDrag(viewHolder);
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        initializeItemTouchHelper();
        this.mItemTouchHelper.startSwipe(viewHolder);
    }

    private void checkAdapterExist(String str) {
        if (this.mAdapterWrapper != null) {
            throw new IllegalStateException(str);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            return;
        }
        checkAdapterExist("Cannot set item click listener, setAdapter has already been called.");
        this.mOnItemClickListener = new ItemClickListener(this, onItemClickListener);
    }

    private static class ItemClickListener implements OnItemClickListener {
        private OnItemClickListener mListener;
        private SwipeRecyclerView mRecyclerView;

        public ItemClickListener(SwipeRecyclerView swipeRecyclerView, OnItemClickListener onItemClickListener) {
            this.mRecyclerView = swipeRecyclerView;
            this.mListener = onItemClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemClickListener
        public void onItemClick(View view, int i) {
            int headerCount = i - this.mRecyclerView.getHeaderCount();
            if (headerCount >= 0) {
                this.mListener.onItemClick(view, headerCount);
            }
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            return;
        }
        checkAdapterExist("Cannot set item long click listener, setAdapter has already been called.");
        this.mOnItemLongClickListener = new ItemLongClickListener(this, onItemLongClickListener);
    }

    private static class ItemLongClickListener implements OnItemLongClickListener {
        private OnItemLongClickListener mListener;
        private SwipeRecyclerView mRecyclerView;

        public ItemLongClickListener(SwipeRecyclerView swipeRecyclerView, OnItemLongClickListener onItemLongClickListener) {
            this.mRecyclerView = swipeRecyclerView;
            this.mListener = onItemLongClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemLongClickListener
        public void onItemLongClick(View view, int i) {
            int headerCount = i - this.mRecyclerView.getHeaderCount();
            if (headerCount >= 0) {
                this.mListener.onItemLongClick(view, headerCount);
            }
        }
    }

    public void setSwipeMenuCreator(SwipeMenuCreator swipeMenuCreator) {
        if (swipeMenuCreator == null) {
            return;
        }
        checkAdapterExist("Cannot set menu creator, setAdapter has already been called.");
        this.mSwipeMenuCreator = swipeMenuCreator;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener onItemMenuClickListener) {
        if (onItemMenuClickListener == null) {
            return;
        }
        checkAdapterExist("Cannot set menu item click listener, setAdapter has already been called.");
        this.mOnItemMenuClickListener = new ItemMenuClickListener(this, onItemMenuClickListener);
    }

    private static class ItemMenuClickListener implements OnItemMenuClickListener {
        private OnItemMenuClickListener mListener;
        private SwipeRecyclerView mRecyclerView;

        public ItemMenuClickListener(SwipeRecyclerView swipeRecyclerView, OnItemMenuClickListener onItemMenuClickListener) {
            this.mRecyclerView = swipeRecyclerView;
            this.mListener = onItemMenuClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemMenuClickListener
        public void onItemClick(SwipeMenuBridge swipeMenuBridge, int i) {
            int headerCount = i - this.mRecyclerView.getHeaderCount();
            if (headerCount >= 0) {
                this.mListener.onItemClick(swipeMenuBridge, headerCount);
            }
        }
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.yanzhenjie.recyclerview.SwipeRecyclerView.1
                public int getSpanSize(int i) {
                    if (SwipeRecyclerView.this.mAdapterWrapper.isHeader(i) || SwipeRecyclerView.this.mAdapterWrapper.isFooter(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i - SwipeRecyclerView.this.getHeaderCount());
                    }
                    return 1;
                }
            });
        }
        super.setLayoutManager(layoutManager);
    }

    public RecyclerView.Adapter getOriginAdapter() {
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper == null) {
            return null;
        }
        return adapterWrapper.getOriginAdapter();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper != null) {
            adapterWrapper.getOriginAdapter().unregisterAdapterDataObserver(this.mAdapterDataObserver);
        }
        if (adapter == null) {
            this.mAdapterWrapper = null;
        } else {
            adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            AdapterWrapper adapterWrapper2 = new AdapterWrapper(getContext(), adapter);
            this.mAdapterWrapper = adapterWrapper2;
            adapterWrapper2.setOnItemClickListener(this.mOnItemClickListener);
            this.mAdapterWrapper.setOnItemLongClickListener(this.mOnItemLongClickListener);
            this.mAdapterWrapper.setSwipeMenuCreator(this.mSwipeMenuCreator);
            this.mAdapterWrapper.setOnItemMenuClickListener(this.mOnItemMenuClickListener);
            if (this.mHeaderViewList.size() > 0) {
                Iterator<View> it = this.mHeaderViewList.iterator();
                while (it.hasNext()) {
                    this.mAdapterWrapper.addHeaderView(it.next());
                }
            }
            if (this.mFooterViewList.size() > 0) {
                Iterator<View> it2 = this.mFooterViewList.iterator();
                while (it2.hasNext()) {
                    this.mAdapterWrapper.addFooterView(it2.next());
                }
            }
        }
        super.setAdapter(this.mAdapterWrapper);
    }

    public void addHeaderView(View view) {
        this.mHeaderViewList.add(view);
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper != null) {
            adapterWrapper.addHeaderViewAndNotify(view);
        }
    }

    public void removeHeaderView(View view) {
        this.mHeaderViewList.remove(view);
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper != null) {
            adapterWrapper.removeHeaderViewAndNotify(view);
        }
    }

    public void addFooterView(View view) {
        this.mFooterViewList.add(view);
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper != null) {
            adapterWrapper.addFooterViewAndNotify(view);
        }
    }

    public void removeFooterView(View view) {
        this.mFooterViewList.remove(view);
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper != null) {
            adapterWrapper.removeFooterViewAndNotify(view);
        }
    }

    public int getHeaderCount() {
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper == null) {
            return 0;
        }
        return adapterWrapper.getHeaderCount();
    }

    public int getFooterCount() {
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper == null) {
            return 0;
        }
        return adapterWrapper.getFooterCount();
    }

    public int getItemViewType(int i) {
        AdapterWrapper adapterWrapper = this.mAdapterWrapper;
        if (adapterWrapper == null) {
            return 0;
        }
        return adapterWrapper.getItemViewType(i);
    }

    public void smoothOpenLeftMenu(int i) {
        smoothOpenMenu(i, 1, 200);
    }

    public void smoothOpenLeftMenu(int i, int i2) {
        smoothOpenMenu(i, 1, i2);
    }

    public void smoothOpenRightMenu(int i) {
        smoothOpenMenu(i, -1, 200);
    }

    public void smoothOpenRightMenu(int i, int i2) {
        smoothOpenMenu(i, -1, i2);
    }

    public void smoothOpenMenu(int i, int i2, int i3) {
        SwipeMenuLayout swipeMenuLayout = this.mOldSwipedLayout;
        if (swipeMenuLayout != null && swipeMenuLayout.isMenuOpen()) {
            this.mOldSwipedLayout.smoothCloseMenu();
        }
        int headerCount = i + getHeaderCount();
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(headerCount);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View swipeMenuView = getSwipeMenuView(viewHolderFindViewHolderForAdapterPosition.itemView);
            if (swipeMenuView instanceof SwipeMenuLayout) {
                SwipeMenuLayout swipeMenuLayout2 = (SwipeMenuLayout) swipeMenuView;
                this.mOldSwipedLayout = swipeMenuLayout2;
                if (i2 == -1) {
                    this.mOldTouchedPosition = headerCount;
                    swipeMenuLayout2.smoothOpenRightMenu(i3);
                } else if (i2 == 1) {
                    this.mOldTouchedPosition = headerCount;
                    swipeMenuLayout2.smoothOpenLeftMenu(i3);
                }
            }
        }
    }

    public void smoothCloseMenu() {
        SwipeMenuLayout swipeMenuLayout = this.mOldSwipedLayout;
        if (swipeMenuLayout == null || !swipeMenuLayout.isMenuOpen()) {
            return;
        }
        this.mOldSwipedLayout.smoothCloseMenu();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        boolean z;
        SwipeMenuLayout swipeMenuLayout2;
        ViewParent parent;
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.allowSwipeDelete || this.mSwipeMenuCreator == null) {
            return zOnInterceptTouchEvent;
        }
        boolean z2 = true;
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int childAdapterPosition = getChildAdapterPosition(findChildViewUnder(x, y));
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(childAdapterPosition);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View swipeMenuView = getSwipeMenuView(viewHolderFindViewHolderForAdapterPosition.itemView);
            if (swipeMenuView instanceof SwipeMenuLayout) {
                swipeMenuLayout = (SwipeMenuLayout) swipeMenuView;
            } else {
                swipeMenuLayout = null;
            }
        } else {
            swipeMenuLayout = null;
        }
        boolean z3 = this.mSwipeItemMenuEnable && !this.mDisableSwipeItemMenuList.contains(Integer.valueOf(childAdapterPosition));
        if (swipeMenuLayout != null) {
            swipeMenuLayout.setSwipeEnable(z3);
        }
        if (!z3) {
            return zOnInterceptTouchEvent;
        }
        if (action == 0) {
            this.mDownX = x;
            this.mDownY = y;
            if (childAdapterPosition == this.mOldTouchedPosition || (swipeMenuLayout2 = this.mOldSwipedLayout) == null || !swipeMenuLayout2.isMenuOpen()) {
                z = false;
            } else {
                this.mOldSwipedLayout.smoothCloseMenu();
                z = true;
            }
            if (z) {
                this.mOldSwipedLayout = null;
                this.mOldTouchedPosition = -1;
                return z;
            }
            if (swipeMenuLayout == null) {
                return z;
            }
            this.mOldSwipedLayout = swipeMenuLayout;
            this.mOldTouchedPosition = childAdapterPosition;
            return z;
        }
        if (action != 1) {
            if (action == 2) {
                zOnInterceptTouchEvent = handleUnDown(x, y, zOnInterceptTouchEvent);
                if (this.mOldSwipedLayout == null || (parent = getParent()) == null) {
                    return zOnInterceptTouchEvent;
                }
                int i = this.mDownX - x;
                boolean z4 = i > 0 && (this.mOldSwipedLayout.hasRightMenu() || this.mOldSwipedLayout.isLeftCompleteOpen());
                boolean z5 = i < 0 && (this.mOldSwipedLayout.hasLeftMenu() || this.mOldSwipedLayout.isRightCompleteOpen());
                if (!z4 && !z5) {
                    z2 = false;
                }
                parent.requestDisallowInterceptTouchEvent(z2);
            } else if (action != 3) {
                return zOnInterceptTouchEvent;
            }
        }
        return handleUnDown(x, y, zOnInterceptTouchEvent);
    }

    private boolean handleUnDown(int i, int i2, boolean z) {
        int i3 = this.mDownX - i;
        int i4 = this.mDownY - i2;
        if (Math.abs(i3) > this.mScaleTouchSlop && Math.abs(i3) > Math.abs(i4)) {
            return false;
        }
        if (Math.abs(i4) >= this.mScaleTouchSlop || Math.abs(i3) >= this.mScaleTouchSlop) {
            return z;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        if (motionEvent.getAction() == 2 && (swipeMenuLayout = this.mOldSwipedLayout) != null && swipeMenuLayout.isMenuOpen()) {
            this.mOldSwipedLayout.smoothCloseMenu();
        }
        return super.onTouchEvent(motionEvent);
    }

    private View getSwipeMenuView(View view) {
        if (view instanceof SwipeMenuLayout) {
            return view;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ViewGroup) {
                if (view2 instanceof SwipeMenuLayout) {
                    return view2;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
        }
        return view;
    }

    public void onScrollStateChanged(int i) {
        this.mScrollState = i;
    }

    public void onScrolled(int i, int i2) {
        LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = layoutManager;
            int itemCount = layoutManager.getItemCount();
            if (itemCount > 0 && itemCount == linearLayoutManager.findLastVisibleItemPosition() + 1) {
                int i3 = this.mScrollState;
                if (i3 == 1 || i3 == 2) {
                    dispatchLoadMore();
                    return;
                }
                return;
            }
            return;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int itemCount2 = layoutManager.getItemCount();
            if (itemCount2 <= 0) {
                return;
            }
            int[] iArrFindLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions((int[]) null);
            if (itemCount2 == iArrFindLastCompletelyVisibleItemPositions[iArrFindLastCompletelyVisibleItemPositions.length - 1] + 1) {
                int i4 = this.mScrollState;
                if (i4 == 1 || i4 == 2) {
                    dispatchLoadMore();
                }
            }
        }
    }

    private void dispatchLoadMore() {
        if (this.isLoadError) {
            return;
        }
        if (!this.isAutoLoadMore) {
            LoadMoreView loadMoreView = this.mLoadMoreView;
            if (loadMoreView != null) {
                loadMoreView.onWaitToLoadMore(this.mLoadMoreListener);
                return;
            }
            return;
        }
        if (this.isLoadMore || this.mDataEmpty || !this.mHasMore) {
            return;
        }
        this.isLoadMore = true;
        LoadMoreView loadMoreView2 = this.mLoadMoreView;
        if (loadMoreView2 != null) {
            loadMoreView2.onLoading();
        }
        LoadMoreListener loadMoreListener = this.mLoadMoreListener;
        if (loadMoreListener != null) {
            loadMoreListener.onLoadMore();
        }
    }

    public void useDefaultLoadMore() {
        DefaultLoadMoreView defaultLoadMoreView = new DefaultLoadMoreView(getContext());
        addFooterView(defaultLoadMoreView);
        setLoadMoreView(defaultLoadMoreView);
    }

    public void setLoadMoreView(LoadMoreView loadMoreView) {
        this.mLoadMoreView = loadMoreView;
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
    }

    public void setAutoLoadMore(boolean z) {
        this.isAutoLoadMore = z;
    }

    public final void loadMoreFinish(boolean z, boolean z2) {
        this.isLoadMore = false;
        this.isLoadError = false;
        this.mDataEmpty = z;
        this.mHasMore = z2;
        LoadMoreView loadMoreView = this.mLoadMoreView;
        if (loadMoreView != null) {
            loadMoreView.onLoadFinish(z, z2);
        }
    }

    public void loadMoreError(int i, String str) {
        this.isLoadMore = false;
        this.isLoadError = true;
        LoadMoreView loadMoreView = this.mLoadMoreView;
        if (loadMoreView != null) {
            loadMoreView.onLoadError(i, str);
        }
    }
}
