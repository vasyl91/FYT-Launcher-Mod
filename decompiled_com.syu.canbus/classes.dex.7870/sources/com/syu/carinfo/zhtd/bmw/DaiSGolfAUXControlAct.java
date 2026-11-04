package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class DaiSGolfAUXControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.DaiSGolfAUXControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                    DaiSGolfAUXControlAct.this.UpdateAUXState(value);
                    DaiSGolfAUXControlAct.this.UpdateAUXTrigger();
                    break;
                case 40:
                    if (DaiSGolfAUXControlAct.this.pagenum == 1) {
                        DaiSGolfAUXControlAct.this.UpdateAUXTrigger();
                    }
                    break;
                case 41:
                    if (DaiSGolfAUXControlAct.this.pagenum == 2) {
                        DaiSGolfAUXControlAct.this.UpdateAUXTrigger();
                    }
                    break;
                case 42:
                    if (DaiSGolfAUXControlAct.this.pagenum == 3) {
                        DaiSGolfAUXControlAct.this.UpdateAUXTrigger();
                    }
                    break;
                case 43:
                    if (DaiSGolfAUXControlAct.this.pagenum == 4) {
                        DaiSGolfAUXControlAct.this.UpdateAUXTrigger();
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_ds_golf_auxctr);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.layout_text_view1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.layout_text_view2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.layout_text_view3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.layout_text_view4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int onoff;
        int onoff2;
        int onoff3;
        int onoff4;
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
            case R.id.layout_text_view1 /* 2131427554 */:
                this.pagenum = 1;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
            case R.id.layout_text_view2 /* 2131427555 */:
                this.pagenum = 2;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
            case R.id.layout_text_view3 /* 2131427712 */:
                this.pagenum = 3;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
            case R.id.layout_text_view4 /* 2131427713 */:
                this.pagenum = 4;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                this.pagenum = 0;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int mode = DataCanbus.DATA[19];
                switch (this.pagenum) {
                    case 1:
                        int mode1 = (mode >> 0) & 3;
                        if (mode1 != 2) {
                            int onoff5 = DataCanbus.DATA[40];
                            if (onoff5 == 1) {
                                onoff4 = 0;
                            } else {
                                onoff4 = 1;
                            }
                            DataCanbus.PROXY.cmd(100, new int[]{1, onoff4}, null, null);
                        }
                        break;
                    case 2:
                        int mode2 = (mode >> 2) & 3;
                        if (mode2 != 2) {
                            int onoff6 = DataCanbus.DATA[41];
                            if (onoff6 == 1) {
                                onoff3 = 0;
                            } else {
                                onoff3 = 1;
                            }
                            DataCanbus.PROXY.cmd(100, new int[]{2, onoff3}, null, null);
                        }
                        break;
                    case 3:
                        int mode3 = (mode >> 4) & 3;
                        if (mode3 != 2) {
                            int onoff7 = DataCanbus.DATA[42];
                            if (onoff7 == 1) {
                                onoff2 = 0;
                            } else {
                                onoff2 = 1;
                            }
                            DataCanbus.PROXY.cmd(100, new int[]{3, onoff2}, null, null);
                        }
                        break;
                    case 4:
                        int mode4 = (mode >> 6) & 3;
                        if (mode4 != 2) {
                            int onoff8 = DataCanbus.DATA[43];
                            if (onoff8 == 1) {
                                onoff = 0;
                            } else {
                                onoff = 1;
                            }
                            DataCanbus.PROXY.cmd(100, new int[]{4, onoff}, null, null);
                        }
                        break;
                }
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                switch (this.pagenum) {
                    case 1:
                        int onoff9 = (DataCanbus.DATA[18] >> 0) & 1;
                        int state = (DataCanbus.DATA[19] >> 0) & 3;
                        int remonoff = (DataCanbus.DATA[20] >> 0) & 1;
                        if (state != 2) {
                            DataCanbus.PROXY.cmd(0, new int[]{1, onoff9, 2, remonoff, 0}, null, null);
                        }
                        break;
                    case 2:
                        int onoff10 = (DataCanbus.DATA[18] >> 1) & 1;
                        int state2 = (DataCanbus.DATA[19] >> 2) & 3;
                        int remonoff2 = (DataCanbus.DATA[20] >> 1) & 1;
                        if (state2 != 2) {
                            DataCanbus.PROXY.cmd(0, new int[]{2, onoff10, 2, remonoff2, 0}, null, null);
                        }
                        break;
                    case 3:
                        int onoff11 = (DataCanbus.DATA[18] >> 2) & 1;
                        int state3 = (DataCanbus.DATA[19] >> 4) & 3;
                        int remonoff3 = (DataCanbus.DATA[20] >> 2) & 1;
                        if (state3 != 2) {
                            DataCanbus.PROXY.cmd(0, new int[]{3, onoff11, 2, remonoff3, 0}, null, null);
                        }
                        break;
                    case 4:
                        int onoff12 = (DataCanbus.DATA[18] >> 3) & 1;
                        int state4 = (DataCanbus.DATA[19] >> 6) & 3;
                        int remonoff4 = (DataCanbus.DATA[20] >> 3) & 1;
                        if (state4 != 2) {
                            DataCanbus.PROXY.cmd(0, new int[]{4, onoff12, 2, remonoff4, 0}, null, null);
                        }
                        break;
                }
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                switch (this.pagenum) {
                    case 1:
                        int onoff13 = (DataCanbus.DATA[18] >> 0) & 1;
                        int state5 = (DataCanbus.DATA[19] >> 0) & 3;
                        int remonoff5 = (DataCanbus.DATA[20] >> 0) & 1;
                        if (state5 != 0) {
                            DataCanbus.PROXY.cmd(0, new int[]{1, onoff13, 0, remonoff5, 0}, null, null);
                        }
                        break;
                    case 2:
                        int onoff14 = (DataCanbus.DATA[18] >> 1) & 1;
                        int state6 = (DataCanbus.DATA[19] >> 2) & 3;
                        int remonoff6 = (DataCanbus.DATA[20] >> 1) & 1;
                        if (state6 != 0) {
                            DataCanbus.PROXY.cmd(0, new int[]{2, onoff14, 0, remonoff6, 0}, null, null);
                        }
                        break;
                    case 3:
                        int onoff15 = (DataCanbus.DATA[18] >> 2) & 1;
                        int state7 = (DataCanbus.DATA[19] >> 4) & 3;
                        int remonoff7 = (DataCanbus.DATA[20] >> 2) & 1;
                        if (state7 != 0) {
                            DataCanbus.PROXY.cmd(0, new int[]{3, onoff15, 0, remonoff7, 0}, null, null);
                        }
                        break;
                    case 4:
                        int onoff16 = (DataCanbus.DATA[18] >> 3) & 1;
                        int state8 = (DataCanbus.DATA[19] >> 6) & 3;
                        int remonoff8 = (DataCanbus.DATA[20] >> 3) & 1;
                        if (state8 != 0) {
                            DataCanbus.PROXY.cmd(0, new int[]{4, onoff16, 0, remonoff8, 0}, null, null);
                        }
                        break;
                }
                break;
        }
    }

    void UpdatePagenum(int num) {
        switch (num) {
            case 1:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("AUX1");
                ((TextView) findViewById(R.id.tv_text4)).setText("Press the AUX1 button to power on/off");
                break;
            case 2:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("AUX2");
                ((TextView) findViewById(R.id.tv_text4)).setText("Press the AUX2 button to power on/off");
                break;
            case 3:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("AUX3");
                ((TextView) findViewById(R.id.tv_text4)).setText("Press the AUX3 button to power on/off");
                break;
            case 4:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("AUX4");
                ((TextView) findViewById(R.id.tv_text4)).setText("Press the AUX4 button to power on/off");
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        UpdateAUXTrigger();
        UpdateAUXState(DataCanbus.DATA[19]);
    }

    void UpdateAUXTrigger() {
        int state = 0;
        int mode1 = 0;
        int mode = DataCanbus.DATA[19];
        switch (this.pagenum) {
            case 1:
                state = DataCanbus.DATA[40];
                mode1 = (mode >> 0) & 3;
                if (state == 0) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_off);
                } else if (mode1 == 2) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_onoff);
                } else {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_on);
                }
                break;
            case 2:
                state = DataCanbus.DATA[41];
                mode1 = (mode >> 2) & 3;
                if (state == 0) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_off);
                } else if (mode1 == 2) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_onoff);
                } else {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_on);
                }
                break;
            case 3:
                state = DataCanbus.DATA[42];
                mode1 = (mode >> 4) & 3;
                if (state == 0) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_off);
                } else if (mode1 == 2) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_onoff);
                } else {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_on);
                }
                break;
            case 4:
                state = DataCanbus.DATA[43];
                mode1 = (mode >> 6) & 3;
                if (state == 0) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_off);
                } else if (mode1 == 2) {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_onoff);
                } else {
                    findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_ds_golf_on);
                }
                break;
        }
        if (state == 1 || mode1 == 2) {
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            return;
        }
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
    }

    public void UpdateAUXState(int val) {
        int state = 0;
        switch (this.pagenum) {
            case 1:
                state = (val >> 0) & 3;
                break;
            case 2:
                state = (val >> 2) & 3;
                break;
            case 3:
                state = (val >> 4) & 3;
                break;
            case 4:
                state = (val >> 6) & 3;
                break;
        }
        if (state == 0) {
            findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
            findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
        } else if (state == 2) {
            findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
            findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.pagenum = 0;
        DataCanbus.PROXY.cmd(3, new int[]{56, 255}, null, null);
        addNotify();
        UpdatePagenum(this.pagenum);
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
    }
}
