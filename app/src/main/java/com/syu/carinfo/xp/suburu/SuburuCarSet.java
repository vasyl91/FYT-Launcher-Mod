package com.syu.carinfo.xp.suburu;

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
public class SuburuCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.suburu.SuburuCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    if (((CheckedTextView) SuburuCarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) SuburuCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                        break;
                    }
                case 29:
                    if (((CheckedTextView) SuburuCarSet.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) SuburuCarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                        break;
                    }
                case 30:
                    SuburuCarSet.this.updateText1(val);
                    break;
                case 31:
                    SuburuCarSet.this.updateText2(val);
                    break;
                case 32:
                    SuburuCarSet.this.updateText3(val);
                    break;
                case 33:
                    SuburuCarSet.this.updateText4(val);
                    break;
                case 34:
                    SuburuCarSet.this.updateText5(val);
                    break;
                case 35:
                    SuburuCarSet.this.updateText6(val);
                    break;
                case 36:
                    SuburuCarSet.this.updateText7(val);
                    break;
                case 37:
                    SuburuCarSet.this.updateText8(val);
                    break;
                case 39:
                    if (val == 0) {
                        SuburuCarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    } else {
                        SuburuCarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xp_suburu_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[28] == 1) {
                    value6 = 0;
                } else {
                    value6 = 1;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value7 = DataCanbus.DATA[30] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value8 = DataCanbus.DATA[30] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = DataCanbus.DATA[31] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = DataCanbus.DATA[31] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                if (DataCanbus.DATA[32] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                if (DataCanbus.DATA[32] == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                if (DataCanbus.DATA[33] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                if (DataCanbus.DATA[33] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value11 = DataCanbus.DATA[34] - 1;
                if (value11 < 0) {
                    value11 = 5;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value12 = DataCanbus.DATA[34] + 1;
                if (value12 > 5) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value13 = DataCanbus.DATA[35] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value14 = DataCanbus.DATA[35] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value15 = DataCanbus.DATA[36] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(9, value15);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value16 = DataCanbus.DATA[36] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(9, value16);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value17 = DataCanbus.DATA[37] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(10, value17);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value18 = DataCanbus.DATA[37] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(10, value18);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[29] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, SuburuCarEQInfo.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type2");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type1");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Shift into or out of PARK");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Ignition off");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Driver door open");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Vehicle Speed");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Shift into or out of PARK");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("20s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("40s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text5)).setText("50s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text5)).setText("60s");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("15 Minutes");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Continuously");
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
                    ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("30s");
                    break;
            }
        }
    }
}
