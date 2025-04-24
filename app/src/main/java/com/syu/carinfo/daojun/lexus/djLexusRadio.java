package com.syu.carinfo.daojun.lexus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class djLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djLexusRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    djLexusRadio.this.updateRadioBand();
                    break;
                case 99:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 10) + "." + (value % 10));
                        break;
                    }
                case 100:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 101:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 102:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 103:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 104:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 105:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
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
            djLexusRadio.this.num++;
            if (djLexusRadio.this.num == 3 && djLexusRadio.this.curnum != 0) {
                djLexusRadio.this.mSetCurFrq(djLexusRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(djLexusRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(djLexusRadio.this.mCalTime, 1000L);
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
        findViewById(R.id.lexus_radio_fm).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_am).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djLexusRadio.this, djLexusAudio.class);
                    djLexusRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[98];
        switch (value) {
            case 1:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 17:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
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
        DataCanbus.PROXY.cmd(12, new int[]{3, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(1, new int[]{9, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{17, 1}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427871 */:
                    DataCanbus.PROXY.cmd(1, new int[]{5, 1}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427872 */:
                    DataCanbus.PROXY.cmd(1, new int[]{4, 1}, null, null);
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
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(1, new int[]{9}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(1, new int[]{8}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(1, new int[]{16}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(1, new int[]{17}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427871 */:
                    DataCanbus.PROXY.cmd(1, new int[]{5}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427872 */:
                    DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427874 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value = 5;
                        if (this.unit == 1) {
                            value = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427876 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value2 = 5;
                        if (this.unit == 1) {
                            value2 = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value2, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427878 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value3 = 5;
                        if (this.unit == 1) {
                            value3 = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value3, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427880 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value4 = 5;
                        if (this.unit == 1) {
                            value4 = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value4, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427882 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value5 = 5;
                        if (this.unit == 1) {
                            value5 = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value5, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427884 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value6 = 5;
                        if (this.unit == 1) {
                            value6 = 4;
                        }
                        DataCanbus.PROXY.cmd(12, new int[]{value6, 6}, null, null);
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
        DataCanbus.PROXY.cmd(1, new int[]{5, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{5}, null, null);
            }
        }, 100L);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
            }
        }, 50L);
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
            DataCanbus.PROXY.cmd(14, new int[1], null, null);
            finish();
        }
        return true;
    }
}
