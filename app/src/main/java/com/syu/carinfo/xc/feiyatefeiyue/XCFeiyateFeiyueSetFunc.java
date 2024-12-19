package com.syu.carinfo.xc.feiyatefeiyue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCFeiyateFeiyueSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.feiyatefeiyue.XCFeiyateFeiyueSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 32:
                    XCFeiyateFeiyueSetFunc.this.updateText1(val);
                    break;
                case 33:
                    XCFeiyateFeiyueSetFunc.this.setCheck((CheckedTextView) XCFeiyateFeiyueSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 34:
                    XCFeiyateFeiyueSetFunc.this.updateText2(val);
                    break;
                case 35:
                    XCFeiyateFeiyueSetFunc.this.updateText3(val);
                    break;
                case 36:
                    XCFeiyateFeiyueSetFunc.this.setCheck((CheckedTextView) XCFeiyateFeiyueSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 37:
                    XCFeiyateFeiyueSetFunc.this.setCheck((CheckedTextView) XCFeiyateFeiyueSetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 38:
                    XCFeiyateFeiyueSetFunc.this.setCheck((CheckedTextView) XCFeiyateFeiyueSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 39:
                    XCFeiyateFeiyueSetFunc.this.updateText4(val);
                    break;
                case 40:
                    XCFeiyateFeiyueSetFunc.this.setCheck((CheckedTextView) XCFeiyateFeiyueSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 41:
                    XCFeiyateFeiyueSetFunc.this.updateText5(val);
                    break;
                case 43:
                    XCFeiyateFeiyueSetFunc.this.updateText6(val);
                    break;
                case 44:
                    XCFeiyateFeiyueSetFunc.this.updateText7(val);
                    break;
                case 45:
                    XCFeiyateFeiyueSetFunc.this.updateText8(val);
                    break;
                case 46:
                    XCFeiyateFeiyueSetFunc.this.updateText9(val);
                    break;
                case 47:
                    XCFeiyateFeiyueSetFunc.this.updateText10(val);
                    break;
                case 48:
                    XCFeiyateFeiyueSetFunc.this.updateText11(val);
                    break;
                case 49:
                    XCFeiyateFeiyueSetFunc.this.updateText12(val);
                    break;
                case 50:
                    XCFeiyateFeiyueSetFunc.this.updateText13(val);
                    break;
                case 51:
                    XCFeiyateFeiyueSetFunc.this.updateText14(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xc_feiyate_feiyue_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value8 = DataCanbus.DATA[50] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(82, value8);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value9 = DataCanbus.DATA[50] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(82, value9);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value10 = DataCanbus.DATA[51] - 1;
                if (value10 < 1) {
                    value10 = 8;
                }
                setCarInfo(83, value10);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value11 = DataCanbus.DATA[51] + 1;
                if (value11 > 8) {
                    value11 = 1;
                }
                setCarInfo(83, value11);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[33] == 0) {
                    value7 = 2;
                } else {
                    value7 = 1;
                }
                setCarInfo(39, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value12 = DataCanbus.DATA[32] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(1, value12);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value13 = DataCanbus.DATA[32] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(1, value13);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value14 = DataCanbus.DATA[34];
                if (value14 == 0) {
                    value14 = 90;
                } else if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 2) {
                    value14 = 30;
                } else if (value14 == 3) {
                    value14 = 60;
                }
                setCarInfo(17, value14);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value15 = DataCanbus.DATA[34];
                if (value15 == 0) {
                    value15 = 30;
                } else if (value15 == 1) {
                    value15 = 60;
                } else if (value15 == 2) {
                    value15 = 90;
                } else if (value15 == 3) {
                    value15 = 0;
                }
                setCarInfo(17, value15);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value16 = DataCanbus.DATA[35];
                if (value16 == 0) {
                    value16 = 90;
                } else if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 2) {
                    value16 = 30;
                } else if (value16 == 3) {
                    value16 = 60;
                }
                setCarInfo(18, value16);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value17 = DataCanbus.DATA[35];
                if (value17 == 0) {
                    value17 = 30;
                } else if (value17 == 1) {
                    value17 = 60;
                } else if (value17 == 2) {
                    value17 = 90;
                } else if (value17 == 3) {
                    value17 = 0;
                }
                setCarInfo(18, value17);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                if (DataCanbus.DATA[39] == 0) {
                    value3 = 2;
                } else {
                    value3 = 1;
                }
                setCarInfo(36, value3);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                if (DataCanbus.DATA[39] == 0) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                setCarInfo(36, value2);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value18 = DataCanbus.DATA[41];
                if (value18 == 0) {
                    value18 = 40;
                } else if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 2) {
                    value18 = 3;
                } else if (value18 == 3) {
                    value18 = 20;
                }
                setCarInfo(50, value18);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value19 = DataCanbus.DATA[41];
                if (value19 == 0) {
                    value19 = 3;
                } else if (value19 == 1) {
                    value19 = 20;
                } else if (value19 == 2) {
                    value19 = 40;
                } else if (value19 == 3) {
                    value19 = 0;
                }
                setCarInfo(50, value19);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int vol = DataCanbus.DATA[43];
                int bal = DataCanbus.DATA[44];
                int fad = DataCanbus.DATA[45];
                int bass = DataCanbus.DATA[46];
                int mid = DataCanbus.DATA[47];
                int treb = DataCanbus.DATA[48];
                int onoff = DataCanbus.DATA[49];
                if (vol > 0) {
                    vol--;
                }
                setCarEQ(vol, bal, fad, bass, mid, treb, (onoff << 1) & 6);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int vol2 = DataCanbus.DATA[43];
                int bal2 = DataCanbus.DATA[44];
                int fad2 = DataCanbus.DATA[45];
                int bass2 = DataCanbus.DATA[46];
                int mid2 = DataCanbus.DATA[47];
                int treb2 = DataCanbus.DATA[48];
                int onoff2 = DataCanbus.DATA[49];
                if (vol2 < 38) {
                    vol2++;
                }
                setCarEQ(vol2, bal2, fad2, bass2, mid2, treb2, (onoff2 << 1) & 6);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int vol3 = DataCanbus.DATA[43];
                int bal3 = DataCanbus.DATA[44];
                int fad3 = DataCanbus.DATA[45];
                int bass3 = DataCanbus.DATA[46];
                int mid3 = DataCanbus.DATA[47];
                int treb3 = DataCanbus.DATA[48];
                int onoff3 = DataCanbus.DATA[49];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarEQ(vol3, bal3, fad3, bass3, mid3, treb3, (onoff3 << 1) & 6);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int vol4 = DataCanbus.DATA[43];
                int bal4 = DataCanbus.DATA[44];
                int fad4 = DataCanbus.DATA[45];
                int bass4 = DataCanbus.DATA[46];
                int mid4 = DataCanbus.DATA[47];
                int treb4 = DataCanbus.DATA[48];
                int onoff4 = DataCanbus.DATA[49];
                if (bal4 < 19) {
                    bal4++;
                }
                setCarEQ(vol4, bal4, fad4, bass4, mid4, treb4, (onoff4 << 1) & 6);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int vol5 = DataCanbus.DATA[43];
                int bal5 = DataCanbus.DATA[44];
                int fad5 = DataCanbus.DATA[45];
                int bass5 = DataCanbus.DATA[46];
                int mid5 = DataCanbus.DATA[47];
                int treb5 = DataCanbus.DATA[48];
                int onoff5 = DataCanbus.DATA[49];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarEQ(vol5, bal5, fad5, bass5, mid5, treb5, (onoff5 << 1) & 6);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int vol6 = DataCanbus.DATA[43];
                int bal6 = DataCanbus.DATA[44];
                int fad6 = DataCanbus.DATA[45];
                int bass6 = DataCanbus.DATA[46];
                int mid6 = DataCanbus.DATA[47];
                int treb6 = DataCanbus.DATA[48];
                int onoff6 = DataCanbus.DATA[49];
                if (fad6 < 19) {
                    fad6++;
                }
                setCarEQ(vol6, bal6, fad6, bass6, mid6, treb6, (onoff6 << 1) & 6);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int vol7 = DataCanbus.DATA[43];
                int bal7 = DataCanbus.DATA[44];
                int fad7 = DataCanbus.DATA[45];
                int bass7 = DataCanbus.DATA[46];
                int mid7 = DataCanbus.DATA[47];
                int treb7 = DataCanbus.DATA[48];
                int onoff7 = DataCanbus.DATA[49];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarEQ(vol7, bal7, fad7, bass7, mid7, treb7, (onoff7 << 1) & 6);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int vol8 = DataCanbus.DATA[43];
                int bal8 = DataCanbus.DATA[44];
                int fad8 = DataCanbus.DATA[45];
                int bass8 = DataCanbus.DATA[46];
                int mid8 = DataCanbus.DATA[47];
                int treb8 = DataCanbus.DATA[48];
                int onoff8 = DataCanbus.DATA[49];
                if (bass8 < 19) {
                    bass8++;
                }
                setCarEQ(vol8, bal8, fad8, bass8, mid8, treb8, (onoff8 << 1) & 6);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int vol9 = DataCanbus.DATA[43];
                int bal9 = DataCanbus.DATA[44];
                int fad9 = DataCanbus.DATA[45];
                int bass9 = DataCanbus.DATA[46];
                int mid9 = DataCanbus.DATA[47];
                int treb9 = DataCanbus.DATA[48];
                int onoff9 = DataCanbus.DATA[49];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarEQ(vol9, bal9, fad9, bass9, mid9, treb9, (onoff9 << 1) & 6);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int vol10 = DataCanbus.DATA[43];
                int bal10 = DataCanbus.DATA[44];
                int fad10 = DataCanbus.DATA[45];
                int bass10 = DataCanbus.DATA[46];
                int mid10 = DataCanbus.DATA[47];
                int treb10 = DataCanbus.DATA[48];
                int onoff10 = DataCanbus.DATA[49];
                if (mid10 < 19) {
                    mid10++;
                }
                setCarEQ(vol10, bal10, fad10, bass10, mid10, treb10, (onoff10 << 1) & 6);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int vol11 = DataCanbus.DATA[43];
                int bal11 = DataCanbus.DATA[44];
                int fad11 = DataCanbus.DATA[45];
                int bass11 = DataCanbus.DATA[46];
                int mid11 = DataCanbus.DATA[47];
                int treb11 = DataCanbus.DATA[48];
                int onoff11 = DataCanbus.DATA[49];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarEQ(vol11, bal11, fad11, bass11, mid11, treb11, (onoff11 << 1) & 6);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int vol12 = DataCanbus.DATA[43];
                int bal12 = DataCanbus.DATA[44];
                int fad12 = DataCanbus.DATA[45];
                int bass12 = DataCanbus.DATA[46];
                int mid12 = DataCanbus.DATA[47];
                int treb12 = DataCanbus.DATA[48];
                int onoff12 = DataCanbus.DATA[49];
                if (treb12 < 19) {
                    treb12++;
                }
                setCarEQ(vol12, bal12, fad12, bass12, mid12, treb12, (onoff12 << 1) & 6);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int vol13 = DataCanbus.DATA[43];
                int bal13 = DataCanbus.DATA[44];
                int fad13 = DataCanbus.DATA[45];
                int bass13 = DataCanbus.DATA[46];
                int mid13 = DataCanbus.DATA[47];
                int treb13 = DataCanbus.DATA[48];
                int onoff13 = DataCanbus.DATA[49];
                if (onoff13 > 0) {
                    onoff13--;
                }
                setCarEQ(vol13, bal13, fad13, bass13, mid13, treb13, (onoff13 << 1) & 6);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int vol14 = DataCanbus.DATA[43];
                int bal14 = DataCanbus.DATA[44];
                int fad14 = DataCanbus.DATA[45];
                int bass14 = DataCanbus.DATA[46];
                int mid14 = DataCanbus.DATA[47];
                int treb14 = DataCanbus.DATA[48];
                int onoff14 = DataCanbus.DATA[49];
                if (onoff14 < 3) {
                    onoff14++;
                }
                setCarEQ(vol14, bal14, fad14, bass14, mid14, treb14, (onoff14 << 1) & 6);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[36] == 0) {
                    value6 = 2;
                } else {
                    value6 = 1;
                }
                setCarInfo(19, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[37] == 0) {
                    value5 = 2;
                } else {
                    value5 = 1;
                }
                setCarInfo(21, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[38] == 0) {
                    value4 = 2;
                } else {
                    value4 = 1;
                }
                setCarInfo(34, value4);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[40] == 0) {
                    value = 2;
                } else {
                    value = 1;
                }
                setCarInfo(37, value);
                break;
        }
    }

    public void setCarEQ(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText14(int value) {
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_14);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_35);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_21);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_15);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_9);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_31);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText13(int value) {
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text13)).setText(R.string.str_unit_us_imperial);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text13)).setText(R.string.str_unit_metric);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Off");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value == 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("0");
                return;
            }
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("F" + (10 - value));
            } else if (value > 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("R" + (value - 10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("0");
                return;
            }
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("L" + (10 - value));
            } else if (value > 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("R" + (value - 10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("45s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("5min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("10min");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText("90s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("90s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Sound Only");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Sound & Display");
                    break;
            }
        }
    }
}
