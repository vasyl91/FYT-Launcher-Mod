package com.syu.radio.page;

import android.view.View;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.netchannel.NetChannel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_DelInfo extends MyPage {
    Act_Radio actRadio;

    public Page_DelInfo(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    public void doAfterDel() {
        this.actRadio.initlist(false, false, true);
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) throws Throwable {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.DelInfo_Btn_Ok /* 130329 */:
                MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new Runnable() { // from class: com.syu.radio.page.Page_DelInfo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        App_Radio.getInstance().mRadioInfoManager.delete();
                        Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_DelInfo.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Page_DelInfo.this.doAfterDel();
                            }
                        });
                    }
                }, false, 1);
                JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Info);
                if (page != null) {
                    JGridView gridView = (JGridView) page.getChildViewByid(FinalRadioCtrl.Info_ListView);
                    MyApplication.clear(gridView);
                }
                App_Radio.getInstance().mySharePreference2.saveIntValue(NetChannel.CURRENT_VERSION, 0);
                getPage().getDialog().dismiss();
                break;
            case FinalRadioCtrl.DelInfo_Btn_Cancel /* 130330 */:
                getPage().getDialog().dismiss();
                break;
        }
    }
}
