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

public class PAToyotaXMRadioAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 224:
                    if (value == 1) {
                        PAToyotaXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_scan_p);
                        break;
                    } else {
                        PAToyotaXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_scan_n);
                        break;
                    }
                case 225:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text1)).setText("SAT " + value);
                    break;
                case 226:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text2)).setText("CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 227:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text13)).setText("1.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 228:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text14)).setText("2.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 229:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text15)).setText("3.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 230:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text16)).setText("4.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 231:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text17)).setText("5.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 232:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text18)).setText("6.     CH" + (value / 100) + ((value % 100) / 10) + (value % 10));
                    break;
                case 233:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text3)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMName);
                    break;
                case 234:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text4)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMTitle);
                    break;
                case 235:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text5)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCategory);
                    break;
                case 236:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text6)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMStatus);
                    break;
                case 237:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text7)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH1);
                    break;
                case 238:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text8)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH2);
                    break;
                case 239:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text9)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH3);
                    break;
                case 240:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text10)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH4);
                    break;
                case 241:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text11)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH5);
                    break;
                case 242:
                    ((TextView) PAToyotaXMRadioAct.this.findViewById(R.id.tv_text12)).setText(Callback_0397_BNR_XP1_VScreen_Camry2013.XMCH6);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0397_pa_toyota_xmradio);
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
        findViewById(R.id.btn_plus11).setOnTouchListener(this);
        findViewById(R.id.btn_plus12).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 2;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 3;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 1;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 13;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 14;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text13)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text7)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text13)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text7)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 4;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text14)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text8)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text14)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text8)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 5;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text15)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text9)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text15)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text9)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 6;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text16)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text10)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text16)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text10)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 7;
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text17)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text11)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text17)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text11)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 8;
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                if (event.getAction() == 0) {
                    ((TextView) findViewById(R.id.tv_text18)).setTextColor(Color.parseColor("#666666"));
                    ((TextView) findViewById(R.id.tv_text12)).setTextColor(Color.parseColor("#666666"));
                } else if (event.getAction() == 1) {
                    ((TextView) findViewById(R.id.tv_text18)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text12)).setTextColor(Color.parseColor("#ffffff"));
                }
                data0 = 9;
                break;
            case R.id.btn_plus12 /* 2131427490 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
    }
}
