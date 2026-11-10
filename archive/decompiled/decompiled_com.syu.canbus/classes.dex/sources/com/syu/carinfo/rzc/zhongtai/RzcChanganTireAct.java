package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcChanganTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganTireAct.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:54:0x0197  */
        /* JADX WARN: Code duplicated, block: B:57:0x01b0  */
        /* JADX WARN: Code duplicated, block: B:60:0x01c9  */
        /* JADX WARN: Code duplicated, block: B:63:0x01e2  */
        /* JADX WARN: Code duplicated, block: B:66:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:69:0x0214  */
        /* JADX WARN: Code duplicated, block: B:72:0x022d  */
        /* JADX WARN: Code duplicated, block: B:74:0x0252  */
        /* JADX WARN: Code duplicated, block: B:75:0x0264  */
        /* JADX WARN: Code duplicated, block: B:76:0x0276  */
        /* JADX WARN: Code duplicated, block: B:77:0x0288  */
        /* JADX WARN: Code duplicated, block: B:79:0x0290  */
        /* JADX WARN: Code duplicated, block: B:80:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:81:0x02b2  */
        /* JADX WARN: Code duplicated, block: B:83:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:84:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:85:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:87:0x02e4  */
        /* JADX WARN: Code duplicated, block: B:88:0x02f4  */
        /* JADX WARN: Code duplicated, block: B:89:0x0306  */
        /* JADX WARN: Code duplicated, block: B:91:0x030e  */
        /* JADX WARN: Code duplicated, block: B:92:0x031e  */
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 30:
                    RzcChanganTireAct.this.mUpdaterTireFL();
                    break;
                case 31:
                    RzcChanganTireAct.this.updaterTempFL();
                    break;
                case 32:
                case 33:
                case 34:
                case 39:
                case 40:
                    RzcChanganTireAct.this.updaterFLWalm2();
                    break;
                case 36:
                    if (DataCanbus.DATA[36] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText("----");
                    }
                    if (DataCanbus.DATA[49] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[62] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[75] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 37:
                case 38:
                    if (DataCanbus.DATA[38] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[37] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-256);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
                    }
                    break;
                case 41:
                case 42:
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 43:
                    RzcChanganTireAct.this.mUpdaterTireFR();
                    break;
                case 44:
                    RzcChanganTireAct.this.updaterTempFR();
                    break;
                case 45:
                case 46:
                case 47:
                case 52:
                case 53:
                    RzcChanganTireAct.this.updaterFRWalm2();
                    break;
                case 49:
                    if (DataCanbus.DATA[49] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[62] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[75] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 50:
                case 51:
                    if (DataCanbus.DATA[51] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[50] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-256);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
                    }
                    break;
                case 54:
                case 55:
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 56:
                    RzcChanganTireAct.this.mUpdaterTireRL();
                    break;
                case 57:
                    RzcChanganTireAct.this.updaterTempRL();
                    break;
                case 58:
                case 59:
                case 60:
                case 65:
                case 66:
                    RzcChanganTireAct.this.updaterRLWalm2();
                    break;
                case 62:
                    if (DataCanbus.DATA[62] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[75] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 63:
                case 64:
                    if (DataCanbus.DATA[64] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[63] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-256);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
                    }
                    break;
                case 67:
                case 68:
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 69:
                    RzcChanganTireAct.this.mUpdaterTireRR();
                    break;
                case 70:
                    RzcChanganTireAct.this.updaterTempRR();
                    break;
                case 71:
                case 72:
                case 73:
                case 78:
                case 79:
                    RzcChanganTireAct.this.updaterRRWalm2();
                    break;
                case 75:
                    if (DataCanbus.DATA[75] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[54] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[55] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[67] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[68] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 76:
                case 77:
                    if (DataCanbus.DATA[77] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[76] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-256);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
                    }
                    break;
                case 80:
                case 81:
                    if (DataCanbus.DATA[80] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[81] == 1) {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) RzcChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 82:
                case 83:
                case 84:
                    RzcChanganTireAct.this.updaterFLWalm();
                    break;
                case 85:
                case 86:
                case 87:
                    RzcChanganTireAct.this.updaterFRWalm();
                    break;
                case 88:
                case 89:
                case 90:
                    RzcChanganTireAct.this.updaterRLWalm();
                    break;
                case 91:
                case 92:
                case 93:
                    RzcChanganTireAct.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.sCanbusId == 2163127 || DataCanbus.sCanbusId == 2228663 || DataCanbus.sCanbusId == 2294199 || DataCanbus.sCanbusId == 2359735) {
            DataCanbus.NOTIFY_EVENTS[82].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[83].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[84].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[85].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[86].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[90].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[91].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[92].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[93].addNotify(this.notifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.notifyCanbus);
        if (DataCanbus.sCanbusId == 2163127 || DataCanbus.sCanbusId == 2228663 || DataCanbus.sCanbusId == 14614967 || DataCanbus.sCanbusId == 2294199 || DataCanbus.sCanbusId == 2359735) {
            DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm2() {
        int system = DataCanbus.DATA[32];
        int system1 = DataCanbus.DATA[33];
        int system2 = DataCanbus.DATA[34];
        int value = DataCanbus.DATA[39];
        int value1 = DataCanbus.DATA[40];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm2() {
        int system = DataCanbus.DATA[45];
        int system1 = DataCanbus.DATA[46];
        int system2 = DataCanbus.DATA[47];
        int value = DataCanbus.DATA[52];
        int value1 = DataCanbus.DATA[53];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm2() {
        int system = DataCanbus.DATA[58];
        int system1 = DataCanbus.DATA[59];
        int system2 = DataCanbus.DATA[60];
        int value = DataCanbus.DATA[65];
        int value1 = DataCanbus.DATA[66];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm2() {
        int system = DataCanbus.DATA[71];
        int system1 = DataCanbus.DATA[72];
        int system2 = DataCanbus.DATA[73];
        int value = DataCanbus.DATA[78];
        int value1 = DataCanbus.DATA[79];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[31];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[44];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[57];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[70];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[30];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 3539396) {
            if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
            }
        } else {
            int value2 = value * 1373;
            if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 1000) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[43];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 3539396) {
            if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
            }
        } else {
            int value2 = value * 1373;
            if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 1000) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[56];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 3539396) {
            if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
            }
        } else {
            int value2 = value * 1373;
            if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 1000) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[69];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (DataCanbus.DATA[1000] == 3539396) {
            if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
            }
        } else {
            int value2 = value * 1373;
            if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 1000) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[82];
        int value = DataCanbus.DATA[83];
        int value1 = DataCanbus.DATA[84];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[85];
        int value = DataCanbus.DATA[86];
        int value1 = DataCanbus.DATA[87];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[88];
        int value = DataCanbus.DATA[89];
        int value1 = DataCanbus.DATA[90];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[91];
        int value = DataCanbus.DATA[92];
        int value1 = DataCanbus.DATA[93];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }
}
