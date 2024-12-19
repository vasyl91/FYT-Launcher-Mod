package com.syu.carinfo.ky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityDaMaiX7 extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ky.ActivityDaMaiX7.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    ActivityDaMaiX7.this.updateSeatComity(this.value);
                    break;
                case 17:
                    ActivityDaMaiX7.this.updateAtmosphereLight(this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_258_damai_x7);
        ((CheckedTextView) findViewById(R.id.ctv_damaix7_seat_comity)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_damaix7_atmosphere_lights_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_damaix7_atmosphere_lights_plus)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatComity(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_damaix7_seat_comity)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_damaix7_seat_comity)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAtmosphereLight(int value) {
        if (((TextView) findViewById(R.id.tv_damaix7_atmosphere_lights_show)) != null) {
            ((TextView) findViewById(R.id.tv_damaix7_atmosphere_lights_show)).setText(new StringBuilder().append(value).toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_damaix7_seat_comity /* 2131429000 */:
                this.value = DataCanbus.DATA[16];
                DataCanbus.PROXY.cmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.btn_damaix7_atmosphere_lights_minus /* 2131429002 */:
                this.value = DataCanbus.DATA[17] - 1;
                if (this.value < 0) {
                    this.value = 0;
                }
                DataCanbus.PROXY.cmd(2, this.value);
                break;
            case R.id.btn_damaix7_atmosphere_lights_plus /* 2131429004 */:
                this.value = DataCanbus.DATA[17] + 1;
                if (this.value > 6) {
                    this.value = 6;
                }
                DataCanbus.PROXY.cmd(2, this.value);
                break;
        }
    }
}
