package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KswAudiQ5SetFunc extends BaseActivity {
    static int screenMaxtype = 18;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    KswAudiQ5SetFunc.this.updateCameraType(value);
                    break;
                case 8:
                    KswAudiQ5SetFunc.this.updateMirrorType(value);
                    break;
                case 10:
                    KswAudiQ5SetFunc.this.mUpdaterRadarOn(value);
                    break;
                case 11:
                    KswAudiQ5SetFunc.this.updateTrajectoryOnoff(value);
                    break;
                case 49:
                    KswAudiQ5SetFunc.this.updateLangType(value);
                    break;
                case 50:
                    KswAudiQ5SetFunc.this.updateIDriveType(value);
                    break;
                case 51:
                    KswAudiQ5SetFunc.this.updateScreenType(value);
                    break;
                case 52:
                    KswAudiQ5SetFunc.this.updateEVOType(value);
                    break;
                case 53:
                    KswAudiQ5SetFunc.this.mUpdaterCarUiOn(value);
                    break;
                case 54:
                    KswAudiQ5SetFunc.this.updateAuxKeyNum(value);
                    break;
                case 55:
                    KswAudiQ5SetFunc.this.updateAuxPosition(value);
                    break;
                case 56:
                    KswAudiQ5SetFunc.this.updateAuxHandAuto(value);
                    break;
                case 57:
                    KswAudiQ5SetFunc.this.updateCarBtType(value);
                    break;
                case 58:
                    KswAudiQ5SetFunc.this.backcar = value;
                    KswAudiQ5SetFunc.this.updatebackCartype(value);
                    break;
                case 59:
                    KswAudiQ5SetFunc.this.delayon = value;
                    KswAudiQ5SetFunc.this.updateBackcardelay(value);
                    break;
            }
        }
    };
    int delayon = 0;
    int backcar = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ksw_audiq5_setfunc);
        ((Button) findViewById(R.id.ksw_adui_q5_camera_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[7] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_camera_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[7] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_mirror_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[8] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_mirror_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[8] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_language_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[49] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_language_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[49] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_idrivetype_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[50] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_idrivetype_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[50] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_screentype_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[51];
                if (value > 0) {
                    value--;
                }
                if (value > KswAudiQ5SetFunc.screenMaxtype) {
                    value = KswAudiQ5SetFunc.screenMaxtype;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_screentype_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[51] + 1;
                if (value > KswAudiQ5SetFunc.screenMaxtype) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_evotype_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[52] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_evotype_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[52] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_keynum_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[54] - 1;
                if (value < 1) {
                    value = 8;
                }
                DataCanbus.PROXY.cmd(0, new int[]{160, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_keynum_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[54] + 1;
                if (value > 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{160, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_position_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[55] - 1;
                if (value < 1) {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(0, new int[]{161, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_position_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[55] + 1;
                if (value > 15) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{161, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_auto_hand_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{162, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_auto_hand_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{162, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_carbt_type_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_carbt_type_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_backcar_type_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[58] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((value << 6) & 64) | ((KswAudiQ5SetFunc.this.delayon << 7) & 128)) & 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_backcar_type_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[58] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((value << 6) & 64) | ((KswAudiQ5SetFunc.this.delayon << 7) & 128)) & 255}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[59];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((KswAudiQ5SetFunc.this.backcar << 6) & 64) | ((value << 7) & 128)) & 255}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[53];
                DataCanbus.PROXY.cmd(0, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[10];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{23, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{22, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackcardelay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatebackCartype(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_backcar_type)).setText(R.string.str_8836_backcar);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_backcar_type)).setText(R.string.str_add_backcar);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarBtType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_carbt_type)).setText(R.string.str_after_addbt);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_carbt_type)).setText(R.string.dj_14b70_bt_str);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuxHandAuto(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_aux_auto_hand)).setText(R.string.klc_air_auto);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_aux_auto_hand)).setText(R.string.klc_air_Manual);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuxPosition(int value) {
        ((TextView) findViewById(R.id.tv_lz_bmw_aux_position)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuxKeyNum(int value) {
        ((TextView) findViewById(R.id.tv_lz_bmw_aux_keynum)).setText("Key" + value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEVOType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_evotype)).setText("6.5″");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_evotype)).setText("8.8″");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_lz_bmw_evotype)).setText("8.8″ H");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CIC8.8 Full");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CIC6.5 Half");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CIC6.5 Full");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("NBT/EVO6.5 Full");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("NBT/EVO6.5 Half");
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("NBT/EVO8.8 Full");
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC6.5 Full");
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC6.5 Half");
                break;
            case 8:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC8.8 Full");
                break;
            case 9:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC8.8 Half");
                break;
            case 10:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC6.5_2008 Full");
                break;
            case 11:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC6.5_2008 Half");
                break;
            case 12:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC8.8_E60 Full");
                break;
            case 13:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("CCC8.8_2008 Full");
                break;
            case 14:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText(new StringBuilder().append(value).toString());
                break;
            case 15:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText(new StringBuilder().append(value).toString());
                break;
            case 16:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText(new StringBuilder().append(value).toString());
                break;
            case 17:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText(new StringBuilder().append(value).toString());
                break;
            case 18:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText(new StringBuilder().append(value).toString());
                break;
            default:
                ((TextView) findViewById(R.id.tv_lz_bmw_screentype)).setText("invalid");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIDriveType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_idrivetype)).setText("IDrive_A(CIC)");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_idrivetype)).setText("IDrive_B(CCC)");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLangType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_lz_bmw_language)).setText(R.string.wc_psa_all_lauguage_set_value_1);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_lz_bmw_language)).setText(R.string.rzc_others_language_setting_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_lz_bmw_language)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMirrorType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ksw_adui_q5_mirror)).setText(R.string.normal);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ksw_adui_q5_mirror)).setText(R.string.str_leftright_mirror);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCameraType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_ksw_adui_q5_camera)).setText(R.string.str_after_device);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_ksw_adui_q5_camera)).setText(R.string.str_car_device);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_ksw_adui_q5_camera)).setText(R.string.str_car_360device);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUiOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrajectoryOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)).setChecked(value == 1);
        }
    }
}
