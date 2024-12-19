package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KYCLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static KYCLexusRadio mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.KYCLexusRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 128:
                    KYCLexusRadio.this.updateRadioBand();
                    break;
                case 129:
                    KYCLexusRadio.this.updateRadioNum();
                    break;
                case 130:
                    if (value == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 131:
                    if (value == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST");
                        break;
                    } else {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("");
                        break;
                    }
                case 132:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        int value2 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value2 / 100) + "." + ((value2 % 100) / 10) + (value2 % 10));
                        break;
                    }
                case 133:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value3 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value3 / 100) + "." + (value3 % 100) + "  mhz");
                        break;
                    }
                case 134:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value4 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value4 / 100) + "." + (value4 % 100) + "  mhz");
                        break;
                    }
                case 135:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value5 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value5 / 100) + "." + (value5 % 100) + "  mhz");
                        break;
                    }
                case 136:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value6 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value6 / 100) + "." + (value6 % 100) + "  mhz");
                        break;
                    }
                case 137:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value7 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value7 / 100) + "." + (value7 % 100) + "  mhz");
                        break;
                    }
                case 138:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value8 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value8 / 100) + "." + (value8 % 100) + "  mhz");
                        break;
                    }
            }
        }
    };
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.lz.lexusis.KYCLexusRadio.2
        @Override // java.lang.Runnable
        public void run() {
            KYCLexusRadio.this.num++;
            if (KYCLexusRadio.this.num == 3 && KYCLexusRadio.this.curnum != 0) {
                KYCLexusRadio.this.mSetCurFrq(KYCLexusRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(KYCLexusRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(KYCLexusRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_carradio);
        init();
    }

    public void init() {
        mInit = this;
        ((Button) findViewById(R.id.btn_lexus_radio_frq1)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_radio_frq2)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_radio_frq3)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_radio_frq4)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_radio_frq5)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_radio_frq6)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_scan_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_scan_minu)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_next)).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_am).setVisibility(8);
        findViewById(R.id.lexus_radio_fm).setVisibility(8);
        ((Button) findViewById(R.id.lexus_radio_toaudio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.KYCLexusRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KYCLexusRadio.this, KYCToyotaAllCarSet.class);
                    KYCLexusRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[129];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-65536);
                break;
        }
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[128];
        switch (value) {
            case 0:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                return;
            case 16:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            case 17:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            case 18:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                return;
            default:
                return;
        }
        this.unit = (byte) 0;
        ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
        ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.num = 0;
            this.flag = false;
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(1, new int[]{19, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(1, new int[]{20, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21, 1}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 6}, null, null);
                        break;
                    }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }
}
