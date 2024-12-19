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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAToyotaCarCDAct extends BaseActivity implements View.OnTouchListener {
    int cdtype = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAToyotaCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 191:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_rpt_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_rpt_n);
                        break;
                    }
                case 192:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_random_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_random_n);
                        break;
                    }
                case 193:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_scan_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_scan_n);
                        break;
                    }
                case 194:
                    if (value == 1) {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_full_p);
                        break;
                    } else {
                        PAToyotaCarCDAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_carcd_full_n);
                        break;
                    }
                case 195:
                    PAToyotaCarCDAct.this.cdtype = value;
                    if (value == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text1)).setText("DVD ");
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text1)).setText("CD");
                        break;
                    }
                case 196:
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
                case 197:
                    if (PAToyotaCarCDAct.this.cdtype == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text5)).setText("Title: " + value);
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text5)).setText("Folder: " + value);
                        break;
                    }
                case 198:
                    if (PAToyotaCarCDAct.this.cdtype == 1) {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text6)).setText("Chapter: " + value);
                        break;
                    } else {
                        ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text6)).setText("File: " + value);
                        break;
                    }
                case 199:
                    int hour = value / 3600;
                    int min = (value % 3600) / 60;
                    int sec = value % 60;
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 200:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text2)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDName);
                    break;
                case 221:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text3)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDFolder);
                    break;
                case 222:
                    ((TextView) PAToyotaCarCDAct.this.findViewById(R.id.tv_text4)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.CDArtist);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0397_pa_toyota_carcd);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427482 */:
                data0 = 1;
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                data0 = 2;
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                data0 = 4;
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                data0 = 3;
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                data0 = 8;
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                data0 = 9;
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                data0 = 10;
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                data0 = 7;
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                data0 = 11;
                break;
            case R.id.btn_plus10 /* 2131427519 */:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
    }
}
