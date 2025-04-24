package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LzNissan05CimaCarInfo extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 100:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " mph");
                        break;
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
                        break;
                    }
                case 101:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 103:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 105:
                    LzNissan05CimaCarInfo.this.unit = value;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_lz_nissan_05cima_carinfo);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{55}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
