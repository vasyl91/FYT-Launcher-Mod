package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalTyresActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 124:
                    Golf7FunctionalTyresActi.this.mUpdaterTyresSpeedWarnning();
                    break;
                case 125:
                    Golf7FunctionalTyresActi.this.mUpdaterTyresSpeedWarnningValue();
                    break;
                case 253:
                    Golf7FunctionalTyresActi.this.uDirectTireDetect(DataCanbus.DATA[updateCode]);
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
            //setContentView(R.layout.layout_golf7_functional_state_tyres_setting_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_tyres_setting);
        }
        init();
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(45, null, null, null);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
    }

    protected void uDirectTireDetect(int i) {
        int id;
        if (((TextView) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_txt)) != null) {
            if (DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                int enable = (65280 & i) >> 8;
                int switchOn = i & 255;
                setViewVisible(findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_view), enable != 0);
                id = R.string.driver_system_standard;
                if (switchOn == 1) {
                    id = R.string.str_driving_comfort;
                } else if (switchOn == 2) {
                    id = R.string.str_tuang_str1;
                }
            } else {
                id = R.string.str_driving_comfort;
                if (i == 1) {
                    id = R.string.driver_system_standard;
                } else if (i == 2) {
                    id = R.string.str_tuang_str1;
                }
            }
            if (id != -1) {
                ((TextView) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_txt)).setText(id);
            }
        }
    }

    
    public void mUpdaterTyresSpeedWarnning() {
        int value = DataCanbus.DATA[124];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_tpres_setting_speed_warning), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_speed_warning), switchOn != 0);
            if (enable != 0) {
                setViewVisible(findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at), switchOn != 0);
                return;
            } else {
                setViewVisible(findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at), true);
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_tpres_setting_speed_warning), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_speed_warning), value != 0);
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalTyresActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalTyresActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_tpms), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalTyresActi.this.dialog();
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_speed_warning), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(46, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ConstGolf.isWcGolf()) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value < 30) {
                        value = 30;
                    } else if (value > 240) {
                        value = 240;
                    }
                    if (value > 30) {
                        value -= 10;
                    }
                    DataCanbus.PROXY.cmd(47, new int[]{value}, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value2) >> 8;
                int mValue = value2 & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value2 > 240) {
                        mValue = 240;
                    }
                    if (mValue > 30) {
                        mValue -= 10;
                    }
                } else {
                    if (mValue < 20) {
                        mValue = 20;
                    } else if (mValue > 150) {
                        mValue = 150;
                    }
                    if (mValue > 20) {
                        mValue -= 5;
                    }
                }
                DataCanbus.PROXY.cmd(47, new int[]{mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ConstGolf.isWcGolf()) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value < 30) {
                        value = 30;
                    } else if (value > 240) {
                        value = 240;
                    }
                    if (value < 240) {
                        value += 10;
                    }
                    DataCanbus.PROXY.cmd(47, new int[]{value}, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value2) >> 8;
                int mValue = value2 & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value2 > 240) {
                        mValue = 240;
                    }
                    if (mValue < 240) {
                        mValue += 10;
                    }
                } else {
                    if (mValue < 20) {
                        mValue = 20;
                    } else if (mValue > 150) {
                        mValue = 150;
                    }
                    if (mValue < 150) {
                        mValue += 5;
                    }
                }
                DataCanbus.PROXY.cmd(47, new int[]{mValue}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 327840) {
            setViewVisible(findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_view), true);
        } else {
            setViewVisible(findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_view), false);
        }
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int i = (DataCanbus.DATA[253] & 255) - 1;
                if (i < 0) {
                    i = 0;
                }
                if (DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                    DataCanbus.PROXY.cmd(114, new int[]{i}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(103, new int[]{35, i}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int i = (DataCanbus.DATA[253] & 255) + 1;
                if (i > 2) {
                    i = 2;
                }
                if (DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                    DataCanbus.PROXY.cmd(114, new int[]{i}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(103, new int[]{35, i}, null, null);
                }
            }
        });
    }

    
    public void mUpdaterTyresSpeedWarnningValue() {
        int value = DataCanbus.DATA[125];
        int unit = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            ((TextView) findViewById(R.id.glf7_tv_functional_tpres_setting_warnint_at)).setText(String.valueOf(mValue) + "km/h");
        } else if (unit == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_tpres_setting_warnint_at)).setText(String.valueOf(mValue) + "km/h");
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_tpres_setting_warnint_at)).setText(String.valueOf(mValue) + "mph");
        }
    }
}
