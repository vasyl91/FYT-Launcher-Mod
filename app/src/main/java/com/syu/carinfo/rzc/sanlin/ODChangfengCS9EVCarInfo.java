package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODChangfengCS9EVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "/10");
                    break;
                case 99:
                    switch (value) {
                        case 0:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("停车状态");
                            break;
                        case 1:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("驱动状态");
                            break;
                        case 2:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text2)).setText("能量回收状态");
                            break;
                    }
                case 100:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    break;
                case 101:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kmh/100km");
                    break;
                case 102:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kmh/100km");
                    break;
                case 103:
                    switch (value) {
                        case 0:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("行车状态");
                            break;
                        case 1:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("充电状态");
                            break;
                        case 2:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("快充状态");
                            break;
                        case 3:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("慢充状态");
                            break;
                        case 4:
                            ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text6)).setText("充电完成");
                            break;
                    }
                case 104:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "%");
                    break;
                case 105:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    break;
                case 106:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 107:
                    if (value == 255) {
                        ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value - 40) + " ℃");
                        break;
                    }
                case 108:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 109:
                    ((TextView) ODChangfengCS9EVCarInfo.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_changfengcs9_ev_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
