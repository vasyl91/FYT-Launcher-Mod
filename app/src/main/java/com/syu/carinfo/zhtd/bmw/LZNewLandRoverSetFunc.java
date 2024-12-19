package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_LandRover_KeepCD;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZNewLandRoverSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_LandRover_KeepCD.modevalue = ints[2];
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 61:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 62:
                case 63:
                    int w = DataCanbus.DATA[62];
                    int h = DataCanbus.DATA[63];
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                    break;
                case 64:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 65:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 72:
                    LZNewLandRoverSetFunc.this.updateLauguageSet();
                    break;
                case 73:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("13-16 Range Rover");
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("13-15 EVOQUE");
                            break;
                        case 2:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("12 EVOQUE");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_landrover_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewLandRoverSetFunc.this.language_set = position;
                if (LZNewLandRoverSetFunc.this.language_set >= 0 && LZNewLandRoverSetFunc.this.language_set <= LZNewLandRoverSetFunc.this.mLauStylelist.size() && LZNewLandRoverSetFunc.this.send_lang != null) {
                    LZNewLandRoverSetFunc.this.setCarInfo(250, LZNewLandRoverSetFunc.this.language_set);
                    switch (LZNewLandRoverSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 4}, null, null);
                            break;
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 5}, null, null);
                            break;
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 6}, null, null);
                            break;
                        case 3:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 16}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                            if (Callback_0453_LZ_LandRover_KeepCD.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                break;
                            }
                    }
                }
                LZNewLandRoverSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[72];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("LR-Bose 800x480 G100");
        this.mLauStylelist.add("LR-Bose 800x480-1 G100");
        this.mLauStylelist.add("LR-Bose 800x480-2 G100");
        this.mLauStylelist.add("LR-Haman 1280x540  I300");
        this.send_lang = new int[]{0, 1, 2, 3};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewLandRoverSetFunc.this.mLauStyle == null) {
                    LZNewLandRoverSetFunc.this.initLauStyle();
                }
                if (LZNewLandRoverSetFunc.this.mLauStyle != null && LZNewLandRoverSetFunc.this.mPopShowView != null) {
                    LZNewLandRoverSetFunc.this.mLauStyle.showAtLocation(LZNewLandRoverSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewLandRoverSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus14 /* 2131427471 */:
                int value = DataCanbus.DATA[65];
                if (value > 0) {
                    value--;
                }
                setCarInfo(252, value);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value2 = DataCanbus.DATA[65];
                if (value2 < 36) {
                    value2++;
                }
                setCarInfo(252, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZNewLandRoverCarinfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_minus1 /* 2131427480 */:
                int value3 = DataCanbus.DATA[73] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(249, value3);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[73] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(249, value4);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value5 = DataCanbus.DATA[61] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(254, value5);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value6 = DataCanbus.DATA[61] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(254, value6);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value7 = DataCanbus.DATA[64];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(253, value7);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value8 = DataCanbus.DATA[64];
                if (value8 < 36) {
                    value8++;
                }
                setCarInfo(253, value8);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
    }
}
