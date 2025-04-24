package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BmwCarLogAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    BmwCarLogAct.this.updatexushilicheng();
                    break;
                case 9:
                    BmwCarLogAct.this.updatepingjunSpeed();
                    break;
                case 10:
                    BmwCarLogAct.this.updatepingjunOil();
                    break;
                case 11:
                    BmwCarLogAct.this.updatexushilicheng();
                    BmwCarLogAct.this.updatepingjunSpeed();
                    break;
                case 12:
                    BmwCarLogAct.this.updatepingjunOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_haozheng_bmw_car_log);
        init();
    }

    @Override
    public void init() {
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    
    public void updatexushilicheng() {
        int licheng = DataCanbus.DATA[8];
        int JuliUnit = DataCanbus.DATA[11];
        if (JuliUnit == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_xushi_licheng_tv)).setText(String.valueOf(licheng) + "mls");
        } else if (JuliUnit == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_xushi_licheng_tv)).setText(String.valueOf(licheng) + "km");
        }
    }

    
    public void updatepingjunSpeed() {
        int speed = DataCanbus.DATA[9];
        int oilUnit = DataCanbus.DATA[11];
        if (oilUnit == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_speed_tv)).setText(String.valueOf(speed / 10.0f) + " mls/h");
        } else if (oilUnit == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_speed_tv)).setText(String.valueOf(speed / 10.0f) + " km/h");
        }
    }

    
    public void updatepingjunOil() {
        int oil = DataCanbus.DATA[10];
        int oilUnit = DataCanbus.DATA[12];
        if (oilUnit == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_oil_tv)).setText(String.valueOf(oil / 10.0f) + " l/100km");
            return;
        }
        if (oilUnit == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_oil_tv)).setText(String.valueOf(oil / 10.0f) + " mpg(US)");
        } else if (oilUnit == 2) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_oil_tv)).setText(String.valueOf(oil / 10.0f) + " mpg(UK)");
        } else if (oilUnit == 3) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_oil_tv)).setText(String.valueOf(oil / 10.0f) + " km/l");
        }
    }
}
