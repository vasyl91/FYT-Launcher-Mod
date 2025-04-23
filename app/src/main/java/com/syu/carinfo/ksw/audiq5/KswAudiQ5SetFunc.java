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

public class KswAudiQ5SetFunc extends BaseActivity {
    static int screenMaxtype = 18;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    KswAudiQ5SetFunc.this.updateCameraType(value);
                    break;
                case 99:
                    KswAudiQ5SetFunc.this.updateMirrorType(value);
                    break;
                case 101:
                    KswAudiQ5SetFunc.this.mUpdaterRadarOn(value);
                    break;
                case 102:
                    KswAudiQ5SetFunc.this.updateTrajectoryOnoff(value);
                    break;
                case 118:
                    KswAudiQ5SetFunc.this.updateLangType(value);
                    break;
                case 119:
                    KswAudiQ5SetFunc.this.updateIDriveType(value);
                    break;
                case 120:
                    KswAudiQ5SetFunc.this.updateScreenType(value);
                    break;
                case 121:
                    KswAudiQ5SetFunc.this.updateEVOType(value);
                    break;
                case 122:
                    KswAudiQ5SetFunc.this.mUpdaterCarUiOn(value);
                    break;
                case 123:
                    KswAudiQ5SetFunc.this.updateAuxKeyNum(value);
                    break;
                case 124:
                    KswAudiQ5SetFunc.this.updateAuxPosition(value);
                    break;
                case 125:
                    KswAudiQ5SetFunc.this.updateAuxHandAuto(value);
                    break;
                case 126:
                    KswAudiQ5SetFunc.this.updateCarBtType(value);
                    break;
                case 127:
                    KswAudiQ5SetFunc.this.backcar = value;
                    KswAudiQ5SetFunc.this.updatebackCartype(value);
                    break;
                case 128:
                    KswAudiQ5SetFunc.this.delayon = value;
                    KswAudiQ5SetFunc.this.updateBackcardelay(value);
                    break;
            }
        }
    };
    int delayon = 0;
    int backcar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_ksw_audiq5_setfunc);
        ((Button) findViewById(R.id.ksw_adui_q5_camera_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_camera_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_mirror_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.ksw_adui_q5_mirror_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[99] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_language_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_language_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_idrivetype_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_idrivetype_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_screentype_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120];
                if (value > 0) {
                    value--;
                }
                if (value > KswAudiQ5SetFunc.screenMaxtype) {
                    value = KswAudiQ5SetFunc.screenMaxtype;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_screentype_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value > KswAudiQ5SetFunc.screenMaxtype) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_evotype_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_evotype_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_keynum_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] - 1;
                if (value < 1) {
                    value = 8;
                }
                DataCanbus.PROXY.cmd(0, new int[]{160, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_keynum_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] + 1;
                if (value > 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{160, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_position_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] - 1;
                if (value < 1) {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(0, new int[]{161, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_position_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] + 1;
                if (value > 15) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{161, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_auto_hand_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{162, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_aux_auto_hand_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{162, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_carbt_type_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_carbt_type_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_backcar_type_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((value << 6) & 64) | ((KswAudiQ5SetFunc.this.delayon << 7) & 128)) & 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.lz_bmw_backcar_type_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((value << 6) & 64) | ((KswAudiQ5SetFunc.this.delayon << 7) & 128)) & 255}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, (((KswAudiQ5SetFunc.this.backcar << 6) & 64) | ((value << 7) & 128)) & 255}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122];
                DataCanbus.PROXY.cmd(0, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[101];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{23, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[102];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{22, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
    }

    
    public void updateBackcardelay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_lz_bmw_backcar_delay_onoff)).setChecked(value == 1);
        }
    }

    
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

    
    public void updateAuxPosition(int value) {
        ((TextView) findViewById(R.id.tv_lz_bmw_aux_position)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateAuxKeyNum(int value) {
        ((TextView) findViewById(R.id.tv_lz_bmw_aux_keynum)).setText("Key" + value);
    }

    
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

    
    public void mUpdaterCarUiOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_carui_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterRadarOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_radar_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateTrajectoryOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_ksw_adui_q5_trajectory_onoff)).setChecked(value == 1);
        }
    }
}
