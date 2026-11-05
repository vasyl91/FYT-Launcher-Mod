package com.lsec.core.frame.app;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.frame.page.Page_ContentView;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.data.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class MyActivity extends Activity {
    public boolean bTop = false;
    public AnimatorSet mAnimSet;
    public JPage mPage;
    public JPage mPageCurrent;
    public ViewGroup mPageMain;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        if (MyApplication.mActs != null) {
            MyApplication.mActs.add(this);
        }
        this.mPage = new JPage(this, null);
        this.mPage.setNotify(new Page_ContentView(this.mPage, this));
        setContentView(this.mPage);
        this.mPageMain = new FrameLayout(this);
        this.mPage.addView(this.mPageMain);
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.bTop) {
            this.bTop = false;
            doActionPause();
        }
        if (MyApplication.mActs != null) {
            MyApplication.mActs.remove(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (TextUtils.isEmpty(MyUi.mStrHeadXml)) {
            this.bTop = false;
            doActionPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.bTop = true;
        doActionResume();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
        super.onNewIntent(intent);
    }

    public void handleIntent(Intent intent) {
    }

    public void doActionResume() {
    }

    public void doActionPause() {
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.bTop) {
            this.bTop = false;
            doActionPause();
        }
        super.onStop();
    }

    public void handleSizeChanged() {
        View viewDecor = getWindow().getDecorView();
        if (viewDecor != null) {
            Rect rect = new Rect();
            viewDecor.getWindowVisibleDisplayFrame(rect);
            if (rect.width() > 0 && rect.height() > 0) {
                int areaRect = rect.width() * rect.height();
                FuncUtils.getDisplayMetrics(this);
                int areaScreen = FuncUtils.mDispayMetrics.widthPixels * FuncUtils.mDispayMetrics.heightPixels;
                if (areaRect * 2 <= areaScreen) {
                    if (FuncUtils.mDispayMetrics.widthPixels < FuncUtils.mDispayMetrics.heightPixels) {
                        MyUi.mStrHeadXml = "half_ver_";
                    } else {
                        MyUi.mStrHeadXml = "half_hor_";
                    }
                } else {
                    MyUi.mStrHeadXml = FinalChip.BSP_PLATFORM_Null;
                }
                if (!TextUtils.isEmpty(MyUi.mStrHeadXml)) {
                    this.bTop = true;
                    doActionResume();
                }
                if (this.mPageCurrent != null && this.mPageCurrent.isNeedReload()) {
                    goPage(this.mPageCurrent.getId());
                }
            }
        }
    }

    public boolean isTop() {
        return this.bTop;
    }

    public void goPage(int idPageTo) {
    }

    public IPageNotify getPageNotify(MyUi ui, int idPage) {
        JPage page;
        if (ui == null || (page = ui.mPages.get(idPage)) == null) {
            return null;
        }
        IPageNotify pageNotify = page.getNotify();
        return pageNotify;
    }

    public void requestAppIdRight() {
    }

    public void showSystemUi() {
        getWindow().getDecorView().setSystemUiVisibility(0);
        getWindow().getDecorView().requestFitSystemWindows();
    }

    public void hideSystemUi() {
        getWindow().getDecorView().setSystemUiVisibility(4102);
        getWindow().getDecorView().requestFitSystemWindows();
    }

    public boolean isSystemUiVisible() {
        return getWindow().getDecorView().getSystemUiVisibility() == 0;
    }

    public void setTransParentWindow(boolean bTrans) {
        if (FuncUtils.mDispayMetrics.widthPixels > FuncUtils.mDispayMetrics.heightPixels && this.bTop) {
            if (bTrans) {
                hideSystemUi();
                getWindow().addFlags(134217728);
                getWindow().addFlags(67108864);
                if (MyApplication.mIdPlatForm == 9) {
                    getWindow().addFlags(1024);
                    return;
                }
                return;
            }
            getWindow().clearFlags(134217728);
            getWindow().clearFlags(67108864);
            if (MyApplication.mIdPlatForm == 9) {
                getWindow().clearFlags(1024);
            }
            showSystemUi();
        }
    }
}
