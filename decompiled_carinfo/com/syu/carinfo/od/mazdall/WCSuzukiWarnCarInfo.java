package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCSuzukiWarnCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn1_p : R.drawable.ic_suzuki_warn1_n);
                    break;
                case 159:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn2_p : R.drawable.ic_suzuki_warn2_n);
                    break;
                case 160:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn3_p : R.drawable.ic_suzuki_warn3_n);
                    break;
                case 161:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view4).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn4_p : R.drawable.ic_suzuki_warn4_n);
                    break;
                case 162:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn5_p : R.drawable.ic_suzuki_warn5_n);
                    break;
                case 163:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view6).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn6_p : R.drawable.ic_suzuki_warn6_n);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_suzuki_warn_carinfo);
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

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
    }
}
