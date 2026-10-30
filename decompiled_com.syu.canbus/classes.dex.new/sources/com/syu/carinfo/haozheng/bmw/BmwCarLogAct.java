package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BmwCarLogAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwCarLogAct.1
        @Override // com.syu.module.IUiNotify
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
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatexushilicheng() {
        int licheng = DataCanbus.DATA[8];
        int JuliUnit = DataCanbus.DATA[11];
        if (JuliUnit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(licheng) + "mls");
        } else if (JuliUnit == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(licheng) + "km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatepingjunSpeed() {
        int speed = DataCanbus.DATA[9];
        int oilUnit = DataCanbus.DATA[11];
        if (oilUnit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(speed / 10.0f) + " mls/h");
        } else if (oilUnit == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(speed / 10.0f) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatepingjunOil() {
        int oil = DataCanbus.DATA[10];
        int oilUnit = DataCanbus.DATA[12];
        if (oilUnit == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(oil / 10.0f) + " l/100km");
            return;
        }
        if (oilUnit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(oil / 10.0f) + " mpg(US)");
        } else if (oilUnit == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(oil / 10.0f) + " mpg(UK)");
        } else if (oilUnit == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(oil / 10.0f) + " km/l");
        }
    }
}
