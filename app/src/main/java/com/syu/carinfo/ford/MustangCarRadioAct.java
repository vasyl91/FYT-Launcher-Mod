package com.syu.carinfo.ford;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0334_RZC_XP1_Focus2015;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MustangCarRadioAct extends Activity implements View.OnTouchListener {
    public static MustangCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.MustangCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    MustangCarRadioAct.this.updaterRadioBand();
                    break;
                case 115:
                    MustangCarRadioAct.this.updaterRadioFreq();
                    break;
                case 116:
                    MustangCarRadioAct.this.updaterRadioFreq1(Callback_0334_RZC_XP1_Focus2015.RadioFrq1);
                    break;
                case 117:
                    MustangCarRadioAct.this.updaterRadioFreq2(Callback_0334_RZC_XP1_Focus2015.RadioFrq2);
                    break;
                case 118:
                    MustangCarRadioAct.this.updaterRadioFreq3(Callback_0334_RZC_XP1_Focus2015.RadioFrq3);
                    break;
                case 119:
                    MustangCarRadioAct.this.updaterRadioFreq4(Callback_0334_RZC_XP1_Focus2015.RadioFrq4);
                    break;
                case 120:
                    MustangCarRadioAct.this.updaterRadioFreq5(Callback_0334_RZC_XP1_Focus2015.RadioFrq5);
                    break;
                case 121:
                    MustangCarRadioAct.this.updaterRadioFreq6(Callback_0334_RZC_XP1_Focus2015.RadioFrq6);
                    break;
                case 131:
                    MustangCarRadioAct.this.updaterRadioFreqColor();
                    break;
            }
        }
    };
    int radioband = 1;
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.ford.MustangCarRadioAct.2
        @Override // java.lang.Runnable
        public void run() {
            MustangCarRadioAct.this.num++;
            if (MustangCarRadioAct.this.num == 3 && MustangCarRadioAct.this.curnum != 0) {
                MustangCarRadioAct.this.mSetCurFrq(MustangCarRadioAct.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(MustangCarRadioAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(MustangCarRadioAct.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;
    byte unit = 0;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_mustang_carradio);
        mInstance = this;
        init();
    }

    public void init() {
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
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.MustangCarRadioAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MustangCarRadioAct.this, MustangCarEQSet.class);
                    MustangCarRadioAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(6, new int[1], null, null);
        if (DataCanbus.DATA[113] != 1) {
            DataCanbus.PROXY.cmd(9, new int[]{169, 1}, null, null);
            DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
            DataCanbus.PROXY.cmd(0, new int[]{101}, null, null);
        }
        switch (DataCanbus.DATA[114]) {
            case 1:
                DataCanbus.PROXY.cmd(9, new int[]{169, 1}, null, null);
                DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                break;
            case 2:
                DataCanbus.PROXY.cmd(9, new int[]{169, 2}, null, null);
                DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                break;
            case 3:
                DataCanbus.PROXY.cmd(9, new int[]{169, 3}, null, null);
                DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                break;
            case 16:
                DataCanbus.PROXY.cmd(9, new int[]{169, 4}, null, null);
                DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                break;
            case 17:
                DataCanbus.PROXY.cmd(9, new int[]{169, 5}, null, null);
                DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreqColor() {
        int value = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq6(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq5(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq4(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq3(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq2(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq1(String strs) {
        ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(strs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq() {
        int value = DataCanbus.DATA[115];
        switch (this.radioband) {
            case 16:
            case 17:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 100) + "." + (value % 100));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        if (this.radioband != DataCanbus.DATA[114]) {
            this.radioband = DataCanbus.DATA[114];
            DataCanbus.PROXY.cmd(0, new int[]{101}, null, null);
        }
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 16:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 17:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am2");
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
        DataCanbus.PROXY.cmd(9, new int[]{169, value + 15}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 7}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 6}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 8}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 9}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    if (DataCanbus.DATA[114] == 1) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 2}, null, null);
                        break;
                    } else if (DataCanbus.DATA[114] == 2) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 3}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 1}, null, null);
                        break;
                    }
                case R.id.lexus_radio_am /* 2131427856 */:
                    if (DataCanbus.DATA[114] == 16) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 5}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 4}, null, null);
                        break;
                    }
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
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131427856 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 10}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 11}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 12}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 13}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 14}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 15}, null, null);
                    }
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
            }
        }
        return false;
    }
}