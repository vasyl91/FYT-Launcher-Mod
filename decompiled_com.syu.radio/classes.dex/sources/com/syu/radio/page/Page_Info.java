package com.syu.radio.page;

import android.app.Dialog;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.util.data.FinalChip;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.db.Radio_Info;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Info extends MyPage {
    public static JButton cityName = null;
    Act_Radio actRadio;

    public Page_Info(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() {
        Log.d("edit", " 00  Page_Info resume ");
        resetList(Radio_Info.mListInfo);
        Log.d("edit", " 01  Page_Info resume  ");
        if (cityName == null) {
            cityName = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Info_Txt_City);
        }
        if (cityName != null && App_Radio.mCity != null) {
            if (App_Radio.mCity.length() > 0) {
                cityName.setText(App_Radio.mCity);
            } else {
                cityName.setText(getString("radio_info_city"));
            }
        }
        if (App_Radio.bUI_NightColour) {
            setDayOrNight(App_Radio.mNightDay);
        }
    }

    public void resetList(List<SparseArray<String>> list) {
        JGridView gridView = (JGridView) getPage().getChildViewByid(FinalRadioCtrl.Info_ListView);
        try {
            MyApplication.resetList(gridView, list);
        } catch (Exception e) {
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.Info_Btn_Del /* 130317 */:
                Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_DelInfo, "popwindow_delete_btn_anim_style", true);
                if (popDlg != null) {
                    popDlg.show();
                }
                break;
            case FinalRadioCtrl.Info_Txt_City /* 130318 */:
                Dialog popDlg2 = this.actRadio.ui.getPopDlg(FinalRadioCtrl.Page_CityInfo, "popwindow_delete_btn_anim_style", true);
                if (popDlg2 != null) {
                    popDlg2.show();
                }
                break;
            case FinalRadioCtrl.Info_Btn_Add /* 130319 */:
                Dialog popDlg3 = getPage().ui.getPopDlg(FinalRadioCtrl.Page_EditInfo, "popwindow_delete_btn_anim_style", true);
                if (popDlg3 != null) {
                    JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_EditInfo);
                    Radio_IpcObj.mIsAdd_for_db = true;
                    if (page != null) {
                        page.resume();
                    }
                    popDlg3.show();
                }
                break;
            case FinalRadioCtrl.Info_Btn_Cancel /* 130320 */:
                getPage().getDialog().dismiss();
                break;
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void InitGridItem(JGridView gridView, JPage page, SparseArray<String> map, int position) {
        int id = gridView.getId();
        switch (id) {
            case FinalRadioCtrl.Info_ListView /* 130325 */:
                View viewContent = page.getChildViewByid(FinalRadioCtrl.Item_Content);
                if (viewContent != null) {
                    if (map.size() == 0) {
                        viewContent.setVisibility(8);
                    } else {
                        viewContent.setVisibility(0);
                        JText text = (JText) page.getChildViewByid(FinalRadioCtrl.Item_Txt_Id);
                        if (text != null) {
                            text.setText(String.format(Locale.US, "%d.", Integer.valueOf(position + 1)));
                        }
                    }
                }
                break;
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void GridClick(JGridView gridView) {
        if (gridView != null) {
            SparseArray<String> map = gridView.getList().get(gridView.getPosition());
            if (map.size() > 0) {
                float freq = Float.parseFloat(map.get(FinalRadioCtrl.Item_Txt_Freq));
                App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
            }
        }
    }

    public void setDayOrNight(int value) {
        JView view = (JView) getPage().getChildViewByid(FinalRadioCtrl.Info_iv_bk);
        if (view != null) {
            String str = value > 0 ? "night_" : FinalChip.BSP_PLATFORM_Null;
            String drawableName = view.getStrDrawable();
            if (TextUtils.isEmpty(str)) {
                if (drawableName.startsWith("night_")) {
                    view.setStrDrawable(drawableName.replace("night_", FinalChip.BSP_PLATFORM_Null), true);
                }
            } else if (!drawableName.startsWith("night_")) {
                view.setStrDrawable("night_" + drawableName, true);
            }
        }
    }
}
