package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
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
public class PAToyotaXMRadioAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAToyotaXMRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 201:
                    if (value == 1) {
                        PAToyotaXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_scan_p);
                        break;
                    } else {
                        PAToyotaXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_scan_n);
                        break;
                    }
                case 202:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text1)).setText("SAT " + value);
                    break;
                case 203:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text2)).setText("CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 204:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text13)).setText("1.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 205:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text14)).setText("2.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 206:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text15)).setText("3.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 207:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text16)).setText("4.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 208:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text17)).setText("5.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 209:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text18)).setText("6.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 210:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text3)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMName);
                    break;
                case 211:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text4)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMTitle);
                    break;
                case 212:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text5)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCategory);
                    break;
                case 213:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text6)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMStatus);
                    break;
                case 215:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text7)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH1);
                    break;
                case 216:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text8)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH2);
                    break;
                case 217:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text9)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH3);
                    break;
                case 218:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text10)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH4);
                    break;
                case 219:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text11)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH5);
                    break;
                case 220:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text12)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH6);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0397_pa_toyota_xmradio);
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
        findViewById(R.id.btn_plus11).setOnTouchListener(this);
        findViewById(R.id.btn_plus12).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427482 */:
                data0 = 2;
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                data0 = 3;
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                data0 = 1;
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                data0 = 13;
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                data0 = 14;
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text13)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text7)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text13)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text7)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 4;
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text14)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text8)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text14)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text8)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 5;
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text15)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text9)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text15)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text9)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 6;
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text16)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text10)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text16)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text10)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 7;
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text17)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text11)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text17)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text11)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 8;
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text18)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text12)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text18)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text12)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 9;
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                data0 = 10;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(43, new int[]{data0, 1}, null, null);
            } else if (event.getAction() == 1) {
                DataCanbus.PROXY.cmd(43, new int[]{data0}, null, null);
            }
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
    }
}
