package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GmAndraCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 178:
                case 180:
                    GmAndraCarInfo.this.updateCarinfo1();
                    break;
                case 179:
                case 183:
                    GmAndraCarInfo.this.updateCarinfo2();
                    break;
                case 184:
                case 197:
                    GmAndraCarInfo.this.updateCarinfo3();
                    break;
                case 200:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 201:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    break;
                case 202:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " L");
                    break;
                case 203:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 204:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " kPa");
                    break;
                case 205:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 206:
                    ((TextView) GmAndraCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value - 40) + " ℃");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_andra_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{74, 2}, null, null);
        DataCanbus.PROXY.cmd(11, new int[]{74, 4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[197];
        int unit = DataCanbus.DATA[184];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
            return;
        }
        if (unit == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " gal/h");
        } else if (unit == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " gal/m");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/h");
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[179];
        int unit = DataCanbus.DATA[183];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[178];
        int unit = DataCanbus.DATA[180];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
        }
    }
}
