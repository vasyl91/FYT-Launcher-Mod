package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Acti_BNR_ShengDaFei extends BaseActivity {
    private int[] resIDs = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 98, 99};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.Acti_BNR_ShengDaFei.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    Acti_BNR_ShengDaFei.this.uCurSpeed(value);
                    break;
                case 99:
                    Acti_BNR_ShengDaFei.this.uEngineSpeed(value);
                    break;
                case 101:
                    Acti_BNR_ShengDaFei.this.uSelfDetect(value);
                    break;
                case 102:
                    Acti_BNR_ShengDaFei.this.uTireFL(value);
                    break;
                case 103:
                    Acti_BNR_ShengDaFei.this.uTempFL(value);
                    break;
                case 104:
                    Acti_BNR_ShengDaFei.this.uBatteryFL(value);
                    break;
                case 105:
                    Acti_BNR_ShengDaFei.this.uWarnFL(value);
                    break;
                case 106:
                    Acti_BNR_ShengDaFei.this.uTireFR(value);
                    break;
                case 107:
                    Acti_BNR_ShengDaFei.this.uTempFR(value);
                    break;
                case 108:
                    Acti_BNR_ShengDaFei.this.uBatteryFR(value);
                    break;
                case 109:
                    Acti_BNR_ShengDaFei.this.uWarnFR(value);
                    break;
                case 110:
                    Acti_BNR_ShengDaFei.this.uTireRL(value);
                    break;
                case 111:
                    Acti_BNR_ShengDaFei.this.uTempRL(value);
                    break;
                case 112:
                    Acti_BNR_ShengDaFei.this.uBatteryRL(value);
                    break;
                case 113:
                    Acti_BNR_ShengDaFei.this.uWarnRL(value);
                    break;
                case 114:
                    Acti_BNR_ShengDaFei.this.uTireRR(value);
                    break;
                case 115:
                    Acti_BNR_ShengDaFei.this.uTempRR(value);
                    break;
                case 116:
                    Acti_BNR_ShengDaFei.this.uBatteryRR(value);
                    break;
                case 117:
                    Acti_BNR_ShengDaFei.this.uWarnRR(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_bnr_shengdafei_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        for (int i = 0; i < this.resIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.resIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    private void setTxt(TextView tv, String str) {
        if (tv != null) {
            tv.setText(str);
        }
    }

    protected void uCurSpeed(int value) {
        setTxt((TextView) findViewById(R.id.tv_text14), String.valueOf(value) + "km/h");
    }

    protected void uEngineSpeed(int value) {
        setTxt((TextView) findViewById(R.id.tv_text15), String.valueOf(value) + "rpm");
    }

    private void setTxt(TextView tv, int id) {
        if (tv != null) {
            if (id == -1) {
                tv.setText("");
            } else {
                tv.setText(id);
            }
        }
    }

    protected void uSelfDetect(int value) {
        int id = -1;
        if (value == 1) {
            id = R.string.wc_damaix5_str1;
        } else if (value == 2) {
            id = R.string.klc_onstar_call_alarm_status;
        }
        setTxt((TextView) findViewById(R.id.tv_text1), id);
    }

    protected void uTireFL(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text4);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRR(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text10);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRL(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text7);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireFR(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text13);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnRR(int value) {
        setWarnText((TextView) findViewById(R.id.tv_text10), value);
        TextView txt = (TextView) findViewById(R.id.tv_text10);
        if (value == 0) {
            setTires(txt, DataCanbus.DATA[114]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnRL(int value) {
        setWarnText((TextView) findViewById(R.id.tv_text7), value);
        TextView txt = (TextView) findViewById(R.id.tv_text7);
        if (value == 0) {
            setTires(txt, DataCanbus.DATA[110]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnFR(int value) {
        setWarnText((TextView) findViewById(R.id.tv_text13), value);
        TextView txt = (TextView) findViewById(R.id.tv_text13);
        if (value == 0) {
            setTires(txt, DataCanbus.DATA[106]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnFL(int value) {
        setWarnText((TextView) findViewById(R.id.tv_text4), value);
        TextView txt = (TextView) findViewById(R.id.tv_text4);
        if (value == 0) {
            setTires(txt, DataCanbus.DATA[102]);
        }
    }

    private void setTires(TextView txt, int value) {
        int bitHight = (value >> 7) & 1;
        int bitLow = (value >> 6) & 1;
        if (bitHight != 0) {
            setTxt(txt, R.string.tireflhigh);
            return;
        }
        if (bitLow != 0) {
            setTxt(txt, R.string.tirefllow);
        } else if (value >= 0 && value <= 62) {
            setTxt(txt, String.valueOf(value / 10.0f) + "Bar");
        } else {
            setTxt(txt, "--");
        }
    }

    private void setWarnText(TextView txt, int value) {
        if (txt != null) {
            if (((value >> 7) & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str7);
                return;
            }
            if (((value >> 6) & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str2);
                return;
            }
            if (((value >> 5) & 1) == 1) {
                setTxt(txt, R.string.str_408_carinfo_81_1);
            } else if (((value >> 4) & 1) == 1) {
                setTxt(txt, R.string.str_focus_warm_8_7);
            } else if ((value & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str8);
            }
        }
    }

    private void setBatteryText(TextView txt, int value) {
        if (txt != null) {
            int value2 = value & 15;
            if (value2 >= 0 && value2 <= 5) {
                setTxt(txt, "电量:" + value2);
            } else {
                setTxt(txt, "--");
            }
        }
    }

    private void setTempText(TextView txt, int value) {
        if (txt != null) {
            if (value >= 0 && value <= 165) {
                setTxt(txt, String.valueOf(value - 40) + "℃");
            } else {
                setTxt(txt, "--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryRR(int value) {
        setBatteryText((TextView) findViewById(R.id.tv_text9), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryRL(int value) {
        setBatteryText((TextView) findViewById(R.id.tv_text6), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryFR(int value) {
        setBatteryText((TextView) findViewById(R.id.tv_text12), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryFL(int value) {
        setBatteryText((TextView) findViewById(R.id.tv_text3), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempRR(int value) {
        setTempText((TextView) findViewById(R.id.tv_text8), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempRL(int value) {
        setTempText((TextView) findViewById(R.id.tv_text5), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempFR(int value) {
        setTempText((TextView) findViewById(R.id.tv_text11), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempFL(int value) {
        setTempText((TextView) findViewById(R.id.tv_text2), value);
    }
}
