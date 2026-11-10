package com.syu.radio.page;

import android.view.View;
import android.widget.EditText;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.data.FinalChip;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_SetFreq extends MyPage {
    Act_Radio actRadio;
    public int i_freq;

    public Page_SetFreq(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.i_freq = 0;
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() {
        String strFreq;
        EditText editName = (EditText) getPage().getChildViewByid(FinalRadioCtrl.SetFreq_Edit);
        if (editName != null) {
            if (Radio_IpcObj.mIsAdd_for_db) {
                editName.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                editName.setText(Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Txt_Name));
            }
        }
        JText textFreq = (JText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Txt_Freq);
        if (textFreq != null) {
            switch (App_Radio.iRadioType_Arm) {
                case 1:
                case 2:
                case 3:
                    float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                    if (FmUtils.mBand > 3) {
                        textFreq.setText(String.format(Locale.US, "%d", Integer.valueOf((int) freq)));
                    } else {
                        textFreq.setText(String.format(Locale.US, "%.02f", Float.valueOf(freq)));
                    }
                    break;
                default:
                    int freq2 = App_Radio.getInstance().mIpcObj.getCurrentFreq();
                    if (freq2 > 5000) {
                        Radio_IpcObj.mFreq_for_db = freq2;
                        strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq2 / 100), Integer.valueOf(freq2 % 100));
                    } else {
                        Radio_IpcObj.mFreq_for_db = freq2 * 100;
                        strFreq = new StringBuilder().append(freq2).toString();
                    }
                    textFreq.setText(strFreq);
                    break;
            }
        }
    }

    private void EditOk() {
        EditText editName = (EditText) getPage().getChildViewByid(FinalRadioCtrl.SetFreq_Edit);
        String str_freq = editName.getText().toString().trim();
        if (str_freq != null) {
            this.i_freq = 0;
            int i_point = 255;
            for (int i = 0; i < str_freq.length(); i++) {
                if (str_freq.charAt(i) >= '0' && str_freq.charAt(i) <= '9') {
                    this.i_freq = (this.i_freq * 10) + Character.getNumericValue(str_freq.charAt(i));
                    if (i_point <= 1) {
                        i_point++;
                    } else if (i_point != 255) {
                        break;
                    }
                } else if (str_freq.charAt(i) == '.') {
                    if (i_point == 255) {
                        i_point = 0;
                    } else {
                        this.i_freq = 0;
                        break;
                    }
                } else {
                    this.i_freq = 0;
                    break;
                }
            }
            if (i_point == 1) {
                this.i_freq *= 10;
            }
            if (this.i_freq >= FmUtils.LOWEST_STATION_FM && this.i_freq <= FmUtils.HIGHEST_STATION_FM) {
                if (FmUtils.mBand > 3) {
                    this.i_freq = 0;
                }
            } else if (this.i_freq < FmUtils.LOWEST_STATION_AM || this.i_freq > FmUtils.HIGHEST_STATION_AM || FmUtils.mBand <= 3) {
                this.i_freq = 0;
            }
            if (this.i_freq == 0) {
                this.actRadio.tips(getString("radio_freq_err"));
            } else {
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_SetFreq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        App_Radio.getInstance().setFreq(Page_SetFreq.this.i_freq, true);
                    }
                }, 500L);
            }
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.SetFreq_Btn_Ok /* 130344 */:
                EditOk();
                getPage().getDialog().dismiss();
                break;
            case FinalRadioCtrl.SetFreq_Btn_Cancel /* 130345 */:
                getPage().getDialog().dismiss();
                break;
        }
    }
}
