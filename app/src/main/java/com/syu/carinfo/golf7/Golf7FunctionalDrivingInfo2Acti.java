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

@SuppressLint({"CutPasteId"})
public class Golf7FunctionalDrivingInfo2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 195:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D26();
                    break;
                case 196:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D24();
                    break;
                case 197:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D22();
                    break;
                case 198:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D20();
                    break;
                case 199:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D37();
                    break;
                case 200:
                    Golf7FunctionalDrivingInfo2Acti.this.mUpdater86D36();
                    break;
                case 269:
                    Golf7FunctionalDrivingInfo2Acti.this.enable_Wc(DataCanbus.DATA[updateCode]);
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
            //setContentView(R.layout.layout_golf7_functional_driving_info2_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_driving_info2);
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
                        Golf7FunctionalDrivingInfo2Acti.this.onKeyDown(4, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ((Button) findViewById(R.id.wc_golf_dcc_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[195] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_dcc_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[195] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_bend_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[196] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_bend_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[196] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[197] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[197] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[198] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[198] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[199] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[199] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[200] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[200] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{6, value}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
            findViewById(R.id.wc_view_golf_driving_reset).setVisibility(0);
        } else {
            findViewById(R.id.wc_view_golf_driving_reset).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.wc_golf_driving_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalDrivingInfo2Acti.this.dialog(R.string.driving_mode_reset);
            }
        });
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
                        DataCanbus.PROXY.cmd(104, new int[]{7}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdater86D26() {
        int value = DataCanbus.DATA[195];
        if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
            findViewById(R.id.wc_golf_dcc).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_dcc_set_show)) != null) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.wc_golf_dcc_set_show)).setText(R.string.str_driving_comfort);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_dcc_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else {
                    if (value == 2) {
                        ((TextView) findViewById(R.id.wc_golf_dcc_set_show)).setText(R.string.str_driving_sport);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_dcc).setVisibility(8);
    }

    protected void enable_Wc(int i) {
        if (DataCanbus.DATA[1000] == 196625 || DataCanbus.DATA[1000] == 262161 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
            int dcc = (i >> 7) & 1;
            int bend = (i >> 6) & 1;
            int engine = (i >> 5) & 1;
            int acc = (i >> 4) & 1;
            int air = (i >> 3) & 1;
            int steer = (i >> 2) & 1;
            if (findViewById(R.id.wc_golf_dcc) != null) {
                findViewById(R.id.wc_golf_dcc).setVisibility(dcc == 1 ? 0 : 8);
            }
            if (findViewById(R.id.wc_golf_bend) != null) {
                findViewById(R.id.wc_golf_bend).setVisibility(bend == 1 ? 0 : 8);
            }
            if (findViewById(R.id.wc_golf_engine) != null) {
                findViewById(R.id.wc_golf_engine).setVisibility(engine == 1 ? 0 : 8);
            }
            if (findViewById(R.id.wc_golf_acc) != null) {
                findViewById(R.id.wc_golf_acc).setVisibility(acc == 1 ? 0 : 8);
            }
            if (findViewById(R.id.wc_golf_air_condition) != null) {
                findViewById(R.id.wc_golf_air_condition).setVisibility(air == 1 ? 0 : 8);
            }
            if (findViewById(R.id.wc_golf_steering) != null) {
                findViewById(R.id.wc_golf_steering).setVisibility(steer != 1 ? 8 : 0);
            }
        }
    }

    
    public void mUpdater86D24() {
        int value = DataCanbus.DATA[196];
        if (ConstGolf.isWcGolf()) {
            findViewById(R.id.wc_golf_bend).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_bend_set_show)) != null) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_sport);
                    return;
                } else {
                    if (value == 2) {
                        ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_eco);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_bend).setVisibility(8);
    }

    
    public void mUpdater86D22() {
        int value = DataCanbus.DATA[197];
        if (ConstGolf.isWcGolf()) {
            findViewById(R.id.wc_golf_engine).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_engine_set_show)) != null) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.str_driving_sport);
                    return;
                } else {
                    if (value == 2) {
                        ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.str_driving_eco);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_engine).setVisibility(8);
    }

    
    public void mUpdater86D20() {
        int value = DataCanbus.DATA[198];
        if (ConstGolf.isWcGolf()) {
            findViewById(R.id.wc_golf_acc).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_acc_set_show)) != null) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_sport);
                    return;
                } else {
                    if (value == 2) {
                        ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_eco);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_acc).setVisibility(8);
    }

    
    public void mUpdater86D37() {
        int value = DataCanbus.DATA[199];
        if (ConstGolf.isWcGolf()) {
            findViewById(R.id.wc_golf_air_condition).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_air_condition_set_show)) != null) {
                if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else {
                    if (value == 0) {
                        ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.str_driving_eco);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_air_condition).setVisibility(8);
    }

    
    public void mUpdater86D36() {
        int value = DataCanbus.DATA[200];
        if (ConstGolf.isWcGolf()) {
            findViewById(R.id.wc_golf_steering).setVisibility(0);
            if (((TextView) findViewById(R.id.wc_golf_steering_set_show)) != null) {
                if (value == 1) {
                    ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.str_driving_normal);
                    return;
                } else {
                    if (value == 0) {
                        ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.str_driving_sport);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        findViewById(R.id.wc_golf_steering).setVisibility(8);
    }
}
