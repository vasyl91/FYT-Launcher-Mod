package com.lsec.core.frame.page;

import com.lsec.core.frame.app.MyActivity;
import com.lsec.core.frame.ctrl.JPage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_ContentView extends MyPage {
    MyActivity myActivity;

    public Page_ContentView(JPage page, MyActivity myActivity) {
        super(page, null);
        this.myActivity = myActivity;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.myActivity.handleSizeChanged();
    }
}
