package com.syu.carinfo.golf7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.Print;

@SuppressLint({"CutPasteId"})
@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7Functional_OffRoadCustom_Wc_Acti extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int cmd = -1;
            int val = -1;
            switch (v.getId()) {
                case R.id.wc_golf_4engine_m /* 2131431179 */:
                case R.id.wc_golf_4engine_p /* 2131431181 */:
                    cmd = 3;
                    int val2 = DataCanbus.DATA[257] & 255;
                    if (val2 != 1) {
                        val = 1;
                        break;
                    } else {
                        val = 0;
                        break;
                    }
                case R.id.wc_golf_air_downhill_m /* 2131431186 */:
                case R.id.wc_golf_air_downhill_p /* 2131431188 */:
                    cmd = 7;
                    int val3 = DataCanbus.DATA[259] & 255;
                    if (val3 != 1) {
                        val = 1;
                        break;
                    } else {
                        val = 0;
                        break;
                    }
                case R.id.wc_golf_air_ramp_m /* 2131431190 */:
                case R.id.wc_golf_air_ramp_p /* 2131431192 */:
                    cmd = 8;
                    int val4 = DataCanbus.DATA[260] & 255;
                    if (val4 != 1) {
                        val = 1;
                        break;
                    } else {
                        val = 0;
                        break;
                    }
                case R.id.wc_golf_air_parkassit_m /* 2131431194 */:
                case R.id.wc_golf_air_parkassit_p /* 2131431196 */:
                    cmd = 9;
                    int val5 = DataCanbus.DATA[261] & 255;
                    if (val5 != 1) {
                        val = 1;
                        break;
                    } else {
                        val = 0;
                        break;
                    }
            }
            if (cmd != -1) {
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(cmd, val);
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 255:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uEngine(val);
                    break;
                case 256:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uSteer(val);
                    break;
                case 257:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.u4Engine(val);
                    break;
                case 258:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uAir(val);
                    break;
                case 259:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uDownHill(val);
                    break;
                case 260:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uRamp(val);
                    break;
                case 261:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uParkAssit(val);
                    break;
                case 262:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uBend(val);
                    break;
                case 263:
                    Golf7Functional_OffRoadCustom_Wc_Acti.this.uAcc(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_offroad_driving_info3_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_offroad_driving_info3_wc);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Golf7Functional_OffRoadCustom_Wc_Acti.this.onKeyDown(4, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setClick((Button) findViewById(R.id.wc_golf_air_parkassit_m));
        setClick((Button) findViewById(R.id.wc_golf_air_parkassit_p));
        setClick((Button) findViewById(R.id.wc_golf_air_ramp_m));
        setClick((Button) findViewById(R.id.wc_golf_air_ramp_p));
        setClick((Button) findViewById(R.id.wc_golf_air_downhill_m));
        setClick((Button) findViewById(R.id.wc_golf_air_downhill_p));
        setClick((Button) findViewById(R.id.wc_golf_4engine_m));
        setClick((Button) findViewById(R.id.wc_golf_4engine_p));
        ((Button) findViewById(R.id.wc_golf_bend_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[262] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(5, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_bend_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[262] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(5, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(2, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(2, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[263] & 255;
                Print.log("LG", "value=" + value2);
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(4, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[263] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(4, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                Print.log("LG", "value=" + value2);
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(6, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(6, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[256] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(1, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[256] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(1, value);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_golf_driving_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7Functional_OffRoadCustom_Wc_Acti.this.dialog(R.string.driving_mode_reset);
            }
        });
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(113, new int[]{9, cmd, val}, null, null);
    }

    @Override
    public void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    private void setVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(10, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
    }

    protected void uParkAssit(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.wc_golf_air_parkassit_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_air_parkassit_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_parkassit_txt)).setText(id);
        }
    }

    protected void uRamp(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.wc_golf_air_ramp_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_air_ramp_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_ramp_txt)).setText(id);
        }
    }

    protected void uDownHill(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.wc_golf_air_downhill_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_air_downhill_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_downhill_txt)).setText(id);
        }
    }

    protected void u4Engine(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.wc_golf_4engine_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_4engine_txt)) != null) {
            int id = R.string.driver_system_standard;
            if (val2 == 1) {
                id = R.string.str_17_off_road;
            }
            ((TextView) findViewById(R.id.wc_golf_4engine_txt)).setText(id);
        }
    }

    
    public void uBend(int val) {
        int i = DataCanbus.DATA[262];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.wc_golf_bend_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_bend_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    
    public void uEngine(int val) {
        int i = DataCanbus.DATA[255];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.wc_golf_engine_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_engine_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.str_17_off_road);
            }
        }
    }

    
    public void uAcc(int val) {
        int i = DataCanbus.DATA[263];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.wc_golf_acc_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_acc_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    
    public void uAir(int val) {
        int i = DataCanbus.DATA[258];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.wc_golf_air_condition_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_air_condition_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    
    public void uSteer(int val) {
        int i = DataCanbus.DATA[256];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.wc_golf_steering_view), enable == 1);
        if (((TextView) findViewById(R.id.wc_golf_steering_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.str_driving_sport);
            }
        }
    }
}
