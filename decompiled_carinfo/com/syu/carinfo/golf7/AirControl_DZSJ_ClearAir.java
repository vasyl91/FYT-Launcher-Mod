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

@SuppressWarnings({"deprecation", "unchecked"})
public class AirControl_DZSJ_ClearAir extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        int value = 0;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 73:
                case 76:
                    AirControl_DZSJ_ClearAir.this.uAirClearState();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_golf7_clearair_dzsj);
        initUI();
    }

    private void initUI() {
        ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { 
            @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.glf7_btn_air_clear_od /* 2131431043 */:
                int value = DataCanbus.DATA[76];
                setAirCmd(32, value == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mCanbusNotify);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    
    public void uAirClearState() {
        int value1 = DataCanbus.DATA[73];
        int value2 = DataCanbus.DATA[76];
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
