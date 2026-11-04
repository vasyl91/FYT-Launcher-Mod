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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class AirControl_DZSJ_SeatHotBlow extends Activity implements View.OnClickListener {
    public static AirControl_DZSJ_SeatHotBlow mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControl_DZSJ_SeatHotBlow.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0017_maiteng_air_searhotblow_dzsj);
        initUI();
        mInstance = this;
    }

    private void initUI() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
                int value = DataCanbus.DATA[31];
                if (value != 0) {
                    setAirCmd(37, 0);
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value2 = DataCanbus.DATA[31];
                if (value2 != 3) {
                    setAirCmd(37, 3);
                }
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value3 = DataCanbus.DATA[31];
                if (value3 != 2) {
                    setAirCmd(37, 2);
                }
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value4 = DataCanbus.DATA[31];
                if (value4 != 1) {
                    setAirCmd(37, 1);
                }
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value5 = DataCanbus.DATA[32];
                if (value5 != 0) {
                    setAirCmd(38, 0);
                }
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value6 = DataCanbus.DATA[32];
                if (value6 != 3) {
                    setAirCmd(38, 3);
                }
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value7 = DataCanbus.DATA[32];
                if (value7 != 2) {
                    setAirCmd(38, 2);
                }
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value8 = DataCanbus.DATA[32];
                if (value8 != 1) {
                    setAirCmd(38, 1);
                }
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value9 = DataCanbus.DATA[29];
                if (value9 != 0) {
                    setAirCmd(33, 0);
                }
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value10 = DataCanbus.DATA[29];
                if (value10 != 1) {
                    setAirCmd(33, 1);
                }
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value11 = DataCanbus.DATA[29];
                if (value11 != 2) {
                    setAirCmd(33, 2);
                }
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value12 = DataCanbus.DATA[29];
                if (value12 != 3) {
                    setAirCmd(33, 3);
                }
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value13 = DataCanbus.DATA[30];
                if (value13 != 0) {
                    setAirCmd(34, 0);
                }
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value14 = DataCanbus.DATA[30];
                if (value14 != 1) {
                    setAirCmd(34, 1);
                }
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value15 = DataCanbus.DATA[30];
                if (value15 != 2) {
                    setAirCmd(34, 2);
                }
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                int value16 = DataCanbus.DATA[30];
                if (value16 != 3) {
                    setAirCmd(34, 3);
                }
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
        if (((ImageView) findViewById(R.id.layout_view2)) != null) {
            int value1 = DataCanbus.DATA[32];
            int value2 = DataCanbus.DATA[30];
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("OFF");
                    ((Button) findViewById(R.id.btn_plus8)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus7)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus6)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus8)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus7)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus6)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus8)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus7)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus6)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus8)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus7)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus6)).setSelected(true);
                    break;
            }
            switch (value2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("OFF");
                    ((Button) findViewById(R.id.btn_plus14)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus15)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus16)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus14)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus15)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus16)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus14)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus15)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus16)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus14)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus15)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus16)).setSelected(true);
                    break;
            }
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr0);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
            if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr1);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
            if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr2);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fr);
                        break;
                }
            }
        }
    }

    protected void updateSeatHotBlow_FL() {
        if (((ImageView) findViewById(R.id.layout_view1)) != null) {
            int value1 = DataCanbus.DATA[31];
            int value2 = DataCanbus.DATA[29];
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("OFF");
                    ((Button) findViewById(R.id.btn_plus4)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus3)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus2)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus4)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus3)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus2)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus4)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus3)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus2)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus4)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus3)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus2)).setSelected(true);
                    break;
            }
            switch (value2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("OFF");
                    ((Button) findViewById(R.id.btn_plus10)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus11)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus12)).setSelected(false);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus10)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus11)).setSelected(false);
                    ((Button) findViewById(R.id.btn_plus12)).setSelected(false);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus10)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus11)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus12)).setSelected(false);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText("ON");
                    ((Button) findViewById(R.id.btn_plus10)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus11)).setSelected(true);
                    ((Button) findViewById(R.id.btn_plus12)).setSelected(true);
                    break;
            }
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl0);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
            if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl1);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
            if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl2);
                        break;
                    default:
                        ((ImageView) findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.air_maiteng_dzsj_hotblow_fl);
                        break;
                }
            }
        }
    }
}
