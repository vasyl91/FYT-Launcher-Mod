package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class XpZHFordAirControlAct extends Activity implements View.OnTouchListener {
    public static XpZHFordAirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    XpZHFordAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    XpZHFordAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    XpZHFordAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    XpZHFordAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    XpZHFordAirControlAct.this.mUpdateDualOn();
                    break;
                case 15:
                    XpZHFordAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 16:
                    XpZHFordAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    XpZHFordAirControlAct.this.mUpdaterBlowWindow();
                    XpZHFordAirControlAct.this.updateBtnSource();
                    break;
                case 19:
                    XpZHFordAirControlAct.this.mUpdaterBlowBodyLeftOn();
                    XpZHFordAirControlAct.this.updateBtnSource();
                    break;
                case 20:
                    XpZHFordAirControlAct.this.mUpdaterBlowFootLeftOn();
                    XpZHFordAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    XpZHFordAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    XpZHFordAirControlAct.this.mUpdateAirTempLeft();
                    if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
                        XpZHFordAirControlAct.this.mUpdateAirTempRight();
                        break;
                    }
                case 28:
                    if (DataCanbus.DATA[1000] != 1900997 && DataCanbus.DATA[1000] != 2032069) {
                        XpZHFordAirControlAct.this.mUpdateAirTempRight();
                        break;
                    }
                case 29:
                    XpZHFordAirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    XpZHFordAirControlAct.this.mUpdaterSeatHeatRight();
                    break;
                case 31:
                    XpZHFordAirControlAct.this.mUpdaterSeatColdLeft();
                    break;
                case 32:
                    XpZHFordAirControlAct.this.mUpdaterSeatColdRight();
                    break;
                case 37:
                case 75:
                    XpZHFordAirControlAct.this.mUpdateAirTempLeft();
                    XpZHFordAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 53:
                    XpZHFordAirControlAct.this.mUpdateAcMAxOn();
                    break;
            }
        }
    };

    private void sendCmd(int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{172, cmd}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{172}, null, null);
            }
        }, 100L);
        mInstance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 1900997) {
            //setContentView(R.layout.layout_0452_zh_13explorer_hand_air_control);
        } else if (DataCanbus.DATA[1000] == 1966533) {
            //setContentView(R.layout.layout_0452_zh_13explorer_auto_air_control);
        } else if (DataCanbus.DATA[1000] == 2032069) {
            //setContentView(R.layout.layout_0452_zh_16explorer_hand_air_control);
        } else {
            //setContentView(R.layout.layout_0443_wc_18ruijie_air_control);
        }
        init();
    }

    private void init() {
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rearpage) != null) {
            findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_minuts_btn) != null) {
            findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_plus_btn) != null) {
            findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_plus) != null) {
            findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_minus) != null) {
            findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seatwin_left) != null) {
            findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_cycle) != null) {
            findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seatwin_right) != null) {
            findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode) != null) {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
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
                data0 = 36;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 35;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 39;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 40;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 43;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 7;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 45;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 23;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 34;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 33;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 32;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) XpZHFordRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 38;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 37;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 44;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 46;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 24;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 6;
                break;
        }
        if (!flag && event.getAction() == 0) {
            if (data0 == 39) {
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 1966533) {
                    int leave = DataCanbus.DATA[21];
                    if (leave > 0) {
                        leave--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{173, leave}, null, null);
                } else {
                    sendCmd(data0);
                }
            } else if (data0 == 40) {
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 1966533) {
                    int leave2 = DataCanbus.DATA[21];
                    if (leave2 < 7) {
                        leave2++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{173, leave2}, null, null);
                } else {
                    sendCmd(data0);
                }
            } else if (data0 == 35) {
                int leave3 = DataCanbus.DATA[27];
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
                    if (leave3 > 0) {
                        leave3--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{174, leave3}, null, null);
                } else {
                    int unit = DataCanbus.DATA[37];
                    if (unit == 0) {
                        if (leave3 == -2) {
                            leave3 = 30;
                        } else if (leave3 == -3) {
                            leave3 = 59;
                        } else if (leave3 == -1) {
                            leave3 = 30;
                        } else if (leave3 >= 31 && leave3 <= 59) {
                            leave3--;
                        }
                    } else if (leave3 == -2) {
                        leave3 = 119;
                    } else if (leave3 == -3) {
                        leave3 = 170;
                    } else if (leave3 == -1) {
                        leave3 = 119;
                    } else if (leave3 >= 120 && leave3 <= 170) {
                        leave3--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{170, leave3}, null, null);
                }
            } else if (data0 == 36) {
                int leave4 = DataCanbus.DATA[27];
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
                    if (leave4 < 30) {
                        leave4++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{174, leave4}, null, null);
                } else {
                    int unit2 = DataCanbus.DATA[37];
                    if (unit2 == 0) {
                        if (leave4 == -2) {
                            leave4 = 31;
                        } else if (leave4 == -3) {
                            leave4 = 60;
                        } else if (leave4 == -1) {
                            leave4 = 30;
                        } else if (leave4 >= 31 && leave4 <= 59) {
                            leave4++;
                        }
                    } else if (leave4 == -2) {
                        leave4 = 120;
                    } else if (leave4 == -3) {
                        leave4 = 171;
                    } else if (leave4 == -1) {
                        leave4 = 171;
                    } else if (leave4 >= 120 && leave4 <= 170) {
                        leave4++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{170, leave4}, null, null);
                }
            } else if (data0 == 37) {
                int leave5 = DataCanbus.DATA[28];
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
                    int leave6 = DataCanbus.DATA[27];
                    if (leave6 > 0) {
                        leave6--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{174, leave6}, null, null);
                } else {
                    int unit3 = DataCanbus.DATA[37];
                    if (unit3 == 0) {
                        if (leave5 == -2) {
                            leave5 = 30;
                        } else if (leave5 == -3) {
                            leave5 = 59;
                        } else if (leave5 == -1) {
                            leave5 = 30;
                        } else if (leave5 >= 31 && leave5 <= 59) {
                            leave5--;
                        }
                    } else if (leave5 == -2) {
                        leave5 = 119;
                    } else if (leave5 == -3) {
                        leave5 = 170;
                    } else if (leave5 == -1) {
                        leave5 = 119;
                    } else if (leave5 >= 120 && leave5 <= 170) {
                        leave5--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{171, leave5}, null, null);
                }
            } else if (data0 == 38) {
                int leave7 = DataCanbus.DATA[28];
                if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
                    int leave8 = DataCanbus.DATA[27];
                    if (leave8 < 30) {
                        leave8++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{174, leave8}, null, null);
                } else {
                    int unit4 = DataCanbus.DATA[37];
                    if (unit4 == 0) {
                        if (leave7 == -2) {
                            leave7 = 31;
                        } else if (leave7 == -3) {
                            leave7 = 60;
                        } else if (leave7 == -1) {
                            leave7 = 30;
                        } else if (leave7 >= 31 && leave7 <= 59) {
                            leave7++;
                        }
                    } else if (leave7 == -2) {
                        leave7 = 120;
                    } else if (leave7 == -3) {
                        leave7 = 171;
                    } else if (leave7 == -1) {
                        leave7 = 171;
                    } else if (leave7 >= 120 && leave7 <= 170) {
                        leave7++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{171, leave7}, null, null);
                }
            } else {
                sendCmd(data0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatColdRight() {
        int value = DataCanbus.DATA[32];
        if (findViewById(R.id.air_xts_seatwin_right) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                    break;
            }
        }
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                    break;
            }
        }
    }

    
    public void mUpdaterSeatColdLeft() {
        int value = DataCanbus.DATA[31];
        if (findViewById(R.id.air_xts_seatwin_left) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                    break;
            }
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                    break;
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int value = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        int type = DataCanbus.DATA[75];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (type == 1) {
                if (value == -2) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    return;
                }
                if (value == -3) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    return;
                }
                if (value == -1) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
                    return;
                } else if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value * 0.5f) + "℃");
                    return;
                } else {
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 2) + "℉");
                        return;
                    }
                    return;
                }
            }
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (value == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (value > 0 && value < 30) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((value * 5) + 160) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int value = DataCanbus.DATA[28];
        if (DataCanbus.DATA[1000] == 1900997 || DataCanbus.DATA[1000] == 2032069) {
            value = DataCanbus.DATA[27];
        }
        int unit = DataCanbus.DATA[37];
        int type = DataCanbus.DATA[75];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (type == 1) {
                if (value == -2) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    return;
                }
                if (value == -3) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    return;
                }
                if (value == -1) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
                    return;
                } else if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value * 0.5f) + "℃");
                    return;
                } else {
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 2) + "℉");
                        return;
                    }
                    return;
                }
            }
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (value == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (value > 0 && value < 30) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((value * 5) + 160) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdateAcMAxOn() {
        int acOn = DataCanbus.DATA[53];
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[15];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        if (findViewById(R.id.dj_xts_air_winlevel) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        }
    }

    
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[19];
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[20];
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[18];
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
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
        if (findViewById(R.id.air_xts_mode) != null) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
    }
}
