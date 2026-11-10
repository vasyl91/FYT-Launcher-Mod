package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.data.FinalInfo;
import com.lsec.core.frame.page.IPageNotify;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JListApp extends ViewGroup implements AdapterView.OnItemClickListener, View.OnKeyListener {
    private static final int APPS_PAGE_SIZE = 10;
    private static final int SNAP_VELOCITY = 600;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private int PageNum;
    boolean bAttached;
    boolean bWillUpdateBackground;
    private int idPageRow;
    private JIndicator indicator;
    public ArrayList<ResolveInfo> mAllAppsList;
    public AppsAdapter[] mAppsAdapter;
    private int mCurScreen;
    public HashMap<String, Drawable> mDrawables;
    private float mLastMotionX;
    private Scroller mScroller;
    String mStrDrawable;
    private int mTouchSlop;
    private int mTouchState;
    private VelocityTracker mVelocityTracker;
    public JPage page;
    public View viewAppSelect;

    public JListApp(JPage page) {
        super(page.ui.mContext);
        this.mAllAppsList = new ArrayList<>();
        this.mTouchState = 0;
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.page = page;
        initViews();
    }

    public void setPageRow(int idPageRow) {
        this.idPageRow = idPageRow;
    }

    public JPage getPage() {
        return this.page;
    }

    public void initViews() {
        this.mCurScreen = 0;
        this.mScroller = new Scroller(this.page.ui.mContext);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != 8) {
                int childWidth = childView.getMeasuredWidth();
                childView.layout(childLeft, 0, childLeft + childWidth, childView.getMeasuredHeight());
                childLeft += childWidth;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != 1073741824) {
            throw new IllegalStateException("AllApps only canmCurScreen run at EXACTLY mode!");
        }
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
        }
        scrollTo(this.mCurScreen * width, 0);
    }

    public void snapToDestination() {
        int screenWidth = getWidth();
        int destScreen = (getScrollX() + (screenWidth / 2)) / screenWidth;
        snapToScreen(destScreen);
    }

    public void snapToScreen(int whichScreen) {
        int childs = getChildCount();
        int whichScreen2 = Math.max(0, Math.min(whichScreen, childs - 1));
        if (getScrollX() != getWidth() * whichScreen2) {
            int delta = (getWidth() * whichScreen2) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, delta, 0, Math.abs(delta) * 2);
            this.mCurScreen = whichScreen2;
            this.indicator.setCurrent(this.mCurScreen);
            invalidate();
        }
    }

    public void setToScreen(int whichScreen) {
        int whichScreen2 = Math.max(0, Math.min(whichScreen, getChildCount() - 1));
        this.mCurScreen = whichScreen2;
        scrollTo(getWidth() * whichScreen2, 0);
    }

    public int getCurScreen() {
        return this.mCurScreen;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        int action = event.getAction();
        float x = event.getX();
        switch (action) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = x;
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                int velocityX = (int) velocityTracker.getXVelocity();
                if (velocityX > 600 && this.mCurScreen > 0) {
                    snapToScreen(this.mCurScreen - 1);
                } else if (velocityX < -600 && this.mCurScreen < getChildCount() - 1) {
                    snapToScreen(this.mCurScreen + 1);
                } else {
                    snapToDestination();
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.mTouchState = 0;
                break;
            case 2:
                int deltaX = (int) (this.mLastMotionX - x);
                this.mLastMotionX = x;
                scrollBy(deltaX, 0);
                break;
            case 3:
                this.mTouchState = 0;
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 2 && this.mTouchState != 0) {
            return true;
        }
        float x = ev.getX();
        switch (action) {
            case 0:
                this.mLastMotionX = x;
                this.mTouchState = this.mScroller.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.mTouchState = 0;
                break;
            case 2:
                int xDiff = (int) Math.abs(this.mLastMotionX - x);
                if (xDiff > this.mTouchSlop) {
                    this.mTouchState = 1;
                }
                break;
        }
        return this.mTouchState != 0;
    }

    public class AppsAdapter extends ArrayAdapter<ResolveInfo> {
        public ArrayList<ResolveInfo> apps;
        public ArrayList<WeakReference<JPage>> mPageInfos;
        private JListApp mRelatedListApp;
        public int start;

        public AppsAdapter(Context context, ArrayList<ResolveInfo> apps, JListApp listApp, int start) {
            super(context, 0, apps);
            this.mPageInfos = new ArrayList<>();
            this.apps = null;
            this.start = 0;
            this.apps = apps;
            this.start = start;
            setRelatedListApp(listApp);
        }

        public void setRelatedListApp(JListApp listApp) {
            this.mRelatedListApp = listApp;
        }

        public JListApp getRelatedListApp() {
            return this.mRelatedListApp;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            JPage pageTmp;
            ResolveInfo info = getItem(position);
            if (convertView == null) {
                pageTmp = JListApp.this.page.ui.loadPage(false, JListApp.this.idPageRow);
                MyUiItem item = (MyUiItem) pageTmp.getTag();
                pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.getWidth(), item.getHeight()));
                pageTmp.setStrDrawable(item.getStrDrawable(), true);
            } else {
                pageTmp = (JPage) convertView;
            }
            boolean bContainsInPageInfos = false;
            ArrayList<WeakReference<JPage>> pageInfos = new ArrayList<>();
            for (WeakReference<JPage> pageReferenceTmp : this.mPageInfos) {
                if (pageReferenceTmp.get() == pageTmp) {
                    bContainsInPageInfos = true;
                    break;
                }
                if (pageReferenceTmp.get() == null) {
                    pageInfos.add(pageReferenceTmp);
                }
            }
            if (!bContainsInPageInfos) {
                pageTmp.setListApp(this.mRelatedListApp);
                this.mPageInfos.removeAll(pageInfos);
                WeakReference<JPage> pageReference = new WeakReference<>(pageTmp);
                this.mPageInfos.add(pageReference);
            }
            pageTmp.setChildTag(position);
            IPageNotify pageNotify = this.mRelatedListApp.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.InitAppItem(this.mRelatedListApp, pageTmp, info);
            }
            return pageTmp;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                return true;
            default:
                return false;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        if (this.viewAppSelect != null) {
            JPage page = (JPage) this.viewAppSelect;
            ResolveInfo app = (ResolveInfo) parent.getItemAtPosition(page.getChildTag());
            IPageNotify pageNotify = getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.AppClick(this, app);
            }
        }
    }

    public void setApps(ArrayList<ResolveInfo> list) {
        this.mAllAppsList.clear();
        addApps(list);
    }

    public void addApps(ArrayList<ResolveInfo> list) {
        int N = list.size();
        for (int i = 0; i < N; i++) {
            ResolveInfo item = list.get(i);
            this.mAllAppsList.add(item);
        }
        changeAdapter();
        ShowGridView();
    }

    public void ShowGridView() {
        removeAllViews();
        for (int page = 0; page < this.PageNum; page++) {
            addPage(page);
        }
        this.indicator.setTotal(this.PageNum);
        snapToScreen(this.mCurScreen);
    }

    public int getPageNum() {
        return this.PageNum;
    }

    public void addPage(int pageTmp) {
        GridView gridView = new GridView(this.page.ui.mContext);
        IPageNotify pageNotify = getPage().getNotify();
        if (pageNotify != null) {
            pageNotify.InitAppGridView(gridView);
        }
        gridView.setNumColumns(5);
        gridView.setPadding(5, 5, 5, 5);
        gridView.setOnItemClickListener(this);
        gridView.setHorizontalSpacing(5);
        gridView.setVerticalSpacing(5);
        gridView.setGravity(17);
        gridView.setSmoothScrollbarEnabled(true);
        gridView.setAdapter((ListAdapter) this.mAppsAdapter[pageTmp]);
        addView(gridView);
    }

    public void changeAdapter() {
        int apps = this.mAllAppsList.size();
        int Extra = apps % 10;
        if (Extra == 0) {
            this.PageNum = apps / 10;
        } else {
            this.PageNum = (apps / 10) + 1;
        }
        this.mAppsAdapter = null;
        this.mAppsAdapter = new AppsAdapter[this.PageNum];
        for (int pageTmp = 0; pageTmp < this.PageNum; pageTmp++) {
            ArrayList<ResolveInfo> mInfos = new ArrayList<>();
            int start = pageTmp * 10;
            int end = start + 10;
            if (pageTmp == this.PageNum - 1 && Extra != 0) {
                end = start + Extra;
            }
            for (int i = start; i >= start && i < end; i++) {
                mInfos.add(this.mAllAppsList.get(i));
            }
            this.mAppsAdapter[pageTmp] = new AppsAdapter(this.page.ui.mContext, mInfos, this, start);
        }
    }

    public void setIndicator(JIndicator indicator) {
        this.indicator = indicator;
    }

    public void getAllInstalledApps() {
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> apps = getContext().getPackageManager().queryIntentActivities(mainIntent, 0);
        if (apps != null) {
            ArrayList<ResolveInfo> list = new ArrayList<>();
            list.clear();
            for (ResolveInfo res : apps) {
                String str = res.activityInfo.packageName;
                if (str != null && !str.startsWith(FinalInfo.COMPANY_NAME)) {
                    list.add(res);
                }
            }
            setApps(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mAppsAdapter != null) {
            for (AppsAdapter appsAdapter : this.mAppsAdapter) {
                appsAdapter.notifyDataSetChanged();
            }
        }
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
