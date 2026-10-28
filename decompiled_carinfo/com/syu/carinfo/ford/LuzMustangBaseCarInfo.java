package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuzMustangBaseCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 174:
                case 176:
                case 177:
                    int unit = DataCanbus.DATA[174];
                    int range = DataCanbus.DATA[176];
                    int mile = DataCanbus.DATA[177];
                    if (unit == 1) {
                        ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(range) + "miles");
                        ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(mile) + "miles");
                        break;
                    } else {
                        ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(range) + "km");
                        ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(mile) + "km");
                        break;
                    }
                case 183:
                    ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 184:
                    ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 185:
                    ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "L");
                    break;
                case 186:
                    ((TextView) LuzMustangBaseCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_mustang_base_carinfo);
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
        v.getId();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{41, 2}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{41, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
    }
}
