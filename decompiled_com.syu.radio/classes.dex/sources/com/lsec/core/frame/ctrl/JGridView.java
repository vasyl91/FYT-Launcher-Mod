package com.lsec.core.frame.ctrl;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.MyFolder;
import com.lsec.core.util.data.FinalChip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JGridView extends GridView {
    public GridAdapter adapter;
    boolean bAttached;
    public boolean bDefaultSet;
    boolean bWillUpdateBackground;
    public JGridView gridView;
    private int idPageRow;
    private List<SparseArray<String>> list;
    private List<MyFolder> listFolder;
    public boolean mActionDown;
    public int mBegin;
    public int mCnt;
    public HashMap<String, Drawable> mDrawables;
    public boolean mInScrollView;
    public int mIndexFocus;
    public int mMaxRow;
    public ArrayList<WeakReference<JPage>> mPageInfos;
    public int mPosition;
    private int mScrollState;
    String mStrDrawable;
    private SwipeGridViewHelper mSwipeHelper;
    public JPage page;
    public String strTail;
    public String[] strs;

    public JGridView(JPage page) {
        super(page.ui.mContext);
        this.strs = null;
        this.list = new ArrayList();
        this.listFolder = new ArrayList();
        this.mPageInfos = new ArrayList<>();
        this.mBegin = 0;
        this.mCnt = 0;
        this.mIndexFocus = 0;
        this.mMaxRow = 1;
        this.mInScrollView = false;
        this.mActionDown = false;
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.strTail = FinalChip.BSP_PLATFORM_Null;
        this.bDefaultSet = true;
        this.page = page;
        this.gridView = this;
        this.adapter = new GridAdapter();
        this.adapter.setGridView(this);
        setAdapter((ListAdapter) this.adapter);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.lsec.core.frame.ctrl.JGridView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                IPageNotify pageNotify;
                if (JGridView.this.mScrollState != 1 && scrollState == 1) {
                    JGridView.this.notifyDataSetChanged();
                }
                JGridView.this.mScrollState = scrollState;
                switch (JGridView.this.mScrollState) {
                    case 0:
                        if (view.getLastVisiblePosition() == view.getCount() - 1) {
                            IPageNotify pageNotify2 = JGridView.this.getPage().getNotify();
                            if (pageNotify2 != null) {
                                pageNotify2.LoadGridItemWhenPullDown(JGridView.this.gridView);
                            }
                            break;
                        } else if (view.getFirstVisiblePosition() == 0 && (pageNotify = JGridView.this.getPage().getNotify()) != null) {
                            pageNotify.LoadGridItemWhenPullUp(JGridView.this.gridView);
                            break;
                        }
                        break;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    public JPage getPage() {
        return this.page;
    }

    public void setMaxRowDisp(int iMaxRow) {
        this.mMaxRow = iMaxRow;
    }

    public int getMaxRowDisp() {
        return this.mMaxRow;
    }

    public void setPageRow(int idPageRow) {
        this.idPageRow = idPageRow;
    }

    public void setPosition(int position) {
        this.mPosition = position;
        this.mIndexFocus = position;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public List<SparseArray<String>> getList() {
        return this.list;
    }

    public List<MyFolder> getListFolder() {
        return this.listFolder;
    }

    public void notifyDataSetChanged() {
        if (this.adapter != null) {
            this.adapter.notifyDataSetChanged();
        }
    }

    public void setStrs(String[] strs, int begin, int end) {
        this.list = null;
        this.strs = strs;
        this.mBegin = begin;
        this.mCnt = end - begin;
        if (this.mCnt < 0) {
            this.mCnt = 0;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.list != null ? this.list.size() : this.mCnt;
    }

    public class GridAdapter extends BaseAdapter {
        private JGridView mGridView;

        public GridAdapter() {
        }

        public void setGridView(JGridView gridView) {
            this.mGridView = gridView;
        }

        public JGridView getGridView() {
            return this.mGridView;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return JGridView.this.list != null ? JGridView.this.list.size() : JGridView.this.mCnt;
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            JPage pageTmp;
            String[] strs;
            JGridView gridView = getGridView();
            if (convertView == null) {
                pageTmp = JGridView.this.page.ui.loadPage(false, JGridView.this.idPageRow);
                MyUiItem item = (MyUiItem) pageTmp.getTag();
                if (item.mLayoutParams != null) {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.mLayoutParams.width, item.mLayoutParams.height));
                } else {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.getWidth(), item.getHeight()));
                }
            } else {
                pageTmp = (JPage) convertView;
            }
            if (JGridView.this.mSwipeHelper != null && pageTmp != null) {
                pageTmp.setScrollX(0);
            }
            boolean bContainsInPageInfos = false;
            ArrayList<WeakReference<JPage>> pageInfos = new ArrayList<>();
            for (WeakReference<JPage> pageReferenceTmp : JGridView.this.mPageInfos) {
                if (pageReferenceTmp.get() == pageTmp) {
                    bContainsInPageInfos = true;
                    break;
                }
                if (pageReferenceTmp.get() == null) {
                    pageInfos.add(pageReferenceTmp);
                }
            }
            if (!bContainsInPageInfos) {
                pageTmp.setGridView(gridView);
                JGridView.this.mPageInfos.removeAll(pageInfos);
                WeakReference<JPage> pageReference = new WeakReference<>(pageTmp);
                JGridView.this.mPageInfos.add(pageReference);
            }
            MyUiItem item2 = (MyUiItem) pageTmp.getTag();
            String str = null;
            if ((position & 1) != 0 && (strs = item2.getStrDrawableExtra()) != null) {
                str = strs[0];
            }
            if (str == null) {
                str = item2.getStrDrawable();
            }
            pageTmp.setChildTag(position);
            if (pageTmp.getStrDrawable() != str && str != null) {
                pageTmp.setStrDrawable(str, true);
            }
            if (JGridView.this.list != null) {
                SparseArray<String> map = (SparseArray) JGridView.this.list.get(position);
                IPageNotify pageNotify = gridView.getPage().getNotify();
                if (pageNotify != null) {
                    pageNotify.InitGridItem(getGridView(), pageTmp, map, position);
                }
                if (JGridView.this.bDefaultSet) {
                    int nsize = map.size();
                    for (int i = 0; i < nsize; i++) {
                        int key = map.keyAt(i);
                        JText tv = (JText) pageTmp.getChildViewByid(key);
                        if (tv != null && tv.getVisibility() == 0) {
                            boolean bAddPosition2Str = false;
                            String strMid = ". ";
                            String strTmp = JGridView.this.strTail;
                            MyUiItem itemTv = (MyUiItem) tv.getTag();
                            if (itemTv.getPara() != null) {
                                if (itemTv.getPara()[0] == 1) {
                                    bAddPosition2Str = true;
                                } else if (itemTv.getPara()[0] == 2) {
                                    bAddPosition2Str = true;
                                    strMid = FinalChip.BSP_PLATFORM_Null;
                                    strTmp = FinalChip.BSP_PLATFORM_Null;
                                }
                            }
                            if (bAddPosition2Str) {
                                tv.setText(String.valueOf(String.valueOf(JGridView.this.mBegin + position + 1)) + strMid + map.get(key) + strTmp);
                            } else {
                                tv.setText(String.valueOf(map.get(key)) + strTmp);
                            }
                        }
                    }
                }
            } else {
                IPageNotify pageNotify2 = gridView.getPage().getNotify();
                if (pageNotify2 != null) {
                    pageNotify2.InitGridItem(getGridView(), pageTmp, null, position);
                }
            }
            return pageTmp;
        }
    }

    public void scrollToPosition(int position) {
        if (!this.mActionDown && position >= 0) {
            setAdapter((ListAdapter) this.adapter);
            this.adapter.notifyDataSetChanged();
            setSelection(position);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mInScrollView) {
            int expandSpec = View.MeasureSpec.makeMeasureSpec(536870911, ExploreByTouchHelper.INVALID_ID);
            super.onMeasure(widthMeasureSpec, expandSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void superTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
    }

    public void initSwipePara(int rightViewWidth) {
        if (rightViewWidth > 0) {
            this.mSwipeHelper = new SwipeGridViewHelper(this, rightViewWidth);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mSwipeHelper == null || !this.mSwipeHelper.onInterceptTouchEvent(ev)) {
            return super.onInterceptTouchEvent(ev);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.mActionDown = true;
                break;
            case 1:
            case 3:
                this.mActionDown = false;
                break;
        }
        if (this.mSwipeHelper == null || !this.mSwipeHelper.onTouchEvent(ev)) {
            return super.onTouchEvent(ev);
        }
        return true;
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.page != null && this.mStrDrawable != null) {
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawable, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
