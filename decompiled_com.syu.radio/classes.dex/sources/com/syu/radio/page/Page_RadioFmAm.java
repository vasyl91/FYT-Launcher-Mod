package com.syu.radio.page;

import android.view.View;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.MyPage;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_RadioFmAm extends MyPage {
    Act_Radio actRadio;

    public Page_RadioFmAm(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        if (this.actRadio.mInterfacePageRadio != null) {
            this.actRadio.mInterfacePageRadio.ResponseClick(id);
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public boolean ResponseLongClick(View v) {
        int id = v.getId();
        if (this.actRadio.mInterfacePageRadio != null) {
            this.actRadio.mInterfacePageRadio.ResponseLongClick(id);
            return false;
        }
        return false;
    }
}
