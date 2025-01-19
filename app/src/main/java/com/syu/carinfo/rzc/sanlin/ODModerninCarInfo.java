package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODModerninCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    break;
                case 125:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    break;
                case 126:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 127:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    break;
                case 128:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " RPM");
                    break;
                case 129:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    break;
                case 130:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 131:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km");
                    break;
                case 132:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " km");
                    break;
                case 133:
                    ((TextView) ODModerninCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " km");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_modernin_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{66}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }
}
