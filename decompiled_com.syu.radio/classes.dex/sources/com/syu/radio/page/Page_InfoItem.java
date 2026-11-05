package com.syu.radio.page;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.FuncUtils;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.db.Radio_Info;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_InfoItem extends MyPage {
    Act_Radio actRadio;

    public Page_InfoItem(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.Item_Btn_Edit /* 130354 */:
                Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_EditInfo, "popwindow_delete_btn_anim_style", true);
                if (popDlg != null) {
                    int pos = getPage().getChildTag();
                    SparseArray<String> map = Radio_Info.mListInfo.get(pos);
                    if (map.size() > 0) {
                        float freq = Float.parseFloat(map.get(FinalRadioCtrl.Item_Txt_Freq));
                        App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
                    }
                    JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_EditInfo);
                    Radio_IpcObj.mIsAdd_for_db = false;
                    Radio_IpcObj.updateMap = Radio_Info.mListInfo.get(pos);
                    if (page != null) {
                        page.resume();
                    }
                    popDlg.show();
                }
                break;
            case FinalRadioCtrl.Item_Btn_Del /* 130355 */:
                delInfo(getPage().getChildTag());
                break;
        }
    }

    public void doAfterDel() {
        this.actRadio.initlist(false, false, true);
    }

    public class RunnableDelInfo implements Runnable {
        private int iIndex;

        public RunnableDelInfo(int iIndex) {
            this.iIndex = iIndex;
        }

        @Override // java.lang.Runnable
        public void run() {
            App_Radio.getInstance().mRadioInfoManager.delete(Integer.valueOf(this.iIndex));
            Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_InfoItem.RunnableDelInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    Page_InfoItem.this.doAfterDel();
                }
            });
        }
    }

    private void delInfo(int position) {
        JGridView gridView;
        if (Radio_Info.mListInfo != null) {
            int iIndex = FuncUtils.myParseInt(Radio_Info.mListInfo.get(position).get(FinalRadioCtrl.Item_Index));
            MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new RunnableDelInfo(iIndex), false, 1);
            JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Info);
            if (page != null && (gridView = (JGridView) page.getChildViewByid(FinalRadioCtrl.Info_ListView)) != null) {
                MyApplication.remove(gridView, position);
            }
            Page_Radio_6025.refreshColName();
        }
    }
}
