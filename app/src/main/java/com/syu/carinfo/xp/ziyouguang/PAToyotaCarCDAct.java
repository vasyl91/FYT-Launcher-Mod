package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0397_BNR_XP1_VScreen_Camry2013;
import com.syu.module.canbus.DataCanbus;

public class PAToyotaCarCDAct extends BaseActivity implements View.OnTouchListener {
    int cdtype = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 214:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_rpt_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_rpt_n);
                        break;
                    }
                case 215:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_random_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_random_n);
                        break;
                    }
                case 216:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_scan_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_scan_n);
                        break;
                    }
                case 217:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_full_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_full_n);
                        break;
                    }
                case 218:
                    PAToyotaCarCDAct.this.cdtype = value;
                    if (value == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text1)).setText("DVD ");
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text1)).setText("CD");
                        break;
                    }
                case 219:
                    switch (value) {
                        case 1:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate3);
                            break;
                        case 2:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate4);
                            break;
                        case 3:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate2);
                            break;
                        case 4:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate6);
                            break;
                        case 5:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate5);
                            break;
                        case 6:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate9);
                            break;
                        case 7:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate7);
                            break;
                        default:
                            ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_playstate1);
                            break;
                    }
                case 220:
                    if (PAToyotaCarCDAct.this.cdtype == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text5)).setText("Title: " + value);
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text5)).setText("Folder: " + value);
                        break;
                    }
                case 221:
                    if (PAToyotaCarCDAct.this.cdtype == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text6)).setText("Chapter: " + value);
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text6)).setText("File: " + value);
                        break;
                    }
                case 222:
                    int hour = value / 3600;
                    int min = (value % 3600) / 60;
                    int sec = value % 60;
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 223:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text2)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDName);
                    break;
                case 243:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text3)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDFolder);
                    break;
                case 244:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text4)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDArtist);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0397_pa_toyota_carcd);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
        findViewById(R.id.btn_plus10).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 1;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 2;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 4;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 3;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 8;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 9;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                data0 = 10;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                data0 = 7;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                data0 = 11;
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                data0 = 12;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(45, new int[]{data0, 1}, null, null);
            } else if (event.getAction() == 1) {
                DataCanbus.PROXY.cmd(45, new int[]{data0}, null, null);
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
    }
}
