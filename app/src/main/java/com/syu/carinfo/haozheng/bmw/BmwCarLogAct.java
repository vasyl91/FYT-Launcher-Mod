package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BmwCarLogAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwCarLogAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    BmwCarLogAct.this.updatexushilicheng();
                    break;
                case 2:
                    BmwCarLogAct.this.updatepingjunSpeed();
                    break;
                case 3:
                    BmwCarLogAct.this.updatepingjunOil();
                    break;
                case 4:
                    BmwCarLogAct.this.updatexushilicheng();
                    BmwCarLogAct.this.updatepingjunSpeed();
                    break;
                case 5:
                    BmwCarLogAct.this.updatepingjunOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haozheng_bmw_car_log);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatexushilicheng() {
        int licheng = DataCanbus.DATA[1];
        int JuliUnit = DataCanbus.DATA[4];
        if (JuliUnit == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_xushi_licheng_tv)).setText(String.valueOf(licheng) + "mls");
        } else if (JuliUnit == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_xushi_licheng_tv)).setText(String.valueOf(licheng) + "km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatepingjunSpeed() {
        int speed = DataCanbus.DATA[2];
        int oilUnit = DataCanbus.DATA[4];
        if (oilUnit == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_speed_tv)).setText(String.valueOf(speed / 10.0f) + " mls/h");
        } else if (oilUnit == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_pingjun_speed_tv)).setText(String.valueOf(speed / 10.0f) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatepingjunOil() {
        int oil = DataCanbus.DATA[3];
        int oilUnit = DataCanbus.DATA[5];
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
