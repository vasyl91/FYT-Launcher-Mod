package com.syu.carinfo.xc.lexus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class XCLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XCLexusRadio mInit;
    protected Handler mHandler;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    XCLexusRadio.this.updateRadioBand();
                    break;
                case 124:
                    if (value == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("");
                        break;
                    }
                case 125:
                    if (value == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 126:
                    XCLexusRadio.this.updateRadioNum();
                    break;
                case 127:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 100) + "." + ((value % 100) / 10) + (value % 10));
                        break;
                    }
                case 128:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 129:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 130:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 131:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 132:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 133:
                    if (XCLexusRadio.this.unit == 1) {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
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
            XCLexusRadio.this.num++;
            if (XCLexusRadio.this.num == 1 && XCLexusRadio.this.curnum != 0) {
                XCLexusRadio.this.mSetCurFrq(XCLexusRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(XCLexusRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(XCLexusRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xincheng_lexus_carradio);
        this.mHandler = new Handler(Looper.getMainLooper());
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
        ((Button) findViewById(R.id.lexus_radio_fm)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_am)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_toaudio)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusRadio.this, XCLexusAudio.class);
                    XCLexusRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[126];
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
        int value = DataCanbus.DATA[123];
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
        DataCanbus.PROXY.cmd(1, new int[]{32, value + 128}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(1, new int[]{34, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(1, new int[]{35, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{35, 2}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{34, 2}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427871 */:
                    DataCanbus.PROXY.cmd(1, new int[]{28}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427872 */:
                    int value = DataCanbus.DATA[123];
                    if (value != 16) {
                        DataCanbus.PROXY.cmd(1, new int[]{28}, null, null);
                        break;
                    }
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
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(1, new int[]{34}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(1, new int[]{35}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{35}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{34}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427874 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 1}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131427876 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 2}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131427878 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 3}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131427880 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 4}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131427882 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 5}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131427884 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(1, new int[]{32, 6}, null, null);
                    }
                    this.mHandler.postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(1, new int[]{32}, null, null);
                        }
                    }, 100L);
                    break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(0, new int[2], null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
