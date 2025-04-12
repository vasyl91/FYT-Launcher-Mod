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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

public class LuzLexusISRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LuzLexusISRadio mInit;
    byte unit = 0;
    int band = 0;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    LuzLexusISRadio.this.updateRadioBand();
                    break;
                case 116:
                    LuzLexusISRadio.this.updateRadioNum();
                    break;
                case 117:
                    if (value == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_scan)).setText("");
                        break;
                    }
                case 118:
                    if (value == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("ST");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_st)).setText("");
                        break;
                    }
                case 119:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value));
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 100) + "." + ((value % 100) / 10) + (value % 10));
                        break;
                    }
                case 120:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 121:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 122:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 123:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 124:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
                        break;
                    }
                case 125:
                    if (LuzLexusISRadio.this.unit == 1) {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + value + "  khz");
                        break;
                    } else {
                        ((TextView) LuzLexusISRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("   " + (value / 100) + "." + (value % 100) + "  mhz");
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
            LuzLexusISRadio.this.num++;
            if (LuzLexusISRadio.this.num == 3 && LuzLexusISRadio.this.curnum != 0) {
                LuzLexusISRadio.this.mSetCurFrq(LuzLexusISRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(LuzLexusISRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(LuzLexusISRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                //setContentView(R.layout.layout_djlexus_carradio_cg);
                break;
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                //setContentView(R.layout.layout_djlexus_carradio_yl);
                break;
            default:
                //setContentView(R.layout.layout_djlexus_carradio);
                break;
        }
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
                    intent.setClass(LuzLexusISRadio.this, LZLexusISCarSet.class);
                    LuzLexusISRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }

    public void updateRadioNum() {
        int value = DataCanbus.DATA[116];
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
        int value = DataCanbus.DATA[115];
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
        DataCanbus.PROXY.cmd(2, new int[]{33, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(2, new int[]{38}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(2, new int[]{37}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427869 */:
                    DataCanbus.PROXY.cmd(2, new int[]{34}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427870 */:
                    DataCanbus.PROXY.cmd(2, new int[]{35}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427871 */:
                    int value = DataCanbus.DATA[115];
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
                case R.id.lexus_radio_am /* 2131427872 */:
                    int value2 = DataCanbus.DATA[115];
                    if (value2 >= 16 && value2 <= 18) {
                        if (value2 + 1 > 18) {
                        }
                    } else if (value2 == 0 || value2 == 1 || value2 == 2) {
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{48, 3}, null, null);
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
                case R.id.btn_lexus_radio_frq1 /* 2131427874 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427876 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427878 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427880 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427882 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427884 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{32, 6}, null, null);
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
        DataCanbus.PROXY.cmd(2, new int[]{48, 1}, null, null);
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
            DataCanbus.PROXY.cmd(2, new int[]{48, 5}, null, null);
            finish();
            return true;
        }
        return true;
    }
}
