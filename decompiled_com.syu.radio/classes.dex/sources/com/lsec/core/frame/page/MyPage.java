package com.lsec.core.frame.page;

import android.content.pm.ResolveInfo;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import com.lsec.core.frame.app.MyUi;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JListApp;
import com.lsec.core.frame.ctrl.JListViewEx;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JViewPagerVertical;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyPage implements IPageNotify {
    private JPage page;
    public MyUi uiApp;

    public MyPage(JPage page, MyUi uiApp) {
        this.page = page;
        this.uiApp = uiApp;
    }

    public JPage getPage() {
        return this.page;
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void init() {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void resume() {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void pause() {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void setPressed(JButton jButton, boolean pressed) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void InitAppGridView(GridView mGridView) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void InitAppItem(JListApp listApp, JPage page, ResolveInfo info) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void InitGridItem(JGridView gridView, JPage page, SparseArray<String> map, int position) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void InitGroupItem(JListViewEx listViewEx, JPage page, SparseArray<String> map, boolean isExpanded, int position) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void InitChildItem(JListViewEx listViewEx, JPage page, SparseArray<String> map, int childPosition) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public boolean ResponseLongClick(View v) {
        return false;
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void AppClick(JListApp listApp, ResolveInfo app) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void GridClick(JGridView gridView) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void GridLongClick(JGridView gridView) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void ListExChildClick(JListViewEx listViewEx) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void GridPressed(JGridView gridView, JPage jPage, boolean pressed) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void ItemExPressed(JListViewEx listViewEx, JPage jPage, boolean pressed) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void listAppPressed(JListApp listApp, JPage jPage, boolean pressed) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPagePrev(ViewPager viewPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPageNext(ViewPager viewPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPageScrolled(ViewPager viewPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPagePrev(JViewPagerVertical mPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPageNext(JViewPagerVertical mPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void viewPageScrolled(JViewPagerVertical mPager) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void dispatchTouchEvent(MotionEvent event) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void onDismiss() {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public boolean onKeyCodeBack() {
        return false;
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void LoadGridItemWhenPullDown(JGridView gridView) {
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void LoadGridItemWhenPullUp(JGridView gridView) {
    }

    public String getString(String name) {
        if (this.uiApp != null) {
            return this.uiApp.getString(name);
        }
        return name;
    }

    @Override // com.lsec.core.frame.page.IPageNotify
    public void touchEvent(MotionEvent event) {
    }
}
