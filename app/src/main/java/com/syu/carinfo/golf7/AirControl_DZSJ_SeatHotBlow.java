package com.syu.carinfo.golf7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class AirControl_DZSJ_SeatHotBlow extends Activity implements View.OnClickListener {
    public static AirControl_DZSJ_SeatHotBlow mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        int value = 0;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                case 31:
                    AirControl_DZSJ_SeatHotBlow.this.updateSeatHotBlow_FL();
                    break;
                case 30:
                case 32:
                    AirControl_DZSJ_SeatHotBlow.this.updateSeatHotBlow_FR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0017_maiteng_air_searhotblow_dzsj);
        initUI();
        mInstance = this;
    }

    private void initUI() {
        ((Button) findViewById(R.id.btn_air_blow_onoff_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow1_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow2_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow3_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow_onoff_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow1_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow2_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_blow3_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot_onoff_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot1_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot2_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot3_fl)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot_onoff_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot1_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot2_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_hot3_fr)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_air_blow_onoff_fl /* 2131427405 */:
                int value = DataCanbus.DATA[31];
                if (value != 0) {
                    setAirCmd(37, 0);
                    break;
                }
            case R.id.btn_air_blow3_fl /* 2131427406 */:
                int value2 = DataCanbus.DATA[31];
                if (value2 != 3) {
                    setAirCmd(37, 3);
                    break;
                }
            case R.id.btn_air_blow2_fl /* 2131427407 */:
                int value3 = DataCanbus.DATA[31];
                if (value3 != 2) {
                    setAirCmd(37, 2);
                    break;
                }
            case R.id.btn_air_blow1_fl /* 2131427408 */:
                int value4 = DataCanbus.DATA[31];
                if (value4 != 1) {
                    setAirCmd(37, 1);
                    break;
                }
            case R.id.btn_air_blow_onoff_fr /* 2131427409 */:
                int value5 = DataCanbus.DATA[32];
                if (value5 != 0) {
                    setAirCmd(38, 0);
                    break;
                }
            case R.id.btn_air_blow3_fr /* 2131427410 */:
                int value6 = DataCanbus.DATA[32];
                if (value6 != 3) {
                    setAirCmd(38, 3);
                    break;
                }
            case R.id.btn_air_blow2_fr /* 2131427411 */:
                int value7 = DataCanbus.DATA[32];
                if (value7 != 2) {
                    setAirCmd(38, 2);
                    break;
                }
            case R.id.btn_air_blow1_fr /* 2131427412 */:
                int value8 = DataCanbus.DATA[32];
                if (value8 != 1) {
                    setAirCmd(38, 1);
                    break;
                }
            case R.id.btn_air_hot_onoff_fl /* 2131427413 */:
                int value9 = DataCanbus.DATA[29];
                if (value9 != 0) {
                    setAirCmd(33, 0);
                    break;
                }
            case R.id.btn_air_hot1_fl /* 2131427414 */:
                int value10 = DataCanbus.DATA[29];
                if (value10 != 1) {
                    setAirCmd(33, 1);
                    break;
                }
            case R.id.btn_air_hot2_fl /* 2131427415 */:
                int value11 = DataCanbus.DATA[29];
                if (value11 != 2) {
                    setAirCmd(33, 2);
                    break;
                }
            case R.id.btn_air_hot3_fl /* 2131427416 */:
                int value12 = DataCanbus.DATA[29];
                if (value12 != 3) {
                    setAirCmd(33, 3);
                    break;
                }
            case R.id.btn_air_hot_onoff_fr /* 2131427417 */:
                int value13 = DataCanbus.DATA[30];
                if (value13 != 0) {
                    setAirCmd(34, 0);
                    break;
                }
            case R.id.btn_air_hot1_fr /* 2131427418 */:
                int value14 = DataCanbus.DATA[30];
                if (value14 != 1) {
                    setAirCmd(34, 1);
                    break;
                }
            case R.id.btn_air_hot2_fr /* 2131427419 */:
                int value15 = DataCanbus.DATA[30];
                if (value15 != 2) {
                    setAirCmd(34, 2);
                    break;
                }
            case R.id.btn_air_hot3_fr /* 2131427420 */:
                int value16 = DataCanbus.DATA[30];
                if (value16 != 3) {
                    setAirCmd(34, 3);
                    break;
                }
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
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
    }

    protected void updateSeatHotBlow_FR() {
        if (((ImageView) findViewById(R.id.image_FRHeatDriver)) != null) {
            int value1 = DataCanbus.DATA[32];
            int value2 = DataCanbus.DATA[30];
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_blow_onoff_fr)).setText("OFF");
                    ((Button) findViewById(R.id.btn_air_blow1_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow2_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow3_fr)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_air_blow_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow3_fr)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_air_blow_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow3_fr)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_air_blow_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow3_fr)).setSelected(true);
                    break;
            }
            switch (value2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fr)).setText("OFF");
                    ((Button) findViewById(R.id.btn_air_hot1_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot2_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot3_fr)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fr)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot3_fr)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot3_fr)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fr)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fr)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot3_fr)).setSelected(true);
                    break;
            }
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr0);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
            if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr1);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
            if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr2);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
        }
    }

    protected void updateSeatHotBlow_FL() {
        if (((ImageView) findViewById(R.id.image_FLHeatDriver)) != null) {
            int value1 = DataCanbus.DATA[31];
            int value2 = DataCanbus.DATA[29];
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("OFF");
                    ((Button) findViewById(R.id.btn_air_blow1_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow2_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow3_fl)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_blow3_fl)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow3_fl)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_blow1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow2_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_blow3_fl)).setSelected(true);
                    break;
            }
            switch (value2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fl)).setText("OFF");
                    ((Button) findViewById(R.id.btn_air_hot1_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot2_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot3_fl)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fl)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fl)).setSelected(false);
                    ((Button) findViewById(R.id.btn_air_hot3_fl)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fl)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot3_fl)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_air_hot_onoff_fl)).setText("ON");
                    ((Button) findViewById(R.id.btn_air_hot1_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot2_fl)).setSelected(true);
                    ((Button) findViewById(R.id.btn_air_hot3_fl)).setSelected(true);
                    break;
            }
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl0);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
            if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl1);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
            if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl2);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
        }
    }
}
