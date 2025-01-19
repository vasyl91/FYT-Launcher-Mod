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

public class ActivityHuanSuAirSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    ActivityHuanSuAirSet.this.updateRemoteOpenAir(value);
                    break;
                case 110:
                    ActivityHuanSuAirSet.this.updatePhoneDownWind(value);
                    break;
                case 111:
                    ActivityHuanSuAirSet.this.updateHighTempInterCycle(value);
                    break;
                case 112:
                    ActivityHuanSuAirSet.this.updateAutoWind(value);
                    break;
                case 113:
                    ActivityHuanSuAirSet.this.updateAutoAC(value);
                    break;
                case 114:
                    ActivityHuanSuAirSet.this.updateParkInterCycle(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_419_huansu_s6_air_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_419_air_remote_open_air)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_air_hightemp_auto_inter_cycle)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_air_auto_wind)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_air_auto_ac)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_air_pack_auto_inter_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_air_phone_down_wind_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_air_phone_down_wind_plus)).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_419_air_remote_open_air /* 2131429920 */:
                setCmd(6, (DataCanbus.DATA[109] & 255) != 0 ? 0 : 1);
                break;
            case R.id.btn_419_air_phone_down_wind_minus /* 2131429922 */:
                int value = (DataCanbus.DATA[110] & 255) - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(5, value);
                break;
            case R.id.btn_419_air_phone_down_wind_plus /* 2131429924 */:
                int value2 = (DataCanbus.DATA[110] & 255) + 1;
                if (value2 > 7) {
                    value2 = 7;
                }
                setCmd(5, value2);
                break;
            case R.id.ctv_419_air_hightemp_auto_inter_cycle /* 2131429926 */:
                setCmd(4, (DataCanbus.DATA[111] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_air_auto_wind /* 2131429928 */:
                setCmd(3, (DataCanbus.DATA[112] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_air_auto_ac /* 2131429930 */:
                setCmd(2, (DataCanbus.DATA[113] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_air_pack_auto_inter_cycle /* 2131429932 */:
                setCmd(1, (DataCanbus.DATA[114] & 255) == 0 ? 1 : 0);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    protected void updateParkInterCycle(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_pack_auto_inter_cycle).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_air_pack_auto_inter_cycle)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_air_pack_auto_inter_cycle).setVisibility(8);
        }
    }

    protected void updateAutoAC(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_auto_ac).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_air_auto_ac)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_air_auto_ac).setVisibility(8);
        }
    }

    protected void updateAutoWind(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_auto_wind).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_air_auto_wind)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_air_auto_wind).setVisibility(8);
        }
    }

    protected void updateHighTempInterCycle(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_hightemp_auto_inter_cycle).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_air_hightemp_auto_inter_cycle)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_air_hightemp_auto_inter_cycle).setVisibility(8);
        }
    }

    protected void updatePhoneDownWind(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_phone_down_wind_minus).setVisibility(0);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_419_air_phone_down_wind)).setText(R.string.off);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_419_air_phone_down_wind)).setText(new StringBuilder().append(value & 255).toString());
                return;
            }
        }
        findViewById(R.id.layout_419_air_phone_down_wind_minus).setVisibility(8);
    }

    protected void updateRemoteOpenAir(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_419_air_remote_open_air).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_air_remote_open_air)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_air_remote_open_air).setVisibility(8);
        }
    }
}
