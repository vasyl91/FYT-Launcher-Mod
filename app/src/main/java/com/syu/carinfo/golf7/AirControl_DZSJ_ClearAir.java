package com.syu.carinfo.golf7;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AirControl_DZSJ_ClearAir extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControl_DZSJ_ClearAir.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 190:
                case 226:
                    AirControl_DZSJ_ClearAir.this.uAirClearState();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_golf7_clearair_dzsj);
        initUI();
    }

    private void initUI() {
        ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.AirControl_DZSJ_ClearAir.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    AirControl_DZSJ_ClearAir.this.onKeyDown(4, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setListner((Button) findViewById(R.id.glf7_btn_air_clear_od));
    }

    private void setListner(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.glf7_btn_air_clear_od /* 2131431067 */:
                int value = DataCanbus.DATA[190];
                setAirCmd(32, value == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mCanbusNotify);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAirClearState() {
        int value1 = DataCanbus.DATA[226];
        int value2 = DataCanbus.DATA[190];
        if (value2 == 0) {
            ((Button) findViewById(R.id.glf7_btn_air_clear_od)).setSelected(false);
            ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat0));
            ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clear_auto_off);
        }
        if (value2 == 1) {
            ((Button) findViewById(R.id.glf7_btn_air_clear_od)).setSelected(true);
            switch (value1) {
                case 0:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat0));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clear_auto_on_open);
                    break;
                case 1:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat1));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 2:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat2));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 3:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat3));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 4:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat4));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 5:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat5));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 6:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat6));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 7:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat7));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 8:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat8));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 9:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat9));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
                case 10:
                    ((ImageView) findViewById(R.id.iv_airlearstate)).setImageDrawable(getResources().getDrawable(R.drawable.ic_air_clear_stat10));
                    ((TextView) findViewById(R.id.golf7_air_clear_state)).setText(R.string.str_air_clearing_auto);
                    break;
            }
        }
    }
}
