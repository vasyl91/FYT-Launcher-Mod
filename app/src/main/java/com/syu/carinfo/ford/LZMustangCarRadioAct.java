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
import com.syu.module.canbus.Callback_0452_LZ_Ford_Mustang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZMustangCarRadioAct extends Activity implements View.OnTouchListener {
    public static LZMustangCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZMustangCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    LZMustangCarRadioAct.this.updaterRadioBand();
                    break;
                case 109:
                    LZMustangCarRadioAct.this.updaterRadioFreq();
                    break;
                case 110:
                    LZMustangCarRadioAct.this.updaterRadioFreq1(Callback_0452_LZ_Ford_Mustang.RadioFrq1);
                    break;
                case 111:
                    LZMustangCarRadioAct.this.updaterRadioFreq2(Callback_0452_LZ_Ford_Mustang.RadioFrq2);
                    break;
                case 112:
                    LZMustangCarRadioAct.this.updaterRadioFreq3(Callback_0452_LZ_Ford_Mustang.RadioFrq3);
                    break;
                case 113:
                    LZMustangCarRadioAct.this.updaterRadioFreq4(Callback_0452_LZ_Ford_Mustang.RadioFrq4);
                    break;
                case 114:
                    LZMustangCarRadioAct.this.updaterRadioFreq5(Callback_0452_LZ_Ford_Mustang.RadioFrq5);
                    break;
                case 115:
                    LZMustangCarRadioAct.this.updaterRadioFreq6(Callback_0452_LZ_Ford_Mustang.RadioFrq6);
                    break;
                case 116:
                    LZMustangCarRadioAct.this.updaterRadioFreqColor();
                    break;
            }
        }
    };
    int radioband = 1;
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.ford.LZMustangCarRadioAct.2
        @Override // java.lang.Runnable
        public void run() {
            LZMustangCarRadioAct.this.num++;
            if (LZMustangCarRadioAct.this.num == 3 && LZMustangCarRadioAct.this.curnum != 0) {
                LZMustangCarRadioAct.this.mSetCurFrq(LZMustangCarRadioAct.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(LZMustangCarRadioAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(LZMustangCarRadioAct.this.mCalTime, 1000L);
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
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.LZMustangCarRadioAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZMustangCarRadioAct.this, LZMustangCarEQSet.class);
                    LZMustangCarRadioAct.this.startActivity(intent);
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
        if (DataCanbus.DATA[126] != 1) {
            DataCanbus.PROXY.cmd(1, new int[]{176, 1}, null, null);
            DataCanbus.PROXY.cmd(0, new int[]{97}, null, null);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreqColor() {
        int value = DataCanbus.DATA[116];
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
        int value = DataCanbus.DATA[109];
        switch (this.radioband) {
            case 2:
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 100) + "." + (value % 100));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        if (this.radioband != DataCanbus.DATA[107]) {
            this.radioband = DataCanbus.DATA[107];
            DataCanbus.PROXY.cmd(0, new int[]{97}, null, null);
        }
        switch (this.radioband) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 4:
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
        DataCanbus.PROXY.cmd(2, new int[]{13, value + 48}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 10}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 9}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 11}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 12}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    if (DataCanbus.DATA[107] == 0) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 1}, null, null);
                        break;
                    } else if (DataCanbus.DATA[107] == 1) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 2}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                        break;
                    }
                case R.id.lexus_radio_am /* 2131427856 */:
                    if (DataCanbus.DATA[107] == 3) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 4}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 3}, null, null);
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
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 13}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(2, new int[]{13, 13}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 33}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 34}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 35}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 36}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 37}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{13, 38}, null, null);
                        break;
                    }
            }
        }
        return false;
    }
}