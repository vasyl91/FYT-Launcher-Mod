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
public class ZTTireAct_Wc extends BaseActivity {
    AlertDialog dialog;
    private String PressUnit = "Bar";
    private String TempUnit = "℃";
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.ZTTireAct_Wc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 1442187) {
                switch (updateCode) {
                    case 10:
                    case 13:
                    case 16:
                    case 19:
                        ZTTireAct_Wc.this.updateTireWarns(DataCanbus.DATA[updateCode] & 255);
                        break;
                    case 22:
                        ZTTireAct_Wc.this.updateTireState(DataCanbus.DATA[updateCode]);
                        break;
                }
            }
            switch (updateCode) {
                case 2:
                    ZTTireAct_Wc.this.updaterTempFL();
                    break;
                case 3:
                    ZTTireAct_Wc.this.updaterTempFR();
                    break;
                case 4:
                    ZTTireAct_Wc.this.updaterTempRL();
                    break;
                case 5:
                    ZTTireAct_Wc.this.updaterTempRR();
                    break;
                case 6:
                    ZTTireAct_Wc.this.mUpdaterTireFL();
                    break;
                case 7:
                    ZTTireAct_Wc.this.mUpdaterTireFR();
                    break;
                case 8:
                    ZTTireAct_Wc.this.mUpdaterTireRL();
                    break;
                case 9:
                    ZTTireAct_Wc.this.mUpdaterTireRR();
                    break;
                case 10:
                    ZTTireAct_Wc.this.updaterFlTipWalm();
                    break;
                case 11:
                    ZTTireAct_Wc.this.updaterFlLowWalm();
                    break;
                case 12:
                    ZTTireAct_Wc.this.updaterFlHighWalm();
                    break;
                case 13:
                    ZTTireAct_Wc.this.updaterFRTipWalm();
                    break;
                case 14:
                    ZTTireAct_Wc.this.updaterFRHighWalm();
                    break;
                case 15:
                    ZTTireAct_Wc.this.updaterFRlowWalm();
                    break;
                case 16:
                    ZTTireAct_Wc.this.updaterRLTipWalm();
                    break;
                case 17:
                    ZTTireAct_Wc.this.updaterRLLowWalm();
                    break;
                case 18:
                    ZTTireAct_Wc.this.updaterRLHighWalm();
                    break;
                case 19:
                    ZTTireAct_Wc.this.updaterRRTipWalm();
                    break;
                case 20:
                    ZTTireAct_Wc.this.updaterRRLowWalm();
                    break;
                case 21:
                    ZTTireAct_Wc.this.updaterRRHighWalm();
                    break;
                case 22:
                    ZTTireAct_Wc.this.updaterSystemBad();
                    break;
                case 82:
                    ZTTireAct_Wc.this.updaterFLinfo();
                    break;
                case 83:
                    ZTTireAct_Wc.this.updaterFRinfo();
                    break;
                case 84:
                    ZTTireAct_Wc.this.updaterRLinfo();
                    break;
                case 85:
                    ZTTireAct_Wc.this.updaterRRinfo();
                    break;
            }
        }
    };
    private int[] resIdTireState = {R.string.str_wc_rfs2_1, R.string.str_wc_rfs2_2, R.string.str_wc_rfs2_3};
    private int[] resIdTireWarn = {R.string.str_wc_rfs2_4, R.string.str_wc_rfs2_5, R.string.str_wc_rfs2_6, R.string.str_wc_rfs2_7, R.string.str_wc_rfs2_8, R.string.str_wc_rfs2_9, R.string.str_wc_rfs2_10, R.string.str_wc_rfs2_11};
    private int[] resIdTirePosition = {R.string.str_wc_rfs2_12, R.string.str_wc_rfs2_13, R.string.str_wc_rfs2_14, R.string.str_wc_rfs2_15};
    private int[] resIdTire_Update = {10, 13, 16, 19};
    ArrayList<String> strArrayWarn = new ArrayList<>();

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_zt_t600_tire);
        init();
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931) {
            this.PressUnit = "Kpa";
        }
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931 || DataCanbus.DATA[1000] == 131467 || DataCanbus.DATA[1000] == 262539) {
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931 || DataCanbus.DATA[1000] == 131467 || DataCanbus.DATA[1000] == 262539) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireState(int i) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_state)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_state)).setText("");
            for (int j = 0; j < this.resIdTireState.length; j++) {
                int d = (i >> (2 - j)) & 1;
                if (d != 0) {
                    ((TextView) findViewById(R.id.zt_tv_car_tire_state)).setText(this.resIdTireState[j]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireWarns(int i) {
        this.strArrayWarn.clear();
        int index = 0;
        for (int n = 0; n < this.resIdTire_Update.length; n++) {
            int data = DataCanbus.DATA[this.resIdTire_Update[n]] & 255;
            for (int j = 7; j >= 0; j--) {
                int pos = (data >> j) & 1;
                String str = getString(this.resIdTireWarn[7 - j], new Object[]{getString(this.resIdTirePosition[n])});
                if (pos == 1) {
                    if (!this.strArrayWarn.contains(str)) {
                        index++;
                        this.strArrayWarn.add(String.valueOf(index) + " . " + str);
                    }
                } else {
                    this.strArrayWarn.remove(str);
                }
            }
        }
        showWarnDlg();
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
        String str;
        int value = DataCanbus.DATA[2];
        if (DataCanbus.DATA[1000] == 393611) {
            if (value == 65535) {
                str = "--";
            } else {
                str = String.valueOf(value - 40) + this.TempUnit;
            }
        } else if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value) + this.TempUnit;
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        String str;
        int value = DataCanbus.DATA[3];
        if (DataCanbus.DATA[1000] == 393611) {
            if (value == 65535) {
                str = "--";
            } else {
                str = String.valueOf(value - 40) + this.TempUnit;
            }
        } else if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value) + this.TempUnit;
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        String str;
        int value = DataCanbus.DATA[4];
        if (DataCanbus.DATA[1000] == 393611) {
            if (value == 65535) {
                str = "--";
            } else {
                str = String.valueOf(value - 40) + this.TempUnit;
            }
        } else if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value) + this.TempUnit;
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        String str;
        int value = DataCanbus.DATA[5];
        if (DataCanbus.DATA[1000] == 393611) {
            if (value == 65535) {
                str = "--";
            } else {
                str = String.valueOf(value - 40) + this.TempUnit;
            }
        } else if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value) + this.TempUnit;
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931) {
            value = value2 * 100;
        } else {
            value = value2 * 10;
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931) {
            value = value2 * 100;
        } else {
            value = value2 * 10;
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931) {
            value = value2 * 100;
        } else {
            value = value2 * 10;
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        } else if (value == 0) {
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
        if (DataCanbus.DATA[1000] == 393611 || DataCanbus.DATA[1000] == 65931) {
            value = value2 * 100;
        } else {
            value = value2 * 10;
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
