package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCShanqiDelongCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if ((value & 128) != 0) {
                        ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text1)).setText("-" + (value & 127) + "℃");
                        break;
                    } else {
                        ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "℃");
                        break;
                    }
                case 99:
                    if (value == 65535) {
                        ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "L/100Km");
                        break;
                    }
                case 100:
                    ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 101:
                    ((TextView) RZCShanqiDelongCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rzc_delong_carinfo);
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
        DataCanbus.PROXY.cmd(1, new int[]{96}, null, null);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
