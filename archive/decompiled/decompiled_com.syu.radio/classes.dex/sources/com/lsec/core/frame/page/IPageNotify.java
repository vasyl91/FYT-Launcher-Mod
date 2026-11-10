package com.lsec.core.frame.page;

import android.content.pm.ResolveInfo;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JListApp;
import com.lsec.core.frame.ctrl.JListViewEx;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JViewPagerVertical;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IPageNotify {
    void AppClick(JListApp jListApp, ResolveInfo resolveInfo);

    void GridClick(JGridView jGridView);

    void GridLongClick(JGridView jGridView);

    void GridPressed(JGridView jGridView, JPage jPage, boolean z);

    void InitAppGridView(GridView gridView);

    void InitAppItem(JListApp jListApp, JPage jPage, ResolveInfo resolveInfo);

    void InitChildItem(JListViewEx jListViewEx, JPage jPage, SparseArray<String> sparseArray, int i);

    void InitGridItem(JGridView jGridView, JPage jPage, SparseArray<String> sparseArray, int i);

    void InitGroupItem(JListViewEx jListViewEx, JPage jPage, SparseArray<String> sparseArray, boolean z, int i);

    void ItemExPressed(JListViewEx jListViewEx, JPage jPage, boolean z);

    void ListExChildClick(JListViewEx jListViewEx);

    void LoadGridItemWhenPullDown(JGridView jGridView);

    void LoadGridItemWhenPullUp(JGridView jGridView);

    void ResponseClick(View view);

    boolean ResponseLongClick(View view);

    void dispatchTouchEvent(MotionEvent motionEvent);

    void init();

    void listAppPressed(JListApp jListApp, JPage jPage, boolean z);

    void onDismiss();

    boolean onKeyCodeBack();

    void onSizeChanged(int i, int i2, int i3, int i4);

    void pause();

    void resume();

    void setPressed(JButton jButton, boolean z);

    void touchEvent(MotionEvent motionEvent);

    void viewPageNext(ViewPager viewPager);

    void viewPageNext(JViewPagerVertical jViewPagerVertical);

    void viewPagePrev(ViewPager viewPager);

    void viewPagePrev(JViewPagerVertical jViewPagerVertical);

    void viewPageScrolled(ViewPager viewPager);

    void viewPageScrolled(JViewPagerVertical jViewPagerVertical);
}
