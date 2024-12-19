package com.syu.carinfo.golf7_xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalTyresActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 27:
                    Golf7_XP_FunctionalTyresActi.this.mUpdaterTyresSpeedWarnning();
                    break;
                case 28:
                    Golf7_XP_FunctionalTyresActi.this.mUpdaterTyresSpeedWarnningValue();
                    break;
                case 171:
                    Golf7_XP_FunctionalTyresActi.this.uDirectTireDetect(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_tyres_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_tpms), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalTyresActi.this.dialog();
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_speed_warning), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] & 255;
                int unit = (65280 & value) >> 8;
                int mValue = value & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value > 240) {
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
                DataCanbus.PROXY.cmd(107, new int[]{33, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_warnint_at_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] & 255;
                int unit = (65280 & value) >> 8;
                int mValue = value & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value > 240) {
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
                DataCanbus.PROXY.cmd(107, new int[]{33, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_m), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i = (DataCanbus.DATA[171] & 255) - 1;
                if (i < 0) {
                    i = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{35, i}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_p), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i = (DataCanbus.DATA[171] & 255) + 1;
                if (i > 2) {
                    i = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{35, i}, null, null);
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{34, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
    }

    protected void uDirectTireDetect(int i) {
        if (((TextView) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_txt)) != null) {
            int id = R.string.str_driving_comfort;
            if (i == 1) {
                id = R.string.driver_system_standard;
            } else if (i == 2) {
                id = R.string.str_tuang_str1;
            }
            if (id != -1) {
                ((TextView) findViewById(R.id.glf7_btn_functional_tpres_setting_direct_detect_txt)).setText(id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnning() {
        int value = DataCanbus.DATA[27];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_tpres_setting_speed_warning), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnningValue() {
        int value = DataCanbus.DATA[28];
        int unit = (65280 & value) >> 8;
        int mValue = value & 255;
        if (unit == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_tpres_setting_warnint_at)).setText(String.valueOf(mValue) + "km/h");
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_tpres_setting_warnint_at)).setText(String.valueOf(mValue) + "mph");
        }
    }
}
