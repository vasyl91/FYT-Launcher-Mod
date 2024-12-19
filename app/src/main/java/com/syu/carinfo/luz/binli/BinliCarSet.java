package com.syu.carinfo.luz.binli;

import android.content.Intent;
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
public class BinliCarSet extends BaseActivity implements View.OnClickListener {
    public static BinliCarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.binli.BinliCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 33:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 34:
                    BinliCarSet.this.updateParkMode(val);
                    break;
                case 35:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 36:
                    BinliCarSet.this.updateTireUnit(val);
                    break;
                case 37:
                    BinliCarSet.this.updateTireSpeedType(val);
                    break;
                case 38:
                    BinliCarSet.this.updateTireType(val);
                    break;
                case 39:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 48:
                    BinliCarSet.this.updateHangLev(val);
                    break;
                case 49:
                    BinliCarSet.this.updateCarLev(val);
                    break;
                case 56:
                    BinliCarSet.this.updateTempUnit(val);
                    break;
                case 66:
                    BinliCarSet.this.updateTripUnit(val);
                    break;
                case 83:
                    BinliCarSet.this.updateLightDelay(val);
                    break;
                case 84:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 85:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_binli_settings);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
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
        int value8;
        int value9;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[39] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(10, value4);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value10 = DataCanbus.DATA[38] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value11 = DataCanbus.DATA[38] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = DataCanbus.DATA[37] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value13 = DataCanbus.DATA[37] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value14 = DataCanbus.DATA[56] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(13, value14);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value15 = DataCanbus.DATA[56] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(13, value15);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value16 = DataCanbus.DATA[36] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(14, value16);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value17 = DataCanbus.DATA[36] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(14, value17);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value18 = (DataCanbus.DATA[66] >> 5) & 3;
                if (value18 == 0) {
                    value18 = 2;
                } else if (value18 == 1) {
                    value18 = 1;
                } else if (value18 == 2) {
                    value18 = 0;
                }
                setCarInfo(15, value18);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value19 = (DataCanbus.DATA[66] >> 5) & 3;
                if (value19 == 0) {
                    value19 = 0;
                } else if (value19 == 1) {
                    value19 = 2;
                } else if (value19 == 2) {
                    value19 = 1;
                }
                setCarInfo(15, value19);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value20 = DataCanbus.DATA[83] - 1;
                if (value20 < 0) {
                    value20 = 6;
                }
                setCarInfo(16, value20);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value21 = DataCanbus.DATA[83] + 1;
                if (value21 > 6) {
                    value21 = 0;
                }
                setCarInfo(16, value21);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                if (DataCanbus.DATA[34] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                if (DataCanbus.DATA[49] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[48] - 1;
                if (value22 < 0) {
                    value22 = 3;
                }
                setCarInfo(1, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[48] + 1;
                if (value23 > 3) {
                    value23 = 0;
                }
                setCarInfo(1, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                if (DataCanbus.DATA[49] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                if (DataCanbus.DATA[49] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[35] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[84] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(17, value2);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[85] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(18, value);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[33] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                setCarInfo(3, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfo(11, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, BinliCarTire.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLightDelay(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text6)).setText("90s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text6)).setText("120s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text6)).setText("150s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text6)).setText("180s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch ((value >> 5) & 3) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("L/100km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("km/L");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("mpg");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℉");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("kpa");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireSpeedType(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_car_screen_display_normal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.lingdu_air_con_profile_2);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.MAX);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireType(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("21");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20 Winter");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Winter(275/40R20)");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarLev(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.rzc_klc_nomal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_advanced_set);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHangLev(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_driving_comfort);
                    break;
                case 1:
                case 2:
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.driver_system_sports);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParkMode(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_vertical_parking);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_horizontal_parking);
                    break;
            }
        }
    }
}
