package com.syu.carinfo.rzc.t70;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class AirRzcQiChenT90 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int touchState = -1;
    int cmd = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    if (value == 0) {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                        break;
                    } else {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 12:
                    if (value == 0) {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                        break;
                    } else {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        break;
                    }
                case 13:
                    if (DataCanbus.DATA[1000] == 721186) {
                        if (value == 0) {
                            ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_n);
                            break;
                        } else {
                            ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_p);
                            break;
                        }
                    }
                    break;
                case 18:
                case 19:
                case 20:
                    int foot = DataCanbus.DATA[20];
                    int body = DataCanbus.DATA[19];
                    int window = DataCanbus.DATA[18];
                    int mode = 0;
                    if (foot == 1) {
                        mode = 0 | 1;
                    } else if (foot == 0) {
                        mode = 0 & 254;
                    }
                    if (body == 1) {
                        mode |= 2;
                    } else if (body == 0) {
                        mode &= 253;
                    }
                    if (window == 1) {
                        mode |= 4;
                    } else if (window == 0) {
                        mode &= 251;
                    }
                    switch (mode) {
                        case 0:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                            break;
                        case 1:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                            break;
                        case 2:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                            break;
                        case 3:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                            break;
                        case 4:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                            break;
                        case 5:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                            break;
                        case 6:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                            break;
                        case 7:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                            break;
                        default:
                            AirRzcQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                            break;
                    }
                case 21:
                    if (value == 0) {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
                    } else {
                        ((Button) AirRzcQiChenT90.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
                    }
                    AirRzcQiChenT90.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    if (DataCanbus.DATA[1000] == 721186) {
                        if (value == -1) {
                            ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("NONE");
                            break;
                        } else {
                            ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 2.0f) + " ℃");
                            break;
                        }
                    } else if (value == -2) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("LOW");
                        break;
                    } else if (value == -3) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                        break;
                    } else if (value == -1) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("NONE");
                        break;
                    } else {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value + 17) + "℃");
                        break;
                    }
                case 28:
                    if (DataCanbus.DATA[1000] == 721186) {
                        if (value == -1) {
                            ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("NONE");
                            break;
                        } else {
                            ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 2.0f) + " ℃");
                            break;
                        }
                    } else if (value == -2) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                        break;
                    } else if (value == -3) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                        break;
                    } else if (value == -1) {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("NONE");
                        break;
                    } else {
                        ((TextView) AirRzcQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value + 17) + "℃");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0290_rzc_qichen_t90);
        initListener();
    }

    private void initListener() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.touchState = -1;
        if (event.getAction() == 0) {
            this.touchState = 1;
        } else if (event.getAction() == 1) {
            this.touchState = 0;
        }
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmd = 19;
                if (DataCanbus.DATA[1000] == 721186) {
                    if (DataCanbus.DATA[27] < 64) {
                        this.touchState = DataCanbus.DATA[27] + 1;
                    } else {
                        this.touchState = 64;
                    }
                } else if (DataCanbus.DATA[27] < 15) {
                    this.touchState = DataCanbus.DATA[27] + 1;
                } else {
                    this.touchState = 15;
                }
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmd = 19;
                if (DataCanbus.DATA[1000] == 721186) {
                    if (DataCanbus.DATA[27] > 32) {
                        this.touchState = DataCanbus.DATA[27] - 1;
                    } else {
                        this.touchState = 32;
                    }
                } else if (DataCanbus.DATA[27] > 1) {
                    this.touchState = DataCanbus.DATA[27] - 1;
                } else {
                    this.touchState = 1;
                }
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                    break;
                }
            case R.id.air_xts_power /* 2131427428 */:
                this.cmd = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmd = 18;
                if (DataCanbus.DATA[21] > 1) {
                    this.touchState = DataCanbus.DATA[21] - 1;
                } else {
                    this.touchState = 1;
                }
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (DataCanbus.DATA[21] < 7) {
                    this.touchState = DataCanbus.DATA[21] + 1;
                } else {
                    this.touchState = 7;
                }
                this.cmd = 18;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                    break;
                }
            case R.id.air_xts_mode /* 2131427434 */:
                this.cmd = 17;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmd = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (DataCanbus.DATA[12] == 0) {
                    this.cmd = 4;
                    break;
                } else {
                    this.cmd = 5;
                    break;
                }
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmd = 1;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (DataCanbus.DATA[1000] == 721186) {
                    if (DataCanbus.DATA[28] < 64) {
                        this.touchState = DataCanbus.DATA[28] + 1;
                    } else {
                        this.touchState = 64;
                    }
                } else if (DataCanbus.DATA[28] < 15) {
                    this.touchState = DataCanbus.DATA[28] + 1;
                } else {
                    this.touchState = 15;
                }
                this.cmd = 20;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                    break;
                }
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (DataCanbus.DATA[1000] == 721186) {
                    if (DataCanbus.DATA[28] > 32) {
                        this.touchState = DataCanbus.DATA[28] - 1;
                    } else {
                        this.touchState = 32;
                    }
                } else if (DataCanbus.DATA[28] > 1) {
                    this.touchState = DataCanbus.DATA[28] - 1;
                } else {
                    this.touchState = 1;
                }
                this.cmd = 20;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                    break;
                }
        }
        if (event.getAction() != 1 || (this.cmd != 18 && this.cmd != 19 && this.cmd != 20)) {
            setAirControl(this.cmd, this.touchState);
        }
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }
}
