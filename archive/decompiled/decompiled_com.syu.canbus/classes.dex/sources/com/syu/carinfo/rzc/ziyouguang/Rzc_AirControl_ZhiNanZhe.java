package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_AirControl_ZhiNanZhe extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_AirControl_ZhiNanZhe.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 42:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirAuto();
                    break;
                case 43:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirCycle();
                    break;
                case 44:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirFrontDefrost();
                    break;
                case 45:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirRearDefrost();
                    break;
                case 46:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirAC();
                    break;
                case 47:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirTempLeft();
                    break;
                case 48:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirBlow();
                    break;
                case 49:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirBlow();
                    break;
                case 50:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirBlow();
                    break;
                case 51:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirGoFog();
                    break;
                case 52:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirWindLevel();
                    break;
                case 53:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 54:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirSeatHeatRight();
                    break;
                case 55:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirTempRight();
                    break;
                case 56:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirPower();
                    break;
                case 57:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirTempRight();
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirTempLeft();
                    break;
                case 59:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdateAirSYNC();
                    break;
                case 111:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirSeatBlowLeft();
                    break;
                case 112:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirSeatBlowRight();
                    break;
                case 113:
                    Rzc_AirControl_ZhiNanZhe.this.mUpdaterAirPower();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{31, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{31, 1}, null, null);
                }
                return false;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{30, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{30, 1}, null, null);
                }
                return false;
            case R.id.air_xts_power /* 2131427428 */:
                if (DataCanbus.DATA[56] == 1) {
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{16, 0}, null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                    }
                } else {
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{9, 0}, null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
                    }
                }
                return false;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{28, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{28, 1}, null, null);
                }
                return false;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{29, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{29, 1}, null, null);
                }
                return false;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{48, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{48, 1}, null, null);
                }
                return false;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{50, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{50, 1}, null, null);
                }
                return false;
            case R.id.air_xts_auto /* 2131427436 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{20, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                }
                return false;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{19, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                }
                return false;
            case R.id.air_xts_front /* 2131427438 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{21, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                }
                return false;
            case R.id.air_xts_ac /* 2131427439 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{17, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{17, 1}, null, null);
                }
                return false;
            case R.id.air_xts_maxac /* 2131427440 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{18, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                }
                return false;
            case R.id.air_xts_sync /* 2131427441 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{23, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                }
                return false;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{26, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{26, 1}, null, null);
                }
                return false;
            case R.id.air_xts_mode_body /* 2131427444 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{24, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                }
                return false;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{33, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{33, 1}, null, null);
                }
                return false;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{32, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{32, 1}, null, null);
                }
                return false;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{49, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{49, 1}, null, null);
                }
                return false;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{52, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{52, 1}, null, null);
                }
                return false;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{51, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{51, 1}, null, null);
                }
                return false;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{25, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{25, 1}, null, null);
                }
                return false;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{27, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{27, 1}, null, null);
                }
                return false;
            case R.id.air_xts_rear /* 2131427534 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{22, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                }
                return false;
            default:
                return false;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[47];
        int unit = DataCanbus.DATA[57];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                    break;
                default:
                    switch (DataCanbus.DATA[1000]) {
                        case 373:
                        case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                        case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                        case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                            if (unit == 1) {
                                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
                            } else {
                                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
                            }
                            break;
                        default:
                            if (temp <= 32 && temp >= 1) {
                                float tempval = (temp + 31) * 0.5f;
                                if (unit == 1) {
                                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((9.0f * tempval) / 5.0f) + 32.0f) + "℉");
                                } else {
                                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(tempval + "℃");
                                }
                                break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[55];
        int unit = DataCanbus.DATA[57];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
                    break;
                default:
                    switch (DataCanbus.DATA[1000]) {
                        case 373:
                        case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                        case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                        case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                        case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                            if (unit == 1) {
                                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
                            } else {
                                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
                            }
                            break;
                        default:
                            if (temp <= 32 && temp >= 1) {
                                float tempval = (temp + 31) * 0.5f;
                                if (unit == 1) {
                                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((9.0f * tempval) / 5.0f) + 32.0f) + "℉");
                                } else {
                                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(tempval + "℃");
                                }
                                break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatBlowRight() {
        int level = DataCanbus.DATA[112];
        switch (level) {
            case 0:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatBlowLeft() {
        int level = DataCanbus.DATA[111];
        switch (level) {
            case 0:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatHeatLeft() {
        int level = DataCanbus.DATA[53];
        switch (level) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatHeatRight() {
        int level = DataCanbus.DATA[54];
        switch (level) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[52];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[51];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPower() {
        int value = DataCanbus.DATA[56];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[42];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[59];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[43];
        if (value == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (value == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[46];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[44];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[45];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlow() {
        int up = DataCanbus.DATA[50];
        int body = DataCanbus.DATA[48];
        int foot = DataCanbus.DATA[49];
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (up == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
            return;
        }
        if (up == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (up == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else if (up == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[113];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }
}
