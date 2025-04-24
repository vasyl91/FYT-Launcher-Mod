package com.syu.carinfo.bagu.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BaguBmwCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    BaguBmwCarInfo.this.mUpdateTx1();
                    break;
                case 9:
                    BaguBmwCarInfo.this.mUpdateTx2();
                    break;
                case 10:
                case 13:
                    BaguBmwCarInfo.this.mUpdateTx3();
                    break;
                case 11:
                    BaguBmwCarInfo.this.mUpdateTx1();
                    BaguBmwCarInfo.this.mUpdateTx2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0386_bagu_bmw_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateTx1() {
        int value = DataCanbus.DATA[8];
        int unit = DataCanbus.DATA[11];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " mls");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
        }
    }

    
    public void mUpdateTx2() {
        int value = DataCanbus.DATA[9];
        int unit = DataCanbus.DATA[13];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text2)).setText("--.--");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mls/h");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
        }
    }

    
    public void mUpdateTx3() {
        int value = DataCanbus.DATA[10];
        int unit = DataCanbus.DATA[11];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text3)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                break;
        }
    }
}
