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

public class RzcKlcLightAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                    RzcKlcLightAct.this.updaterLookLight();
                    break;
                case 106:
                    RzcKlcLightAct.this.updaterDelaySet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_klc_light_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int lasuoState = DataCanbus.DATA[106];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int lasuoState2 = DataCanbus.DATA[106];
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
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int lightState = DataCanbus.DATA[105];
                RzcKlcFunc.CAR_COMM_CONTROL(0, lightState != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterLookLight() {
        int lightState = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(lightState != 0);
    }

    
    public void updaterDelaySet() {
        int lasuoState = DataCanbus.DATA[106];
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
