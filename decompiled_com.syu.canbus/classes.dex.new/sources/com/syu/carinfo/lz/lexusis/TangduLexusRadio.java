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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TangduLexusRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static TangduLexusRadio mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    TangduLexusRadio.this.updateRadioBand();
                    break;
                case 136:
                    TangduLexusRadio.this.updateRadioNum();
                    break;
                case 137:
                    if (value == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                    }
                    break;
                case 138:
                    if (value == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("");
                    }
                    break;
                case 139:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 100) + "." + ((value % 100) / 10) + (value % 10));
                    }
                    break;
                case 140:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
                case 141:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
                case 142:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
                case 143:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
                case 144:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
                case 145:
                    if (TangduLexusRadio.this.unit == 1) {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                    } else {
                        ((TextView) TangduLexusRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                    }
                    break;
            }
        }
    };
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusRadio.2
        @Override // java.lang.Runnable
        public void run() {
            TangduLexusRadio.this.num++;
            if (TangduLexusRadio.this.num == 3 && TangduLexusRadio.this.curnum != 0) {
                TangduLexusRadio.this.mSetCurFrq(TangduLexusRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(TangduLexusRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(TangduLexusRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
                setContentView(R.layout.layout_djlexus_carradio_yl);
                break;
            default:
                setContentView(R.layout.layout_djlexus_carradio);
                break;
        }
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
        ((Button) findViewById(R.id.lexus_cd_skipb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_skipf)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_fm)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_am)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_toaudio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(TangduLexusRadio.this, TangduLexusCarSet.class);
                    TangduLexusRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[136];
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
        int value = DataCanbus.DATA[135];
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
        DataCanbus.PROXY.cmd(2, new int[]{33, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131428050 */:
                    DataCanbus.PROXY.cmd(2, new int[]{35, 0}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428053 */:
                    DataCanbus.PROXY.cmd(2, new int[]{34, 0}, null, null);
                    break;
                case R.id.lexus_radio_prev /* 2131428056 */:
                    DataCanbus.PROXY.cmd(2, new int[]{38, 0}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131428057 */:
                    DataCanbus.PROXY.cmd(2, new int[]{37, 0}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131428059 */:
                    DataCanbus.PROXY.cmd(2, new int[]{36, 0}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131428061 */:
                    int value = DataCanbus.DATA[135];
                    if (value > 0 && value < 3) {
                        value++;
                        if (value > 2) {
                            value = 1;
                        }
                    } else if (value == 16 || value == 17 || value == 18) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{48, value}, null, null);
                    break;
                case R.id.lexus_radio_am /* 2131428062 */:
                    int value2 = DataCanbus.DATA[135];
                    if (value2 >= 16 && value2 <= 18) {
                        if (value2 + 1 > 18) {
                        }
                    } else if (value2 == 0 || value2 == 1 || value2 == 2) {
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{48, 3}, null, null);
                    break;
                case R.id.btn_lexus_radio_frq1 /* 2131428064 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131428066 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131428068 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131428070 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131428072 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131428074 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_lexus_radio_frq1 /* 2131428064 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 1}, null, null);
                    }
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131428066 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 2}, null, null);
                    }
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131428068 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 3}, null, null);
                    }
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131428070 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 4}, null, null);
                    }
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131428072 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 5}, null, null);
                    }
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131428074 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 6}, null, null);
                    }
                    break;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(2, new int[]{48, 1}, null, null);
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
            DataCanbus.PROXY.cmd(2, new int[]{48, 5}, null, null);
            finish();
            return true;
        }
        return true;
    }
}
