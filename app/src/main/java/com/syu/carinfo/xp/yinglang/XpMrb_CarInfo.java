package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpMrb_CarInfo extends Activity {
    private int[] events = {124, 125, 126, 127, 128};
    int value = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.XpMrb_CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            XpMrb_CarInfo.this.value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 124:
                    XpMrb_CarInfo.this.uRF(XpMrb_CarInfo.this.value);
                    break;
                case 125:
                    XpMrb_CarInfo.this.uLF(XpMrb_CarInfo.this.value);
                    break;
                case 126:
                    XpMrb_CarInfo.this.uRR(XpMrb_CarInfo.this.value);
                    break;
                case 127:
                    XpMrb_CarInfo.this.uLR(XpMrb_CarInfo.this.value);
                    break;
                case 128:
                    XpMrb_CarInfo.this.uAngel(XpMrb_CarInfo.this.value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_359_carinfo);
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

    private void addUpdater() {
        for (int i = 0; i < this.events.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.events[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        for (int i = 0; i < this.events.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.events[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    private void setT(TextView v, boolean on) {
        if (v != null) {
            v.setText(on ? "Open" : "Close");
        }
    }

    private void setVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    protected void uAngel(int val) {
        int angle = (val * 3) / 2;
        if (((ImageView) findViewById(R.id.iv_car_compass_pointer)) != null) {
            ((ImageView) findViewById(R.id.iv_car_compass_pointer)).setRotation(angle);
        }
    }

    protected void uLR(int val) {
        setT((TextView) findViewById(R.id.tv_car_win_3), val == 1);
        setVisible((ImageView) findViewById(R.id.iv_car_win_lr), val == 1);
    }

    protected void uRR(int val) {
        setT((TextView) findViewById(R.id.tv_car_win_4), val == 1);
        setVisible((ImageView) findViewById(R.id.iv_car_win_rr), val == 1);
    }

    protected void uLF(int val) {
        setT((TextView) findViewById(R.id.tv_car_win_1), val == 1);
        setVisible((ImageView) findViewById(R.id.iv_car_win_lf), val == 1);
    }

    protected void uRF(int val) {
        setT((TextView) findViewById(R.id.tv_car_win_2), val == 1);
        setVisible((ImageView) findViewById(R.id.iv_car_win_rf), val == 1);
    }
}