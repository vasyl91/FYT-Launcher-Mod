package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCTataTripBCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 123:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 124:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 125:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text4)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_tata_cur_carinfo);
        ((TextView) findViewById(R.id.tv_text5)).setText("Trip B");
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }
}
