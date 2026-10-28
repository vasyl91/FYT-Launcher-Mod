package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class KYCLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static KYCLexusRadio mInit;
    byte unit = 0;
    int band = 0;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    KYCLexusRadio.this.updateRadioBand();
                    break;
                case 141:
                    KYCLexusRadio.this.updateRadioNum();
                    break;
                case 142:
                    if (value == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 143:
                    if (value == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST");
                        break;
                    } else {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("");
                        break;
                    }
                case 144:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value));
                        break;
                    } else {
                        int value2 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value2 / 100) + "." + ((value2 % 100) / 10) + (value2 % 10));
                        break;
                    }
                case 145:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value3 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value3 / 100) + "." + (value3 % 100) + "  mhz");
                        break;
                    }
                case 146:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value4 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value4 / 100) + "." + (value4 % 100) + "  mhz");
                        break;
                    }
                case 147:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value5 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value5 / 100) + "." + (value5 % 100) + "  mhz");
                        break;
                    }
                case 148:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value6 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value6 / 100) + "." + (value6 % 100) + "  mhz");
                        break;
                    }
                case 149:
                    if (KYCLexusRadio.this.unit == 1) {
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        int value7 = value * 10;
                        ((TextView) KYCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value7 / 100) + "." + (value7 % 100) + "  mhz");
                        break;
                    }
                case 150:
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
    Runnable mCalTime = new Runnable() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_djlexus_carradio);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.btn_lexus_radio_frq1).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq2).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq3).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq4).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq5).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq6).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_scan_plus).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_scan_minu).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_next).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_am).setVisibility(8);
        findViewById(R.id.lexus_radio_fm).setVisibility(8);
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[141];
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
        int value = DataCanbus.DATA[140];
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

    
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(1, new int[]{19, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(1, new int[]{20, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21, 1}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427874 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131427876 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131427878 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131427880 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131427882 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131427884 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427874 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427876 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427878 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427880 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427882 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{16, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427884 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }
}
