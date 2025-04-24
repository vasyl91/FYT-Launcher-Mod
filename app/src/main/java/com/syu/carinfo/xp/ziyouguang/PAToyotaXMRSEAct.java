package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAToyotaXMRSEAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 253:
                    if (value == 0) {
                        ((TextView) PAToyotaXMRSEAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        ((TextView) PAToyotaXMRSEAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 254:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 255:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 256:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 257:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 258:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
                case 259:
                    if (value == 1) {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        break;
                    } else {
                        ((Button) PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                        PAToyotaXMRSEAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0397_pa_toyota_rse);
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
                data0 = 3;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 4;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 5;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 6;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(46, new int[]{data0, 1}, null, null);
            } else if (event.getAction() == 1) {
                DataCanbus.PROXY.cmd(46, new int[]{data0}, null, null);
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(17);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
    }
}
