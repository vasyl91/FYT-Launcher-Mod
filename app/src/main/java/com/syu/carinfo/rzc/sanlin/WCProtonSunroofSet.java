package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCProtonSunroofSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    switch (value) {
                        case 0:
                            WCProtonSunroofSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_proton_button_n);
                            WCProtonSunroofSet.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_proton_button_p);
                            break;
                        case 1:
                            WCProtonSunroofSet.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_proton_button_p);
                            WCProtonSunroofSet.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_proton_button_n);
                            break;
                    }
                case 155:
                    switch (value) {
                        case 0:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_0);
                            break;
                        case 1:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_1);
                            break;
                        case 2:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_2);
                            break;
                        case 3:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_3);
                            break;
                        case 4:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_4);
                            break;
                        case 5:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_5);
                            break;
                        case 6:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_6);
                            break;
                        case 7:
                            WCProtonSunroofSet.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_car_sunroof_7);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_proton_sunroof_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(74, 1, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(20, 0, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(20, 1, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value = DataCanbus.DATA[151];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(73, value, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(73, 1, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(73, 0, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{97}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
