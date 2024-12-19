package com.syu.carinfo.xc.tule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCTuleCDCarRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XCTuleCDCarRadio mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.tule.XCTuleCDCarRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    if (value == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 101:
                    XCTuleCDCarRadio.this.updateRadioBand();
                    break;
                case 102:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 100) + "." + ((value % 100) / 10) + (value % 10));
                        break;
                    }
                case 103:
                    XCTuleCDCarRadio.this.updateRadioNum();
                    break;
                case 104:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 105:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 106:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 107:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 108:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 109:
                    if (XCTuleCDCarRadio.this.unit == 1) {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) XCTuleCDCarRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
            }
        }
    };
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xc.tule.XCTuleCDCarRadio.2
        @Override // java.lang.Runnable
        public void run() {
            XCTuleCDCarRadio.this.num++;
            if (XCTuleCDCarRadio.this.num == 1 && XCTuleCDCarRadio.this.curnum != 0) {
                XCTuleCDCarRadio.this.mSetCurFrq(XCTuleCDCarRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(XCTuleCDCarRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(XCTuleCDCarRadio.this.mCalTime, 1000L);
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
        ((Button) findViewById(R.id.lexus_radio_fm)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_am)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_toaudio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.tule.XCTuleCDCarRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCTuleCDCarRadio.this, XCTuleCDCarSet.class);
                    XCTuleCDCarRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[103];
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
        int value = DataCanbus.DATA[101];
        switch (value) {
            case 1:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
            case 3:
            default:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
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
        DataCanbus.PROXY.cmd(9, new int[]{11, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(9, new int[]{4, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(9, new int[]{3, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(9, new int[]{1, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(9, new int[]{2, 1}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    int value = DataCanbus.DATA[101];
                    if (value == 3) {
                        DataCanbus.PROXY.cmd(9, new int[]{6, 4}, null, null);
                        break;
                    } else if (value == 4) {
                        DataCanbus.PROXY.cmd(9, new int[]{6, 3}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{5, 2}, null, null);
                        break;
                    }
                case R.id.lexus_radio_am /* 2131427856 */:
                    DataCanbus.PROXY.cmd(9, new int[]{6, 1}, null, null);
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
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{12, 6}, null, null);
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
        if (DataCanbus.DATA[117] != 1) {
            DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
