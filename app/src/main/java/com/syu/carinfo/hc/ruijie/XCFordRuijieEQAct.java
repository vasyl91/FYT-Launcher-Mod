package com.syu.carinfo.hc.ruijie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCFordRuijieEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.ruijie.XCFordRuijieEQAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    XCFordRuijieEQAct.this.updateTempUnit();
                    break;
                case 32:
                    XCFordRuijieEQAct.this.updateCarEQVol();
                    break;
                case 33:
                    XCFordRuijieEQAct.this.updateCarEQBal();
                    break;
                case 34:
                    XCFordRuijieEQAct.this.updateCarEQFad();
                    break;
                case 35:
                    XCFordRuijieEQAct.this.updateCarEQBass();
                    break;
                case 36:
                    XCFordRuijieEQAct.this.updateCarEQMid();
                    break;
                case 37:
                    XCFordRuijieEQAct.this.updateCarEQTre();
                    break;
                case 38:
                    XCFordRuijieEQAct.this.updateCarEQSpeedVol();
                    break;
                case 40:
                    if (((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_ice_blue);
                                break;
                            case 2:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                                break;
                            case 3:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_darkskyblue_str);
                                break;
                            case 4:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_red_str);
                                break;
                            case 5:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_background_green);
                                break;
                            case 6:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 7:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_pueple_str);
                                break;
                            default:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 41:
                    if (((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_hc_ruijie_eqsettings);
        setListener();
    }

    private void setListener() {
        if (DataCanbus.DATA[1000] != 6881719) {
            setViewVisible(findViewById(R.id.layout_view1), false);
            setViewVisible(findViewById(R.id.layout_view2), false);
            setViewVisible(findViewById(R.id.layout_view4), false);
            setViewVisible(findViewById(R.id.layout_view5), false);
            setViewVisible(findViewById(R.id.layout_view6), false);
            setViewVisible(findViewById(R.id.layout_view7), false);
            setViewVisible(findViewById(R.id.layout_view8), false);
            setViewVisible(findViewById(R.id.layout_view9), false);
            setViewVisible(findViewById(R.id.layout_view10), false);
        }
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int color = DataCanbus.DATA[40];
                int lev = DataCanbus.DATA[41];
                if (color > 0) {
                    color--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color, lev}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int color2 = DataCanbus.DATA[40];
                int lev2 = DataCanbus.DATA[41];
                if (color2 < 7) {
                    color2++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color2, lev2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int color3 = DataCanbus.DATA[40];
                int lev3 = DataCanbus.DATA[41];
                if (lev3 > 0) {
                    lev3--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color3, lev3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int color4 = DataCanbus.DATA[40];
                int lev4 = DataCanbus.DATA[41];
                if (lev4 < 15) {
                    lev4++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color4, lev4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value = DataCanbus.DATA[28];
                if (value < 1) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value2 = DataCanbus.DATA[28];
                if (value2 > 0) {
                    value2--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value2}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value3 = DataCanbus.DATA[38];
                if (value3 > 0) {
                    value3--;
                }
                setCarEQ(6, value3);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value4 = DataCanbus.DATA[38];
                if (value4 < 7) {
                    value4++;
                }
                setCarEQ(6, value4);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value5 = DataCanbus.DATA[33];
                if (value5 > 0) {
                    value5--;
                }
                setCarEQ(1, value5);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value6 = DataCanbus.DATA[33];
                if (value6 < 14) {
                    value6++;
                }
                setCarEQ(1, value6);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value7 = DataCanbus.DATA[34];
                if (value7 > 0) {
                    value7--;
                }
                setCarEQ(2, value7);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value8 = DataCanbus.DATA[34];
                if (value8 < 14) {
                    value8++;
                }
                setCarEQ(2, value8);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value9 = DataCanbus.DATA[35];
                if (value9 > 0) {
                    value9--;
                }
                setCarEQ(3, value9);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value10 = DataCanbus.DATA[35];
                if (value10 < 14) {
                    value10++;
                }
                setCarEQ(3, value10);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value11 = DataCanbus.DATA[36];
                if (value11 > 0) {
                    value11--;
                }
                setCarEQ(4, value11);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value12 = DataCanbus.DATA[36];
                if (value12 < 14) {
                    value12++;
                }
                setCarEQ(4, value12);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value13 = DataCanbus.DATA[37];
                if (value13 > 0) {
                    value13--;
                }
                setCarEQ(5, value13);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value14 = DataCanbus.DATA[37];
                if (value14 < 14) {
                    value14++;
                }
                setCarEQ(5, value14);
                break;
        }
    }

    public void setCarEQ(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit() {
        int value = DataCanbus.DATA[28];
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
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text10)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[36];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text9)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text8)).setText("-" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("F" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("R" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("R" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("L" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
