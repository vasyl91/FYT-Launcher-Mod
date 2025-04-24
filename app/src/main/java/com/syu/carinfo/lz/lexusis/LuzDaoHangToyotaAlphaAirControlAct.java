package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuzDaoHangToyotaAlphaAirControlAct extends Activity implements View.OnTouchListener {
    public static LuzDaoHangToyotaAlphaAirControlAct mInstance;
    public static boolean mIsFront = false;
    int Pagenum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_power) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_power_n : R.drawable.ic_daohang_toyota_power_p);
                        break;
                    }
                case 11:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_ac) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_ac_n : R.drawable.ic_daohang_toyota_ac_p);
                        break;
                    }
                case 12:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_cycle) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_cycle_n : R.drawable.ic_daohang_toyota_cycle_p);
                        break;
                    }
                case 13:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_auto) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_auto_n : R.drawable.ic_daohang_toyota_auto_p);
                        break;
                    }
                case 14:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_dual) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_dual_n : R.drawable.ic_daohang_toyota_dual_p);
                        break;
                    }
                case 15:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_front) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_front_n : R.drawable.ic_daohang_toyota_front_p);
                        break;
                    }
                case 16:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_rear) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_rear_n : R.drawable.ic_daohang_toyota_rear_p);
                        break;
                    }
                case 18:
                case 19:
                case 20:
                    LuzDaoHangToyotaAlphaAirControlAct.this.updateBtnSource();
                    LuzDaoHangToyotaAlphaAirControlAct.this.updateBtnSourceRight();
                    break;
                case 21:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 33:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_flowauto) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_flowauto).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_flowauto_n : R.drawable.ic_daohang_toyota_flowauto_p);
                        break;
                    }
                case 37:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempLeft();
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 40:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempRearLeft();
                    break;
                case 41:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdateAirTempRearRight();
                    break;
                case 43:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_auto_rear) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_auto_rear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_auto_rear_n : R.drawable.ic_daohang_toyota_auto_rear_p);
                        break;
                    }
                case 44:
                    LuzDaoHangToyotaAlphaAirControlAct.this.mUpdaterAirWindLevelRear();
                    break;
                case 67:
                    if (LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_rearlock) != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.this.findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_rearlight_n : R.drawable.ic_daohang_toyota_rearlight_p);
                        break;
                    }
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0454_lz_daohang_alpha_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_flowauto).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_power_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_rear).setOnTouchListener(this);
    }

    private void updatepage(int num) {
        this.Pagenum = num;
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daohang_front_n);
        findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daohang_rear_n);
        switch (this.Pagenum) {
            case 0:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daohang_front_p);
                break;
            case 2:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daohang_rear_p);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        updatepage(this.Pagenum);
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 18;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                flag = true;
                updatepage(0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                flag = true;
                updatepage(2);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                flag = true;
                if (event.getAction() == 1) {
                    finish();
                    break;
                }
            case R.id.air_xts_mode_munits /* 2131427497 */:
            case R.id.air_xts_mode_plus /* 2131427498 */:
                data0 = 36;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 20;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 16;
                break;
            case R.id.air_xts_mode_plus_right /* 2131428648 */:
            case R.id.air_xts_mode_munits_right /* 2131428649 */:
                data0 = 36;
                break;
            case R.id.air_xts_flowauto /* 2131428650 */:
                data0 = 32;
                break;
            case R.id.btn_air_temp_left_plus_rear /* 2131428654 */:
                data0 = 39;
                break;
            case R.id.btn_air_temp_left_minus_rear /* 2131428656 */:
                data0 = 38;
                break;
            case R.id.dj_xts_air_win_plus_btn_rear /* 2131428657 */:
                data0 = 41;
                break;
            case R.id.dj_xts_air_win_minuts_btn_rear /* 2131428660 */:
                data0 = 40;
                break;
            case R.id.btn_air_temp_right_plus_rear /* 2131428661 */:
                data0 = 47;
                break;
            case R.id.btn_air_temp_right_minus_rear /* 2131428663 */:
                data0 = 46;
                break;
            case R.id.air_xts_power_rear /* 2131428664 */:
                data0 = 44;
                break;
            case R.id.air_xts_auto_rear /* 2131428665 */:
                data0 = 45;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf((((temp * 9) / 5) + 320) / 10));
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf((((temp * 9) / 5) + 320) / 10));
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev0);
                break;
            case 1:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev1);
                break;
            case 2:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev2);
                break;
            case 3:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev3);
                break;
            case 4:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev4);
                break;
            case 5:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev5);
                break;
            case 6:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev6);
                break;
            case 7:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev7);
                break;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(leave));
    }

    
    public void mUpdateAirTempRearLeft() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.tv_air_temp_left_rear) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("HI");
            } else if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf(temp * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf((((temp * 9) / 5) + 320) / 10));
            }
        }
    }

    
    public void mUpdateAirTempRearRight() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[41];
        if (findViewById(R.id.tv_air_temp_right_rear) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("HI");
            } else if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf(temp * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf((((temp * 9) / 5) + 320) / 10));
            }
        }
    }

    
    public void mUpdaterAirWindLevelRear() {
        int leave = DataCanbus.DATA[44];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev0);
                break;
            case 1:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev1);
                break;
            case 2:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev2);
                break;
            case 3:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev3);
                break;
            case 4:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev4);
                break;
            case 5:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev5);
                break;
            case 6:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev6);
                break;
            case 7:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev7);
                break;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel_rear)).setText(String.valueOf(leave));
        findViewById(R.id.air_xts_power_rear).setBackgroundResource(leave == 0 ? R.drawable.ic_daohang_toyota_power_rear_n : R.drawable.ic_daohang_toyota_power_rear_p);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode0);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode0);
                break;
        }
    }

    
    public void updateBtnSourceRight() {
        int body_right = DataCanbus.DATA[19];
        int foot_right = DataCanbus.DATA[20];
        int window_right = DataCanbus.DATA[18];
        int mode_right = 0;
        if (foot_right == 1) {
            mode_right = 0 | 1;
        } else if (foot_right == 0) {
            mode_right = 0 & 254;
        }
        if (body_right == 1) {
            mode_right |= 2;
        } else if (body_right == 0) {
            mode_right &= 253;
        }
        if (window_right == 1) {
            mode_right |= 4;
        } else if (window_right == 0) {
            mode_right &= 251;
        }
        if (findViewById(R.id.air_xts_mode_right) != null) {
            switch (mode_right) {
                case 0:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode3);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode4);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode5);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode6);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode7);
                    break;
                default:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode0);
                    break;
            }
        }
    }
}
