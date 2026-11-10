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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
@SuppressLint({"CutPasteId"})
public class Golf7Functional_OffRoadCustom_Wc_Acti extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int cmd = -1;
            int val = -1;
            switch (v.getId()) {
                case R.id.btn_minus3 /* 2131427425 */:
                case R.id.btn_plus3 /* 2131427427 */:
                    cmd = 3;
                    int val2 = DataCanbus.DATA[257] & 255;
                    val = val2 != 1 ? 1 : 0;
                    break;
                case R.id.btn_plus7 /* 2131427431 */:
                case R.id.btn_minus7 /* 2131427478 */:
                    cmd = 7;
                    int val3 = DataCanbus.DATA[259] & 255;
                    val = val3 != 1 ? 1 : 0;
                    break;
                case R.id.btn_plus8 /* 2131427432 */:
                case R.id.btn_minus8 /* 2131427480 */:
                    cmd = 8;
                    int val4 = DataCanbus.DATA[260] & 255;
                    val = val4 != 1 ? 1 : 0;
                    break;
                case R.id.btn_plus9 /* 2131427433 */:
                case R.id.btn_minus9 /* 2131427482 */:
                    cmd = 9;
                    int val5 = DataCanbus.DATA[261] & 255;
                    val = val5 != 1 ? 1 : 0;
                    break;
            }
            if (cmd != -1) {
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(cmd, val);
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.2
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.layout_golf7_functional_offroad_driving_info3_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_offroad_driving_info3_wc);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Golf7Functional_OffRoadCustom_Wc_Acti.this.onKeyDown(4, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setClick((Button) findViewById(R.id.btn_minus9));
        setClick((Button) findViewById(R.id.btn_plus9));
        setClick((Button) findViewById(R.id.btn_minus8));
        setClick((Button) findViewById(R.id.btn_plus8));
        setClick((Button) findViewById(R.id.btn_minus7));
        setClick((Button) findViewById(R.id.btn_plus7));
        setClick((Button) findViewById(R.id.btn_minus3));
        setClick((Button) findViewById(R.id.btn_plus3));
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.4
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.5
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(2, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(2, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.8
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.9
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.10
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.11
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.12
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.13
            @Override // android.view.View.OnClickListener
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7Functional_OffRoadCustom_Wc_Acti.this.dialog(R.string.driving_mode_reset);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(113, new int[]{9, cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Golf7Functional_OffRoadCustom_Wc_Acti.this.sendCMD(10, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7Functional_OffRoadCustom_Wc_Acti.16
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
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // com.syu.canbus.BaseActivity
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
        setVisible(findViewById(R.id.layout_view9), enable == 1);
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.tv_text9)).setText(id);
        }
    }

    protected void uRamp(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.layout_view8), enable == 1);
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(id);
        }
    }

    protected void uDownHill(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.layout_view7), enable == 1);
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.tv_text7)).setText(id);
        }
    }

    protected void u4Engine(int val) {
        int enable = val >> 8;
        int val2 = val & 255;
        setVisible(findViewById(R.id.layout_view3), enable == 1);
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            int id = R.string.driver_system_standard;
            if (val2 == 1) {
                id = R.string.str_17_off_road;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBend(int val) {
        int i = DataCanbus.DATA[262];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.layout_view5), enable == 1);
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uEngine(int val) {
        int i = DataCanbus.DATA[255];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.layout_view2), enable == 1);
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_17_off_road);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAcc(int val) {
        int i = DataCanbus.DATA[263];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.layout_view4), enable == 1);
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAir(int val) {
        int i = DataCanbus.DATA[258];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.layout_view6), enable == 1);
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSteer(int val) {
        int i = DataCanbus.DATA[256];
        int enable = val >> 8;
        int value = val & 255;
        setVisible(findViewById(R.id.layout_view1), enable == 1);
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
            }
        }
    }
}
