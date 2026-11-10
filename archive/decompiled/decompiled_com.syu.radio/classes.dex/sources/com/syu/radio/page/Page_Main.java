package com.syu.radio.page;

import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.MyPage;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Main extends MyPage {
    Act_Radio actRadio;

    public Page_Main(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (App_Radio.getInstance().bEnableHalfScreen && App_Radio.iPageCur >= 0) {
            this.actRadio.goPage(App_Radio.iPageCur);
        }
    }
}
