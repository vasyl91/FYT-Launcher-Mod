package com.syu.carinfo.daojun.tianlai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class djTianlaiRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djTianlaiRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    djTianlaiRadio.this.updateRadioBand();
                    break;
                case 101:
                    if (djTianlaiRadio.this.unit == 1) {
                        ((TextView) djTianlaiRadio.this.findViewById(R.id.dj_prado_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) djTianlaiRadio.this.findViewById(R.id.dj_prado_radio_freq)).setText((value / 10) + "." + (value % 10));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_djtianlai_carradio);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.prado_radio_fm1).setOnTouchListener(this);
        findViewById(R.id.prado_radio_am).setOnTouchListener(this);
        findViewById(R.id.prado_radio_prev).setOnTouchListener(this);
        findViewById(R.id.prado_radio_skib).setOnTouchListener(this);
        findViewById(R.id.prado_radio_skif).setOnTouchListener(this);
        findViewById(R.id.prado_radio_next).setOnTouchListener(this);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[99];
        switch (value) {
            case 1:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_prado_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_prado_radio_unit)).setText("Mhz");
                break;
            case 2:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_prado_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_prado_radio_unit)).setText("Mhz");
                break;
            case 17:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_prado_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_prado_radio_unit)).setText("Khz");
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.prado_radio_fm1 /* 2131430910 */:
                    DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
                    break;
                case R.id.prado_radio_am /* 2131430911 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    break;
                case R.id.prado_radio_prev /* 2131430912 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                    break;
                case R.id.prado_radio_skib /* 2131430913 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
                    break;
                case R.id.prado_radio_skif /* 2131430914 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8, 1}, null, null);
                    break;
                case R.id.prado_radio_next /* 2131430915 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.prado_radio_fm1 /* 2131430910 */:
                    DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                    break;
                case R.id.prado_radio_am /* 2131430911 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                    break;
                case R.id.prado_radio_prev /* 2131430912 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                    break;
                case R.id.prado_radio_skib /* 2131430913 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                    break;
                case R.id.prado_radio_skif /* 2131430914 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                    break;
                case R.id.prado_radio_next /* 2131430915 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
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
        if (DataCanbus.DATA[119] != 1) {
            DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                }
            }, 100L);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
