package com.syu.radio.page;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.util.data.FinalChip;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.runnable.RunnableUpdate;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_EditInfo extends MyPage {
    Act_Radio actRadio;

    public Page_EditInfo(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() {
        String strFreq;
        JText title = (JText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Txt_Title);
        if (title != null) {
            if (Radio_IpcObj.mIsAdd_for_db) {
                title.setText(getString("radio_info_add"));
            } else {
                title.setText(getString("radio_info_edit"));
            }
        }
        EditText editName = (EditText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Edit_Name);
        if (editName != null) {
            if (Radio_IpcObj.mIsAdd_for_db) {
                editName.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                editName.setText(Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Txt_Name));
            }
        }
        JText textFreq = (JText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Txt_Freq);
        EditText EditFreq = (EditText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Edit_Freq);
        if (textFreq != null || EditFreq != null) {
            switch (App_Radio.iRadioType_Arm) {
                case 1:
                case 2:
                case 3:
                    float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                    if (FmUtils.mBand <= 3) {
                        strFreq = String.format(Locale.US, "%.02f", Float.valueOf(freq));
                    } else {
                        strFreq = String.format(Locale.US, "%d", Integer.valueOf((int) freq));
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
                    break;
            }
            if (strFreq != null) {
                if (EditFreq != null) {
                    EditFreq.setText(strFreq);
                }
                if (textFreq != null) {
                    textFreq.setText(strFreq);
                }
            }
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("^[0-9]+(.[0-9]+)?$");
    }

    private void EditOk() {
        String strToast = FinalChip.BSP_PLATFORM_Null;
        EditText editName = (EditText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Edit_Name);
        JText textFreq = (JText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Txt_Freq);
        String freq = null;
        if (textFreq != null) {
            freq = textFreq.getText().toString();
        }
        EditText EditFreq = (EditText) getPage().getChildViewByid(FinalRadioCtrl.EditInfo_Edit_Freq);
        if (EditFreq != null) {
            freq = EditFreq.getText().toString();
            if (!isNumber(freq)) {
                freq = null;
                this.actRadio.tips(getString("radio_freq_err"));
            }
        }
        if (freq != null && editName != null) {
            if (Radio_IpcObj.mIsAdd_for_db) {
                int area = App_Radio.getInstance().mIpcObj.getArea();
                String name = editName.getText().toString().trim();
                String amfm = Radio_IpcObj.mTextHZ;
                if (freq.length() > 0 && name.length() > 0) {
                    SparseArray<String> map = new SparseArray<>();
                    map.put(FinalRadioCtrl.Item_Txt_Freq, freq);
                    map.put(FinalRadioCtrl.Item_Area, Integer.toString(area));
                    map.put(FinalRadioCtrl.Item_Txt_Name, name);
                    map.put(FinalRadioCtrl.Item_Txt_Unit, amfm);
                    map.put(FinalRadioCtrl.Item_Net, Integer.toString(0));
                    map.put(FinalRadioCtrl.Item_City, FinalChip.BSP_PLATFORM_Null);
                    if (App_Radio.bRuRadioName) {
                        map.put(FinalRadioCtrl.Item_Logo, FinalChip.BSP_PLATFORM_Null);
                    }
                    int[] flags = App_Radio.getInstance().InsertOrUpdate(map, this.actRadio);
                    if (flags[1] == 0 && flags[0] == 0) {
                        editName.setText(FinalChip.BSP_PLATFORM_Null);
                    } else if (flags[1] != 0 && flags[0] == 0) {
                        strToast = "radio_info_nameused";
                    } else if (flags[1] != 0 && flags[0] != 0) {
                        strToast = "radio_info_exist";
                    } else if (flags[1] == 0 && flags[0] != 0) {
                        editName.setText(FinalChip.BSP_PLATFORM_Null);
                    }
                } else if (name.length() == 0) {
                    strToast = "radio_info_namenull";
                }
            } else if (!Radio_IpcObj.mIsAdd_for_db) {
                String name2 = editName.getText().toString().trim();
                if (name2.length() == 0) {
                    strToast = "radio_info_namenull";
                } else {
                    SparseArray<String> map2 = new SparseArray<>();
                    map2.put(FinalRadioCtrl.Item_Index, Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Index));
                    map2.put(FinalRadioCtrl.Item_Txt_Freq, freq);
                    map2.put(FinalRadioCtrl.Item_Area, Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Area));
                    map2.put(FinalRadioCtrl.Item_Txt_Name, name2);
                    map2.put(FinalRadioCtrl.Item_Txt_Unit, Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Txt_Unit));
                    map2.put(FinalRadioCtrl.Item_Net, Integer.toString(0));
                    map2.put(FinalRadioCtrl.Item_City, FinalChip.BSP_PLATFORM_Null);
                    if (App_Radio.bRuRadioName) {
                        map2.put(FinalRadioCtrl.Item_Logo, Radio_IpcObj.updateMap.get(FinalRadioCtrl.Item_Logo));
                    }
                    MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new RunnableUpdate(map2, this.actRadio), false, 1);
                }
                editName.setText(FinalChip.BSP_PLATFORM_Null);
            }
            if (!TextUtils.isEmpty(strToast)) {
                this.actRadio.tips(getString(strToast));
            }
            Page_Radio_6025.refreshColName();
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.EditInfo_Btn_FreqM /* 130334 */:
                switch (App_Radio.iRadioType_Arm) {
                    case 1:
                    case 2:
                    case 3:
                        int station = FmUtils.computeDecreaseStation();
                        App_Radio.getInstance().setFreq(station, true);
                        break;
                    default:
                        App_Radio.getInstance().mIpcObj.freqMinus();
                        break;
                }
                break;
            case FinalRadioCtrl.EditInfo_Btn_FreqP /* 130335 */:
                switch (App_Radio.iRadioType_Arm) {
                    case 1:
                    case 2:
                    case 3:
                        int station2 = FmUtils.computeIncreaseStation();
                        App_Radio.getInstance().setFreq(station2, true);
                        break;
                    default:
                        App_Radio.getInstance().mIpcObj.freqPlus();
                        break;
                }
                break;
            case FinalRadioCtrl.EditInfo_Btn_Ok /* 130336 */:
                EditOk();
                getPage().getDialog().dismiss();
                break;
            case FinalRadioCtrl.EditInfo_Btn_Cancel /* 130337 */:
                getPage().getDialog().dismiss();
                break;
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public boolean ResponseLongClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.EditInfo_Btn_FreqM /* 130334 */:
                App_Radio.getInstance().seekDown();
                break;
            case FinalRadioCtrl.EditInfo_Btn_FreqP /* 130335 */:
                App_Radio.getInstance().seekUp();
                break;
        }
        return false;
    }
}
