package com.syu.carinfo.od.ford.falcon;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class FordFalconCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                case 114:
                    FordFalconCarInfo.this.updateCarinfo1();
                    break;
                case 115:
                    FordFalconCarInfo.this.updateCarinfo2();
                    break;
                case 116:
                    FordFalconCarInfo.this.updateCarinfo3();
                    break;
                case 117:
                    FordFalconCarInfo.this.updateCarinfo4();
                    break;
                case 118:
                    FordFalconCarInfo.this.updateCarinfo5();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_od_falcon_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[118];
        ((TextView) findViewById(R.id.tv_text5)).setText(value + " Km");
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[117];
        ((TextView) findViewById(R.id.tv_text4)).setText(value + " Km/H");
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[116] & 31;
        int unit = (DataCanbus.DATA[116] >> 5) & 1;
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " L/H");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[115] & 31;
        int unit = (DataCanbus.DATA[115] >> 5) & 1;
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " L/H");
                break;
        }
    }

    
    public void updateCarinfo1() {
        int hour = DataCanbus.DATA[113];
        int minute = DataCanbus.DATA[114];
        ((TextView) findViewById(R.id.tv_text1)).setText(hour + ":" + minute);
    }
}
