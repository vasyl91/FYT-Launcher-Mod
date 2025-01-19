package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WCTataAllCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    if (value % 10 == 0) {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 127:
                    if (value % 10 == 0) {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 128:
                    if (value % 10 == 0) {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
                case 129:
                    if (value % 10 == 0) {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text4)).setText(value / 10 + "/5");
                        break;
                    } else {
                        ((TextView) WCTataAllCarInfo.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + "/5");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_tata_cur_carinfo);
        ((TextView) findViewById(R.id.tv_text5)).setText("All");
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }
}
