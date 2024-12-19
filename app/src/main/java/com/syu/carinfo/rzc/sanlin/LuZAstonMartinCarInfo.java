package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_AstonMartin;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuZAstonMartinCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuZAstonMartinCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 25:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 26:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text3)).setText("passenger only");
                                break;
                            case 1:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text3)).setText("passenger&driver");
                                break;
                        }
                    }
                    break;
                case 27:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 28:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 29:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text4)).setText("all doors");
                                break;
                            case 1:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text4)).setText("driver door");
                                break;
                        }
                    }
                    break;
                case 30:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 31:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 32:
                    LuZAstonMartinCarInfo.this.setCheck((CheckedTextView) LuZAstonMartinCarInfo.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 33:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 1:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                            case 2:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text5)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 1:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                            case 2:
                                ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text6)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 35:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 36:
                    if (((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LuZAstonMartinCarInfo.this.findViewById(R.id.tv_text2)).setText(Callback_0453_LZ_AstonMartin.VinId);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_astonmartin_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[24];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[26] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[26] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[29] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[29] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[33] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(9, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[33] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[34] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(10, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[34] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(10, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[25];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(1, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value11 = DataCanbus.DATA[27];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(3, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value12 = DataCanbus.DATA[28];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(4, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value13 = DataCanbus.DATA[30];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(6, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value14 = DataCanbus.DATA[31];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(7, value14);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value15 = DataCanbus.DATA[32];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(8, value15);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{54}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
    }
}
