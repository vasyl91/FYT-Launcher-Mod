package com.syu.carinfo.oudi.changan;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class OdChanganTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.changan.OdChanganTireAct.1
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
                case 98:
                    OdChanganTireAct.this.updaterTempFL();
                    break;
                case 99:
                    OdChanganTireAct.this.updaterTempFR();
                    break;
                case 100:
                    OdChanganTireAct.this.updaterTempRL();
                    break;
                case 101:
                    OdChanganTireAct.this.updaterTempRR();
                    break;
                case 102:
                    OdChanganTireAct.this.mUpdaterTireFL();
                    break;
                case 103:
                    OdChanganTireAct.this.mUpdaterTireFR();
                    break;
                case 104:
                    OdChanganTireAct.this.mUpdaterTireRL();
                    break;
                case 105:
                    OdChanganTireAct.this.mUpdaterTireRR();
                    break;
                case 106:
                case 107:
                case 108:
                    OdChanganTireAct.this.updaterFLWalm();
                    break;
                case 109:
                case 110:
                case 111:
                    OdChanganTireAct.this.updaterFRWalm();
                    break;
                case 112:
                case 113:
                case 114:
                    OdChanganTireAct.this.updaterRLWalm();
                    break;
                case 115:
                case 116:
                case 117:
                    OdChanganTireAct.this.updaterRRWalm();
                    break;
                case 118:
                case 119:
                case 120:
                case 125:
                case 126:
                    OdChanganTireAct.this.updaterFLWalm2();
                    break;
                case 122:
                    if (DataCanbus.DATA[122] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText("----");
                    }
                    if (DataCanbus.DATA[133] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[144] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[155] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[127] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 123:
                case 124:
                    if (DataCanbus.DATA[124] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[123] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
                    }
                    break;
                case 127:
                case 128:
                    if (DataCanbus.DATA[127] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 129:
                case 130:
                case 131:
                case 136:
                case 137:
                    OdChanganTireAct.this.updaterFRWalm2();
                    break;
                case 133:
                    if (DataCanbus.DATA[133] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[144] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[155] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[127] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 134:
                case 135:
                    if (DataCanbus.DATA[135] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[134] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
                    }
                    break;
                case 138:
                case 139:
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 140:
                case 141:
                case 142:
                case 147:
                case 148:
                    OdChanganTireAct.this.updaterRLWalm2();
                    break;
                case 144:
                    if (DataCanbus.DATA[144] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[155] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[127] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 145:
                case 146:
                    if (DataCanbus.DATA[146] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[145] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
                    }
                    break;
                case 149:
                case 150:
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 151:
                case 152:
                case 153:
                case 158:
                case 159:
                    OdChanganTireAct.this.updaterRRWalm2();
                    break;
                case 155:
                    if (DataCanbus.DATA[155] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[127] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[138] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[139] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[149] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[150] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 156:
                case 157:
                    if (DataCanbus.DATA[157] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[156] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
                    }
                    break;
                case 160:
                case 161:
                    if (DataCanbus.DATA[160] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[161] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm2() {
        int system = DataCanbus.DATA[118];
        int system1 = DataCanbus.DATA[119];
        int system2 = DataCanbus.DATA[120];
        int value = DataCanbus.DATA[125];
        int value1 = DataCanbus.DATA[126];
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
        int system = DataCanbus.DATA[129];
        int system1 = DataCanbus.DATA[130];
        int system2 = DataCanbus.DATA[131];
        int value = DataCanbus.DATA[136];
        int value1 = DataCanbus.DATA[137];
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
        int system = DataCanbus.DATA[140];
        int system1 = DataCanbus.DATA[141];
        int system2 = DataCanbus.DATA[142];
        int value = DataCanbus.DATA[147];
        int value1 = DataCanbus.DATA[148];
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
        int system = DataCanbus.DATA[151];
        int system1 = DataCanbus.DATA[152];
        int system2 = DataCanbus.DATA[153];
        int value = DataCanbus.DATA[158];
        int value1 = DataCanbus.DATA[159];
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
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[101];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            if (DataCanbus.DATA[1000] == 786871) {
                int value2 = (int) (((double) value) * 1.373d * 100.0d);
                DecimalFormat df = new DecimalFormat("#.#");
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                        break;
                }
            }
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value / 10;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            if (DataCanbus.DATA[1000] == 786871) {
                int value2 = (int) (((double) value) * 1.373d * 100.0d);
                DecimalFormat df = new DecimalFormat("#.#");
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                        break;
                }
            }
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value / 10;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            if (DataCanbus.DATA[1000] == 786871) {
                int value2 = (int) (((double) value) * 1.373d * 100.0d);
                DecimalFormat df = new DecimalFormat("#.#");
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                        break;
                }
            }
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value / 10;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            if (DataCanbus.DATA[1000] == 786871) {
                int value2 = (int) (((double) value) * 1.373d * 100.0d);
                DecimalFormat df = new DecimalFormat("#.#");
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                        break;
                }
            }
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value / 10;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[106];
        int value = DataCanbus.DATA[107];
        int value1 = DataCanbus.DATA[108];
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
        int system = DataCanbus.DATA[109];
        int value = DataCanbus.DATA[110];
        int value1 = DataCanbus.DATA[111];
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
        int system = DataCanbus.DATA[112];
        int value = DataCanbus.DATA[113];
        int value1 = DataCanbus.DATA[114];
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
        int system = DataCanbus.DATA[115];
        int value = DataCanbus.DATA[116];
        int value1 = DataCanbus.DATA[117];
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
