package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHuanSuDashboardSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    ActivityHuanSuDashboardSet.this.updateLdwWarn(value);
                    break;
                case 130:
                    ActivityHuanSuDashboardSet.this.updateBsdWarn(value);
                    break;
                case 131:
                    ActivityHuanSuDashboardSet.this.updateWinterSpeedWarn(value);
                    break;
                case 132:
                    ActivityHuanSuDashboardSet.this.updateSpeedSpeedWarn(value);
                    break;
                case 133:
                    ActivityHuanSuDashboardSet.this.updateTpmsUint(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_419_huansu_s6_dashboard_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_419_dash_ldw_warn)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_dash_bsd_warn)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_dash_winter_speed_warn)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_dash_speed_speed_warn)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_dash_tpms_unit_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_dash_tpms_unit_plus)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_419_dash_ldw_warn /* 2131429970 */:
                setCmd(5, (DataCanbus.DATA[129] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_dash_bsd_warn /* 2131429972 */:
                setCmd(4, (DataCanbus.DATA[130] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_dash_winter_speed_warn /* 2131429974 */:
                setCmd(3, (DataCanbus.DATA[131] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_dash_speed_speed_warn /* 2131429976 */:
                setCmd(2, (DataCanbus.DATA[132] & 255) != 0 ? 0 : 1);
                break;
            case R.id.btn_419_dash_tpms_unit_minus /* 2131429978 */:
                int value = (DataCanbus.DATA[133] & 255) - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(1, value);
                break;
            case R.id.btn_419_dash_tpms_unit_plus /* 2131429980 */:
                int value2 = (DataCanbus.DATA[133] & 255) + 1;
                if (value2 > 2) {
                    value2 = 2;
                }
                setCmd(1, value2);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(2, cmd, value);
    }

    protected void updateTpmsUint(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_dash_tpms_unit).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_419_dash_tpms_unit)).setText("bar");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_419_dash_tpms_unit)).setText("psi");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_419_dash_tpms_unit)).setText("kpa");
                    break;
            }
            return;
        }
        findViewById(R.id.layout_419_dash_tpms_unit).setVisibility(8);
    }

    protected void updateSpeedSpeedWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_dash_speed_speed_warn).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_dash_speed_speed_warn)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_dash_speed_speed_warn).setVisibility(8);
        }
    }

    protected void updateWinterSpeedWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_dash_winter_speed_warn).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_dash_winter_speed_warn)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_dash_winter_speed_warn).setVisibility(8);
        }
    }

    protected void updateBsdWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_dash_bsd_warn).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_dash_bsd_warn)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_dash_bsd_warn).setVisibility(8);
        }
    }

    protected void updateLdwWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_dash_ldw_warn).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_dash_ldw_warn)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_dash_ldw_warn).setVisibility(8);
        }
    }
}
