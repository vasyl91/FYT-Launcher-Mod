package com.syu.carinfo.wc.infeinidi;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WcInfinitCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static WcInfinitCarCD mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
                    int hour = value / 3600;
                    int min = (value % 3600) / 60;
                    int sec = value % 60;
                    ((TextView) WcInfinitCarCD.this.findViewById(R.id.dj_lexus_radio_freq11)).setText(String.valueOf(hour) + ":" + min + ":" + sec);
                    break;
                case 159:
                case 160:
                    int track = DataCanbus.DATA[159];
                    int Totaltrack = DataCanbus.DATA[160];
                    ((TextView) WcInfinitCarCD.this.findViewById(R.id.dj_lexus_radio_freq12)).setText("Trcak: " + track + "/" + Totaltrack);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_infinit_q50l_carcd);
        mInit = this;
        ((Button) findViewById(R.id.lexus_radio_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_radio_next)).setOnTouchListener(this);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[156];
        switch (value) {
            case 1:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(4, new int[]{77, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(4, new int[]{78, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427866 */:
                    DataCanbus.PROXY.cmd(4, new int[]{77}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427867 */:
                    DataCanbus.PROXY.cmd(4, new int[]{78}, null, null);
                    break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
