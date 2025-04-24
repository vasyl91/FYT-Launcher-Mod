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

@SuppressWarnings({"deprecation", "unchecked"})
public class ZTTireAct_Rzc extends BaseActivity {
    AlertDialog dialog;
    private String PressUnit = "Kpa";
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    ZTTireAct_Rzc.this.updaterTempFL();
                    break;
                case 100:
                    ZTTireAct_Rzc.this.updaterTempFR();
                    break;
                case 101:
                    ZTTireAct_Rzc.this.updaterTempRL();
                    break;
                case 102:
                    ZTTireAct_Rzc.this.updaterTempRR();
                    break;
                case 103:
                    ZTTireAct_Rzc.this.mUpdaterTireFL();
                    break;
                case 104:
                    ZTTireAct_Rzc.this.mUpdaterTireFR();
                    break;
                case 105:
                    ZTTireAct_Rzc.this.mUpdaterTireRL();
                    break;
                case 106:
                    ZTTireAct_Rzc.this.mUpdaterTireRR();
                    break;
                case 107:
                    ZTTireAct_Rzc.this.updaterFlTipWalm();
                    break;
                case 108:
                    ZTTireAct_Rzc.this.updaterFlLowWalm();
                    break;
                case 109:
                    ZTTireAct_Rzc.this.updaterFlHighWalm();
                    break;
                case 110:
                    ZTTireAct_Rzc.this.updaterFRTipWalm();
                    break;
                case 111:
                    ZTTireAct_Rzc.this.updaterFRHighWalm();
                    break;
                case 112:
                    ZTTireAct_Rzc.this.updaterFRlowWalm();
                    break;
                case 113:
                    ZTTireAct_Rzc.this.updaterRLTipWalm();
                    break;
                case 114:
                    ZTTireAct_Rzc.this.updaterRLLowWalm();
                    break;
                case 115:
                    ZTTireAct_Rzc.this.updaterRLHighWalm();
                    break;
                case 116:
                    ZTTireAct_Rzc.this.updaterRRTipWalm();
                    break;
                case 117:
                    ZTTireAct_Rzc.this.updaterRRLowWalm();
                    break;
                case 118:
                    ZTTireAct_Rzc.this.updaterRRHighWalm();
                    break;
                case 119:
                    ZTTireAct_Rzc.this.updaterSystemBad();
                    break;
                case 141:
                    ZTTireAct_Rzc.this.updaterFLinfo();
                    break;
                case 142:
                    ZTTireAct_Rzc.this.updaterFRinfo();
                    break;
                case 143:
                    ZTTireAct_Rzc.this.updaterRLinfo();
                    break;
                case 144:
                    ZTTireAct_Rzc.this.updaterRRinfo();
                    break;
            }
        }
    };
    ArrayList<String> strArrayWarn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_zt_t600_tire);
        init();
        if (this.dialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setAdapter(new ArrayAdapter(this, R.layout.simple_textview_item, this.strArrayWarn), null);
            this.dialog = builder.create();
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 393611) {
            DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        }
        if (DataCanbus.DATA[1000] == 1442187) {
            this.PressUnit = "Bar";
            DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 1442187) {
            DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        if (DataCanbus.DATA[1000] == 393611) {
            DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
    }

    @Override
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

    
    public void updaterFLinfo() {
        int value = DataCanbus.DATA[141] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(setTempWalmState("fl", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
    }

    
    public void updaterFRinfo() {
        int value = DataCanbus.DATA[142] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(setTempWalmState("fr", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
    }

    
    public void updaterRLinfo() {
        int value = DataCanbus.DATA[143] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(setTempWalmState("rl", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
    }

    
    public void updaterRRinfo() {
        int value = DataCanbus.DATA[144] & 255;
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(setTempWalmState("rr", value));
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[99];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1310985 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[100];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1310985 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[101];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1310985 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[102];
        String str = "";
        if (value == 255) {
            str = "--";
        } else if (DataCanbus.DATA[1000] != 917769 && DataCanbus.DATA[1000] != 1310985 && DataCanbus.DATA[1000] != 1048841 && DataCanbus.DATA[1000] != 1179913 && DataCanbus.DATA[1000] != 1245449) {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(str);
    }

    
    public void mUpdaterTireFL() {
        int value;
        int value2 = DataCanbus.DATA[103] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    
    public void updaterFlHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[109];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFlLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[108];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFlTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[107];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireFR() {
        int value;
        int value2 = DataCanbus.DATA[104] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    
    public void updaterFRHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[111];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFRlowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[112];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFRTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[110];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRL() {
        int value;
        int value2 = DataCanbus.DATA[105] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    
    public void updaterRRHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[118];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRRLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[117];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRRTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[116];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRR() {
        int value;
        int value2 = DataCanbus.DATA[106] & 65535;
        if (value2 == 255 || value2 == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            value = (int) (value2 * 2.75d * 100.0d);
        } else {
            value = (int) (value2 * 1.373d * 100.0d);
        }
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(df.format(value / 100.0f)) + this.PressUnit);
        }
    }

    
    public void updaterRLHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[115];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRLLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[114];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRLTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[113];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void updaterSystemBad() {
        int value = DataCanbus.DATA[119];
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
