package com.syu.carinfo.ztt600;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZTTireAct_Rzc extends BaseActivity {
    AlertDialog dialog;
    private String PressUnit = "Kpa";
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.ZTTireAct_Rzc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                    ZTTireAct_Rzc.this.updaterTempFL();
                    break;
                case 3:
                    ZTTireAct_Rzc.this.updaterTempFR();
                    break;
                case 4:
                    ZTTireAct_Rzc.this.updaterTempRL();
                    break;
                case 5:
                    ZTTireAct_Rzc.this.updaterTempRR();
                    break;
                case 6:
                    ZTTireAct_Rzc.this.mUpdaterTireFL();
                    break;
                case 7:
                    ZTTireAct_Rzc.this.mUpdaterTireFR();
                    break;
                case 8:
                    ZTTireAct_Rzc.this.mUpdaterTireRL();
                    break;
                case 9:
                    ZTTireAct_Rzc.this.mUpdaterTireRR();
                    break;
                case 10:
                    ZTTireAct_Rzc.this.updaterFlTipWalm();
                    break;
                case 11:
                    ZTTireAct_Rzc.this.updaterFlLowWalm();
                    break;
                case 12:
                    ZTTireAct_Rzc.this.updaterFlHighWalm();
                    break;
                case 13:
                    ZTTireAct_Rzc.this.updaterFRTipWalm();
                    break;
                case 14:
                    ZTTireAct_Rzc.this.updaterFRHighWalm();
                    break;
                case 15:
                    ZTTireAct_Rzc.this.updaterFRlowWalm();
                    break;
                case 16:
                    ZTTireAct_Rzc.this.updaterRLTipWalm();
                    break;
                case 17:
                    ZTTireAct_Rzc.this.updaterRLLowWalm();
                    break;
                case 18:
                    ZTTireAct_Rzc.this.updaterRLHighWalm();
                    break;
                case 19:
                    ZTTireAct_Rzc.this.updaterRRTipWalm();
                    break;
                case 20:
                    ZTTireAct_Rzc.this.updaterRRLowWalm();
                    break;
                case 21:
                    ZTTireAct_Rzc.this.updaterRRHighWalm();
                    break;
                case 22:
                    ZTTireAct_Rzc.this.updaterSystemBad();
                    break;
                case 82:
                    ZTTireAct_Rzc.this.updaterFLinfo();
                    break;
                case 83:
                    ZTTireAct_Rzc.this.updaterFRinfo();
                    break;
                case 84:
                    ZTTireAct_Rzc.this.updaterRLinfo();
                    break;
                case 85:
                    ZTTireAct_Rzc.this.updaterRRinfo();
                    break;
            }
        }
    };
    ArrayList<String> strArrayWarn = new ArrayList<>();

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_zt_t600_tire);
        init();
        if (this.dialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setAdapter(new ArrayAdapter(this, R.layout.simple_textview_item, this.strArrayWarn), null);
            this.dialog = builder.create();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 393611) {
            DataCanbus.NOTIFY_EVENTS[82].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[83].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[84].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[85].addNotify(this.notifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        }
        if (DataCanbus.DATA[1000] == 1442187) {
            this.PressUnit = "Bar";
            DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 1442187) {
            DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        if (DataCanbus.DATA[1000] == 393611) {
            DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @SuppressLint({"NewApi"})
    private void showWarnDlg() {
        if (this.strArrayWarn.size() != 0) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
            attributes.height = 400;
            attributes.width = 600;
            this.dialog.getWindow().setAttributes(attributes);
            this.dialog.show();
            return;
        }
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLinfo() {
        int value = DataCanbus.DATA[82] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(setTempWalmState("fl", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRinfo() {
        int value = DataCanbus.DATA[83] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(setTempWalmState("fr", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLinfo() {
        int value = DataCanbus.DATA[84] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(setTempWalmState("rl", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRinfo() {
        int value = DataCanbus.DATA[85] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(setTempWalmState("rr", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[2];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[3];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[4];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[5];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value;
        int value2 = DataCanbus.DATA[6] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlHighWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[12];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlLowWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[11];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlTipWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[10];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value;
        int value2 = DataCanbus.DATA[7] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRHighWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[14];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRlowWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[15];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRTipWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[13];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value;
        int value2 = DataCanbus.DATA[8] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRHighWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[21];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRLowWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[20];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRTipWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[19];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value;
        int value2 = DataCanbus.DATA[9] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLHighWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[18];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLLowWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[17];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLTipWalm() {
        int system = DataCanbus.DATA[22];
        int value = DataCanbus.DATA[16];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSystemBad() {
        int value = DataCanbus.DATA[22];
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        }
    }

    private String setTempWalmState(String type, int value) {
        switch (value) {
            case 0:
                return "";
            case 1:
                String str = getString(R.string.wc_damaix5_str1);
                return str;
            case 2:
                String str2 = getString(R.string.wc_damaix5_str2);
                return str2;
            case 3:
                String str3 = getString(R.string.wc_damaix5_str3);
                return str3;
            case 4:
                String str4 = getString(R.string.wc_damaix5_str4);
                return str4;
            case 5:
                String str5 = getString(R.string.wc_damaix5_str5);
                return str5;
            case 6:
                String str6 = getString(R.string.wc_damaix5_str6);
                return str6;
            case 7:
                String str7 = getString(R.string.wc_damaix5_str7);
                return str7;
            case 8:
                String str8 = getString(R.string.wc_damaix5_str8);
                return str8;
            default:
                return "";
        }
    }
}
