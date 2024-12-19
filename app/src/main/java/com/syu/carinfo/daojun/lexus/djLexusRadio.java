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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djLexusRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.lexus.djLexusRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                    djLexusRadio.this.updateRadioBand();
                    break;
                case 20:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 10) + "." + (value % 10));
                        break;
                    }
                case 21:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 22:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 23:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 24:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 25:
                    if (djLexusRadio.this.unit == 1) {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) djLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 10) + "." + (value % 10) + "  mhz");
                        break;
                    }
                case 26:
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
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusRadio.2
        @Override // java.lang.Runnable
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_carradio);
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
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusRadio.3
            @Override // android.view.View.OnClickListener
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
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[19];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(1, new int[]{9, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(1, new int[]{17, 1}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    DataCanbus.PROXY.cmd(1, new int[]{5, 1}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427856 */:
                    DataCanbus.PROXY.cmd(1, new int[]{4, 1}, null, null);
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
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(1, new int[]{9}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(1, new int[]{8}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(1, new int[]{16}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(1, new int[]{17}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    DataCanbus.PROXY.cmd(1, new int[]{5}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427856 */:
                    DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value = 5;
                        if (this.unit == 1) {
                            value = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value2 = 5;
                        if (this.unit == 1) {
                            value2 = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value2, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value3 = 5;
                        if (this.unit == 1) {
                            value3 = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value3, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value4 = 5;
                        if (this.unit == 1) {
                            value4 = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value4, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value5 = 5;
                        if (this.unit == 1) {
                            value5 = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value5, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        int value6 = 5;
                        if (this.unit == 1) {
                            value6 = 4;
                        }
                        DataCanbus.PROXY.cmd(3, new int[]{value6, 6}, null, null);
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
        DataCanbus.PROXY.cmd(1, new int[]{5, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusRadio.4
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{5}, null, null);
            }
        }, 100L);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusRadio.5
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
            }
        }, 50L);
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
            DataCanbus.PROXY.cmd(5, new int[1], null, null);
            finish();
        }
        return true;
    }
}
