package com.syu.carinfo.bagu.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BaguBmwCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bagu.bmw.BaguBmwCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    BaguBmwCarSet.this.updateText1(val);
                    break;
                case 12:
                    BaguBmwCarSet.this.updateText2(val);
                    break;
                case 13:
                    BaguBmwCarSet.this.updateText3(val);
                    break;
                case 14:
                    BaguBmwCarSet.this.updateText4(val);
                    break;
                case 15:
                    BaguBmwCarSet.this.updateText5(val);
                    break;
                case 18:
                    BaguBmwCarSet.this.updateText6(val);
                    BaguBmwCarSet.this.setCheck((CheckedTextView) BaguBmwCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 19:
                    BaguBmwCarSet.this.setCheck((CheckedTextView) BaguBmwCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    BaguBmwCarSet.this.updateText7(val);
                    break;
                case 20:
                    BaguBmwCarSet.this.setCheck((CheckedTextView) BaguBmwCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0386_bagu_bmw_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value0 = DataCanbus.DATA[11];
                int value1 = DataCanbus.DATA[12];
                int value2 = DataCanbus.DATA[13];
                int value3 = DataCanbus.DATA[14];
                int value4 = DataCanbus.DATA[15];
                int value5 = value0 - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo2(value5, value1, value2, value3, value4);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value6 = DataCanbus.DATA[11];
                int value7 = DataCanbus.DATA[12];
                int value8 = DataCanbus.DATA[13];
                int value9 = DataCanbus.DATA[14];
                int value10 = DataCanbus.DATA[15];
                int value11 = value6 + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo2(value11, value7, value8, value9, value10);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value12 = DataCanbus.DATA[11];
                int value13 = DataCanbus.DATA[12];
                int value14 = DataCanbus.DATA[13];
                int value15 = DataCanbus.DATA[14];
                int value16 = DataCanbus.DATA[15];
                int value17 = value13 - 1;
                if (value17 < 0) {
                    value17 = 5;
                }
                setCarInfo2(value12, value17, value14, value15, value16);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value18 = DataCanbus.DATA[11];
                int value19 = DataCanbus.DATA[12];
                int value20 = DataCanbus.DATA[13];
                int value21 = DataCanbus.DATA[14];
                int value22 = DataCanbus.DATA[15];
                int value23 = value19 + 1;
                if (value23 > 5) {
                    value23 = 0;
                }
                setCarInfo2(value18, value23, value20, value21, value22);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value24 = DataCanbus.DATA[11];
                int value25 = DataCanbus.DATA[12];
                int value26 = DataCanbus.DATA[13];
                int value27 = DataCanbus.DATA[14];
                int value28 = DataCanbus.DATA[15];
                int value29 = value26 - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo2(value24, value25, value29, value27, value28);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value30 = DataCanbus.DATA[11];
                int value31 = DataCanbus.DATA[12];
                int value32 = DataCanbus.DATA[13];
                int value33 = DataCanbus.DATA[14];
                int value34 = DataCanbus.DATA[15];
                int value35 = value32 + 1;
                if (value35 > 3) {
                    value35 = 0;
                }
                setCarInfo2(value30, value31, value35, value33, value34);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value36 = DataCanbus.DATA[11];
                int value37 = DataCanbus.DATA[12];
                int value38 = DataCanbus.DATA[13];
                int value39 = DataCanbus.DATA[14];
                int value40 = DataCanbus.DATA[15];
                int value41 = value39 - 1;
                if (value41 < 0) {
                    value41 = 1;
                }
                setCarInfo2(value36, value37, value38, value41, value40);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value42 = DataCanbus.DATA[11];
                int value43 = DataCanbus.DATA[12];
                int value44 = DataCanbus.DATA[13];
                int value45 = DataCanbus.DATA[14];
                int value46 = DataCanbus.DATA[15];
                int value47 = value45 + 1;
                if (value47 > 1) {
                    value47 = 0;
                }
                setCarInfo2(value42, value43, value44, value47, value46);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value48 = DataCanbus.DATA[11];
                int value49 = DataCanbus.DATA[12];
                int value50 = DataCanbus.DATA[13];
                int value51 = DataCanbus.DATA[14];
                int value52 = DataCanbus.DATA[15] - 1;
                if (value52 < 0) {
                    value52 = 1;
                }
                setCarInfo2(value48, value49, value50, value51, value52);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value53 = DataCanbus.DATA[11];
                int value54 = DataCanbus.DATA[12];
                int value55 = DataCanbus.DATA[13];
                int value56 = DataCanbus.DATA[14];
                int value57 = DataCanbus.DATA[15] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo2(value53, value54, value55, value56, value57);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(2);
                break;
        }
    }

    public void setCarInfo2(int value0, int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3, value4}, null, null);
    }

    private void setCarInfo(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.bagu.bmw.BaguBmwCarSet.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd, 0}, null, null);
            }
        }, 100L);
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
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
                    ((TextView) findViewById(R.id.tv_text5)).setText("12");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("24");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℉");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("l/100km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("mpg(US)");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText("mpg(UK)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText("km/l");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Deutsch");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("English UK");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("English US");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Espanol");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Italiano");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Francais");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("mls");
                    break;
            }
        }
    }
}
