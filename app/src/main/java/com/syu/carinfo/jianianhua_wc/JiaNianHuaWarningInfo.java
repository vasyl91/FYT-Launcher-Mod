package com.syu.carinfo.jianianhua_wc;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JiaNianHuaWarningInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    JiaNianHuaWarningInfo.this.Warning_check();
                    break;
                case 99:
                    JiaNianHuaWarningInfo.this.Last_OilWarning();
                    break;
                case 100:
                    JiaNianHuaWarningInfo.this.SafetyBelt();
                    break;
                case 101:
                    JiaNianHuaWarningInfo.this.CleanLiquid();
                    break;
                case 102:
                    JiaNianHuaWarningInfo.this.Handlebreak();
                    break;
                case 103:
                    JiaNianHuaWarningInfo.this.LastOil();
                    break;
                case 104:
                    JiaNianHuaWarningInfo.this.Battery();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jianianhua_warning_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    @Override
    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void Warning_check() {
        int value = DataCanbus.DATA[98];
        if (value == 0) {
            ((TextView) findViewById(R.id.wc_jianianhua_1)).setVisibility(8);
            ((TextView) findViewById(R.id.wc_jianianhua_2)).setVisibility(8);
            ((TextView) findViewById(R.id.wc_jianianhua_3)).setVisibility(8);
            ((TextView) findViewById(R.id.wc_jianianhua_4)).setVisibility(8);
            ((TextView) findViewById(R.id.wc_jianianhua_5)).setVisibility(8);
            ((TextView) findViewById(R.id.wc_jianianhua_6)).setVisibility(8);
            return;
        }
        ((TextView) findViewById(R.id.wc_jianianhua_1)).setVisibility(0);
        ((TextView) findViewById(R.id.wc_jianianhua_2)).setVisibility(0);
        ((TextView) findViewById(R.id.wc_jianianhua_3)).setVisibility(0);
        ((TextView) findViewById(R.id.wc_jianianhua_4)).setVisibility(0);
        ((TextView) findViewById(R.id.wc_jianianhua_5)).setVisibility(0);
        ((TextView) findViewById(R.id.wc_jianianhua_6)).setVisibility(0);
    }

    
    public void Last_OilWarning() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[99];
            if (((TextView) findViewById(R.id.wc_jianianhua_1)) != null) {
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_0);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_1);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_2);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_3);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_4);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_5);
                }
                if ((value1 & 64) == 64) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_6);
                }
                if ((value1 & 128) == 128) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText(R.string.wc_jianianhua_warning_7);
                }
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_1)).setText("");
                }
            }
        }
    }

    
    public void SafetyBelt() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[100];
            if (((TextView) findViewById(R.id.wc_jianianhua_2)) != null) {
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_8);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_9);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_10);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_11);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_12);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_13);
                }
                if ((value1 & 64) == 64) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_14);
                }
                if ((value1 & 128) == 128) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText(R.string.wc_jianianhua_warning_15);
                }
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_2)).setText("");
                }
            }
        }
    }

    
    public void CleanLiquid() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[101];
            if (((TextView) findViewById(R.id.wc_jianianhua_3)) != null) {
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText("");
                }
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_16);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_17);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_18);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_19);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_20);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_21);
                }
                if ((value1 & 64) == 64) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_22);
                }
                if ((value1 & 128) == 128) {
                    ((TextView) findViewById(R.id.wc_jianianhua_3)).setText(R.string.wc_jianianhua_warning_23);
                }
            }
        }
    }

    
    public void Handlebreak() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[102];
            if (((TextView) findViewById(R.id.wc_jianianhua_4)) != null) {
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText("");
                }
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_24);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_25);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_26);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_27);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_28);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_29);
                }
                if ((value1 & 64) == 64) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_30);
                }
                if ((value1 & 128) == 128) {
                    ((TextView) findViewById(R.id.wc_jianianhua_4)).setText(R.string.wc_jianianhua_warning_31);
                }
            }
        }
    }

    
    public void LastOil() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[103];
            if (((TextView) findViewById(R.id.wc_jianianhua_5)) != null) {
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText("");
                }
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_32);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_33);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_34);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_35);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_36);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_37);
                }
                if ((value1 & 64) == 64) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_38);
                }
                if ((value1 & 128) == 128) {
                    ((TextView) findViewById(R.id.wc_jianianhua_5)).setText(R.string.wc_jianianhua_warning_39);
                }
            }
        }
    }

    
    public void Battery() {
        int value = DataCanbus.DATA[98];
        if (value != 0) {
            int value1 = DataCanbus.DATA[104];
            if (((TextView) findViewById(R.id.wc_jianianhua_6)) != null) {
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText("");
                }
                if ((value1 & 1) == 1) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_40);
                }
                if ((value1 & 2) == 2) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_41);
                }
                if ((value1 & 4) == 4) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_42);
                }
                if ((value1 & 8) == 8) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_43);
                }
                if ((value1 & 16) == 16) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_44);
                }
                if ((value1 & 32) == 32) {
                    ((TextView) findViewById(R.id.wc_jianianhua_6)).setText(R.string.wc_jianianhua_warning_45);
                }
            }
        }
    }
}
