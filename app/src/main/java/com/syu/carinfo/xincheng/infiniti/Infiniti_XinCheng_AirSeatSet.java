package com.syu.carinfo.xincheng.infiniti;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Infiniti_XinCheng_AirSeatSet extends Activity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_AirSeatSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 85:
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
                case 86:
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
                case 87:
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
                case 88:
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xincheng_infiniti_airseat_settings);
        init();
    }

    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                data0 = 11;
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                data0 = 13;
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                data0 = 64;
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
    }
}
