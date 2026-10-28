package com.syu.carinfo.xincheng.infiniti;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Infiniti_XinCheng_AirSeatSet extends Activity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                            case 4:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 30:
                    if (((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                            case 4:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_AirSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_airseat_settings);
        init();
    }

    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                data0 = 11;
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                data0 = 13;
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                data0 = 64;
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                data0 = 65;
                break;
        }
        if (event.getAction() == 0) {
            setCarInfo(data0, 1);
        } else if (event.getAction() == 1) {
            setCarInfo(data0, 0);
        }
        return false;
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }
}
