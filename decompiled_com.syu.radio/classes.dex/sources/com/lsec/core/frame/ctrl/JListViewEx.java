package com.lsec.core.frame.ctrl;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.MyFolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JListViewEx extends ExpandableListView {
    public ExtAdapter adapter;
    boolean bAttached;
    boolean bWillUpdateBackground;
    public int idPageRowChild;
    public int idPageRowGroup;
    private List<MyFolder> listFolder;
    public JListViewEx listViewEx;
    public boolean mActionDown;
    public HashMap<String, Drawable> mDrawables;
    public ArrayList<WeakReference<JPage>> mPageInfos;
    public int mPositionChild;
    public int mPositionGroup;
    private int mScrollState;
    String mStrDrawable;
    private SwipeListViewHelper mSwipeHelper;
    private JPage page;

    public JListViewEx(JPage page) {
        super(page.ui.mContext);
        this.listFolder = new ArrayList();
        this.mPageInfos = new ArrayList<>();
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mActionDown = false;
        this.page = page;
        this.listViewEx = this;
        this.adapter = new ExtAdapter();
        this.adapter.setListViewEx(this);
        setAdapter(this.adapter);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.lsec.core.frame.ctrl.JListViewEx.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (JListViewEx.this.mScrollState != 1 && scrollState == 1) {
                    JListViewEx.this.notifyDataSetChanged();
                }
                JListViewEx.this.mScrollState = scrollState;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    public JPage getPage() {
        return this.page;
    }

    public void setPageRow(int idPageRowGroup, int idPageRowChild) {
        this.idPageRowGroup = idPageRowGroup;
        this.idPageRowChild = idPageRowChild;
    }

    public void setPositionGroup(int position) {
        this.mPositionGroup = position;
    }

    public int getPositionGroup() {
        return this.mPositionGroup;
    }

    public void setPositionChild(int position) {
        this.mPositionChild = position;
    }

    public int getPositionChild() {
        return this.mPositionChild;
    }

    public int getGroupCount() {
        return this.listFolder.size();
    }

    public int getChildrenCount(int groupPosition) {
        MyFolder folder;
        if (this.listFolder.size() <= groupPosition || (folder = this.listFolder.get(groupPosition)) == null) {
            return 0;
        }
        return folder.array.size();
    }

    public void notifyDataSetChanged() {
        if (this.adapter != null) {
            this.adapter.notifyDataSetChanged();
        }
    }

    public class ExtAdapter extends BaseExpandableListAdapter {
        private JListViewEx mListViewEx;

        public ExtAdapter() {
        }

        public void setListViewEx(JListViewEx listViewEx) {
            this.mListViewEx = listViewEx;
        }

        public JListViewEx getListViewEx() {
            return this.mListViewEx;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return JListViewEx.this.listFolder.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int groupPosition) {
            MyFolder folder = (MyFolder) JListViewEx.this.listFolder.get(groupPosition);
            if (folder != null) {
                return folder.array.size();
            }
            return 0;
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int groupPosition) {
            return JListViewEx.this.listFolder.get(groupPosition);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int groupPosition, int childPosition) {
            return ((MyFolder) JListViewEx.this.listFolder.get(groupPosition)).array.get(childPosition);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int position, boolean isExpanded, View convertView, ViewGroup parent) {
            JPage pageTmp;
            String[] strs;
            SparseArray<String> map = ((MyFolder) JListViewEx.this.listFolder.get(position)).map;
            JListViewEx listViewEx = getListViewEx();
            if (convertView == null) {
                pageTmp = JListViewEx.this.page.ui.loadPage(false, JListViewEx.this.idPageRowGroup);
                MyUiItem item = (MyUiItem) pageTmp.getTag();
                if (item.mLayoutParams != null) {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.mLayoutParams.width, item.mLayoutParams.height));
                } else {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.getWidth(), item.getHeight()));
                }
            } else {
                pageTmp = (JPage) convertView;
            }
            WeakReference<JPage> pageReference = null;
            for (WeakReference<JPage> pageReferenceTmp : JListViewEx.this.mPageInfos) {
                if (pageReferenceTmp.get() == pageTmp) {
                    pageReference = pageReferenceTmp;
                    break;
                }
            }
            if (pageReference != null) {
                pageTmp.setListViewEx(null);
                JListViewEx.this.mPageInfos.remove(pageReference);
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
            IPageNotify pageNotify = listViewEx.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.InitGroupItem(getListViewEx(), pageTmp, map, isExpanded, position);
            }
            int nsize = map.size();
            for (int i = 0; i < nsize; i++) {
                int key = map.keyAt(i);
                JText tv = (JText) pageTmp.getChildViewByid(key);
                if (tv != null && tv.getVisibility() == 0) {
                    boolean bAddPosition2Str = false;
                    MyUiItem itemTv = (MyUiItem) tv.getTag();
                    if (itemTv.getPara() != null && itemTv.getPara()[0] == 1) {
                        bAddPosition2Str = true;
                    }
                    if (bAddPosition2Str) {
                        tv.setText(String.valueOf(String.valueOf(position + 1)) + ".  " + map.get(key));
                    } else {
                        tv.setText(map.get(key));
                    }
                }
            }
            return pageTmp;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            JPage pageTmp;
            String[] strs;
            SparseArray<String> map = ((MyFolder) JListViewEx.this.listFolder.get(groupPosition)).array.get(childPosition);
            JListViewEx listViewEx = getListViewEx();
            if (convertView == null) {
                pageTmp = JListViewEx.this.page.ui.loadPage(false, JListViewEx.this.idPageRowChild);
                MyUiItem item = (MyUiItem) pageTmp.getTag();
                if (item.mLayoutParams != null) {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.mLayoutParams.width, item.mLayoutParams.height));
                } else {
                    pageTmp.setLayoutParams(new AbsListView.LayoutParams(item.getWidth(), item.getHeight()));
                }
            } else {
                pageTmp = (JPage) convertView;
            }
            if (JListViewEx.this.mSwipeHelper != null && pageTmp != null) {
                pageTmp.setScrollX(0);
            }
            boolean bContainsInPageInfos = false;
            ArrayList<WeakReference<JPage>> pageInfos = new ArrayList<>();
            for (WeakReference<JPage> pageReferenceTmp : JListViewEx.this.mPageInfos) {
                if (pageReferenceTmp.get() == pageTmp) {
                    bContainsInPageInfos = true;
                    break;
                }
                if (pageReferenceTmp.get() == null) {
                    pageInfos.add(pageReferenceTmp);
                }
            }
            if (!bContainsInPageInfos) {
                pageTmp.setListViewEx(listViewEx);
                JListViewEx.this.mPageInfos.removeAll(pageInfos);
                WeakReference<JPage> pageReference = new WeakReference<>(pageTmp);
                JListViewEx.this.mPageInfos.add(pageReference);
            }
            MyUiItem item2 = (MyUiItem) pageTmp.getTag();
            String str = null;
            if ((childPosition & 1) != 0 && (strs = item2.getStrDrawableExtra()) != null) {
                str = strs[0];
            }
            if (str == null) {
                str = item2.getStrDrawable();
            }
            pageTmp.setGroupTag(groupPosition);
            pageTmp.setChildTag(childPosition);
            if (pageTmp.getStrDrawable() != str && str != null) {
                pageTmp.setStrDrawable(str, true);
            }
            IPageNotify pageNotify = listViewEx.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.InitChildItem(getListViewEx(), pageTmp, map, childPosition);
            }
            int nsize = map.size();
            for (int i = 0; i < nsize; i++) {
                int key = map.keyAt(i);
                JText tv = (JText) pageTmp.getChildViewByid(key);
                if (tv != null && tv.getVisibility() == 0) {
                    boolean bAddPosition2Str = false;
                    MyUiItem itemTv = (MyUiItem) tv.getTag();
                    if (itemTv.getPara() != null && itemTv.getPara()[0] == 1) {
                        bAddPosition2Str = true;
                    }
                    if (bAddPosition2Str) {
                        tv.setText(String.valueOf(String.valueOf(childPosition + 1)) + ".  " + map.get(key));
                    } else {
                        tv.setText(map.get(key));
                    }
                }
            }
            return pageTmp;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    public List<MyFolder> getList() {
        return this.listFolder;
    }

    public void scrollToPosition(int posGroup, int posChild) {
        if (!this.mActionDown && this.listFolder.size() > posGroup) {
            for (int i = 0; i < getGroupCount(); i++) {
                if (posGroup != i && isGroupExpanded(i)) {
                    collapseGroup(i);
                }
            }
            MyFolder folder = this.listFolder.get(posGroup);
            if (folder != null && folder.array.size() > posChild) {
                if (!isGroupExpanded(posGroup)) {
                    expandGroup(posGroup);
                }
                setSelectionFromTop(posGroup + 1 + posChild, 0);
                smoothScrollToPositionFromTop(posGroup + 1 + posChild, 0);
            }
        }
    }

    public void scrollToPosition(int posGroup) {
        if (!this.mActionDown && this.listFolder.size() > posGroup) {
            for (int i = 0; i < getGroupCount(); i++) {
                if (isGroupExpanded(i)) {
                    collapseGroup(i);
                }
            }
            setSelectionFromTop(posGroup, 0);
            smoothScrollToPositionFromTop(posGroup, 0);
        }
    }

    public void superTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
    }

    public void initSwipePara(int rightViewWidth) {
        if (rightViewWidth > 0) {
            this.mSwipeHelper = new SwipeListViewHelper(this, rightViewWidth);
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
