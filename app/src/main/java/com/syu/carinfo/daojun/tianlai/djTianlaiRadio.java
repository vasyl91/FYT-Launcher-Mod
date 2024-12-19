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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djTianlaiRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djTianlaiRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    djTianlaiRadio.this.updateRadioBand();
                    break;
                case 89:
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djtianlai_carradio);
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
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[87];
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
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.prado_radio_fm1 /* 2131430934 */:
                    DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
                    break;
                case R.id.prado_radio_am /* 2131430935 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    break;
                case R.id.prado_radio_prev /* 2131430936 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                    break;
                case R.id.prado_radio_skib /* 2131430937 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
                    break;
                case R.id.prado_radio_skif /* 2131430938 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8, 1}, null, null);
                    break;
                case R.id.prado_radio_next /* 2131430939 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.prado_radio_fm1 /* 2131430934 */:
                    DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                    break;
                case R.id.prado_radio_am /* 2131430935 */:
                    DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                    break;
                case R.id.prado_radio_prev /* 2131430936 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                    break;
                case R.id.prado_radio_skib /* 2131430937 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                    break;
                case R.id.prado_radio_skif /* 2131430938 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                    break;
                case R.id.prado_radio_next /* 2131430939 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
                    break;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[107] != 1) {
            DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiRadio.2
                @Override // java.lang.Runnable
                public void run() {
                    DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                }
            }, 100L);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
