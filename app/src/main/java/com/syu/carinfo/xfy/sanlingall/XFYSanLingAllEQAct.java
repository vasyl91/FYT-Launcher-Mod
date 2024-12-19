package com.syu.carinfo.xfy.sanlingall;

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
public class XFYSanLingAllEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.sanlingall.XFYSanLingAllEQAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 36:
                    XFYSanLingAllEQAct.this.updateCarEQFad();
                    break;
                case 37:
                    XFYSanLingAllEQAct.this.updateCarEQBal();
                    break;
                case 39:
                    XFYSanLingAllEQAct.this.updateCarEQBass();
                    break;
                case 40:
                    XFYSanLingAllEQAct.this.updateCarEQTre();
                    break;
                case 41:
                    XFYSanLingAllEQAct.this.updateCarEQMid();
                    break;
                case 42:
                    XFYSanLingAllEQAct.this.updateCarEQPunch();
                    break;
                case 43:
                    XFYSanLingAllEQAct.this.updateCarEQVol();
                    break;
                case 44:
                    XFYSanLingAllEQAct.this.updateCarEQSurround();
                    break;
                case 46:
                    XFYSanLingAllEQAct.this.updateCarEQPremidia();
                    break;
                case 47:
                    XFYSanLingAllEQAct.this.updateCarEQSCV();
                    break;
                case 48:
                    XFYSanLingAllEQAct.this.updateCarEQDolby();
                    break;
                case 49:
                    XFYSanLingAllEQAct.this.updateCarEQSpeedVol();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_xfy_sanling_eqsettings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[49];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(9, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[43];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(8, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[43];
                if (value3 < 45) {
                    value3++;
                }
                setCarInfo(8, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[37];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[37];
                if (value5 < 22) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[36];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[36];
                if (value7 < 22) {
                    value7++;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[39];
                if (value8 > 2) {
                    value8--;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[39];
                if (value9 < 12) {
                    value9++;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[41];
                if (value10 > 2) {
                    value10--;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[41];
                if (value11 < 12) {
                    value11++;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[40];
                if (value12 > 2) {
                    value12--;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[40];
                if (value13 < 12) {
                    value13++;
                }
                setCarInfo(5, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[42];
                if (value14 > 2) {
                    value14--;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[42];
                if (value15 < 8) {
                    value15++;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[44];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(10, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[44];
                if (value17 < 2) {
                    value17++;
                }
                setCarInfo(10, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[46];
                if (value18 > 0) {
                    value18--;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[46];
                if (value19 < 2) {
                    value19++;
                }
                setCarInfo(12, value19);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value20 = DataCanbus.DATA[47];
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(13, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value21 = DataCanbus.DATA[47];
                if (value21 < 3) {
                    value21++;
                }
                setCarInfo(13, value21);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value22 = DataCanbus.DATA[48];
                if (value22 > 0) {
                    value22--;
                }
                setCarInfo(14, value22);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value23 = DataCanbus.DATA[48];
                if (value23 < 3) {
                    value23++;
                }
                setCarInfo(14, value23);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQSCV() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text10)).setText("High");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQDolby() {
        int value = DataCanbus.DATA[48];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text11)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text11)).setText("High");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQPremidia() {
        int value = DataCanbus.DATA[46];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText("High");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQSurround() {
        int value = DataCanbus.DATA[44];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("DTS Neural");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("PREMIDIA WIDE");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQPunch() {
        int value = DataCanbus.DATA[42];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_text7)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[49];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value > 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("F" + (value - 11));
            } else if (value == 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("0");
            } else if (value < 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("R" + (11 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value > 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("R" + (value - 11));
            } else if (value == 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("0");
            } else if (value < 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("L" + (11 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[43];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
