package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCSuzukiCarInfo1 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                case 105:
                    int unit = DataCanbus.DATA[105];
                    int value = DataCanbus.DATA[98];
                    switch (unit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " l/100km");
                            break;
                    }
                case 99:
                case 103:
                    int unit2 = DataCanbus.DATA[103];
                    int value2 = DataCanbus.DATA[99];
                    switch (unit2) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " l/100km");
                            break;
                    }
                case 100:
                case 101:
                    int unit3 = DataCanbus.DATA[101];
                    int value3 = DataCanbus.DATA[100];
                    switch (unit3) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value3) + " km");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value3) + " mil");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_rzc_suzuki_carinfo1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{51, 1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
