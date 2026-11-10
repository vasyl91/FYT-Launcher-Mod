package com.syu.radio.page;

import android.util.Log;
import android.view.View;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.page.MyPage;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_MsgBox extends MyPage {
    Act_Radio actRadio;

    public Page_MsgBox(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
        Log.d("mb", " MB Page_MsgBox MsgBox_Sel = " + Page_Radio_6025.MsgBox_Sel);
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() {
        Log.d("mb", " MB  00 resume Page_Radio_6025.MsgBox_Sel = " + Page_Radio_6025.MsgBox_Sel);
        JText title = (JText) getPage().getChildViewByid(FinalRadioCtrl.MsgBox_Txt_Title);
        Log.d("mb", " MB 11 resume Page_Radio_6025.MsgBox_Sel = " + Page_Radio_6025.MsgBox_Sel);
        if (Page_Radio_6025.MsgBox_Sel == 255) {
            title.setText(getString("radio_del_All"));
        } else {
            title.setText(getString("radio_msg_1"));
        }
    }

    public void doAfterDel() {
        this.actRadio.initlist(false, false, true);
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.MsgBox_Btn_Ok /* 130130 */:
                if (Page_Radio_6025.MsgBox_Sel == 255) {
                    Page_Radio_6025.getColList().clear();
                    Page_Radio_6025.SaveColList(Page_Radio_6025.getColList());
                    Page_Radio_6025.refreshCol();
                }
                Log.d("gdy2", " MB  MsgBox_Btn_Ok = " + Page_Radio_6025.MsgBox_Sel);
                getPage().getDialog().dismiss();
                break;
            case FinalRadioCtrl.MsgBox_Btn_Cancel /* 130131 */:
                Log.d("mb", " MB  MsgBox_Btn_Cancel = " + Page_Radio_6025.MsgBox_Sel);
                getPage().getDialog().dismiss();
                break;
        }
    }
}
