package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLTireAct_BNR extends Activity {
    public static YLTireAct_BNR mInit;
    int[] ids = {146, 147, 148, 41, 42, 43, 44, 149};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLTireAct_BNR.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 41:
                    YLTireAct_BNR.this.uTireFL(value);
                    break;
                case 42:
                    YLTireAct_BNR.this.uTireFR(value);
                    break;
                case 43:
                    YLTireAct_BNR.this.uTireRL(value);
                    break;
                case 44:
                    YLTireAct_BNR.this.uTireRR(value);
                    break;
                case 146:
                    YLTireAct_BNR.this.uTireExist(value);
                    break;
                case 147:
                    YLTireAct_BNR.this.uSpareTireExist(value);
                    break;
                case 148:
                    YLTireAct_BNR.this.uTireUnit(value);
                    break;
                case 149:
                    YLTireAct_BNR.this.uTireSpare(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_tire_bnr);
        init();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    private void init() {
        mInit = this;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    protected void uTireExist(int value) {
        if (findViewById(R.id.xp_yl_layout_car) != null) {
            findViewById(R.id.xp_yl_layout_car).setVisibility(value == 1 ? 0 : 8);
        }
    }

    protected void uTireSpare(int value) {
        TextView v = (TextView) findViewById(R.id.xp_yl_tv_car_sparetire);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireRR(int value) {
        TextView v = (TextView) findViewById(R.id.xp_yl_tv_car_tire_3);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireRL(int value) {
        TextView v = (TextView) findViewById(R.id.xp_yl_tv_car_tire_2);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireFR(int value) {
        TextView v = (TextView) findViewById(R.id.xp_yl_tv_car_tire_1);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireFL(int value) {
        TextView v = (TextView) findViewById(R.id.xp_yl_tv_car_tire_0);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireUnit(int value) {
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_unit)) != null) {
            String str = "Bar";
            if (value == 1) {
                str = "Psi";
            } else if (value == 2) {
                str = "Kpa";
            }
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_unit)).setText(str);
        }
    }

    protected void uSpareTireExist(int value) {
        if (findViewById(R.id.bnr_yl_spare_tire_view) != null) {
            findViewById(R.id.bnr_yl_spare_tire_view).setVisibility(value == 1 ? 0 : 8);
        }
    }
}
