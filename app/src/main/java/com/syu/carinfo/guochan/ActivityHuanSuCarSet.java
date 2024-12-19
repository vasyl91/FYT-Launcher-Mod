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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHuanSuCarSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityHuanSuCarSet.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 66:
                    ActivityHuanSuCarSet.this.updateUpLightAutoDelay(this.value);
                    break;
                case 67:
                    ActivityHuanSuCarSet.this.updateOutRearview(this.value);
                    break;
                case 68:
                    ActivityHuanSuCarSet.this.updateAwayHome(this.value);
                    break;
                case 69:
                    ActivityHuanSuCarSet.this.updateBackHome(this.value);
                    break;
                case 70:
                    ActivityHuanSuCarSet.this.updateFoldRearview(this.value);
                    break;
                case 71:
                    ActivityHuanSuCarSet.this.updateAutoLock15(this.value);
                    break;
                case 72:
                    ActivityHuanSuCarSet.this.updateSecondaryUnlock(this.value);
                    break;
                case 73:
                    ActivityHuanSuCarSet.this.updateMagneticRelay(this.value);
                    break;
                case 74:
                    ActivityHuanSuCarSet.this.updateDriverSeat(this.value);
                    break;
                case 75:
                    ActivityHuanSuCarSet.this.updateTurnAutoFrontFogLight(this.value);
                    break;
                case 76:
                    ActivityHuanSuCarSet.this.updateStopWiper(this.value);
                    break;
                case 77:
                    ActivityHuanSuCarSet.this.updateBeamFlash(this.value);
                    break;
                case 78:
                    ActivityHuanSuCarSet.this.updateRemoteWinDown(this.value);
                    break;
                case 79:
                    ActivityHuanSuCarSet.this.updateRemoteWinUp(this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_huansu_s6_car_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_419_car_auto_lock_when_15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_secondary_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_stop_wiper_when_open_door)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_beam_flash)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_remote_control_window_down)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_remote_control_window_up)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_out_rearview_auto_light)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_fold_rearview_when_locked)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_magnetic_relay_state)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_turn_auto_front_fog_light)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_away_home_delay_light_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_away_home_delay_light_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_back_home_delay_light_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_back_home_delay_light_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_uplight_auto_delay_minus)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_419_car_driver_seat_auto_recoers)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_419_car_uplight_auto_delay_plus)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mCanbusNotify, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_419_car_away_home_delay_light_minus /* 2131429982 */:
                this.value = DataCanbus.DATA[68] & 255;
                this.value--;
                if (this.value < 0) {
                    this.value = 0;
                }
                setCmd(5, this.value);
                break;
            case R.id.btn_419_car_away_home_delay_light_plus /* 2131429984 */:
                this.value = DataCanbus.DATA[68] & 255;
                this.value++;
                if (this.value > 6) {
                    this.value = 6;
                }
                setCmd(5, this.value);
                break;
            case R.id.btn_419_car_back_home_delay_light_minus /* 2131429986 */:
                this.value = DataCanbus.DATA[69] & 255;
                this.value--;
                if (this.value < 0) {
                    this.value = 0;
                }
                setCmd(4, this.value);
                break;
            case R.id.btn_419_car_back_home_delay_light_plus /* 2131429988 */:
                this.value = DataCanbus.DATA[69] & 255;
                this.value++;
                if (this.value > 6) {
                    this.value = 6;
                }
                setCmd(4, this.value);
                break;
            case R.id.ctv_419_car_auto_lock_when_15 /* 2131429990 */:
                this.value = DataCanbus.DATA[71] & 255;
                setCmd(2, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_secondary_unlock /* 2131429992 */:
                this.value = DataCanbus.DATA[72] & 255;
                setCmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.ctv_419_car_stop_wiper_when_open_door /* 2131429995 */:
                this.value = DataCanbus.DATA[76] & 255;
                setCmd(11, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_beam_flash /* 2131429997 */:
                this.value = DataCanbus.DATA[77] & 255;
                setCmd(10, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_remote_control_window_down /* 2131429999 */:
                this.value = DataCanbus.DATA[78] & 255;
                setCmd(9, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_remote_control_window_up /* 2131430001 */:
                this.value = DataCanbus.DATA[79] & 255;
                setCmd(8, this.value != 0 ? 0 : 1);
                break;
            case R.id.btn_419_car_uplight_auto_delay_minus /* 2131430003 */:
                this.value = DataCanbus.DATA[66] & 255;
                this.value--;
                if (this.value < 0) {
                    this.value = 0;
                }
                setCmd(7, this.value);
                break;
            case R.id.btn_419_car_uplight_auto_delay_plus /* 2131430005 */:
                this.value = DataCanbus.DATA[66] & 255;
                this.value++;
                if (this.value > 3) {
                    this.value = 3;
                }
                setCmd(7, this.value);
                break;
            case R.id.ctv_419_car_out_rearview_auto_light /* 2131430007 */:
                this.value = DataCanbus.DATA[67] & 255;
                setCmd(6, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_fold_rearview_when_locked /* 2131430009 */:
                this.value = DataCanbus.DATA[70] & 255;
                setCmd(3, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_magnetic_relay_state /* 2131430011 */:
                this.value = DataCanbus.DATA[73] & 255;
                setCmd(14, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_driver_seat_auto_recoers /* 2131430014 */:
                this.value = DataCanbus.DATA[74] & 255;
                setCmd(13, this.value != 0 ? 0 : 1);
                break;
            case R.id.ctv_419_car_turn_auto_front_fog_light /* 2131430016 */:
                this.value = DataCanbus.DATA[75] & 255;
                setCmd(12, this.value != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, cmd, value);
    }

    protected void updateRemoteWinUp(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_remote_control_window_up).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_remote_control_window_up)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_remote_control_window_up).setVisibility(8);
        }
    }

    protected void updateRemoteWinDown(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_remote_control_window_down).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_remote_control_window_down)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_remote_control_window_down).setVisibility(8);
        }
    }

    protected void updateBeamFlash(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_beam_flash).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_beam_flash)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_beam_flash).setVisibility(8);
        }
    }

    protected void updateStopWiper(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_stop_wiper_when_open_door).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_stop_wiper_when_open_door)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_stop_wiper_when_open_door).setVisibility(8);
        }
    }

    protected void updateTurnAutoFrontFogLight(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_turn_auto_front_fog_light).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_turn_auto_front_fog_light)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_turn_auto_front_fog_light).setVisibility(8);
        }
    }

    protected void updateDriverSeat(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_driver_seat_auto_recoers).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_driver_seat_auto_recoers)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_driver_seat_auto_recoers).setVisibility(8);
        }
    }

    protected void updateMagneticRelay(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_magnetic_relay_state).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_magnetic_relay_state)).setChecked((value & 255) == 1);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_419_car_magnetic_relay_state)).setText(R.string.str_mode_factory);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_419_car_magnetic_relay_state)).setText(R.string.str_mode_user);
                return;
            }
        }
        findViewById(R.id.layout_419_car_magnetic_relay_state).setVisibility(8);
    }

    protected void updateSecondaryUnlock(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_secondary_unlock).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_secondary_unlock)).setChecked((value & 255) == 1);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_419_car_secondary_unlock)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_419_car_secondary_unlock)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                return;
            }
        }
        findViewById(R.id.layout_419_car_secondary_unlock).setVisibility(8);
    }

    protected void updateAutoLock15(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_auto_lock_when_15).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_auto_lock_when_15)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_auto_lock_when_15).setVisibility(8);
        }
    }

    protected void updateFoldRearview(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_fold_rearview_when_locked).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_fold_rearview_when_locked)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_fold_rearview_when_locked).setVisibility(8);
        }
    }

    protected void updateBackHome(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_back_home_delay_light).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("10S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("20S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("30S");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("40S");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("50S");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText("60S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_419_car_back_home_delay_light)).setText(R.string.off);
                    break;
            }
            return;
        }
        findViewById(R.id.layout_419_car_back_home_delay_light).setVisibility(8);
    }

    protected void updateAwayHome(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_away_home_delay_light).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("10S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("20S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("30S");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("40S");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("50S");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText("60S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_419_car_away_home_delay_light)).setText(R.string.off);
                    break;
            }
            return;
        }
        findViewById(R.id.layout_419_car_away_home_delay_light).setVisibility(8);
    }

    protected void updateOutRearview(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_out_rearview_auto_light).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_419_car_out_rearview_auto_light)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_419_car_out_rearview_auto_light).setVisibility(8);
        }
    }

    protected void updateUpLightAutoDelay(int value) {
        int visi = (value >> 8) & 255;
        if (visi == 1) {
            findViewById(R.id.layout_419_car_uplight_auto_delay).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_419_car_uplight_auto_delay)).setText("8S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_419_car_uplight_auto_delay)).setText("15S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_419_car_uplight_auto_delay)).setText("30S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_419_car_uplight_auto_delay)).setText("0S");
                    break;
            }
            return;
        }
        findViewById(R.id.layout_419_car_uplight_auto_delay).setVisibility(8);
    }
}
