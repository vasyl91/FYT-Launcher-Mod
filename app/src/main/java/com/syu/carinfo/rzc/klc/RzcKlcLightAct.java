package com.syu.carinfo.rzc.klc;

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
public class RzcKlcLightAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcLightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    RzcKlcLightAct.this.updaterLookLight();
                    break;
                case 8:
                    RzcKlcLightAct.this.updaterDelaySet();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_light_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int lightState = DataCanbus.DATA[7];
                RzcKlcFunc.CAR_COMM_CONTROL(0, lightState != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int lasuoState = DataCanbus.DATA[8];
                if (lasuoState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (lasuoState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                } else if (lasuoState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (lasuoState == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int lasuoState2 = DataCanbus.DATA[8];
                if (lasuoState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (lasuoState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                } else if (lasuoState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (lasuoState2 == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                }
        }
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
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLookLight() {
        int lightState = DataCanbus.DATA[7];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(lightState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDelaySet() {
        int lasuoState = DataCanbus.DATA[8];
        if (lasuoState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (lasuoState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (lasuoState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (lasuoState == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }
}
