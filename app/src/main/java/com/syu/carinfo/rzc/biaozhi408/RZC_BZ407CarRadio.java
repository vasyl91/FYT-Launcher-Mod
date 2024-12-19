package com.syu.carinfo.rzc.biaozhi408;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ407CarRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static RZC_BZ407CarRadio mInit;
    int rdtest = 0;
    int rds = 0;
    int ta = 0;
    int reg = 0;
    int value = 0;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 200:
                    RZC_BZ407CarRadio.this.updateRadioBand();
                    break;
                case 201:
                    if (RZC_BZ407CarRadio.this.unit == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 202:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text1)).setText("RDTEST： ON");
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text1)).setText("RDTEST： OFF");
                        break;
                    }
                case 203:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text2)).setText("RDS： ON");
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text2)).setText("RDS： OFF");
                        break;
                    }
                case 204:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text3)).setText("TA： ON");
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text3)).setText("TA： OFF");
                        break;
                    }
                case 205:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text5)).setText("REG： ON");
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text5)).setText("REG： OFF");
                        break;
                    }
                case 214:
                    ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text4)).setText(Const_RZC4_PSA_ALL_DATA.RadioText);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_407_carradio);
        mInit = this;
        findViewById(R.id.tv_text1).setOnTouchListener(this);
        findViewById(R.id.tv_text2).setOnTouchListener(this);
        findViewById(R.id.tv_text3).setOnTouchListener(this);
        findViewById(R.id.tv_text5).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_text1 /* 2131427481 */:
                if (this.rdtest == 1) {
                    this.rdtest = 0;
                    break;
                } else {
                    this.rdtest = 1;
                    break;
                }
            case R.id.tv_text2 /* 2131427485 */:
                if (this.rds == 1) {
                    this.rds = 0;
                    break;
                } else {
                    this.rds = 1;
                    break;
                }
            case R.id.tv_text3 /* 2131427489 */:
                if (this.ta == 1) {
                    this.ta = 0;
                    break;
                } else {
                    this.ta = 1;
                    break;
                }
            case R.id.tv_text5 /* 2131427497 */:
                if (this.reg == 1) {
                    this.reg = 0;
                    break;
                } else {
                    this.reg = 1;
                    break;
                }
        }
        this.value = ((this.rdtest << 3) & 8) | ((this.rds << 2) & 4) | ((this.ta << 1) & 2) | (this.reg & 1);
        if (event.getAction() == 0) {
            sendCmd(DataCanbus.DATA[199], this.value);
        }
        return false;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(90, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
        if (DataCanbus.DATA[199] != 1) {
            sendCmd(1, this.value);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        this.rdtest = DataCanbus.DATA[202];
        this.rds = DataCanbus.DATA[203];
        this.ta = DataCanbus.DATA[204];
        this.reg = DataCanbus.DATA[205];
        this.value = ((this.rdtest << 3) & 8) | ((this.rds << 2) & 4) | ((this.ta << 1) & 2) | (this.reg & 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[200];
        switch (value) {
            case 1:
            case 2:
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }
}
